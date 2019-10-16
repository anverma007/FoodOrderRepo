pipeline {
  environment {
    registry = "anverma007/docker-test"
    registryCredential = '42a355b0-2928-4ca4-9e7d-ca1b3d702609'
  }
  agent any
  stages {
    stage('Cloning Git') {
      steps {
        git 'https://github.com/anverma007/FoodOrderRepo.git'
      }
    }
  
  stage('Running junit testcases') {
      steps {
       sh 'mvn test'
      }
    }
    stage('Building image') {
      steps{
        script {
          dockerImage = docker.build registry + ":$BUILD_NUMBER"
        }
      }
    }
    stage('Deploy Image') {
      steps{
        script {
          docker.withRegistry( '', registryCredential ) {
            dockerImage.push()
          }
        }
      }
    }
    stage('Remove Unused docker image') {
      steps{
        sh "docker rmi $registry:$BUILD_NUMBER"
      }
    }
  }
}