package model;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import controller.MyInput;
import controller.MyInputProcessor;

public class Game implements ApplicationListener {

    private static final float STEP = 1 / 60f;
    private float accum;
    private GameStateManager gsm;

    @Override
    public void create() {
        Gdx.input.setInputProcessor(new MyInputProcessor());
        gsm = new GameStateManager();
    }

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

    @Override public void resize(int width, int height) {}
    @Override public void pause() {}
    @Override public void resume() {}
    @Override public void dispose() {}




}
