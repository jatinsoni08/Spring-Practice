# 03SpringSecurityProject_OAuth2Client — OAuth2 Login with Google & GitHub

This project covers **Spring Security OAuth2 Login** — integrating **Google** and **GitHub** as third-party authentication providers. Instead of managing usernames and passwords yourself, you delegate authentication to trusted providers. Users log in with their existing Google or GitHub account — zero password management on your end.

---

## 🚀 Project Overview

- Spring Boot project with only **2 dependencies** — Spring Web + OAuth2 Client
- Adding `oauth2-client` dependency → Spring auto-generates a login form with Google & GitHub buttons
- Custom `SecurityConfiguration` written to disable default form and enable OAuth2 login
- Google credentials fetched from **Google Cloud Console**
- GitHub credentials fetched from **GitHub Developer Settings**
- Two REST endpoints: `/` (home) and `/hi` (protected)
- Any user with a valid Google or GitHub account can authenticate
- Runs on **port 7878**

---

## 🧱 Technologies Used

- Java 17
- Spring Boot
- Spring Security
- Spring OAuth2 Client (`spring-boot-starter-oauth2-client`)
- Spring Web
- Google Cloud Console (OAuth2 App)
- GitHub Developer Settings (OAuth2 App)
- Maven

---

## 📁 Project Structure

```
src/main/java/com/app/jatin/
├── Application.java                        # Spring Boot main entry point
├── config/
│   └── SecurityConfiguration.java         # OAuth2 login config
└── restcontroller/
    └── ARestController.java                # REST endpoints — / and /hi
```

---

## ⚙️ application.properties

```properties
spring.application.name=03SpringSecurityProject_OAuth
server.port=7878

# ==========================
# Google OAuth2 Configuration
# ==========================
spring.security.oauth2.client.registration.google.client-id=YOUR_GOOGLE_CLIENT_ID
spring.security.oauth2.client.registration.google.client-secret=YOUR_GOOGLE_CLIENT_SECRET

# ==========================
# GitHub OAuth2 Configuration
# ==========================
spring.security.oauth2.client.registration.github.client-id=YOUR_GITHUB_CLIENT_ID
spring.security.oauth2.client.registration.github.client-secret=YOUR_GITHUB_CLIENT_SECRET
```

> ⚠️ Never commit real Client ID / Secret to GitHub.
> Use environment variables or a `.env` file in production.
> Add `application.properties` to `.gitignore` or replace secrets with placeholders before pushing.

---

## 🧩 Code Explanation

### 🔹 ARestController.java

```java
@RestController
public class ARestController {

    // Home endpoint
    @GetMapping("/")
    public String home() {
        return "Welcome to Spring Security OAuth2 Project";
    }

    // Protected endpoint — requires OAuth2 login to access
    @GetMapping("/hi")
    public String showData() {
        return "OAuth2 Login Project is running successfully.";
    }
}
```

Both endpoints are protected. Without OAuth2 login → redirected to login page automatically.

---

### 🔹 SecurityConfiguration.java (Key Class)

```java
@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)
            throws Exception {

        http
            // Every request must be authenticated
            .authorizeHttpRequests(auth ->
                auth.anyRequest().authenticated())

            // Enable OAuth2 Login (Google / GitHub)
            .oauth2Login(Customizer.withDefaults());

        return http.build();
    }
}
```

`.oauth2Login(Customizer.withDefaults())` — this single line activates the entire OAuth2 flow. Spring auto-handles the redirect to Google/GitHub, token exchange, and user session.

---

## 💡 Key Concepts Covered

### 🔹 What is OAuth2?

OAuth2 is an **authorization framework** that lets users log into your application using their existing account on a trusted provider (Google, GitHub, Facebook, etc.) — without sharing their password with your app.

```
User clicks "Login with Google"
        ↓
Redirected to Google login page
        ↓
User authenticates on Google's server
        ↓
Google sends authorization code to your app
        ↓
Your app exchanges code for access token
        ↓
User info fetched → User logged in
```

---

### 🔹 How to Get Google Client ID & Secret

1. Go to [console.cloud.google.com](https://console.cloud.google.com)
2. Create new project → APIs & Services → Credentials
3. Create OAuth 2.0 Client ID → Web Application
4. Authorized redirect URI: `http://localhost:7878/login/oauth2/code/google`
5. Copy **Client ID** and **Client Secret** → paste in `application.properties`

---

### 🔹 How to Get GitHub Client ID & Secret

1. Go to GitHub → Settings → Developer Settings → OAuth Apps
2. New OAuth App
3. Homepage URL: `http://localhost:7878`
4. Authorization callback URL: `http://localhost:7878/login/oauth2/code/github`
5. Copy **Client ID** and **Client Secret** → paste in `application.properties`

---

### 🔹 Default Behavior vs Custom Config

| Without SecurityConfiguration                          | With SecurityConfiguration                     |
| ------------------------------------------------------ | ---------------------------------------------- |
| Spring shows default login form with username/password | OAuth2 login page with Google + GitHub buttons |
| Form-based login enabled by default                    | `.oauth2Login()` explicitly enabled            |
| CSRF enabled by default                                | Managed by Spring OAuth2                       |

---

### 🔹 OAuth2 vs Previous Authentication Types

| Type                   | Where users stored               | Password managed by |
| ---------------------- | -------------------------------- | ------------------- |
| Default (Session 1-2)  | Console / application.properties | You                 |
| In-Memory (Session 3)  | Java code hardcoded              | You                 |
| DAO Auth (Session 4)   | MySQL database                   | You                 |
| **OAuth2 (Session 5)** | **Google / GitHub servers**      | **Google / GitHub** |

---

### 🔹 Spring OAuth2 Auto-Configuration

Just adding `spring-boot-starter-oauth2-client` dependency is enough for Spring to:

- Auto-generate the login page with provider buttons
- Handle redirect URIs automatically
- Manage token exchange internally
- Support Google, GitHub, Facebook, Okta out of the box

---

## 🔗 API Endpoints

| URL                 | Method | Auth Required  | Description             |
| ------------------- | ------ | -------------- | ----------------------- |
| `localhost:7878/`   | GET    | ✔ OAuth2 Login | Returns welcome message |
| `localhost:7878/hi` | GET    | ✔ OAuth2 Login | Returns success message |

---

## ▶️ How to Run

1. Get Google Client ID + Secret from Google Cloud Console
2. Get GitHub Client ID + Secret from GitHub Developer Settings
3. Paste both into `application.properties`
4. Run as Spring Boot Application
5. Open browser → `http://localhost:7878/`
6. You will be redirected to OAuth2 login page
7. Click **Google** or **GitHub** → Login with your account
8. On success → redirected back to your app → endpoint accessible

---

## ⚠️ Security Note for GitHub Upload

Before pushing to GitHub, replace real credentials:

```properties
spring.security.oauth2.client.registration.google.client-id=YOUR_GOOGLE_CLIENT_ID
spring.security.oauth2.client.registration.google.client-secret=YOUR_GOOGLE_CLIENT_SECRET
spring.security.oauth2.client.registration.github.client-id=YOUR_GITHUB_CLIENT_ID
spring.security.oauth2.client.registration.github.client-secret=YOUR_GITHUB_CLIENT_SECRET
```

Or add to `.gitignore`:

```
application.properties
```
