# SpringBoot_ExceptionHandling_BasicProject — Custom Exception Handling in Spring Boot REST APIs

This project covers **Exception Handling in Spring Boot REST APIs** — from understanding Spring Boot's default error behavior to writing a complete custom exception handling flow using `@RestControllerAdvice`, `@ExceptionHandler`, custom exception classes, and a structured error response bean.

---

## 🚀 Project Overview

A Spring Boot REST API application where:

- A `Product` entity is served via REST endpoint `GET /product/one/{id}`
- When `id == 10` → Product found → `200 OK` with JSON response
- When `id != 10` → `ProductNotFoundException` thrown → caught by global handler → structured JSON error response
- Custom `MyErrorResponse` bean returns: `date`, `status`, `code`, `message`
- `@RestControllerAdvice` + `@ExceptionHandler` handles all exceptions globally — no duplicate try-catch in every controller
- Runs on **port 8484**

---

## 🧱 Technologies Used

- Java 17
- Spring Boot
- Spring Web (REST)
- Lombok
- Postman (API Testing)
- Maven

---

## 📁 Project Structure

```
src/main/java/com/app/
├── Application.java
├── bean/
│   └── MyErrorResponse.java              # Custom error response structure
├── entity/
│   └── Product.java                      # Product model with Lombok
├── exception/
│   └── ProductNotFoundException.java     # Custom Runtime Exception
├── service/
│   └── ProductService.java               # Business logic — throws exception
├── controller/
│   └── ProductRestController.java        # REST Controller
└── handler/
    └── MyCustomExceptionHandler.java     # Global Exception Handler
```

---

## ⚙️ application.properties

```properties
spring.application.name=SpringBoot_ExceptionHandling_BasicProject
server.port=8484
```

---

## 🧩 Code Explanation

### 🔹 Product.java (Entity)

```java
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private Integer pid;
    private String  pcode;
}
```

Simple model class — no database. Data returned directly from service layer.

---

### 🔹 MyErrorResponse.java (Custom Error Bean)

```java
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyErrorResponse {
    private String date;
    private String status;
    private int    code;
    private String message;
}
```

This bean is returned as JSON when any exception occurs. Instead of Spring's default ugly error response, client gets a clean, structured message.

**Default Spring Boot Error (what we replaced):**

```json
{
  "timestamp": "2025-01-01T10:00:00.000+00:00",
  "status": 500,
  "error": "Internal Server Error",
  "trace": "java.lang.RuntimeException..."
}
```

**Our Custom Error Response:**

```json
{
  "date": "Thu Jun 05 10:15:30 IST 2025",
  "status": "EXCEPTION IN PROCESS",
  "code": 500,
  "message": "Product '158' NOT EXIST"
}
```

---

### 🔹 ProductNotFoundException.java (Custom Exception)

```java
public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException() {
        super();
    }

    public ProductNotFoundException(String message) {
        super(message);
    }
}
```

Extends `RuntimeException` → unchecked exception → no forced try-catch at call sites. Custom message passed via `super(message)` → accessible via `getMessage()` in handler.

---

### 🔹 ProductService.java (Business Logic)

```java
@Service
public class ProductService {

    public Product getOneProductById(Integer id) {
        if (id == 10) {
            return new Product(id, "DUMMY");
        } else {
            throw new ProductNotFoundException("Product '" + id + "' NOT EXIST");
        }
    }
}
```

Service layer owns the business rule — if product not found, it throws `ProductNotFoundException`. Controller does not decide this logic.

---

### 🔹 ProductRestController.java (REST Controller)

```java
@RestController
@RequestMapping("/product")
public class ProductRestController {

    @Autowired
    private ProductService service;

    @GetMapping("/one/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Integer id) {

        ResponseEntity<Product> response = null;

        try {
            Product pob = service.getOneProductById(id);
            response = new ResponseEntity<>(pob, HttpStatus.OK);

        } catch (ProductNotFoundException pnfe) {
            pnfe.printStackTrace();
            throw pnfe; // re-throw → passes to @ExceptionHandler
        }

        return response;
    }
}
```

Controller catches the exception, logs it via `printStackTrace()`, then **re-throws** it. Re-throwing passes control to `@RestControllerAdvice` handler — clean separation of concerns.

---

### 🔹 MyCustomExceptionHandler.java (Global Handler — Key Class)

```java
@RestControllerAdvice
public class MyCustomExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<MyErrorResponse> showCustomErrorMsg(
            ProductNotFoundException pnfe) {

        return new ResponseEntity<>(
            new MyErrorResponse(
                new Date().toString(),
                "EXCEPTION IN PROCESS",
                500,
                pnfe.getMessage()
            ),
            HttpStatus.INTERNAL_SERVER_ERROR
        );
    }
}
```

`@RestControllerAdvice` = `@ControllerAdvice` + `@ResponseBody` → global scope, JSON response automatic.
`@ExceptionHandler(ProductNotFoundException.class)` → fires only when this specific exception is thrown anywhere in the application.

---

## 💡 Key Concepts Covered

### 🔹 Exception Handling Flow

```
Client Request
      ↓
Controller Method
      ↓
Exception Occurs in Service
      ↓
Re-thrown from Controller
      ↓
@RestControllerAdvice scans for matching @ExceptionHandler
      ↓
showCustomErrorMsg() executes
      ↓
MyErrorResponse JSON → sent to Client
```

### 🔹 @RestControllerAdvice vs @ControllerAdvice

| Annotation              | Used For  | Response Format     | Needs @ResponseBody? |
| ----------------------- | --------- | ------------------- | -------------------- |
| `@ControllerAdvice`     | MVC apps  | View names          | Yes                  |
| `@RestControllerAdvice` | REST APIs | JSON / XML directly | No — built-in        |

### 🔹 What Happens When No Handler Exists?

```
Exception Occurs
      ↓
No @ExceptionHandler found
      ↓
Request forwarded to BasicErrorController
      ↓
Default error JSON with timestamp, status, trace returned
```

`BasicErrorController` is Spring Boot's built-in fallback. Our custom handler **replaces** it for matched exception types.

### 🔹 Why Custom Exception Handling?

| Default Behavior    | Custom Handling        |
| ------------------- | ---------------------- |
| Exposes stack trace | Clean, safe message    |
| Technical jargon    | User-friendly text     |
| Inconsistent format | Uniform JSON structure |
| Security risk       | Hides implementation   |

### 🔹 Interview Key Points

- `@RestControllerAdvice` handles exceptions **globally** across all controllers — no duplicate code
- One `@ExceptionHandler` method can handle **multiple exception types**
- Custom exception class extends `RuntimeException` — unchecked, no forced try-catch
- `ProductNotFoundException` is re-thrown from controller → picked up by global handler
- `MyErrorResponse` gives structured JSON: `date`, `status`, `code`, `message`

---

## 🔗 API Endpoints

| URL                              | Method | Condition | Response                     | Status |
| -------------------------------- | ------ | --------- | ---------------------------- | ------ |
| `localhost:8484/product/one/10`  | GET    | id == 10  | `{"pid":10,"pcode":"DUMMY"}` | 200 OK |
| `localhost:8484/product/one/158` | GET    | id != 10  | `MyErrorResponse` JSON       | 500    |

---

## 🧪 Expected Output

**GET `/product/one/10` → 200 OK:**

```json
{
  "pid": 10,
  "pcode": "DUMMY"
}
```

**GET `/product/one/158` → 500 Internal Server Error:**

```json
{
  "date": "Thu Jun 05 10:15:30 IST 2025",
  "status": "EXCEPTION IN PROCESS",
  "code": 500,
  "message": "Product '158' NOT EXIST"
}
```

---

## ▶️ How to Run

1. Clone the repository
2. Open in STS / IntelliJ / Eclipse
3. Run as Spring Boot Application
4. Open Postman → GET request
5. Hit `localhost:8484/product/one/10` → success
6. Hit `localhost:8484/product/one/999` → custom error response
