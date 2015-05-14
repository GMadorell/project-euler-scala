package solutions.AAE_SmallestMultiple

import math.{Primes, Multiple}

object SmallestMultiple extends App {
  /**
   *  2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
   *
   *  What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
   */


  /*
   * The idea of this solution is to take all the numbers that are evenly divisible by the last number of the
   * range and check whether they are also evenly divisible by all the others, starting from the second
   * biggest number. This way we skip having to check a lot of numbers.
   */
  val startRange = 1
  val endRange = 20
  val numbersToCheck = List.range(startRange, endRange).reverse  // Don't take the last element of the range.
  val solution = Iterator
    .from(endRange, endRange)
    .dropWhile(!Multiple.isMultipleOfAll(numbersToCheck)(_))
    .next()

  println("Solution to 'Smallest Multiple': " + solution)

  /*
   * The idea behind the following more optimized solution is to find the prime factors
   * of each number of the interval, and store the maximum count of each prime number
   * required to do the prime factors.
   *
   * Then, we just elevate each prime to its count and multiply the results.
   */
  var primeFactorsMap = collection.mutable.Map[Int, Int]() withDefaultValue 0
  for (i <- 2 to 21) {
    val primeDecompositionCountMap = Primes.primeFactors(i)
      .foldLeft(Map[Int, Int]() withDefaultValue 0)((map, n) => map + (n -> (map(n) + 1)))
    primeDecompositionCountMap.foreach {
      case(prime, count) => primeFactorsMap += (prime -> Math.max(count, primeFactorsMap(prime)))
    }
  }

  val primeFactorsSolution =
    primeFactorsMap.foldLeft(1) { case (accumulator, (prime, count)) => accumulator * Math.pow(prime, count).toInt }

  println("Solution to 'Smallest Multiple' with prime factors: " + primeFactorsSolution)

  require(solution == primeFactorsSolution)
}
