import jenkins.model.Jenkins
import hudson.model.User
import hudson.security.Permission
import hudson.EnvVars

def location
def buildNumber
def gitBranch
def pacLog
def testValue


def initTrace() {
  println "###### Entering::pipelineTrace.init ######"

  println Jenkins.instance.getJob('pac_test').lastBuild.workspace


  def pacLogFileName = location + "/PAC.log"
  println "###### pacLogFileName = " + pacLogFileName + " ######"
  if(build.workspace.isRemote())
  {
    println "###### pacLogFileName.build.workspace.isRemote ######"
    channel = build.workspace.channel
    println "###### pacLogFileName.build.workspace.isRemote ######"
    fp = new FilePath(channel, build.workspace.toString() + "/PAC.log")
  } else {
    println "###### pacLogFileName.build.workspace.isRemote NOT ######"
    fp = new FilePath(new File(build.workspace.toString() + "/PAC.log"))
  }

  if(fp != null)
  {
    fp.write("The fun starts here", null) //writing to file
  }

  println "###### Exiting::pipelineTrace.init ######"
}

def startStage(stage) {
  println "###### Entering::pipelineTrace.startStage::" + stage + " ######"


  println "###### pacLogFilePath = " + pacLog + " ######"

  def timeStamp = new Date().format('yyyy-MM-dd HH:mm:ss.SSS')
  pacLog.append([timeStamp, buildNumber, gitBranch].join("; ") + " ::Begin " + stage + '\r\n')

  println "###### Exiting::pipelineTrace.startStage::" + stage + " ######"
}

def endStage(stage) {
  println "###### Entering::pipelineTrace.endStage::" + stage + " ######"

  pacLog = new File(location + "/PAC.log")
  def timeStamp = new Date().format('yyyy-MM-dd HH:mm:ss.SSS')
  pacLog.append([timeStamp, buildNumber, gitBranch].join("; ") + " ::Complete " + stage + '\r\n')

  println "###### Exiting::pipelineTrace.endStage::" + stage + " ######"
}

def output(text) {
  println "###### Entering::pipelineTrace.output ######"

  pacLog = new File(location + "/PAC.log")
  pacLog.append(text + '\r\n')

  println "###### Exiting::pipelineTrace.output ######"
}

def logError(text) {
  println "###### Entering::pipelineTrace.logError ######"

  pacLog = new File(location + "/PAC.log")
  def timeStamp = new Date().format('yyyy-MM-dd HH:mm:ss.SSS')
  pacLog.append([timeStamp, buildNumber, gitBranch].join("; ") + " ::End " + stage + '\r\n')

  println "###### Exiting::pipelineTrace.logError ######"
}

return this
