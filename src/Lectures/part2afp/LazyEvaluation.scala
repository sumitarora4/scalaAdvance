package Lectures.part2afp

object LazyEvaluation {
    lazy  val x : Int = {
    println("Hello")
    42
  }

  // lazy delays evaluation of value util the first use
  // evaluation occur once


  // call by need = call by name + lazy evaluation

  // example 1
  def byNameMethod(n: =>  Int): Int = {
    n + n + n + 1
  }

  def retrieveByMagicValue() = {
    println("waiting...")
    Thread.sleep(1000)
    42
  }

  def demoByName()={
    println(byNameMethod(retrieveByMagicValue()))
  }

  def byNeedMethod(n: => Int): Int = {
    lazy val lazyN = n // memoization
    lazyN + lazyN + lazyN + 1
  }

  def demoByNeed() = {
    println(byNeedMethod(retrieveByMagicValue()))
  }


// example 2
  def lessThan30(i: Int): Boolean = {
    println(s"$i is less than 30 ?")
    i < 30
  }

  def greaterThan20(i: Int): Boolean= {
    println(s"$i is greater than 20?")
    i > 20
  }

  val numbers = List(1,3,5,6,8,26,45,30)

  def demoFilter():Unit = {
    val lt30 = numbers.filter(lessThan30)
    val gt20 = lt30.filter(greaterThan20)
    println(gt20)
  }

  // withFilter use lazy evaluation after having Map(identity) only
  def demoWithFilter(): Unit = {
    val lt30 = numbers.withFilter(lessThan30)
    val gt20 = lt30.withFilter(greaterThan20)
    println(gt20.map(identity))
  }

  // for Comprehension is also used for lazy evaluation of the value
  // so for comprehension internally use withFilter with guards
  def demoForComprehension(): Unit = {
    val forComp = for{
      n <- numbers if lessThan30(n) && greaterThan20(n)
    } yield n
    println(forComp)
  }

  def main(args: Array[String]):Unit ={
  println(x)
  println(x)
  demoByNeed()
//  demoFilter()
//  demoWithFilter()
    demoForComprehension()
  }


}
