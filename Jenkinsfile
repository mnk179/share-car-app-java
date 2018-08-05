pipeline {
   
   agent none
   
    stages {
        stage ('Build') {
            agent none
	    tools {
        	maven 'maven-3.5.4'
        	jdk 'jdk10'
    	    }
            steps {
                sh 'mvn -B -DskipTests -f ShareCar.Api/pom.xml clean package' 
            }
        }    
	stage('Deploy') {
            agent any
            steps {
                sh 'docker build -t sharecarapp .'
             }
        }
      
    }
}

