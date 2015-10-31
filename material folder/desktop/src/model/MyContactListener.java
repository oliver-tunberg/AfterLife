package model;
import com.badlogic.gdx.physics.box2d.*;

public class MyContactListener implements ContactListener {

    private GameManager gameManager;
    private LevelManager levelManager;
    private ContactManager contactManager;

    public MyContactListener(GameManager gameManager){
        this.gameManager = gameManager;
        this.levelManager = gameManager.getLevelManager();
        this.contactManager = new ContactManager();
    }

    @Override
    public void beginContact(Contact contact) {

        Body bodyA = contact.getFixtureA().getBody();
        Body bodyB = contact.getFixtureB().getBody();


        if(bodyB.getUserData()==GameObjectType.projectile){
            //contactManager.manageProjectileOnEnemy(levelManager, bodyB, bodyA);
        }

        if(bodyB.getUserData()==GameObjectType.projectile){
            levelManager.sendProjectileToDeletion(bodyB);
        }

        if(bodyB.getUserData()==GameObjectType.player){
            gameManager.getPlayerMovement().setPlayerInAir(false);
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
