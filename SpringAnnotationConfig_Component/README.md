# Spring Core — @Component Annotation (Manual Container)

This project demonstrates how Spring creates and manages beans using @Component annotation with manual container configuration.

---

## 🚀 Project Overview

A Spring application where:

- A class is marked as a Spring Bean using @Component
- Values are injected using @Value
- Spring container is manually configured using scan() and refresh()

---

## 🧱 Technologies Used

- Java 8
- Spring Core (spring-context)
- Maven

---

## ⚙️ How It Works

1. Spring container is created
2. scan() is used to scan the base package
3. Classes with @Component are detected
4. refresh() initializes the container
5. Bean is fetched using getBean()
6. Output is printed

---

## 🧩 Code Explanation

### 🔹 HandlerInfo Class

- Annotated with @Component("hob")
- Registered as a Spring Bean
- Uses @Value for injecting data into fields

---

### 🔹 Bean Naming

- Custom name:
  @Component("hob")

- Default name:
  If not provided → class name in camelCase  
  Example:
  FormatService → formatService

---

### 🔹 Test Class

- Creates Spring container
- Uses scan() and refresh()
- Fetches bean using:
  getBean("hob")

---

## 💡 Key Concepts Covered

- @Component annotation
- Bean creation in Spring
- Custom & default bean naming
- @Value injection
- Manual container configuration
- scan() and refresh()

---

## 📌 Key Insight

Instead of manually creating objects:

HandlerInfo obj = new HandlerInfo();

Spring automatically creates and manages objects using @Component, reducing boilerplate code and improving scalability.
