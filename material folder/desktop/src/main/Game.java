package main;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import controller.ControllerInputProcessor;
import model.GameManager;
import view.GraphicsRender;

public class Game implements ApplicationListener {

    private static final float STEP = 1 / 60f;
    private float accum;
    private GameManager gameManager;
    private GraphicsRender graphicsRender;
    private ControllerInputProcessor controllerInputProcessor;

    @Override
    public void create() {
        this.gameManager = new GameManager();
        this.graphicsRender = new GraphicsRender(this.gameManager);
        controllerInputProcessor = new ControllerInputProcessor(this.gameManager);
        Gdx.input.setInputProcessor(this.controllerInputProcessor);
    }

    @Override
    public void render() {

        accum = accum + Gdx.graphics.getDeltaTime();

        while(STEP <= accum){
            accum = accum - STEP;
            gameManager.update(STEP);
            graphicsRender.renderGraphics();
        }

    }

    @Override public void resize(int width, int height) {}
    @Override public void pause() {}
    @Override public void resume() {}
    @Override public void dispose() {}




}
