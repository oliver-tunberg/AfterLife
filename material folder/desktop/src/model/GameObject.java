package model;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.physics.box2d.BodyDef;


public class GameObject {

    private BodyDef bodyDef;
    private Body body;
    private PolygonShape polygonShape;
    private FixtureDef fixtureDef;
    private Texture texture;
    private Sprite sprite;

    public GameObject(World world, float x, float y, float width, float height, BodyDef.BodyType bodyType, String texturePath){

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

        this.texture = new Texture(texturePath);
        this.sprite = new Sprite(this.texture);


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
    public Texture getTexture() {
        return texture;
    }
    public void setTexture(Texture texture) {
        this.texture = texture;
    }
    public Sprite getSprite() {
        return sprite;
    }
    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }

}
