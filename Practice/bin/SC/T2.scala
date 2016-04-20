package SC

object T2 {
  
  def randomArray(n:Int) = {
    Seq.fill(n)(scala.util.Random.nextInt)
  }
  
  def printArray(a:Array[Int]): Unit = {
    for(i<-0.to(9))
      println(a(i))
  }
  
  def main(args:Array[String]): Unit = {
    println("AAA")
    
    val str: String = ""
    
    var arr:Array[Int] = new Array[Int](10)
    
    for (i<- 0.to(9)) {
      var r = scala.util.Random.nextInt
      arr(i) = r
    }
    
    printArray(arr)
      


    
    
    
  
  }

  
}