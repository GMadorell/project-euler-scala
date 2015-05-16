package math

import spire.math.Integral
import spire.implicits._

object Square {
  def square[A: Integral](n: A): A = {
    n * n
  }
}
