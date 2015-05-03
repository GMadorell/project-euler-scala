package solutions.AAA_MultiplesOf3And5

import math.Multiple

object MultiplesOfThreeAndFive extends App {
  /**
   * If we list all the natural numbers below 10 that are multiples of 3 or 5,
   * we get 3, 5, 6 and 9. The sum of these multiples is 23.
   *
   * Find the sum of all the multiples of 3 or 5 below 1000.
   */

  val isMultipleOf3: (Int) => Boolean = Multiple.isMultiple(3)
  val isMultipleOf5: (Int) => Boolean = Multiple.isMultiple(5)
  val isMultipleOf3Or5 = (n: Int) => isMultipleOf3(n) || isMultipleOf5(n)

  val solution = List.range(0, 1000).filter(isMultipleOf3Or5).sum

  println("Solution to 'Multiples of 3 and 5': " + solution)
}
