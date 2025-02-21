# Use OpenJDK 17 Alpine as base image
FROM openjdk:17-alpine

# Install OpenSSH server
RUN apk add --no-cache openssh \
    && ssh-keygen -A  # Generate host keys

# Set working directory inside the container
WORKDIR /app

# Copy the JAR file from the target directory
COPY target/MiniProject-1.0-SNAPSHOT.jar app.jar

# Enable SSH key-based authentication
RUN sed -i 's/#PermitRootLogin prohibit-password/PermitRootLogin yes/' /etc/ssh/sshd_config && \
    sed -i 's/#PasswordAuthentication yes/PasswordAuthentication no/' /etc/ssh/sshd_config

# Expose application on 9090 and SSH on 2222
EXPOSE 9090 22

# Start SSH in the background and keep the container alive
CMD ["/bin/sh", "-c", "ssh-keygen -A && /usr/sbin/sshd && exec java -jar /app/app.jar"]
