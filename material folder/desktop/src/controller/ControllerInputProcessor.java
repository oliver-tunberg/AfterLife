package controller;
import com.badlogic.gdx.Input.*;
import com.badlogic.gdx.InputAdapter;
import model.Play;


public class ControllerInputProcessor extends InputAdapter {

    private Play play;

    public ControllerInputProcessor(Play play){
        this.play = play;
    }

    @Override
    public boolean keyDown(int keycode) {
        if(keycode == Keys.A){
            play.getMap().getBox().getBody().applyForceToCenter(-10, 0, true);
        } else if(keycode == Keys.D){
            play.getMap().getBox().getBody().applyForceToCenter(10, 0, true);
        }

        return true;
    }

    @Override
    public boolean keyUp(int keycode) {

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
