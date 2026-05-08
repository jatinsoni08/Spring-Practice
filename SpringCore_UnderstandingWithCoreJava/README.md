# Spring Core — Manual Dependency Injection (Without Spring Container)

This project demonstrates **Dependency Injection (DI)** in Java **without using Spring XML or annotations** — purely through setter and constructor injection patterns.

---

## 🚀 Project Overview

A Java application where:

- `CodeXPrasoon` depends on a `Course` (interface)
- Dependency is injected manually via **Setter Injection**
- `Course` interface has two implementations: `Java` and `SpringBootCourse`

---

## 🧱 Technologies Used

- Java 8
- Core Java (No Spring Framework)
- Maven (optional)

---

## ⚙️ How It Works

1. `Course` interface defines the contract (`getTheCourse(double amount)`)
2. `Java` and `SpringBootCourse` implement the `Course` interface
3. `CodeXPrasoon` holds a `Course` dependency
4. In `TestApp`, the dependency is **manually injected** using a setter
5. `buyTheCourse()` is called, which delegates to the injected implementation

---

## 🧩 Code Explanation

### 🔹 `Course` Interface

- Defines `getTheCourse(double amount)` as the contract for all course types

### 🔹 `Java` & `SpringBootCourse` Classes

- Two concrete implementations of `Course`
- Easily swappable without changing `CodeXPrasoon`

### 🔹 `CodeXPrasoon` Class

- Holds a `Course` dependency
- Uses **setter injection** (`setCourse()`) to receive it
- Also has a commented-out **constructor injection** alternative

### 🔹 `TestApp` (Main Class)

- Creates `CodeXPrasoon` object
- Injects the desired `Course` implementation manually
- Calls `buyTheCourse()` and prints enrollment status

---

## 💡 Key Concepts Covered

- Dependency Injection (DI) — Setter & Constructor
- Programming to an Interface (loose coupling)
- Open/Closed Principle — swap implementations without modifying consumer class
- Foundation for understanding Spring IoC Container

---

## 📌 Key Insight

Instead of tightly coupling like this:

```java
CodeXPrasoon cxp = new CodeXPrasoon();
// No way to change course implementation without modifying the class
```

We inject the dependency externally:

```java
CodeXPrasoon cxp = new CodeXPrasoon();
cxp.setCourse(new SpringBootCourse()); // swap easily!
Boolean status = cxp.buyTheCourse(4000.5);
```

This is the **manual version** of what Spring's IoC container does automatically.

---

## 🔄 Switch Implementations Easily

```java
// Use Java course
cxp.setCourse(new Java());

// OR use SpringBoot course
cxp.setCourse(new SpringBootCourse());
```

No changes needed inside `CodeXPrasoon` — that's the power of DI!

---

## 📁 Project Structure

src/
└── main/
└── java/
└── com/app/jatin2/
├── Course.java # Interface
├── Java.java # Implementation 1
├── SpringBootCourse.java # Implementation 2
├── CodeXPrasoon.java # Consumer class (has dependency)
└── TestApp.java # Main class (wires everything)
