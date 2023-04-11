@Library('utils') _

pipeline {
    agent {
        node {
            label "ci"
        }
    }
    stages {
        stage('first') {
            steps {
                container("maven") {
                    sh 'mvn -version'
                    println "hello"
                }
            }
        }
        stage('second') {
            steps {
                container("node") {
                    sh "node -v"
                    getBranchName()
                }
            }
        }
    }
}