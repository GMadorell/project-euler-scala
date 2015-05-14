package solutions.AAF_SumSquareDifference

object SumSquareDifference extends App {
  /**
   * The sum of the squares of the first ten natural numbers is,
   * 1**2 + 2**2 + ... + 10**2 = 385
   *
   * The square of the sum of the first ten natural numbers is,
   * (1 + 2 + ... + 10)**2 = 552 = 3025
   *
   * Hence the difference between the sum of the squares of the first ten natural numbers
   * and the square of the sum is 3025 − 385 = 2640.
   *
   * Find the difference between the sum of the squares of the first one hundred natural
   * numbers and the square of the sum.
   */

  /*
   * Straight away solution.
   */
  val amountOfNumbers = 100
  val numbers = List.range(1, amountOfNumbers + 1)

  val sumOfSquares = numbers.map(Math.pow(_, 2)).sum
  val squareOfSum = Math.pow(numbers.sum, 2)
  val solution = (squareOfSum - sumOfSquares).toLong

  println("Solution to 'Sum Square Difference': " + solution)

  /*
   * Optimized solution:
   * Let's see what we are really calculating. Imagine that we are calculating the solution
   * for only the first 3 natural numbers:
   *    sumOfSquares = 1**2 + 2**2 + 3**2
   *    squareOfSums = (1 + 2 + 3) ** 2
   *
   * If we expand the squareOfSums:
   *    squareOfSums = (1 + 2 + 3)*(1 + 2 + 3) = 1*1 + 1*2 + 1*3 + 2*1 + 2*2 + 2*3 + 3*1 + 3*2 + 3*3
   *
   * And then, as we are subtracting squareOfSums to that:
   *    solution = squareOfSums - sumOfSquares
   *      = (1*1 + 1*2 + 1*3 + 2*1 + 2*2 + 2*3 + 3*1 + 3*2 + 3*3) - (1**2 + 2**2 + 3**2)
   *      = 1*2 + 1*3 + 2*1 + 2*3 + 3*1 + 3*2
   *      = (1*2)*2 + (1*3)*2 + (2*3)*2
   *
   * As we can see, a lot of the calculations aren't necessary because they get simplified.
   * Thus, the solution is: the summation of multiplying every number by each number higher than it times two.
   */

  val higherNumberMultiplicationIterator = for {
    number <- numbers
    higherNumber <- number + 1 to amountOfNumbers
  } yield number * higherNumber * 2
  val optimizedSolution = higherNumberMultiplicationIterator.sum

  println("Solution to 'Sum Square Difference' - optimized: " + optimizedSolution)
  require(solution == optimizedSolution)
}
