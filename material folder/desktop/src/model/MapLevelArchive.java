package model;
import com.badlogic.gdx.physics.box2d.World;
import java.util.ArrayList;

public class MapLevelArchive {

    private ArrayList<MapLevel> listOfLevels;
    private World world;

    public MapLevelArchive(World world){

        this.world = world;
        this.listOfLevels = new ArrayList<>();

        MapLevel mapLevel0 = new MapLevel("level0");
        mapLevel0.buildLevel(this.world, 10, 10, 10, 1);
        mapLevel0.buildLevel(this.world, 30, 10, 10, 1);
        mapLevel0.buildLevel(this.world, 20, 20, 10, 1);
        mapLevel0.insertPlayer(this.world, 10, 16, 1, 1);
        mapLevel0.insertEnemy(this.world, 12, 16, 1, 1, new Chase());
        listOfLevels.add(mapLevel0);

    }

    public ArrayList<MapLevel> getListOfLevels(){
        return listOfLevels;
    }

}
