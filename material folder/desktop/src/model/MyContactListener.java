package model;
import com.badlogic.gdx.physics.box2d.*;

public class MyContactListener implements ContactListener {

    private MapLevel mapLevel;

    public MyContactListener(MapLevel mapLevel){
        this.mapLevel = mapLevel;
    }

    @Override
    public void beginContact(Contact contact) {

        Body body = contact.getFixtureB().getBody();
        if(body.getUserData()==GameObjectType.projectile){
            mapLevel.sendProjectileToDeletion(body);
        }

    }


    @Override
    public void endContact(Contact contact) {

    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {

    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {

    }
}
