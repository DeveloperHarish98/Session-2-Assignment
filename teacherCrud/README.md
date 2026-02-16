# Teacher Directory - Spring Boot Application

This is a Spring Boot CRUD application for managing teachers with a professional Dashboard UI.

## Prerequisites

1. **Java 17**
2. **MySQL Database**.

## Database Setup

1. Open your MySQL client (Workbench, CLI, etc.).
2. Run the provided script: `teacher-directory.sql` located in the parent directory.
   ```sql
   source ../teacher-directory.sql;
   ```
   Or open the file and execute the commands.
3. Verify the database `teacher_directory` is created.

## Configuration

Open `src/main/resources/application.properties` and update the database credentials if they differ from the defaults:

```properties
spring.datasource.url=****
spring.datasource.username=****
spring.datasource.password=****
```

## Running the Application

1. Open a terminal in this directory.
2. Run the following command:
   ```bash
   ./mvnw spring-boot:run
   ```
3. The application will start at `http://localhost:8080`.

## Accessing the Dashboard

- Dashboard: [http://localhost:8080/teachers/list](http://localhost:8080/teachers/list)
