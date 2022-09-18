package Lectures.part2afp

object CurringPAFs extends App{

  val superAdder : Int => Int=> Int =
    x => y => x + y

  val add3: Int => Int = superAdder(3)  // y => 3 + y
  val eight = add3(5)

  val eight_v2 = superAdder(3)(5)
  println(eight_v2)

  // curriedFunction
  def curriedAdder(x: Int)(y: Int) : Int = x + y

  // method ! = function values

  // converting method to functions
  val add4 = curriedAdder(4)(_) // eta-expansion
  // eta-expansion obtained lambda from methods and then convert into function values
  val nine = add4(5)
  println(nine)

  def increment(x: Int): Int = x + 1
  val aList = List(1,2,3)
  val anIncrementalList = aList.map(increment) // eta-expansion

  println(anIncrementalList)


  // underscore are powerful

  def concatenator(a: String, b: String, c: String) = a + b + c

  val insertName = concatenator("sumit ",_, " arora") // x => concatenator("...",x,"...")
  println(insertName("kumar"))

  val fillInTheBlanks = concatenator(_:String,"Sumit",_: String) // (x,y) => concatenator(x, "...", y)
  println(fillInTheBlanks("Hi","Arora"))














}
