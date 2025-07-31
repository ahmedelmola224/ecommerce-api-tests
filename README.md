# E-commerce API Test Automation Suite

This project is an automated API testing framework designed for verifying authentication and end-to-end user workflows in an e-commerce system. It uses **Java**, **Rest Assured**, **Cucumber**, and **JUnit** to structure and execute test scenarios in a BDD (Behavior-Driven Development) style.

---

## Table of Contents

- [Features](#-features)
- [Tech Stack](#-tech-stack)
- [Project Structure](#-project-structure)
- [Setup Instructions](#-setup-instructions)
- [How to Run Tests](#-how-to-run-tests)
- [Test Scenarios](#-test-scenarios-covered)
- [Reports](#-reports)
- [Contributing](#-contributing)

---

## ⭐ Features

- 🔐 **Authentication** (Login with positive and negative test cases)
- 🚀 **End-to-End Flow**:
  - Add Product
  - Create Order
  - Get Order Details
  - Delete Order
  - Delete Product
- ✅ Token Management: Reuses authentication token across test steps
- 📎 Cucumber tags for filtering (`@e2e`, `@smoke`, `@regression`)
- 💡 Modular and reusable step definitions

---

## Test Scenarios Covered

**Feature: User Authentication**
Successful login with valid credentials

❌ Login with invalid email

❌ Login with invalid password

📌 **Feature: End-to-End E-commerce API Flow (@e2e, @smoke, @regression)**
Login → Add Product → Create Order → Fetch Order Details → Delete Order → Delete Product

---

## 🛠 Tech Stack

| Tool/Library | Purpose                       |
| ------------ | ----------------------------- |
| Java (17+)   | Core language                 |
| Rest Assured | API testing                   |
| Cucumber JVM | BDD framework                 |
| JUnit        | Test runner                   |
| Maven        | Dependency & build management |
| JSON         | Payload & response structure  |

---

## 📂 Project Structure

ecommerce-api-tests/
├── src/test/java/
│ ├── stepDefinitions/ # Step definitions for Cucumber
│ ├── utils/ # Utilities (e.g., request builder, reusable methods)
│ ├── runners/ # Test runners (JUnit)
│ └── features/ # Gherkin scenarios (.feature files)
├── pom.xml # Maven dependencies
├── README.md # Project documentation
└── reports/ # Test execution reports (HTML/JSON)

---

## ⚙️ Setup Instructions

1. **Clone the repository:**

   ```bash
   git clone https://github.com/ahmedelmola224/ecommerce-api-tests.git
   cd ApiFramwork
   mvn clean install
   ```

---

## Run All Tests from Terminal:

```bash
mvn test verify
```

---

## Run Specific Tagged Tests::

```bash
mvn test -Dcucumber.filter.tags="@e2e"
or
mvn test -Dcucumber.filter.tags="@regression"
or
mvn test -Dcucumber.filter.tags="@smoke"
```
