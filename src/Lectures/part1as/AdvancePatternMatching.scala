package Lectures.part1as

object AdvancePatternMatching extends App{

  val numbers = List(1)

  val description = numbers match {
    case head:: Nil => println( s"the only element is $head")
    case _ =>


  }

  /* pattern matching scenarios
  - constants
  - wild cards
  - case classes
  - tuples
  - some special logic like above
  */

  // if for some reason you don't have case class and still you want pattern matching

  class Person(val name: String, val age: Int )

  object Person{

    def unapply(arg: Person): Option[(String, Int)] =
      if(arg.age <20) None
      else Some((arg.name , arg.age))

    // if you have more than one unapply method for more pattern matching
    def unapply(arg: Int): Option[String] =
      Some(if(arg <20) "minor" else "major")

  }

  val bob = new Person("bob", 19)

  val greeting = bob match {
    case Person(name, age) =>  s"Hi my name is $name and age is $age"
    case _ => s"Sorry not allowed"
  }
  println(greeting)


  val greeting2 = bob.age match{
    case Person(status) => s"My legal status is $status"
  }
  println(greeting2)


  /*
  * Exercise
  * */


  object SingleDigit{
    def unapply(arg: Int):  Boolean = arg < 10
  }

  object even {
    def unapply(arg: Int): Boolean = arg % 2 ==0
  }

  val n: Int = 9

  val mathProperty = n match{
    case SingleDigit() => "single digit"
    case even() => "an even nubmer"
    case _ => "no property"
  }

  println(mathProperty)

}
