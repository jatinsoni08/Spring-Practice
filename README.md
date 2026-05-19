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

# 🧱 Technologies Used

- Java 17
- Spring Core
- Spring Boot
- Spring Web MVC
- Spring Data JPA
- Hibernate
- MySQL
- JSP
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
