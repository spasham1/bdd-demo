pipeline {
    agent any
	
    environment {
        BROWSER = 'firefox'
        NODE = 'local'
		PLATFORM = 'windows'
    }
    stages {
        stage('Test') {
            steps {
				bat 'mvn -Dmaven.test.failure.ignore clean test -Dbrowser=%BROWSER% -Dnode=%NODE% -Dplatform=%PLATFORM%'			
            }
        }
        stage('Results') {
            steps {
                allure includeProperties: false, jdk: '', results: [[path: 'target/allure-results']] 
            }
        }		
    }
}