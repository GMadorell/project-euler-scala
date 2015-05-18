package math.structures

import scala.collection.GenTraversableOnce

class Grid2D private(val rows: Int, val cols: Int) {
  private val grid = Array.fill(rows, cols)(0)

  def apply(row: Int, col: Int): Int = grid(row)(col)

  def apply(row: Int): Array[Int] = grid(row)

  def update(row: Int, col: Int, value: Int) = grid(row)(col) = value

  def rowsIterator() = for {row <- 0 to rows - 1} yield this(row)

  def mapRow[A](func: (Array[Int]) => A) = rowsIterator().map(func)

  def flatMapRow[A](func: (Array[Int]) => GenTraversableOnce[A]) = rowsIterator().flatMap(func)

  def forEachRow(func: (Array[Int]) => Unit) = rowsIterator().foreach(func)

  def mapValues[A](func: (Int) => A) = mapRow(identity).map(_.map(func))

  override def toString: String = mapRow((row) => row.map(_.toString).mkString(" ")).mkString("\n")

  override def equals(other: Any): Boolean = other match {
    case grid2D: Grid2D =>
      rows == grid2D.rows && cols == grid2D.cols &&
        Iterator.range(0, rows).forall(
          (row) => Iterator.range(0, cols).forall((col) => this(row, col) == grid2D(row, col))
        )
    case _ => false
  }
}

object Grid2D {
  def apply(rows: Int, cols: Int): Grid2D = new Grid2D(rows, cols)

  def apply(dimensions: Int): Grid2D = new Grid2D(dimensions, dimensions)

  def apply(gridAsArray: Array[Array[Int]]): Grid2D = {
    val rows = gridAsArray.length
    val cols = gridAsArray.head.length
    val grid2D = apply(rows, cols)
    gridAsArray.zipWithIndex.foreach { case (innerSeq, row) =>
      innerSeq.zipWithIndex.foreach { case (value, col) => grid2D(row, col) = value }
    }
    grid2D
  }
}
