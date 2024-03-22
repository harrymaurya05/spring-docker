# Use the official Maven image to create a build artifact
FROM maven:3.8.4-openjdk-17-slim AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package

# Use OpenJDK for running the application
FROM openjdk:17-slim
WORKDIR /usr/app
COPY --from=build /app/target/learn-0.0.1-SNAPSHOT.jar /usr/app/demo.jar

# Expose port
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "demo.jar"]
