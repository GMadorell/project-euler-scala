package math

object Fibonacci {
  val fibonacci: Stream[Int] =
    // 0 #:: 1 #:: fibonacci.zip(fibonacci.tail).map { n => n._1 + n._2 }
    Stream.cons(0, Stream.cons(1, fibonacci.zip(fibonacci.tail).map { n => n._1 + n._2 }))
}
