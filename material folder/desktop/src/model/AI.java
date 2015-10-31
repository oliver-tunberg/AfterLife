package model;
import com.badlogic.gdx.physics.box2d.Body;

public class AI {

    private UnitBehaviour unitBehaviour;

    public AI(UnitBehaviour unitBehaviour){
        this.unitBehaviour = unitBehaviour;
    }

    public void exerciseBehaviour(Body playerBody, Body enemyBody){
        unitBehaviour.exerciseBehaviour(playerBody, enemyBody);
    }





}
