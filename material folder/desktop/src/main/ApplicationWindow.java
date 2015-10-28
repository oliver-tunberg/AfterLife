package main;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import main.Game;

import java.awt.*;

public class ApplicationWindow {

    private LwjglApplication application;
    private LwjglApplicationConfiguration config;

    public ApplicationWindow(){
        this.config = new LwjglApplicationConfiguration();
        //this.config.fullscreen = true;
        this.config.width = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        this.config.height = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        this.application = new LwjglApplication(new Game(), config);
    }

}
