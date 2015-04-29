package ProfileRenamer.Scala

object CountFilesInFoldes extends GeneralMethods {
  
  def main(args:Array[String]): Unit = {
    val targetVersion = "-4.2-"
    var fullName = "";
    var counter = 0;
  
    var time = System.nanoTime()
    
    for (f <- LIST_OF_FILES) {  
        var command = new StringBuilder("");
        fullName = f.getCanonicalPath();

        if (fullName.contains(targetVersion)) {
          command.append(removeFolder(fullName))
          println(counter + " " + command)
          counter += 1;
        } 
    }
    time = System.nanoTime() - time
    System.out.println("Scala Ended: " + counter + " Total Number of files: " + LIST_OF_FILES.length + " Time, ms: " + time/1000000);
  }
  
  
}