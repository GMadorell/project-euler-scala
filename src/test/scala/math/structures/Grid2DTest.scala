package math.structures

import org.scalatest.{FlatSpec, Matchers}

class Grid2DTest extends FlatSpec with Matchers {
  "constructor" should "initialize values to zero" in {
    val grid = Grid2D(2, 2)
    grid(0, 0) should be (0)
    grid(0, 1) should be (0)
    grid(1, 0) should be (0)
    grid(1, 1) should be (0)
  }

  "update method" should "change grid values" in {
    val grid = Grid2D(2, 2)
    grid(1, 1) = 10
    grid(1, 1) should be (10)
  }

  "getting a row" should "return a correct value" in {
    val grid = Grid2D(3, 10)
    grid(1, 8) = 2
    grid(1) should be (Array(0, 0, 0, 0, 0, 0, 0, 0, 2, 0))
  }

  "accessing a row out of bounds" should "raise an exception" in {
    val grid = Grid2D(3, 3)
    intercept[ArrayIndexOutOfBoundsException] {
      grid(3, 1)
    }
  }

  "accessing a column out of bounds" should "raise an exception" in {
    val grid = Grid2D(3, 3)
    intercept[ArrayIndexOutOfBoundsException] {
      grid(1, 3)
    }
  }

  "accessing a negative row" should "raise an exception" in {
    val grid = Grid2D(3, 3)
    intercept[ArrayIndexOutOfBoundsException] {
      grid(-1, 1)
    }
  }

  "accessing a negative column" should "raise an exception" in {
    val grid = Grid2D(3, 3)
    intercept[ArrayIndexOutOfBoundsException] {
      grid(1, -1)
    }
  }

  "equals" should "return true for equally created grids" in {
    Grid2D(2, 2) should be (Grid2D(2, 2))
  }

  it should "return true for grids with equal sized and values" in {
    val firstGrid = Grid2D(2, 2)
    val secondGrid = Grid2D(2, 2)

    firstGrid(1, 1) = 2
    secondGrid(1, 1) = 2
    firstGrid(0, 0) = 50
    secondGrid(0, 0) = 50

    firstGrid should be (secondGrid)
  }

  it should "return false for different values grids" in {
    val grid = Grid2D(2, 2)
    grid(1, 1) = 2
    grid should not be Grid2D(2, 2)
  }

  it should "return false for different sizes" in {
    Grid2D(2, 2) should not be Grid2D(2, 3)
    Grid2D(2, 2) should not be Grid2D(3, 2)
  }

  "object constructor" should "work with a single parameter creating a square grid" in {
    Grid2D(2) should be (Grid2D(2, 2))
  }

  it should "work with a sequence of sequences of numbers" in {
    val expectedGrid = Grid2D(3, 3)
    expectedGrid(0, 0) = 1
    expectedGrid(0, 2) = 2
    expectedGrid(1, 1) = 3
    expectedGrid(2, 1) = 4
    expectedGrid(2, 2) = 5

    val gridArray = Array(Array(1, 0, 2), Array(0, 3, 0), Array(0, 4, 5))

    Grid2D(gridArray) should be (expectedGrid)
  }
}
