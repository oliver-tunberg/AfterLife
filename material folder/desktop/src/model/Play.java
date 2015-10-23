package model;
import static model.Box2DVariables.*;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import controller.MyInput;

import java.awt.*;

public class Play extends GameState {

    private World world;
    private Box2DDebugRenderer b2rd;
    private Platform platform;
    private Platform box;

    public Play() {

        this.world = new World(new Vector2(0, (-10f)), true);
        this.world.setContactListener(new MyContactListener());
        this.b2rd = new Box2DDebugRenderer();
        this.platform = new Platform(this.world, 650, 300, 100, 10, BodyDef.BodyType.StaticBody);
        this.box = new Platform(this.world, 650, 500, 10, 10, BodyDef.BodyType.DynamicBody);
        this.getCamera().setToOrtho(false, (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth() / PPM, (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight() / PPM);

    }

    @Override
    public void update(float dt) {
        handleInput();
        world.step(dt, 6, 2);
    }

    @Override
    public void handleInput() {
        if(MyInput.isDown(0)){
            this.box.getBody().setLinearVelocity(-1, 0);
        } else if(MyInput.isDown(1)){
            this.box.getBody().setLinearVelocity(1, 0);
        }
    }

    @Override
    public void render() {
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
        b2rd.render(world, getCamera().combined);
    }

    @Override
    public void dispose() {

    }
}
