package model;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import model.Game;
import model.GameStateManager;

public abstract class GameState {

    private OrthographicCamera camera;

    protected GameState(){
        this.camera = new OrthographicCamera();
    }

    public abstract void update(float dt);
    public abstract void handleInput();
    public abstract void render();
    public abstract void dispose();

    public OrthographicCamera getCamera() {
        return camera;
    }

}
