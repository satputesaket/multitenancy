# Spring Boot Multi-Tenancy Application

A Spring Boot backend application demonstrating **Multi-Tenancy Architecture** using tenant-based request handling, interceptors, filters, and dynamic tenant context management.

This project showcases how to build scalable enterprise applications that support multiple tenants while maintaining clean architecture and tenant isolation.

---

# 🚀 Features

- Multi-Tenant Architecture
- Tenant Context Management
- Request-Based Tenant Identification
- Spring Boot REST API
- Tenant Interceptor Implementation
- Tenant Filter Implementation
- Aspect-Oriented Logging
- Dynamic Data Source Configuration
- Layered Architecture
- Service-Repository Pattern
- Clean Package Structure
- Centralized Response Handling

---

# 🛠️ Tech Stack

- Java 17+
- Spring Boot
- Spring MVC
- Spring Data JPA
- Maven
- MySQL / PostgreSQL
- Aspect-Oriented Programming (AOP)

---

# 📂 Project Structure

```text
src/main/java/com/saketsatpute/multitenancy
│
├── aspect
│   └── TenantLoggingAspect.java
│
├── configs
│   ├── DataSourceConfig.java
│   ├── TenantContext.java
│   ├── TenantMessageSource.java
│   ├── TenantProperties.java
│   └── WebMvcConfig.java
│
├── controllers
│   └── ProductController.java
│
├── entity
│   └── Product.java
│
├── filter
│   └── TenantFilter.java
│
├── interceptor
│   └── TenantInterceptor.java
│
├── model
│   ├── Product.java
│   ├── Response.java
│   └── TenantConstants.java
│
├── repository
│   └── ProductRepository.java
│
├── service
│   ├── ProductService.java
│   └── impl
│       └── ProductServiceImpl.java
│
├── MultitenancyApplication.java
│
└── resources
```

---

# 🏗️ Architecture Overview

The application follows a tenant-aware architecture where:

1. Incoming requests are intercepted
2. Tenant information is extracted from request headers/context
3. Tenant context is stored for request lifecycle
4. Tenant-specific operations are executed
5. Logging and processing are isolated per tenant

This design helps support multiple clients/customers using a single application instance.

---

# ⚙️ Core Components

## Tenant Filter

Responsible for identifying tenant information from incoming requests and initializing tenant context.

---

## Tenant Interceptor

Handles request lifecycle processing and validates tenant-specific behavior before controller execution.

---

## Tenant Context

Maintains tenant-specific data during request execution using thread-local storage or contextual handling.

---

## Dynamic Data Source Configuration

Supports tenant-aware database routing and datasource management.

---

## Tenant Logging Aspect

Implements aspect-oriented logging to trace tenant-specific operations and improve observability.

---

# ▶️ Running the Application

## Clone Repository

```bash
git clone <repository-url>
```

---

## Build Project

```bash
mvn clean install
```

---

## Run Application

```bash
mvn spring-boot:run
```

Application starts on:

```text
http://localhost:8080
```

---

# 📌 Key Learning Concepts

- Multi-Tenancy Architecture
- Tenant Isolation
- Spring Boot Interceptors
- Request Filtering
- ThreadLocal Context Management
- Dynamic Configuration Handling
- Aspect-Oriented Programming (AOP)
- Layered Application Design
- Repository-Service Pattern
- Enterprise Backend Design

---

# 👨‍💻 Author

Saket Satpute

---

# ⭐ Notes

This project is intended for learning and demonstrating enterprise-grade multi-tenancy implementation using Spring Boot and tenant-aware request processing.
