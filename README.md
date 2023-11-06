## TestingTask
# Testing task for Bots Crew

This project is a simple Spring Boot console application demonstrating a department accounting service

## Prerequisites

- Java 11
- Maven

## Getting Started

### Building and testing the project:

If you have Maven installed:

```
bash
mvn clean install
```

Or you can use the Maven Wrapper:

bash
```./mvnw clean install```

### Running the application:

Using Maven:
```
bash
mvn spring-boot:run
```

All data is in data.sql

### Commands:
Show head of department:
Head of {department_name} department is {head_of_department_name}
```
who is head of department {argument}
```
Show statistics of department:
assistans - {assistams_count}. 
associate professors - {associate_professors_count}
professors -{professors_count}
```
show {argument} statistics
```
Show the average salary:
The average salary of {department_name} is {average_salary}
```
show the average salary for the department {argument}
```
Show count of employee:
The count of employees is {employee_count}
```
show count of employee for {argument}
```
Global search among employees and departments:
```
global search by {argument}
```
