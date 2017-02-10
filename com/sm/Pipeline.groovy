package com.sm

class Pipeline implements Serializable{

  def script

  Pipeline(def script) {
    this.script = script
  }

  def runBuild(){
    script.echo script.currentBuild.toString()
  }

}

//return new Pipeline()