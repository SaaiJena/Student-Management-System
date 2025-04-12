# Step 1: Build the application
FROM maven:3.8.5-eclipse-temurin-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Step 2: Run the application using JDK 17
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY --from=build /app/target/student-management-system-0.0.1-SNAPSHOT.jar student-management-system.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "student-management-system.jar"]

