# SpringWebMVCProject_Basic — Spring Web MVC with Model & String View Name

This project demonstrates a cleaner way of handling requests in Spring Web MVC — using **Model** object to pass data and returning **view name as String** directly from the Controller, instead of using `ModelAndView`.

---

## 🚀 Project Overview

A Spring Boot Web MVC application where:

- `OurController` handles HTTP GET request at `/home`
- `Model` object is used to pass data to the JSP view
- Controller returns view name as `String` directly
- View Resolver resolves the string to a physical JSP file
- JSP page renders the data with custom CSS styling

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
├── Application.java                          # Spring Boot main entry point
└── ourcontroller/
    └── OurController.java                    # MVC Controller — handles request

src/main/resources/
└── application.properties                    # View resolver config + server port

src/main/webapp/WEB-INF/MyPages/
└── mypage.jsp                                # JSP view — renders model data with CSS
```

---

## ⚙️ How It Works

1. Client sends HTTP GET request to `/home`
2. **DispatcherServlet** receives the request
3. **Handler Mapper** identifies `OurController.showPage()` method
4. Controller adds data to `Model` object and returns `"mypage"` as String
5. **View Resolver** resolves `"mypage"` → `/WEB-INF/MyPages/mypage.jsp`
6. JSP renders `${msg}` inside a styled box and sends response back to client

---

## 🗄️ application.properties

```properties
spring.application.name=18May_SpringWebMVCProject_Basic

# JSP View Resolver
spring.mvc.view.prefix=/WEB-INF/MyPages/
spring.mvc.view.suffix=.jsp

# Server Port
server.port=9090
```

---

## 🧩 Code Explanation

### 🔹 OurController.java

- `@Controller` — marks class as Spring MVC Controller
- `@GetMapping("/home")` — maps GET request to `showPage()` method
- `Model model` — Spring injects this automatically; used to pass data to view
- Returns `"mypage"` as String — View Resolver resolves it to JSP file

```java
@Controller
public class OurController {

    @GetMapping("/home")
    public String showPage(Model model) {
        return "mypage";
    }
}
```

---

### 🔹 Application.java

```java
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        System.out.println("Spring Boot MVC Project Started...");
    }
}
```

---

### 🔹 mypage.jsp

- Placed inside `/WEB-INF/MyPages/` — not directly accessible via URL
- Renders `${msg}` using JSP EL expression
- Custom CSS with box layout, background color, and blue heading

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>My Page</title>
    <style>
        body {
            font-family: Arial;
            background-color: #f2f2f2;
            text-align: center;
            padding-top: 100px;
        }
        .box {
            background: white;
            width: 500px;
            margin: auto;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0px 0px 10px gray;
        }
        h1 {
            color: blue;
        }
    </style>
</head>
<body>
    <div class="box">
        <h1>${msg}</h1>
        <h2>Spring Boot MVC + JSP Working Successfully</h2>
    </div>
</body>
</html>
```

---

## 💡 Key Concepts Covered

- `@Controller` — Spring MVC web controller
- `@GetMapping` — maps GET request to handler method
- `Model` — Spring-managed object to pass data from Controller to View
- Returning `String` from controller — cleaner alternative to `ModelAndView`
- `spring.mvc.view.prefix` — JSP file location
- `spring.mvc.view.suffix` — JSP file extension
- **View Resolver** — resolves logical view name to physical JSP path
- `${msg}` — JSP EL expression to render model data
- Custom CSS in JSP — box layout with shadow and styling

---

## 📌 Key Insight

Two ways to return response from Controller:

```java
// Way 1 — ModelAndView (previous project)
ModelAndView mav = new ModelAndView();
mav.addObject("msg", "Hello");
mav.setViewName("mypage");
return mav;

// Way 2 — Model + String (this project) ✔ cleaner
public String showPage(Model model) {
    model.addAttribute("msg", "Hello");
    return "mypage";
}
```

View Resolver resolves:

```
"mypage"  →  /WEB-INF/MyPages/ + mypage + .jsp  →  /WEB-INF/MyPages/mypage.jsp
```

---

## ▶️ How to Run

1. Clone the repository
2. Open in STS / IntelliJ / Eclipse
3. Run as Spring Boot Application
4. Console prints: `Spring Boot MVC Project Started...`
5. Open browser and hit:
   ```
   http://localhost:9090/home
   ```

---

## 🧪 Expected Output

Browser displays a styled white box with:

```
${msg}
Spring Boot MVC + JSP Working Successfully
```
