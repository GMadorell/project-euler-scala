package math.collection

object CollectionCount {
  def countSeq[A](seq: Seq[A]): Map[A, Int] = {
    seq.foldLeft(Map[A, Int]() withDefaultValue 0)((map, n) => map + (n -> (map(n) + 1)))
  }

  def countArray[A](array: Array[A]): Map[A, Int] = countSeq(array.toSeq)
}
