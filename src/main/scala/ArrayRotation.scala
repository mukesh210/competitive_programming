object ArrayRotation extends App {
  //method 1
  def leftRotateByD1(list: List[Int], d: Int): List[Int] = {
    list.drop(d) ++ list.take(d)
  }

  def leftRotateByD2(list: List[Int], d: Int): List[Int] = {
    val (left, right) = list.splitAt(d)
    right ++ left
  }

  def rightRotateByD1(list: List[Int], d: Int): List[Int] = {
    list.takeRight(d) ++ list.take(list.size - d)
  }

  def rightRotateByD2(list: List[Int], d: Int): List[Int] = {
    val (left, right) = list.splitAt(list.size - d)
    right ++ left
  }

  val list = List(1,2,3,4,5,6,7)
  println(s"left rotation 1: ${leftRotateByD1(list, 2)}")
  println(s"left rotation 2: ${leftRotateByD2(list, 2)}")
  println(s"right rotation 1: ${rightRotateByD1(list, 2)}")
  println(s"right rotation 2: ${rightRotateByD2(list, 2)}")
}
