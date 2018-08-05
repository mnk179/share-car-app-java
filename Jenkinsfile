pipeline {
    agent any
    tools {
        maven 'mvn-3.5.4'
        jdk 'jdk10'
    }
    stages {
        stage ('Build') {
            steps {
                sh 'mvn -B -DskipTests -f ShareCar.Api/pom.xml clean package' 
            }
        }
        stage('Docker Build') {
            agent any
            steps {
                sh 'docker build -t sharecarapp .'
             }
        }
    }
}
