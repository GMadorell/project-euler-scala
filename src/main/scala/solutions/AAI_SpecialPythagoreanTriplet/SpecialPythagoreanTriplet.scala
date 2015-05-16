package solutions.AAI_SpecialPythagoreanTriplet

object SpecialPythagoreanTriplet extends App {
  /**
   * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
   *      a**2 + b**2 = c**2
   *
   * For example, 3**2 + 4**2 = 9 + 16 = 25 = 5**2.
   *
   * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
   * Find the product abc.
   */

  /*
   * Brute force approach.
   */
  def square = (x: Int) => x * x
  val tripletIterator = for {
    a <- 1 to 330
    b <- 2 to 500
    c <- 333 to 1000
    if a + b + c == 1000
    if a < b && b < c
    if square(a) + square(b) == square(c)
  } yield (a, b, c)

  val solution = tripletIterator.head
  val solutionProduct = solution._1 * solution._2 * solution._3
  println("Solution to 'Special Pythagorean Triplet': " + solution + " with product: " + solutionProduct )
}
