package model;

public class Play {

    private Map map;
    private boolean moveRight;
    private boolean moveLeft;
    private boolean jump;

    public Play() {
        this.map = new Map();
    }

    public void update(float dt) {
        playerMovement();
        map.getWorld().step(dt, 6, 2);
    }


    private void playerMovement(){
        if(moveRight){
           map.getPlayer().getBody().setLinearVelocity(10, map.getPlayer().getBody().getLinearVelocity().y);
        } else {
            if(0 < map.getPlayer().getBody().getLinearVelocity().x){
                map.getPlayer().getBody().setLinearVelocity(0, map.getPlayer().getBody().getLinearVelocity().y);
            }
        }
        if(moveLeft){
            map.getPlayer().getBody().setLinearVelocity(-10, map.getPlayer().getBody().getLinearVelocity().y);
        } else {
            if(map.getPlayer().getBody().getLinearVelocity().x < 0){
                map.getPlayer().getBody().setLinearVelocity(0, map.getPlayer().getBody().getLinearVelocity().y);
            }
        }
        if(jump){
            map.getPlayer().getBody().applyForceToCenter(map.getPlayer().getBody().getLinearVelocity().x, 2000, true);
            jump = false;
        }
    }

    public Map getMap() {
        return map;
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
