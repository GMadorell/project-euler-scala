package solutions.AAJ_SummationOfPrimes

import math.Primes

object SummationOfPrimes extends App {
  /**
   * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
   *
   * Find the sum of all the primes below two million.
   */

  val solution = Primes.getAllPrimesUpToN(2000000).sum
  println("Solution to 'Summation Of Primes': " + solution)
}
