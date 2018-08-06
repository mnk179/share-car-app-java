pipeline {
	
    agent any

    stages {
        stage ('Build') {
	    tools {
        	maven 'maven-3.5.4'
        	jdk 'jdk10'
    	    }
            steps {
                sh 'mvn -B -DskipTests -f ShareCar.Api/pom.xml clean package' 
            }
        }    
	stage('Deploy') {
	    agent { dockerfile true }
            steps {
                sh 'docker build -t sharecarapp .'
             }
        }
      
    }
}

