


def location
def buildNumber 
def gitBranch
def pacLog

	
def startStage(stage){
    println "###### Entering::pipelineTrace.startStage ######"

	pacLog = new File(location + "/PAC.log")
	def timeStamp = new Date().format('yyyy-MM-dd HH:mm:ss.SSS')
    pacLog.append([timeStamp, buildNumber, gitBranch].join("; ") + " ::Begin " + stage + '\r\n')
	
    println "###### Exiting::pipelineTrace.startStage ######"
}


def endStage(stage){
    println "###### Entering::pipelineTrace.endStage ######"

	pacLog = new File(location + "/PAC.log")
	def timeStamp = new Date().format('yyyy-MM-dd HH:mm:ss.SSS')
    pacLog.append([timeStamp, buildNumber, gitBranch].join("; ") + " ::Complete " + stage + '\r\n')
	
    println "###### Exiting::pipelineTrace.endStage ######"
}

def output(text){
    println "###### Entering::pipelineTrace.output ######"

	pacLog = new File(location + "/PAC.log")
    pacLog.append(text + '\r\n')
	
    println "###### Exiting::pipelineTrace.output ######"
}

def logError(text){
    println "###### Entering::pipelineTrace.logError ######"

	pacLog = new File(location + "/PAC.log")
	def timeStamp = new Date().format('yyyy-MM-dd HH:mm:ss.SSS')
    pacLog.append([timeStamp, buildNumber, gitBranch].join("; ") + " ::End " + stage + '\r\n')
	
    println "###### Exiting::pipelineTrace.logError ######"
}


 return this
