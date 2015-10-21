package states;
import static handlers.Box2DVariables.*;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import handlers.GameStateManager;
import handlers.MyContactListener;
import handlers.MyInput;

import java.awt.*;

/**
 * This state handles the logistics of the game play.
 */
public class Play extends GameState {

    /**
     * "The world class manages all physics entities, dynamic simulation, and asynchronous queries.
     * The world also contains efficient memory management facilities."
     * source: https://libgdx.badlogicgames.com/nightlies/docs/api/com/badlogic/gdx/physics/box2d/World.html
     */
    private World world;

    /**
     * This instance is used to render the graphics.
     * When its used it will require a world and a camera object.
     */
    private Box2DDebugRenderer b2rd;

    /**
     * 
     */
    private OrthographicCamera gameCam;

    public Play(GameStateManager gsm) {
        super(gsm);
        this.world = new World(new Vector2(0, (-1f)), true);
        this.world.setContactListener(new MyContactListener());
        this.b2rd = new Box2DDebugRenderer();

        // ----------------------------------

        //define body (platform)
        BodyDef bodyDef = new BodyDef();
        bodyDef.position.set(650 / PPM, 300 / PPM);
        bodyDef.type = BodyDef.BodyType.StaticBody;

        //create body (platform)
        Body platform = world.createBody(bodyDef);

        //define fixture (platform)
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(150 / PPM, 10 / PPM);

        //create fixture (platform)
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.filter.categoryBits = BIT_GROUND;
        fixtureDef.filter.maskBits = BIT_BOX;
        fixtureDef.filter.maskBits = BIT_BALL;

        //put the fixture in the body (platform)
        Fixture fixPlatform = platform.createFixture(fixtureDef);
        fixPlatform.setUserData("platform");

        // ----------------------------------

        //define body (box)
        bodyDef.position.set(650 / PPM, 700 / PPM);
        bodyDef.type = BodyDef.BodyType.DynamicBody;

        //create body (box)
        Body box = world.createBody(bodyDef);

        //define fixture (box)
        shape.setAsBox(20 / PPM, 20 / PPM);

        //create fixture (box)
        fixtureDef.shape = shape;
        fixtureDef.filter.categoryBits = BIT_BALL;
        fixtureDef.filter.maskBits = BIT_GROUND;

        //put the fixture in the body (box)
        Fixture fixBox = box.createFixture(fixtureDef);
        fixBox.setUserData("box");

        // ----------------------------------

        //define body (ball)
        bodyDef.position.set(700 / PPM, 800 / PPM);
        bodyDef.type = BodyDef.BodyType.DynamicBody;

        //create body (ball)
        Body ball = world.createBody(bodyDef);

        //define fixture (ball)
        CircleShape circleShape = new CircleShape();
        circleShape.setRadius(50 / PPM);

        //create fixture (ball)
        fixtureDef.shape = circleShape;
        fixtureDef.filter.categoryBits = BIT_BALL;
        fixtureDef.filter.maskBits = BIT_GROUND;

        //put the fixture in the body (ball)
        Fixture fixBall = ball.createFixture(fixtureDef);
        fixBall.setUserData("ball");

        // ----------------------------------



        //setting up the camera
        gameCam = new OrthographicCamera();
        gameCam.setToOrtho(false, (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth() / PPM, (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight() / PPM);


    }

    @Override
    public void handleInput() {

        if(MyInput.isPressed(MyInput.BUTTON_0)){
            System.out.println("pressed z");
        } else if(MyInput.isDown(MyInput.BUTTON_1)){
            System.out.println("hold x");
        }

    }

    @Override
    public void update(float dt) {

        handleInput();

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
