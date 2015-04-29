package ProfileRenamer.Scala

class GeneralMethods {

  val path = FoldersSc.en_US
  val folder = new java.io.File (path);
  val LIST_OF_FILES = folder.listFiles()
  
  
  def fixSpaces (in: String): String = {
    var out = new StringBuilder("");
    for (c <- in) {
      if ( c ==' ' ) {
        out.append("\\ ")
      } else if ( c == '&' ) {
        out.append("\\&")
      } else {
        out.append(c)
      }
    }
    out.toString()
  }
  
  def removeFolder (in: String): String = {
    return in.substring(path.length()+1);
  }
  
  def removeFolder2 (in: String): String = {
    return in.substring(path.length());
  }
}