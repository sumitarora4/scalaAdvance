package Lectures.part1as

import scala.util.Try

object DarkSugars {

  def main(args: Array[String]): Unit = {

    // syntax sugar1:   methods with single param
    def singleParamMethod(arg: Int): String = s"$arg little thing"

    val description = singleParamMethod{
      // write complex code
      31
    }

    val aTryInstance = Try{
      throw new RuntimeException
    }

    List(1,2,3).map{x => x +1}




    // syntax sugar 2: Single abstract Method(SAM)

    trait Action{
      def act(x: Int): Int
    }

    val anInstance : Action = new Action {
      override def act(x: Int): Int = x + 1
    }

    // so above can be converted into SAM experssion
    val aFunckyInstance : Action = (x: Int) => x + 1


    // another example:
      val aThread = new Thread(new Runnable {
        override def run(): Unit = println("a thread")
      })

    // above can be converted into SAM expression with lambda
    val aSweetThread = new Thread(() => println("a sweet thread"))


    // this can be done with not only Trait but also with abstract class

    abstract class AnAbstractType{
      def implementedMethod: Int = 31
      def unImplementedMethod(a: Int) : Unit
    }

    val anAbstractInstance: AnAbstractType = (a : Int) => println("an abstract Method implementation")




    // synatx sugar 3: the :: and #:: methods
    val prependentList = 3 :: List(4,5)

    //scala spec: last character decides associativity of the method
    1 :: 2:: 3 :: List(4,5)
    List(4,5).::(3).::(2). :: (1) //  equivalent



    // syntax sugar 4: multi-word method naming

    class TeenGirl(name: String){
      def `and then said`(message: String) = println(s"$name said $message")
    }

    val abha = new TeenGirl("Abha")
    abha `and then said`("scala is sweet")



    // syntax sugar 5: Infix types
    class Composite[A, B]
    val compoiste: Int Composite String = ???

    class --> [A,B]
    val towards: Int --> String = ???



    // syntax sugar 6: update() is special much like apply()

    val anArray = Array(2,34,9)
    anArray(2) = 6 // equivalent to anArray.update(2, 6)
    // used in mutable collection



    // syntax sugar 7: setters for mutable container

    class MutableContainer {

      private var internalMember : Int =0

      // getter method
      def member = internalMember

      // setter method
      def member_=(value: Int ) : Unit =
      internalMember = value
    }

    val aMutableContainerInstance = new MutableContainer
    aMutableContainerInstance.member = 42 // equivalent to aMutableContainerInstance.member_=(42)

    //  this will only allow if we have setter and getter methods already defined so we can assigned value to member variable

  }


}

