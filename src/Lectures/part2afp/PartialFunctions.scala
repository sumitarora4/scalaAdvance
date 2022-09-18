package Lectures.part2afp

object PartialFunctions extends App {

  val aFunction = (x: Int) => x + 1 // Function1[Int, Int] ===  Int => Int

  // lets assume more than one values of x
  val aFussyFunction = (x: Int) => {

    if (x == 1) 42
    else if (x == 2) 56
    else if (x == 5) 199
    else throw new FunctionNotApplicationException
  }
    class FunctionNotApplicationException extends RuntimeException

  println(aFussyFunction(2))

  // similar normal function
  def aNormalFunction(x: Int) = {

    if (x == 1) 42
    else if (x == 2) 56
    else if (x == 5) 199
    else throw new FunctionNotApplicationException2
  }
    class FunctionNotApplicationException2 extends RuntimeException

  println(aNormalFunction(2))

  // with the help of pattern matching
  // total function
  val aNicerFussyFunction = (x: Int) => x match {
    case 1 => 42
    case 2 => 56
    case 5 => 199
  }
 // this is giving function format as {1,2,5} => Int


  // Now with in partial function format
  val aPartialFunction : PartialFunction[Int, Int] = {
    case 1 => 42
    case 2 => 56
    case 5 => 199
//    case _ => throw new FunctionNotApplicationException3
  }

//  class FunctionNotApplicationException3 extends RuntimeException

  println(aPartialFunction(2))
//  println(aPartialFunction(3))

  // partial Function utilities

  // isDefinedAt
  println(aPartialFunction.isDefinedAt(443344))

  // lift
  // partial function can be converted into total function by lift property
  // as it is giving result in Option
  println(aPartialFunction.lift(2))   //  Int => Option[Int]
  println(aPartialFunction.lift(4443))

  // orElse
  // orElse is used for partial function chain
  val pfChain = aPartialFunction.orElse[Int, Int]{
    case 66 => 100
  }

  println(pfChain(2))
  println(pfChain(66))

  // PF extends total function
  val aTotalFunction: Int => Int  ={
    case 1 => 99
  }

  // Higher order function accepts PF as well

  val aMappedList = List(1,2,3).map{
    case 1 => 11
    case 2 => 22
    case 3 => 33
  }

  println(aMappedList)
}

/*
*  Note: PF can only have one parameter type
* */