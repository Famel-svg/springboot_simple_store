# springboot_simple_store

<div align="center">
  <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white"/>
  <img src="https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white"/>
  <img src="https://img.shields.io/badge/Spring_Boot-F2F4F9?style=for-the-badge&logo=spring-boot&logoColor=white"/>
  <img src="https://img.shields.io/badge/JPA-000000?style=for-the-badge&logo=hibernate&logoColor=white"/>
  <img src="https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white"/>
  <img src="https://img.shields.io/badge/H2_Database-4479A1?style=for-the-badge&logo=h2&logoColor=white"/>
  <img src="https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white"/>
  <img src="https://img.shields.io/badge/REST_API-005C9C?style=for-the-badge&logo=rest&logoColor=white"/>
</div>

---

## ✨ Sobre o Projeto

Um projeto de exemplo de uma loja simples construída com **Spring Boot**, utilizando **JPA** para persistência de dados e um banco de dados **H2 em memória** para desenvolvimento e testes, com suporte a **PostgreSQL** para produção. Este projeto demonstra a criação de uma **API RESTful** completa para gerenciamento de usuários, pedidos, categorias e produtos.

---

## 🚀 Tecnologias Utilizadas

Este projeto faz uso das seguintes tecnologias e frameworks:

*   **Java 25**: Linguagem de programação moderna e robusta.
*   **Spring Boot 4.0.2**: Framework líder para desenvolvimento de aplicações Java, focado em microserviços.
*   **Spring Data JPA**: Abstração para facilitar a interação com bancos de dados relacionais, utilizando o padrão JPA.
*   **Maven**: Ferramenta poderosa para automação de build e gerenciamento de dependências do projeto.
*   **H2 Database**: Banco de dados relacional em memória, ideal para desenvolvimento e testes rápidos.
*   **PostgreSQL**: Sistema de gerenciamento de banco de dados objeto-relacional de código aberto, robusto e escalável, para ambiente de produção.
*   **RESTful API**: Arquitetura para construção de serviços web escaláveis e stateless.

---

## 📁 Estrutura do Projeto

A estrutura do projeto segue o padrão de aplicações Spring Boot, com pacotes bem definidos para cada camada da aplicação, promovendo a separação de responsabilidades e a manutenibilidade do código:

```
springboot_simple_store
├── src
│   ├── main
│   │   ├── java
│   │   │   └── br
│   │   │       └── com
│   │   │           └── famel
│   │   │               └── springboot_simple_store
│   │   │                   ├── config             # Classes de configuração da aplicação
│   │   │                   │   └── TestConfig.java
│   │   │                   ├── entities           # Entidades de domínio (modelos de dados)
│   │   │                   │   ├── Category.java
│   │   │                   │   ├── Order.java
│   │   │                   │   ├── OrderItem.java
│   │   │                   │   ├── OrderStatus.java
│   │   │                   │   ├── Payment.java
│   │   │                   │   ├── Product.java
│   │   │                   │   ├── User.java
│   │   │                   │   └── pk             # Chaves primárias compostas
│   │   │                   │       └── OrderItemPK.java
│   │   │                   ├── repositories       # Interfaces para acesso a dados (Spring Data JPA)
│   │   │                   │   ├── CategoryRepository.java
│   │   │                   │   ├── OrderItemRepository.java
│   │   │                   │   ├── OrderRepository.java
│   │   │                   │   ├── ProductRepository.java
│   │   │                   │   └── UserRepository.java
│   │   │                   ├── resources          # Controladores REST (endpoints da API)
│   │   │                   │   ├── CategoryResource.java
│   │   │                   │   ├── OrderResource.java
│   │   │                   │   ├── ProductResource.java
│   │   │                   │   ├── UserResource.java
│   │   │                   │   └── exceptions     # Classes para tratamento de exceções da API
│   │   │                   │       ├── ResourceExceptionHandler.java
│   │   │                   │       └── StandardError.java
│   │   │                   ├── service            # Camada de serviço (lógica de negócio)
│   │   │                   │   ├── CategoryService.java
│   │   │                   │   ├── OrderService.java
│   │   │                   │   ├── ProductService.java
│   │   │                   │   └── UserService.java
│   │   │                   │   └── exceptions     # Classes para tratamento de exceções de serviço
│   │   │                   │       ├── DatabaseException.java
│   │   │                   │       └── ResourceNotFoundException.java
│   │   │                   └── SpringbootSimpleStoreApplication.java # Classe principal da aplicação
│   │   └── resources
│   │       └── application.properties # Arquivo de propriedades da aplicação
│   └── test
│       └── java
│           └── br
│               └── com
│                   └── famel
│                       └── springboot_simple_store
│                           └── SpringbootSimpleStoreApplicationTests.java # Testes da aplicação
├── pom.xml # Arquivo de configuração do Maven
├── SimpleStoreScript.sql # Script SQL para criação e população do banco de dados
└── mvnw # Wrapper Maven para execução em diferentes ambientes
└── mvnw.cmd # Wrapper Maven para Windows
```

---

## 📊 Entidades do Domínio

O projeto possui as seguintes entidades de domínio, que representam os principais objetos de negócio da aplicação e seus relacionamentos:

*   **User**: Representa um usuário do sistema, com atributos como `id`, `name`, `email`, `phone` e `password`.
*   **Order**: Representa um pedido realizado por um usuário, contendo `id`, `moment` (data e hora do pedido), `orderStatus` (status atual do pedido) e associações com `User` (muitos para um) e `Payment` (um para um).
*   **Category**: Representa uma categoria de produto, com `id` e `name`. Um produto pode pertencer a várias categorias (muitos para muitos).
*   **Product**: Representa um produto disponível na loja, com `id`, `name`, `description`, `price` e `imgUrl`. Possui associação com `Category` (muitos para muitos).
*   **OrderItem**: Representa um item específico dentro de um pedido. Utiliza uma chave composta (`OrderItemPK`) para mapear a relação entre `Order` e `Product`, além de armazenar a `quantity` (quantidade) e o `price` (preço unitário no momento do pedido).
*   **Payment**: Representa o pagamento associado a um pedido, com `id`, `moment` (data e hora do pagamento) e associação com `Order` (um para um).

---

## 📦 Como Rodar o Projeto

Para configurar e executar este projeto localmente, siga os passos abaixo:

### Pré-requisitos

Certifique-se de ter o seguinte software instalado em sua máquina:

*   **Java Development Kit (JDK) 25** ou superior.
*   **Maven 3.x** ou superior.
*   **Git**.

### Configuração

1.  **Clone o repositório:**

    ```bash
    git clone https://github.com/Famel-svg/springboot_simple_store.git
    cd springboot_simple_store
    ```

2.  **Configure o banco de dados (opcional, para PostgreSQL):**

    Por padrão, o projeto utiliza o banco de dados **H2 em memória**, que é automaticamente configurado. Se desejar usar **PostgreSQL**, configure as propriedades de conexão no arquivo `src/main/resources/application.properties`:

    ```properties
    spring.datasource.url=jdbc:postgresql://localhost:5432/your_database_name
    spring.datasource.username=your_username
    spring.datasource.password=your_password
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation=true
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
    ```

    Certifique-se de criar o banco de dados `your_database_name` no PostgreSQL e ajustar as credenciais conforme necessário.

3.  **Execute o script SQL (opcional):**

    O arquivo `SimpleStoreScript.sql` contém o esquema do banco de dados e dados de exemplo. Você pode executá-lo em seu banco de dados PostgreSQL ou H2 para popular as tabelas e ter dados para testar a aplicação.

### Execução

Para iniciar a aplicação, execute o seguinte comando na raiz do projeto:

```bash
mvn spring-boot:run
```

Ou, se preferir, compile e execute o JAR:

```bash
mvn clean install
java -jar target/springboot_simple_store-0.0.1-SNAPSHOT.jar
```

A aplicação estará disponível em `http://localhost:8080`.

---

## 🌐 Endpoints da API

Os principais endpoints da **API RESTful** são:

*   **Usuários (`/users`)**
    *   `GET /users`: Lista todos os usuários cadastrados.
    *   `GET /users/{id}`: Busca um usuário específico pelo seu ID.
    *   `POST /users`: Cria um novo usuário (requer corpo da requisição com dados do usuário).
    *   `PUT /users/{id}`: Atualiza os dados de um usuário existente pelo seu ID.
    *   `DELETE /users/{id}`: Deleta um usuário pelo seu ID.

*   **Pedidos (`/orders`)**
    *   `GET /orders`: Lista todos os pedidos realizados.
    *   `GET /orders/{id}`: Busca um pedido específico pelo seu ID.

*   **Categorias (`/categories`)**
    *   `GET /categories`: Lista todas as categorias de produtos.
    *   `GET /categories/{id}`: Busca uma categoria específica pelo seu ID.

*   **Produtos (`/products`)**
    *   `GET /products`: Lista todos os produtos disponíveis.
    *   `GET /products/{id}`: Busca um produto específico pelo seu ID.

---

## 🖥️ Banco de Dados H2 Console

Se estiver utilizando o **H2 Database** para desenvolvimento, você pode acessar a interface web do console H2 para visualizar e gerenciar o banco de dados em `http://localhost:8080/h2-console`.

*   **JDBC URL**: `jdbc:h2:mem:testdb` (ou o valor configurado em `application.properties`)
*   **User Name**: `sa`
*   **Password**: (deixe em branco)

---

## 🤝 Contribuição

Contribuições são muito bem-vindas! Se você tiver sugestões, melhorias ou encontrar algum bug, sinta-se à vontade para abrir **issues** e enviar **pull requests**.

---

## 📝 Licença

Este projeto está licenciado sob a licença **MIT**. Para mais detalhes, consulte o arquivo `LICENSE` na raiz do repositório.

---

<div align="center">
  <strong>Desenvolvido por Famel-svg 🚀</strong>
</div>
