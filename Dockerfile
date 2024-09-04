# Utiliser une image Java officielle pour Java 11
FROM openjdk:21-jdk-slim

# Définir le répertoire de travail
WORKDIR /app

# Copier le fichier JAR généré par Spring Boot
COPY target/demo-0.0.1-SNAPSHOT.jar app.jar

# Exposer le port sur lequel l'application écoute
EXPOSE 8081

# Commande pour exécuter l'application
ENTRYPOINT ["java", "-Dspring.profiles.active=docker", "-jar", "app.jar"]