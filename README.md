# 🎓 Student Course Management System

A backend application built with **Spring Boot** that manages students and their courses with secure **JWT-based authentication**.

---

## 🚀 Features

* 🔐 User Signup & Login
* 🛡️ JWT Authentication & Authorization
* 👨‍🎓 Student Management
* 📚 Course Management
    *    Marks Management
* ‍🎓 Enrollment Management
* 🔒 Secure REST APIs using Spring Security
* ⚡ Custom Exception Handling

## 📄 Marksheet Feature

- Generate marksheet for a student
- Displays subject-wise marks
- Calculates total, percentage, grade, and result
- Download marksheet as PDF using html2pdf

## 🔗 API Endpoint

GET /marksheet/{studentId}

---

## 🛠️ Tech Stack

* ☕ Java
* 🌱 Spring Boot
* 🔐 Spring Security
* 🪪 JWT (JSON Web Token)
* 🗄️ Hibernate / JPA
* 🐬 MySQL
* 📦 Maven

## 🛠️ Tech Used for Marksheet

- Spring Boot (Backend)
- HTML, CSS, JavaScript (Frontend)
- html2pdf.js (PDF generation)

---

## 🔐 Authentication Flow

1. User sends login request (username & password)
2. Server authenticates using Spring Security
3. JWT token is generated
4. Client sends token in header:

   ```
   Authorization: Bearer <token>
   ```
5. Backend validates token using filter
6. Access granted to protected APIs



---

## ⚙️ Setup & Run

1. Clone the repository

   ```
   git clone https://github.com/Commando1901/student-course-management-system.git
   ```

2. Open in IDE (IntelliJ / VS Code)

3. Configure database in `application.properties`

4. Run the project

   ```
   mvn spring-boot:run
   ```

---

## 📌 API Example

### 🔑 Login

**POST** `/auth/login`

Request:

```json
{
  "username": "mandip",
  "password": "1234"
}
```
Response:
```json
{
    "token": "jwt_token_here",
    "userId": 1
}
```
---

## 🧪 Testing

* Use **Postman** or any API client
* Add header for protected APIs:

  ```
  Authorization: Bearer <token>
  ```

---

## ⚠️ Error Handling

* Custom exception handling using `@ExceptionHandler`
* Proper HTTP status codes (404, 401, etc.)

---


## 👨‍💻 Author

**Mandip Patel**

---

## ⭐ Support

If you like this project, give it a ⭐ on GitHub!

---
