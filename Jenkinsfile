pipeline {
    agent any

    triggers {
        githubPush()
    }
    environment {
        DOCKER_REGISTRY_CREDENTIALS = '04e4c6b1-c508-47c3-8671-5301de49e5be'
        DOCKER_IMAGE_BACKEND = 'alphascopic/myapp:backend'
        DOCKER_IMAGE_FRONTEND = 'alphascopic/myapp:frontend'
    }

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

                // Construire les images Docker
                script {
                    withDockerRegistry(credentialsId: "${DOCKER_REGISTRY_CREDENTIALS}") {
                        sh 'docker build -t ${DOCKER_IMAGE_BACKEND} .'
                        sh 'docker build -t ${DOCKER_IMAGE_FRONTEND} ./frontend'
                    }
                }

                echo 'Images Docker construites avec succès.'
            }
        }

        stage('Push Docker Images') {
            steps {
                echo 'Démarrage du push des images Docker...'

                // Pousser les images Docker vers Docker Hub
                script {
                    withDockerRegistry(credentialsId: "${DOCKER_REGISTRY_CREDENTIALS}") {
                        sh 'docker push ${DOCKER_IMAGE_BACKEND}'
                        sh 'docker push ${DOCKER_IMAGE_FRONTEND}'
                    }
                }

                echo 'Images Docker poussées avec succès.'
            }
        }
    }
}
