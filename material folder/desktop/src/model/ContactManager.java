package model;


import com.badlogic.gdx.physics.box2d.Body;

public class ContactManager {

    public void manageProjectileOnEnemy(LevelManager levelManager, Body projectile, Body enemy){
        Unit unit = (Unit)levelManager.searchAndFindGameObject(enemy);
        //CombatCentral.dealDamage(unit, );
    }


}
