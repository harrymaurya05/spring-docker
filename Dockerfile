# Use the official Maven image to create a build artifact
FROM maven:3.8.4-openjdk-17-slim AS build
WORKDIR /app
COPY pom.xml .
# Install dependencies
RUN mvn dependency:go-offline
# Copy the rest of the source code
COPY src ./src
# Build the application
RUN mvn package

# Use OpenJDK for running the application
FROM openjdk:17-slim
WORKDIR /usr/app
# Copy the built JAR file from the previous stage
COPY --from=build /app/target/learn-0.0.1-SNAPSHOT.jar /usr/app/demo.jar

# Expose port
EXPOSE 8080 5005

ENTRYPOINT ["java", "-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005", "-jar", "demo.jar"]
