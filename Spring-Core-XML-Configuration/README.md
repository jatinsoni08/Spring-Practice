# Spring Core — XML Configuration Project

This project demonstrates the **basic usage of Spring Core using XML-based configuration**.

It focuses on understanding how Spring manages objects using **Inversion of Control (IoC)** and **Dependency Injection (DI)**.

---

## 🚀 Project Overview

A simple Spring application where:

- A bean (`Learn` class) is defined
- Properties are injected using XML configuration
- The object is managed by the Spring Container
- The bean is retrieved using `ApplicationContext`

---

## 🧱 Technologies Used

- Java 8
- Spring Core (spring-context)
- Maven

---

## ⚙️ How It Works

1. Spring container loads `config.xml`
2. Bean with id `"aa"` is created
3. Properties (`sid`, `name`) are injected
4. Bean is retrieved using `getBean()`
5. Output is printed

---

## 🧩 Code Explanation

### 🔹 Bean Class (`Learn.java`)

- Contains properties: `sid`, `name`
- Uses setters for dependency injection
- Overrides `toString()` for output

### 🔹 Configuration (`config.xml`)

- Defines the bean
- Injects values using `<property>`

### 🔹 Main Class (`Test.java`)

- Loads Spring container
- Retrieves bean using `ApplicationContext`
- Prints the object

---

---

## 💡 Key Concepts Covered

- Inversion of Control (IoC)
- Dependency Injection (Setter Injection)
- Spring Container (`ApplicationContext`)
- XML-based Bean Configuration

---

## 📌 Why This Project

This project helps in understanding:

- How Spring removes manual object creation
- How dependencies are managed automatically
- The foundation of Spring Framework

---

## 📚 Next Steps

- Java-based configuration (Annotation)
- Bean scopes & lifecycle
- Spring Boot basics

---

## 🙏 Acknowledgment

Grateful to **Prasoon Bidua Sir** and **REGex Software Services**  
for guiding with clear concepts and real-world understanding.
