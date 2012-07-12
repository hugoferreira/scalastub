resolvers += "Sonatype snapshots" at "http://oss.sonatype.org/content/repositories/snapshots/"

resolvers += "spray repo" at "http://repo.spray.cc"

resolvers += Resolver.url("artifactory", url("http://scalasbt.artifactoryonline.com/scalasbt/sbt-plugin-releases"))(Resolver.ivyStylePatterns)

addSbtPlugin("com.github.mpeltonen" % "sbt-idea" % "1.1.0-SNAPSHOT")

addSbtPlugin("org.ensime" % "ensime-sbt-cmd" % "0.0.10")

addSbtPlugin("cc.spray" % "sbt-revolver" % "0.6.1")

addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "0.8.3")
