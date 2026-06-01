# Spring Practice Repository

This repository contains my structured hands-on learning journey of the Spring Framework and Spring Boot, focused on understanding core concepts through practical implementations and mini-projects.

---

## 🚀 Repository Overview

This repository covers:

- Spring Core Fundamentals
- Dependency Injection (DI)
- Inversion of Control (IoC)
- XML-Based Configuration
- Annotation-Based Configuration
- Component Scanning
- Autowiring
- Spring Boot Basics
- External Configuration Handling
- CommandLineRunner & Startup Logic
- Spring Data JPA & Database Integration
- Full CRUD Operations
- Spring Web MVC & Request Handling
- Thymeleaf UI Engine
- REST API Development

Each project is built step-by-step to strengthen real understanding of how Spring works internally.

---

# 📂 Projects

---

## 1️⃣ Spring Core — XML Configuration

### 📌 Concepts Covered

- Bean creation using XML
- Setter Injection
- ApplicationContext usage
- Understanding IoC Container
- Dependency Injection basics

🔗 Repository Link:  
https://github.com/jatinsoni08/Spring-Practice/tree/main/Spring-Core-XML-Configuration

---

## 2️⃣ Spring Core — Collection Type Dependency Injection

### 📌 Concepts Covered

- Injecting collections using XML
- List Injection
- Set Injection
- Map Injection
- Handling multiple values inside beans

🔗 Repository Link:  
https://github.com/jatinsoni08/Spring-Practice/tree/main/SpringCore_CollectionTypeDependencies

---

## 3️⃣ Spring Core — Reference Type Dependency Injection

### 📌 Concepts Covered

- Bean-to-bean injection
- HAS-A relationship
- Using `<ref>` tag
- Loose coupling concepts
- Object dependency management

🔗 Repository Link:  
https://github.com/jatinsoni08/Spring-Practice/tree/main/SpringCore_ReferenceTypeDependencies

---

## 4️⃣ Spring Core — @Component Annotation (Manual Container)

### 📌 Concepts Covered

- Bean creation using `@Component`
- Default and custom bean naming
- `@Value` annotation
- Manual container initialization
- Using `scan()` and `refresh()`

🔗 Repository Link:  
https://github.com/jatinsoni08/Spring-Practice/tree/main/SpringAnnotationConfig_Component

---

## 5️⃣ Spring Core — @ComponentScan (Base Package & Multi-Package)

### 📌 Concepts Covered

- Automatic bean scanning
- Base package scanning
- Multi-package scanning
- Eliminating manual scanning
- Configuration-based container setup

🔗 Repository Link:  
https://github.com/jatinsoni08/Spring-Practice/tree/main/SpringBasePackageDemo

---

## 6️⃣ Spring Core — @Autowired (Basic Dependency Injection)

### 📌 Concepts Covered

- Automatic dependency injection
- `@Autowired` basics
- Bean linking
- HAS-A relationship
- Spring-managed object creation

🔗 Repository Link:  
https://github.com/jatinsoni08/Spring-Practice/tree/main/SpringCore_AutoWiredBasic_EG

---

## 7️⃣ Spring Core — @Autowired (Multiple Beans & Ambiguity)

### 📌 Concepts Covered

- Interface-based injection
- Multiple bean conflict
- Ambiguity problem
- Introduction to `@Qualifier`
- Introduction to `@Primary`

🔗 Repository Link:  
https://github.com/jatinsoni08/Spring-Practice/tree/main/SpringCore_Autowired_Cases

---

## 8️⃣ Spring Core — Manual Dependency Injection (Without Spring Container)

### 📌 Concepts Covered

- Manual Dependency Injection
- Programming to interfaces
- Setter Injection
- Constructor Injection
- Loose coupling without Spring
- Understanding what Spring automates internally

🔗 Repository Link:  
https://github.com/jatinsoni08/Spring-Practice/tree/main/SpringCore_UnderstandingWithCoreJava

---

## 9️⃣ Spring Boot — CommandLineRunner & @Order

### 📌 Concepts Covered

- `CommandLineRunner`
- Startup execution logic
- Multiple runner classes
- `@Order` annotation
- Automatic execution after application startup

🔗 Repository Link:  
https://github.com/jatinsoni08/Spring-Practice/tree/main/SpringBootCoreRunnersEx

---

## 🔟 Spring Boot — @ConfigurationProperties

### 📌 Concepts Covered

- External configuration handling
- `application.properties`
- `@ConfigurationProperties`
- Automatic property binding
- Configuration bean creation

🔗 Repository Link:  
https://github.com/jatinsoni08/Spring-Practice/tree/main/SpringBootCoreConfigPropsEx

---

## 1️⃣1️⃣ Spring Boot — Reading Input from application.properties

### 📌 Concepts Covered

- Reading custom properties
- POJO binding
- Externalized configuration
- Bean injection
- Property mapping

🔗 Repository Link:  
https://github.com/jatinsoni08/Spring-Practice/tree/main/SpringBootCoreInputEx-1

---

## 1️⃣2️⃣ Spring Boot — YAML Configuration & Input Handling

### 📌 Concepts Covered

- `application.yml`
- YAML structure
- Hierarchical configuration
- Property binding
- Spring Boot configuration management

🔗 Repository Link:  
https://github.com/jatinsoni08/Spring-Practice/tree/main/SpringBootCoreInputEx-2

---

## 1️⃣3️⃣ Spring Boot — Data JPA with MySQL

### 📌 Concepts Covered

- Spring Data JPA integration
- Entity mapping with `@Entity` and `@Table`
- Field-to-column mapping using `@Id` and `@Column`
- `CrudRepository` for built-in CRUD operations
- Auto table creation with `ddl-auto=create`
- MySQL datasource configuration
- Lombok `@Data` for boilerplate reduction
- `CommandLineRunner` to execute DB operations on startup

🔗 Repository Link:  
https://github.com/jatinsoni08/Spring-Practice/tree/main/SpringBoot_DataJPA_ProjectExample

---

## 1️⃣4️⃣ Spring Boot — Full CRUD Operations with Spring Data JPA

### 📌 Concepts Covered

- Complete CRUD — Insert, Fetch, Update, Delete
- `saveAll()` for inserting multiple records
- `findAll()` for fetching all records
- `findById()` with `Optional` for null-safe fetch
- `save()` for updating existing record
- `deleteById()` for deleting by primary key
- `ddl-auto=update` to persist data across runs
- `format_sql=true` for formatted SQL in console
- Lombok `@NoArgsConstructor` and `@AllArgsConstructor`

🔗 Repository Link:  
https://github.com/jatinsoni08/Spring-Practice/tree/main/SpringDATAJPA_EmployeeCRUDProject

---

## 1️⃣5️⃣ Spring Web MVC — ModelAndView with JSP

### 📌 Concepts Covered

- Spring Web MVC architecture overview
- `DispatcherServlet` as Front Controller
- `HandlerMapper` for request-to-controller mapping
- `@Controller` annotation
- `@GetMapping` for HTTP GET request mapping
- `ModelAndView` — carries both data and view name
- JSP View Resolver configuration
- `spring.mvc.view.prefix` and `spring.mvc.view.suffix`
- Jasper dependency for JSP support in embedded Tomcat

🔗 Repository Link:  
https://github.com/jatinsoni08/Spring-Practice/tree/main/SpringWebMVC_Project_UsingMVC

---

## 1️⃣6️⃣ Spring Web MVC — Model with String View Name & JSP

### 📌 Concepts Covered

- `Model` object for passing data to view
- Returning view name as `String` from Controller
- Cleaner alternative to `ModelAndView`
- Custom JSP page with CSS styling
- View Resolver with custom prefix path `/WEB-INF/MyPages/`
- JSP EL expression `${msg}` for rendering model data
- Server port configuration

🔗 Repository Link:  
https://github.com/jatinsoni08/Spring-Practice/tree/main/SpringWebMVCProject_UsingString

---

## 1️⃣7️⃣ Spring Web MVC — Model, Map & ModelMap for Data Transfer

### 📌 Concepts Covered

- `Model` interface — `addAttribute()` to pass key-value data to view
- `Map<String, Object>` interface — `put()` to pass key-value data to view
- `ModelMap` class — extends `LinkedHashMap`, `addAttribute()` to pass data
- All three interchangeable — Spring injects `BindingAwareModelMap` internally
- Passing single object to JSP using `model.addAttribute("obj", user)`
- Passing multiple objects using `List<User>` to JSP
- `<c:forEach>` JSTL tag to iterate and render list in JSP table
- JSP EL expression `${key}` and `${obj.field}` for dynamic rendering
- `@RequestMapping(value, method)` — class and method level URL mapping
- Jasper + JSTL dependencies for JSP support
- Lombok `@Data`, `@NoArgsConstructor`, `@AllArgsConstructor` on bean class

🔗 Repository Link:  
https://github.com/jatinsoni08/Spring-Practice/tree/main/SpringWebMVC_Model_Map_ModelMap

---

## 1️⃣8️⃣ Spring Web MVC — HTML Form Handling with @ModelAttribute

### 📌 Concepts Covered

- `@GetMapping` — loads HTML registration form on GET request
- `@PostMapping` — handles form submission on POST request
- `@ModelAttribute` — automatically binds HTML form fields to Java object
- Form field `name` attribute must match Java model field name for auto-binding
- `Model.addAttribute()` — passes bound object to success JSP page
- `${empData.field}` — JSP EL expression to render employee data on success page
- HTML form elements — `input`, `password`, `select`, `textarea`, `submit`
- `form action="register" method="POST"` — triggers POST mapping
- Jasper dependency for JSP support in embedded Tomcat
- Lombok `@Data`, `@NoArgsConstructor`, `@AllArgsConstructor` on Employee model

🔗 Repository Link:  
https://github.com/jatinsoni08/Spring-Practice/tree/main/SpringWebMVC_EmployeeRegistrationForm

---

## 1️⃣9️⃣ Spring Web MVC — Thymeleaf with CSS & JavaScript

### 📌 Concepts Covered

- Thymeleaf as lightweight UI engine — alternative to JSP
- `spring-boot-starter-thymeleaf` — auto-configures Thymeleaf, no extra properties needed
- Default prefix `/templates/` and default suffix `.html`
- `xmlns:th="http://www.thymeleaf.org"` — Thymeleaf namespace declaration
- `th:text="${key}"` — reads and renders model data in HTML
- `th:href="@{/path}"` — links external CSS from `/static/` folder
- `th:src="@{/path}"` — links external JS from `/static/` folder
- `$` symbol — read data from Model/ModelMap/Map
- `@` symbol — URL/Path/Location resolution
- `*` symbol — form input binding (introduced)
- `static/` folder — stores CSS, JS, images
- `templates/` folder — stores Thymeleaf HTML view files
- `@RequestMapping` at class level + `@GetMapping` at method level

🔗 Repository Link:  
https://github.com/jatinsoni08/Spring-Practice/tree/main/SpringWebMVC_Project_ThymeLeaf

---

## 2️⃣0️⃣ Spring Boot — REST API Basics with @RestController

### 📌 Concepts Covered

- `@RestController` — combination of `@Controller` + `@ResponseBody`
- Returns **JSON response** directly — no view page needed
- `@GetMapping` — fetch data, returns JSON list to client
- `@PostMapping` — receive data from client as JSON
- `@RequestBody` — automatically converts incoming JSON to Java object
- Jackson library — handles JSON to Java and Java to JSON conversion
- `List.of()` — immutable list for static data
- `new ArrayList<>()` — mutable list for dynamic add/remove
- Postman — testing GET and POST REST APIs
- `200 OK` — successful HTTP response status
- `@Controller` vs `@RestController` — web page vs JSON response

🔗 Repository Link:  
https://github.com/jatinsoni08/Spring-Practice/tree/main/SpringBoot_RESTBasicProject

---

## 2️⃣1️⃣ Spring Boot — REST API with @RequestParam, @PathVariable & ResponseEntity

### 📌 Concepts Covered

- `@RequestParam` — reads data from query string `?key=value`
- `@PathVariable` — reads data from URL path segments `/{variable}`
- Difference between `@RequestParam` and `@PathVariable` — when to use which
- `ResponseEntity<T>` — full control over HTTP response body and status code
- `HttpStatus.OK` — 200, `HttpStatus.CREATED` — 201, `HttpStatus.NOT_FOUND` — 404
- `new ResponseEntity<>(body, HttpStatus)` — creating custom HTTP responses
- `@RequestMapping` at class level + `@GetMapping` at method level
- URL format difference — `/dataa?pid=10&pname=A` vs `/datab/10/A`

🔗 Repository Link:  
https://github.com/jatinsoni08/Spring-Practice/tree/main/SpringBoot_RESTPathVariable_EG

---

## 2️⃣2️⃣ Spring Boot — @ResponseBody, @JsonProperty & @JsonIgnore in REST API

### 📌 Concepts Covered

- `@ResponseBody` — converts Java object to JSON and writes to HTTP response body
- `@RequestBody` — converts JSON to Java object from HTTP request body
- `@RestController` = `@Controller` + `@ResponseBody` — auto-applied to all methods
- `@JsonProperty("custom-name")` — gives custom key name to field in JSON output
- `@JsonIgnore` — excludes sensitive field (like password) from JSON response
- Returning `Object`, `List<T>`, `Map<K,V>` from REST endpoints as JSON
- `ResponseEntity<T>` — wraps response with body and HTTP status code
- Jackson — auto-configured library handling all JSON conversions
- Only JSON supported by default — XML needs extra dependency

🔗 Repository Link:  
https://github.com/jatinsoni08/Spring-Practice/tree/main/SpringBoot_ResponseBody

---

## 2️⃣3️⃣ Spring Security — Default Behavior, Session ID & CSRF Token

### 📌 Concepts Covered

- Spring Security default behavior — auto login form and auto-generated password
- Custom credentials via `spring.security.user.name` and `spring.security.user.password`
- `Authentication` — verifying identity (who you are)
- `Authorization` — verifying permissions (what you can do)
- Authenticated ≠ Authorized — key difference
- Session ID — stateful communication between client and server
- `JSESSIONID` stored in browser cookie — same per session
- CSRF Token (Cross-Site Request Forgery) — different per request
- GET requests accessible without CSRF token
- POST, PUT, DELETE require CSRF token in request header
- `HttpServletRequest.getSession().getId()` — exposing Session ID
- `request.getAttribute("_csrf")` — exposing CSRF Token
- `401 Unauthorized` vs `403 Forbidden` — difference explained
- Basic Auth in Postman for testing secured REST APIs
- 3 ways Spring resolves credentials — Config Class → application.properties → Console default

🔗 Repository Link:  
https://github.com/jatinsoni08/Spring-Practice/tree/main/01SpringSecurity-BaiscProject

---

# 🧱 Technologies Used

- Java 17
- Spring Core
- Spring Boot
- Spring Web MVC
- Spring Data JPA
- Hibernate
- MySQL
- JSP
- Thymeleaf
- Lombok
- Maven

---

# 💡 Key Learning Focus

- Inversion of Control (IoC)
- Dependency Injection (DI)
- Spring Container
- Bean Management
- XML Configuration
- Annotation Configuration
- Component Scanning
- Autowiring
- Spring Boot Fundamentals
- External Configuration
- YAML Configuration
- Startup Runners
- Spring Data JPA
- Entity Mapping
- Database Integration
- Full CRUD Operations
- Optional Handling
- Loose Coupling
- Spring Web MVC Architecture
- DispatcherServlet & Request Flow
- ModelAndView & Model
- JSP View Rendering
- View Resolver Configuration
- Thymeleaf UI Engine
- Static Resource Linking (CSS & JS)
- JSP vs Thymeleaf
- REST API Development
- @RestController & @RequestBody
- JSON Serialization & Deserialization
- API Testing with Postman

---

# 📈 Learning Approach

- Step-by-step concept building
- Practical implementation of each topic
- Concept-first learning
- Structured mini-projects
- Real understanding over memorization

---

# 🙏 Acknowledgment

A special thanks to Prasoon Bidua Sir and REGex Software Services for making Spring concepts practical, understandable, and industry-oriented through hands-on learning.
