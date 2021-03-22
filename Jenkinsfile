pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building..'
                echo "Branch Name (GIT_BRANCH) : ${env.GIT_BRANCH}"
                echo "Branch Name (BRANCH_NAME) : ${env.BRANCH_NAME}"
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying.......'
            }
        }
    }
}
