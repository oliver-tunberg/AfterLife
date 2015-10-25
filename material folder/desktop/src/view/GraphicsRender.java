package view;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import model.Play;
import model.Player;


public class GraphicsRender {

    private Play play;
    private Box2DDebugRenderer b2rd;
    private OrthographicCamera camera;
    private OrthogonalTiledMapRenderer tmr;


    private Player player;
    private SpriteBatch sb;


    public GraphicsRender(Play play){

        this.play = play;
        this.b2rd = new Box2DDebugRenderer();
        this.camera = new OrthographicCamera();
        this.camera.setToOrtho(false, 33, 20);
        this.camera.zoom = (float)4;
        this.camera.update();


        this.player = new Player();
        this.sb = new SpriteBatch();


    }

    public void renderGraphics(){
        camera.update();
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
        b2rd.render(play.getMap().getWorld(), camera.combined);


        sb.setProjectionMatrix(this.camera.combined);
        sb.begin();
        sb.draw(player.getTexture(), (10) - 1 , (10) - 1, 6, 6);
        sb.end();


    }


    private void coordinateCamera(){



        if(0 < play.getMap().getPlayer().getBody().getLinearVelocity().x){
            camera.translate((float)0.167, 0);
        } else if(play.getMap().getPlayer().getBody().getLinearVelocity().x < 0) {
            camera.translate((float)(-0.167), 0);
        }

    }

}
