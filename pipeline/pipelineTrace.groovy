


def location
def buildNumber 
def gitBranch

	
def startStage(stage){
    println "###### pipelineTrace.startStage::" + stage + "~~location=${location}~~v=${buildNumber}~~gitBranch= ${gitBranch}::Start ######"

File pacLog = new File(location + "/PAC.log")
	def timeStamp = new Date().format('yyyy-MM-dd HH:mm:ss.SSS')
    pacLog.append([timeStamp, buildNumber, buildEnvironment].join("; ") + " ::Begin " + stage + '\r\n')
	
    println "###### pipelineTrace.startStage::" + stage + "~~location=${location}~~v=${buildNumber}~~gitBranch= ${gitBranch}::Finish ######"
}


def endStage(stage){
    println "** pipelineTrace.endStage::" + stage + "::Start **"

File pacLog = new File(location + "/PAC.log")
	def timeStamp = new Date().format('yyyy-MM-dd HH:mm:ss.SSS')
    pacLog.append([timeStamp, buildNumber, buildEnvironment].join("; ") + " ::Complete " + stage + '\r\n')
	
    println "** pipelineTrace.endStage::" + stage + "::Finish **"
}

def output(text){
    println "** pipelineTrace.endStage::" + stage + "::Start **"

File pacLog = new File(location + "/PAC.log")
    pacLog.append(text + '\r\n')
	
    println "** pipelineTrace.endStage::" + stage + "::Finish **"
}

def logError(text){
    println "** pipelineTrace.logError::" + stage + "::Start **"

File pacLog = new File(location + "/PAC.log")
	def timeStamp = new Date().format('yyyy-MM-dd HH:mm:ss.SSS')
    pacLog.append([timeStamp, buildNumber, buildEnvironment].join("; ") + " ::End " + stage + '\r\n')
	
    println "** pipelineTrace.logError::" + stage + "::Finish **"
}


 return this
