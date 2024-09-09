pipeline {
    agent any

    stages {
        stage('Cloner Backend') {
            steps {
                echo 'Clonage du dépôt backend...'
                git url: 'https://github.com/alpha-Issagha/SpringBoot.git', branch: 'master'
                echo 'Dépôt backend cloné avec succès.'
            }
        }

        stage('Cloner Frontend') {
            steps {
                echo 'Clonage du dépôt frontend...'
                dir('frontend') {
                    git url: 'https://github.com/alpha-Issagha/Angular.git', branch: 'master'
                }
                echo 'Dépôt frontend cloné avec succès.'
            }
        }

        stage('Build and Deploy with Docker Compose') {
            steps {
                echo 'Démarrage de la création des images Docker et du déploiement...'
                
                // Utilisation de Docker Compose pour build et deploy
                sh 'docker compose -f docker-compose.yml up --build -d'
                
                echo 'Déploiement terminé avec succès.'
            }
        }
    }
}
