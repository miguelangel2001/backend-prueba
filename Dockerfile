# ===========================
# Etapa 1: Construir la app
# ===========================
FROM maven:3.9.2-eclipse-temurin-23 AS builder
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# ===========================
# Etapa 2: Ejecutar la app
# ===========================
FROM eclipse-temurin:23-jre
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
