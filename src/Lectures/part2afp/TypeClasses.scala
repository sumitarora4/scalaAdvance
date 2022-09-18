package Lectures.part2afp

object TypeClasses {

  def main(args: Array[String]): Unit = {

    // real time scenario:
    // find sum of the list elements
    // if elements are integer then sum would be sum of all numbers
    // if elements are strings then sum would be concatenation of all strings values
    // else not applied sum and give error

    def processMyList[T](list: List[T])(implicit summable: Summable[T]): T = {
      summable.sumElements(list)
    }

    trait Summable[T] {
      def sumElements(list: List[T]): T
    }

    implicit object IntSummable extends Summable[Int]{
      override def sumElements(list: List[Int]): Int = list.sum
    }

    implicit object StringSummable extends Summable[String] {
      override def sumElements(list: List[String]): String = list.mkString("")
    }

    println(processMyList(List(1,2,3)))
    println(processMyList(List("scala","is","good")))
//    processMyList(List(true, false, true))  // will not even compile as compiler
                                              // cannot find an implicit instance of List Aggregation of boolean type
  }
}
