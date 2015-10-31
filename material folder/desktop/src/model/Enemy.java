package model;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;

public class Enemy extends Unit {

    private AI ai;

    public Enemy(World world, float x, float y, float width, float height, BodyDef.BodyType bodyType, UnitBehaviour unitBehaviour) {
        super(world, x, y, width, height, bodyType, PathVariables.enemy_moving0, PathVariables.enemy_moving1);
        this.ai = new AI(unitBehaviour);
    }

    public void exerciseBehaviour(Body playerBody){
        ai.exerciseBehaviour(playerBody, getBody());
    }

    public AI getAi() {
        return ai;

    }

    public void setAi(AI ai) {
        this.ai = ai;

    }
}
