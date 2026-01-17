FROM maven:3.9.2-jdk-20 AS constructor
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

FROM eclipse-temurin:20-jre
WORKDIR /app
COPY --from=constructor /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
