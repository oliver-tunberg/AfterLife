package view;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import model.GameObject;
import model.LevelManager;

import java.util.ArrayList;

public abstract class GraphicsRender {

    private ArrayList<GameObject> listOfGameObjects;
    private Sprite[] sprites;

    public abstract void renderGraphics(LevelManager levelManager, SpriteBatch spriteBatch);
    public abstract void iterateThroughList(SpriteBatch spriteBatch);
    public abstract void setSpriteSize(Sprite sprite);
    public abstract void setSpritePosition(Sprite sprite, GameObject gameObject);
    public abstract void drawSpriteIntoSpriteBatch(SpriteBatch spriteBatch, Sprite sprite);

    public ArrayList<GameObject> getListOfGameObjects() {
        return listOfGameObjects;
    }
    public void setListOfGameObjects(ArrayList<GameObject> listOfGameObjects) {
        this.listOfGameObjects = listOfGameObjects;
    }
    public Sprite[] getSprites() {
        return sprites;
    }
    public void setSprites(Sprite[] sprites) {
        this.sprites = sprites;
    }

}
