package ProfileRenamer.Scala

object UpdateHttpsEveryWhere2 extends GeneralMethods {

    val TARGET_VERSION = "default";
    var fullName = "";
    var command = new StringBuilder();
    var counter = 0;
  
  def main(args:Array[String]): Unit = {

    for (f <- LIST_OF_FILES) {       
//      try {
        fullName = f.getCanonicalPath();

        if (fullName.contains(TARGET_VERSION)) {
          command.append(fullName);
          counter += 1;
          System.out.println(counter + " " + command);      
//          JsonEditor2.modifyJSON(fullName);
        } 
//      } catch (Exception e) {e.printStackTrace();}
    }
    System.out.println("Ended: " + counter + " Total Number of files: " + LIST_OF_FILES.length);
  }
}