# soluquim_back
This repository contains the back code for  the orders module with a simple CRUD/ fullstack developer 

Este repositorio contiene el backend del módulo de pedidos de EPP (Elementos de Protección Personal) desarrollado con **Java 17** y **Spring Boot** bajo una arquitectura limpia y modular.  


## Tecnologías utilizadas

- **Java 17**
- **Spring Boot 3**
- **Maven**
- **PostgreSQL**
- **Lombok**
- **Jakarta Validation**
- **Spring Data JPA**
- **Arquitectura hexagonal / limpia**

---
## Conexion a Postgres 
CREATE DATABASE epp_db;

spring:
  datasource:
    url: jdbc:postgresql://localhost:puerto/epp_db
    username: usuario
    password: tu_contraseña
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
    properties:
      hibernate:
        format_sql: true
server:
  port: pruert


