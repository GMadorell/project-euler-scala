package math

import Multiple._
import spire.math.Integral
import spire.implicits._

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
}
