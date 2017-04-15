package com.github.jarlah.flappy.walk.core.screens

import com.github.jarlah.flappy.walk.core.FlappyWalk
import com.badlogic.gdx.{Gdx, Input, Screen}
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.maps.tiled.{TiledMap, TmxMapLoader}
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer

case class GameScreen(game: FlappyWalk) extends Screen {

  private val camera = new OrthographicCamera(game.width, game.height)
  camera.setToOrtho(false, game.width, game.height)
  camera.update()

  private val initialCameraYPos = camera.position.y
  private val initialCameraXPos = camera.position.x

  private val tiledMap = new TmxMapLoader().load("levels/gameart2d-desert.tmx")
  private val tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap)
  private val tileLayer = tiledMap.getLayers.get("foreground").asInstanceOf[TiledMapTileLayer]
  private val tileHeight = tileLayer.getHeight * tileLayer.getTileHeight
  private val tileWidth = tileLayer.getWidth * tileLayer.getTileWidth

  private val speed = 4f

  def handleInput(): Unit = {
    if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
      if ((camera.position.x + speed) < (initialCameraXPos + tileWidth - game.width)) {
        camera.translate(+speed, 0)
      }
    }
    if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
      if ((camera.position.x - speed) > initialCameraXPos) {
        camera.translate(-speed, 0)
      }
    }
    if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
      if ((camera.position.y + speed) < (initialCameraYPos + tileHeight - game.height)) {
        camera.translate(0, +speed)
      }
    }
    if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
      if ((camera.position.y - speed) > initialCameraYPos) {
        camera.translate(0, -speed)
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
