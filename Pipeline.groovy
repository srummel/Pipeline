

//public class Pipeline implements Serializable{

//  def script
//
//  Pipeline(def script) {
//    this.script = script
//  }
//
//  def runBuild(){
//    script.echo script.currentBuild.toString()
//  }
{ ->

  stage('Build'){
    echo 'TEST'
  }


}
return this

//return new Pipeline()