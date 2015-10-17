package model;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import handlers.GameStateManager;
import handlers.MyInput;
import handlers.MyInputProcessor;

import java.awt.*;

public class Game implements ApplicationListener {

    private SpriteBatch sb;
    private OrthographicCamera cam;
    private OrthographicCamera hudcam;

    private static final float STEP = 1 / 60f;
    private float accum;

    private GameStateManager gsm;

    @Override
    public void create() {

        Gdx.input.setInputProcessor(new MyInputProcessor());

        sb = new SpriteBatch();

        cam = new OrthographicCamera();
        cam.setToOrtho(false, (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(), (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight());

        hudcam = new OrthographicCamera();
        hudcam.setToOrtho(false, (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(), (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight());

        gsm = new GameStateManager(this);
    }

    @Override
    public void resize(int width, int height) {

    }

    /**
     * Looping method
     */
    @Override
    public void render() {

        accum = accum + Gdx.graphics.getDeltaTime();
        while(STEP <= accum){
            accum = accum - STEP;
            gsm.update(STEP);
            gsm.render();
            MyInput.update();

        }

    }

    @Override
    public void pause() {


    }

    @Override
    public void resume() {


    }

    @Override
    public void dispose() {


    }


    public SpriteBatch getSb() {
        return sb;
    }
    public OrthographicCamera getCam() {
        return cam;
    }
    public OrthographicCamera getHudcam() {
        return hudcam;
    }

}
