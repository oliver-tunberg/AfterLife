package com.mygdx.game.desktop;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.GameHead;
import game.Game;

import java.awt.*;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		config.height = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		new LwjglApplication(new Game(), config);
	}
}
