# Dockerfile for CodeboxServer
# This Dockerfile builds a Docker image for the CodeboxServer application.
FROM openjdk:21-jdk-slim
WORKDIR /app
COPY target/*.jar codebox-server.jar
EXPOSE 8080
CMD ["java", "-jar", "codebox-server.jar"]