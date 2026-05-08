# SpringBootCoreInputEx-2 — Spring Boot Input & YAML Configuration

This project demonstrates how Spring Boot reads configuration data using both `application.properties` and `application.yml` files.

---

## 🚀 Project Overview

A Spring Boot application where:

- Configuration values are stored externally
- Spring Boot reads values from YAML format
- Properties are mapped into Java objects
- Bean data is displayed using runner classes

---

## 🧱 Technologies Used

- Java 8
- Spring Boot
- Maven

---

## ⚙️ How It Works

1. Spring Boot application starts
2. `application.yml` file is loaded
3. Configuration values are mapped automatically
4. Bean object is created by Spring container
5. Runner class prints all values

---

## 🧩 Code Explanation

### 🔹 YAML Configuration File

Spring Boot also supports YAML format:

```yaml
my:
  app:
    driver: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:3306/test
    username: root
    password: admin
```

---

### 🔹 Configuration Class

- Uses `@ConfigurationProperties`
- Reads YAML data
- Stores values inside Java object fields

Example:

```java
@Component
@ConfigurationProperties("my.app")
public class AppConfig {
```

---

### 🔹 Runner Class

- Implements `CommandLineRunner`
- Prints configuration values
- Runs automatically after startup

---

## 💡 Key Concepts Covered

- YAML configuration
- `application.yml`
- `@ConfigurationProperties`
- External configuration management
- Spring Boot automatic binding
- Dependency Injection

---

## 📌 Properties File vs YAML

### application.properties

```properties
my.app.username=root
```

### application.yml

```yaml
my:
  app:
    username: root
```

---

## 📌 Key Insight

YAML format is cleaner and more readable for large configurations because it supports hierarchical structure naturally.

Spring Boot supports both:

- `application.properties`
- `application.yml`

Both are used for externalized configuration management.
