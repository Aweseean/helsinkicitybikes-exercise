# Helsinki City Bikes application
This is the Helsinki City Bikes application made for Solita Dev Academy Finland 2023 pre-assignment.

Made with Java, Spring Boot, Thymeleaf and Bootstrap.

### How to build and run with Docker

Package with Maven:

``
mvn clean package -DskipTests=true
``

Build Docker image:

``
docker build -t helsinkicitybikes .
``

Run Docker image:

``
docker run --name hcb-app -p 8080:8080 -d helsinkicitybikes
``

### How to build and run (without Docker)

Package with Maven (as shown previously above).

Run the jar file:

``
java -jar target/helsinkicitybikes-0.0.1-SNAPSHOT.jar
``

Open http:/localhost:8080/ with browser.