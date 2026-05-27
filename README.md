# Pipeline Monitor Backend

This project is a backend application developed using Spring Boot for monitoring DevOps pipelines and build processes. It provides secure REST APIs with JWT-based authentication and role-based authorization.

## Features

- User Registration and Login
- JWT Authentication
- Role-Based Access Control
- Pipeline Management APIs
- Build Management and Status Tracking
- Swagger API Documentation
- Validation and Exception Handling
- MySQL Database Integration

## Tech Stack

- Java
- Spring Boot
- Spring Security
- JWT
- MySQL
- Maven
- Swagger/OpenAPI

## API Endpoints

### Authentication

- `POST /api/auth/register`
- `POST /api/auth/login`

### Pipelines

- `GET /api/pipelines`
- `POST /api/pipelines`

### Builds

- `POST /api/builds/{pipelineId}`
- `PUT /api/builds/{buildId}/status`

## Swagger Documentation

After running the project, Swagger UI can be accessed at:

```bash
http://localhost:8081/swagger-ui/index.html
```

## Running the Project

Clone the repository:

```bash
git clone https://github.com/ASRITHAPUCHAKAYALA/pipeline-monitor-backend.git
```

Move into the project folder:

```bash
cd pipeline-monitor-backend
```

Run the application:

```bash
mvn spring-boot:run
```

## Project Structure

```bash
src/main/java/pipeline_monitor
│
├── controller
├── service
├── repository
├── entity
├── dto
├── security
├── config
└── exception
```

## Author

Asritha Puchakayala  
GitHub: https://github.com/ASRITHAPUCHAKAYALA
