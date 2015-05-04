package math

import spire.math.Integral
import spire.implicits._

object Palindrome {
  def isPalindrome[A: Integral](number: A): Boolean = {
    val asStr = number.toString
    asStr.reverse == asStr
  }

  /**
   * @return The largest palindrome number product of digits of the given length.
   *         Ex: largest palindrome product of digits of 'n' = 2 is 9009 = 91 × 99
   */
  def findLargestPalindromeProductOfDigits(digits: Int): Int = {
    val maxNumber = Math.pow(10, digits).toInt - 1
    val numbersIterator = for(a <- Iterator.range(maxNumber, 0, -1); b <- Iterator.range(maxNumber, 0, -1)) yield (a, b)
    numbersIterator.map(n => n._1 * n._2).filter(isPalindrome).max
  }
}
