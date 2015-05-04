package math

import org.scalatest.{FlatSpec, Matchers}

class PalindromeTest extends FlatSpec with Matchers {
  "isPalindrome" should "return true for palindrome numbers" in {
    Palindrome.isPalindrome(1) should be(true)
    Palindrome.isPalindrome(101) should be(true)
    Palindrome.isPalindrome(123321) should be(true)
    Palindrome.isPalindrome(133343331) should be(true)
    Palindrome.isPalindrome(123123123321321321L) should be(true)
  }

  "findLargestPalindromeProductOfDigits" should "return the correct value for two digits" in {
    Palindrome.findLargestPalindromeProductOfDigits(2) should be(9009)
  }
}
