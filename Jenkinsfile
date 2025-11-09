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
                echo '🧪 Running basic test...'
                sh 'java SnakeGame & sleep 5 && pkill -f SnakeGame || true'
                echo '✅ Test executed successfully.'
            }
        }

        stage('Deploy') {
            steps {
                echo '🚀 Deployment simulation stage...'
                echo 'Snake Game is ready to play or deliver!'
            }
        }
    }

    post {
        success {
            echo '🎯 Pipeline executed successfully!'
        }
        failure {
            echo '❌ Build or test failed. Check console logs.'
        }
    }
}

