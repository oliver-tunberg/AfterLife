package handlers;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputAdapter;




public class MyInputProcessor extends InputAdapter {


    @Override
    public boolean keyDown(int keycode) {
        if(keycode == Keys.Z){
            MyInput.setKey(MyInput.BUTTON_0, true);
        } else if(keycode == Keys.X){
            MyInput.setKey(MyInput.BUTTON_1, true);
        }
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        if(keycode == Keys.Z){
            MyInput.setKey(MyInput.BUTTON_0, false);
        } else if(keycode == Keys.X){
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
