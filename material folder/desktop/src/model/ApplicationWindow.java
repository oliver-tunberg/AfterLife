package model;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import java.awt.*;


/**
 * This class is created my the main method once the program is started.
 * This is the window which the game takes place.
 */
public class ApplicationWindow {

    /**
     * This instance is a window created by the libGDX framework.
     */
    private LwjglApplication application;

    /**
     * This instance contains settings which are later put in the LwjGApplication.
     * So this is only used to change things in the application window.
     */
    private LwjglApplicationConfiguration config;

    /**
     * The only constructor for this class. It needs no parameters.
     */
    public ApplicationWindow(){

        /**
         * Here we create the settings instance.
         * We will later set this instance and then put it in the application window.
         */
        this.config = new LwjglApplicationConfiguration();

        /**
         * This will set the width of the window.
         * The width will be as big as the screen no matter how big the screen is.
         */
        this.config.width = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();

        /**
         * This will set the height of the window.
         * The height will be as big as the screen no matter how big the screen is.
         */
        this.config.height = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();

        /**
         * This instance will start the application window.
         * This will need an <ApplicationListener> interface and ApplicationConfiguration.
         * The <ApplicationListener> interface in this case is the Game class which we have created.
         */
        this.application = new LwjglApplication(new Game(), config);

    }

}
