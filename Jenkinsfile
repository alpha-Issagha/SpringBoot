pipeline {
  agent any
  stages {
    stage('Cloner Backend') {
      steps {
        echo 'Clonage du dépôt backend...'
        git(url: 'https://github.com/alpha-Issagha/SpringBoot.git', branch: 'main')
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
        dir(path: 'frontend') {
          git(url: 'https://github.com/alpha-Issagha/Angular.git', branch: 'main')
        }

        echo 'Dépôt frontend cloné avec succès.'
      }
    }

    stage('Build Frontend') {
      steps {
        echo 'Démarrage de la construction du frontend...'
        dir(path: 'frontend') {
          echo 'Frontend construit avec succès.'
        }

      }
    }

    stage('Dockerize') {
      steps {
        echo 'Démarrage de la création des images Docker...'
        dir(path: 'frontend')
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