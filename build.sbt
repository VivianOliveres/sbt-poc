ThisBuild / scalaVersion := "2.13.8"
ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / organization := "com.exemples"
ThisBuild / organizationName := "sbt"

resolvers += Resolver.mavenLocal
resolvers += "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"

enablePlugins(JavaAppPackaging)

enablePlugins(DockerPlugin)
Docker / packageName := "kensai/sbt-examples"
dockerBaseImage := "openjdk:17-jdk-slim"

lazy val root = (project in file("."))
  .settings(
    assembly / mainClass := Some("com.exemples.sbt.Main"),
  )

// Merge assembly for spark
assemblyMergeStrategy in assembly := {
  case PathList("META-INF", xs @ _*) => MergeStrategy.discard
  case x => MergeStrategy.first
}
