# Use Maven to build the project
FROM maven:3.8.5-openjdk-17 AS builder

# Set the working directory in the container
WORKDIR /app

# Copy the pom.xml and src directory
COPY pom.xml .
COPY src ./src

# Package the application
RUN mvn clean package -DskipTests

# Use OpenJDK to run the application
FROM openjdk:17-jdk

# Set the working directory in the container
WORKDIR /app

# Copy the jar file from the builder stage
COPY --from=builder /app/target/demo-0.0.1-SNAPSHOT.jar /app/demo.jar

EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java", "-jar", "demo.jar"]
