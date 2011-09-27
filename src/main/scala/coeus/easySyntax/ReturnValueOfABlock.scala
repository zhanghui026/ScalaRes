package coeus.easySyntax

/**
 * Created by IntelliJ IDEA.
 * User: zhanghui
 * Date: 11-9-26
 * Time: 下午2:19
 * To change this template use File | Settings | File Templates.
 */

object ReturnValueOfABlock extends App{
  //misunderstanding is that a code block (without parameter) is a function.
  //Code block is a sequence of statements that are executed and result the last statement is returned.
  //That sounds like a Function0,however,if the block is passed to a method/function only the last statement
  //will be returned to the function/method. If that method/function expects a function as the parameter the last
  //statement maybe returned as a function not a value,this means that the block itself is not a function.

  var count = 0;
  //the last statement is returned as function so count
  //it incremented only one during the creation of the function
  val res1 = List(1,2,3,4).map {count+=1;_+1}
  println(res1)
  println(count)

  //now the count increment is within the function
  val res2 = List(1,2,3,4).map{i => count += 1; i+1}
  println(res2)
  println(count)

}