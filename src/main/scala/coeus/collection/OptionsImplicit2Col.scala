package coeus.collection

/**
 * Created by IntelliJ IDEA.
 * User: zhangh
 * Date: 11-9-28
 * Time: 下午2:03
 * To change this template use File | Settings | File Templates.
 */

object OptionsImplicit2Col extends App{
  println(List(1,2,3) ++ Some(4))
  println(List(1,2,3) ++ None)

  val x:Iterable[Int] = None
  val x2:Iterable[Int] = Some(4)
  println(x)
  println(x2)


}