 ecommerce

This is a e-Commerce REST API Sample by using Spring Boot API

#### Prerequisites or last compile by using this current version

* [OpenJDK 8]
* [Docker 19.03.12]
* [Maven 3.6+]


#### Running

At prompt level, type commands below:

    git clone https://github.com/romulofranco/ecommerce.git
    cd ecommerce

You can run the application by using maven directly or by using Docker
`` ` ``
mvn clean compile spring-boot:run
`` ` ``

By using docker, first build a image
`` ` ``
docker build -t springio/ecommerce . 
`` ` ``
Run an image created 
`` ` ``
docker run -p 8181:9090 springio/ecommerce
`` ` ``

In the both case, you should open app using:
`` ` ``
http://localhost:9090/login
`` ` ``

The payload credentials are: {"username":"romulo","password":"12345"} or provide this credentials in the default spring boot login page.

The documentation after login should be accessible on:
`` ` ``
http://localhost:9090/swagger-ui.html#/
`` ` ``

Or a demo can be accessed in:
`` ` ``
Heroku: https://romulo-ecommerce.herokuapp.com/
`` ` ``
Or in my Contabo Server:
`` ` ``

http://62.171.171.85:8080/

#### Endpoints

