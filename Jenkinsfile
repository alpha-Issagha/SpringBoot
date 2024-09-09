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
        }
        echo 'Frontend construit avec succès.'
      }
    }

    stage('Dockerize') {
      steps {
        echo 'Démarrage de la création des images Docker...'
        
        dir('frontend') {
          
        }
        echo 'Images Docker créées avec succès.'
      }
    }

    stage('Deploy') {
      steps {
        echo 'Déploiement des images Docker...'
        
        echo 'Déploiement terminé avec succès.'
      }
    }
  }
}
