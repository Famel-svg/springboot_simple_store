# ─────────────────────────────────────────────
# Stage 1 — Build
# ─────────────────────────────────────────────
FROM maven:3.9.12-eclipse-temurin-21 AS builder

# Java 25 ainda não tem imagem oficial Maven; usamos 21 LTS para build
# Se quiser forçar Java 25, substitua a imagem base por uma que contenha o JDK 25
WORKDIR /app

# Copia somente os arquivos de dependências primeiro (cache layer)
COPY pom.xml .
COPY .mvn .mvn
COPY mvnw .
RUN chmod +x mvnw

# Baixa dependências sem compilar o código (otimiza cache do Docker)
RUN ./mvnw dependency:go-offline -B

# Copia o código-fonte e compila, pulando os testes
COPY src ./src
RUN ./mvnw clean package -DskipTests -B

# ─────────────────────────────────────────────
# Stage 2 — Runtime
# ─────────────────────────────────────────────
FROM eclipse-temurin:21-jre-alpine AS runtime

# Metadados
LABEL maintainer="Famel <famel@famel.com.br>"
LABEL description="springboot_simple_store — API RESTful de loja simples"

# Usuário não-root (boa prática de segurança)
RUN addgroup -S appgroup && adduser -S appuser -G appgroup
USER appuser

WORKDIR /app

# Copia apenas o JAR gerado no stage anterior
COPY --from=builder /app/target/*.jar app.jar

# Porta padrão do perfil dev/prod
EXPOSE 8080

# Variáveis de ambiente com valores padrão (sobrescritas pelo Compose)
ENV SPRING_PROFILES_ACTIVE=dev \
    JAVA_OPTS="-XX:+UseContainerSupport -XX:MaxRAMPercentage=75.0"

ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]