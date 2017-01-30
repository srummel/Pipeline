package com


@Library('pacLog')
class pipelineTrace{ 
def location
def startStage(buildNumber, buildEnvironment, stage){
    println "###### pipelineTrace.startStage::" + stage + "~~location=${location}::Start ######"

	File f = new File(location + "/PAC.log")
	def timeStamp = new Date().format('yyyy-MM-dd HH:mm:ss.SSS')
    f.append([timeStamp, buildNumber, buildEnvironment].join("; ") + " ::Begin " + stage + '\r\n')
	
    println "** pipelineTrace.startStage::" + stage + "::Finish **"
}


def endStage(location, buildNumber, buildEnvironment, stage){
    println "** pipelineTrace.endStage::" + stage + "::Start **"

	File f = new File(location + "/PAC.log")
	def timeStamp = new Date().format('yyyy-MM-dd HH:mm:ss.SSS')
    f.append([timeStamp, buildNumber, buildEnvironment].join("; ") + " ::Complete " + stage + '\r\n')
	
    println "** pipelineTrace.endStage::" + stage + "::Finish **"
}

def output(text){
    println "** pipelineTrace.endStage::" + stage + "::Start **"

	File f = new File(location + "/PAC.log")
    f.append(text + '\r\n')
	
    println "** pipelineTrace.endStage::" + stage + "::Finish **"
}

def logError(text){
    println "** pipelineTrace.logError::" + stage + "::Start **"

	File f = new File(location + "/PAC.log")
	def timeStamp = new Date().format('yyyy-MM-dd HH:mm:ss.SSS')
    f.append([timeStamp, buildNumber, buildEnvironment].join("; ") + " ::End " + stage + '\r\n')
	
    println "** pipelineTrace.logError::" + stage + "::Finish **"
}
}

 return new pipelineTrace()
