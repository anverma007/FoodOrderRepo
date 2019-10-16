pipeline {
  environment {
    registry = "anverma007/docker-test"
    registryCredential = '99898731-1351-4371-9291-632dd3fe0ed5'
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