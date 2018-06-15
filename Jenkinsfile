pipeline {
    agent any
	
    environment {
        BROWSER = 'firefox'
        NODE = 'localhost'
    }
    
    stages {
        stage('Test') {
            steps {
				bat 'mvn -Dmaven.test.failure.ignore clean test'			
            }
        }
        stage('Results') {
            steps {
                allure includeProperties: false, jdk: '', results: [[path: 'target/allure-results']] 
            }
        }		
    }
}
