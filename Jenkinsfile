pipeline {
  agent any

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
        sh 'docker build -t backend-image -f Dockerfile-backend .'
        
        // Construire l'image Docker pour le frontend
        dir('frontend') {
          sh 'docker build -t frontend-image -f Dockerfile-frontend .'
        }

        echo 'Images Docker créées avec succès.'
      }
    }

    stage('Deploy') {
      steps {
        echo 'Démarrage du déploiement des images Docker...'
        
        // Lancer les services avec Docker Compose
        sh 'docker-compose up -d'
        
        echo 'Déploiement terminé avec succès.'
      }
    }
  }
}
