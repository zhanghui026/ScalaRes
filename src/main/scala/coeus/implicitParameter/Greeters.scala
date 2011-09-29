package coeus.implicitParameter

/**
 * Created by IntelliJ IDEA.
 * User: zhangh
 * Date: 11-9-28
 * Time: 上午10:10
 * To change this template use File | Settings | File Templates.
 */

class PreferredPrompt(val preference:String)
class PreferredDrink(val preference:String)

object JobesPrefs {
  implicit val prompt = new PreferredPrompt("Yes,master>")
  implicit val drink = new PreferredDrink("tea")
}
object Greeters extends App{
  import JobesPrefs._
   def greet(name:String)(implicit prompt:PreferredPrompt,drink:PreferredDrink){
     println("Welcome," + name +" .The system is ready.")
     print("But while u work")
     println("why not enjoy a cup of "+drink.preference+"?")
     println(prompt.preference)

   }
  greet("Coeus")

}