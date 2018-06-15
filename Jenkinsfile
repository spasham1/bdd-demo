pipeline {
    agent any
	
    environment {
        BROWSER = 'firefox'
        NODE = 'local'
		PLATFORM = 'windows'
    }
    stages {
        stage('Code Checkout') {
            steps {
                git 'https://git.planittesting.com/spasham/jira-selenium-docker.git'
            }
        }
        stage('Build Test') {
            steps {
                mvn clean test -Dbrowser=$BROWSER -Dnode=$NODE -Dplatform=$PLATFORM
            }
        }
        stage('Results') {
            steps {
                allure includeProperties: false, jdk: '', results: [[path: 'target/allure-results']] 
            }
        }		
    }
}