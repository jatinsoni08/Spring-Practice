# SpringBoot_H2Database — In-Memory Database with H2 + Spring Data JPA

This project covers **H2 In-Memory Database integration with Spring Boot** — a lightweight, embedded database that runs inside your application with zero external setup. No MySQL installation, no Workbench, no server — just add the dependency and your database is ready. Data is visible via the built-in **H2 Console** at `/h2-console`.

---

## 🚀 Project Overview

- Spring Boot project with H2 in-memory database
- `Student` entity mapped to `STUDENT` table — auto-created by JPA on startup
- `StudentRepository` extends `JpaRepository` — save, findAll out of the box
- `StudentController` with `POST /save` and `GET /all` endpoints
- POST `{"id": 101, "name": "Jatin", "course": "Java"}` → saved to H2 → `200 OK`
- H2 Console enabled at `http://localhost:8080/h2-console`
- `SELECT * FROM STUDENT` → data visible in browser console
- Data resets on every app restart — **in-memory, not persistent**
- Runs on **port 8080**

---

## 🧱 Technologies Used

- Java 17
- Spring Boot
- Spring Data JPA
- H2 In-Memory Database
- Lombok
- Postman (API Testing)
- Maven

---

## 📁 Project Structure

```
src/main/java/com/app/jatin/
├── SpringBootH2DatabaseApplication.java     # Main entry point
├── entity/
│   └── Student.java                         # @Entity — maps to STUDENT table
├── repository/
│   └── StudentRepository.java               # JpaRepository<Student, Integer>
└── controller/
    └── StudentController.java               # REST Controller — /save and /all
```

---

## ⚙️ application.properties

```properties
spring.application.name=SpringBoot_H2Database

# H2 Database Configuration
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

# Hibernate Configuration
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

# Enable H2 Console
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
```

---

## 🧩 Code Explanation

### 🔹 Student.java (Entity)

```java
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    private int id;

    private String name;
    private String course;
}
```

`@Entity` tells JPA to map this class to a database table named `STUDENT`. `@Id` marks `id` as the primary key. Lombok handles all getters, setters, constructors.

---

### 🔹 StudentRepository.java (Repository)

```java
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
```

No code needed. By extending `JpaRepository<Student, Integer>` you get `save()`, `findAll()`, `findById()`, `deleteById()` — all auto-implemented by Spring Data JPA.

---

### 🔹 StudentController.java (REST Controller)

```java
@RestController
public class StudentController {

    @Autowired
    private StudentRepository repo;

    @PostMapping("/save")
    public Student saveStudent(@RequestBody Student student) {
        return repo.save(student);
    }

    @GetMapping("/all")
    public Object getAllStudents() {
        return repo.findAll();
    }
}
```

`repo.save(student)` — persists data to H2 in-memory database and returns saved object.
`repo.findAll()` — returns all records from STUDENT table as JSON.

---

## 💡 Key Concepts Covered

### 🔹 What is H2 Database?

H2 is a **Java-based in-memory relational database** that runs embedded inside your Spring Boot application. It requires zero external installation — just add the dependency and it works.

| Feature          | H2                     | MySQL            |
| ---------------- | ---------------------- | ---------------- |
| Installation     | None — embedded        | Required         |
| Setup            | Zero config            | DB server needed |
| Data persistence | Lost on restart        | Permanent        |
| Best for         | Learning, testing      | Production       |
| Console          | Browser at /h2-console | MySQL Workbench  |

---

### 🔹 H2 Console

Access the H2 browser console at `http://localhost:8080/h2-console`

```
JDBC URL : jdbc:h2:mem:testdb
Username : sa
Password : (empty)
```

Run SQL directly in browser:

```sql
SELECT * FROM STUDENT;
```

From screenshot — after POST `/save`:

```
ID   | COURSE | NAME
101  | Java   | Jatin
```

---

### 🔹 Why H2 for Learning?

- No MySQL installation required
- No port conflicts, no server management
- Instant setup — just add dependency
- H2 Console shows live data in browser
- Perfect for testing JPA, queries, and Spring Data

---

### 🔹 Postman Test Results

**POST `/save` → 200 OK:**

Request Body:

```json
{
  "id": 101,
  "name": "Jatin",
  "course": "Java"
}
```

Response:

```json
{
  "id": 101,
  "name": "Jatin",
  "course": "Java"
}
```

**GET `/all` → 200 OK:**

```json
[
  {
    "id": 101,
    "name": "Jatin",
    "course": "Java"
  }
]
```

---

## 🔗 API Endpoints

| URL                         | Method  | Description                 |
| --------------------------- | ------- | --------------------------- |
| `localhost:8080/save`       | POST    | Save student to H2 DB       |
| `localhost:8080/all`        | GET     | Get all students from H2 DB |
| `localhost:8080/h2-console` | Browser | H2 database console         |

---

## ▶️ How to Run

1. Clone the repository
2. Run as Spring Boot Application — no DB setup needed
3. Open Postman → POST `localhost:8080/save`
4. Body → raw → JSON:

```json
{ "id": 101, "name": "Jatin", "course": "Java" }
```

5. Open browser → `http://localhost:8080/h2-console`
6. JDBC URL: `jdbc:h2:mem:testdb` | Username: `sa` | Password: empty
7. Run `SELECT * FROM STUDENT` → data visible
