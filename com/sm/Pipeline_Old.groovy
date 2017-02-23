package com.sm

import java.*

class Pipeline  {

  def script

  Pipeline(def script) {
    this.script = script
  }

  def runBuild(){
    script.echo script.currentBuild.toString()
  }

}

//return new Pipeline()