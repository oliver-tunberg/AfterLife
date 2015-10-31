package model;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;

public class Player extends Unit {

    public Player(World world, float x, float y, float width, float height) {
        super(world, x, y, width, height, BodyDef.BodyType.DynamicBody, PathVariables.player_moving0, PathVariables.player_moving1);
    }


}
