package view;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import model.MapLevel;

public class ProjectileGraphicsRender {

    public static void renderProjectileGraphics(MapLevel mapLevel, SpriteBatch spriteBatch){
        if(0<mapLevel.getProjectiles().size()) {
            for (int i = 0; i < mapLevel.getProjectiles().size(); i++) {
                float x = mapLevel.getProjectiles().get(i).getBody().getPosition().x;
                float y = mapLevel.getProjectiles().get(i).getBody().getPosition().y;
                Sprite sprite = mapLevel.getProjectiles().get(i).getSprite();
                sprite.setSize((float) 0.2, (float) 0.2);
                sprite.setPosition(x, y);
                sprite.draw(spriteBatch);

            }
        }
    }

}
