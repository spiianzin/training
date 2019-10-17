package sp.home.chapter3

object Exercise3 extends App {
  val l = List(1,2,3,4,5).asInstanceOf[Cons[Int]]
  println(List.drop(3, l))
}
