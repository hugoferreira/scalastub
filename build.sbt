name := "Empty Project"
 
version := "0.1"
 
scalaVersion := "2.9.2"

resolvers ++= Seq(
 "snapshots"             at "http://oss.sonatype.org/content/repositories/snapshots",
 "releases"              at "http://oss.sonatype.org/content/repositories/releases",
 "Typesafe Repository"   at "http://repo.typesafe.com/typesafe/releases/"
)

libraryDependencies ++= Seq(
 "org.scalacheck"            %% "scalacheck"  % "1.9" % "test",
 "org.specs2"                %% "specs2"      % "1.9" % "test",
 "com.typesafe.akka"  		  % "akka-actor"  % "2.0.1",
 "org.scalaz"                %% "scalaz-core" % "7.0-SNAPSHOT"
)
