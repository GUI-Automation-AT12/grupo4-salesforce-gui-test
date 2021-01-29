pipeline {
    agent any 

    triggers {
        pollSCM('H/5 * * * *')
    }
        stage('Test') {
            steps {
                echo 'Testing..'
                sh "chmod +x gradlew"
                sh './gradlew test'
            }
        }
        stage('Run BDD Tests') {
            steps {
                catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
                    echo 'Running BDD Tests...'
                    sh './gradlew executeBDDTests'
                }
            }
            post {
                always {
                    archiveArtifacts 'build/jsonTarget/site/cucumber.html'
                }
            }
        }
    }
}
