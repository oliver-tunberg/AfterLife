package model;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;

import java.util.ArrayList;

public class ProjectileManager {

    /**
     *
     * Fire Projectile
     *
     */

    public void fireProjectile(GameManager gameManager){

        World world = gameManager.getLevelManager().getWorld();
        Player player = gameManager.getLevelManager().getPlayer();

        float x = setProjectileCoordinate_x(gameManager, player);
        float y = setProjectileCoordinate_y(player);

        GameObject projectile = new GameObject(world, x, y, (float)0.1, (float)0.1, BodyDef.BodyType.DynamicBody, PathVariables.projectile, PathVariables.projectile);

        setProjectileForce(gameManager, projectile);
        setProjectileBodyUserData(projectile);
        addProjectileIntoGame(gameManager, projectile);
    }

    private float setProjectileCoordinate_x(GameManager gameManager, Player player){
        if(gameManager.getLevelManager().getPlayer().getFacingDirection()==FacingDirection.right){
            return player.getBody().getPosition().x + 2;
        } else {
            return player.getBody().getPosition().x - 2;
        }
    }

    private float setProjectileCoordinate_y(Player player){
        return player.getBody().getPosition().y;
    }

    private void setProjectileForce(GameManager gameManager, GameObject projectile){
        if(gameManager.getLevelManager().getPlayer().getFacingDirection()==FacingDirection.right){
            projectile.getBody().applyForceToCenter(5000, 600, true);
        } else {
            projectile.getBody().applyForceToCenter(-5000, 600, true);
        }
    }

    private void setProjectileBodyUserData(GameObject projectile){
        projectile.getBody().setUserData(GameObjectType.projectile);
    }

    private void addProjectileIntoGame(GameManager gameManager, GameObject projectile){
        gameManager.getLevelManager().getProjectiles().add(projectile);
    }

    /**
     *
     * Destroy Projectile
     *
     */

    public void destroyProjectiles(LevelManager levelManager){

        ArrayList<GameObject> listOfObjectsToDestroy = levelManager.getGameObjectsToDestroyList();
        ArrayList<GameObject> listOfProjectiles = levelManager.getProjectiles();

        if( !listOfObjectsToDestroyIsEmpty(listOfObjectsToDestroy) ) {
            handleDisposing(levelManager, listOfObjectsToDestroy, listOfProjectiles);
        }
    }

    private boolean listOfObjectsToDestroyIsEmpty(ArrayList<GameObject> listOfObjectsToDestroy){
        return listOfObjectsToDestroy.size() == 0;
    }

    private void handleDisposing(LevelManager levelManager, ArrayList<GameObject> listOfObjectsToDestroy, ArrayList<GameObject> listOfProjectiles){
        for (int i = 0; i < listOfObjectsToDestroy.size(); i++) {
            levelManager.disposeTexture(listOfObjectsToDestroy.get(i));
            levelManager.destroyBody(listOfObjectsToDestroy.get(i));
            listOfProjectiles.remove(listOfObjectsToDestroy.get(i));
            listOfObjectsToDestroy.remove(i);
        }
    }

    /**
     *
     * Destroy Lost Projectile
     *
     */

    public void destroyLostProjectiles(LevelManager levelManager){
        ArrayList<GameObject> projectiles = levelManager.getProjectiles();
        if(!listOfProjectilesIsEmpty(projectiles)){
            for(int i=0; i<projectiles.size(); i++){
                investigateProjectilePositionLimit(levelManager, projectiles.get(i).getBody());
            }
        }
    }

    private void investigateProjectilePositionLimit(LevelManager levelManager, Body body){
        if(body.getPosition().y < (-10)){
            sendProjectileToDeletion(levelManager, body);
        }
    }

    private void sendProjectileToDeletion(LevelManager levelManager, Body body){
        levelManager.sendProjectileToDeletion(body);
    }

    private boolean listOfProjectilesIsEmpty(ArrayList<GameObject> projectiles){
        return 0 == projectiles.size();
    }






}
