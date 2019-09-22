pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/davyd0309/SecurityService.git'
            }
        }
        stage('Build'){
            steps {
                sh 'gradlew build'
            }
        }
    }
}