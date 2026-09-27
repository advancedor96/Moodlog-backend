# Moodlog Backend

This is a simple CRUD backend built with Spring Boot and PostgreSQL.
Its purpose is to support a polished mood-tracking frontend.

## Tech Stack

- Java 21
- Spring Boot 4
- Spring Security
- Spring Data JDBC
- PostgreSQL

## Configuration

Environment variables:

```text
DB_URL=jdbc:postgresql://localhost:5432/moodlog
DB_USERNAME=your_username
DB_PWD=your_password
```
## Run
```
./mvnw spring-boot:run
```