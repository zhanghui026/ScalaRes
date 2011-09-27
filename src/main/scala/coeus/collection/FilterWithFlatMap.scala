package coeus.collection

/**
 * Created by IntelliJ IDEA.
 * User: zhanghui
 * Date: 11-9-27
 * Time: 上午9:37
 * To change this template use File | Settings | File Templates.
 */
/**
 * CF:http://daily-scala.blogspot.com/2010/04/filter-with-flatmap-or-collect.html
 * filter with FlatMap(or collect)
 *
 */

object FilterWithFlatMap extends App{
   //use flatMap to create a filtered list

 def insepect[T](l:List[T])(implicit manifest:scala.reflect.Manifest[T]) = print(manifest.toString)
  def strings(list:List[Any]) = list flatMap {
    case st:String => Some(st)
    case _ => None
  }
  //returned list is a List[String]
 val res1 = strings("hi"::1::"wolrd"::4::Nil)

  println(insepect(res1) + " : "+ res1)



  //returned list is a List[Any](not as usual
 val res2 ="hi" :: 1 :: "world" :: 4 :: Nil filter {_.isInstanceOf[String]}
 println(insepect(res2) + ":"+ res2)

 //collect returns List[String]
  val res3 = "hi" :: 1 :: "world" :: 4 :: Nil collect { case s:String => s}
  println(insepect(res3) + ":"+res3)
}