FROM maven:3.9.5-eclipse-temurin-17-alpine AS build

WORKDIR /app
COPY pom.xml .
COPY src ./src

# Build the application
RUN mvn clean package -DskipTests

# Find and copy the JAR file (handles different naming patterns)
RUN find target -name "*.jar" -not -name "*sources.jar" -not -name "*javadoc.jar" -exec cp {} app.jar \;

FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

# Copy the JAR file
COPY --from=build /app/app.jar .

# Expose the port (adjust per service)
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]