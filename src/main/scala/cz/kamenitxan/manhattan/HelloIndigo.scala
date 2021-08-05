import indigo._

import scala.scalajs.js.annotation.JSExportTopLevel

@JSExportTopLevel("IndigoGame")
object HelloIndigo extends IndigoSandbox[Unit, Unit] {

	val config: GameConfig = GameConfig.default

	val animations: Set[Animation] = Set()

	val assetName = AssetName("dots")
	val assets: Set[AssetType] = {
		val assets: Set[indigo.AssetType] = Set(
			AssetType.Image(assetName, AssetPath("assets/useravatar.png"))
		)
		assets
	}

	val fonts: Set[FontInfo] = Set()

	val shaders: Set[Shader] = Set()

	def setup(assetCollection: AssetCollection, dice: Dice): Outcome[Startup[Unit]] = Outcome(Startup.Success(()))

	def initialModel(startupData: Unit): Outcome[Unit] = Outcome(())

	def updateModel(context: FrameContext[Unit], model: Unit): GlobalEvent => Outcome[Unit] = _ => Outcome(())

	def present(context: FrameContext[Unit], model: Unit): Outcome[SceneUpdateFragment] = {
		Outcome(
			SceneUpdateFragment(
				Graphic(Rectangle(0, 0, 32, 32), 1, Material.Bitmap(assetName))
					.moveTo(
						Signal
							.Orbit(config.viewport.center, 30)
							.map(_.toPoint)
							.at(context.gameTime.running)
					)
			)
		)
	}

}
