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

  "isMultipleOfAll" should "return true if the number is multiple of all the elements of the collection" in {
    Multiple.isMultipleOfAll(List.range(1, 1))(2) should be (true)
    Multiple.isMultipleOfAll(List.range(1, 11))(2520) should be (true)
    Multiple.isMultipleOfAll(List.range(1, 11))(List.range(1, 11).product) should be (true)
    Multiple.isMultipleOfAll(List.range(1, 1000))(List.range(1, 1000).product) should be (true)
    Multiple.isMultipleOfAll(List.range(1, 10000))(List.range(1, 10000).product) should be (true)
  }

  it should "return false if the number is not multiple of all the elements of the collection" in {
    Multiple.isMultipleOfAll(List.range(1, 3))(3) should be (false)
    Multiple.isMultipleOfAll(List.range(1, 4))(7) should be (false)
  }
}
