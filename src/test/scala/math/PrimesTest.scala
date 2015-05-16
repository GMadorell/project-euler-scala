package math

import org.scalatest.{FlatSpec, Matchers}

class PrimesTest extends FlatSpec with Matchers {
  "primes" should "represent the correct sequence" in {
    Primes.primes.take(20).toList should be(
      List(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71)
    )
  }

  "isPrime" should "return true for prime numbers" in {
    Primes.isPrime(2) should be(true)
    Primes.isPrime(3) should be(true)
    Primes.isPrime(5) should be(true)
    Primes.isPrime(7) should be(true)
  }

  it should "return false for non-prime numbers" in {
    Primes.isPrime(1) should be(false)
    Primes.isPrime(4) should be(false)
    Primes.isPrime(6) should be(false)
    Primes.isPrime(10) should be(false)
    Primes.isPrime(12) should be(false)
  }

  it should "work with integral types" in {
    Primes.isPrime(2L) should be(true)
    Primes.isPrime(2000000000000000L) should be(false)
    Primes.isPrime(BigInt(2)) should be(true)
  }

  "primeFactors" should "return a list with the same number if the given number is prime" in {
    Primes.primeFactors(2) should be(List(2))
    Primes.primeFactors(3) should be(List(3))
    Primes.primeFactors(5) should be(List(5))
    Primes.primeFactors(7) should be(List(7))
    Primes.primeFactors(17) should be(List(17))
  }

  it should "return a list with the prime factors for non-prime numbers" in {
    Primes.primeFactors(4) should be(List(2, 2))
    Primes.primeFactors(6) should be(List(2, 3))
    Primes.primeFactors(25) should be(List(5, 5))
    Primes.primeFactors(81) should be(List(3, 3, 3, 3))
  }

  it should "work well with very long numbers" in {
    Primes.primeFactors(123123123123123L) should be(List(3, 31, 41, 41, 271, 2906161))
  }

  "getAllPrimesUpToN" should "return the sorted primes <= than the given number" in {
    Primes.getAllPrimesUpToN(1) should be(List())
    Primes.getAllPrimesUpToN(3) should be(List(2, 3))
    Primes.getAllPrimesUpToN(4) should be(List(2, 3))
    Primes.getAllPrimesUpToN(10) should be(List(2, 3, 5, 7))
    Primes.getAllPrimesUpToN(20) should be(List(2, 3, 5, 7, 11, 13, 17, 19))
    Primes.getAllPrimesUpToN(82) should be(
      List(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79)
    )
  }
}
