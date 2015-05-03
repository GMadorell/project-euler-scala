package math

import org.scalatest.{Matchers, FlatSpec}

class MultipleTest extends FlatSpec with Matchers {
  "isMultiple" should "return true for numbers that are multiples" in {
    Multiple.isMultiple(2)(4) should be (true)
    Multiple.isMultiple(2)(6) should be (true)
    Multiple.isMultiple(3)(6) should be (true)
    Multiple.isMultiple(2)(8) should be (true)
    Multiple.isMultiple(4)(8) should be (true)
    Multiple.isMultiple(8)(8) should be (true)
    Multiple.isMultiple(2)(10) should be (true)
    Multiple.isMultiple(5)(10) should be (true)
    Multiple.isMultiple(10)(10) should be (true)
  }

  it should "return false for numbers that are not multiples" in {
    Multiple.isMultiple(4)(2) should be (false)
    Multiple.isMultiple(8)(2) should be (false)
    Multiple.isMultiple(3)(2) should be (false)
    Multiple.isMultiple(3)(1) should be (false)
  }
}
