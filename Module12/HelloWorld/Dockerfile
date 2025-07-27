# Use a base image with OpenJDK
    FROM openjdk:11-jdk-slim
    # Set the working directory inside the container
    WORKDIR /app
    # Copy the Java source file into the container
    COPY HelloWorld.java .
    # display the following text on terminal/shell
    RUN echo "Installing or doing stuff."
    # Compile the Java program
    RUN javac HelloWorld.java
    # Set the default command to run when the container starts
    CMD ["java", "HelloWorld", "Hello from Docker, 605.784 class!"]