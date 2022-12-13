# SBT poc

This repo is a reminder/examples on how to setup things with sbt

## Uber jar

It uses the [sbt-assembly](https://github.com/sbt/sbt-assembly) plugin.

```
addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "2.1.0")
```

```
lazy val root = (project in file("."))
  .settings(
    assembly / mainClass := Some("com.exemples.sbt.Main"),
  )

// Merge assembly for spark
assemblyMergeStrategy in assembly := {
  case PathList("META-INF", xs @ _*) => MergeStrategy.discard
  case x => MergeStrategy.first
}

```

To build the jar: `sbt assembly`

## Docker image

Depends on [sbt-native-packager](https://sbt-native-packager.readthedocs.io/en/stable/)

```
addSbtPlugin("com.github.sbt" % "sbt-native-packager" % "1.9.11")
```

```
enablePlugins(DockerPlugin)
Docker / packageName := "kensai/sbt-examples"
dockerBaseImage := "openjdk:17-jdk-slim"
```

To build the *kensai/sbt-examples:0.1.0-SNAPSHOT* image: `sbt docker:publishLocal`
