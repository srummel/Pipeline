
def location

{
def startStage(buildNumber, buildEnvironment, stage){
    echo "###### pipelineTrace.startStage::" + stage + "~~location=${location}::Start ######"

	File f = new File(location + "/PAC.log")
	def timeStamp = new Date().format('yyyy-MM-dd HH:mm:ss.SSS')
    f.append([timeStamp, buildNumber, buildEnvironment].join("; ") + " ::Begin " + stage + '\r\n')
	
    echo "** pipelineTrace.startStage::" + stage + "::Finish **"
}


def endStage(location, buildNumber, buildEnvironment, stage){
    echo "** pipelineTrace.endStage::" + stage + "::Start **"

	File f = new File(location + "/PAC.log")
	def timeStamp = new Date().format('yyyy-MM-dd HH:mm:ss.SSS')
    f.append([timeStamp, buildNumber, buildEnvironment].join("; ") + " ::Complete " + stage + '\r\n')
	
    echo "** pipelineTrace.endStage::" + stage + "::Finish **"
}

def output(text){
    echo "** pipelineTrace.endStage::" + stage + "::Start **"

	File f = new File(location + "/PAC.log")
    f.append(text + '\r\n')
	
    echo "** pipelineTrace.endStage::" + stage + "::Finish **"
}

def logError(text){
    echo "** pipelineTrace.logError::" + stage + "::Start **"

	File f = new File(location + "/PAC.log")
	def timeStamp = new Date().format('yyyy-MM-dd HH:mm:ss.SSS')
    f.append([timeStamp, buildNumber, buildEnvironment].join("; ") + " ::End " + stage + '\r\n')
	
    echo "** pipelineTrace.logError::" + stage + "::Finish **"
}
}
return this;
