# ===============================
# Etapa 1: Construir la aplicación
# ===============================
FROM maven:3.9.2-eclipse-temurin-23 AS builder
WORKDIR /app

# Copiamos solo el pom para aprovechar el cache de Maven
COPY pom.xml .
RUN mvn dependency:go-offline

# Copiamos el código fuente
COPY src ./src

# Compilamos el proyecto (sin tests para acelerar)
RUN mvn clean package -DskipTests

# ===============================
# Etapa 2: Ejecutar la aplicación
# ===============================
FROM eclipse-temurin:23-jre
WORKDIR /app

# Copiamos el jar generado desde la etapa de construcción
COPY --from=builder /app/target/*.jar app.jar

# Exponemos el puerto (Render usa variables de entorno)
ENV PORT=8080
EXPOSE 8080

# Comando para iniciar la app
ENTRYPOINT ["java","-jar","app.jar"]
