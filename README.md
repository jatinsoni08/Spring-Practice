<!--
  🚀 SPRING FRAMEWORK MASTERY REPOSITORY
  Built with ❤️ by Jatin Soni
  Licensed under MIT
-->

<div align="center">

# 🌟 SPRING FRAMEWORK MASTERY JOURNAL

[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.0-brightgreen?style=for-the-badge&logo=spring-boot)](https://spring.io/projects/spring-boot)
[![Spring Framework](https://img.shields.io/badge/Spring%20Framework-6.1.0-brightgreen?style=for-the-badge&logo=spring)](https://spring.io/projects/spring-framework)
[![Java](https://img.shields.io/badge/Java-17-red?style=for-the-badge&logo=openjdk)](https://openjdk.java.net/)
[![MySQL](https://img.shields.io/badge/MySQL-8.0-blue?style=for-the-badge&logo=mysql)](https://www.mysql.com/)
[![Hibernate](https://img.shields.io/badge/Hibernate-ORM-red?style=for-the-badge&logo=hibernate)](https://hibernate.org/)
[![Maven](https://img.shields.io/badge/Maven-C32127?style=for-the-badge&logo=apache-maven&logo=white)](https://maven.apache.org/)

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg?style=for-the-badge)](https://opensource.org/licenses/MIT)
[![Contributions Welcome](https://img.shields.io/badge/Contributions-Welcome-brightgreen?style=for-the-badge)](mailto:jatinsoni08@example.com)

> **"Building Enterprise-Grade Applications One Bean at a Time"**
>
> A structured, hands-on journey through the depths of the Spring Ecosystem.
> From raw IoC containers to secure REST APIs — this repository documents the complete mastery path.

[📜 Repository Overview](#-repository-overview) | [📂 Project Catalog](#-project-catalog) | [🛠️ Tech Stack](#-technologies-used) | [🧠 Learning Path](#-learning-approach)

</div>

---

## 🚀 Repository Overview

This is **not** a collection of copy-paste tutorials. This is a **battle-tested laboratory** where every concept of the Spring Framework is dissected, implemented, and mastered from scratch.

### 🔥 What You Will Find Here:

- 🧱 **Core Fundamentals**: Deep dive into IoC, DI, and Bean Lifecycle (XML & Annotation-free initially to understand the magic).
- 🤖 **Spring Boot Automation**: Mastering auto-configuration, starters, and production-ready setups.
- 💾 **Data Persistence**: Full-scale JPA, Hibernate, and MySQL integration with complex CRUD operations.
- 🌐 **Web & REST**: Building secure, scalable MVC applications and RESTful APIs.
- 🔒 **Security**: Implementing Authentication, Authorization, CSRF protection, Session Management, and In-Memory Auth with custom SecurityConfiguration.
- ⚡ **Exception Handling**: Building production-grade custom error responses using @RestControllerAdvice, @ExceptionHandler, and structured JSON error beans — replacing Spring's default stack trace exposure.
- 🔒 **Security**: Implementing Authentication, Authorization, CSRF protection, Session Management, In-Memory Auth with custom SecurityConfiguration, and DAO Authentication with database-backed multi-user login via DaoAuthenticationProvider and custom UserDetailsService.

> ⚠️ **WARNING**: This repository contains intense code implementations.
> Viewing this content may cause sudden increases in backend engineering skills and employability.

---

## 📂 Project Catalog

### 🏗️ Phase 1: Spring Core & Container Internals

_Understanding the magic behind the curtain. Manual implementation before automation._

| #   | Project Name                                                                                                            | Key Concepts                                    | Status      |
| --- | ----------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------- | ----------- |
| 01  | [XML Configuration](https://github.com/jatinsoni08/Spring-Practice/tree/main/Spring-Core-XML-Configuration)             | Bean Creation, Setter Injection, IoC Container  | ✅ Complete |
| 02  | [Collection Injection](https://github.com/jatinsoni08/Spring-Practice/tree/main/SpringCore_CollectionTypeDependencies)  | List/Set/Map Injection, Complex Types           | ✅ Complete |
| 03  | [Reference Type DI](https://github.com/jatinsoni08/Spring-Practice/tree/main/SpringCore_RefernceceTypeDependecies)      | Bean-to-Bean Injection, Loose Coupling          | ✅ Complete |
| 04  | [Annotation Config (Manual)](https://github.com/jatinsoni08/Spring-Practice/tree/main/SpringAnnotationConfig_Component) | @Component, @Value, Manual Container            | ✅ Complete |
| 05  | [Component Scanning](https://github.com/jatinsoni08/Spring-Practice/tree/main/SpringBasePackageDemo)                    | @ComponentScan, Base Package Security           | ✅ Complete |
| 06  | [Autowired Basics](https://github.com/jatinsoni08/Spring-Practice/tree/main/SpringCore_AutoWiredBasic_EG)               | @Autowired, Dependency Resolution               | ✅ Complete |
| 07  | [Conflict Resolution](https://github.com/jatinsoni08/Spring-Practice/tree/main/SpringCore_Autowired_Cases)              | @Qualifier, @Primary, Ambiguity Handling        | ✅ Complete |
| 08  | [Manual DI (Core Java)](https://github.com/jatinsoni08/Spring-Practice/tree/main/SpringCore_UnderstandingWithCoreJava)  | **No Spring**: Manual DI, Interface Programming | ✅ Complete |

---

### 🚀 Phase 2: Spring Boot & Automation

_Leveraging the power of convention over configuration._

| #   | Project Name                                                                                              | Key Concepts                               | Status      |
| --- | --------------------------------------------------------------------------------------------------------- | ------------------------------------------ | ----------- |
| 09  | [Startup Runners](https://github.com/jatinsoni08/Spring-Practice/tree/main/SpringBootCoreRunnersEx)       | CommandLineRunner, @Order, Startup Logic   | ✅ Complete |
| 10  | [Config Properties](https://github.com/jatinsoni08/Spring-Practice/tree/main/SpringBootCoreConfigPropsEx) | @ConfigurationProperties, Type-safe Config | ✅ Complete |
| 11  | [Property Binding](https://github.com/jatinsoni08/Spring-Practice/tree/main/SpringBootCoreInputEx-1)      | Custom Properties, POJO Binding            | ✅ Complete |
| 12  | [YAML Configuration](https://github.com/jatinsoni08/Spring-Practice/tree/main/SpringBootCoreInputEx-2)    | application.yml, Hierarchical Config       | ✅ Complete |

---

### 💾 Phase 3: Data Persistence & JPA

_Mastering database interactions with Spring Data JPA and Hibernate._

| #   | Project Name                                                                                                       | Key Concepts                                        | Status      |
| --- | ------------------------------------------------------------------------------------------------------------------ | --------------------------------------------------- | ----------- |
| 13  | [JPA Integration](https://github.com/jatinsoni08/Spring-Practice/tree/main/SpringBoot_DataJPA_ProjectExample)      | @Entity, @Table, ddl-auto, MySQL DataSource         | ✅ Complete |
| 14  | [Full CRUD Operations](https://github.com/jatinsoni08/Spring-Practice/tree/main/SpringDATAJPA_EmployeeCRUDProject) | saveAll, findById, Optional, Transaction Management | ✅ Complete |

> 💡 **Note**: These projects demonstrate safe SQL practices, entity mapping, and the use of Lombok for boilerplate reduction.

---

### 🌐 Phase 4: Web MVC & View Engines

_Building dynamic web applications with JSP and Thymeleaf._

| #   | Project Name                                                                                                               | Key Concepts                                         | Status      |
| --- | -------------------------------------------------------------------------------------------------------------------------- | ---------------------------------------------------- | ----------- |
| 15  | [MVC with ModelAndView](https://github.com/jatinsoni08/Spring-Practice/tree/main/SpringWebMVC_Project_UsingMVC)            | DispatcherServlet, HandlerMapping, JSP View Resolver | ✅ Complete |
| 16  | [Model & String View](https://github.com/jatinsoni08/Spring-Practice/tree/main/SpringWebMVCProject_UsingString)            | Model Object, Custom View Paths, JSP EL              | ✅ Complete |
| 17  | [Advanced Data Transfer](https://github.com/jatinsoni08/Spring-Practice/tree/main/SpringWebMVC_Project_Model_Map_ModelMap) | ModelMap, JSTL c:forEach, List Rendering             | ✅ Complete |
| 18  | [Thymeleaf Integration](https://github.com/jatinsoni08/Spring-Practice/tree/main/SpringWebMVC_Project_ThymeLeaf)           | Thymeleaf Engine, th:text, th:href, Static Resources | ✅ Complete |

---

### 🔒 Phase 5: REST APIs, Security & Exception Handling

_Building and securing enterprise-grade microservices._

| #   | Project Name                                                                                                             | Key Concepts                                                                                                                                                                                                                                   | Status      |
| --- | ------------------------------------------------------------------------------------------------------------------------ | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ----------- |
| 19  | [REST Basics](https://github.com/jatinsoni08/Spring-Practice/tree/main/SpringBoot_RESTBasicProject)                      | @RestController, @RequestBody, JSON Serialization, Postman                                                                                                                                                                                     | ✅ Complete |
| 20  | [Advanced REST](https://github.com/jatinsoni08/Spring-Practice/tree/main/SpringBoot_RESTPathVaribale_EG)                 | @PathVariable, @RequestParam, ResponseEntity, HttpStatus                                                                                                                                                                                       | ✅ Complete |
| 21  | [JSON Control](https://github.com/jatinsoni08/Spring-Practice/tree/main/SpringBoot_ResponseBody)                         | @JsonProperty, @JsonIgnore, @ResponseBody, Custom Responses                                                                                                                                                                                    | ✅ Complete |
| 22  | [Spring Security](https://github.com/jatinsoni08/Spring-Practice/tree/main/01SpringSecurity-BaiscProject)                | Default Behavior, Login Form, CSRF Token, Session ID, Stateful vs Stateless, Authentication vs Authorization, SecurityConfiguration, @EnableWebSecurity, SecurityFilterChain, In-Memory Auth, ADMIN + USER roles                               | ✅ Complete |
| 23  | [Exception Handling](https://github.com/jatinsoni08/Spring-Practice/tree/main/SpringBoot_ExceptionHandling_BasicProject) | @RestControllerAdvice, @ExceptionHandler, Custom RuntimeException, MyErrorResponse Bean, BasicErrorController, Global Exception Handling, Re-throwing Exceptions, Structured JSON Error Response                                               | ✅ Complete |
| 24  | [DAO Authentication](https://github.com/jatinsoni08/Spring-Practice/tree/main/02SpringSecurityProject-DAO-1)                   | DAO Authentication, DaoAuthenticationProvider, UserDetailsService Custom Implementation, UserDetails Adapter Class, IUserRepo + findByName(), Users Entity, MySQL Multi-User Auth, NoOpPasswordEncoder, Spring Data JPA + Security Integration | ✅ Complete |

---

## 🛠️ Technologies Used

<div align="center">

[![Java](https://img.shields.io/badge/Java-17-red?style=for-the-badge&logo=openjdk&logoColor=white)](https://openjdk.java.net/)
[![Spring](https://img.shields.io/badge/Spring%20Framework-6.1.0-brightgreen?style=for-the-badge&logo=spring&logoColor=white)](https://spring.io/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.0-brightgreen?style=for-the-badge&logo=spring-boot&logoColor=white)](https://spring.io/projects/spring-boot)
[![Spring Security](https://img.shields.io/badge/Spring%20Security-6.2.0-brightgreen?style=for-the-badge&logo=spring-security&logoColor=white)](https://spring.io/projects/spring-security)
[![Spring Data JPA](https://img.shields.io/badge/Spring%20Data%20JPA-3.2.0-brightgreen?style=for-the-badge&logo=spring&logoColor=white)](https://spring.io/projects/spring-data-jpa)
[![Hibernate](https://img.shields.io/badge/Hibernate-ORM-red?style=for-the-badge&logo=hibernate&logoColor=white)](https://hibernate.org/)
[![MySQL](https://img.shields.io/badge/MySQL-8.0-blue?style=for-the-badge&logo=mysql&logoColor=white)](https://www.mysql.com/)
[![Maven](https://img.shields.io/badge/Maven-C32127?style=for-the-badge&logo=apache-maven&logoColor=white)](https://maven.apache.org/)
[![Lombok](https://img.shields.io/badge/Lombok-1.18.30-blue?style=for-the-badge&logo=java&logoColor=white)](https://projectlombok.org/)

</div>

---

## 🧠 Learning Approach

This repository follows a **Concept-First, Implementation-Second** methodology:

1. **🔍 Deep Dive**: Understanding the "Why" and "How" before the "What".
2. **🧱 Manual Implementation**: Building things manually (e.g., Manual DI) to appreciate the automation.
3. **🤖 Automation**: Leveraging Spring Boot's power only after understanding the underlying mechanics.
4. **🛡️ Security First**: Integrating security practices from the ground up.
5. **⚡ Resilience**: Handling exceptions gracefully with structured, production-ready error responses.
6. **📈 Real-World Scenarios**: Projects mimic actual industry challenges and requirements.

---

## 🙏 Acknowledgment & Credits

Special thanks to **Prasoon Bidua Sir** and **REGex Software Services** for providing the mentorship and industry-oriented guidance that made this practical learning journey possible. Their approach to making complex concepts understandable is unparalleled.

---

<div align="center">

### 🌟 Ready to Build Something Great?

This repository is a testament to the power of structured learning and practical implementation.
Feel free to explore, clone, and learn from the code.

**If this repository helped you, please ⭐ Star this repository to support the community!**

[![GitHub](https://img.shields.io/badge/GitHub-Follow%20Me-blue?style=for-the-badge&logo=github)](https://github.com/jatinsoni08)

---

_Built with ❤️ and lots of ☕ by Jatin Soni_

_© 2024 Spring Practice Repository. Licensed under MIT._

</div>
