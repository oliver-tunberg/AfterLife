package view;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import model.GameObject;
import model.LevelManager;

import java.util.ArrayList;


public class PlatformsGraphicsRender {

    public static void renderPlatformsGraphics(LevelManager levelManager, SpriteBatch spriteBatch){

        ArrayList<GameObject> listOfPlatforms = levelManager.getPlatforms();
        Sprite[] sprites;

        for(int i=0; i<listOfPlatforms.size(); i++){
            sprites = listOfPlatforms.get(i).getSpriteArray();
            sprites[0].setSize(20, 2);
            sprites[0].setPosition(listOfPlatforms.get(i).getBody().getPosition().x - 10, listOfPlatforms.get(i).getBody().getPosition().y - 1);
            sprites[0].draw(spriteBatch);
        }
    }

}
