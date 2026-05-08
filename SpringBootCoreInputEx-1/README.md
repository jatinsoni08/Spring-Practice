# SpringBootCoreInputEx-1 — Reading Input from application.properties

This project demonstrates how Spring Boot reads custom input values from `application.properties` and stores them inside a Java object.

---

## 🚀 Project Overview

A Spring Boot application where:

- Custom database values are written in `application.properties`
- Spring Boot maps those values into a POJO class
- Bean object is created automatically
- Values are printed using `CommandLineRunner`

---

## 🧱 Technologies Used

- Java 8
- Spring Boot
- Maven

---

## ⚙️ How It Works

1. Application starts
2. Spring Boot loads `application.properties`
3. `@ConfigurationProperties("my.db")` reads matching keys
4. Values are assigned to object fields
5. Bean object is injected automatically
6. Data is displayed in console

---

## 🧩 Code Explanation

### 🔹 DatabaseCon Class

- POJO class for storing database data
- Uses `@Component`
- Uses `@ConfigurationProperties("my.db")`

Example:

```java
@Component
@ConfigurationProperties("my.db")
public class DatabaseCon {
```

---

### 🔹 application.properties

Example properties:

```properties
my.db.driver=com.mysql.cj.jdbc.Driver
my.db.url=jdbc:mysql://localhost:3306/test
my.db.usr=root
my.db.pwd=admin
```

---

### 🔹 TestObjRunner Class

- Implements `CommandLineRunner`
- Uses `@Autowired`
- Prints bean object data

---

## 💡 Key Concepts Covered

- Reading data from properties file
- `@ConfigurationProperties`
- Spring Boot automatic binding
- Bean creation
- Dependency Injection
- `CommandLineRunner`

---

## 📌 Key Insight

Spring Boot automatically binds external configuration values to Java objects using naming conventions.

This approach:

- Reduces boilerplate code
- Makes configuration cleaner
- Improves maintainability
- Separates configuration from business logic
