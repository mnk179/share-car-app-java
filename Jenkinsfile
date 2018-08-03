pipeline {
    agent {
        docker {
            image 'maven:3-jdk-10' 
            args '-v /root/.m2:/root/.m2' 
        }
    }
    stages {
        stage('Build') { 
            steps {
                sh 'mvn -B -DskipTests -f ShareCar.Api/pom.xml clean package' 
            }
        }
    }
}
