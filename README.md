# codefellowship

## Overview

This repository includes some basic implementation of Spring Authorization on a Java Web Application.

## Architecture

The programing language used to build this project is Java and using the Spring MVC Data and Thymeleaf.

**Author**: Motasim Al-Azzam 


## Lab: 16 - Spring Auth and Lab: 17 - Spring Authorization

### Classes

* AppUser

* Post

* WebSecurityConfig

* AppUserController

* HomeController

* PostController

* UserDetailServiceImpl

* DemoApplication

### Interfaces

* AppUserRepository

* PostRepository

### Routers:

#### [http://localhost:8080/signup](http://localhost:8080/signup)

* This route is for a page that contains a signup form.

#### [http://localhost:8080/login](http://localhost:8080/login)

* This route is for a page that allows the user to log into the site.

#### [http://localhost:8080/myprofile](http://localhost:8080/myprofile)

* This route is for a page that allows the user to view the user's profile.

#### [http://localhost:8080/post](http://localhost:8080/post)

* This route is for a page that allows the user write a post.

#### [http://localhost:8080/users/{id}](http://localhost:8080/users/{id})

* This route for a page that displays users based on user id.

### Getting Started

To run the app you shoud follow the folloing steps:

1. [Getting started with Spring](https://spring.io/guides/gs/serving-web-content/) : This website show you how to build an application by **Spring**.

 * This is the dependencies build.gradle file

```
    developmentOnly 'org.springframework.boot:spring-boot-devtools'
	implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
	implementation 'org.springframework.boot:spring-boot-starter-security'
	implementation 'org.springframework.boot:spring-boot-starter-thymeleaf'
	implementation 'org.springframework.boot:spring-boot-starter-web'
	implementation 'org.thymeleaf.extras:thymeleaf-extras-springsecurity5'
	runtimeOnly 'org.postgresql:postgresql'
	testImplementation 'org.springframework.boot:spring-boot-starter-test'
	testImplementation 'org.springframework.security:spring-security-test'
 ```
2. In **application.properties** file you shode put thess lines:

```
spring.datasource.port=8080
spring.sql.init.platform=postgres
spring.datasource.url=jdbc:postgresql://localhost:5432/<<put the postgres name>>
spring.datasource.username=<<postgres username>
spring.datasource.password=<<postgres password>>
spring.jpa.database=POSTGRESQL
spring.jpa.show-sql=true
spring.jpa.generate-ddl=true
spring.jpa.hibernate.ddl-auto=create-drop
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation=true
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
```

3.  You should run the POSTGRESQL on the trminal by using these commands"

   * sudo service postgresql start
   
   * sudo -i -u postgres

   * psql

   * \connect <<`database name`>>

   * \dt 


### I worked with **Maryam Najjar** as a partner.

 
 ## Lab: 18 - Spring Security against User Input

 ### Routers:

 #### [http://localhost:8080/users](http://localhost:8080/users)

 * This route for a page that displays all users and also the user can follow any user by click on the Follow button.

 #### [http://localhost:8080/following](http://localhost:8080/following)

 * This route for a page that allows the user to view a list of the users he/she has followed.

 #### [http://localhost:8080/feed](http://localhost:8080/feed)

 * This route for a page that allows the user to view the posts of the users he/she has followed.

 ### I worked with **Maryam Najjar** as a partner.

