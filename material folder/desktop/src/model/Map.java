package model;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;

import java.util.ArrayList;

public class Map {

    private World world;
    private ArrayList<GameObject> platforms;
    private GameObject player;

    public Map(){
        this.world = new World(new Vector2(0, (-100f)), true);
        this.world.setContactListener(new MyContactListener());

        this.platforms = new ArrayList<>();
        this.platforms.add(new GameObject(world, 10, 10, 10, 1, BodyDef.BodyType.StaticBody));
        this.platforms.add(new GameObject(world, 35, 10, 10, 1, BodyDef.BodyType.StaticBody));
        this.player = new GameObject(world, 10, 18, 1, 1, BodyDef.BodyType.DynamicBody);
    }

    public World getWorld() {
        return world;
    }
    public ArrayList<GameObject> getPlatforms() {
        return platforms;
    }
    public GameObject getPlayer() {
        return player;
    }
}
