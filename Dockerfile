# ===========================
# Etapa 1: Construir la app
# ===========================
FROM maven:3.9.2-eclipse-temurin-23 AS builder

# Directorio de trabajo
WORKDIR /app

# Copiar archivos del proyecto
COPY pom.xml .
COPY src ./src

# Construir el JAR (ignorar tests)
RUN mvn clean package -DskipTests

# ===========================
# Etapa 2: Ejecutar la app
# ===========================
FROM eclipse-temurin:23-jre

WORKDIR /app

# Copiar el JAR generado en la etapa anterior
COPY --from=builder /app/target/*.jar app.jar

# Exponer puerto (igual que en application.properties)
EXPOSE 8080

# Ejecutar la aplicación
ENTRYPOINT ["java","-jar","app.jar"]
