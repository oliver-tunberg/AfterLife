package states;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import game.Game;
import handlers.GameStateManager;

public abstract class GameState {

    protected GameStateManager gsm;
    protected Game game;

    protected SpriteBatch sb;
    protected OrthographicCamera cam;
    protected OrthographicCamera hudcam;

    protected GameState(GameStateManager gsm){
        this.gsm = gsm;
        this.game = gsm.getGame();
        this.sb = game.getSb();
        this.cam = game.getCam();
        this.hudcam = game.getHudcam();
    }

    public abstract void handleInput();
    public abstract void update(float dt);
    public abstract void render();
    public abstract void dispose();

}
