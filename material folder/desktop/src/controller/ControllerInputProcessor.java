package controller;
import com.badlogic.gdx.Input.*;
import com.badlogic.gdx.InputAdapter;
import model.GameManager;


public class ControllerInputProcessor extends InputAdapter {

    private GameManager gameManager;

    public ControllerInputProcessor(GameManager gameManager){
        this.gameManager = gameManager;
    }

    @Override
    public boolean keyDown(int keycode) {
        if(keycode == Keys.A){
            gameManager.getPlayerMovement().setMoveLeft(true);
        } else if(keycode == Keys.D){
            gameManager.getPlayerMovement().setMoveRight(true);
        } else if(keycode == Keys.SPACE){
            gameManager.getPlayerMovement().setJump(true);
        }

        if(keycode == Keys.I){
            gameManager.getProjectileManager().fireProjectile(gameManager);
        }

        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        if(keycode == Keys.D){
            gameManager.getPlayerMovement().setMoveRight(false);
        }
        if(keycode == Keys.A){
            gameManager.getPlayerMovement().setMoveLeft(false);
        }
        return true;
    }

    @Override
    public boolean keyTyped(char character) {
        return super.keyTyped(character);
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return super.touchDown(screenX, screenY, pointer, button);
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return super.touchUp(screenX, screenY, pointer, button);
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return super.touchDragged(screenX, screenY, pointer);
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return super.mouseMoved(screenX, screenY);
    }

    @Override
    public boolean scrolled(int amount) {
        return super.scrolled(amount);
    }
}
