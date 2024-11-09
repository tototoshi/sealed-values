val scalaVersion_3 = "3.3.4"

lazy val root = project
  .in(file("."))
  .settings(
    name := "sealed-values",
    organization := "com.github.tototoshi",
    version := "0.1.0-SNAPSHOT",
    scalaVersion := scalaVersion_3,
    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % "3.2.18" % "test"
    )
  )
