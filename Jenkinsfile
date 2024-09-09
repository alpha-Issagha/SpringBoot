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

stage('Build Docker Images') {
            steps {
                echo 'Démarrage de la construction des images Docker...'

                // Utilisation de Docker Compose pour build les images
                script {
                    withDockerRegistry(credentialsId: '04e4c6b1-c508-47c3-8671-5301de49e5be') {
                        sh 'docker build -t alphascopic/myapp:tag11 .'
                    }
                }
                
                echo 'Images Docker construites avec succès.'
            }
        }

        stage('Push Docker Images') {
            steps {
                echo 'Démarrage du push des images Docker...'

                // Utilisation de Docker Compose pour pousser les images vers Docker Hub
                script {
                    withDockerRegistry(credentialsId: '04e4c6b1-c508-47c3-8671-5301de49e5be') {
                        sh 'docker push alphascopic/myapp:tag11'
                    }
                }

                echo 'Images Docker poussées avec succès.'
            }
        }
    }
}
