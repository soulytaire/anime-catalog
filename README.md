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

## Quick Project Setup

You do not need to install or configure any external database systems (such as MySQL) or have administrator rights to run the application. The H2 database is created automatically in memory when the backend starts.

1. Running the Backend (Spring Boot)
Open the backend folder in IntelliJ IDEA.
If the project is not recognized automatically, right-click the pom.xml file and select Add as Maven Project.
Run the main class ItwsApplication.java.
The server will start on port 8080.

Checking if the backend is working:

REST API: http://localhost:8080/api/anime
H2 Database Console: http://localhost:8080/h2-console
(Connection settings: JDBC URL: jdbc:h2:mem:testdb, User: sa, leave the Password field empty.)
2. Running the Frontend (Angular)
Open the frontend folder in VS Code (or in a terminal).
Install the project dependencies (you only need to do this once, the first time you run the project):
npm install
ng serve
