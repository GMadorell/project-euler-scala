package math

object SumEquations {
  /**
   * @return 1**2 + 2**2 + ... + n**2
   */
  def sumOfSquares(n: Int) = (2 * n + 1) * (n + 1) * n / 6

  /**
   * @return 1 + 2 + 3 + ... + n
   */
  def sumUpToN(n: Int) = n * (n + 1) / 2

  /**
   * @return 1 + 2 + 3 + ... (n-1)
   */
  def sumUntilN(n: Int) = sumUpToN(n - 1)
}
