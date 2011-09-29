package coeus.collection

import collection.IndexedSeqLike
import collection.mutable.{ArrayBuffer, Builder}

/**
 * Created by IntelliJ IDEA.
 * User: zhangh
 * Date: 11-9-29
 * Time: 下午1:23
 * To change this template use File | Settings | File Templates.
 */

final class RNA2 private(val groups:Array[Int],val length:Int) extends  IndexedSeq[Base]  with IndexedSeqLike[Base,RNA2] {
  import RNA2._
  override def newBuilder:Builder[Base,RNA2] = new ArrayBuffer[Base]  mapResult fromSeq
 def apply(idx:Int):Base = {
    if (idx < 0 || length <= idx)
      throw new IndexOutOfBoundsException
    Base.fromInt(groups(idx/N)>>(idx%N*S)&M)
  }
}
object RNA2 {
//Number of bits necessary to represent group
  private val S = 2
  //Number of groups that fit in an Int
  private val N = 32/S

  //Bitmask to isolate a group
  private val M = (1<<S) -1
  def fromSeq(buf:Seq[Base]):RNA2= {
    val groups = new Array[Int]((buf.length+N-1)/N)
    for (i<-0 until buf.length)
      groups(i/N) |= Base.toInt(buf(i)) << (i%N*S)
    new RNA2(groups,buf.length)
  }
  def apply(bases:Base*) = fromSeq(bases)

}

object RNA2App extends App {
    val rna2 = RNA2(A,U,G,G,T)
   println(rna2)

  val res1 = rna2 take 3
   println(res1)

  val res2 =rna2 filter (_!=U)
  println(res2)

  println(rna2 map {case A => T case b => b})
  println(rna2 ++ rna2)
}
