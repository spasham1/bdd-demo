node {
    
   def mvnHome
   stage('Code-Checkout') { // for display purposes
      // Get some code from a GitHub repository
      git 'https://github.com/spasham1/bdd-demo.git'
      // Get the Maven tool.
      // ** NOTE: This 'M3' Maven tool must be configured
      // **       in the global configuration.           
      mvnHome = tool 'M3'
   }
   stage('Build-Test') {
      // Run the maven build
      if (isUnix()) {
         sh "'${mvnHome}/bin/mvn' -Dmaven.test.failure.ignore clean package"
      } else {
         bat(/"${mvnHome}\bin\mvn" -Dmaven.test.failure.ignore clean package/)
      }
   }
   stage('Results') {
      //junit 'target/surefire-reports/TEST-*.xml'
      allure includeProperties: false, jdk: '', results: [[path: 'target/allure-results']]
   }
}