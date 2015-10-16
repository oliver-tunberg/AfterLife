package states;
import static handlers.Box2DVariables.PPM;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.sun.xml.internal.ws.client.sei.ResponseBuilder;
import handlers.GameStateManager;

import java.awt.*;

public class Play extends GameState {

    private World world;
    private Box2DDebugRenderer b2rd;
    private OrthographicCamera gameCam;

    public Play(GameStateManager gsm) {
        super(gsm);
        this.world = new World(new Vector2(0, (-10f)), true);
        this.b2rd = new Box2DDebugRenderer();


        //define body (platform)
        BodyDef bodyDef = new BodyDef();
        bodyDef.position.set(500 / PPM, 500 / PPM);
        bodyDef.type = BodyDef.BodyType.StaticBody;

        //create body (platform)
        Body platform = world.createBody(bodyDef);

        //define fixture (platform)
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(50 / PPM, 50 / PPM);

        //create fixture (platform)
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;

        //put the fixture in the body (platform)
        platform.createFixture(fixtureDef);

        //define body (box)
        bodyDef.position.set(530 / PPM, 700 / PPM);
        bodyDef.type = BodyDef.BodyType.DynamicBody;

        //create body (box)
        Body box = world.createBody(bodyDef);

        //define fixture (box)
        shape.setAsBox(5 / PPM, 5 / PPM);

        //create fixture (box)
        fixtureDef.shape = shape;
        fixtureDef.restitution = 1f;

        //put the fixture in the body (box)
        box.createFixture(fixtureDef);

        //setting up the camera
        gameCam = new OrthographicCamera();
        gameCam.setToOrtho(false, (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth() / PPM, (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight() / PPM);


    }

    @Override
    public void handleInput() {

    }

    @Override
    public void update(float dt) {

        world.step(dt, 6, 2);

    }

    @Override
    public void render() {

        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);

        b2rd.render(world, gameCam.combined);

    }

    @Override
    public void dispose() {

    }
}