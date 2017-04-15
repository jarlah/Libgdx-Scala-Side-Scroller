package com.github.jarlah.flappy.walk.core.screens

import com.badlogic.gdx.{Gdx, Screen}
import com.badlogic.gdx.graphics.GL20
import com.github.jarlah.flappy.walk.core.FlappyWalk

case class MenuScreen(game: FlappyWalk) extends Screen {

  def render(delta: Float) {
    if (Gdx.input.justTouched()) {
      game.setScreen(GameScreen(game))
      dispose()
      return
    }
    Gdx.gl.glClearColor(0, 0, 0.2f, 1)
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
    game.batch.begin()
    game.batch.draw(game.background, 0, 0, game.width, game.height)
    game.batch.draw(game.playBtn, game.width / 2 - game.playBtn.getWidth / 2, game.height / 2)
    game.batch.end()
  }

  def show() {}
  def resume() {}
  def pause() {}
  def hide() {}
  def dispose() {}
  def resize(width: Int, height: Int) {}
}
