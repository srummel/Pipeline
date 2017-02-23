#!/usr/bin/env groovy


def script




def execute() {

  def build = load "${env.WORKSPACE}/scripts/pipeline/stages/_MS_Build_Stage.groovy"
  build.nugetSlave = "${SLAVE_NUGET}"
  build.solutionPath = "${SOLUTION_PATH}"
  build.buildNumber = "${build_number}"
  build.packageType = "${Package_type}"
  build.execute()





}
def build(){

  def build = load "${env.WORKSPACE}/scripts/pipeline/stages/_MS_Build_Stage.groovy"
  build.nugetSlave = "${SLAVE_NUGET}"
  build.solutionPath = "${SOLUTION_PATH}"
  build.buildNumber = "${build_number}"
  build.packageType = "${Package_type}"
  build.execute()

}

return this