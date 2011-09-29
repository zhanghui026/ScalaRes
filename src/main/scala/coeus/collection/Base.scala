package coeus.collection

/**
 * Created by IntelliJ IDEA.
 * User: zhangh
 * Date: 11-9-28
 * Time: 下午4:48
 * To change this template use File | Settings | File Templates.
 */

abstract class Base
case object A extends Base
case object T extends Base
case object G extends Base
case object U extends Base

object Base {
  val fromInt:Int => Base = Array(A,T,G,U) // Array is a 1subclass Func
  val toInt:Base => Int = Map(A->0,T->1,G->2,U->3) //Also Map is a subclass Func

}
object TestApp extends App{
  println(Base.fromInt)
     println(Base.fromInt(0))
  val t= Array(A,T,G,U)
  val e= t(0)
}