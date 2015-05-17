package math

import math.Multiple._
import spire.implicits._
import spire.math.Integral

object Primes {
  val primes: Stream[Int] = Stream.cons(2, Stream.from(3, 2).filter(isPrime))

  def isPrime[A: Integral](n: A) = {
    val sqrtOfN = Math.sqrt(n.toDouble())
    (n > 1) && primes.takeWhile(_ <= sqrtOfN).forall(!isMultiple(_)(n))
  }

  def primeFactors[A: Integral](number: A): List[A] = {
    require(number > 1, "Prime factors of numbers <= 1 are not supported (and probably don't make sense, too).")
    def primeFactorsR(n: A, ps: Stream[Int]): List[A] =
      if (Primes.isPrime(n)) List(n)
      else if (isMultiple(ps.head)(n)) ps.head :: primeFactorsR(n /~ ps.head, ps)
      else primeFactorsR(n, ps.tail)
    primeFactorsR(number, primes)
  }

  def getAllPrimesUpToN(n: Int): List[Int] = {
    if (n <= 4) return primes.takeWhile(_ <= n).toList

    // Sieve of Eratosthenes implementation.
    val sieveBound = (n - 1) / 2
    val crossLimit = (Math.sqrt(n.toDouble).toInt - 1) / 2
    val sieve = Array.fill(sieveBound + 1)(false)
    for (i <- 1 to crossLimit) {
      if (!sieve(i)) {
        for (j <- 2 * i * (i + 1) to sieveBound by 2 * i + 1) {
          sieve(j) = true
        }
      }
    }

    val sievePrimes = sieve.zipWithIndex
      .filter { case (isNotPrime, index) => index >= 1 }
      .filter { case (isNotPrime, index) => !isNotPrime }
      .map { case (isNotPrime, index) => 2 * index + 1 }

    List(2) ::: sievePrimes.toList
  }
}
