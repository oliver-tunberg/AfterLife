package model;
import com.badlogic.gdx.physics.box2d.World;
import java.util.ArrayList;

public class MapLevel {

    private String name;
    private ArrayList<GameObject> platforms;
    private ArrayList<Enemy> enemies;
    private Player player;

    public MapLevel(String name){
        this.name = name;
        this.platforms = new ArrayList<>();
        this.enemies = new ArrayList<>();
    }

    public void buildLevel(World wold, float x, float y, float width, float height){
        platforms.add(MapCreator.platformCreator(wold, x, y, width, height));
    }

    public void insertPlayer(World world, float x, float y, float width, float height){
        player = new Player(world, x, y, width, height);
    }

    public void insertEnemy(World world, float x, float y, float width, float height, UnitBehaviour unitBehaviour){
        enemies.add(MapCreator.enemyCreator(world, x, y, width, height, unitBehaviour));
    }

    public ArrayList<GameObject> getPlatforms() {
        return platforms;
    }
    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }
    public Player getPlayer() {
        return player;
    }

}
