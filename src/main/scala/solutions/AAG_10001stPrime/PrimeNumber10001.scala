package solutions.AAG_10001stPrime

import math.Primes

object PrimeNumber10001 extends App {
  /**
   * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
   *
   * What is the 10 001st prime number?
   */

  /*
   * Straight away solution (it was already optimized beforehand).
   */
  val solution = Primes.primes(10000)
  println("Solution to '10001st Prime: " + solution)
}
