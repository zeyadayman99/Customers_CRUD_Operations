# Customers CRUD Operations

## Project Description
Customers CRUD Operations is a Spring Boot application designed to manage customer data using RESTful APIs. It utilizes Spring MVC for handling web requests, Spring Data JPA for database interactions, and PostgreSQL as the database managed via Docker. The application supports basic CRUD operations (Create, Read, Update, Delete) for managing customer records.

## Technologies Used
- ![Java](https://img.shields.io/badge/Java-8+-blue.svg)
- ![Maven](https://img.shields.io/badge/Maven-3+-blue.svg)
- ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-2.5.2-blue.svg)
- ![Spring MVC](https://img.shields.io/badge/Spring%20MVC-5.3.7-blue.svg)
- ![Spring Data JPA](https://img.shields.io/badge/Spring%20Data%20JPA-2.5.2-blue.svg)
- ![Spring JDBC](https://img.shields.io/badge/Spring%20JDBC-5.3.7-blue.svg)
- ![PostgreSQL](https://img.shields.io/badge/PostgreSQL-13.0-blue.svg)
- ![Docker](https://img.shields.io/badge/Docker-20.10.7-blue.svg)

## Architecture Overview
The project follows a layered architecture using Spring Boot, incorporating MVC design pattern for handling web requests and JPA for data persistence. PostgreSQL is used as the database managed via Docker.

![N Tier Architecture](src/main/resources/N%20tier%20architecture.jpg)

### Package Structure
- **`com.example.customers.controller`**: Contains REST controllers for handling HTTP requests.
- **`com.example.customers.service`**: Implements business logic and interacts with repositories.
- **`com.example.customers.repository`**: Provides interfaces for database operations using Spring Data JPA.
- **`com.example.customers.entity`**: Defines JPA entities mapped to database tables.
- **`com.example.customers.dto`**: Data Transfer Objects (DTOs) for transferring data between layers.
- **`com.example.customers.exception`**: Custom exception handling.
- **`com.example.customers.config`**: Configuration classes for Spring Boot and database setup.
- **`resources`**: Contains application properties, database scripts, and static resources.

## Class Descriptions
- **`CustomerController`**: Handles HTTP requests related to customer operations.
- **`CustomerService`**: Implements business logic for customer operations.
- **`CustomerRepository`**: Interface for database operations using Spring Data JPA.
- **`Customer`**: JPA entity representing a customer stored in the database.
- **`CustomerDTO`**: DTO for transferring customer data between layers.
- **`GlobalExceptionHandler`**: Handles exceptions thrown during application runtime.

## Setup Instructions
Follow these steps to set up and run the Customers CRUD Operations project locally:

1. Clone the repository:
   ```bash
   git clone https://github.com/zeyadayman99/Customers_CRUD_Operations.git

2. Ensure Docker is installed and running.
3. Start PostgreSQL database in Docker:
   ```bash
   docker-compose up -d
4. Build and run the Spring Boot application using Maven:
   ```bash
   cd Customers_CRUD_Operations
   mvn spring-boot:run

## Testing API with Postman

- Import the collection from 'docs/postman_collection.json' to Postman.
- Use the collection to test CRUD operations for customers.

