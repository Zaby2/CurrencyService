# Currency Service
____

## Description
This project is created to convert one currency to another. It is using API of https://freecurrencyapi.com/, but you can add your own.
The project is devided into three services, that are connected by REST API. All of this services are returning the simple json, so you can easily integrate  each of them into your system.


Note that in this project I worked with H2 database, so for your peoject you will need to do this steps:
1. Add PostgreSQL dependency to pom.xml
2. Download PostgreSQL driver, simular as for JDBC
3. Chages in application.properties:
spring.datasource.url=jdbc:postgresql://localhost:5432/customers
spring.datasource.username=root
spring.datasource.password=123

spring.datasource.driver-class-name=org.postgresql.Driver
spring.jpa.database=postgresql
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQL10Dialect

spring.datasource.initialization-mode=ALWAYS
spring.datasource.schema=classpath*:database/initDB.sql
#spring.datasource.data=classpath*:database/populateDB.sql

## TODO
1. Adding Spring Cloud Eureka server, for flexibility of the whole system and add Load Balancer
2. Later it is better to change REST API to Kafka of RabbitMQ
3. Put constant variables into application.properties file
