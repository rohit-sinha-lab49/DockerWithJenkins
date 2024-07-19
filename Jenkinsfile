pipeline {
    agent any
    tools{
        maven 'Maven3'
    }
    environment{
    DOCKER_HUB_CREDENTIALS = credentials('rohitsinha025-dockerhub')
    }
    stages{
    stage('Login'){
                steps{
                    bat 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
                }
            }
        stage('Build Maven'){
            steps{
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[credentialsId: '75640b0a-dece-46b2-95f5-781877fe7e39', url: 'https://github.com/rohit-sinha-lab49/DockerWithJenkins']])
                bat 'mvn clean install'
            }
        }
        stage('Build docker image'){
            steps{
                bat 'docker build -t rohitsinha025/jenkins-docker .'
            }
        }
        stage('Push image to hub'){
            steps {
                bat 'docker push rohitsinha025/jenkins-docker'
            }
        }
    }
        post{
            always{
                bat 'docker logout'
            }
        }

}