pipeline {
    agent { label 'linux'}
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