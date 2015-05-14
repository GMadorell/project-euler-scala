package solutions.AAE_SmallestMultiple

import math.Multiple

object SmallestMultiple extends App {
  /**
   *  2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
   *
   *  What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
   */
  val startRange = 1
  val endRange = 20

  /*
   * The idea of the solution is to take all the numbers that are evenly divisible by the last number of the
   * range and check whether they are also evenly divisible by all the others, starting from the second
   * biggest number. This way we skip having to check a lot of numbers.
   */

  val numbersToCheck = List.range(startRange, endRange).reverse  // Don't take the last element of the range.
  val solution = Iterator
    .from(endRange, endRange)
    .dropWhile(!Multiple.isMultipleOfAll(numbersToCheck)(_))
    .next()

  println("Solution to 'Smallest Multiple': " + solution)
}
