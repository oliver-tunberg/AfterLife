package handlers;
import model.Game;
import states.GameState;
import states.Play;
import java.util.Stack;

/**
 * The GameStateManager is the central of the game states.
 * This class contains all of the different states which will be used in the game.
 * Examples of states are gameplay, menu and paused state.
 * This class will be able to switch between the states.
 */
public class GameStateManager {

    /**
     * A reference to the Game class.
     */
    private Game game;

    /**
     * A stack of GameStates.
     * Here are all the states of the game collected.
     */
    private Stack<GameState> gameStates;

    /**
     * The name i the form of a number of the game state Play.
     */
    private static final int PLAY = 0;

    /**
     * The only constructor of this class.
     * @param game a reference to the Game class.
     */
    public GameStateManager(Game game){

        /**
         * The Game class created this class and this class also has a reference to the Game class.
         */
        this.game = game;

        /**
         * Initiating the stack of game states.
         */
        this.gameStates = new Stack<GameState>();

        /**
         * Puts the game state Play first onto the stack.
         * Which will make the game state Play the state that will be active when the application starts.
         */
        pushState(PLAY);
    }

    /**
     * This method is called from the game loop.
     * Here the state which is on top of the stack will be selected and commanded to update the information.
     *
     * @param dt this is the value of the time between the frames.
     */
    public void update(float dt){
        gameStates.peek().update(dt);
    }

    /**
     * This method is called from the game loop.
     * Here the state which is on top of the stack will be selected and commanded to render the graphics.
     */
    public void render(){
        gameStates.peek().render();
    }

    /**
     * Removes the state that was recently on the stack and puts a new one on it.
     *
     * @param state the state which is to replace the older state.
     */
    public void setState(int state){
        popState();
        pushState(state);
    }

    /**
     * A sort of factory method.
     * Depending on which value is given to this method it will return a state.
     * This method will return the state that the client is selecting via the parameter.
     *
     * @param stateNumber the name of the state the client wants.
     * @return the state which was specified by the parameter.
     */
    private GameState getState(int stateNumber){
        if(stateNumber == PLAY){
            return new Play(this);
        }
        return null;
    }

    /**
     * This method receives the name of a state and then puts the correct state in the stack.
     *
     * @param state the state wished to be put on the stack.
     */
    public void pushState(int state){
        gameStates.push(getState(state));
    }

    /**
     * This method is called upon when a state on the stack is supposed to be removed.
     * The state is first taken of the stack and then commanded to destroy it self.
     */
    public void popState(){
        GameState g = gameStates.pop();
        g.dispose();
    }

    /**
     * Getter methods.
     */
    public Game getGame() {
        return game;
    }
}
