name := "Empty Project"
 
version := "0.1"
 
scalaVersion := "2.9.1"

autoCompilerPlugins := true

addCompilerPlugin("org.scala-lang.plugins" % "continuations" % "2.9.1")

scalacOptions += "-P:continuations:enable"

resolvers ++= Seq(
 "Typesafe Repository"   at "http://repo.typesafe.com/typesafe/releases/",
 "Scala Tools Snapshots" at "http://scala-tools.org/repo-releases"
)

libraryDependencies ++= Seq(
 "org.scala-tools.testing"   %% "scalacheck"  % "1.9"   % "test",
 "org.specs2"                %% "specs2"      % "1.8.2" % "test",
 "se.scalablesolutions.akka"  % "akka-actor"  % "1.3.1",
 "org.xerial"                 % "sqlite-jdbc" % "3.6.16",
 "org.scalaz"                %% "scalaz-core" % "6.0.4"
)