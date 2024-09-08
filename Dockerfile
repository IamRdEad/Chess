# Stage 1: Build the Maven project
FROM maven:3.8.4-openjdk-17 AS build

# Set the working directory
WORKDIR /app

# Copy the pom.xml to download dependencies
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy the source code
COPY src ./src

# Build the application, skipping tests
RUN mvn clean package -DskipTests

# Stage 2: Run the application using a lighter image
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the built JAR file from the previous stage
COPY --from=build /app/target/Chess-0.0.1-SNAPSHOT.jar .

# Expose the port that the application runs on
EXPOSE 8080

# Define the command to run the JAR file
ENTRYPOINT ["java", "-jar", "/app/Chess-0.0.1-SNAPSHOT.jar"]
