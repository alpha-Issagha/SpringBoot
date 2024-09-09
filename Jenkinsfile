pipeline {
  agent any{
    tools {
      jdk 'OpenJDK21'  // Utiliser une image Docker Maven
      maven 'Maven3'  // Optionnel: monter le cache Maven
    }
  }

  stages {
    stage('Cloner Backend') {
      steps {
        echo 'Clonage du dépôt backend...'
        git(url: 'https://github.com/alpha-Issagha/SpringBoot.git', branch: 'master')
        echo 'Dépôt backend cloné avec succès.'
      }
    }

    stage('Build Backend') {
      steps {
        echo 'Démarrage de la construction du backend...'
        sh 'mvn clean package -DskipTests'  // Construire le backend avec Maven
        echo 'Backend construit avec succès.'
      }
    }

    stage('Cloner Frontend') {
      steps {
        echo 'Clonage du dépôt frontend...'
        dir('frontend') {
          git(url: 'https://github.com/alpha-Issagha/Angular.git', branch: 'master')
        }
        echo 'Dépôt frontend cloné avec succès.'
      }
    }

    stage('Build Frontend') {
      steps {
        echo 'Démarrage de la construction du frontend...'
        dir('frontend') {
          sh 'npm install && npm run build'  // Construire le frontend avec npm
        }
        echo 'Frontend construit avec succès.'
      }
    }

    stage('Dockerize') {
      steps {
        echo 'Démarrage de la création des images Docker...'
        
        // Construire l'image Docker pour le backend
        script { 
          withDockerRegistry(credentialsId: '04e4c6b1-c508-47c3-8671-5301de49e5be'){
                 sh 'docker build -t backend-image -f Dockerfile-backend .'
              }
        }
        
        // Construire l'image Docker pour le frontend
        dir('frontend') {
          script { 
              withDockerRegistry(credentialsId: '04e4c6b1-c508-47c3-8671-5301de49e5be'){
                 sh 'docker build -t frontend-image -f Dockerfile-frontend .'
              }
          }
          
        }

        echo 'Images Docker créées avec succès.'
      }
    }

    stage('Deploy') {
      steps {
        echo 'Démarrage du déploiement des images Docker...'
        
        // Déplacer le fichier docker-compose.yml depuis le dépôt backend
        
        script { 
              withDockerRegistry(credentialsId: '04e4c6b1-c508-47c3-8671-5301de49e5be'){
                  sh 'cp docker-compose.yml ../'
                  sh 'docker-compose up -d'
                  sh 'docker push'
              }
          }
        // Lancer les services avec Docker Compose
        sh 'docker-compose up -d'
        
        echo 'Déploiement terminé avec succès.'
      }
    }
  }
}
