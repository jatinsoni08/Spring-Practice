# Spring Core — @ComponentScan (Base Package & Multi-Package)

This project demonstrates how Spring automatically detects and manages beans using @ComponentScan without manual scan() and refresh().

---

## 🚀 Project Overview

A Spring application where:

- Beans are created using @Component
- Packages are scanned using @ComponentScan
- Multiple packages are handled using basePackages
- Spring container is automatically initialized

---

## 🧱 Technologies Used

- Java 8
- Spring Core (spring-context)
- Maven

---

## ⚙️ How It Works

1. Configuration class is loaded
2. @ComponentScan scans defined packages
3. Classes with @Component are detected
4. Beans are created automatically
5. No need to use scan() and refresh()
6. Beans are fetched using getBean()

---

## 🧩 Code Explanation

### 🔹 MyAppConfig Class

- Annotated with @Configuration
- Uses @ComponentScan to define packages

Example:
@ComponentScan(basePackages = {"com.app", "my.one.format"})

---

### 🔹 Multi-Package Scanning

- Spring scans multiple packages at once
- Helps manage large applications

---

### 🔹 Base Package vs Sub-Package

✔ If you scan:
@ComponentScan("com.app")

It will scan:

- com.app
- com.app.service
- com.app.dao

❌ It will NOT scan:

- my.one.format

✔ To include it:
@ComponentScan(basePackages = {"com.app", "my.one.format"})

---

### 🔹 Test Class

- Uses:
  AnnotationConfigApplicationContext(MyAppConfig.class)

- Directly loads configuration
- No need for scan() and refresh()

---

## 💡 Key Concepts Covered

- @ComponentScan annotation
- Base package vs sub-package
- Multi-package scanning
- Automatic bean creation
- Configuration-based container setup

---

## 📌 Key Insight

Instead of manually scanning packages:

ac.scan("com.app");
ac.refresh();

Spring allows automatic scanning using @ComponentScan, making configuration cleaner and production-ready.
