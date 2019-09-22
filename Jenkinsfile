pipeline {
    agent any
    tools {
        gradle "Gradle"
    }
    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/davyd0309/SecurityService.git'
            }
        }
        stage('Build'){
            steps {
                sh 'gradle build'
            }
        }
    }
}
