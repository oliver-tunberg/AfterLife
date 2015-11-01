package model;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;

import java.util.ArrayList;

public class LevelManager {

    private GameManager gameManager;
    private World world;
    private MapLevelArchive mapLevelArchive;
    private int levelSelected;
    private ArrayList<GameObject> projectiles;
    private ArrayList<GameObject> gameObjectsToDestroyList;
    private Background background;

    public LevelManager(GameManager gameManager){
        this.gameManager = gameManager;
        this.world = new World(new Vector2(0, (-100f)), true);
        this.levelSelected = 0;
        this.mapLevelArchive = new MapLevelArchive(this.world);
        this.gameObjectsToDestroyList = new ArrayList<>();
        this.projectiles = new ArrayList<>();
        this.background = new Background(new Texture(PathVariables.background0));
    }

    public void setContactListener(){
        world.setContactListener(new MyContactListener(gameManager));
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
        Sprite[] sprites = gameObject.getSpriteArray();
        sprites[0].getTexture().dispose();
        sprites[1].getTexture().dispose();

    }


    public void destroyBody(GameObject gameObject){
        world.destroyBody(gameObject.getBody());

    }

    public World getWorld() {
        return world;

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

    public ArrayList<GameObject> getPlatforms(){
        return mapLevelArchive.getListOfLevels().get(levelSelected).getPlatforms();

    }

    public ArrayList<Enemy> getEnemies(){
        return mapLevelArchive.getListOfLevels().get(levelSelected).getEnemies();
    }

    public Player getPlayer(){
        return mapLevelArchive.getListOfLevels().get(levelSelected).getPlayer();

    }

}
