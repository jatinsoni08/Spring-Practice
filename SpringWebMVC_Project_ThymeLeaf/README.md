# SpringBoot_Thymeleaf_Intro — Spring Boot with Thymeleaf, CSS & JavaScript

This project demonstrates how **Thymeleaf** works as a lightweight UI engine in Spring Boot — replacing JSP. It covers reading model data in HTML using Thymeleaf expressions, linking external CSS and JavaScript files via `th:href` and `th:src`.

---

## 🚀 Project Overview

A Spring Boot Web application where:

- `ProductController` passes product data to Thymeleaf view via `Model`
- `productData.html` renders data using Thymeleaf `th:text` expressions
- External `design.css` is linked using `th:href="@{/myCSS/design.css}"`
- External `javascript.js` is linked using `th:src="@{/myJS/javascript.js}"`
- No JSP, no Jasper — Thymeleaf handles everything as plain HTML

---

## 🧱 Technologies Used

- Java 17
- Spring Boot
- Thymeleaf (`spring-boot-starter-thymeleaf`)
- HTML + CSS + JavaScript
- Maven

---

## 📁 Project Structure

```
src/main/java/com/app/jatin/
├── Application.java                          # Spring Boot main entry point
└── controller/
    └── ProductController.java                # MVC Controller — passes product data

src/main/resources/
├── templates/
│   └── productData.html                      # Thymeleaf view — renders product data
└── static/
    ├── myCSS/
    │   └── design.css                        # External CSS — body, h2, .mydesign styles
    └── myJS/
        └── javascript.js                     # External JS — alert on page load
```

---

## ⚙️ How It Works

1. Client hits `GET /product/data`
2. `ProductController.showData()` adds product attributes to `Model`
3. Returns `"productData"` — Thymeleaf resolves to `/templates/productData.html`
4. Thymeleaf engine processes `th:text`, `th:href`, `th:src` tags
5. CSS styles are applied, JS alert fires, product data renders on page

---

## 🧩 Code Explanation

### 🔹 ProductController.java

- `@Controller` — marks class as Spring MVC Controller
- `@RequestMapping("/product")` — base URL for all methods in this class
- `@GetMapping("/data")` — maps GET `/product/data` to `showData()`
- Adds `pId`, `pName`, `pPrice` to Model

```java
@Controller
@RequestMapping("/product")
public class ProductController {

    @GetMapping("/data")
    public String showData(Model model) {

        model.addAttribute("pId",    101);
        model.addAttribute("pName",  "Laptop");
        model.addAttribute("pPrice", 55000);

        return "productData";
    }
}
```

---

### 🔹 productData.html (Thymeleaf View)

- `xmlns:th="http://www.thymeleaf.org"` — Thymeleaf namespace declaration
- `th:href="@{/myCSS/design.css}"` — links external CSS from `/static/myCSS/`
- `th:src="@{/myJS/javascript.js}"` — links external JS from `/static/myJS/`
- `th:text="${pId}"` — renders model attribute value in span

```html
<html xmlns:th="http://www.thymeleaf.org">
  <head>
    <title>WEB APP</title>

    <!-- To Link with CSS -->
    <link rel="stylesheet" th:href="@{/myCSS/design.css}" />

    <!-- To Link with JS file -->
    <script type="text/javascript" th:src="@{/myJS/javascript.js}"></script>
  </head>
  <body>
    <h2>Welcome To SpringBoot + Thymeleaf</h2>

    <p class="mydesign">SAMPLE CSS</p>

    <!-- Data Read -->
    <p>This is Product Id : <span th:text="${pId}"></span></p>
    <p>This is Product Name : <span th:text="${pName}"></span></p>
    <p>This is Product Price : <span th:text="${pPrice}"></span></p>
  </body>
</html>
```

---

### 🔹 design.css

```css
body {
  background-color: lightyellow;
  font-family: Arial;
}

h2 {
  color: blue;
}

.mydesign {
  color: red;
  font-size: 20px;
}
```

---

### 🔹 javascript.js

```javascript
alert("JS File Loaded");
```

---

## 💡 Key Concepts Covered

- `spring-boot-starter-thymeleaf` — auto-configures Thymeleaf engine
- Default prefix — `src/main/resources/templates/`
- Default suffix — `.html`
- No extra configuration needed in `application.properties`
- `th:text="${key}"` — reads and renders model data
- `th:href="@{/path}"` — links CSS file from `/static/` folder
- `th:src="@{/path}"` — links JS file from `/static/` folder
- `@` symbol — used for URL/path resolution in Thymeleaf
- `$` symbol — used to read data from Model/ModelMap/Map
- `xmlns:th` — Thymeleaf namespace declaration in HTML tag
- `static/` folder — stores CSS, JS, images (served directly)
- `templates/` folder — stores Thymeleaf HTML view files

---

## 📌 JSP vs Thymeleaf

| Feature          | JSP                              | Thymeleaf                 |
| ---------------- | -------------------------------- | ------------------------- |
| Type             | Heavy (Servlet-based)            | Lightweight (Core Java)   |
| File Extension   | `.jsp`                           | `.html`                   |
| Processing       | Entire file converted to Servlet | Only `th:` tags processed |
| Extra Dependency | Jasper required                  | None — auto-configured    |
| Static Content   | Also converted to Servlet code   | Stays as plain HTML       |
| Default Location | `/WEB-INF/`                      | `/templates/`             |

---

## 📌 Thymeleaf 3 Main Symbols

| Symbol | Purpose               | Example                          |
| ------ | --------------------- | -------------------------------- |
| `$`    | Read data from Model  | `th:text="${pName}"`             |
| `@`    | URL / Path / Location | `th:href="@{/myCSS/design.css}"` |
| `*`    | Form input binding    | `th:field="*{empName}"`          |

---

## ▶️ How to Run

1. Clone the repository
2. Open in STS / IntelliJ / Eclipse
3. Run as Spring Boot Application
4. Open browser and hit:
   ```
   http://localhost:8080/product/data
   ```

---

## 🧪 Expected Output

Browser displays:

```
Welcome To SpringBoot + Thymeleaf   ← blue heading

SAMPLE CSS                           ← red, font-size 20px

This is Product Id    : 101
This is Product Name  : Laptop
This is Product Price : 55000
```

JS alert fires on page load:

```
JS File Loaded
```
