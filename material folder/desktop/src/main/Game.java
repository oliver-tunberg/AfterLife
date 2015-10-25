package main;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import controller.ControllerInputProcessor;
import model.Play;
import model.Player;
import view.GraphicsRender;

public class Game implements ApplicationListener {

    private static final float STEP = 1 / 60f;
    private float accum;
    private Play play;
    private GraphicsRender graphicsRender;
    private ControllerInputProcessor controllerInputProcessor;

    @Override
    public void create() {
        this.play = new Play();
        this.graphicsRender = new GraphicsRender(this.play);
        controllerInputProcessor = new ControllerInputProcessor(this.play);
        Gdx.input.setInputProcessor(this.controllerInputProcessor);
    }

    @Override
    public void render() {

        accum = accum + Gdx.graphics.getDeltaTime();

        while(STEP <= accum){
            accum = accum - STEP;
            play.update(STEP);
            graphicsRender.renderGraphics();
        }

    }

    @Override public void resize(int width, int height) {}
    @Override public void pause() {}
    @Override public void resume() {}
    @Override public void dispose() {}




}
