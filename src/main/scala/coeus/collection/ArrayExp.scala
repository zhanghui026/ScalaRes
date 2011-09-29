package coeus.collection

/**
 * Created by IntelliJ IDEA.
 * User: zhangh
 * Date: 11-9-28
 * Time: 下午1:51
 * To change this template use File | Settings | File Templates.
 */

//http://daily-scala.blogspot.com/2010/04/scala-28-arrays-are-not-traversables.html
//Scala 2.8 Arrays are not traversable
object ArrayExp extends App{

  def x(t:Traversable[Int]) = t.isInstanceOf[Array[_]]

  /**
   * this evaluates to false because Array is converted
   * to WrappedArray because it has to be implicitly converted
   * to a Traversable.Since Array is not a Traversable the resulting
   * object is not an Array
   */
  println(x(Array(1,2,3)))

  def x2(t:Traversable[Int]) =println(t)
  x2(Array(1,2,3))


  def x3[T <% Traversable[Int]](t:T) = t match {
    case x:Array[Int] => true
  }
  println(x3(Array(1,2,3)))


}