# SpringBoot_DataJPA_Project — Spring Boot Data JPA with MySQL

This project demonstrates how Spring Boot integrates with a MySQL database using **Spring Data JPA**. It performs a basic `save()` operation on a `Student` entity using `CrudRepository`, all triggered via `CommandLineRunner`.

---

## 🚀 Project Overview

A Spring Boot application where:

- MySQL database connection is configured in `application.properties`
- A `Student` entity is mapped to a database table using JPA annotations
- `StudentRepository` extends `CrudRepository` for built-in CRUD operations
- A `CommandLineRunner` creates and saves a `Student` object on app startup
- Hibernate auto-creates the table using `ddl-auto=create`

---

## 🧱 Technologies Used

- Java 17
- Spring Boot 4.0.6
- Spring Data JPA
- Hibernate
- MySQL
- Lombok
- Maven

---

## 📁 Project Structure

```
src/main/java/com/app/jatin/
├── Application.java                  # Main Spring Boot entry point
├── entity/
│   └── Student.java                  # JPA Entity mapped to student_tab
├── repo/
│   └── StudentRepository.java        # CrudRepository interface
└── runner/
    └── TestOprRunner.java            # CommandLineRunner — saves a Student
```

---

## ⚙️ How It Works

1. Spring Boot application starts
2. `application.properties` configures the MySQL datasource
3. Hibernate reads `Student` entity and auto-creates `student_tab` table (`ddl-auto=create`)
4. `TestOprRunner` runs on startup
5. A `Student` object is created and saved to the database via `repo.save()`
6. SQL query is printed to console (`show-sql=true`)

---

## 🗄️ Database Configuration

### `application.properties`

```properties
spring.application.name=SpringBoot_DataJPA_ProjectExample

spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/springdatajpa2May
spring.datasource.username=root
spring.datasource.password=yourpassword

spring.jpa.show-sql=true
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect
spring.jpa.hibernate.ddl-auto=create
```

> ⚠️ Create the database `springdatajpa2May` in MySQL before running the app.

---

## 🧩 Code Explanation

### 🔹 Student.java (Entity)

- Annotated with `@Entity` — marks it as a JPA entity
- `@Table(name = "student_tab")` — maps to `student_tab` table in DB
- `@Id` + `@Column(name = "sid")` — primary key mapping
- Uses Lombok `@Data` for auto-generated getters, setters, toString

```java
@Entity
@Table(name = "student_tab")
@Data
public class Student {

    @Id
    @Column(name = "sid")
    private Integer stdId;

    @Column(name = "sname")
    private String stdName;

    @Column(name = "sfee")
    private Double stdFee;
}
```

---

### 🔹 StudentRepository.java

- Extends `CrudRepository<Student, Integer>`
- No extra code needed — Spring Data JPA provides built-in methods like `save()`, `findById()`, `findAll()`, `deleteById()` automatically

```java
public interface StudentRepository extends CrudRepository<Student, Integer> {

}
```

---

### 🔹 TestOprRunner.java

- Implements `CommandLineRunner` — runs automatically after Spring Boot starts
- Injects `StudentRepository` using `@Autowired`
- Creates a `Student` object and saves it to the database

```java
@Component
public class TestOprRunner implements CommandLineRunner {

    @Autowired
    private StudentRepository repo;

    @Override
    public void run(String... args) throws Exception {

        System.out.println(repo.getClass().getName());

        Student sob = new Student();
        sob.setStdId(101);
        sob.setStdName("Jatin Soni");
        sob.setStdFee(1000.00);

        repo.save(sob);
    }
}
```

---

## 💡 Key Concepts Covered

- `@Entity` and `@Table` — JPA entity mapping
- `@Id` and `@Column` — field-to-column mapping
- `CrudRepository` — ready-made CRUD operations
- `spring.jpa.hibernate.ddl-auto=create` — auto table creation
- `CommandLineRunner` — code execution on startup
- `@Autowired` — Dependency Injection
- Lombok `@Data` — boilerplate reduction
- `spring.jpa.show-sql=true` — Hibernate SQL logging

---

## 📌 Key Insight

Instead of writing SQL queries manually, Spring Data JPA provides built-in repository methods. Just extend `CrudRepository` and call:

```java
repo.save(object);       // INSERT
repo.findById(id);       // SELECT by ID
repo.findAll();          // SELECT all
repo.deleteById(id);     // DELETE
```

Hibernate handles the SQL internally — no boilerplate needed.

---

## ▶️ How to Run

1. Start MySQL and create the database:
   ```sql
   CREATE DATABASE springdatajpa2May;
   ```
2. Update `username` and `password` in `application.properties`
3. Run the project:
   ```bash
   ./mvnw spring-boot:run
   ```
4. Check the console for the Hibernate SQL output and verify data in MySQL

---

## 🧪 Expected Console Output

```
com.sun.proxy.$Proxy...
Hibernate: drop table if exists student_tab
Hibernate: create table student_tab (sfee double(53), sid integer not null, sname varchar(255), primary key (sid))
Hibernate: insert into student_tab (sfee, sname, sid) values (?, ?, ?)
```
