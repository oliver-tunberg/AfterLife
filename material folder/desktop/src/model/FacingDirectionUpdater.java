package model;


public class FacingDirectionUpdater {

    public void correctFacingDirection(Player player){
        if(0 < player.getBody().getLinearVelocity().x){
            player.setFacingDirection(FacingDirection.right);
        } else if(player.getBody().getLinearVelocity().x < 0) {
            player.setFacingDirection(FacingDirection.left);
        }
    }

}
