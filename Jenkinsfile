pipeline {
    agent any
	
    environment {
        BROWSER = 'chrome'
        NODE = 'local'
    }
    
    stages {
        stage('Test') {
            steps {
				bat 'mvn -Dmaven.test.failure.ignore clean test -Dbrowser=%BROWSER% -Dnode=%NODE%'			
            }
        }
        stage('Results') {
            steps {
                allure includeProperties: false, jdk: '', results: [[path: 'target/allure-results']] 
            }
        }		
    }
}
