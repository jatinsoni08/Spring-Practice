# 01SpringSecurityProject — Spring Security: Default Behavior + Custom Configuration + In-Memory Authentication

This project covers **3 sessions of Spring Security** — from understanding default behavior to writing a custom `SecurityConfiguration` class with multiple in-memory users, stateless sessions, and disabled CSRF protection.

---

## 🚀 Project Overview

### Session 1 & 2 — Default Behavior

- REST endpoints created for Employee GET and POST
- Spring Security dependency added → **auto login form + auto-generated password**
- Session ID demonstrated via `HttpServletRequest` → proves **Stateful** behavior
- CSRF Token exposed and passed in Postman header for POST requests
- Custom credentials set via `application.properties`

### Session 3 — Custom Security Configuration

- Custom `SecurityConfiguration` class written with `@Configuration` + `@EnableWebSecurity`
- CSRF protection **disabled** → POST requests work without CSRF token
- HTTP Basic Auth **enabled** → Postman can access APIs directly
- Session management set to **STATELESS** → no session stored on server
- Two **in-memory users** hardcoded with different roles:
  - `jatin` / `hello` → **ADMIN**
  - `prasson` / `bidua` → **USER**
- Old `application.properties` credentials no longer work → custom config takes priority

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
├── Application.java
├── model/
│   └── Employee.java                        # Employee model with Lombok
├── restcontroller/
│   └── EmployeeRestController.java          # REST Controller — 5 endpoints
└── config/
    └── SecurityConfiguration.java           # Custom Security Config (Session 3)
```

---

## ⚙️ application.properties

```properties
spring.application.name=01SpringSecurityProject

# These are overridden by SecurityConfiguration class
# spring.security.user.name=jatin
# spring.security.user.password=jatin123
```

> Once `SecurityConfiguration` class is present with `@Configuration` + `@EnableWebSecurity`,
> Spring ignores `application.properties` credentials and uses the config class instead.

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

### 🔹 EmployeeRestController.java

```java
@RestController
public class EmployeeRestController {

    List<Employee> list = new ArrayList<>(List.of(
        new Employee(1, "Jatin",      "Jaipur"),
        new Employee(2, "Sumit",      "Indore"),
        new Employee(1, "BePositive", "Kota")
    ));

    @GetMapping("/get-employee")
    public List<Employee> getAllEmployee() { return list; }

    @PostMapping("/add-employee")
    public void addEmployee(@RequestBody Employee employee) {
        list.add(employee);
        System.out.println(list);
    }

    @GetMapping("/get-info")
    public String getCourseInfo(HttpServletRequest request) {
        return "Jatin Soni JAVA Course" + request.getSession().getId();
    }

    @GetMapping("/get-moreinfo")
    public String getCourseMoreInfo(HttpServletRequest request) {
        return "Its a 10 month course" + request.getSession().getId();
    }

    @GetMapping("/get-csrf")
    public CsrfToken getCsrfToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
    }
}
```

---

### 🔹 SecurityConfiguration.java (Session 3 — Key File)

```java
@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    /**
     * Configure Spring Security settings
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        // Disable CSRF protection
        // Useful for REST APIs accessed through Postman, mobile apps, or frontend applications.
        http.csrf(csrf -> csrf.disable());

        // Enable HTTP Basic Authentication
        // Username and password will be sent in request headers.
        http.httpBasic(Customizer.withDefaults());

        // Make the application stateless
        // Spring Security will not create or use HTTP sessions.
        http.sessionManagement(session ->
            session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        // Require authentication for every request
        http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());

        return http.build();
    }

    /**
     * In-Memory User Configuration
     * Users are stored in application memory.
     * Mainly used for testing and learning purposes.
     */
    @Bean
    public UserDetailsService userDetailsService() {

        // Admin user
        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("jatin")
                .password("hello")
                .roles("ADMIN")
                .build();

        // Normal user
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("prasson")
                .password("bidua")
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(admin, user);
    }
}
```

---

## 💡 Key Concepts Covered

### 🔹 Spring Security Priority Order

Spring checks credentials in this order:

```
1. @Configuration class with @EnableWebSecurity  ← HIGHEST PRIORITY
2. application.properties (spring.security.user.*)
3. Console auto-generated password               ← LOWEST PRIORITY
```

> Once custom config class is present → `application.properties` credentials are **ignored**

### 🔹 What SecurityFilterChain Does

| Configuration                               | Effect                                           |
| ------------------------------------------- | ------------------------------------------------ |
| `http.csrf(csrf -> csrf.disable())`         | CSRF token not required for POST/PUT/DELETE      |
| `http.httpBasic(Customizer.withDefaults())` | Basic Auth via Postman/frontend works            |
| `SessionCreationPolicy.STATELESS`           | No session stored — every request is independent |
| `auth.anyRequest().authenticated()`         | Every endpoint requires authentication           |

### 🔹 In-Memory Authentication vs DAO Authentication

| Type                   | When to Use                   | Storage               |
| ---------------------- | ----------------------------- | --------------------- |
| **In-Memory**          | Small apps, testing, learning | RAM — lost on restart |
| **DAO Authentication** | Production, scalable apps     | Database              |

### 🔹 Stateful vs Stateless

| Stateful (Session 1 & 2)                     | Stateless (Session 3)           |
| -------------------------------------------- | ------------------------------- |
| Server stores session (JSESSIONID in cookie) | Server stores nothing           |
| Same Session ID across requests              | Every request is treated as new |
| Security risk if Session ID stolen           | Safer — no session to steal     |
| Traditional web apps                         | REST APIs, JWT-based apps       |

### 🔹 Authentication vs Authorization

| Term               | Meaning                                              |
| ------------------ | ---------------------------------------------------- |
| **Authentication** | Who are you? → verify identity via username/password |
| **Authorization**  | What can you do? → verify role/permissions           |

> `jatin` with role `ADMIN` → authenticated ✔ + authorized for all resources
> `prasson` with role `USER` → authenticated ✔ + limited authorization (role-based access in future sessions)

---

## 🔗 API Endpoints

| URL                           | Method | Description                                        |
| ----------------------------- | ------ | -------------------------------------------------- |
| `localhost:8080/get-employee` | GET    | Returns employee list as JSON                      |
| `localhost:8080/add-employee` | POST   | Adds new employee (no CSRF needed after Session 3) |
| `localhost:8080/get-info`     | GET    | Returns course info + Session ID                   |
| `localhost:8080/get-moreinfo` | GET    | Returns more info + Session ID                     |
| `localhost:8080/get-csrf`     | GET    | Returns CSRF Token object                          |

---

## 🧪 Postman Testing Results

**Wrong credentials → 401 Unauthorized:**

```
Username: jatin | Password: jatin  → 401 Unauthorized ❌
```

**Correct ADMIN credentials → 200 OK:**

```
Username: jatin | Password: hello  → 200 OK ✔
```

**Correct USER credentials → 200 OK:**

```
Username: prasson | Password: bidua → 200 OK ✔
```

**Old application.properties credentials → 401 Unauthorized:**

```
Username: jatin | Password: jatin123 → 401 Unauthorized ❌
(overridden by SecurityConfiguration class)
```

---

## ▶️ How to Run

1. Clone the repository
2. Open in STS / IntelliJ / Eclipse
3. Run as Spring Boot Application
4. Open Postman → Authorization → Basic Auth
5. Use: `jatin` / `hello` (ADMIN) or `prasson` / `bidua` (USER)
6. Test all endpoints

---

## 📌 Sessions Covered

| Session   | Topic                                                                                         |
| --------- | --------------------------------------------------------------------------------------------- |
| Session 1 | REST APIs without Spring Security — free access                                               |
| Session 2 | Default Spring Security — login form, CSRF token, Session ID, Authentication vs Authorization |
| Session 3 | Custom SecurityConfiguration — disable CSRF, stateless, in-memory multi-user auth             |
