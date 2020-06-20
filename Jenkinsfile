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
        stage('Sanity check') {
            steps {
                input "Est-ce que tout est OK ?"
            }
        }
        stage('Build docker image') {
            steps {
                sh 'docker build -t yrosman/test-cicd-gaglo:v1.0.0 .'
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
