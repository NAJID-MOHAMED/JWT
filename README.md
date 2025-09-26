# Demo JWT Spring Boot Application

This is a demo project that demonstrates how to use JWT (JSON Web Token) for authentication in a Spring Boot application.

[![Java Version](https://img.shields.io/badge/Java-21-blue.svg)](https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html)
[![Spring Boot Version](https://img.shields.io/badge/Spring%20Boot-3.5.5-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![License](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

## Features

*   User and Role management.
*   Secure API endpoints using JWT.
*   In-memory H2 database.
*   Token generation and validation.

## Technologies Used


*   **Backend:**
    *   [Spring Boot](https://spring.io/projects/spring-boot) - Framework for building Java-based enterprise applications.
    *   [Spring Security](https://spring.io/projects/spring-security) - For authentication and access control.
    *   [Spring Data JPA](https://spring.io/projects/spring-data-jpa) - For data access.
    *   [H2 Database](https://www.h2database.com/html/main.html) - In-memory database.
    *   [java-jwt](https://github.com/auth0/java-jwt) - For JWT creation and verification.
    *   [Lombok](https://projectlombok.org/) - To reduce boilerplate code.
*   **Build Tool:**
    *   [Maven](https://maven.apache.org/) - Dependency management.

## Prerequisites

Before you begin, ensure you have the following installed:

*   [JDK 21](https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html)
*   [Maven](https://maven.apache.org/download.cgi)

## Installation and Setup

1.  **Clone the repository:**

    ```bash
    git clone https://github.com/your-username/demoJWTSpringBoot.git
    cd demoJWTSpringBoot
    ```

2.  **Run the application:**

    ```bash
    ./mvnw spring-boot:run
    ```

The application will start on `http://localhost:8080`.

## API Endpoints

The following endpoints are available:

| Method | Endpoint         | Description        |
| ------ | ---------------- | ------------------ |
| `GET`  | `/users`         | Get all users      |
| `POST` | `/user`          | Add a new user     |
| `POST` | `/role`          | Add a new role     |
| `POST` | `/addRoleToUser` | Add a role to a user |

### `POST /user`

**Request Body:**

```json
{
  "username": "testuser",
  "password": "password"
}
```

### `POST /role`

**Request Body:**

```json
{
  "rolename": "USER"
}
```

### `POST /addRoleToUser`

**Request Body:**

```json
{
  "username": "testuser",
  "rolename": "USER"
}
```

## Security

This application uses JWT for securing the API endpoints. When a user authenticates, a JWT is generated and returned to the client. The client then includes this token in the `Authorization` header of subsequent requests to access protected resources.

The JWT is generated using the `java-jwt` library and is signed with a secret key. The `JwtAuthenticationFilter` intercepts incoming requests, validates the JWT, and sets the authentication context.

## How to Contribute

Contributions are welcome! Please follow these steps:

1.  Fork the repository.
2.  Create a new branch (`git checkout -b feature/your-feature`).
3.  Make your changes.
4.  Commit your changes (`git commit -m 'Add some feature'`).
5.  Push to the branch (`git push origin feature/your-feature`).
6.  Open a pull request.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
