# SpringWebMVC_EmployeeRegistrationForm — HTML Form Handling with @ModelAttribute

This project demonstrates how Spring Web MVC handles **HTML form submission** — capturing form data from JSP, binding it to a Java object automatically using `@ModelAttribute`, and displaying the registered employee data on a success page.

---

## 🚀 Project Overview

A Spring Boot Web MVC application where:

- `empReg.jsp` contains an HTML registration form with employee fields
- On form submit, Spring automatically binds form data to `Employee` object via `@ModelAttribute`
- `EmployeeController` handles both GET (show form) and POST (save form) requests
- Registered employee data is passed to `success.jsp` via `Model`
- `success.jsp` renders all employee fields using JSP EL expressions

---

## 🧱 Technologies Used

- Java 17
- Spring Boot
- Spring Web MVC
- JSP (Jakarta Server Pages)
- Lombok
- Maven

---

## 📁 Project Structure

```
src/main/java/com/example/demo/
├── DemoApplication.java                      # Spring Boot main entry point
├── model/
│   └── Employee.java                         # Employee model with Lombok annotations
└── controller/
    └── EmployeeController.java               # MVC Controller — GET form + POST save

src/main/resources/
└── application.properties                    # View resolver config + server port

src/main/webapp/WEB-INF/
├── empReg.jsp                                # Employee registration HTML form
└── success.jsp                               # Success page — displays registered employee
```

---

## ⚙️ How It Works

1. User hits `GET /form` → DispatcherServlet routes to `showForm()`
2. `showForm()` returns `"empReg"` → ViewResolver loads `empReg.jsp`
3. User fills form and clicks **CREATE** → `POST /register` triggered
4. Spring auto-binds form fields to `Employee` object via `@ModelAttribute`
5. `saveEmployee()` adds employee to Model and returns `"success"`
6. ViewResolver loads `success.jsp` → renders `${empData.field}` values

---

## 🗄️ application.properties

```properties
spring.application.name=SpringWebMVC_EmployeeRegistrationForm

spring.mvc.view.prefix=/WEB-INF/
spring.mvc.view.suffix=.jsp

server.port=8080
```

---

## 🧩 Code Explanation

### 🔹 Employee.java (Model)

- Lombok `@Data` — generates getters, setters, toString
- `@NoArgsConstructor` — default constructor
- `@AllArgsConstructor` — parameterized constructor
- Fields map directly to HTML form `name` attributes

```java
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    private int    eid;
    private String ename;
    private double esal;
    private String epwd;
    private String edept;
    private String eaddr;
}
```

---

### 🔹 EmployeeController.java

```java
@Controller
public class EmployeeController {

    // SHOW FORM
    @GetMapping("/form")
    public String showForm() {
        return "empReg";
    }

    // SAVE FORM DATA
    @PostMapping("/register")
    public String saveEmployee(
            @ModelAttribute Employee emp,
            Model model) {

        model.addAttribute("empData", emp);

        return "success";
    }
}
```

**`@GetMapping("/form")`** — loads the registration form page

**`@PostMapping("/register")`** — handles form submission

**`@ModelAttribute Employee emp`** — Spring automatically maps each form field to matching `Employee` field by name

**`model.addAttribute("empData", emp)`** — passes bound Employee object to success page

---

### 🔹 empReg.jsp (Registration Form)

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<html>
<head>
    <title>WELCOME TO APP</title>
</head>
<body>
<pre>
    <h2>WELCOME TO REGISTER FORM</h2>

    <form action="register" method="POST">

        ID   : <input type="text"     name="eid"/>
        NAME : <input type="text"     name="ename"/>
        SAL  : <input type="text"     name="esal"/>
        PWD  : <input type="password" name="epwd"/>

        DEPT : <select name="edept">
                    <option value="DEV">DEV</option>
                    <option value="QA">QA</option>
                    <option value="BA">BA</option>
               </select>

        ADDR : <textarea name="eaddr"></textarea>

        <input type="submit" value="CREATE"/>

    </form>
</pre>
</body>
</html>
```

> ⚠️ Form field `name` attributes must exactly match `Employee` field names for `@ModelAttribute` binding to work.

---

### 🔹 success.jsp (Success Page)

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<html>
<head>
    <title>Success Page</title>
</head>
<body>
    <h2>Employee Registered Successfully</h2>
    <hr>
    <h3>ID         : ${empData.eid}</h3>
    <h3>NAME       : ${empData.ename}</h3>
    <h3>SALARY     : ${empData.esal}</h3>
    <h3>PASSWORD   : ${empData.epwd}</h3>
    <h3>DEPARTMENT : ${empData.edept}</h3>
    <h3>ADDRESS    : ${empData.eaddr}</h3>
</body>
</html>
```

---

## 💡 Key Concepts Covered

- `@Controller` — marks class as Spring MVC web controller
- `@GetMapping` — maps HTTP GET request to show form
- `@PostMapping` — maps HTTP POST request to handle form submission
- `@ModelAttribute` — automatically binds HTML form fields to Java object
- `Model` — passes bound object to JSP view
- `model.addAttribute("empData", emp)` — sends employee data to success page
- `${empData.field}` — JSP EL expression to render employee data
- HTML form fields — `input`, `select`, `textarea`, `password`
- Form `action="register" method="POST"` — triggers POST mapping
- Jasper dependency — required for JSP support in embedded Tomcat

---

## 📌 Key Insight

`@ModelAttribute` does automatic form binding:

```
HTML form field name="eid"    →  Employee.eid
HTML form field name="ename"  →  Employee.ename
HTML form field name="esal"   →  Employee.esal
HTML form field name="epwd"   →  Employee.epwd
HTML form field name="edept"  →  Employee.edept
HTML form field name="eaddr"  →  Employee.eaddr
```

Spring reads each `name` attribute from the submitted form and calls the matching setter on the `Employee` object automatically — no manual parsing needed.

---

## 🔗 URL Endpoints

| URL                       | HTTP Method | Action                              |
| ------------------------- | ----------- | ----------------------------------- |
| `localhost:8080/form`     | GET         | Shows employee registration form    |
| `localhost:8080/register` | POST        | Saves form data, shows success page |

---

## ▶️ How to Run

1. Clone the repository
2. Open in STS / IntelliJ / Eclipse
3. Run as Spring Boot Application
4. Open browser and hit:
   ```
   http://localhost:8080/form
   ```
5. Fill the form and click **CREATE**
6. Success page displays all registered employee details

---

## 🧪 Expected Output

**Registration Form** (`/form`):

```
WELCOME TO REGISTER FORM

ID   : [input]
NAME : [input]
SAL  : [input]
PWD  : [password]
DEPT : [DEV / QA / BA]
ADDR : [textarea]
      [CREATE]
```

**Success Page** (`/register` POST):

```
Employee Registered Successfully
─────────────────────────────────
ID         : 101
NAME       : Jatin
SALARY     : 55000.0
PASSWORD   : ••••••
DEPARTMENT : DEV
ADDRESS    : Jaipur
```
