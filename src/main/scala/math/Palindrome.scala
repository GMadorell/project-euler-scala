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
    val minNumber = Math.pow(10, digits-1).toInt
    val numbersIterator = for {a <- Iterator.range(maxNumber, minNumber, -1)
                               b <- Iterator.range(maxNumber, minNumber, -1)
                               if a <= b} yield (a, b)
    numbersIterator.map(n => n._1 * n._2).filter(isPalindrome).max
  }
}
