# 01SpringSecurity-BaiscProject — Spring Security Basics, Session ID, CSRF Token & Authentication vs Authorization

This project is the **first hands-on introduction to Spring Security** — demonstrating what happens the moment you add the security dependency, how Spring secures your entire application by default, what Session IDs are, why CSRF tokens exist, and the most misunderstood concept in security — the difference between **Authentication** and **Authorization**.

---

## 🚀 Project Overview

A Spring Boot REST API application where:

- REST endpoints created for GET and POST operations on `Employee` data
- Application runs **without** Spring Security first — all endpoints freely accessible
- Spring Security dependency added — **auto login form + auto-generated password** triggered immediately
- Custom credentials configured in `application.properties`
- Session ID exposed via `HttpServletRequest` to prove **stateful behavior**
- CSRF Token exposed via dedicated endpoint to understand its generation
- POST request **fails with 401** without CSRF token in header
- POST request **succeeds with 200** after passing CSRF token in `X-CSRF-TOKEN` header
- All APIs tested using **Postman** with Basic Auth

---

## 🧱 Technologies Used

- Java 17
- Spring Boot
- Spring Security (`spring-boot-starter-security`)
- Spring Web (REST)
- Lombok
- Postman (API Testing)
- Maven

---

## 📁 Project Structure

```
src/main/java/com/app/
├── Application.java                         # Spring Boot main entry point
├── model/
│   └── Employee.java                        # Employee model with Lombok
└── restcontroller/
    └── EmployeeRestController.java          # REST Controller — 5 endpoints
```

---

## ⚙️ application.properties

```properties
spring.application.name=01SpringSecurityProject

spring.security.user.name=jatin
spring.security.user.password=jatin123
```

> Without these → Spring auto-generates password on console every restart (changes each time)
> With these → use `jatin` / `jatin123` to authenticate via Basic Auth in Postman

---

## 🧩 Code Explanation

### 🔹 Employee.java (Model)

```java
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private Integer empId;
    private String  empName;
    private String  empCity;
}
```

---

### 🔹 EmployeeRestController.java — 5 Endpoints

```java
@RestController
public class EmployeeRestController {

    List<Employee> list = new ArrayList<>(List.of(
        new Employee(1, "Jatin",      "Jaipur"),
        new Employee(2, "Sumit",      "Indore"),
        new Employee(1, "BePositive", "Kota")
    ));

    // GET — fetch all employees as JSON
    @GetMapping("/get-employee")
    public List<Employee> getAllEmployee() {
        return list;
    }

    // POST — add new employee (requires CSRF token in header)
    @PostMapping("/add-employee")
    public void addEmployee(@RequestBody Employee employee) {
        list.add(employee);
        System.out.println(list);
    }

    // GET — returns Session ID with response (proves STATEFUL behavior)
    @GetMapping("/get-info")
    public String getCourseInfo(HttpServletRequest request) {
        return "Jatin Soni JAVA Course" + request.getSession().getId();
    }

    // GET — returns Session ID (SAME as /get-info = confirms STATEFUL)
    @GetMapping("/get-moreinfo")
    public String getCourseMoreInfo(HttpServletRequest request) {
        return "Its a 10 month course" + request.getSession().getId();
    }

    // GET — exposes CSRF Token for use in POST/PUT/DELETE header
    @GetMapping("/get-csrf")
    public CsrfToken getCsrfToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
    }
}
```

---

## 💡 Key Concepts Covered

### 🔹 Spring Security Default Behavior

When `spring-boot-starter-security` is added:

- **Entire application is secured automatically** — zero configuration needed
- A **default login form** appears for every endpoint
- An **auto-generated password** is printed on console on every server restart
- Default username is `user` — override via `application.properties`
- Spring checks credentials in this order:
  1. Custom `@Configuration` class with `@EnableWebSecurity`
  2. `application.properties` — `spring.security.user.name` + `spring.security.user.password`
  3. Console default — auto-generated password

---

### 🔹 Authentication vs Authorization

| Term               | Meaning                               | Real World Example                   |
| ------------------ | ------------------------------------- | ------------------------------------ |
| **Authentication** | Who are you? — Verify identity        | Login with username + password       |
| **Authorization**  | What can you do? — Verify permissions | Admin can delete, User can only read |

> **Key Rule: Authenticated ≠ Authorized**

**Hotel analogy from lecture:**

- Rahul books a room → provides Booking ID + Aadhaar + OTP → **Authenticated** → gets room key
- Rahul tries gym → guard checks ID → gym needs extra payment → **Authenticated but NOT Authorized**
- Same concept in Spring: A user with valid credentials can be blocked from specific resources based on role

---

### 🔹 Session ID — Stateful Communication

```
Client → sends request → Server
Server → generates Session ID (JSESSIONID) → sends back in response cookie
Browser → stores Session ID in cookie
Next request → Session ID sent automatically → Server recognizes same user → STATEFUL
```

**Proof from code:**

```
GET /get-info     → "Jatin Soni JAVA Course  DF9A3C7B..."
GET /get-moreinfo → "Its a 10 month course   DF9A3C7B..."
                                              ↑ SAME Session ID = STATEFUL
```

**Risk:** If attacker steals Session ID → can access all protected resources

---

### 🔹 CSRF Token — Cross-Site Request Forgery Protection

| HTTP Method | Session ID Sufficient? | CSRF Token Required? |
| ----------- | ---------------------- | -------------------- |
| GET         | ✔ Yes                  | ✘ No                 |
| POST        | ✔ Yes                  | ✔ Yes                |
| PUT         | ✔ Yes                  | ✔ Yes                |
| DELETE      | ✔ Yes                  | ✔ Yes                |

**How CSRF Token works:**

- Generated **server-side** internally by Spring Security
- **Different every request** — unlike Session ID which stays same per session
- Must be passed in request **header** as `X-CSRF-TOKEN` for POST/PUT/DELETE
- Even if attacker steals Session ID → **cannot modify data** without CSRF Token

**From Postman screenshots:**

- POST without CSRF token → `401 Unauthorized`
- POST with `X-CSRF-TOKEN` in header → `200 OK` ✔
- Cookie shows `JSESSIONID=7769BFD5261A4C1CC5E04B...`

---

### 🔹 401 vs 403

| Status Code        | Meaning                          | Cause                                           |
| ------------------ | -------------------------------- | ----------------------------------------------- |
| `401 Unauthorized` | Authentication failed or missing | Wrong/missing credentials or missing CSRF token |
| `403 Forbidden`    | Authenticated but not authorized | Valid user but no permission for that resource  |

---

## 🔗 API Endpoints

| URL                           | Method | Auth         | CSRF       | Description                                        |
| ----------------------------- | ------ | ------------ | ---------- | -------------------------------------------------- |
| `localhost:8080/get-employee` | GET    | ✔ Basic Auth | ✘          | Returns employee list as JSON — **200 OK**         |
| `localhost:8080/add-employee` | POST   | ✔ Basic Auth | ✔ Required | Adds employee — **401** without CSRF, **200** with |
| `localhost:8080/get-info`     | GET    | ✔ Basic Auth | ✘          | Returns course info + Session ID                   |
| `localhost:8080/get-moreinfo` | GET    | ✔ Basic Auth | ✘          | Returns more info + **same** Session ID            |
| `localhost:8080/get-csrf`     | GET    | ✔ Basic Auth | ✘          | Returns CSRF Token to use in POST header           |

---

## ▶️ How to Run & Test

1. Clone the repository
2. Open in STS / IntelliJ / Eclipse
3. Run as Spring Boot Application
4. Open **Postman** → Authorization → **Basic Auth**
5. Username: `jatin` | Password: `jatin123`

**Step-by-step Postman flow:**

```
Step 1: GET /get-employee        → verify data returns (200 OK)
Step 2: GET /get-csrf            → copy the token value
Step 3: POST /add-employee
        Headers → X-CSRF-TOKEN: [paste token]
        Body → raw JSON: {"empId":4,"empName":"Anubhav","empCity":"Pali"}
        → 200 OK ✔
Step 4: GET /get-info            → note Session ID
Step 5: GET /get-moreinfo        → same Session ID confirms STATEFUL
```

---

## 🧪 Expected Output

**GET `/get-employee` → 200 OK (with Basic Auth: jatin/jatin123):**

```json
[
  { "empId": 1, "empName": "Jatin", "empCity": "Jaipur" },
  { "empId": 2, "empName": "Sumit", "empCity": "Indore" },
  { "empId": 1, "empName": "BePositive", "empCity": "Kota" }
]
```

**POST `/add-employee` without CSRF → 401 Unauthorized**

**POST `/add-employee` with X-CSRF-TOKEN header → 200 OK**

**GET `/get-info` and `/get-moreinfo` → same JSESSIONID confirms stateful session**
