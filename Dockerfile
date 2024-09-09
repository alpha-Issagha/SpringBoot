# Étape 1 : Construire l'application avec Maven
FROM maven:3.9.5 AS build

# Définir le répertoire de travail pour Maven
WORKDIR /app

# Copier le fichier de configuration Maven (pom.xml)
COPY pom.xml ./

# Télécharger les dépendances nécessaires (étape de mise en cache)
RUN mvn dependency:go-offline -B

# Copier le code source du projet
COPY src ./src

# Effectuer un clean et construire l'application avec Maven
RUN mvn clean package -DskipTests

# Étape 2 : Utiliser une image Java légère pour exécuter l'application
FROM openjdk:21-jdk-slim

# Définir le répertoire de travail pour l'application finale
WORKDIR /app

# Copier le fichier JAR généré lors de l'étape précédente
COPY --from=build /app/target/demo-0.0.1-SNAPSHOT.jar app.jar

# Exposer le port sur lequel l'application Spring Boot écoute
EXPOSE 8081

# Commande pour exécuter l'application avec le profil 'docker'
ENTRYPOINT ["java", "-Dspring.profiles.active=docker", "-jar", "app.jar"]