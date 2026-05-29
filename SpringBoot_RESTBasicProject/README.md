# SpringBoot_RESTBasicProject — REST API Basics with @RestController & @RequestBody

This project demonstrates how to build a basic **REST API** in Spring Boot using `@RestController`, `@GetMapping`, `@PostMapping` and `@RequestBody` — returning **JSON responses** directly to the client without any view page.

---

## 🚀 Project Overview

A Spring Boot REST API application where:

- `EmployeeRestController` handles GET and POST HTTP requests
- `@GetMapping("/show")` returns list of employees as JSON
- `@PostMapping("/add")` accepts JSON body, adds employee to list
- `@RequestBody` automatically converts incoming JSON to `Employee` object
- Jackson library handles JSON ↔ Java conversion internally
- APIs tested using **Postman**

---

## 🧱 Technologies Used

- Java 17
- Spring Boot
- Spring Web (REST)
- Jackson (auto-configured)
- Lombok
- Postman (API Testing)
- Maven

---

## 📁 Project Structure

```
src/main/java/com/app/jatin/
├── SpringBootRESTBasicApplication.java       # Spring Boot main entry point
├── model/
│   └── Employee.java                         # Employee model with Lombok annotations
└── restcontroller/
    └── EmployeeRestController.java           # REST Controller — GET + POST APIs
```

---

## ⚙️ How It Works

1. Spring Boot starts on port `8080`
2. `EmployeeRestController` is registered with base URL `/employee`
3. **GET `/employee/show`** → returns `listOfEmployee` as JSON array
4. **POST `/employee/add`** → reads JSON body → converts to `Employee` object → adds to list → returns updated list
5. Jackson auto-converts Java objects to JSON and JSON to Java objects

---

## 🧩 Code Explanation

### 🔹 Employee.java (Model)

```java
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    private Integer empId;
    private String  empName;
    private String  empCity;
}
```

---

### 🔹 EmployeeRestController.java

```java
@RestController
@RequestMapping("/employee")
public class EmployeeRestController {

    List<Employee> listOfEmployee = new ArrayList<>(
        List.of(
            new Employee(1, "A", "Jaipur"),
            new Employee(2, "B", "Udaipur"),
            new Employee(3, "C", "Indore")
        )
    );

    // GET API
    @GetMapping("/show")
    public List<Employee> showEmployeeDetails() {
        return listOfEmployee;
    }

    // POST API
    @PostMapping("/add")
    public List<Employee> addEmployee(@RequestBody Employee employee) {
        listOfEmployee.add(employee);
        return listOfEmployee;
    }
}
```

---

## 💡 Key Concepts Covered

- `@RestController` — combination of `@Controller` + `@ResponseBody`
- Returns **JSON** directly — no JSP, no Thymeleaf, no view resolver
- `@RequestMapping("/employee")` — base URL at class level
- `@GetMapping("/show")` — maps GET request, fetches data
- `@PostMapping("/add")` — maps POST request, receives data
- `@RequestBody` — Spring reads JSON from request body → converts to Java object
- **Jackson** — auto-configured library that handles JSON serialization/deserialization
- `List.of()` — immutable list (cannot add/remove)
- `new ArrayList<>(List.of(...))` — mutable list (can add/remove) ✔
- **Postman** — industry standard tool for testing REST APIs
- `200 OK` — successful HTTP response status

---

## 📌 @Controller vs @RestController

| Feature          | @Controller                   | @RestController                 |
| ---------------- | ----------------------------- | ------------------------------- |
| Returns          | Web page (HTML/JSP/Thymeleaf) | JSON / XML data                 |
| Used for         | MVC Web Applications          | REST APIs                       |
| View Resolver    | Required                      | Not needed                      |
| Response goes to | JSP / Thymeleaf view          | Directly to client              |
| Internally       | `@Controller` only            | `@Controller` + `@ResponseBody` |

---

## 📌 How @RequestBody Works

```
Client sends POST request with JSON body:
{
  "empId": 4,
  "empName": "D",
  "empCity": "Delhi"
}
        ↓
@RequestBody reads JSON
        ↓
Jackson converts JSON → Employee object
        ↓
employee.getEmpId()   → 4
employee.getEmpName() → "D"
employee.getEmpCity() → "Delhi"
        ↓
Added to list → updated list returned as JSON
```

---

## 🔗 API Endpoints

| URL                            | HTTP Method | Action                                  | Body Required |
| ------------------------------ | ----------- | --------------------------------------- | ------------- |
| `localhost:8080/employee/show` | GET         | Returns all employees as JSON           | No            |
| `localhost:8080/employee/add`  | POST        | Adds new employee, returns updated list | Yes (JSON)    |

---

## ▶️ How to Run

1. Clone the repository
2. Open in STS / IntelliJ / Eclipse
3. Run as Spring Boot Application
4. Open **Postman** and test:

**GET Request:**

```
GET http://localhost:8080/employee/show
```

**POST Request:**

```
POST http://localhost:8080/employee/add
Body → raw → JSON:
{
  "empId": 4,
  "empName": "D",
  "empCity": "Delhi"
}
```

---

## 🧪 Expected Output

**GET `/employee/show` → 200 OK:**

```json
[
  { "empId": 1, "empName": "A", "empCity": "Jaipur" },
  { "empId": 2, "empName": "B", "empCity": "Udaipur" },
  { "empId": 3, "empName": "C", "empCity": "Indore" }
]
```

**POST `/employee/add` → 200 OK:**

```json
[
  { "empId": 1, "empName": "A", "empCity": "Jaipur" },
  { "empId": 2, "empName": "B", "empCity": "Udaipur" },
  { "empId": 3, "empName": "C", "empCity": "Indore" },
  { "empId": 4, "empName": "D", "empCity": "Delhi" }
]
```
