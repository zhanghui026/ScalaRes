package coeus.scalares

import collection.mutable.ArrayBuffer
import util.Random

/**
 * Created by IntelliJ IDEA.
 * User: zhanghui
 * Date: 11-9-9
 * Time: 上午10:14
 * To change this template use File | Settings | File Templates.
 */

object ArrayLearn {
  def main(args: Array[String]) {
    //set a to an array of n random intergers between 0 (inclusive) and n (exclusive)
    def nextArray(n: Int, a: Any) = {
      val r = new Random()
      for (i <- (0 to r.nextInt(n))) yield a
    }

    println(nextArray(5, 't'))

    // a loop swaps adjacent elements of an array of intergers
    def swapsAdjacent(arr: Array[Int]) = {
      for (i <- 0 to arr.length) yield {
        if (i % 2 == 0 && i != arr.length - 1) arr(i + 1) else if (i % 2 == 0 && i == arr.length - 1) arr(i) else arr(i - 1)
      }
    }

    println(swapsAdjacent(Array(23, 2, 12, 23, 5)))

    //give an array of integers,produce a new array that contains all positive values of the original array
    // in their original order,followed by all values that are zero or negative,in their original order
    def postiveAndZeroNegativeArray(arr: Array[Int]) = {
      val l,r = new ArrayBuffer[Int]()
      for (a <- arr) {
        (if (a>0) l else r) +=a
      }
      (l ++ r).toArray

    }

    println(postiveAndZeroNegativeArray(Array(5, 3, -2, 33, -45, 2)).mkString("(",",",")"))

    //How do you compute the average of Array[Double]
    println(Array(12,3,2).sum/3)

    //How do rearrange the elements of Array[Int] so that they appear in reverse sorted array
    println(Array(2,21,-1).sortWith((i: Int, i0: Int) => i>i0) mkString("(",",",")"))

    //do the same thingtoArrayBuffer
    println(ArrayBuffer(2,2,3,-1).sortWith((i: Int, i0: Int) => i>i0) mkString("(",",",")"))

    //produces all values from an array with duplicates remove
    def removeDuplicateElem(arr:Array[Any]) = arr.distinct
    println(Array(2,23,3,22,2,3,23).distinct mkString("(",",",")"))

    //drop the index of the first match


  }

}