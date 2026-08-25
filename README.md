# 👨‍⚕️ HealthSync Doctor Service

Specialist Doctor Directory Microservice responsible for doctor profiles, specialist information, hospital affiliations, and consultation fees.

## Student Information

| Field | Details |
|---|---|
| Student Name | Matheesha Abiman |
| Student Number | 241722050 |
| Slack Handle | [YOUR SLACK HANDLE - OPTIONAL] |
| GCP Project ID | `[YOUR GCP PROJECT ID]` |


## Project Description

The Doctor Service provides the healthcare platform with a dedicated specialist doctor directory.

## Main Responsibilities

- Doctor profile management
- Medical specialist catalog
- Hospital affiliations
- Consultation fee information
- Doctor directory lookup

## Technology and Persistence

| Property | Value |
|---|---|
| Framework | Spring Boot 3 |
| Persistence | MongoDB |
| Database | `medicare` |
| Collection | `doctors` |
| Port | `8001` |
| Architecture | Microservice |

## Technology Stack

- Java
- Spring Boot 3
- Spring Cloud
- Maven
- REST APIs
- Git and GitHub
- Google Cloud Platform (GCP)

## Getting Started

### Prerequisites

- JDK 21 or 25
- Maven
- Git
- MySQL and/or MongoDB as required by the service
- Node.js and npm for the web application
- GCP access for cloud deployment

### Clone

```bash
git clone <REPOSITORY_URL>
cd <REPOSITORY_FOLDER>
```

### Run

```bash
mvn clean install
mvn spring-boot:run
```

## Service Integration

The Doctor Service participates in service discovery and can be accessed through the API Gateway.
 
## Parent Repository

Part of [medicare-healthsync-services](https://github.com/Matheesha-Abiman/medicare-healthsync-services).
