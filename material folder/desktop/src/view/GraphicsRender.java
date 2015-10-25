package view;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import model.Play;



public class GraphicsRender {

    private Play play;
    private Box2DDebugRenderer b2rd;
    private OrthographicCamera camera;
    private OrthogonalTiledMapRenderer tmr;

    public GraphicsRender(Play play){
        this.play = play;
        this.b2rd = new Box2DDebugRenderer();
        this.camera = new OrthographicCamera();
        this.camera.setToOrtho(false, 20, 20);
        this.camera.update();

    }

    public void renderGraphics(){
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
        b2rd.render(play.getMap().getWorld(), this.camera.combined);
    }

}
