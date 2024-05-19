# Gym Management System

A Gym Management System built using Spring Boot with an H2 in-memory database, designed to manage a gym, including member registration, instructor management, class scheduling, and more.

## Features

- **Member Management**: Add, update, delete, and view members.
- **Instructor Management**: Add, update, delete, and view instructors.
- **Class Scheduling**: Schedule, update, and manage gym classes.
- **API Documentation**: Integrated Swagger UI for API documentation and testing.

## Technologies Used

- **Java 17**
- **Spring Boot 3.2.5**
- **Spring Data JPA**
- **Hibernate**
- **H2 Database** (in-memory)
- **Spring Security**
- **Swagger/OpenAPI 3**
- **Maven**

## Getting Started

### Prerequisites

- Java 17 or higher
- Maven 3.6 or higher
- Git

### Installation

1. **Clone the repository:**

    ```sh
    git clone https://github.com/your-username/gym-management-system.git
    cd gym-management-system
    ```

2. **Build the project:**

    ```sh
    mvn clean install
    ```

3. **Run the application:**

    ```sh
    mvn spring-boot:run
    ```

    The application should now be running at `http://localhost:8080`.

### Configuration

The application uses an H2 in-memory database by default, with no additional configuration required. You can access the H2 console at `http://localhost:8080/h2-console` (JDBC URL: `jdbc:h2:mem:db_gymmanager`, username: `sa`, password: ``).

## API Documentation

Swagger UI is integrated for API documentation. Once the application is running, you can access it at:
`http://localhost:8080/swagger-ui.html`
