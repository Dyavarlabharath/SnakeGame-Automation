pipeline {
    agent any

    stages {
        stage('Clone Repository') {
            steps {
                echo '📥 Cloning repository...'
                git branch: 'main', url: 'https://github.com/Dyavarlabharath/SnakeGame-Automation.git'
            }
        }

        stage('Build') {
            steps {
                echo '🏗️ Building Java project...'
                sh 'javac SnakeGame.java'
                echo '✅ Build completed successfully.'
            }
        }

        stage('Test') {
            steps {
                echo '🧪 Checking Java environment...'
                sh 'java -version'
                echo '✅ Test passed (GUI run skipped for Jenkins).'
            }
        }

        stage('Deploy') {
            steps {
                echo '🚀 Deployment simulation...'
                echo 'Snake Game build is ready to deliver!'
            }
        }
    }

    post {
        success {
            echo '🎯 Pipeline executed successfully!'
        }
        failure {
            echo '❌ Build or test failed. Check logs.'
        }
    }
}
