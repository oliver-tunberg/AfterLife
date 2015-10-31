package model;
import com.badlogic.gdx.physics.box2d.Body;

public class PlayerMovement {

    private boolean moveRight;
    private boolean moveLeft;
    private boolean jumpRequested;
    private boolean playerInAir;

    public void setPlayerInAir(boolean playerInAir) {
        this.playerInAir = playerInAir;
    }

    public void controlPlayerMovement(GameManager gameManager){
        Body body =  gameManager.getLevelManager().getPlayer().getBody();
        if(moveRight){
            body.setLinearVelocity(10, body.getLinearVelocity().y);
        } else {
            if (0 < body.getLinearVelocity().x){
                body.setLinearVelocity(0, body.getLinearVelocity().y);
            }
        }
        if (moveLeft){
            body.setLinearVelocity(-10, body.getLinearVelocity().y);
        } else {
            if (body.getLinearVelocity().x < 0){
                body.setLinearVelocity(0, body.getLinearVelocity().y);
            }
        }
        if (jumpRequested && !playerInAir) {
            body.applyForceToCenter(body.getLinearVelocity().x, 2000, true);
            jumpRequested = false;
            playerInAir = true;
        }
    }

    public boolean isMoveRight() {
        return moveRight;
    }
    public void setMoveRight(boolean moveRight) {
        this.moveRight = moveRight;
    }
    public boolean isMoveLeft() {
        return moveLeft;
    }
    public void setMoveLeft(boolean moveLeft) {
        this.moveLeft = moveLeft;
    }
    public boolean hasJumpBeenRequested() {
        return jumpRequested;
    }
    public boolean isPlayerInAir() {
        return playerInAir;
    }

    public void requestJump(boolean b) {
        if(!playerInAir) {
            this.jumpRequested = b;
        }
    }

}
