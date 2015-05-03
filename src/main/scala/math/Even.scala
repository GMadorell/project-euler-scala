package math

object Even {
  def isEven(n: Int) = 0 == (n & 1)
  def isOdd(n: Int) = !isEven(n)
}
