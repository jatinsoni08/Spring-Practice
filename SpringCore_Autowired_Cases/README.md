# Spring Core — @Autowired with Multiple Beans (Ambiguity Case)

This project demonstrates what happens when multiple beans of the same type exist and how Spring handles it.

---

## 🚀 Project Overview

A Spring application where:

- One interface has multiple implementations
- Spring tries to inject dependency using @Autowired
- Ambiguity problem occurs

---

## 🧱 Technologies Used

- Java 8
- Spring Core (spring-context)
- Maven

---

## ⚙️ How It Works

1. Spring scans package using @ComponentScan
2. Two beans are created:
   - MySQLRepository
   - OracleRepository
3. Service depends on MyRepository interface
4. Spring gets confused (multiple beans)
5. Injection becomes ambiguous

---

## 🧩 Code Explanation

### 🔹 Repository Interface

- Defines method getData()

---

### 🔹 MySQLRepository & OracleRepository

- Both implement same interface
- Both annotated with @Component

---

### 🔹 MyService Class

- Uses @Autowired
- Depends on interface (MyRepository)

---

## 💡 Key Concepts Covered

- @Autowired ambiguity problem
- Multiple bean issue
- Interface-based injection
- Real-world dependency scenarios

---

## 📌 Key Insight

When multiple beans of same type exist, Spring cannot decide which one to inject.

This problem is solved using:

- @Qualifier
- @Primary
