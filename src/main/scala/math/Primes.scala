package math

import math.Multiple._
import math.Square.square
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
    val crossLimit = Math.sqrt(n.toDouble).toInt
    val sieve = Array.fill(n+1)(false)
    for (i <- 4 to n by 2) sieve(i) = true
    for (i <- 3 to crossLimit by 2) {
      if (!sieve(i)) {
        for (j <- square(i) to n by 2 * i) {
          sieve(j) = true
        }
      }
    }

    val sievePrimes = collection.mutable.ListBuffer[Int]()
    for (i <- 2 to n) {
      if (!sieve(i)) sievePrimes.append(i)
    }
    sievePrimes.toList
  }
}
