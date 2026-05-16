# SpringDATAJPA_EmployeeCRUDProject — Full CRUD with Spring Data JPA & MySQL

This project demonstrates complete **CRUD operations** (Create, Read, Update, Delete) on an `Employee` entity using **Spring Data JPA** and **MySQL**, all executed on application startup via `CommandLineRunner`.

---

## 🚀 Project Overview

A Spring Boot application where:

- `Employee` entity is mapped to `employee_tab` table using JPA annotations
- `EmployeeRepository` extends `CrudRepository` for built-in CRUD operations
- All CRUD operations are performed inside `TestOperationRunner` on startup
- `ddl-auto=update` ensures table persists across runs
- SQL queries are formatted and printed to console

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
src/main/java/com/app/prasoon/
├── Application.java                      # Spring Boot main entry point
├── entity/
│   └── Employee.java                     # JPA Entity mapped to employee_tab
├── repo/
│   └── EmployeeRepository.java           # CrudRepository interface
└── runner/
    └── TestOperationRunner.java          # CommandLineRunner — full CRUD operations
```

---

## ⚙️ How It Works

1. Spring Boot starts and connects to MySQL
2. Hibernate reads `Employee` entity — creates/updates `employee_tab` table
3. `TestOperationRunner` runs on startup
4. INSERT → FETCH ALL → FETCH BY ID → UPDATE → DELETE → FINAL FETCH — all executed in sequence
5. All SQL queries printed to console with formatting

---

## 🗄️ Database Configuration

### `application.properties`

```properties
spring.application.name=8May_SpringDATAJPA_EmployeeCRUDProject

spring.datasource.url=jdbc:mysql://localhost:3306/springbootdb
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

> ⚠️ Create database `springbootdb` in MySQL before running the app.

---

## 🧩 Code Explanation

### 🔹 Employee.java (Entity)

- `@Entity` + `@Table(name = "employee_tab")` — mapped to DB table
- `@Id` + `@Column` — field-to-column mapping
- Lombok `@Data`, `@NoArgsConstructor`, `@AllArgsConstructor` — no boilerplate

```java
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employee_tab")
public class Employee {

    @Id
    @Column(name = "eid")
    private Integer empId;

    @Column(name = "ename")
    private String empName;

    @Column(name = "esal")
    private Double empSal;

    @Column(name = "edept")
    private String empDept;
}
```

---

### 🔹 EmployeeRepository.java

- Extends `CrudRepository<Employee, Integer>`
- Zero custom code — all CRUD methods available out of the box

```java
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

}
```

---

### 🔹 TestOperationRunner.java — CRUD in Action

```java
// INSERT
repo.saveAll(Arrays.asList(e1, e2, e3));

// FETCH ALL
repo.findAll().forEach(System.out::println);

// FETCH BY ID
Optional<Employee> opt = repo.findById(102);

// UPDATE
emp.setEmpSal(90000.0);
repo.save(emp);

// DELETE
repo.deleteById(101);
```

---

## 💡 Key Concepts Covered

- `@Entity`, `@Table`, `@Id`, `@Column` — JPA entity mapping
- `CrudRepository` — built-in CRUD without SQL
- `saveAll()` — insert multiple records at once
- `findAll()` — fetch all records
- `findById()` — fetch by primary key using `Optional`
- `save()` — update existing record
- `deleteById()` — delete by primary key
- `Optional` — null-safe result handling
- `ddl-auto=update` — table persists across runs
- `format_sql=true` — formatted SQL in console
- Lombok `@NoArgsConstructor` + `@AllArgsConstructor`

---

## 📌 Key Insight

`ddl-auto=create` → drops and recreates table every run  
`ddl-auto=update` → keeps existing data, only applies new changes

For CRUD practice → always use `update` so data persists between runs.

---

## ▶️ How to Run

1. Start MySQL and create the database:
   ```sql
   CREATE DATABASE springbootdb;
   ```
2. Update `username` and `password` in `application.properties`
3. Run the project:
   ```bash
   ./mvnw spring-boot:run
   ```
4. Watch console — all CRUD operations execute and SQL prints with formatting

---

## 🧪 Expected Console Output

```
EMPLOYEE DATA INSERTED
--------------------------------
Employee(empId=101, empName=Rahul, empSal=45000.0, empDept=DEV)
Employee(empId=102, empName=Aman, empSal=55000.0, empDept=TESTING)
Employee(empId=103, empName=Neha, empSal=65000.0, empDept=HR)
--------------------------------
EMPLOYEE FOUND
Employee(empId=102, empName=Aman, empSal=55000.0, empDept=TESTING)
--------------------------------
EMPLOYEE UPDATED
--------------------------------
EMPLOYEE DELETED
--------------------------------
Employee(empId=102, empName=Aman, empSal=55000.0, empDept=TESTING)
Employee(empId=103, empName=Neha, empSal=90000.0, empDept=HR)
```
