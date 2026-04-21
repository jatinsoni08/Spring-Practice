# Spring Core — Collection Type Dependency Injection

This project demonstrates how to inject **collection type dependencies** in Spring using XML configuration.

---

## 🚀 Project Overview

A Spring application where a `Student` bean receives multiple types of data using collections:

- List → Mobile numbers
- Set → Addresses
- Map → Courses and duration

---

## 🧱 Technologies Used

- Java 8
- Spring Core (spring-context)
- Maven

---

---

## ⚙️ How It Works

1. Spring container loads `config.xml`
2. Bean `st` is created
3. Collection dependencies are injected:
   - `<list>` → Mobile numbers
   - `<set>` → Addresses
   - `<map>` → Courses
4. Bean is retrieved using `getBean()`

---

## 🧩 Code Explanation

### 🔹 Student Class

- Contains:
  - `List<String> mobileno`
  - `Set<String> address`
  - `Map<String, String> courses`
- Uses setter injection for collections
- Prints data using `toString()` :contentReference[oaicite:0]{index=0}

### 🔹 Test Class

- Loads Spring container
- Fetches bean `st`
- Prints all injected values :contentReference[oaicite:1]{index=1}

---

## ▶️ Output

- Student name
- Mobile numbers (List)
- Address (Set)
- Courses (Map)

---

## 💡 Key Concepts Covered

- Collection Type Dependency Injection
- XML configuration using:
  - `<list>`
  - `<set>`
  - `<map>`
- Spring Container usage
- Setter Injection

---

## 📌 Key Insight

Spring allows injecting **multiple values and structured data**  
without manually creating objects.

---

## 📚 Next Steps

- Reference Type Dependency Injection
- Bean relationships (Has-A)
- Annotation-based configuration
