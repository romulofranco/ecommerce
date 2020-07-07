## eCommerce Spring Boot Rest API
This is a e-Commerce REST API Sample by using Spring Boot API

#### Prerequisites
- [OpenJDK 8]
- [Docker 19.03.12]
- [Maven 3.6+]

#### Running

At prompt level, type commands below:

    git clone https://github.com/romulofranco/ecommerce.git
    cd ecommerce


You can run the application by using maven directly or by using a Docker container

Maven:
 
    mvn clean compile spring-boot:run

By using docker, first build an image

    docker build -t springio/ecommerce . 

Run an image that you've created 

    docker run -p 8181:9090 springio/ecommerce


### Get Access to it

In the both case (Maven or Docker), you should get access to app using:

    http://localhost:9090/login
 
The payload credentials can be used on postman and these are: 
    *{"username":"romulo","password":"12345"}*    
or provide that in the default spring boot login page.

### Demo

A demo can be accessed in:
  
    Heroku: https://romulo-ecommerce.herokuapp.com/

Or in Docker container on my Contabo Server:

    http://62.171.171.85:8181/

#### Endpoints and API Doc

After login, the documentation should be accessible on:

    http://localhost:9090/swagger-ui.html#/


