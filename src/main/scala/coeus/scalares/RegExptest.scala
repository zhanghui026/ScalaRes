package coeus.scalares

import util.matching.Regex.Match

/**
 * Created by IntelliJ IDEA.
 * User: zhanghui
 * Date: 11-9-14
 * Time: 下午2:47
 * To change this template use File | Settings | File Templates.
 */

object RegExptest extends App{
  val pattern = """&#x([1|2|3]);""".r
  val prefix = "rertew&#x3;23213&#x2;ee23123"


  val pp = pattern.replaceAllIn(prefix,(x: Match) => ""+(x.group(1).toInt).toChar)
  println(pp)


  //find the first match
  val fPattern = """([a-cA-C])""".r
  "c222"(0).toString match {
    case fPattern(c) => println(c)
    case _ => println("meiyou 中")
  }

}