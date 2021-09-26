## Bookstore Demo

Spring Boot - React Demo app.

### Backend - Spring Boot maven app:
* Root directory: bookstore

*To run the maven Spring Boot app go into root directory - bookstore:*
```
cd bookstore
mvn spring-boot:run
```

### MySQL Database Configuration:
*Database name: bookstoredb*
*Update: application.properties in the resources directory with your SQL parameters*
```
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5Dialect
spring.datasource.url=jdbc:mysql://YOUR_HOSTNAME:SQL-PORT/DB-NAME?serverTimezone=UTC&reconnect=true
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.username=<SQL-Username>
spring.datasource.password=<SQL-Password>
```

### MySQL Database Data dump:
*Creata Database: bookstoredb*
*Table name: book*

```
create database bookstoredb;
create schema bookstoredb;
use bookstoredb;

CREATE TABLE "bookstoredb.book"(
    ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 100000, INCREMENT BY 1),
    author VARCHAR(255), 
    is_finished NUMBER(0),
    rating REAL,
    url VARCHAR(255));

INSERT INTO bookstoredb.book(author,is_finished,rating,url)
VALUES
('Robin Wieruch', '1', '3', 'https://images-na.ssl-images-amazon.com/images/I/41+WkW8xuAS._SX258_BO1,204,203,200_.jpg', '2017'),
('Tomcy John', '0', '4', 'https://www.booktopia.com.au/covers/big/9781788995979/0000/hands-on-spring-security-5-for-reactive-applications.jpg', '2020'),
('Felipe Paul Gutierrez', '1', '4', 'https://images.thenile.io/r1000/9781484236758.jpg', '2016'),
('Gene Kim', '1', '4.5', 'https://m.media-amazon.com/images/I/41YpWJi9OoL._SY346_.jpg', '2018'),
('Joyce Farrell', '0', '3', 'https://images.thenile.io/r1000/9781337397070.jpg', '2018'),
('Nathan Clark', '1', '3', 'https://m.media-amazon.com/images/I/41N8dZQdldL.jpg', '2018'),
('Joakim Verona', '0', '3.5', 'https://m.media-amazon.com/images/I/51-lY0PtmnL.jpg', '2016');
```