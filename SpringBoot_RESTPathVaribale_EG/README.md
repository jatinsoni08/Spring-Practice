# SpringBoot_RESTPathVariable_EG — @RequestParam vs @PathVariable in Spring Boot REST API

This project demonstrates two different ways to pass data through a URL in Spring Boot REST APIs — using **@RequestParam** (query parameters) and **@PathVariable** (path segments) — along with **ResponseEntity** for complete HTTP response control.

---

## 🚀 Project Overview

A Spring Boot REST API application where:

- `ProductRestController` exposes two GET endpoints
- `/dataa` uses `@RequestParam` — reads data from query string (`?key=value`)
- `/datab/{pid}/{pname}` uses `@PathVariable` — reads data from URL path segments
- Both return `ResponseEntity<String>` with `HttpStatus.OK`
- Tested using Postman or browser

---

## 🧱 Technologies Used

- Java 17
- Spring Boot
- Spring Web (REST)
- ResponseEntity & HttpStatus
- Maven

---

## 📁 Project Structure

```
src/main/java/com/example/
├── SpringBootApplication.java               # Spring Boot main entry point
└── controller/
    └── ProductRestController.java           # REST Controller — @RequestParam + @PathVariable
```

---

## ⚙️ How It Works

### Using @RequestParam

- Data passed as **query parameters** after `?` in URL
- Format: `/dataa?pid=10&pname=Laptop`
- Spring reads `pid` and `pname` from query string

### Using @PathVariable

- Data passed as **path segments** directly in URL
- Format: `/datab/10/Laptop`
- Spring reads `{pid}` and `{pname}` from URL path

---

## 🧩 Code Explanation

### 🔹 ProductRestController.java

```java
@RestController
@RequestMapping("/product")
public class ProductRestController {

    // Using @RequestParam
    // URL: /product/dataa?pid=10&pname=Laptop
    @GetMapping("/dataa")
    public ResponseEntity<String> showDataA(
            @RequestParam("pid")   Integer id,
            @RequestParam("pname") String name) {

        System.out.println("PID " + id + " PNAME " + name);
        return new ResponseEntity<>("PID " + id + " PNAME " + name, HttpStatus.OK);
    }

    // Using @PathVariable
    // URL: /product/datab/10/Laptop
    @GetMapping("/datab/{pid}/{pname}")
    public ResponseEntity<String> showDataB(
            @PathVariable("pid")   Integer id,
            @PathVariable("pname") String name) {

        System.out.println("PID " + id + " PNAME " + name);
        return new ResponseEntity<>("PID " + id + " PNAME " + name, HttpStatus.OK);
    }
}
```

---

## 💡 Key Concepts Covered

- `@RestController` — returns JSON/String directly, no view page needed
- `@RequestMapping("/product")` — base URL at class level
- `@GetMapping` — maps HTTP GET request to handler method
- `@RequestParam("key")` — reads value from query string `?key=value`
- `@PathVariable("name")` — reads value from URL path `/{name}`
- `ResponseEntity<T>` — wrapper for HTTP response with body + status code
- `HttpStatus.OK` — represents HTTP status `200 OK`
- `new ResponseEntity<>(body, status)` — creates response with body and status

---

## 📌 @RequestParam vs @PathVariable

| Feature          | @RequestParam                    | @PathVariable                                 |
| ---------------- | -------------------------------- | --------------------------------------------- |
| URL Format       | `/dataa?pid=10&pname=A`          | `/datab/10/A`                                 |
| Position in URL  | After `?` as key=value pairs     | Directly in URL path                          |
| Declaration      | `@RequestParam("key")`           | `@PathVariable("name")` + `{name}` in mapping |
| Optional support | Yes — can be made optional       | No — always required                          |
| Best used for    | Filters, search, optional params | Resource identification                       |
| Example          | `/search?city=Jaipur`            | `/employee/101`                               |

---

## 📌 What is ResponseEntity?

`ResponseEntity<T>` gives full control over the HTTP response:

```java
// Syntax
new ResponseEntity<>(body, httpStatus)

// Examples
new ResponseEntity<>("Success", HttpStatus.OK);           // 200
new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);  // 404
new ResponseEntity<>(employeeList, HttpStatus.CREATED);   // 201
```

| Component                | Description                                |
| ------------------------ | ------------------------------------------ |
| `body`                   | Response data — String, Object, List, etc. |
| `HttpStatus.OK`          | 200 — request successful                   |
| `HttpStatus.CREATED`     | 201 — resource created                     |
| `HttpStatus.NOT_FOUND`   | 404 — resource not found                   |
| `HttpStatus.BAD_REQUEST` | 400 — invalid request                      |

---

## 🔗 API Endpoints

| URL                                                | HTTP Method | Type          | Description                           |
| -------------------------------------------------- | ----------- | ------------- | ------------------------------------- |
| `localhost:8080/product/dataa?pid=10&pname=Laptop` | GET         | @RequestParam | Reads pid and pname from query string |
| `localhost:8080/product/datab/10/Laptop`           | GET         | @PathVariable | Reads pid and pname from URL path     |

---

## ▶️ How to Run

1. Clone the repository
2. Open in STS / IntelliJ / Eclipse
3. Run as Spring Boot Application
4. Test in browser or Postman:

**@RequestParam:**

```
GET http://localhost:8080/product/dataa?pid=10&pname=Laptop
```

**@PathVariable:**

```
GET http://localhost:8080/product/datab/10/Laptop
```

---

## 🧪 Expected Output

**Both endpoints return:**

```
PID 10 PNAME Laptop
```

**Status: 200 OK**

**Console prints:**

```
PID 10 PNAME Laptop
```
