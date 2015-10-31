package view;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;
import model.Unit;

public class HealthBarRender {

    public static void renderHealthBar(Unit unit, SpriteBatch spriteBatch){
        Body body = unit.getBody();
        Sprite sprite = unit.getSprite_healthBar();
        setSpriteSize(sprite);
        setSpritePosition(body, sprite);
        drawSpriteIntoSpriteBatch(spriteBatch, sprite);
    }

    private static void setSpriteSize(Sprite sprite){
        sprite.setSize(2, (float)0.1);
    }

    private static void setSpritePosition(Body body, Sprite sprite){
        sprite.setPosition(body.getPosition().x - 1, body.getPosition().y + 2);
    }

    private static void drawSpriteIntoSpriteBatch(SpriteBatch spriteBatch, Sprite sprite){
        sprite.draw(spriteBatch);
    }

}
