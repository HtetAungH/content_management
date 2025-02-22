# React-Js-and-Spring-Boot-Full-Stack-Project-CRUD

## Description

```
A simple Content Management System (CMS) allowing admins to upload and read posts, and users to read posts.

```

# Simple Content Management System (CMS)

## 📌 System Requirements

1. **Admin**:
   - Can upload posts
   - Can read posts

2. **User**:
   - Can only read posts

##    Features

- **Admin Interface**: A user-friendly interface for administrators to create, edit, and delete posts.
- **User Interface**: A simple and clean interface for users to browse and read posts.
- **Authentication**: Secure login system to differentiate between admins and users.

## Spring-backend

  > Spring Boot web java backend application that exposes a Rest API to manage the content datas.

### Tech 

  - Spring Boot
  - MyBatis
  - Lombok
  - JDBC
  - Postgres + Database

## System Requirement

- Java Development Kit (JDK) 8 
- Apache Maven (for building the project)
- PostgreSQL Database
- Web Browser (Chrome, Firefox, etc.)
  
### Running the Application

To run the application locally:

1. Clone the repository:
    ```bash
    git clone https://github.com/yourusername/your-repo.git
    ```
2. Navigate to the project directory:
    ```bash
    cd your-repo
    ```
3. Build the application:
    ```bash
    mvn clean install
    ```
4. Run the application:
    ```bash
    mvn spring-boot:run
    ```

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
    

