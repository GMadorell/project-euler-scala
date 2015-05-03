package math

import org.scalatest.{Matchers, FlatSpec}

class FibonacciTest extends FlatSpec with Matchers {
  it should "return the correct fibonacci sequence" in {
    Fibonacci.fibonacci.take(13).toList should be (List(0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144))
  }
}
