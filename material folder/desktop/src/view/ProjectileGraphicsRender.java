package view;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import model.LevelManager;

public class ProjectileGraphicsRender {

    public static void renderProjectileGraphics(LevelManager levelManager, SpriteBatch spriteBatch){
        if(0< levelManager.getProjectiles().size()) {
            for (int i = 0; i < levelManager.getProjectiles().size(); i++) {
                float x = levelManager.getProjectiles().get(i).getBody().getPosition().x;
                float y = levelManager.getProjectiles().get(i).getBody().getPosition().y;
                Sprite[] sprites = levelManager.getProjectiles().get(i).getSpriteArray();
                sprites[0].setSize((float) 0.2, (float) 0.2);
                sprites[0].setPosition(x, y);
                sprites[0].draw(spriteBatch);

            }
        }
    }

}
