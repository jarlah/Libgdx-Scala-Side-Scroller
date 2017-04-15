package com.github.jarlah.flappy.walk.core

import com.badlogic.gdx.Game
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.physics.bullet.Bullet
import com.github.jarlah.flappy.walk.core.screens.MenuScreen
import com.badlogic.gdx.graphics.g2d.BitmapFont

class FlappyWalk extends Game {
  val width = FlappyWalk.WIDTH
  val height = FlappyWalk.HEIGHT

  var batch: SpriteBatch = _
  var font: BitmapFont = _
  var background: Texture = _
  var playBtn: Texture = _

  def create() {
    Bullet.init()
    batch = new SpriteBatch
    font = new BitmapFont
    background = new Texture("background.png")
    playBtn = new Texture("playbtn.png")
    this.setScreen(MenuScreen(this))
  }

  override def render() {
    super.render()
  }

  override def dispose() {
    batch.dispose()
  }
}

object FlappyWalk {
  val WIDTH = 800
  val HEIGHT = 480
  val TITLE = "Flappy Bird"
}