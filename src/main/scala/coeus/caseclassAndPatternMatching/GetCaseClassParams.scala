package coeus.caseclassAndPatternMatching

import coeus.caseclassAndPatternMatching.GetCaseClassParams.MyClass

/**
 * Created by IntelliJ IDEA.
 * User: zhanghui
 * Date: 11-9-23
 * Time: 下午4:47
 * To change this template use File | Settings | File Templates.
 */

object GetCaseClassParams extends App{
 //come from the question http://stackoverflow.com/questions/1226555/case-class-to-map-in-scala

  def getCCName(caseobj:AnyRef) = {
     (Map[String,Any]() /: caseobj.getClass.getDeclaredFields) { (a,f) =>
       f.setAccessible(true)
       a + (f.getName -> f.get(caseobj))
     }
  }
  case class MyClass(param1:String,param2:String)
  println(getCCName(new MyClass("hello","hello")))

}