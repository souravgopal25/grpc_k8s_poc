# Start with a base image containing Java runtime
FROM openjdk:17-alpine

# Make port 8080 available to the world outside this container
EXPOSE 8080

ADD target/greet-service.jar greet-service.jar

# Run the jar file
ENTRYPOINT ["java","-jar","greet-service.jar"]