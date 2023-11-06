# Authentication API
![MODELO](https://github.com/lfelipessilva/senac-spring-api/assets/75910800/ee157669-1a74-49d8-84f0-073f70a0eeb5)

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)
![JWT](https://img.shields.io/badge/JWT-black?style=for-the-badge&logo=JSON%20web%20tokens)


This project is an API built using **Java, Java Spring, Flyway Migrations, PostgresSQL as the database, and Spring Security and JWT for authentication control.**

The API was developed for my [Youtube Tutorial](https://www.youtube.com/watch?v=5w-YCcOjPD0), to demonstrate how to configure Authenticatio and Authorization in Spring application using Spring Security.

## Table of Contents

- [Installation](#installation)
- [Configuration](#configuration)
- [Usage](#usage)
- [API Endpoints](#api-endpoints)
- [Authentication](#authentication)
- [Database](#database)
- [Contributing](#contributing)

## Installation

1. Clone the repository:

```bash
git clone https://github.com/lfelipessivla/senac-spring-api.git
```

2. Instale as dependências com o Maven

3. Instale o  [Mysql](https://www.mysql.com/)

4. Insira as credênciais do banco no application.properties

5. Rode o comando SQL dentro de /resources/db/migration manualmente no banco

6. Ou você pode rodar usando docker-compose

## Usage

1. Start the application with Maven
2. The API will be accessible at http://localhost:8080


## API Endpoints
The API provides the following endpoints:

```markdown
POST /auth/login - Login into the App

POST /auth/register - Register a new user into the App
```

## Authentication
The API uses Spring Security for authentication control. The following roles are available:

```
USER -> Standard user role for logged-in users.
ADMIN -> Admin role for managing partners (registering new partners).
```
To access protected endpoints as an ADMIN user, provide the appropriate authentication credentials in the request header.