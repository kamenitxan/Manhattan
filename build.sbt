val scala3Version = "3.0.1"

lazy val mygame =
	(project in file("."))
		.enablePlugins(ScalaJSPlugin, SbtIndigo) // Enable the Scala.js and Indigo plugins
		.settings( // Standard SBT settings
			name := "manhattan",
			version := "0.0.1",
			scalaVersion := scala3Version,
			organization := "cz.kamenitxan.manhattan"
		)
		.settings( // Indigo specific settings
			showCursor := true,
			title := "Manhattan",
			gameAssetsDirectory := "assets",
			windowStartWidth := 720, // Width of Electron window, used with `indigoRun`.
			windowStartHeight := 480, // Height of Electron window, used with `indigoRun`.
			libraryDependencies ++= Seq(
				"io.indigoengine" %%% "indigo" % "0.9.0",
				"io.indigoengine" %%% "indigo-json-circe" % "0.9.0",
			)
		)

addCommandAlias("buildGame", ";compile;fastOptJS;indigoBuild")
addCommandAlias("runGame", ";compile;fastOptJS;indigoRun")
addCommandAlias("buildGameFull", ";compile;fullOptJS;indigoBuildFull")
addCommandAlias("runGameFull", ";compile;fullOptJS;indigoRunFull")