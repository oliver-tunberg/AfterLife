package handlers;
import game.Game;
import states.GameState;
import states.Play;
import java.util.Stack;

public class GameStateManager {

    private Game game;
    private Stack<GameState> gameStates;
    private static final int PLAY = 0;

    public GameStateManager(Game game){
        this.game = game;
        this.gameStates = new Stack<GameState>();
        pushState(PLAY);
    }

    public void update(float dt){
        gameStates.peek().update(dt);
    }

    public void render(){
        gameStates.peek().render();
    }

    private GameState getState(int state){
        if(state == PLAY){
            return new Play(this);
        }
        return null;
    }

    public void setState(int state){
        popState();
        pushState(state);
    }

    public void pushState(int state){
        gameStates.push(getState(state));
    }

    public void popState(){
        GameState g = gameStates.pop();
        g.dispose();
    }


    public Game getGame() {
        return game;
    }
}
