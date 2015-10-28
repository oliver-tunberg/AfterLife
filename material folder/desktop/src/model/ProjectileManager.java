package model;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;

import java.util.ArrayList;

public class ProjectileManager {

    public void fireProjectile(GameManager gameManager){
        World world = gameManager.getMapLevel().getWorld();
        Player player = gameManager.getMapLevel().getPlayer();
        float x = setProjectileDirection(gameManager, player);
        float y = player.getBody().getPosition().y;
        GameObject projectile = new GameObject(world, x, y, (float)0.1, (float)0.1, BodyDef.BodyType.DynamicBody, "C:\\Users\\Max4u_000\\Documents\\Projekt\\source code\\AfterLife\\material folder\\graphics_material\\projectile.png");
        setProjectileForce(gameManager, projectile);
        projectile.getBody().setUserData(GameObjectType.projectile);
        gameManager.getMapLevel().getProjectiles().add(projectile);
    }

    private float setProjectileDirection(GameManager gameManager, Player player){
        if(gameManager.getMapLevel().getPlayer().getFacingDirection()==FacingDirection.right){
            return player.getBody().getPosition().x + 2;
        } else {
            return player.getBody().getPosition().x - 2;
        }
    }

    private void setProjectileForce(GameManager gameManager, GameObject projectile){
        if(gameManager.getMapLevel().getPlayer().getFacingDirection()==FacingDirection.right){
            projectile.getBody().applyForceToCenter(5000, 600, true);
        } else {
            projectile.getBody().applyForceToCenter(-5000, 600, true);
        }
    }

    public void destroyProjectiles(MapLevel mapLevel){
        ArrayList<GameObject> listA = mapLevel.getGameObjectsToDestroyList();
        ArrayList<GameObject> listB = mapLevel.getProjectiles();
        if( 0 < listA.size() ) {
            for (int i = 0; i < listA.size(); i++) {
                mapLevel.disposeTexture(listA.get(i));
                mapLevel.destroyBody(listA.get(i));
                listB.remove(listA.get(i));
                listA.remove(i);
            }
        }
    }

    public void destroyLostProjectiles(MapLevel mapLevel){
        ArrayList<GameObject> projectiles = mapLevel.getProjectiles();
        if(0<projectiles.size()){
            for(int i=0; i<projectiles.size(); i++){
                if(projectiles.get(i).getBody().getPosition().y < (-10)){
                    mapLevel.sendProjectileToDeletion(projectiles.get(i).getBody());
                }
            }
        }
    }





}
