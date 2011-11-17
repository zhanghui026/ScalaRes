package scalaz

/**
 * Created by IntelliJ IDEA.
 * User: zhangh
 * Date: 11-10-18
 * Time: 下午4:06
 * To change this template use File | Settings | File Templates.
 */

trait Equal[-A]{
  def equal(a1:A, a2:A):Boolean
}

trait Equals {
  def equal[A](f:(A, A) => Boolean):Equal[A] = new Equal[A] {
    def equal(a1:A,a2:A) = f(a1,a2)
  }

  trait NaturalEqual

  def equalA[A]:Equal[A] = new Equal[A] with NaturalEqual{
    def equal(a1: A, a2: A) = a1 == a2
  }

// def equalBy[A, B: Equal](f: A => B): Equal[A] = implicitly[Equal[B]] ∙ f
}