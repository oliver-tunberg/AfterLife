package states;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import model.Game;
import handlers.GameStateManager;

/**
 * This class is inherited by all classes that are states in the game.
 * It consists of all common information of these classes.
 * The states of the game updates the information and renders the graphics.
 */
public abstract class GameState {

    /**
     * The states needs information from the Game class, and a reference of the Game class is in the GameStateManager.
     */
    protected GameStateManager gsm;

    /**
     * To reach the cameras which are in the Game class the states need a reference to the Game class.
     */
    protected Game game;

    /**
     * The states uses a SpriteBatch to render the graphics of the game.
     */
    protected SpriteBatch sb;

    /**
     * This is the personal camera of the player character.
     */
    protected OrthographicCamera cam;

    /**
     * This is the camera of the information of the side.
     */
    protected OrthographicCamera hudcam;

    /**
     * This is the only constructor of this class.
     * It requires are reference to the GameStateManager inorder to reach the Game class.
     *
     * @param gsm a reference to the GameStateManager.
     */
    protected GameState(GameStateManager gsm){

        /**
         * Connects the GameStateManager into this class.
         */
        this.gsm = gsm;

        /**
         * Receives a reference to the Game class from the GameStateManager.
         */
        this.game = gsm.getGame();

        /**
         * Receives a reference to the SpriteBatch from the Game class.
         */
        this.sb = game.getSb();

        /**
         * Receives a reference to the personal camera from the Game class.
         */
        this.cam = game.getCam();

        /**
         * Receives a reference to the side information camera from the Game class.
         */
        this.hudcam = game.getHudcam();
    }

    /**
     *
     */
    public abstract void handleInput();
    public abstract void update(float dt);
    public abstract void render();
    public abstract void dispose();

}
