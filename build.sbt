ThisBuild / scalaVersion := "2.13.16"
ThisBuild / organization := "dev.fp"
ThisBuild / version      := "0.1.0"

javacOptions ++= Seq(
    "--release", "21"
)

scalacOptions ++= Seq(
    "-deprecation",
    "-feature"
)

libraryDependencies ++= Seq()

