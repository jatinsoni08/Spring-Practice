# SpringBoot_JPQL_HQL_IMPL — JPQL, HQL & Custom Queries with Spring Data JPA + H2

This project covers **JPQL (Java Persistence Query Language)**, **HQL (Hibernate Query Language)**, and **custom finder methods** in Spring Data JPA — using H2 in-memory database. Instead of writing raw SQL, you write object-oriented queries that work with your Java entity classes directly.

---

## 🚀 Project Overview

- Same H2 setup as previous project — zero external DB needed
- `Student` entity with `id`, `name`, `course` fields
- `StudentRepository` extends `JpaRepository` with **3 types of queries**:
  - **Custom Finder Method** — `findAll()` via Spring naming convention
  - **JPQL** — `@Query("SELECT s FROM Student s")` — entity-based query
  - **JPQL with condition** — `@Query("SELECT s FROM Student s WHERE s.course=?1")` — param binding
  - **HQL** — `@Query(value = "FROM Student")` — Hibernate native syntax
- `StudentController` with 4 endpoints — `/save`, `/all`, `/jpql`, `/course/{course}`, `/hql`
- POST saves student → H2 Console shows live data
- H2 Console: `select * from student` → 2 rows visible (Prasoon/SpringBoot, Jatin/Java)
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
├── SpringBootJPQLHQLIMPLApplication.java
├── entity/
│   └── Student.java                        # @Entity — id, name, course
├── repository/
│   └── StudentRepository.java              # JpaRepository + JPQL + HQL queries
└── controller/
    └── StudentController.java              # REST endpoints
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

---

### 🔹 StudentRepository.java — 3 Query Types

```java
public interface StudentRepository extends JpaRepository<Student, Integer> {

    // ── JPQL Query ──────────────────────────────────────────────
    // Uses entity class name (Student) — not table name (STUDENT)
    // Show AOT-generated Implementation, Query, etc...
    @Query("SELECT s FROM Student s")
    List<Student> getAllStudentsJPQL();

    // ── JPQL with condition (parameter binding) ──────────────────
    // ?1 = first method parameter
    // Show AOT-generated Implementation, Query, etc...
    @Query("SELECT s FROM Student s WHERE s.course=?1 course ")
    List<Student> getStudentByCourse(String course);

    // ── HQL Query ────────────────────────────────────────────────
    // Hibernate Query Language — shorter syntax, FROM only
    // Show AOT-generated Implementation, Query, etc...
    @Query(value = "FROM Student")
    List<Student> getAllStudentsHQL();
}
```

---

### 🔹 StudentController.java

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
    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    // JPQL endpoint
    @GetMapping("/jpql")
    public List<Student> getJPQLData() {
        return repo.getAllStudentsJPQL();
    }

    // JPQL with condition — filter by course
    @GetMapping("/course/{course}")
    public List<Student> getByCourse(@PathVariable String course) {
        return repo.getStudentByCourse(course);
    }

    // HQL endpoint
    @GetMapping("/hql")
    public List<Student> getHQLData() {
        return repo.getAllStudentsHQL();
    }
}
```

---

## 💡 Key Concepts Covered

### 🔹 SQL vs JPQL vs HQL

| Feature      | SQL                     | JPQL                      | HQL                |
| ------------ | ----------------------- | ------------------------- | ------------------ |
| Works with   | Table names             | Entity class names        | Entity class names |
| Written by   | Developer               | Developer                 | Developer          |
| Syntax       | `SELECT * FROM STUDENT` | `SELECT s FROM Student s` | `FROM Student`     |
| DB dependent | Yes                     | No                        | No                 |
| Framework    | Raw JDBC                | Spring Data JPA           | Hibernate          |

---

### 🔹 JPQL — Java Persistence Query Language

```java
@Query("SELECT s FROM Student s")
```

- `Student` = Java class name (not table name)
- `s` = alias for Student object
- Works with **any database** — H2, MySQL, PostgreSQL — same query
- Spring Data JPA translates this to proper SQL at runtime

---

### 🔹 JPQL with Parameter Binding

```java
@Query("SELECT s FROM Student s WHERE s.course=?1")
List<Student> getStudentByCourse(String course);
```

- `?1` = first parameter of the method (`course`)
- `s.course` = field name of the Java class — not column name
- Hit `GET /course/Java` → returns all students with course = Java

---

### 🔹 HQL — Hibernate Query Language

```java
@Query(value = "FROM Student")
```

- Even shorter than JPQL — `FROM Student` is enough
- Hibernate handles the rest — generates full SQL internally
- HQL is Hibernate-specific; JPQL is JPA standard

---

### 🔹 Custom Finder Methods vs @Query

| Approach      | Example                                               | When to use                      |
| ------------- | ----------------------------------------------------- | -------------------------------- |
| Custom Finder | `findByName(String name)`                             | Simple single-field queries      |
| @Query JPQL   | `@Query("SELECT s FROM Student s WHERE s.course=?1")` | Complex conditions, joins        |
| @Query HQL    | `@Query(value = "FROM Student")`                      | Hibernate-specific, short syntax |

---

## 🔗 API Endpoints

| URL                          | Method | Query Type       | Description            |
| ---------------------------- | ------ | ---------------- | ---------------------- |
| `localhost:8080/save`        | POST   | —                | Save student to H2     |
| `localhost:8080/all`         | GET    | findAll()        | Get all students       |
| `localhost:8080/jpql`        | GET    | JPQL             | Get all via JPQL query |
| `localhost:8080/course/Java` | GET    | JPQL + condition | Filter by course name  |
| `localhost:8080/hql`         | GET    | HQL              | Get all via HQL query  |

---

## 🧪 Postman Test Results

**POST `/save` → 200 OK:**

```json
{ "id": 102, "name": "Jatin", "course": "Java" }
```

**GET `/course/Java` → 200 OK:**

```json
[{ "id": 102, "name": "Jatin", "course": "Java" }]
```

**H2 Console — `select * from student`:**

```
ID  | COURSE     | NAME
101 | SpringBoot | Prasoon
102 | Java       | Jatin
```

---

## ▶️ How to Run

1. Run as Spring Boot Application — H2 starts automatically
2. POST `localhost:8080/save` with JSON body to add students
3. Test all GET endpoints in Postman
4. Open `localhost:8080/h2-console` → JDBC URL: `jdbc:h2:mem:testdb`
5. Run `select * from student` to see live data
