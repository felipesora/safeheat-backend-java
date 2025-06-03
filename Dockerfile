# Etapa de build com OpenJDK 21
FROM eclipse-temurin:21-jdk AS build

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN ./mvnw clean install -DskipTests || mvn clean install -DskipTests

# Etapa de runtime com JDK leve
FROM eclipse-temurin:21-jdk-jammy

WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]