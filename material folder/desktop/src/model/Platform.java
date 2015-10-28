package model;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;

public class Platform extends GameObject {


    public Platform(World world, float x, float y, float width, float height, BodyDef.BodyType bodyType, String texturePath) {
        super(world, x, y, width, height, bodyType, texturePath);
    }
}
