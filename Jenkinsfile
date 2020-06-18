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
    }
}
