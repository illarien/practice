package SC

object T1 extends App{
  println("abcd")
  
  def factorial(x:BigInt):BigInt = 
  {if (x==0) 1 else x*factorial(x-1)}
  
  println(factorial(5))
  
}