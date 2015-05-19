package math

import math.collection.CollectionCount

object Divisors {
  def countDivisors(n: Int): Int = {
    val primeFactorsCounts: Map[Int, Int] = CollectionCount.countSeq(Primes.primeFactors(n))
    primeFactorsCounts.map { case (prime, count) => count }.map(_ + 1).product
  }
}
