# Use OpenJDK 17 Alpine as base image
FROM openjdk:17-alpine

# Set working directory inside the container
WORKDIR /app

# Copy the JAR file from the target directory
COPY target/MiniProject-1.0-SNAPSHOT.jar app.jar

# Expose port 8080 for the application
EXPOSE 8080

# Command to run the application
CMD ["java", "-jar", "app.jar"]
