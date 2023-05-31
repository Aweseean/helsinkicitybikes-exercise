# Helsinki City Bikes application
This is the Helsinki City Bikes application made as an exercise. Based on Solita Dev Academy Finland pre-assignment.  https://github.com/solita/dev-academy-2023-exercise

Made with Java, Spring Boot, Thymeleaf and Bootstrap.

### Dockerized PostgreSQL

Run PostgreSQL image with Docker

``
docker run --detach --name hcb-postgres -p 5432:5432 -e POSTGRES_PASSWORD=hcb_pass -e POSTGRES_USER=hcb_user -e POSTGRES_DB=helsinkicitybikes -d postgres
``

### How to build and run with Docker

Package with Maven:

``
mvn clean package -DskipTests=true
``

Build Docker image (in the project folder directory):

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