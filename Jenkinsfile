pipeline {
    agent any
    tools{
        maven 'Maven3'
    }
    stages{
        stage('SCM'){
                steps{
                    git branch: 'main', changelog: false, poll: false, url: 'https://github.com/rohit-sinha-lab49/DockerWithJenkins'
                }
            }
        stage('Build Maven'){
            steps{
                bat 'mvn clean install'
            }
        }
        stage('Build docker image & Push'){
            steps{
                script{
                    withDockerRegistry(credentialsId: 'rohitsinha025-dockerhub') {
                    // some block
                        bat 'docker build -t rohitsinha025/jenkins-docker .'
                        bat 'docker push rohitsinha025/jenkins-docker'
                    }
                }
            }
        }
    }
        post{
            always{
                bat 'docker logout'
            }
        }

}