pipeline {
    agent any
    tools {
        maven 'maven363'
    }
    stages {
        stage('GEt maven version And clean package') {
            parallel {
                stage('Maven version') {
                    steps {
                        sh 'mvn --version'
                    }
                }
                stage('Clean Package') {
                    steps {
                        sh 'mvn clean'
                    }
                }
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn package -DskipTests'
            }
        }
        stage('Build docker image') {
            steps {
                sh "docker build -t yrosman/test-cicd-gaglo:v1.0.${BUILD_NUMBER} ."
            }
        }
        stage('Analyse du code') {
            withSonarQubeEnv('sonar') {
                sh "./mvnw -ntp initialize sonar:sonar"
            }
        }
        /*stage('Sanity check') {
            steps {
                input "Voulez-vous lancer l'image docker ?"
            }
        }
        stage('Running docker image') {
            steps {
                script{
                    try{
                        sh 'docker rm -f test-cicd'
                    } catch(exc) {
                        echo '[ERROR] => Error de suppression du container'
                    }
                }
                sh "docker run --name test-cicd -d -p 8081:8081 yrosman/test-cicd-gaglo:v1.0.${BUILD_NUMBER}"
            }
        }*/
        stage('Push docker image to the Hub') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'docker-hub-login', usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {
                    sh "docker login -u $DOCKER_USERNAME -p $DOCKER_PASSWORD"
                    sh "docker push yrosman/test-cicd-gaglo:v1.0.${BUILD_NUMBER}"
                }
            }
        }
    }
    post {
        always {
            echo 'I will always say Hello World again !!!'
            junit 'target/surefire-reports/*.xml'
            archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
        }
    }
}
