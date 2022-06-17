FROM eclipse-temurin:17-alpine

EXPOSE 8080

COPY target/RabbitMQ-tutorial-*.jar /RabbitMQ-tutorial.jar

ENTRYPOINT [ "java", "-jar", "/RabbitMQ-tutorial.jar" ]