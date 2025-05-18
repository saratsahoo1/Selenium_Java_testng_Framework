pipeline {
    agent any
    tools {
        maven 'Maven3.9.9'
        jdk 'JDK21'
    }
    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/saratsahoo1/Selenium_Java_testng_Framework.git'
            }
        }
        stage('Build and Test') {
            steps {
                bat 'mvn clean test -DsuiteXmlFile=testng.xml'
            }
        }
    }
    post {
        always {
            archiveArtifacts artifacts: '**/test-output/**/*.*', fingerprint: true
            junit '**/test-output/testng-results.xml'
        }
    }
}
