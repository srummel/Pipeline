


def location
def buildNumber 
def gitBranch
def pacLog = new File(location + "/PAC.log")

def test(){
    println "###### Well this works!!!! ######"
}
	
def startStage(stage){
    println "###### pipelineTrace.startStage::Start ######"

	def timeStamp = new Date().format('yyyy-MM-dd HH:mm:ss.SSS')
    pacLog.append([timeStamp, buildNumber, gitBranch].join("; ") + " ::Begin " + stage + '\r\n')
	
    println "###### pipelineTrace.startStage::Complete ######"
}


def endStage(stage){
    println "** pipelineTrace.endStage::" + stage + "::Start **"

//File pacLog = new File(location + "/PAC.log")
	def timeStamp = new Date().format('yyyy-MM-dd HH:mm:ss.SSS')
    pacLog.append([timeStamp, buildNumber, gitBranch].join("; ") + " ::Complete " + stage + '\r\n')
	
    println "###### pipelineTrace.startStage::Complete ######"
}

def output(text){
    println "** pipelineTrace.endStage::" + stage + "::Start **"

File pacLog = new File(location + "/PAC.log")
    pacLog.append(text + '\r\n')
	
    println "###### pipelineTrace.startStage::Complete ######"
}

def logError(text){
    println "** pipelineTrace.logError::" + stage + "::Start **"

File pacLog = new File(location + "/PAC.log")
	def timeStamp = new Date().format('yyyy-MM-dd HH:mm:ss.SSS')
    pacLog.append([timeStamp, buildNumber, gitBranch].join("; ") + " ::End " + stage + '\r\n')
	
    println "###### pipelineTrace.startStage::Complete ######"
}


 return this
