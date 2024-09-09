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
        sh 'mvn clean install'  // Assurez-vous que Maven est installé et configuré
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
          sh 'npm install && npm run build'  // Assurez-vous que Node.js et npm sont installés
        }
        echo 'Frontend construit avec succès.'
      }
    }

    stage('Dockerize') {
      steps {
        echo 'Démarrage de la création des images Docker...'
        sh 'docker build -t backend-image .'
        dir('frontend') {
          sh 'docker build -t frontend-image .'
        }
        echo 'Images Docker créées avec succès.'
      }
    }

    stage('Deploy') {
      steps {
        echo 'Déploiement des images Docker...'
        sh 'docker-compose up -d'
        echo 'Déploiement terminé avec succès.'
      }
    }
  }
}
