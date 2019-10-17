package sp.home.chapter3

import scala.annotation.tailrec

sealed trait List[+A]
case object Nil extends List[Nothing]
case class Cons[+A](head: A, tail: List[A]) extends List[A]
object List {
  def sum(ints: List[Int]): Int = ints match {
    case Nil => 0
    case Cons(x,xs) => x + sum(xs)
  }
  def product(ds: List[Double]): Double = ds match {
    case Nil => 1.0
    case Cons(0.0, _) => 0.0
    case Cons(x,xs) => x * product(xs)
  }
  def tail[A](as: A*): List[A] = {
    apply(as.tail: _*)
  }

  @tailrec
  def drop[A](n: Int, as: A*): List[A] = n match {
    case 1 => tail(as: _*)
    case x => drop(x - 1, as: _*)
  }

  def apply[A](as: A*): List[A] =
    if (as.isEmpty) Nil
    else Cons(as.head, apply(as.tail: _*))
  val example = Cons(1, Cons(2, Cons(3, Nil)))
  val example2 = List(1,2,3)
  val total: Int = sum(example)
}
