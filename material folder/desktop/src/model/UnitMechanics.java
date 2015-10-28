package model;
import com.badlogic.gdx.physics.box2d.Body;

public class UnitMechanics {

    public static boolean isUnitMoving(Body body){
            return !(body.getLinearVelocity().x == 0);
    }



}
