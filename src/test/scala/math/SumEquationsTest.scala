package math

import org.scalatest.{Matchers, FlatSpec}

class SumEquationsTest extends FlatSpec with Matchers {
  "sumOfSquares" should "return the correct value" in {
    SumEquations.sumOfSquares(0) should be (0)
    SumEquations.sumOfSquares(1) should be (1)
    SumEquations.sumOfSquares(2) should be (5)
    SumEquations.sumOfSquares(3) should be (14)
    SumEquations.sumOfSquares(4) should be (30)
  }

  "sumUpToN" should "return the correct value" in {
    SumEquations.sumUpToN(0) should be (0)
    SumEquations.sumUpToN(1) should be (1)
    SumEquations.sumUpToN(2) should be (3)
    SumEquations.sumUpToN(3) should be (6)
    SumEquations.sumUpToN(4) should be (10)
    SumEquations.sumUpToN(5) should be (15)
  }

  "sumUntilN" should "return the correct value" in {
    SumEquations.sumUntilN(0) should be(0)
    SumEquations.sumUntilN(1) should be(0)
    SumEquations.sumUntilN(2) should be(1)
    SumEquations.sumUntilN(3) should be(3)
    SumEquations.sumUntilN(4) should be(6)
    SumEquations.sumUntilN(5) should be(10)
  }
}
