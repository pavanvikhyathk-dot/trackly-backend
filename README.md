# Trackly Backend

Monolith backend for **Trackly**, a job-application tracker built to learn Java, Spring Boot, and microservices — the eventual plan is to decompose this into `trackly-eureka`, `trackly-gateway`, `trackly-auth-service`, `trackly-application-service`, and `trackly-stats-service` once the fundamentals are solid.

## Stack

- Java 21
- Spring Boot 4
- MongoDB (Spring Data MongoDB)
- MapStruct for DTO <-> entity mapping
- Maven (via the included wrapper, `./mvnw`)

## Running locally

1. Make sure MongoDB is running on `localhost:27017`
2. `./mvnw spring-boot:run`
3. App starts on `http://localhost:8080`

## Endpoints so far

- `POST /api/applications` - create a job application

## Docs

- [docs/annotations-glossary.md](docs/annotations-glossary.md) - plain-English notes on the annotations and tools used in this project
