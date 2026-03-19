# springboot_simple_store

Um projeto de exemplo de uma loja simples construída com Spring Boot, utilizando JPA para persistência de dados e um banco de dados H2 em memória para desenvolvimento e testes, com suporte a PostgreSQL para produção.

## Tecnologias Utilizadas

Este projeto faz uso das seguintes tecnologias e frameworks:

*   **Java 25**: Linguagem de programação.
*   **Spring Boot 4.0.2**: Framework para facilitar o desenvolvimento de aplicações Java.
*   **Spring Data JPA**: Para persistência de dados e interação com o banco de dados.
*   **Maven**: Ferramenta de automação de build e gerenciamento de dependências.
*   **H2 Database**: Banco de dados em memória para desenvolvimento e testes.
*   **PostgreSQL**: Banco de dados relacional para ambiente de produção.
*   **RESTful API**: Arquitetura para construção de serviços web.

## Estrutura do Projeto

A estrutura do projeto segue o padrão de aplicações Spring Boot, com pacotes bem definidos para cada camada da aplicação:

```
springboot_simple_store
├── src
│   ├── main
│   │   ├── java
│   │   │   └── br
│   │   │       └── com
│   │   │           └── famel
│   │   │               └── springboot_simple_store
│   │   │                   ├── config
│   │   │                   │   └── TestConfig.java
│   │   │                   ├── entities
│   │   │                   │   ├── Category.java
│   │   │                   │   ├── Order.java
│   │   │                   │   ├── OrderItem.java
│   │   │                   │   ├── OrderStatus.java
│   │   │                   │   ├── Payment.java
│   │   │                   │   ├── Product.java
│   │   │                   │   ├── User.java
│   │   │                   │   └── pk
│   │   │                   │       └── OrderItemPK.java
│   │   │                   ├── repositories
│   │   │                   │   ├── CategoryRepository.java
│   │   │                   │   ├── OrderItemRepository.java
│   │   │                   │   ├── OrderRepository.java
│   │   │                   │   ├── ProductRepository.java
│   │   │                   │   └── UserRepository.java
│   │   │                   ├── resources
│   │   │                   │   ├── CategoryResource.java
│   │   │                   │   ├── OrderResource.java
│   │   │                   │   ├── ProductResource.java
│   │   │                   │   ├── UserResource.java
│   │   │                   │   └── exceptions
│   │   │                   │       ├── ResourceExceptionHandler.java
│   │   │                   │       └── StandardError.java
│   │   │                   ├── service
│   │   │                   │   ├── CategoryService.java
│   │   │                   │   ├── OrderService.java
│   │   │                   │   ├── ProductService.java
│   │   │                   │   └── UserService.java
│   │   │                   │   └── exceptions
│   │   │                   │       ├── DatabaseException.java
│   │   │                   │       └── ResourceNotFoundException.java
│   │   │                   └── SpringbootSimpleStoreApplication.java
│   │   └── resources
│   │       └── application.properties
│   └── test
│       └── java
│           └── br
│               └── com
│                   └── famel
│                       └── springboot_simple_store
│                           └── SpringbootSimpleStoreApplicationTests.java
├── pom.xml
├── SimpleStoreScript.sql
└── mvnw
└── mvnw.cmd
```

## Entidades

O projeto possui as seguintes entidades de domínio:

*   **User**: Representa um usuário do sistema, com `id`, `name`, `email`, `phone` e `password`.
*   **Order**: Representa um pedido, contendo `id`, `moment` (data e hora do pedido), `orderStatus` (status do pedido) e associação com `User` e `Payment`.
*   **Category**: Representa uma categoria de produto, com `id` e `name`.
*   **Product**: Representa um produto, com `id`, `name`, `description`, `price` e `imgUrl`, associado a `Category`.
*   **OrderItem**: Representa um item de pedido, com uma chave composta (`OrderItemPK`) para `Order` e `Product`, além de `quantity` e `price`.
*   **Payment**: Representa o pagamento de um pedido, com `id`, `moment` e associação com `Order`.

## Como Rodar o Projeto

Para configurar e executar este projeto localmente, siga os passos abaixo:

### Pré-requisitos

Certifique-se de ter o seguinte software instalado em sua máquina:

*   Java Development Kit (JDK) 25 ou superior.
*   Maven 3.x ou superior.
*   Git.

### Configuração

1.  **Clone o repositório:**

    ```bash
    git clone https://github.com/Famel-svg/springboot_simple_store.git
    cd springboot_simple_store
    ```

2.  **Configure o banco de dados (opcional, para PostgreSQL):**

    Por padrão, o projeto utiliza o banco de dados H2 em memória. Se desejar usar PostgreSQL, configure as propriedades de conexão no arquivo `src/main/resources/application.properties`:

    ```properties
    spring.datasource.url=jdbc:postgresql://localhost:5432/your_database_name
    spring.datasource.username=your_username
    spring.datasource.password=your_password
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation=true
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
    ```

    Certifique-se de criar o banco de dados `your_database_name` no PostgreSQL e ajustar as credenciais.

3.  **Execute o script SQL (opcional):**

    O arquivo `SimpleStoreScript.sql` contém o esquema do banco de dados e dados de exemplo. Você pode executá-lo em seu banco de dados PostgreSQL ou H2 para popular as tabelas.

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

## Endpoints da API

Os principais endpoints da API RESTful são:

*   **Usuários**
    *   `GET /users`: Lista todos os usuários.
    *   `GET /users/{id}`: Busca um usuário por ID.
    *   `POST /users`: Cria um novo usuário.
    *   `PUT /users/{id}`: Atualiza um usuário existente.
    *   `DELETE /users/{id}`: Deleta um usuário.

*   **Pedidos**
    *   `GET /orders`: Lista todos os pedidos.
    *   `GET /orders/{id}`: Busca um pedido por ID.

*   **Categorias**
    *   `GET /categories`: Lista todas as categorias.
    *   `GET /categories/{id}`: Busca uma categoria por ID.

*   **Produtos**
    *   `GET /products`: Lista todos os produtos.
    *   `GET /products/{id}`: Busca um produto por ID.

## Banco de Dados H2 Console

Se estiver utilizando o H2 Database, você pode acessar o console do H2 em `http://localhost:8080/h2-console`.

*   **JDBC URL**: `jdbc:h2:mem:testdb` (ou o valor configurado em `application.properties`)
*   **User Name**: `sa`
*   **Password**: (deixe em branco)

## Contribuição

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues e pull requests.

## Licença

Este projeto está licenciado sob a licença MIT. Veja o arquivo `LICENSE` para mais detalhes. (Assumindo licença MIT, caso contrário, ajustar.)
