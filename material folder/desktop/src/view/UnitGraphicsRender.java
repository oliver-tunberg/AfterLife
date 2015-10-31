package view;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;
import model.*;

import java.util.ArrayList;

public class UnitGraphicsRender {

    public void renderUnitGraphics(LevelManager levelManager, SpriteBatch spriteBatch){
        renderPlayer(levelManager, spriteBatch);
        renderEnemies(levelManager, spriteBatch);
    }

    private void renderPlayer(LevelManager levelManager, SpriteBatch spriteBatch){
        Unit player = levelManager.getPlayer();
        Sprite[] sprites = player.getSpriteArray();
        Body body = player.getBody();
        investigateBodyMovement(spriteBatch, sprites, player, body);
        HealthBarRender.renderHealthBar(player, spriteBatch);
    }

    private void renderEnemies(LevelManager levelManager, SpriteBatch spriteBatch){
        ArrayList<Enemy> listOfEnemies = levelManager.getEnemies();
        for(int i=0; i<listOfEnemies.size(); i++){
            Unit unit = listOfEnemies.get(i);
            Sprite[] sprites = unit.getSpriteArray();
            Body body = unit.getBody();
            investigateBodyMovement(spriteBatch, sprites, unit, body);
            HealthBarRender.renderHealthBar(unit, spriteBatch);
        }
    }

    private void investigateBodyMovement(SpriteBatch spriteBatch, Sprite[] sprites, Unit unit, Body body){
        if(UnitMechanics.isUnitMoving(body)) {
            unitMoving(spriteBatch, sprites, unit, body);
        } else {
            unitStandingStill(spriteBatch, sprites, unit, body);
        }
    }

    private void unitStandingStill(SpriteBatch spriteBatch, Sprite[] sprites, Unit unit, Body body){
        setSpriteSize(sprites, 0);
        setSpritePosition(body, sprites, 0);
        updateFacingDirection_StandingStill(unit, sprites, 0);
        drawSpriteIntoSpriteBatch(spriteBatch, sprites, 0);
    }

    private void unitMoving(SpriteBatch spriteBatch, Sprite[] sprites, Unit unit, Body body){
        setTimeA(unit);
        setTimeB(unit);
        calculateDifference(unit);
        manageArrayIndex(unit);
        setSpriteSize(sprites, unit.getGraphicsRenderArrayPointer());
        setSpritePosition(body, sprites, unit.getGraphicsRenderArrayPointer());
        updateFacingDirection_Moving(unit, sprites);
        drawSpriteIntoSpriteBatch(spriteBatch, sprites, unit.getGraphicsRenderArrayPointer());
    }

    private void setTimeA(Unit unit){
        if(unit.getGraphicsRenderTimeA()==0) {
            unit.setGraphicsRenderTimeA(System.nanoTime());
        }
    }

    private void setTimeB(Unit unit){
        unit.setGraphicsRenderTimeB(System.nanoTime());
    }

    private void calculateDifference(Unit unit){
        unit.setGraphicsRenderDeltaTime( (unit.getGraphicsRenderTimeB() - unit.getGraphicsRenderTimeA())/1000000000.0 );
    }

    private void manageArrayIndex(Unit unit){
        if(0.08 <= unit.getGraphicsRenderDeltaTime()){
            unit.setGraphicsRenderDeltaTime(0.0);
            unit.setGraphicsRenderTimeA(0.0);
            unit.setGraphicsRenderArrayPointer((unit.getGraphicsRenderArrayPointer() + 1) % 2);
        }
    }

    private void setSpriteSize(Sprite[] sprites, int index){
        sprites[index].setSize(2, 2);
    }

    private void setSpritePosition(Body body, Sprite[] sprites, int index){
        sprites[index].setPosition(body.getPosition().x - 1, body.getPosition().y - 1);
    }

    private void drawSpriteIntoSpriteBatch(SpriteBatch spriteBatch, Sprite[] sprites, int index){
        sprites[index].draw(spriteBatch);
    }

    private void updateFacingDirection_StandingStill(Unit unit, Sprite[] sprites, int index){
        if(unit.getFacingDirection()!=unit.getLastFacingDirection()){
            sprites[index].flip(true, false);
            unit.setLastFacingDirection(unit.getFacingDirection());
        }
    }

    private void updateFacingDirection_Moving(Unit unit, Sprite[] sprites){
        if(unit.getFacingDirection()!=unit.getLastFacingDirection()){
            sprites[0].flip(true, false);
            sprites[1].flip(true, false);
            unit.setLastFacingDirection(unit.getFacingDirection());
        }
    }








}
