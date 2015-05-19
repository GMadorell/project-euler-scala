package math.collection

import org.scalatest.{FlatSpec, Matchers}

import scala.collection.immutable.Stack

class CollectionCountTest extends FlatSpec with Matchers {
  "countSeq" should "return an empty map for an empty list" in {
    CollectionCount.countSeq(List()) should be(Map())
  }

  it should "return a count of a single element list" in {
    CollectionCount.countSeq(List(10)) should be(Map(10 -> 1))
  }

  it should "return a count of a list with two different elements" in {
    CollectionCount.countSeq(List(2, 3)) should be(Map(2 -> 1, 3 -> 1))
  }

  it should "return a count of a list with two equal elements" in {
    CollectionCount.countSeq(List(2, 2)) should be(Map(2 -> 2))
  }

  it should "return a count of a list with equal and different elements" in {
    CollectionCount.countSeq(List(2, 2, 3, 2, 4, 5, 4)) should be(Map(2 -> 3, 3 -> 1, 4 -> 2, 5 -> 1))
  }

  it should "work with other sequences other than list" in {
    CollectionCount.countSeq(Vector()) should be(Map())
    CollectionCount.countSeq(Vector(2, 2, 2)) should be(Map(2 -> 3))
    CollectionCount.countSeq(Stack()) should be(Map())
  }

  "countArray" should "return an empty map for an empty array" in {
    CollectionCount.countArray(Array()) should be(Map())
  }

  it should "return a count of an array with a single element" in {
    CollectionCount.countArray(Array(10)) should be(Map(10 -> 1))
  }

  it should "return a count of an array with two different elements" in {
    CollectionCount.countArray(Array(2, 3)) should be(Map(2 -> 1, 3 -> 1))
  }

  it should "return a count of an array with two equal elements" in {
    CollectionCount.countArray(Array(2, 2)) should be(Map(2 -> 2))
  }

  it should "return a count of an array with equal and different elements" in {
    CollectionCount.countArray(Array(2, 2, 3, 2, 4, 5, 4)) should be(Map(2 -> 3, 3 -> 1, 4 -> 2, 5 -> 1))
  }
}
