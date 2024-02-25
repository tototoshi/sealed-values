val scalaVersion_3 = "3.3.1"

lazy val root = project
  .in(file("."))
  .settings(
    name := "sealed-values",
    organization := "com.github.tototoshi",
    version := "0.1.0-SNAPSHOT",
    scalaVersion := scalaVersion_3,
    libraryDependencies ++= Seq(
      "org.slf4j" % "slf4j-api" % "2.0.11",
      "ch.qos.logback" % "logback-classic" % "1.4.14",
      "org.scalatest" %% "scalatest" % "3.2.17" % "test"
    )
  )
