FROM openjdk:17-oracle
ADD target/helsinkicitybikes-0.0.1-SNAPSHOT.jar //
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/helsinkicitybikes-0.0.1-SNAPSHOT.jar"]