package solutions.AAC_LargestPrimeFactor

import math.Primes

object LargestPrimeFactor extends App {
  /**
   * The prime factors of 13195 are 5, 7, 13 and 29.
   *
   * What is the largest prime factor of the number 600851475143 ?
   */

  val solution = Primes.primeFactors(600851475143L).last
  println("Solution to 'Largest Prime Factor': " + solution)
}
