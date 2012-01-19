name := "Empty Project"
 
version := "0.1"
 
scalaVersion := "2.9.1"

autoCompilerPlugins := true

addCompilerPlugin("org.scala-lang.plugins" % "continuations" % "2.9.1")

scalacOptions += "-P:continuations:enable"

libraryDependencies += "org.scalatest" %% "scalatest" % "1.6.1" % "test"

libraryDependencies += "se.scalablesolutions.akka" % "akka-actor" % "1.2"

libraryDependencies += "org.xerial" % "sqlite-jdbc" % "3.6.16"

libraryDependencies += "org.scalaz" %% "scalaz-core" % "6.0.3"