package coeus.anormLearn

/**
 * Created by IntelliJ IDEA.
 * User: zhanghui
 * Date: 11-9-20
 * Time: 下午5:55
 * To change this template use File | Settings | File Templates.
 */

import play.db.anorm.defaults._
 import play.db.anorm.{Pk, Id}

 case class Country(
   code:Id[String], name:String, population:Int, headOfState:Option[String]
 )

 case class City(
   id:Pk[Int], name: String
 )

 case class CountryLanguage(
   language:String, isOfficial:String
 )

 object Country extends Magic[Country]
 object CountryLanguage extends Magic[CountryLanguage]
 object City extends Magic[City]
