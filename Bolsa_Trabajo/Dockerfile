# Usa la imagen base de OpenJDK
FROM openjdk:17

# Copia el JAR de la aplicación al contenedor
COPY target/Bolsa_Trabajo-0.0.1-SNAPSHOT.jar /app.jar

WORKDIR /app

# Expone el puerto en el que la aplicación Spring Boot se ejecutará
EXPOSE 8090

# Comando para ejecutar la aplicación cuando el contenedor se inicia
CMD ["java", "-jar", "/app.jar"]
