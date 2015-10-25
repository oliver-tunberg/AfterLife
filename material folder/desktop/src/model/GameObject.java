package model;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.physics.box2d.BodyDef;


public class GameObject {

    private BodyDef bodyDef;
    private Body body;
    private PolygonShape polygonShape;
    private FixtureDef fixtureDef;

    public GameObject(World world, float x, float y, float width, float height, BodyDef.BodyType bodyType){

        this.bodyDef = new BodyDef();

        this.bodyDef.position.set(x, y);
        this.bodyDef.type = bodyType;

        this.body = world.createBody(bodyDef);

        this.polygonShape = new PolygonShape();
        this.polygonShape.setAsBox(width, height);

        this.fixtureDef = new FixtureDef();
        this.fixtureDef.friction = 0;
        this.fixtureDef.shape = polygonShape;

        this.body.createFixture(fixtureDef);


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


}
