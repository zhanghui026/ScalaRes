package coeus.scalares

import org.specs2.mutable.Specification

/**
 * Created by IntelliJ IDEA.
 * User: zhanghui
 * Date: 11-9-9
 * Time: 上午9:41
 * To change this template use File | Settings | File Templates.
 */
class DogTest extends Specification {
  "test" should {
    "dog test" in {
      val dog: Dog = new Dog(12, 33, 22)
      dog.weight must_== 33


    }
  }
}