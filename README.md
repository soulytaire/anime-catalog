Anime Catalog

A full-stack web application for browsing and organizing anime and anime studios. The project is built as a monorepo.

## Technologies
Frontend: Angular, TypeScript, HTML, CSS
Backend: Java, Spring Boot, Spring Data JPA
DB: MySQL

## Design and Prototype
Figma: https://www.figma.com/design/vG0pta10p0946v3DGg9MQQ/Untitled?node-id=12-86&m=dev&t=lF8FYghZA7KsLqi5-1
<img width="4320" height="3120" alt="main-design" src="https://github.com/user-attachments/assets/9e030e84-f9ef-423e-b450-92e262ba07cf" />
<img width="1440" height="1024" alt="card-design" src="https://github.com/user-attachments/assets/d6072dca-f71e-40b7-8e0f-8478f32dcdd8" />

## Project Structure
backend/ — REST API server built with Spring Boot
frontend/ — client application built with Angular

## How to Run the Project
1. Database
Make sure MySQL is running and that the correct database connection settings are specified in backend/src/main/resources/application.properties.

2. Backend
cd backend
./mvnw spring-boot:run

3. Frontend
cd frontend
npm install
ng serve
