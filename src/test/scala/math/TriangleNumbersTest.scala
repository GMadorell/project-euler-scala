package math

import org.scalatest.{Matchers, FlatSpec}

class TriangleNumbersTest extends FlatSpec with Matchers {
  "triangleNumbers" should "be the correct sequence" in {
    TriangleNumbers.triangleNumbers.take(10).toList should be(List(1, 3, 6, 10, 15, 21, 28, 36, 45, 55))
  }
}
