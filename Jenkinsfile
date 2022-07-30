pipeline 
{
    agent any
    tools {
        maven 'maven'
    }

    stages 
    {
        stage('Build') 
        {
            steps 
            {
                 git 'https://github.com/jglick/simple-maven-project-with-tests.git'
                 bat "mvn -Dmaven.test.failure.ignore=true clean package"
            }
            post 
            {
                success 
                {
                    junit '**/target/surefire-reports/TEST-*.xml'
                    archiveArtifacts 'target/*.jar'
                }
            }
        }
        
        
        
        stage('Test') {
            steps {
                catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
                    git 'https://github.com/VedangDeshmukh/Pomproject'
                    bat "mvn clean install"
                }
            }
        }
                
     
        stage('Publish Allure Reports') {
           steps {
                script {
                    allure([
                        includeProperties: false,
                        jdk: '',
                        properties: [],
                        reportBuildPolicy: 'ALWAYS',
                        results: [[path: '/allure-results']]
                    ])
                }
            }
        }
        
        
        stage('Publish Extent Report'){
            steps{
                     publishHTML([allowMissing: false,
                                  alwaysLinkToLastBuild: false, 
                                  keepAll: false, 
                                  reportDir: 'build', 
                                  reportFiles: 'TestExecutionReport.html', 
                                  reportName: 'HTML Extent Report', 
                                  reportTitles: ''])
            }
        }
        
        
        
        stage('Email Report') {
        	steps{
   			 	// Change the recipent address
   			 	sh "zip -r allure-report.zip allure-report"
   				 def mailRecipients = "deshmukhvedang7@gmail.com"
 				 env.ForEmailPlugin = env.WORKSPACE
 				 if(fileExists('allure-report.zip')){
      				  		emailext(
       			     		to: "${mailRecipients}",
         			 		from: "deshmukhvedang7@gmail.com",
           					subject: "Allure Report",
            				body: "PFA",
           					attachmentsPattern: 'allure-report.zip')
    			}else{
						echo("COULD NOT FIND FILE TO ATTACH")
        			}
			}
		}	
        
        
   
        
    }
}