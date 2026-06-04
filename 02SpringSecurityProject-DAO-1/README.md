# 02SpringSecurityProject — DAO Authentication (Database-Backed Multi-User Authentication)

This project covers **Spring Security Session 4 — DAO Authentication**, where users are authenticated against a **real MySQL database** instead of hardcoded credentials. Any user stored in the `users` table can access the application. This is how real-world production applications handle authentication.

---

## 🚀 Project Overview

- New Spring Boot project created with Spring Security 3.x
- MySQL database `securitydb1` with `users` table — 10 users inserted
- `Users` entity mapped to `users` table via Spring Data JPA
- `IUserRepo` extends `JpaRepository` with custom `findByName()` finder method
- `MyUserDetailService` implements `UserDetailsService` — fetches user from DB
- `UserInformation` implements `UserDetails` — adapts `Users` entity to Spring Security model
- `SecurityConfiguration` wires `DaoAuthenticationProvider` with `MyUserDetailService`
- CSRF disabled, HTTP Basic enabled, session STATELESS
- Any DB-stored user can authenticate — `sneha / sneha321` → 200 OK, wrong creds → 401
- Runs on **port 8083**

---

## 🧱 Technologies Used

- Java 17
- Spring Boot 3.x
- Spring Security
- Spring Data JPA
- MySQL + MySQL Workbench
- Lombok
- Spring Dev Tools
- Postman (API Testing)
- Maven

---

## 📁 Project Structure

```
src/main/java/com/app/
├── Application.java
├── model/
│   └── Employee.java                    # Employee model (REST layer)
├── entity/
│   └── Users.java                       # @Entity — maps to users table in MySQL
├── repo/
│   └── IUserRepo.java                   # JpaRepository + custom findByName()
├── service/
│   ├── MyUserDetailService.java         # implements UserDetailsService — core auth logic
│   └── UserInformation.java             # implements UserDetails — adapts Users entity
├── config/
│   └── SecurityConfiguration.java      # @Configuration + @EnableWebSecurity
└── restcontroller/
    └── EmployeeRestController.java      # REST endpoints
```

---

## ⚙️ application.properties

```properties
spring.application.name=02SpringSecurityProject
server.port=8083

spring.datasource.url=jdbc:mysql://localhost:3306/securitydb1
spring.datasource.username=root
spring.datasource.password=your_password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
```

---

## 🧩 Code Explanation

### 🔹 Users.java (Entity — maps to DB table)

```java
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Users {

    @Id
    private String name;       // Primary Key = username

    private String password;
}
```

Spring Data JPA auto-creates the `users` table from this entity via `ddl-auto=update`.

---

### 🔹 IUserRepo.java (Repository Layer)

```java
public interface IUserRepo extends JpaRepository<Users, String> {

    // Custom finder method — Spring generates SQL automatically
    Users findByName(String username);
}
```

No SQL written. Spring generates `SELECT * FROM users WHERE name = ?` automatically from method name.

---

### 🔹 MyUserDetailService.java (UserDetailsService Implementation — Key Class)

```java
@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private IUserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        Users users = repo.findByName(username);

        if (users == null) {
            throw new UsernameNotFoundException("User Not Found 404");
        }

        return new UserInformation(users);
    }
}
```

This is where the magic happens. `UserDetailsService` is a Spring Security interface. We provide our own implementation so Spring knows to check the database — not `application.properties`.

---

### 🔹 UserInformation.java (UserDetails Implementation — Adapter Class)

```java
@Service
public class UserInformation implements UserDetails {

    private Users user;

    public UserInformation(Users user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority("USER"));
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getName();
    }
}
```

`Users` entity cannot be returned directly from `loadUserByUsername()` because its return type is `UserDetails` (interface). `UserInformation` acts as an **adapter/wrapper** — it holds the `Users` object and exposes its data through `UserDetails` methods.

---

### 🔹 SecurityConfiguration.java (Full Configuration)

```java
@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public AuthenticationProvider authProvider() {

        DaoAuthenticationProvider daoProvider = new DaoAuthenticationProvider();

        // Connect custom UserDetailsService → goes to DB for user data
        daoProvider.setUserDetailsService(userDetailsService);

        // NoOpPasswordEncoder — plain text passwords (for learning only)
        daoProvider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());

        return daoProvider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)
            throws Exception {

        http.csrf(csrf -> csrf.disable());
        http.httpBasic(Customizer.withDefaults());
        http.sessionManagement(session ->
            session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());

        return http.build();
    }
}
```

`DaoAuthenticationProvider` is the bridge between Spring Security and the database. It calls `UserDetailsService.loadUserByUsername()` → which calls our `MyUserDetailService` → which calls `IUserRepo.findByName()` → which queries MySQL.

---

## 🗄️ Database Setup

```sql
-- Create database
CREATE DATABASE securitydb1;

-- Users table auto-created by JPA on app start
-- Insert users manually
INSERT INTO users (name, password) VALUES
('jatin',   'hello'),
('admin',   'admin123'),
('prasson', 'bidua'),
('rahul',   'pass123'),
('neha',    'neha@123'),
('amit',    'amit123'),
('sneha',   'sneha321'),
('rohit',   'rohit@2024'),
('ankit',   'ankit007'),
('priya',   'priya999');
```

Any of these 10 users can now authenticate. Add more rows to add more users — **no code change needed**.

---

## 💡 Key Concepts Covered

### 🔹 DAO Authentication Flow

```
Client Request (username + password via Basic Auth)
        ↓
DaoAuthenticationProvider
        ↓
UserDetailsService.loadUserByUsername(username)
        ↓
MyUserDetailService → IUserRepo.findByName(username)
        ↓
MySQL DB query → Users entity returned
        ↓
UserInformation wraps Users → returned as UserDetails
        ↓
DaoAuthenticationProvider compares password
        ↓
Match → 200 OK  |  No match → 401 Unauthorized
```

---

### 🔹 Why UserInformation Class is Needed

| Problem                                                                    | Solution                                          |
| -------------------------------------------------------------------------- | ------------------------------------------------- |
| `loadUserByUsername()` must return `UserDetails`                           | Create `UserInformation implements UserDetails`   |
| `Users` entity has different type than `UserDetails`                       | `UserInformation` wraps `Users` — adapter pattern |
| Spring Security needs `getUsername()`, `getPassword()`, `getAuthorities()` | `UserInformation` implements all 3 methods        |

---

### 🔹 Why Custom UserDetailsService is Needed

| Default Spring Behavior             | Our Custom Behavior               |
| ----------------------------------- | --------------------------------- |
| Reads from `application.properties` | Reads from MySQL database         |
| Supports only 1 user                | Supports unlimited users          |
| Hardcoded credentials               | Dynamic — add users to DB anytime |
| No DB connection                    | Full JPA + MySQL integration      |

---

### 🔹 In-Memory Auth vs DAO Auth

| Feature          | In-Memory (Session 3)  | DAO Auth (Session 4)         |
| ---------------- | ---------------------- | ---------------------------- |
| User storage     | Hardcoded in Java      | MySQL database               |
| Add new user     | Change code + redeploy | INSERT SQL — no code change  |
| User count       | Small (2-5)            | Unlimited                    |
| Production ready | No                     | Yes (with password encoding) |

---

### 🔹 Version Note

`DaoAuthenticationProvider` constructor with no args works in **Spring 3.x only**. Spring 4.x requires different approach. This project uses Spring Boot 3.x.

---

## 🔗 API Endpoints

| URL                           | Method | Auth Required          | Description           |
| ----------------------------- | ------ | ---------------------- | --------------------- |
| `localhost:8083/get-employee` | GET    | ✔ Basic Auth (DB user) | Returns employee list |
| `localhost:8083/add-employee` | POST   | ✔ Basic Auth (DB user) | Adds employee         |
| `localhost:8083/get-info`     | GET    | ✔ Basic Auth (DB user) | Returns session info  |

---

## 🧪 Postman Testing Results

**Any DB user → 200 OK:**

```
Username: sneha  | Password: sneha321  → 200 OK ✔
Username: jatin  | Password: hello     → 200 OK ✔
Username: prasson| Password: bidua     → 200 OK ✔
```

**Wrong password → 401 Unauthorized:**

```
Username: sneha | Password: wrongpass → 401 Unauthorized ❌
```

**User not in DB → 401 Unauthorized:**

```
Username: xyz   | Password: anything  → 401 Unauthorized ❌
```

---

## ▶️ How to Run

1. Create MySQL database: `CREATE DATABASE securitydb1;`
2. Update `application.properties` with your MySQL credentials
3. Run as Spring Boot Application — `users` table auto-created by JPA
4. Run the INSERT SQL to populate users
5. Open Postman → GET `localhost:8083/get-employee`
6. Authorization → Basic Auth → any username/password from `users` table
7. 200 OK confirms successful DAO Authentication
