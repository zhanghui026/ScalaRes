package coeus.customControlStructures

/**
 * Created by IntelliJ IDEA.
 * User: zhangh
 * Date: 11-9-28
 * Time: 下午1:34
 * To change this template use File | Settings | File Templates.
 */

object BreaksExp extends App {

  import util.control.Breaks._

  breakable {
    for (i <- 1 to 10) {
      if (i > 5) break
      println(i)
    }
  }


  //break only breaks out to the first enclosing breakable
  //Break object extends the Breaks class.By instantiating other
  //instance of Breaks it is possible to control with breaks capture
  import util.control._
  def loop(f: Int => Boolean) = {
    val Inner = new Breaks
    Inner.breakable {
      for(i<- 1 to 4) if (f(i)) Inner.break() else println(i)
    }
  }
  val Outer= new Breaks
  Outer.breakable{
    while (true){
      loop{i=>if(i==4) Outer.break();false}
    }
  }
}