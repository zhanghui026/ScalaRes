package coeus.easySyntax

/**
 * Created by IntelliJ IDEA.
 * User: zhanghui
 * Date: 11-9-23
 * Time: 下午3:20
 * To change this template use File | Settings | File Templates.
 */

/**
 * Problem:Case classes are great for pattern matching,
 * but how do u transform data?
 * Often need to update (functionally) some specific field(s)
 *  of a data structure defined by case classes.
 *
 * Solution:Selective copy method
 *
 *
 * case  classes in 2.8
 */
object CopyOperation extends App{
  //constructor methods have defaults defined
  case class Node(name:String,left:Option[Node] = None, right:Option[Node] = None)
  //the name is the only required parameter because it does not have a default
  val child = Node("leaf")
  println(child)

  //left is being assigned here because the name of the parameter is not explicit
  val parent  = Node("parent",Some(child))
  println(parent)

  //now the left node is not defined just the right
  val node = Node("node",right=Some(child))
  println(node)

  println("sssssssssssssss")

  //the real power is the copy constructor that is automatically generated in the case class . I can make a copy with
  //any or all attributes modified by using the copy constructor and declaring which field to modify

  println(parent.copy(right = Some(node)))
  println(parent.copy(left = None))
  println(parent.copy(name = "hoho"))
  println(parent.copy(name = "hoho",left = None))



}