package coeus.anormLearn

/**
 * Created by IntelliJ IDEA.
 * User: zhanghui
 * Date: 11-9-20
 * Time: 上午10:15
 * To change this template use File | Settings | File Templates.
 */

import play.db.anorm._
import play.db.Config._
import java.sql.DriverManager
import java.lang.RuntimeException

object WorldAnorm extends App {
  setConnection((Unit) => {
    val driver = "com.mysql.jdbc.Driver"
    val url = "jdbc:mysql://localhost/world"
    Class.forName(driver)
    DriverManager.getConnection(url, "root", "admin")
  })
  val result: Boolean = SQL("Select 1").execute()
  println(result)

  val result2 = SQL("delete from city where id = 99").executeUpdate()
  println(result2)

  var sqlQuery = SQL(
    """select * from Country c join CountryLanguage l on l.CountryCode = c.Code where c.code = 'FRA';
    """
  )
  val list = sqlQuery().toList
  println(list.size)

  var sqlQuery2 = SQL(
    "select * from Country c join CountryLanguage l on l.CountryCode = c.Code where c.code = {countryCode};"
  ).on(("countryCode" -> "FRA")) //.onParams("FRA")
  //    sqlQuery2
  val list2 = sqlQuery2().toList
  println(list2.size)

  //Retrieving data using the Stream API
  val selectCountries = SQL("Select * from country")

  //Transform the resulting Stream[Row] as a List[(String,String)]
  val countries = selectCountries().map(row => row[String]("code") -> row[String]("name")).toList
  println(countries)


  //First retrieve the first row
  val firstRow = SQL("select count(*) as c from country")().head
  println(firstRow)

  //next get the the content of the 'c' column as Long
  val countryCount = firstRow[Long]("c")
  println(countryCount)

  //Using pattern matching
  //u can also use pattern matching to match and extract the row content.
  case class SmallCountry(name: String)

  case class BigCountry(name: String)

  case class France()

  val countries2 = SQL("select name,population from country")().collect {
    case Row("France", _) => France()
    case Row(name: String, pop: Int) if (pop > 1000000) => BigCountry(name)
    case Row(name: String, _) => SmallCountry(name)

  }

  //  countries2 foreach println _

  //Dealing with Nullable columns
  //if a column can contain Null values in the database schema,you need to manipulate it as an Option type
  val indepYear = SQL("select name,indepYear from Country")().collect {
    case Row(name: String, Some(year)) => name -> year
  }
  println(indepYear.toList.size)
  indepYear foreach println _
  //if try to match this column as short,throw unexpectedNullableFound(Country.INDEPYEAR)
  try {
    val nullexception = SQL("select name,indepYear from Country")().map {
      row => row[String]("name") -> row[Int]("indepYear")
    }
  } catch {
    case e: RuntimeException => println("抛出异常" + e.getMessage)
  }

  //need to map it properly to an Option[Short]
  val theSql = SQL("select name,indepYear from Country")().map {
    row => row[String]("name") -> row[Option[Int]]("indepYear")
  }
  println(theSql.toList.size)
  import play.db.anorm.SqlParser._
  //Using the parse combinator API
  val count:Long = SQL("select count(*) from Country").as(scalar[Long])
  val populations:List[String~Int] = {
    SQL("select * from Country").as( str("name") ~< int("population") * )
}
    val onePopulation:String~Int = {
    SQL("select * from Country").parse(
        str("name") ~< int("population")
    )
}
  //Adding some Magic[T]


   val countries3:List[Country]= SQL("select * from Country").as(rep(Country))
  println(countries3)
}