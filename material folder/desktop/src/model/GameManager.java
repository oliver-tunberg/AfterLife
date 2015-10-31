package model;
import java.util.ArrayList;

public class GameManager {

    private LevelManager levelManager;
    private PlayerMovement playerMovement;
    private FacingDirectionUpdater facingDirectionUpdater;
    private ProjectileManager projectileManager;
    private boolean initializingComplete = false;

    public GameManager() {
        this.levelManager = new LevelManager(this);
        this.playerMovement = new PlayerMovement();
        this.facingDirectionUpdater = new FacingDirectionUpdater();
        this.projectileManager = new ProjectileManager();
    }

    private void finishLateInitialization(){
        if(!initializingComplete) {
            levelManager.setContactListener();
            initializingComplete = true;
        }
    }

    public void update(float dt) {

        finishLateInitialization();

        levelManager.getWorld().step(dt, 6, 2);
        playerMovement.controlPlayerMovement(this);
        manageUnits();
        projectileManager.destroyProjectiles(levelManager);
        projectileManager.destroyLostProjectiles(levelManager);
    }

    private void manageUnits(){

        ArrayList<Enemy> listOfEnemies = levelManager.getEnemies();
        Unit player = levelManager.getPlayer();

        facingDirectionUpdater.correctFacingDirection(player);

        for(int i=0; i < listOfEnemies.size(); i++){
            Enemy enemy = listOfEnemies.get(i);
            enemy.exerciseBehaviour(levelManager.getPlayer().getBody());
            facingDirectionUpdater.correctFacingDirection(enemy);
        }

    }


    public ProjectileManager getProjectileManager() {
        return projectileManager;
    }
    public LevelManager getLevelManager() {
        return levelManager;
    }
    public PlayerMovement getPlayerMovement() {
        return playerMovement;
    }

}
