package model;
import com.badlogic.gdx.physics.box2d.*;

public class MyContactListener implements ContactListener {

    /**
     * Called when two fixtures start to collide.
     *
     * @param contact
     */
    @Override
    public void beginContact(Contact contact) {

        Fixture fixtureA = contact.getFixtureA();
        Fixture fixtureB = contact.getFixtureB();

    }

    /**
     * Called when two fixtures stops collide.
     *
     * @param contact
     */
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
