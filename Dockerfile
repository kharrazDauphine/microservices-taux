FROM openjdk:8
ADD target/microservice-taux.jar microservice-taux.jar
EXPOSE 8001
ENTRYPOINT ["java", "-jar", "microservice-taux.jar"]