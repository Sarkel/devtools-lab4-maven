# Lab6 Maven Project - School Helper Application

This repository contains the **Lab6 Maven Project**, a Spring Boot-based Java application designed to provide a foundation for developing a school management or helper app. It leverages several cutting-edge technologies and libraries to ensure maintainability, scalability, and ease of use.

## Features

- **Spring Boot Integration**: Simplifies the development process and provides robust configuration management.
- **JavaFX Controls and FXML**: Combines desktop UI components with declarative user interface definition.
- **Spring Data JPA**: Simplifies database interaction with PostgreSQL using ORM.
- **Lombok Integration**: Reduces boilerplate code for model and utility classes.
- **MapStruct**: Handles object mapping between DTOs and entity classes.
- **Flyway**: Database versioning and migrations for smooth DB schema evolution.
- **JUnit 5**: Provides a robust framework for writing and running unit tests.
- **PostgreSQL Support**: Reliable, robust, and scalable database integration.

---

## Requirements

To build and run this application, ensure the following are installed:

- **Java JDK**: Version 21.
- **Apache Maven**: Version 3.6 or higher.
- **Docker and Docker Compose**: For running PostgreSQL in a container.
- **PostgreSQL Database**: Alternatively, you can run a local instance if Docker isn't available.

---

## Technologies Used

The following dependencies and plugins are configured in the `pom.xml`:

### Dependencies

1. **JavaFX** (`javafx-controls` and `javafx-fxml` - v21)
2. **Spring Boot**:
   - `spring-boot-starter`
   - `spring-boot-starter-data-jpa`
   - `spring-boot-starter-validation`
3. **Database**:
   - PostgreSQL Driver (`postgresql` - v42.7.4)
   - Flyway Migration (`flyway-database-postgresql` - v10.14.0)
4. **Mapping & Validation**:
   - Lombok (`lombok` - v1.18.30)
   - MapStruct (`mapstruct` - v1.5.5.Final)
5. **Testing**:
   - JUnit 5 (`junit-jupiter-api` and `junit-jupiter-engine` - v5.10.2)

### Plugins

1. **Maven Compiler Plugin**:
   - Targets Java 21 for both source and target compatibility.
   - Configured for annotation processors like Lombok and MapStruct.
2. **Exec-Maven-Plugin**:
   - To execute the main class.
3. **Spring Boot Maven Plugin**:
   - To build and run Spring Boot applications easily.

---

## How to Run PostgreSQL Using Docker Compose

The project is set up to use PostgreSQL for its database needs. You can run PostgreSQL as a Docker container using the provided `docker-compose.yml` file.

### 1. Prerequisites
Ensure you have Docker and Docker Compose installed on your system.

### 2. Start the PostgreSQL Container
From the root directory of the project (where the `docker-compose.yml` file is located), run the following command to start the PostgreSQL container:

```bash
docker-compose up -d
```

This will:
- Pull the `postgres:16-alpine` image (if not already available locally).
- Start a container named `lab6_maven`.
- Map the PostgreSQL port to the host's `5432` port.
- Create a database named `lab6_maven` with the user/password `lab6_maven`.

### 3. Stopping the Container
To stop the container when you're done, use:
```bash
docker-compose down
```

---

## How to Run the Application

### 1. Clone the Repository
```bash
git clone https://github.com/Sarkel/devtools-lab4-maven
cd lab6_maven
```

### 2. Build the Project
Run the Maven build command:
```bash
mvn clean install
```

This will compile the code, process dependencies, and run unit tests.

### 3. Configure Database
The application is set to connect to the PostgreSQL instance as defined in `docker-compose.yml`. The default configuration is:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/lab6_maven
spring.datasource.username=lab6_maven
spring.datasource.password=lab6_maven
spring.jpa.hibernate.ddl-auto=update
```

If you need to adjust these settings, you can modify the `application.properties` or `application.yml` file.

### 4. Run the Application
To start the application, you can use:

#### Via Maven:
```bash
mvn java:exec
```

---

## Testing

The project contains unit tests written using JUnit 5. To run tests, use:
```bash
mvn test
```
