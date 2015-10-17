package model;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import java.awt.*;

public class ApplicationWindow {

    private LwjglApplicationConfiguration config;
    private LwjglApplication application;

    public ApplicationWindow(){

        this.config = new LwjglApplicationConfiguration();
        config.width = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        config.height = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        this.application = new LwjglApplication(new Game(), config);

    }

}
