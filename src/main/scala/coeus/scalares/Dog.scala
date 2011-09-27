package coeus.scalares

import xml.Utility

/**
 * Created by IntelliJ IDEA.
 * User: zhanghui
 * Date: 11-9-8
 * Time: 上午10:21
 * To change this template use File | Settings | File Templates.
 */
/**
 *  Universal average-function for Arrays
 */
class Dog(a: Int, w: Int, h: Int) {
  var age = a;
  var weight = w;
  var height = h;


}

object TestDog {
  // To return average value of specific feild in array
  // Example use : average(dogs, weight)
  def average[T](a: Traversable[T], f: T => Int): Int = a.map(f).sum / a.size

  def main(args: Array[String]) {
    var dogs = new Array[Dog](2)
    dogs(0) = new Dog(2, 14, 50)
    dogs(1) = new Dog(4, 16, 55)
    println("avg age = " + average(dogs, (d: Dog) => d.age))
    println("avg weigt = " + average(dogs, (d: Dog) => d.weight))
    println("avg height = " + average(dogs, (d: Dog) => d.height))
    //Ctrl +Shift + Space => generate anonymous function feature
    val seq:Seq[String] = Seq("one","two","three")
    val se =seq.map((s: String) => s.toUpperCase)

    val dog = new Dog(2, 14, 40)

    println(se)
  }
}