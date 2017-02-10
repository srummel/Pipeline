public class Pipeline {

  def script
  String message;

  Pipeline(def script) {
    this.script = script
  }

  def runBuild(){
    script.echo script.currentBuild.toString()
  }

}