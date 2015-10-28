package view;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;
import model.FacingDirection;
import model.MapLevel;
import model.Player;
import model.UnitMechanics;


public class PlayerGraphicsRender {

    private double timeA;
    private double timeB;
    private double delta;
    private int arrayPointer;
    private FacingDirection lastFacingDirection;

    public PlayerGraphicsRender(){
        this.lastFacingDirection = FacingDirection.right;
    }

    public void renderPlayerGraphics(MapLevel mapLevel, SpriteBatch spriteBatch){

        Player player = mapLevel.getPlayer();
        Body body = mapLevel.getPlayer().getBody();
        Sprite[] sprites = player.getSpriteArray();

        if(UnitMechanics.isUnitMoving(body)) {
            playerMoving(player, body, spriteBatch, sprites);
        } else {
            playerStandingStill(player, body, spriteBatch, sprites);
        }
    }

    private void playerStandingStill(Player player, Body body, SpriteBatch spriteBatch, Sprite[] sprites){
        setSpriteSize(sprites, 0);
        setSpritePosition(body, sprites, 0);
        updateFacingDirection_StandingStill(player, sprites, 0);
        drawSpriteIntoSpriteBatch(spriteBatch, sprites, 0);
    }

    private void playerMoving(Player player, Body body, SpriteBatch spriteBatch, Sprite[] sprites){
        setTimeA();
        setTimeB();
        calculateDifference();
        manageArrayIndex();
        setSpriteSize(sprites, arrayPointer);
        setSpritePosition(body, sprites, arrayPointer);
        updateFacingDirection_Moving(player, sprites);
        drawSpriteIntoSpriteBatch(spriteBatch, sprites, arrayPointer);
    }

    private void setTimeA(){
        if(timeA==0) {
            timeA = System.nanoTime();
        }
    }

    private void setTimeB(){
        timeB = System.nanoTime();
    }

    private void calculateDifference(){
        delta = (timeB - timeA)/1000000000.0;
    }

    private void manageArrayIndex(){
        if(0.08 <= delta){
            delta = 0;
            timeA = 0;
            arrayPointer = (arrayPointer + 1) % 2;
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

    private void updateFacingDirection_StandingStill(Player player, Sprite[] sprites, int index){
        if(player.getFacingDirection()!=lastFacingDirection){
            sprites[index].flip(true, false);
            lastFacingDirection = player.getFacingDirection();
        }
    }

    private void updateFacingDirection_Moving(Player player, Sprite[] sprites){
        if(player.getFacingDirection()!=lastFacingDirection){
            sprites[0].flip(true, false);
            sprites[1].flip(true, false);
            lastFacingDirection = player.getFacingDirection();
        }
    }








}
