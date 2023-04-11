@Library('utils') _

pipeline {
    agent {
        kubernetes {
             defaultContainer 'maven'
             yaml """
                apiVersion: v1
                kind: Pod
                metadata:
                  labels:
                    app: my-app
                spec:
                  containers:
                  - name: maven
                    image: maven:3.6.3-jdk-11-slim
                    command:
                    - cat
                    tty: true
                  - name: node
                    image: node
                    command:
                    - cat
                    tty: true
             """
        }
    }
    stages {
        stage('first') {
            steps {
                container('maven') {
                    sh 'mvn -version'
                    println 'hello'
                }
            }
        }
        stage('second') {
            steps {
                container('node') {
                    sh 'node -v'
                    hello()
                }
            }
        }
    }
}