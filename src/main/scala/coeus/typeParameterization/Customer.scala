package coeus.typeParameterization

/**
 * Created by IntelliJ IDEA.
 * User: zhangh
 * Date: 11-10-19
 * Time: 下午3:31
 * To change this template use File | Settings | File Templates.
 */

//Type parameterization
/**
 * class Function1[-S,+T] {
 *     def apply(x:S):T
 * }
 * S => T
 */


class Publication(val title:String)

class Book(title:String) extends Publication(title)

object Library{
  val books:Set[Book]  = {
    Set(
      new Book("1.bool"),
    new Book("23.boo1")
    )
  }

  def printBookList(info:Book => AnyRef) ={
    for (b <- books) print(info(b))
  }
}

object Customer extends App{
  def getTitle(publication:Publication) = publication.title+","

  Library.printBookList(getTitle)
}