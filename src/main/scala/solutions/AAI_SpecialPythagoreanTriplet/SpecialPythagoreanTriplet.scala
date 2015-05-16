package solutions.AAI_SpecialPythagoreanTriplet

import math.Square.square

object SpecialPythagoreanTriplet extends App {
  /**
   * A Pythagorean triplet is a set of three natural numbers, a < b < c,
   * for which: a**2 + b**2 = c**2
   *
   * For example, 3**2 + 4**2 = 9 + 16 = 25 = 5**2.
   *
   * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
   * Find the product abc.
   */

  val sumExpectedResult = 1000

  def bruteForcePythagoreanTriplets(sumExpectedResult: Int): Iterable[List[Int]] = for {
    a <- 3 to (sumExpectedResult - 3) / 3
    b <- a + 1 to (sumExpectedResult - 1 - a) / 2
    c = sumExpectedResult - a - b
    if square(a) + square(b) == square(c)
  } yield List(a, b, c)

  val bruteForceSolution = bruteForcePythagoreanTriplets(sumExpectedResult).head
  println("Solution to 'Special Pythagorean Triplet' with brute force: " + bruteForceSolution +
    " with product: " + bruteForceSolution.product)

  require(bruteForceSolution.product == 31875000)
}
