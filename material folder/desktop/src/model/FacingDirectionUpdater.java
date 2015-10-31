package model;


public class FacingDirectionUpdater {

    public void correctFacingDirection(Unit unit){
        if(0 < unit.getBody().getLinearVelocity().x){
            unit.setFacingDirection(FacingDirection.right);
        } else if(unit.getBody().getLinearVelocity().x < 0) {
            unit.setFacingDirection(FacingDirection.left);
        }
    }

}
