package coeus.customControlStructures

/**
 * Created by IntelliJ IDEA.
 * User: zhangh
 * Date: 11-9-28
 * Time: 下午1:16
 * To change this template use File | Settings | File Templates.
 */

object SimpleCatchingExp extends App{
  def catching[T](exceptions: Class[_]*)(body: =>T) = {
    try{
      Some(body)
    } catch {
      case e if exceptions contains e.getClass => None
    }
  }

  val runtime = catching[Number](classOf[NullPointerException],classOf[NumberFormatException])_

  println(runtime {"".toInt})
  println(runtime {"10".toInt})
  println(runtime {throw new NullPointerException})
//  runtime{throw  new RuntimeException}

}