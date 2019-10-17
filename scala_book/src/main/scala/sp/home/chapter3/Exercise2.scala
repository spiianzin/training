package sp.home.chapter3

object Exercise2 extends App {
  println(List(1,2,3,4,5).asInstanceOf[Cons[Int]].tail)
}
