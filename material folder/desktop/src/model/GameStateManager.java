package model;

public class GameStateManager {

    private GameState gameState;

    public GameStateManager(){

        this.gameState = new Play();

    }

    public void update(float dt){
        gameState.update(dt);
    }

    public void render(){
        gameState.render();
    }

}
