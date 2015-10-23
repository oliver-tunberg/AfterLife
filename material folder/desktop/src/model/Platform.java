package model;
import static model.Box2DVariables.*;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import java.awt.*;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.sun.xml.internal.ws.client.sei.ResponseBuilder;

public class Platform {


    private BodyDef bodyDef;
    private Body body;
    private PolygonShape polygonShape;
    private FixtureDef fixtureDef;

    public Platform(World world, float x, float y, float width, float height, BodyDef.BodyType bodyType){

        this.bodyDef = new BodyDef();

        this.bodyDef.position.set(x / PPM, y / PPM);
        this.bodyDef.type = bodyType;

        this.body = world.createBody(bodyDef);

        this.polygonShape = new PolygonShape();
        this.polygonShape.setAsBox(width / PPM, height / PPM);

        this.fixtureDef = new FixtureDef();
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
