package model;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;

public class Player extends GameObject {

    private Sprite[] spriteArray;
    private FacingDirection facingDirection;

    public Player(World world, float x, float y, float width, float height, BodyDef.BodyType bodyType, String texturePath) {
        super(world, x, y, width, height, bodyType, texturePath);
        this.facingDirection = FacingDirection.right;
        this.spriteArray = new Sprite[2];
        loadSpriteArray();
    }

    private void loadSpriteArray(){
        Texture texture0 = new Texture("C:\\Users\\Max4u_000\\Documents\\Projekt\\source code\\AfterLife\\material folder\\graphics_material\\player_moving0.png");
        Texture texture1= new Texture("C:\\Users\\Max4u_000\\Documents\\Projekt\\source code\\AfterLife\\material folder\\graphics_material\\player_moving1.png");
        spriteArray[0] = new Sprite(texture0);
        spriteArray[1] = new Sprite(texture1);
    }

    public Sprite[] getSpriteArray() {
        return spriteArray;
    }

    public FacingDirection getFacingDirection() {
        return facingDirection;
    }

    public void setFacingDirection(FacingDirection facingDirection) {
        this.facingDirection = facingDirection;
    }
}
