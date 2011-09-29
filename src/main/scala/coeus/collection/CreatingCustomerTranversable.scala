package coeus.collection

/**
 * Created by IntelliJ IDEA.
 * User: zhangh
 * Date: 11-9-28
 * Time: 下午2:07
 * To change this template use File | Settings | File Templates.
 *
 *
 */

//http://daily-scala.blogspot.com/2010/04/creating-custom-traversable.html

//a few tips u need to be aware of to create your new collection

    import scala.collection._
    import scala.collection.generic._
    import scala.collection.mutable.{ Builder, ListBuffer }
    class MyColl[A](seq : A*) extends Traversable[A]
                                 with GenericTraversableTemplate[A, MyColl]
                                 with TraversableLike[A, MyColl[A]] {
      override def companion = MyColl
      def foreach[U](f: A => U) = util.Random.shuffle(seq.toSeq).foreach(f)
      def sayhi = println("hi!")
    }
    object MyColl extends TraversableFactory[MyColl] {
      implicit def canBuildFrom[A]: CanBuildFrom[Coll, A, MyColl[A]] = new GenericCanBuildFrom[A]
      def newBuilder[A] = new ListBuffer[A] mapResult (x => new MyColl(x:_*))
    }
  object CusApp extends App {
    val c = new MyColl(1, 2, 3)
    println (c mkString ",")
    println(c mkString ",")
    assert(c.drop(1).isInstanceOf[MyColl[_]])
    assert((c map {_ + 1}).isInstanceOf[MyColl[_]])
    val o : MyColl[Int] = c filter {_ < 2}
    println(o mkString "," )
    o.sayhi
  }