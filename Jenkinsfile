pipeline {
    agent any

    triggers {
        pollSCM('H/5 * * * *')
    }

    stages {
        stage('Test') {
            steps {
                echo 'Testing..'
                sh "chmod +x gradlew"
                sh './gradlew executeBDDTests'
            }
        }
    }
}
