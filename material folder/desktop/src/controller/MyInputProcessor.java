package controller;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputAdapter;

/**
 * This class extends the functionality of the InputAdapter provided by the libGDX framework.
 * When the application is started the libGDX framework is given a reference to this class.
 * When that is done this class will become a listener to input from the computer.
 */
public class MyInputProcessor extends InputAdapter {

    /**
     * This method is called when any key on the keyboard is pressed down.
     *
     * @param keycode an integer with the identity of the key pressed down.
     * @return if successful.
     */
    @Override
    public boolean keyDown(int keycode) {
        if(keycode == Keys.A){
            MyInput.setKey(MyInput.BUTTON_0, true);
        } else if(keycode == Keys.D){
            MyInput.setKey(MyInput.BUTTON_1, true);
        }
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        if(keycode == Keys.A){
            MyInput.setKey(MyInput.BUTTON_0, false);
        } else if(keycode == Keys.D){
            MyInput.setKey(MyInput.BUTTON_1, false);
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
