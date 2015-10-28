package model;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;
import main.Game;

import java.util.ArrayList;

public class MapLevel {

    private World world;
    private ArrayList<GameObject> platforms;
    private Player player;
    private Background background;
    private ArrayList<GameObject> projectiles;
    private ArrayList<GameObject> gameObjectsToDestroyList;

    public MapLevel(){
        this.world = new World(new Vector2(0, (-100f)), true);
        this.world.setContactListener(new MyContactListener(this));

        this.gameObjectsToDestroyList = new ArrayList<>();
        this.platforms = new ArrayList<>();
        this.projectiles = new ArrayList<>();
        this.platforms.add(new GameObject(world, 10, 10, 10, 1, BodyDef.BodyType.StaticBody, "C:\\Users\\Max4u_000\\Documents\\Projekt\\source code\\AfterLife\\material folder\\graphics_material\\image1.png"));
        this.platforms.add(new GameObject(world, 30, 10, 10, 1, BodyDef.BodyType.StaticBody, "C:\\Users\\Max4u_000\\Documents\\Projekt\\source code\\AfterLife\\material folder\\graphics_material\\image1.png"));
        this.platforms.add(new GameObject(world, 20, 20, 10, 1, BodyDef.BodyType.StaticBody, "C:\\Users\\Max4u_000\\Documents\\Projekt\\source code\\AfterLife\\material folder\\graphics_material\\image1.png"));
        this.player = new Player(world, 10, 18, 1, 1, BodyDef.BodyType.DynamicBody, "C:\\Users\\Max4u_000\\Documents\\Projekt\\source code\\AfterLife\\material folder\\graphics_material\\player_passive.png");
        this.background = new Background(new Texture("C:\\Users\\Max4u_000\\Documents\\Projekt\\source code\\AfterLife\\material folder\\graphics_material\\background_teal.png"));
    }

    public void sendProjectileToDeletion(Body body){
        GameObject gameObject = searchAndFindGameObject(body);
        gameObjectsToDestroyList.add(gameObject);
    }

    public GameObject searchAndFindGameObject(Body body){
        for(int i=0; i<projectiles.size(); i++){
            if(projectiles.get(i).getBody()==body){
                return projectiles.get(i);
            }
        }
        return null;
    }

    public void disposeTexture(GameObject gameObject){
        gameObject.getTexture().dispose();
    }

    public void destroyBody(GameObject gameObject){
        world.destroyBody(gameObject.getBody());
    }


    public World getWorld() {
        return world;
    }
    public ArrayList<GameObject> getPlatforms() {
        return platforms;
    }
    public Player getPlayer() {
        return player;
    }
    public Background getBackground() {
        return background;
    }
    public ArrayList<GameObject> getProjectiles() {
        return projectiles;
    }
    public ArrayList<GameObject> getGameObjectsToDestroyList() {
        return gameObjectsToDestroyList;
    }

}
