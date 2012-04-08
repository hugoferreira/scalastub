name := "Empty Project"
 
version := "0.1"
 
scalaVersion := "2.10-SNAPSHOT"

resolvers ++= Seq(
 "Typesafe Repository"   at "http://repo.typesafe.com/typesafe/releases/",
 "Scala Tools Snapshots" at "http://scala-tools.org/repo-releases"
)

libraryDependencies ++= Seq(
 // "org.scala-tools.testing"   %% "scalacheck"  % "1.9"   % "test",
 // "org.specs2"                %% "specs2"      % "1.8.2" % "test",
 "com.typesafe.akka"  		  % "akka-actor"  % "2.0"
 // "org.scalaz"                %% "scalaz-core" % "7.0-SNAPSHOT"
)