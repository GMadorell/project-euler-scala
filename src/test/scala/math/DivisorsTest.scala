package math

import org.scalatest.{Matchers, FlatSpec}

class DivisorsTest extends FlatSpec with Matchers {
  "countDivisors" should "return the correct value" in {
    Divisors.countDivisors(2) should be(2)
    Divisors.countDivisors(3) should be(2)
    Divisors.countDivisors(4) should be(3)
    Divisors.countDivisors(6) should be(4)
    Divisors.countDivisors(10) should be(4)
    Divisors.countDivisors(15) should be(4)
    Divisors.countDivisors(21) should be(4)
    Divisors.countDivisors(28) should be(6)
    Divisors.countDivisors(48) should be(10)
  }
}
