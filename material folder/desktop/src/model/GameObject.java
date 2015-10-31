package model;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.sun.org.apache.bcel.internal.generic.ObjectType;


public class GameObject {

    private BodyDef bodyDef;
    private Body body;
    private PolygonShape polygonShape;
    private FixtureDef fixtureDef;

    private Sprite[] spriteArray;
    private FacingDirection facingDirection;

    public GameObject(World world, float x, float y, float width, float height, BodyDef.BodyType bodyType, String texturePathA, String texturePathB){

        this.bodyDef = new BodyDef();

        this.bodyDef.position.set(x, y);
        this.bodyDef.type = bodyType;

        this.body = world.createBody(bodyDef);

        this.polygonShape = new PolygonShape();
        this.polygonShape.setAsBox(width, height);

        this.fixtureDef = new FixtureDef();
        this.fixtureDef.friction = 0;
        this.fixtureDef.shape = polygonShape;
        this.fixtureDef.filter.maskBits = 2;
        this.fixtureDef.filter.categoryBits = 2;

        this.body.createFixture(fixtureDef);

        this.facingDirection = FacingDirection.right;
        this.spriteArray = new Sprite[2];
        this.setBodyUserData(GameObjectType.player);
        Texture texture0 = new Texture(texturePathA);
        Texture texture1= new Texture(texturePathB);
        spriteArray[0] = new Sprite(texture0);
        spriteArray[1] = new Sprite(texture1);

    }

    public void setBodyUserData(GameObjectType type){
        this.getBody().setUserData(type);
    }
    public BodyDef getBodyDef() {
        return bodyDef;
    }
    public void setBodyDef(BodyDef bodyDef) {
        this.bodyDef = bodyDef;
    }
    public Body getBody() {
        return body;
    }
    public void setBody(Body body) {
        this.body = body;
    }
    public PolygonShape getPolygonShape() {
        return polygonShape;
    }
    public void setPolygonShape(PolygonShape polygonShape) {
        this.polygonShape = polygonShape;
    }
    public FixtureDef getFixtureDef() {
        return fixtureDef;
    }
    public void setFixtureDef(FixtureDef fixtureDef) {
        this.fixtureDef = fixtureDef;
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
