pipeline {
    agent any
    tools {
        maven 'Maven 3.3.9'
        jdk 'jdk10'
    }
    stages {
        stage ('Build') {
            steps {
                sh 'mvn -B -DskipTests -f ShareCar.Api/pom.xml clean package' 
            }
        }
    }
}
