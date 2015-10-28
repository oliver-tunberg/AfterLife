package model;
import com.badlogic.gdx.physics.box2d.Body;

public class PlayerMovement {

    private boolean moveRight;
    private boolean moveLeft;
    private boolean jump;

    public void coordinatePlayerMovement(GameManager gameManager){
        Body body =  gameManager.getMapLevel().getPlayer().getBody();
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
        if (jump) {
            body.applyForceToCenter(body.getLinearVelocity().x, 2000, true);
            jump = false;
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
    public boolean isJump() {
        return jump;
    }
    public void setJump(boolean jump) {
        this.jump = jump;
    }

}
