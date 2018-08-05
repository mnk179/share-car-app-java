pipeline {
   
   agent none
   
    stages {
        stage ('Build') {
            agent {
				docker {
					image 'maven:3.5-jdk-10-slim'
				}
			}
            steps {
                sh 'mvn -B -DskipTests -f ShareCar.Api/pom.xml clean package' 
            }
        }
      
    }
}

