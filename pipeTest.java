
pipeline {
    agent any
    //tools { maven "maven-3.8.6" }
    stages {
        stage('Build') {
            steps {
                echo 'Building..'
                sh 'mvn clean package'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing nothing..'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
                script {
                deploy adapters: [tomcat9(credentialsId: "736b7f03-5044-4541-8689-98925309f0c5", path: "", url: "http://localhost:8080")], contextPath: "/pipeline", onFailure: false, war: "**/*.war"
                }
            }
        }    

    }
}




