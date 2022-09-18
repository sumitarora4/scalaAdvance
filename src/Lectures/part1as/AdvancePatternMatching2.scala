package Lectures.part1as

object AdvancePatternMatching2 {

  def main(args: Array[String]): Unit = {

    // infix pattern
    case class or[A,B] (a: A, b: B)
    val either = or(2, "two")
    val humanDescription = either match{

      case number or string => s"$number is writen as $string"
    }

    println(humanDescription)


  }

}
