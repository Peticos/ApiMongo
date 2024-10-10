# Build Package Stage
FROM maven:3.8.3-openjdk-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Package Stage
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/target/ApiMongoPeticos-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
