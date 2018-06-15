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
                git 'https://github.com/spasham1/bdd-demo.git'
            }
        }
        stage('Build Test') {
            steps {
				  if (isUnix()) {
					 sh "mvn -Dmaven.test.failure.ignore clean package"
				  } else {
					 bat 'mvn -Dmaven.test.failure.ignore clean test -Dbrowser=$BROWSER -Dnode=$NODE -Dplatform=$PLATFORM'
				  }				
            }
        }
        stage('Results') {
            steps {
                allure includeProperties: false, jdk: '', results: [[path: 'target/allure-results']] 
            }
        }		
    }
}