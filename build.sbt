name := """survey-project-web"""
organization := "com.Tchana"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.13.8"

libraryDependencies += guice
libraryDependencies ++= Seq(
  "org.scala-lang" % "scala-library" % scalaVersion.value,
  "org.scala-lang" % "scala-compiler" % scalaVersion.value % "scala-tool",
  "org.scala-lang.modules" %% "scala-parser-combinators" % "1.1.2",
  "org.apache.poi" % "poi" % "5.0.0",
  "org.apache.poi" % "poi-ooxml" % "5.0.0",
  "io.spray" %% "spray-json" % "1.3.5",
  "com.github.scopt" %% "scopt" % "3.7.1",
  "ch.qos.logback" % "logback-classic" % "1.1.7",
  "org.slf4j" % "slf4j-api" % "1.7.10",
  "org.apache.pdfbox" % "pdfbox" % "2.0.1",
  "org.apache.pdfbox" % "fontbox" % "2.0.1",
)
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "5.0.0" % Test

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.Tchana.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.Tchana.binders._"
