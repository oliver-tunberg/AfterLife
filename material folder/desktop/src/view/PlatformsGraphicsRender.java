package view;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import model.MapLevel;


public class PlatformsGraphicsRender {

    public static void renderPlatformsGraphics(MapLevel mapLevel, SpriteBatch spriteBatch){
        for(int i=0; i< mapLevel.getPlatforms().size(); i++){
            Sprite sprite = mapLevel.getPlatforms().get(i).getSprite();
            sprite.setSize(20, 2);
            sprite.setPosition(mapLevel.getPlatforms().get(i).getBody().getPosition().x-10, mapLevel.getPlatforms().get(i).getBody().getPosition().y-1);
            sprite.draw(spriteBatch);
        }
    }

}
