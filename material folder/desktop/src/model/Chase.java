package model;
import com.badlogic.gdx.physics.box2d.Body;

public class Chase extends UnitBehaviour {

    @Override
    public void exerciseBehaviour(Body playerBody, Body enemyBody) {

        float p_x = playerBody.getPosition().x;
        float p_y = playerBody.getPosition().y;
        float e_x = enemyBody.getPosition().x;
        float e_y = enemyBody.getPosition().y;

        if( p_x < e_x ){
            enemyBody.setLinearVelocity(-2, enemyBody.getLinearVelocity().y);
        } else {
            enemyBody.setLinearVelocity(2, enemyBody.getLinearVelocity().y);
        }

    }


}
