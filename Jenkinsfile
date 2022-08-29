pipeline {
  agent any
  stages {
    stage('BUILD') {
      steps {
        sh 'mvn clean install'
      }
    }

    stage('TEST') {
      steps {
        sh '''echo Test 
'''
      }
    }

    stage('POST BUILD') {
      steps {
        archiveArtifacts(artifacts: '**/*.war', onlyIfSuccessful: true)
      }
    }

    stage('DEPLOY') {
      steps {
        sh '''cp target/*.war /var/lib/jenkins/deploy/spark.war'''

      }
    }

  }
}
