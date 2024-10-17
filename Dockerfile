# Use Maven to build the project
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Use a lightweight Java image to run the app
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/target/MidtermProject-1.0-SNAPSHOT.jar /app/MidtermProject.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "MidtermProject.jar"]
