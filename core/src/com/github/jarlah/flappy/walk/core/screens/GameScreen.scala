package com.github.jarlah.flappy.walk.core.screens

import com.github.jarlah.flappy.walk.core.FlappyWalk
import com.badlogic.gdx.{Gdx, Input, Screen}
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.maps.tiled.{TiledMap, TmxMapLoader}
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer

case class GameScreen(game: FlappyWalk) extends Screen {

  val camera = new OrthographicCamera(game.width, game.height)

  camera.setToOrtho(false, game.width, game.height)
  camera.update()

  val initialCameraYPos: Float = camera.position.y
  val initialCameraXPos: Float = camera.position.x

  val tiledMap: TiledMap = new TmxMapLoader().load("levels/gameart2d-desert.tmx")
  val tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap)
  val tileLayer: TiledMapTileLayer = tiledMap.getLayers.get("foreground").asInstanceOf[TiledMapTileLayer]
  val tileHeight: Float = tileLayer.getHeight * tileLayer.getTileHeight
  val tileWidth: Float = tileLayer.getWidth * tileLayer.getTileWidth

  def handleInput(): Unit = {
    if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
      if ((camera.position.x + 10) < (initialCameraXPos + tileWidth)) {
        camera.translate(+10, 0)
      }
    }
    if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
      if ((camera.position.x - 10) > initialCameraXPos) {
        camera.translate(-10, 0)
      }
    }
    if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
      if ((camera.position.y + 10) < (initialCameraYPos + tileHeight)) {
        camera.translate(0, +10)
      }
    }
    if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
      if ((camera.position.y - 10) > initialCameraYPos) {
        camera.translate(0, -10)
      }
    }
  }

  def render(delta: Float) {
    handleInput()
    Gdx.gl.glClearColor(1, 0, 0, 1)
    Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA)
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
    camera.update()
    tiledMapRenderer.setView(camera)
    tiledMapRenderer.render()
  }

  override def show() {}
  override def resume() {}
  override def pause() {}
  override def hide() {}
  override def resize(width: Int, height: Int) {}
  override def dispose() {}
}
