# selenium-framework

Introduction:
-------------
The Test Automation Framework is created using Selenium WebDriver using Java bindings and supports Junit/TestNG & Cucumber BDD. The framework is primarily used for testing web applications but extendible to Mobile using Appium/Selendroid (not covered here). There is also a docker-compose script to setup Selenium Grid (optional). The framework approach has been used to integrate with Jira/Xray (for Project/Test Management) and Jenkins (for CI/CD).

Pre-requisites:
---------------
Java jdk-1.8 or higher (http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
Apache Maven 3 or higher (https://maven.apache.org/)
Selenium (https://www.seleniumhq.org/download/)

Steps to Use:
-------------
1. Setup: 
    - Clone the repository (git clone git@git.planittesting.com:spasham/jira-selenium-docker.git) OR
    - Download zip and extract to a local directory
2. Execution: 
    - MAVEN: mvn clean test (command line or using lifecycle goals from IDE)
	- TESTNG: use testng.xml to run the tests
	- BDD: use RunTests class to run BDD feature files
3. Optional Configuration/Parameters: 
    - Local Variables: BROWSER, NODE, PLATFORM
    - Global System Variables: -Dbrowser -Dnode -Dplatform (for command-line/jvm runtime/jenkins options)
    - Selenium Grid setup by Docker-Compose


