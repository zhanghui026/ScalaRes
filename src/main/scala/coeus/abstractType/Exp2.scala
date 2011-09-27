package coeus.abstractType

import java.io.{StringReader, ByteArrayInputStream, Reader, InputStream}

/**
 * Created by IntelliJ IDEA.
 * User: zhanghui
 * Date: 11-9-26
 * Time: 下午5:09
 * To change this template use File | Settings | File Templates.
 */

object Foreach {
  def fromStream(s: => InputStream) = new Foreach[Int] {
    type I = InputStream
    def source = new Source {
      def in = s
      def next(_in:InputStream) = _in.read match {
        case -1 => None
        case i => Some(i)
      }
    }
  }

  def fromReader(s: =>Reader) = new Foreach[Char] {
    type I = Reader
    def source = new Source {
      def in = s
      def next(_in:Reader) = _in.read match {
        case -1 => None
        case i => Some(i.toChar)
      }
    }
  }

  def fromInputAndFunction[A](s: =>InputStream,f:Int => A) = new Foreach[A]{
    type I = InputStream
    def source = new Source {
      def in = s
      def next(_in:InputStream) = _in.read() match {
        case -1 => None
        case i => Some(f(i))
      }
    }
  }
}

trait Foreach[A] {
  type I <: java.io.Closeable

  trait Source {
    def in: I

    def next(in: I): Option[A]
  }

  def source: Source

  def foreach[U](f: A => U): Unit = {
    val s = source.in
    try {
      def processNext: Unit = source.next(s) match {
        case None => ()
        case Some(value) =>
          f(value)
          processNext
      }
      processNext
    } finally {
      //correctly handle exception
      s.close()
    }

  }

}

object Exp2 extends App {

  val data = "hello world"
  val bytes = data.toArray.map { _.toByte}
  import Foreach._
  fromStream(new ByteArrayInputStream(bytes)).foreach(a=>print(a.toChar))

  println

  fromReader(new StringReader(data)) foreach print

  println

  fromInputAndFunction(new ByteArrayInputStream(bytes),i=>i.toChar) foreach print

}