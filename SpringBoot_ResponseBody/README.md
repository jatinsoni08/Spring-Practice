# SpringBoot_ResponseBody — @ResponseBody, @JsonProperty & @JsonIgnore in REST API

This project demonstrates how Spring Boot handles **JSON serialization and deserialization** in REST APIs using `@ResponseBody`, `@JsonProperty`, and `@JsonIgnore` — giving full control over what data appears in JSON responses and how fields are named.

---

## 🚀 Project Overview

A Spring Boot REST API application where:

- `UserRestController` exposes 3 GET endpoints returning Object, List and Map as JSON
- `User` entity uses `@JsonProperty` to customize JSON field names
- `@JsonIgnore` hides sensitive `password` field from JSON response
- `ResponseEntity<T>` wraps response with body and HTTP status
- Jackson automatically converts Java objects to JSON

---

## 🧱 Technologies Used

- Java 17
- Spring Boot
- Spring Web (REST)
- Jackson (auto-configured)
- Lombok
- Maven

---

## 📁 Project Structure

```
src/main/java/com/app/
├── SpringBootResponseBodyApplication.java    # Spring Boot main entry point
├── entity/
│   ├── User.java                             # User entity with @JsonProperty & @JsonIgnore
│   └── Role.java                             # Role entity with Lombok
└── controller/
    └── UserRestController.java               # REST Controller — 3 GET endpoints
```

---

## ⚙️ How It Works

1. Client hits GET endpoint
2. Controller creates Java object (User / List / Map)
3. `@ResponseBody` (via `@RestController`) triggers Jackson
4. Jackson converts Java → JSON automatically
5. `@JsonProperty` renames fields in JSON output
6. `@JsonIgnore` excludes sensitive fields from JSON output
7. `ResponseEntity` wraps JSON with HTTP status `200 OK`

---

## 🧩 Code Explanation

### 🔹 User.java (Entity)

```java
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @JsonProperty("user-unq-id")       // renames userId → "user-unq-id" in JSON
    private Integer userId;

    @JsonProperty("user-first-name")   // renames userName → "user-first-name" in JSON
    private String userName;

    private String userRole;

    @JsonIgnore                        // password excluded from JSON response
    private String password;

    private List<String> permissions;
    private Map<String, String> models;
}
```

---

### 🔹 Role.java (Entity)

```java
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    private Integer roleId;
    private String roleCode;
}
```

---

### 🔹 UserRestController.java

```java
@RestController
@RequestMapping("/user")
public class UserRestController {

    // GET — Single Object
    @GetMapping("/one")
    public ResponseEntity<User> getOneObj() {
        User ob = new User(101, "ABC", "Dev", "PASSWD1234",
                Arrays.asList("P1", "P2"),
                Map.of("M1", "AA", "M2", "AB"));
        return new ResponseEntity<>(ob, HttpStatus.OK);
    }

    // GET — List of Objects
    @GetMapping("/list")
    public ResponseEntity<List<Role>> getAllRoles() {
        List<Role> roles = Arrays.asList(
                new Role(1100, "ADMIN"),
                new Role(1102, "BA"),
                new Role(1103, "QA"));
        return new ResponseEntity<>(roles, HttpStatus.OK);
    }

    // GET — Map
    @GetMapping("/map")
    public ResponseEntity<Map<Integer, Role>> getRolesMap() {
        Map<Integer, Role> rolesMap = Map.of(
                1100, new Role(1100, "ADMIN"),
                1102, new Role(1102, "BA"),
                1103, new Role(1103, "QA"));
        return new ResponseEntity<>(rolesMap, HttpStatus.OK);
    }
}
```

---

## 💡 Key Concepts Covered

- `@ResponseBody` — converts Java object → JSON and writes to HTTP response body
- `@RequestBody` — converts JSON → Java object from HTTP request body
- `@RestController` = `@Controller` + `@ResponseBody` (auto-applied to all methods)
- `@JsonProperty("custom-name")` — gives custom key name in JSON output
- `@JsonIgnore` — excludes field from JSON (used for sensitive data like password)
- `ResponseEntity<T>` — wraps response with body + HTTP status code
- `HttpStatus.OK` — 200 status
- Jackson — auto-configured library handling all JSON conversions
- Returning `Object`, `List<T>`, `Map<K,V>` from REST endpoints

---

## 📌 @RequestBody vs @ResponseBody

| Annotation      | Direction   | What it does                                          |
| --------------- | ----------- | ----------------------------------------------------- |
| `@RequestBody`  | JSON → Java | Reads JSON from request body, converts to Java object |
| `@ResponseBody` | Java → JSON | Converts Java object to JSON, writes to response body |

> Both work only with **non-String types** (Class, Collection, Map)

---

## 📌 @JsonProperty vs @JsonIgnore

| Annotation              | Purpose                 | Example                         |
| ----------------------- | ----------------------- | ------------------------------- |
| `@JsonProperty("name")` | Rename field in JSON    | `userId` → `"user-unq-id"`      |
| `@JsonIgnore`           | Exclude field from JSON | `password` hidden from response |

---

## 🔗 API Endpoints

| URL                        | HTTP Method | Returns               | Description                           |
| -------------------------- | ----------- | --------------------- | ------------------------------------- |
| `localhost:4545/user/one`  | GET         | Single User object    | @JsonProperty + @JsonIgnore in action |
| `localhost:4545/user/list` | GET         | List of Role objects  | List serialized to JSON array         |
| `localhost:4545/user/map`  | GET         | Map of Integer → Role | Map serialized to JSON object         |

---

## ▶️ How to Run

1. Clone the repository
2. Open in STS / IntelliJ / Eclipse
3. Run as Spring Boot Application (port 4545)
4. Hit in browser or Postman:

```
GET http://localhost:4545/user/one
GET http://localhost:4545/user/list
GET http://localhost:4545/user/map
```

---

## 🧪 Expected Output

**GET `/user/one` → 200 OK:**

```json
{
  "user-unq-id": 101,
  "user-first-name": "ABC",
  "userRole": "Dev",
  "permissions": ["P1", "P2"],
  "models": { "M1": "AA", "M2": "AB" }
}
```

> Note: `password` field is **not visible** — hidden by `@JsonIgnore`

**GET `/user/list` → 200 OK:**

```json
[
  { "roleId": 1100, "roleCode": "ADMIN" },
  { "roleId": 1102, "roleCode": "BA" },
  { "roleId": 1103, "roleCode": "QA" }
]
```

**GET `/user/map` → 200 OK:**

```json
{
  "1100": { "roleId": 1100, "roleCode": "ADMIN" },
  "1102": { "roleId": 1102, "roleCode": "BA" },
  "1103": { "roleId": 1103, "roleCode": "QA" }
}
```
