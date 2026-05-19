# SpringWebMVC_Project_UsingMVC — Spring Web MVC with ModelAndView

This project demonstrates how Spring Web MVC handles HTTP requests and returns responses using **ModelAndView** — the classic way of sending data from Controller to a JSP view page.

---

## 🚀 Project Overview

A Spring Boot Web MVC application where:

- `HelloController` handles incoming HTTP GET request
- `ModelAndView` object carries both **data** and **view name**
- JSP page renders the data sent from Controller
- View Resolver resolves the logical view name to physical JSP file

---

## 🧱 Technologies Used

- Java 17
- Spring Boot
- Spring Web MVC
- JSP (Jakarta Server Pages)
- Maven

---

## 📁 Project Structure

```
src/main/java/com/app/jatin/
├── SpringWebMvcProjectUsingMvcApplication.java   # Spring Boot main entry point
└── controller/
    └── HelloController.java                      # MVC Controller — handles request

src/main/resources/
└── application.properties                        # View resolver config + server port

src/main/webapp/WEB-INF/
└── home.jsp                                      # JSP view — renders model data
```

---

## ⚙️ How It Works

1. Client sends HTTP GET request to `/`
2. **DispatcherServlet** (Front Controller) receives the request
3. **Handler Mapper** identifies `HelloController.showMessage()` method
4. Controller creates `ModelAndView` object — adds data and sets view name
5. **View Resolver** resolves `"home"` → `/WEB-INF/home.jsp`
6. JSP renders `${msg}` and sends response back to client

---

## 🗄️ application.properties

```properties
spring.application.name=SpringWebMVC_Project_UsingMVC

spring.mvc.view.prefix=/WEB-INF/
spring.mvc.view.suffix=.jsp

server.port=7878
```

---

## 🧩 Code Explanation

### 🔹 HelloController.java

- Annotated with `@Controller` — marks class as Spring MVC Controller
- `@GetMapping("/")` — maps HTTP GET request to `showMessage()` method
- Creates `ModelAndView` object, adds data and view name, returns it

```java
@Controller
public class HelloController {

    @GetMapping("/")
    public ModelAndView showMessage() {

        // Create object
        ModelAndView mav = new ModelAndView();

        // Sending data to JSP
        mav.addObject("msg", "Welcome To Spring MVC");

        // JSP page name
        mav.setViewName("home");

        return mav;
    }
}
```

---

### 🔹 home.jsp

- Placed inside `/WEB-INF/` — not directly accessible via URL
- Fetches model data using `${msg}` — JSP EL expression

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<html>
<head>
    <title>Home Page</title>
</head>
<body>
    <h2>${msg}</h2>
</body>
</html>
```

---

## 💡 Key Concepts Covered

- `@Controller` — marks class as Spring MVC web controller
- `@GetMapping` — maps GET request to handler method
- `ModelAndView` — carries both model data and logical view name
- `mav.addObject("key", value)` — adds data to model
- `mav.setViewName("name")` — sets logical view name
- `spring.mvc.view.prefix` — defines view file location
- `spring.mvc.view.suffix` — defines view file type (`.jsp`)
- **View Resolver** — resolves logical name to physical JSP path
- `${msg}` — JSP EL expression to render model data
- **DispatcherServlet** — Front Controller that manages entire request-response flow

---

## 📌 Key Insight

`ModelAndView` carries two things together:

```
Model  → Data  (key-value pairs added via addObject())
View   → Page  (logical name set via setViewName())
```

View Resolver then resolves:

```
"home"  →  /WEB-INF/ + home + .jsp  →  /WEB-INF/home.jsp
```

---

## 🔄 Spring MVC Request Flow

```
Client
  ↓ HTTP Request
DispatcherServlet (Front Controller)
  ↓
Handler Mapper → identifies HelloController.showMessage()
  ↓
HelloController → returns ModelAndView (data + view name)
  ↓
View Resolver → resolves "home" → /WEB-INF/home.jsp
  ↓
JSP View → renders ${msg}
  ↓ HTTP Response
Client sees → Welcome To Spring MVC
```

---

## ▶️ How to Run

1. Clone the repository
2. Open in STS / IntelliJ / Eclipse
3. Run as Spring Boot Application
4. Open browser and hit:
   ```
   http://localhost:7878/
   ```
5. Output: **Welcome To Spring MVC**

---

## 🧪 Expected Output

Browser displays:

```
Welcome To Spring MVC
```
