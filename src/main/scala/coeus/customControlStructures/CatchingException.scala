package coeus.customControlStructures

/**
 * Created by IntelliJ IDEA.
 * User: zhangh
 * Date: 11-9-28
 * Time: 上午11:08
 * To change this template use File | Settings | File Templates.
 */

object CatchingException extends App {

  import util.control.Exception._

  val numberFormat = catching(classOf[NumberFormatException])

  val result = numberFormat opt {
    "10".toInt
  }

  result match {
    case Some(n) => println(n) //do something
    case None => println("None") //handle this situation
  }

  // This is a special type construct which means that a no param function
  //is passed in but is not executed until called within the method
  def method(para: => Int) = println(para)

  def method2(para: => Int) = println("not calling args")

  var x = 1

  //when method is called x is incremented because method calls the argument
  method {
    x += 1; x
  }
  println(x) //2

  //when method2 is called x is not incremented because the argument is not called/refrerenced
  method2 {
    x += 1; x
  }
  println(x)

  //2

  //arg is referenced 2 times in method three so x is increamented 2 times
  def method3(para: => Int) = println("first call=" + para + " second call=" + para)

  method3 {
    x += 1;
    x
  }
  println(x)

  //4

  //now demonstrated the standard way of defining arguments
  //the value passed is calculated before calling the method
  //so is at most called once

  def byValue(arg: Int) = println(arg)

  def byValue2(arg: Int) = println("not calling arg")

  def byValue3(arg: Int) = println("first call = " + arg + " second call = " + arg)

  byValue {
    x += 1; x
  } //5

  byValue2 {
    x += 1; x
  } //6
  byValue3 {
    x += 1; x
  } //first call = 7 second call = 7


  //And finally show the normal way to pass in a function
  //This has the benefit of allowing the reader of the code
  // to realize that the argument is function
  //but is not a nice syntax for control flow

  def stdFunc(arg: ()=>Int) = println(arg())
  def stdFunc2(arg: ()=>Int) = println("not calling arg")
  def stdFunc3(arg: ()=>Int) =println("first call="+arg() + " second call="+arg())
  stdFunc{()=>x+=1;x}
  stdFunc2{()=>x+=1;x}
  println(x)
  stdFunc3{()=>x+=1;x}

}