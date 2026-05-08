# SpringBootCoreConfigPropsEx — Spring Boot @ConfigurationProperties

This project demonstrates how Spring Boot reads data from `application.properties` and maps it into a Java class using `@ConfigurationProperties`.

---

## 🚀 Project Overview

A Spring Boot application where:

- Configuration data is stored in `application.properties`
- Properties are mapped to Java object fields
- Spring automatically injects values
- Data is displayed using `CommandLineRunner`

---

## 🧱 Technologies Used

- Java 8
- Spring Boot
- Maven

---

## ⚙️ How It Works

1. Spring Boot application starts
2. `application.properties` file is loaded
3. `@ConfigurationProperties` reads matching keys
4. Values are stored inside Java object fields
5. Object is injected using `@Autowired`
6. Data is printed in runner class

---

## 🧩 Code Explanation

### 🔹 DatabaseCon Class

- Annotated with `@Component`
- Uses `@ConfigurationProperties("my.app")`
- Stores database configuration data

Example:

```java
@Component
@ConfigurationProperties("my.app")
public class DatabaseCon {
```

---

### 🔹 application.properties

Stores configuration values:

```properties
my.app.driver=com.mysql.cj.jdbc.Driver
my.app.url=jdbc:mysql://localhost:3306/test
my.app.username=root
my.app.password=admin
```

---

### 🔹 TestDbConrunner Class

- Implements `CommandLineRunner`
- Injects `DatabaseCon` object using `@Autowired`
- Prints object data

---

## 💡 Key Concepts Covered

- `@ConfigurationProperties`
- External configuration
- Property binding
- Dependency Injection
- `@Autowired`
- Spring Boot configuration handling

---

## 📌 Key Insight

Instead of manually reading properties using:

```java
Environment env
```

Spring Boot automatically maps configuration values into Java objects using `@ConfigurationProperties`, making the code cleaner and easier to manage.
