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
    }
    post {
        always {
            echo 'I will always say Hello World again !!!'
        }
    }
}
