package coeus.collection

/**
 * Created by IntelliJ IDEA.
 * User: zhangh
 * Date: 11-9-29
 * Time: 上午10:43
 * To change this template use File | Settings | File Templates.
 */

final class RNA1 private (val groups: Array[Int],val length:Int) extends IndexedSeq[Base] {
  import RNA1._
  def apply(idx:Int):Base = {
    if (idx < 0 || length <= idx)
      throw new IndexOutOfBoundsException
    Base.fromInt(groups(idx/N)>>(idx%N*S)&M)
  }
}
object RNA1 {
  //Number of bits necessary to represent group
  private val S = 2
  //Number of groups that fit in an Int
  private val N = 32/S

  //Bitmask to isolate a group
  private val M = (1<<S) -1
  def fromSeq(buf:Seq[Base]):RNA1= {
    val groups = new Array[Int]((buf.length+N-1)/N)
    for (i<-0 until buf.length)
      groups(i/N) |= Base.toInt(buf(i)) << (i%N*S)
    new RNA1(groups,buf.length)
  }
  def apply(bases:Base*) = fromSeq(bases)


}

object RNA1App extends App{
  val xs = List(A,G,T,A)
  val rs1 =RNA1.fromSeq(xs)
  println(rs1)
  val rna1 = RNA1(A,U,G,G,T)
  println(rna1)

  println(rna1.last)
  println(rna1.length)
  println(rna1.take(3))
}