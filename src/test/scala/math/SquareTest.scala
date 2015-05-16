package math

import org.scalatest.{Matchers, FlatSpec}

class SquareTest extends FlatSpec with Matchers {
  "square" should "return the squared value of the given number" in {
    Square.square(1) should be (1)
    Square.square(2) should be (4)
    Square.square(3) should be (9)
    Square.square(4) should be (16)
    Square.square(10) should be (100)
    Square.square(100) should be (10000)
  }
}
