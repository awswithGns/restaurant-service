pipeline {
    agent any

    environment {
        DOCKERHUB_CREDENTIALS = credentials('DOCKER_HUB_CREDENTIAL')
        VERSION = "${env.BUILD_ID}"
    }

    tools {
        maven "Maven"
    }

    stages {
        stage('Maven Build') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Run Tests') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Docker Build and Push') {
            steps {
                sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
                sh 'docker build -t gajusawale/restaurant-listing-service:${VERSION} .'
                sh 'docker push gajusawale/restaurant-listing-service:${VERSION}'
            }
        }

        stage('Cleanup Workspace') {
            steps {
                deleteDir()
            }
        }
    }
}
