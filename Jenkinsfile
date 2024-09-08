pipeline {
    agent any

    stages {
        stage('Cloner Backend') {
            steps {
                echo 'Clonage du dépôt backend...'
                // Cloner le dépôt backend
                git url: 'https://github.com/alpha-Issagha/SpringBoot.git', branch: 'main'
                echo 'Dépôt backend cloné avec succès.'
            }
        }
        
        stage('Build Backend') {
            steps {
                echo 'Démarrage de la construction du backend...'
                // Simuler la construction backend
                // sh 'mvn clean install'
                echo 'Backend construit avec succès.'
            }
        }
        
        stage('Cloner Frontend') {
            steps {
                echo 'Clonage du dépôt frontend...'
                // Cloner le dépôt frontend dans un sous-dossier "frontend"
                dir('frontend') {
                    git url: 'https://github.com/alpha-Issagha/Angular.git', branch: 'main'
                }
                echo 'Dépôt frontend cloné avec succès.'
            }
        }
        
        stage('Build Frontend') {
            steps {
                echo 'Démarrage de la construction du frontend...'
                dir('frontend') {
                    // Simuler la construction frontend
                    // sh 'npm install && npm run build'
                    echo 'Frontend construit avec succès.'
                }
            }
        }

        stage('Dockerize') {
            steps {
                echo 'Démarrage de la création des images Docker...'
                // Simuler la création des images Docker
                // sh 'docker build -t backend-image .'
                
                dir('frontend') {
                    // Simuler la création de l'image Docker pour le frontend
                    // sh 'docker build -t frontend-image .'
                }
                echo 'Images Docker créées avec succès.'
            }
        }

        stage('Deploy') {
            steps {
                echo 'Déploiement des images Docker...'
                // Simuler le déploiement
                // sh 'docker-compose up -d'
                echo 'Déploiement terminé avec succès.'
            }
        }
    }
}
