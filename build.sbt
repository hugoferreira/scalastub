name := "Empty Project"
 
version := "0.1"
 
scalaVersion := "2.9.1"

autoCompilerPlugins := true

addCompilerPlugin("org.scala-lang.plugins" % "continuations" % "2.9.1")

scalacOptions += "-P:continuations:enable"

libraryDependencies ++= Seq(
 "se.scalablesolutions.akka" % "akka-actor" % "1.2",
 "org.scala-tools.testing" %% "scalacheck" % "1.9" % "test",
 "org.xerial" % "sqlite-jdbc" % "3.6.16",
 "org.scalaz" %% "scalaz-core" % "6.0.3",
 "org.specs2" %% "specs2" % "1.7.1" % "test"
)