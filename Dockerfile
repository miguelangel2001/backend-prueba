# ===============================
# Etapa 1: Construcción
# ===============================
FROM maven:3.9.9-eclipse-temurin-23 AS builder
WORKDIR /app

# Copiar pom.xml y descargar dependencias para cache
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copiar el código fuente
COPY src ./src

# Empaquetar la aplicación (sin tests para acelerar build)
RUN mvn clean package -DskipTests

# ===============================
# Etapa 2: Runtime
# ===============================
FROM eclipse-temurin:23-jre
WORKDIR /app

# Copiar JAR final desde la etapa anterior
COPY --from=builder /app/target/*.jar app.jar

# Puerto para Render
ENV PORT=8080
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
