# Spring Core — @Autowired (Basic Dependency Injection)

This project demonstrates how Spring automatically injects one bean into another using @Autowired.

---

## 🚀 Project Overview

A Spring application where:

- Service depends on Repository
- Dependency is injected automatically using @Autowired
- No manual object creation is required

---

## 🧱 Technologies Used

- Java 8
- Spring Core (spring-context)
- Maven

---

## ⚙️ How It Works

1. Spring scans package using @ComponentScan
2. Repository bean is created
3. Service bean is created
4. Repository is injected into Service using @Autowired
5. Bean is fetched and printed

---

## 🧩 Code Explanation

### 🔹 MyRepository Class

- Annotated with @Component
- Represents data layer
- Value injected using @Value

---

### 🔹 MyService Class

- Annotated with @Component
- Depends on MyRepository (HAS-A relationship)
- Uses @Autowired for injection

---

### 🔹 Test Class

- Loads Spring container
- Fetches MyService bean
- Prints injected dependency

---

## 💡 Key Concepts Covered

- @Autowired annotation
- Automatic Dependency Injection
- Bean-to-bean linking
- HAS-A relationship
- Spring Container management

---

## 📌 Key Insight

Instead of manually creating objects:

MyService s = new MyService();

Spring automatically injects dependencies using @Autowired, reducing coupling and improving code structure.
