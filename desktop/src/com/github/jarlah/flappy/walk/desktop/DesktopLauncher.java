package com.github.jarlah.flappy.walk.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.github.jarlah.flappy.walk.core.FlappyWalk;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = FlappyWalk.WIDTH();
		config.height = FlappyWalk.HEIGHT();
		config.title = FlappyWalk.TITLE();
		new LwjglApplication(new FlappyWalk(), config);
	}
}
