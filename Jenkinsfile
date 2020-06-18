pipeline {
    agent any
    tools {
        maven 'maven363'
    }
    stages {
        stage('GEt maven version') {
            steps {
                sh 'mvn --version'
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
}
