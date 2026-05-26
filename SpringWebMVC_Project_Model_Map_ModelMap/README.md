# SpringWebMVC_Model_Map_ModelMap — Spring Web MVC Data Transfer using Model, Map & ModelMap

This project demonstrates three different ways to pass data from a Spring MVC Controller to a JSP view — using **Model** interface, **Map** interface, and **ModelMap** class. It also covers sending both a single object and a list of objects to the UI.

---

## 🚀 Project Overview

A Spring Boot Web MVC application where:

- `UserController` handles multiple GET requests using `@GetMapping` and `@RequestMapping`
- Data is passed to JSP views using **Model**, **Map**, and **ModelMap**
- A `User` bean is created using **Lombok** annotations
- Single user object and multiple user objects (List) are sent to JSP
- JSP pages render data using **EL expressions** and **JSTL `<c:forEach>`**

---

## 🧱 Technologies Used

- Java 17
- Spring Boot
- Spring Web MVC
- JSP (Jakarta Server Pages)
- JSTL
- Lombok
- Maven

---

## 📁 Project Structure

```
src/main/java/com/app/jatin/
├── SpringBootWebMvcApplication.java          # Spring Boot main entry point
├── bean/
│   └── User.java                             # User bean with Lombok annotations
└── controller/
    └── UserController.java                   # MVC Controller — 4 handler methods

src/main/resources/
└── application.properties                    # View resolver config + server port

src/main/webapp/WEB-INF/
├── userHome.jsp                              # JSP view — single user + key-value data
└── userData.jsp                              # JSP view — multiple users in table
```

---

## ⚙️ How It Works

1. Client sends GET request to one of the mapped URLs
2. **DispatcherServlet** receives and routes the request
3. **HandlerMapper** identifies the correct method in `UserController`
4. Controller adds data via `Model` / `Map` / `ModelMap` and returns view name as String
5. **ViewResolver** resolves view name → physical JSP file location
6. JSP renders data using `${key}` EL expressions and `<c:forEach>` for lists

---

## 🗄️ application.properties

```properties
spring.application.name=SpringWebMVC_Model_Map_ModelMap

spring.mvc.view.prefix=/WEB-INF/
spring.mvc.view.suffix=.jsp

server.port=9191
```

---

## 🧩 Code Explanation

### 🔹 User.java (Bean)

- Lombok `@Data` — generates getters, setters, toString
- `@NoArgsConstructor` — default constructor
- `@AllArgsConstructor` — parameterized constructor

```java
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Integer id;
    private String userName;
    private String userRole;
}
```

---

### 🔹 UserController.java — 4 Methods

#### Method 1 — Using Model (key-value data)

```java
// USING MODEL
@GetMapping("/info")
public String showHomePage(Model model) {

    model.addAttribute("userName", "Jatin");
    model.addAttribute("courseName", "Spring MVC");

    return "userHome";
}
```

---

#### Method 2 — Using Map (key-value data)

```java
// USING MAP
@GetMapping("/map")
public String mapData(Map<String, Object> map) {

    map.put("trainer", "Jatin");
    map.put("technology", "Spring MVC");

    return "userHome";
}
```

---

#### Method 3 — Using ModelMap (key-value data)

```java
// USING MODELMAP
@GetMapping("/modelmap")
public String modelMapData(ModelMap map) {

    map.addAttribute("framework", "Spring MVC");
    map.addAttribute("version", "3.x");

    return "userHome";
}
```

---

#### Method 4 — Single User Object

```java
// SINGLE OBJECT
@GetMapping("/single")
public String singleUser(Model model) {

    User user = new User(1, "Prasoon", "Team Lead");

    model.addAttribute("obj", user);

    return "userData";
}
```

---

#### Method 5 — Multiple User Objects (List)

```java
// MULTIPLE OBJECTS
@GetMapping("/all")
public String allUsers(Model model) {

    List<User> list = Arrays.asList(
        new User(1, "Ram",      "Software Engineer"),
        new User(2, "Ramesh",   "Software Engineer"),
        new User(3, "Shyam",    "Tester"),
        new User(4, "Ashutosh", "QA")
    );

    model.addAttribute("userData", list);

    return "userData";
}
```

---

### 🔹 userHome.jsp

Displays single key-value data from Model / Map / ModelMap:

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Home</title>
</head>
<body>
    <h1>Welcome To Spring MVC</h1>
    <h2>Hello : ${userName}</h2>
    <h3>Your Course : ${courseName}</h3>
    <h3>Trainer : ${trainer}</h3>
    <h3>Technology : ${technology}</h3>
    <h3>Framework : ${framework}</h3>
    <h3>Version : ${version}</h3>
</body>
</html>
```

---

### 🔹 userData.jsp

Displays single user object and multiple users in a table using JSTL:

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Data</title>
</head>
<body>
    <h1>Single User Data</h1>
    <h3>ID   : ${obj.id}</h3>
    <h3>Name : ${obj.userName}</h3>
    <h3>Role : ${obj.userRole}</h3>

    <hr>

    <h1>Multiple Users</h1>
    <table border="1" cellpadding="10">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Role</th>
        </tr>
        <c:forEach items="${userData}" var="ob">
            <tr>
                <td>${ob.id}</td>
                <td>${ob.userName}</td>
                <td>${ob.userRole}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
```

---

## 💡 Key Concepts Covered

- `@Controller` — marks class as Spring MVC Controller
- `@GetMapping` — maps GET request to handler method
- `@RequestMapping(value, method)` — legacy URL + method mapping
- `Model` — interface; `addAttribute(key, value)` to pass data
- `Map<String, Object>` — generic interface; `put(key, value)` to pass data
- `ModelMap` — class extending LinkedHashMap; `addAttribute(key, value)`
- All three are interchangeable — Spring injects `BindingAwareModelMap` internally
- Single object passing via `model.addAttribute("obj", user)`
- List passing via `model.addAttribute("userData", list)`
- `${key}` — JSP EL expression to render model data
- `<c:forEach>` — JSTL tag to iterate over list in JSP
- Jasper dependency — required for JSP support in embedded Tomcat
- JSTL dependency — required for `<c:forEach>` and other JSTL tags

---

## 📌 Key Insight

Three ways to pass data from Controller to View — all work the same:

```java
// Model (Interface)
model.addAttribute("key", value);

// Map (Interface)
map.put("key", value);

// ModelMap (Class — extends LinkedHashMap)
map.addAttribute("key", value);
```

Spring internally injects `BindingAwareModelMap` for all three.
Always prefer **interface** (Model / Map) over concrete class for loose coupling.

---

## 🔗 URL Endpoints

| URL                       | Method Used  | Returns      |
| ------------------------- | ------------ | ------------ |
| `localhost:9191/info`     | Model        | userHome.jsp |
| `localhost:9191/map`      | Map          | userHome.jsp |
| `localhost:9191/modelmap` | ModelMap     | userHome.jsp |
| `localhost:9191/single`   | Model        | userData.jsp |
| `localhost:9191/all`      | Model + List | userData.jsp |

---

## ▶️ How to Run

1. Clone the repository
2. Open in STS / IntelliJ / Eclipse
3. Run as Spring Boot Application
4. Open browser and hit any of the URLs above

---

## 🧪 Expected Output

**`/info`** → `Hello: Jatin`, `Your Course: Spring MVC`

**`/single`** → `ID: 1`, `Name: Prasoon`, `Role: Team Lead`

**`/all`** → Table with 4 users — Ram, Ramesh, Shyam, Ashutosh
