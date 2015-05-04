package math

import spire.math.Integral
import spire.implicits._

object Multiple {
  /**
   * @return Whether n is multiple of m.
   */
  def isMultiple[A: Integral, B: Integral](m: A)(n: B): Boolean = {
    n.toLong() % m.toLong() == 0
  }
}
