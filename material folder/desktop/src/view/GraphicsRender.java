package view;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import model.GameManager;
import model.MapLevel;


public class GraphicsRender {

    private GameManager gameManager;
    private MapLevel mapLevel;
    private Box2DDebugRenderer b2rd;
    private OrthographicCamera camera;
    private SpriteBatch sb;
    private PlayerGraphicsRender playerGraphicsRender;

    public GraphicsRender(GameManager gameManager){
        this.gameManager = gameManager;
        this.mapLevel = gameManager.getMapLevel();
        //this.b2rd = new Box2DDebugRenderer();
        this.camera = new OrthographicCamera();
        this.camera.setToOrtho(false, 33, 20);
        this.camera.zoom = (float)1;
        this.camera.update();
        this.sb = new SpriteBatch();
        this.playerGraphicsRender = new PlayerGraphicsRender();
    }

    public void renderGraphics(){
        updateCamera();
        clearTheScreen();
        cameraToFollowPlayer();
        connectCameraAndSpriteBatch();
        startSpriteBatchDrawing();
        renderBackground(sb);
        playerGraphicsRender.renderPlayerGraphics(mapLevel, sb);
        PlatformsGraphicsRender.renderPlatformsGraphics(mapLevel, sb);
        ProjectileGraphicsRender.renderProjectileGraphics(mapLevel, sb);
        stopSpriteBatchDrawing();
    }

    private void updateCamera(){
        camera.update();
    }

    private void clearTheScreen(){
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    private void renderTestingGraphics(){
        b2rd.render(gameManager.getMapLevel().getWorld(), camera.combined);
    }

    private void cameraToFollowPlayer(){
        Body body = gameManager.getMapLevel().getPlayer().getBody();
        camera.position.set(body.getPosition().x, body.getPosition().y, 0);
    }

    private void connectCameraAndSpriteBatch(){
        sb.setProjectionMatrix(this.camera.combined);
    }

    private void startSpriteBatchDrawing(){
        sb.begin();
    }

    private void stopSpriteBatchDrawing(){
        sb.end();
    }

    private void renderBackground(SpriteBatch spriteBatch){
        Sprite sprite = mapLevel.getBackground().getSprite();
        sprite.setPosition((-10),(-10));
        sprite.setSize(500, 500);
        sprite.draw(spriteBatch);
    }

}
