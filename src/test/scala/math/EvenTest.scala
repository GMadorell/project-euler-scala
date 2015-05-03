package math

import org.scalatest.{Matchers, FlatSpec}

class EvenTest extends FlatSpec with Matchers {
  "isEven" should "return true for even numbers" in {
    Even.isEven(0) should be (true)
    Even.isEven(-2) should be (true)
    Even.isEven(-4) should be (true)
    Even.isEven(-1000) should be (true)
    Even.isEven(2) should be (true)
    Even.isEven(4) should be (true)
    Even.isEven(1000) should be (true)
  }

  it should "return false for odd numbers" in {
    Even.isEven(-1) should be (false)
    Even.isEven(-3) should be (false)
    Even.isEven(-1999) should be (false)
    Even.isEven(1) should be (false)
    Even.isEven(3) should be (false)
    Even.isEven(1999) should be (false)
  }

  "isOdd" should "return true for odd numbers" in {
    Even.isOdd(-1) should be (true)
    Even.isOdd(-3) should be (true)
    Even.isOdd(-1999) should be (true)
    Even.isOdd(1) should be (true)
    Even.isOdd(3) should be (true)
    Even.isOdd(1999) should be (true)
  }

  it should "return false for even numbers" in {
    Even.isOdd(0) should be (false)
    Even.isOdd(-2) should be (false)
    Even.isOdd(-4) should be (false)
    Even.isOdd(-1000) should be (false)
    Even.isOdd(2) should be (false)
    Even.isOdd(4) should be (false)
    Even.isOdd(1000) should be (false)
  }
}
