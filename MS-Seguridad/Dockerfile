#mvn --version
# Etapa 1: Construir la aplicación con Maven
FROM maven:3.6.3-openjdk-17 AS build
WORKDIR /home/app
COPY . /home/app
RUN mvn -f /home/app/pom.xml clean package -DskipTests  

# Etapa 2: Ejecutar la aplicación con Java
FROM openjdk:17
WORKDIR /app
VOLUME /tmp
EXPOSE 80
COPY --from=build /home/app/target/*.jar app.jar
ENV SPRING_PROFILES_ACTIVE=docker

ENTRYPOINT ["java", "-jar", "/app/app.jar"]
