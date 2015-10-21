package model;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import handlers.GameStateManager;
import handlers.MyInput;
import handlers.MyInputProcessor;
import org.lwjgl.Sys;

import java.awt.*;

/**
 * Interface < ApplicationListener > :
 * An ApplicationListener is called when the Application is created, resumed, rendering, paused or destroyed.
 * All methods are called in a thread that has the OpenGL context current.
 * You can thus safely create and manipulate graphics resources.
 * source: https://libgdx.badlogicgames.com/nightlies/docs/api/com/badlogic/gdx/ApplicationListener.html
 *
 * This is one of the head classes of the game.
 * It contains the looping method which runs the entire game.
 * It will work from the moment the application is started til the very last moment when it is closed down.
 */
public class Game implements ApplicationListener { //   ?

    /**
     * The SpriteBatch implements the Batch interface.
     * Here are some information collected from the framework:
     *
     * A Batch is used to draw 2D rectangles that reference a texture (region).
     * The class will batch the drawing commands and optimize them for processing by the GPU.
     * All drawing commands of the Batch operate in screen coordinates.
     * The screen coordinate system has an x-axis pointing to the right, an y-axis pointing upwards and the origin is in the lower left corner of the screen.
     * You can also provide your own transformation and projection matrices if you so wish.
     *
     * source: https://libgdx.badlogicgames.com/nightlies/docs/api/com/badlogic/gdx/graphics/g2d/Batch.html
     */
    private SpriteBatch sb;

    /**
     * The OrthographicCamera is used to control what the computer screen will show.
     * It works like a window into the world of the game.
     * This view into the game can zoom in and out, follow and move around inside the world.
     *
     * This camera is supposed to follow the player of the game.
     */
    private OrthographicCamera cam;

    /**
     * This camera is supposed to help display the corner information of the game.
     */
    private OrthographicCamera hudcam;

    /**
     * This number is used to control the rate in which the frames update.
     * If a powerful computer wants to run through the game loop a lot quicker then it was intended then it will still not pass 60 fps.
     */
    private static final float STEP = 1 / 60f;

    /**
     * This number helps with the frame rate control.
     */
    private float accum;

    /**
     * The GameStateManager handles the states in which the game takes place in.
     * Examples of states could be gameplay, menu and paused state.
     */
    private GameStateManager gsm;

    /**
     * This method is called when the application first starts up.
     * It initializes many of the important functions of the game.
     */
    @Override
    public void create() {

        /**
         * Here we connect our controller classes with the libGDX framework.
         * The framework wants an <InputProcessor> interface, which it receives from our created class MyInputProcessor.
         */
        Gdx.input.setInputProcessor(new MyInputProcessor());

        /**
         * Here is the SpriteBatch initialized.
         * It will be used by other classes and they will get it through the getter method.
         */
        sb = new SpriteBatch();

        /**
         * Here we initialize the personal camera instance.
         */
        cam = new OrthographicCamera();

        /**
         * Here we set the personal camera to focus on the entire game window.
         * This will set the zoom to fit the screen monitor width and height on your particular monitor.
         */
        cam.setToOrtho(false, (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(), (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight());

        /**
         * Here we initialize the gameplay information camera instance.
         */
        hudcam = new OrthographicCamera();

        /**
         * Here we set the gameplay information camera to focus on the entire game window.
         * This will set the zoom to fit the screen monitor width and height on your particular monitor.
         */
        hudcam.setToOrtho(false, (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(), (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight());

        /**
         * Here we initialize the GameStateManager.
         * The GameStateManager requires this class because this class is one of the states which the game consists of.
         */
        gsm = new GameStateManager(this);
    }

    /**
     * This method resized the application window.
     *
     * @param width the new width of the window.
     * @param height the new height of the window.
     */
    @Override
    public void resize(int width, int height) {

    }

    /**
     * This method will run as fast as possible for as long as the application is running.
     * This is the looping method which runs the game.
     */
    @Override
    public void render() {

        /**
         * This value will increase with the time between the frames.
         * When the computer update frames quickly the value of increment will be smaller.
         * When the computer update frames slowly the value of increment will be higher.
         * This makes all computer as long as they have enough power to run just as fast.
         */
        accum = accum + Gdx.graphics.getDeltaTime();

        /**
         * This condition limits the program to the speed of the set frames per second.
         */
        while(STEP <= accum){

            /**
             * This pushes back the tracking value at amount of the set limit value.
             */
            accum = accum - STEP;

            /**
             * This commands the GameStateManager to update the state which is currently active.
             */
            gsm.update(STEP);

            /**
             * This commands the GameStateManager to render the state which is currently active.
             */
            gsm.render();

            /**
             * This method commands the controller input class to update the variables of which keys have been pressed.
             */
            MyInput.update();
        }
    }

    /**
     * Methods inherited by the ApplicationListener Interface.
     * They are tools which can help but they are not being used at the current version of the game.
     * Nevertheless they have to be here inorder to satisfy the interface.
     */
    @Override public void pause() {}
    @Override public void resume() {}
    @Override public void dispose() {}

    /**
     * Getter methods.
     */
    public SpriteBatch getSb() {return sb;}
    public OrthographicCamera getCam() {return cam;}
    public OrthographicCamera getHudcam() {return hudcam;}

}
