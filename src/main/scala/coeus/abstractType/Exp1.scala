package coeus.abstractType

/**
 * Created by IntelliJ IDEA.
 * User: zhanghui
 * Date: 11-9-26
 * Time: 下午4:15
 * To change this template use File | Settings | File Templates.
 */

object Exp1 extends App{

  //type parameter
   trait C[A] {
     def get:A
     def doit(a:A):A
   }

  //abstract type
  trait C2 {
    type A
    def get:A
//    def doit(a:A):A
  }

  //both implementions have simlilar properties.However they r not the same
  //

  var c:C2 = new C2 {
    type A = Int
    def get = 3
  }

  //what is the type of result if at compile time the
  //value of c is not known
  var result: C2#A = c.get

  println(result.isInstanceOf[Int])

  c = new C2 {
    type A = String
    def get = "hi"
  }
  //C2#A type
  result= c.get
  println(result.isInstanceOf[String])

  //u can not assign a string to result
//  result = "4"


}