# SpringBootCoreRunnersEx — Spring Boot CommandLineRunner & @Order

This project demonstrates how multiple `CommandLineRunner` classes work in Spring Boot and how execution order is managed using `@Order`.

---

## 🚀 Project Overview

A Spring Boot application where:

- Multiple runner classes are created
- Each runner executes automatically after application startup
- `@Order` is used to control execution sequence
- Spring Boot manages all beans automatically

---

## 🧱 Technologies Used

- Java 8
- Spring Boot
- Maven

---

## ⚙️ How It Works

1. Spring Boot application starts
2. Spring container creates all runner beans
3. Classes implementing `CommandLineRunner` are detected
4. `run()` methods execute automatically
5. Execution order is decided using `@Order`

---

## 🧩 Code Explanation

### 🔹 Application Class

- Main starter class
- Uses `@SpringBootApplication`
- Starts Spring Boot container

Example:

```java
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
```

---

### 🔹 DatabaseConRunner

- Implements `CommandLineRunner`
- Uses `@Order(5)`
- Executes first

```java
@Component
@Order(5)
public class DatabaseConRunner implements CommandLineRunner
```

---

### 🔹 MessageRunner

- Uses `@Order(10)`
- Executes after DatabaseConRunner

---

### 🔹 EmailConfigRunner

- Uses `@Order(15)`
- Executes last

---

## 💡 Key Concepts Covered

- `CommandLineRunner`
- Automatic execution after startup
- `@Order` annotation
- Spring Boot bean management
- Startup execution flow

---

## 📌 Execution Order

Since smaller order value executes first:

```text
DatabaseConRunner  -> Order 5
MessageRunner      -> Order 10
EmailConfigRunner  -> Order 15
```

Output sequence:

```text
Database Con Runner
Message Runner.....
Email config..........
```

---

## 📌 Key Insight

`CommandLineRunner` is useful for:

- Testing startup logic
- Loading initial data
- Checking configuration
- Running background startup tasks

`@Order` helps manage execution sequence when multiple runners exist.
