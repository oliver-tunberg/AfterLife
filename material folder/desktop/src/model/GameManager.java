package model;

public class GameManager {

    private MapLevel maplevel;
    private PlayerMovement playerMovement;
    private FacingDirectionUpdater facingDirectionUpdater;
    private ProjectileManager projectileManager;

    public GameManager() {
        this.maplevel = new MapLevel();
        this.playerMovement = new PlayerMovement();
        this.facingDirectionUpdater = new FacingDirectionUpdater();
        this.projectileManager = new ProjectileManager();
    }

    public void update(float dt) {
        maplevel.getWorld().step(dt, 6, 2);
        playerMovement.coordinatePlayerMovement(this);
        facingDirectionUpdater.correctFacingDirection(maplevel.getPlayer());
        projectileManager.destroyProjectiles(maplevel);
        projectileManager.destroyLostProjectiles(maplevel);
        System.out.println(maplevel.getWorld().getBodyCount());
    }


    public ProjectileManager getProjectileManager() {
        return projectileManager;
    }

    public MapLevel getMapLevel() {
        return maplevel;
    }
    public PlayerMovement getPlayerMovement() {
        return playerMovement;
    }

}
