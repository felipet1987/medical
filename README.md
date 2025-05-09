# Medical Management System

This is a Java-based medical management system designed to handle appointments, patients, doctors, and specialties. The project uses Spring Boot and follows a layered architecture with clear separation between controllers, services, ports, and repositories.

## Features
- Manage appointments, patients, doctors, and specialties
- RESTful API endpoints
- Unit tests for core services and controllers
- Exception handling with a global exception handler

## Getting Started

### Prerequisites
- Java 17+
- Gradle

### Running the Application
```
gradle bootRun
```

### Running Tests
```
gradle test
```

## Project Structure
- `src/main/java/cl/talavera/medical/adapter/controller` - REST controllers
- `src/main/java/cl/talavera/medical/core/service` - Business logic/services
- `src/main/java/cl/talavera/medical/core/port` - Service ports/interfaces
- `src/main/java/cl/talavera/medical/adapter/repository` - Data repositories and DAOs
- `src/main/java/cl/talavera/medical/mapper` - DTO/entity mappers
- `src/test/java` - Unit and integration tests

## License
MIT
