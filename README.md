# 📱 Mobile Store Microservice

A full-stack Spring Boot **microservice** application simulating an online mobile store, implementing distributed architecture, secured APIs, and service communication.

## 🚀 Project Overview

This project is designed around multiple microservices handling:
- **Mobile Service**: Manages mobile details (brands, models, pricing).
- **Customer Service**: Manages customer details (profiles, addresses).
- **Order Service**: Manages orders and order items (customer orders for mobiles).

All services communicate through:
- **API Gateway** (Centralized Routing)
- **Eureka Discovery Server** (Service Registration/Discovery)
- **Load Balancing** (Multiple instances)
- **JWT Security** (Admin and User login APIs)
- **Kafka Messaging** (Asynchronous communication)

---

## 🏛️ Microservice Structure

| Microservice            | Purpose |
|--------------------------|---------|
| `mobile-service`         | Mobile product details management |
| `customer-service`       | Customer profiles management |
| `order-service`          | Order and OrderItem management |
| `mobilestore-apigateway` | Central API Gateway for routing all services |
| `eureka-server`          | Service registry and discovery |
| `config-server-app`      | Centralized configuration management |
| `jwtsecurity`            | Practice project for secured endpoints |
| `producer-service` / `consumer-service` | Kafka event-based communication |

---

## 📚 Tech Stack

- Java 17
- Spring Boot 3.x
- Spring Cloud (Eureka, OpenFeign, Config Server)
- Spring Security + JWT Authentication
- Kafka (Producer/Consumer model)
- Maven
- Postman for API Testing
- GitHub for version control

---

## ⚙️ How to Run

1. Start the **Eureka Server** (`eureka-server`).
2. Start the **Config Server** (`config-server-app`).
3. Start the **API Gateway** (`mobilestore-apigateway`).
4. Start individual services:
   - `mobile-service`
   - `customer-service`
   - `order-service`
5. Access services through the Gateway:
http://localhost:8080/api/mobiles
http://localhost:8080/api/customers
http://localhost:8080/api/orders

> 🔐 Use JWT token for secured routes (admin/user dashboards).

6. Kafka producer and consumer services can be tested separately for event-driven messaging.

---

## ✨ Features

- Microservice communication via API Gateway
- Service discovery and registration (Eureka)
- JWT-secured endpoints for Admin/User roles
- Load balancing (multiple instances tested)
- Kafka asynchronous communication
- Centralized Configuration Server (Spring Cloud Config)

---

## 🧑‍💻 Author
- **Cyril Joshua** | Full Stack Java Developer
