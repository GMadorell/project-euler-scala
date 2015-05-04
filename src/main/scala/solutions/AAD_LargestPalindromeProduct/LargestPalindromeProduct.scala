package solutions.AAD_LargestPalindromeProduct

import math.Palindrome

object LargestPalindromeProduct extends App {
  /**
   * A palindromic number reads the same both ways.
   * The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
   *
   * Find the largest palindrome made from the product of two 3-digit numbers.
   */

  val solution = Palindrome.findLargestPalindromeProductOfDigits(3)
  println("Solution to: 'Largest Palindrome Product': " + solution)
}
