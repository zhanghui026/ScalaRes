

name:="scalaRes"

version:= "1.0"

scalaVersion := "2.9.1"

libraryDependencies ++= Seq(
    "org.specs2" %% "specs2" % "1.6.1",
    "org.specs2" %% "specs2-scalaz-core" % "6.0.1" % "test"
)

libraryDependencies ++= Seq(
  "se.scalablesolutions.akka" % "akka-actor" % "1.1.3",
  "se.scalablesolutions.akka" % "akka-typed-actor" % "1.1.3",
  "se.scalablesolutions.akka" % "akka-amqp" % "1.1.3",
  "se.scalablesolutions.akka" % "akka-testkit" % "1.1.3"
)

libraryDependencies += "anorm" %% "anorm" % "0.1"

libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.17"

