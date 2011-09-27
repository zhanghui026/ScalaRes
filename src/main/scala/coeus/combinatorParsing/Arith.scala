package coeus.combinatorParsing

/**
 * Created by IntelliJ IDEA.
 * User: zhanghui
 * Date: 11-9-21
 * Time: 上午9:12
 * To change this template use File | Settings | File Templates.
 */
import scala.util.parsing.combinator._

class Arith extends JavaTokenParsers{
    def expr:Parser[Any] = term~rep("+"~term | "-"~term)
    def term:Parser[Any] = factor~rep("*"~factor | "/"~factor)
    def factor:Parser[Any] = floatingPointNumber | "("~expr~")"
}
//Running your parse
object ParserExpr extends Arith {
  def main(args: Array[String]) {
    println("input: " + args(0))
    println(parseAll(expr,args(0)))
  }
}