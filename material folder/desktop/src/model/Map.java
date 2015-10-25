package model;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;

public class Map {

    private World world;
    private Platform platform;
    private Platform box;

    public Map(){
        this.world = new World(new Vector2(0, (-10f)), true);
        this.world.setContactListener(new MyContactListener());
        this.platform = new Platform(world, 1000/100, 1000/100, 200/100, 200/100, BodyDef.BodyType.StaticBody);
        this.box = new Platform(world, 1000/100, 2000/100, 200/100, 200/100, BodyDef.BodyType.DynamicBody);
    }

    public World getWorld() {
        return world;
    }
    public Platform getPlatform() {
        return platform;
    }
    public Platform getBox() {
        return box;
    }
}
