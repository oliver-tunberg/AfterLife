package model;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;

public class MapCreator {

    public static Player playerCreator(World wold, float x, float y, float width, float height){
        return new Player(wold, x, y, width, height);
    }

    public static GameObject platformCreator(World wold, float x, float y, float width, float height){
        return new GameObject(wold, x, y, width, height, BodyDef.BodyType.StaticBody, PathVariables.platform0, PathVariables.platform0);
    }

    public static Enemy enemyCreator(World wold, float x, float y, float width, float height, UnitBehaviour unitBehaviour){
        return new Enemy(wold, x, y, width, height, BodyDef.BodyType.DynamicBody, unitBehaviour);
    }



}
