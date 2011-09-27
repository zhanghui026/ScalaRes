package coeus.typeeraser

/**
 * Created by IntelliJ IDEA.
 * User: zhanghui
 * Date: 11-9-21
 * Time: 下午1:20
 * To change this template use File | Settings | File Templates.
 */

object Registry {
  import scala.reflect.Manifest
  private var _map = Map.empty[Any,(Manifest[_],Any)]

  def register[T](name:Any,item:T)(implicit m:Manifest[T]) {
    _map = Map(name -> (m,item))
  }

  def get[T](key:Any)(implicit m:Manifest[T]):Option[T] = {
    val o = _map.get(key)
    o match {
      case Some((om:Manifest[_],s:Any)) => if (om <:< m) Some(s.asInstanceOf[T]) else None
      case  _ => None
    }
  }

  def main(args: Array[String]) {
    Registry.register("a",List(1,2,3))
    println(Registry.get[List[Int]]("a"))
    println(Registry.get[List[String]]("a"))


  }

}