# Spring Core — Reference Type Dependency Injection

This project demonstrates how to inject **one bean into another bean** using Spring XML configuration.

---

## 🚀 Project Overview

A Spring application where:

- `Service` depends on `Repository`
- Dependency is injected using `<ref>`

---

## 🧱 Technologies Used

- Java 8
- Spring Core (spring-context)
- Maven

---

---

## ⚙️ How It Works

1. Spring container loads `bean.xml`
2. `Repository` bean is created
3. `Service` bean is created
4. `Repository` object is injected into `Service`
5. Bean is retrieved and printed

---

## 🧩 Code Explanation

### 🔹 Repository Class

- Represents data layer
- Contains simple property `entity` :contentReference[oaicite:2]{index=2}

### 🔹 Service Class

- Depends on `Repository`
- Uses setter injection for dependency :contentReference[oaicite:3]{index=3}

### 🔹 Test Class

- Loads Spring container
- Fetches `Service` bean
- Prints injected dependency :contentReference[oaicite:4]{index=4}

---

---

## 💡 Key Concepts Covered

- Reference Type Dependency Injection
- Bean-to-Bean injection
- `<ref>` tag usage
- Loose coupling using Spring

---

## 📌 Key Insight

Instead of manually creating objects:

```java
Service s = new Service();
s.setRepo(new Repository());
```
