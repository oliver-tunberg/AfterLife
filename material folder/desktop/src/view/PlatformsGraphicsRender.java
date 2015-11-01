package view;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import model.GameObject;
import model.GameObjectValues;
import model.LevelManager;

import java.util.ArrayList;


public class PlatformsGraphicsRender extends GraphicsRender {

    @Override
    public void renderGraphics(LevelManager levelManager, SpriteBatch spriteBatch){
        setListOfGameObjects(levelManager.getPlatforms());
        iterateThroughList(spriteBatch);
    }

    @Override
    public void iterateThroughList(SpriteBatch spriteBatch) {
        for(int i=0; i<getListOfGameObjects().size(); i++){
            setSprites(getListOfGameObjects().get(i).getSpriteArray());
            setSpriteSize(getSprites()[0]);
            setSpritePosition(getSprites()[0], getListOfGameObjects().get(i));
            drawSpriteIntoSpriteBatch(spriteBatch, getSprites()[0]);
        }
    }

    @Override
    public void setSpriteSize(Sprite sprite) {
        sprite.setSize(GameObjectValues.platform0_width, GameObjectValues.platform0_height);
    }

    @Override
    public void setSpritePosition(Sprite sprite, GameObject gameObject) {
        float x = (gameObject.getBody().getPosition().x) - (GameObjectValues.platform0_width/2);
        float y = (gameObject.getBody().getPosition().y) - (GameObjectValues.platform0_height/2);
        sprite.setPosition(x, y);
    }

    @Override
    public void drawSpriteIntoSpriteBatch(SpriteBatch spriteBatch, Sprite sprite) {
        sprite.draw(spriteBatch);
    }

}
