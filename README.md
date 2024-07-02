# React-Js-and-Spring-Boot-Full-Stack-Project-CRUD

## Description

```
A simple Content Management System (CMS) allowing admins to upload and read posts, and users to read posts.

```
## Spring-backend

  > Spring Boot web java backend application that exposes a Rest API to manage the student datas.

  ### Tech 

  - Spring Boot
  - MyBatis
  - Lombok
  - JDBC
  - Postgres + Database

# Configuration

backend

 - Set up a PostgreSQL database and create the necessary tables with sql file.
 - Update the database connection configuration in the **application.properties** file:
    > spring.datasource.url=jdbc:postgresql://127.0.0.1:5432/pjdc_batch1
    >  spring.datasource.username=postgres
    >  spring.datasource.password=Maythukhaing

    >  mybatis.mapper-locations=classpath:mapper/AccountRepository.xml,mapper/PostRepository.xml
    >  mybatis.type-aliases-package=com.content_management.model

    >  spring.security.user.name=HtetAung
    >  spring.security.user.password=pass 
