node {

   pipeline {
  environment {
    registry = "anverma007/docker-test"
    registryCredential = 'bcf3dccf-8877-42e2-949e-dbf787c7f5fc'
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

}
