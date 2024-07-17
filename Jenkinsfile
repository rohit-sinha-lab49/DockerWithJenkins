pipeline {
    agent any
    tools{
        maven 'Maven3'
    }
    stages{
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
            steps{
            withCredentials([usernamePassword(credentialsId: 'dockerhubcred', passwordVariable: 'dockerusername', usernameVariable: 'dockerpwd')]) {
            script{
                //bat 'docker login -u ${dockerusername} -p ${dockerpwd}'
                bat """
                echo %dockerusername% | docker login -u %dockerpwd% --password-stdin
                """
                }
            }
                /* withCredentials([string(credentialsId: 'dockerhub-pwd', variable: 'dockerhubpwd')]) {
                        bat 'docker login -u rohitsinha025@gmail.com -p Hanuman@1209'
                        }  */
                bat 'docker push rohitsinha025/jenkins-docker'
            }
        }
    }
}