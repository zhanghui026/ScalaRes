package coeus.easySyntax

/**
 * Created by IntelliJ IDEA.
 * User: zhanghui
 * Date: 11-9-26
 * Time: 下午3:47
 * To change this template use File | Settings | File Templates.
 */

/*
 * dealing with abstract types:attention
 *
 * if u r not explicit when assigning a variable or defining a funtion u can
 * get unexcepted compiler errors
 *
 */
object TypeInferenceWithAbstractType extends App{
     trait S {
       type x
       def get : x
     }

  var sample = new S {
    type x = Int
    def get = 3
  }
   //compile will type mismatch
//   sample = new S {
//     type x = Double
//     def get = 3.0
//   }

   //fix is to explicitly declare the variable type
  var sample2 :S = new S {
    type  x = Int
    def get = 3

  }
  //type match
  sample2 = new S {
    type x = Double
    def get = 3.0
  }


  //the same thing happens when declaring functions and allows type inference for function definition
  class Fac{
    def newS = new S {
      type x = Int
      def get = 3
    }
  }

//  class SubFac extends Fac {
//    override def newS = new S {
//      type x = Double
//      def get = 3.0
//    }
//  }


  //fix it
  class Fac2 {
    def newS:S = new S {
      type x = Int
      def get = 3
    }


  }
  class SubFac2 extends Fac2 {
    override def newS = new S {
      type x = Double
      def get =3.0
    }
  }
}