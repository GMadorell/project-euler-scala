package math

object Multiple {
  /**
   * @return Whether n is multiple of m.
   */
  def isMultiple(m: Int)(n: Int): Boolean = {
    n % m == 0
  }
}
