package model;
import com.badlogic.gdx.physics.box2d.Body;

public abstract class UnitBehaviour {

    public abstract void exerciseBehaviour(Body enemyBody, Body playerBody);

}
