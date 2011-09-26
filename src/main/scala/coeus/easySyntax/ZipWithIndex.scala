package coeus.easySyntax

/**
 * Created by IntelliJ IDEA.
 * User: zhanghui
 * Date: 11-9-26
 * Time: 上午10:37
 * To change this template use File | Settings | File Templates.
 */

object ZipWithIndex extends App{

  //List('a','b','c','d').zipWithIndex  trigger an extra iteration
  //List('a','b','c','d').view.zipWithIndex only traversed when required so there is no performance loss

  val list = List ('a','b','c','d')
  println(list)

  //I like to use the function constructed with case statements in order to clearly label the index. The alternative is
  // to use x._2 for the index and x._1 for the value
  list.view.zipWithIndex foreach {case (value,index) => println(value,index)}

  //alternative syntax without case statement
  list.view.zipWithIndex foreach { e => println(e._1,e._2)}

  /**
   * Fold left and right function have 2 parameters (accumulator,nextValue)
   * using a case statement allows you to expand that but watch the brackets
   */

  val res1 = (list.view.zipWithIndex foldLeft 0){case(acc,(value,index)) => acc + value.toInt + index}
  println(res1)
  val res2 = (list.view.zipWithIndex foldLeft 0){(acc,e) => acc + e._1.toInt + e._2}
  println(res2)


  /**
   * alternative foldLeft operator. The thing i like about this syntax is
   * that it have the initial accumulator value on the left in the same position
   * ase the accumulator parameter in the function.
   *
   * The other thing I like about it is that visually you can see that it starts with ""
   * and the folds left
   */
  val res3 = ("" /: list.view.zipWithIndex) {
    case (acc,(value,index)) if index % 2 == 0 => acc + value
    case (acc,_) => acc
  }

  println(res3)

  /**
   * This example filters based on the index then users map to remove the index force simply
   * forces the view to be processed.
   */
  val res4 = list.view.zipWithIndex.filter(_._2%2 == 0).map{_._1}.force
  println(res4)
}