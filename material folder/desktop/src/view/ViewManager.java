package view;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import model.GameManager;
import model.LevelManager;


public class ViewManager {

    private GameManager gameManager;
    private LevelManager levelManager;

    private UnitGraphicsRender unitGraphicsRender;
    private GraphicsRender platformsGraphicsRender;
    private GraphicsRender projectileGraphicsRender;

    public static OrthographicCamera camera;
    private SpriteBatch sb;

    public ViewManager(GameManager gameManager){
        this.gameManager = gameManager;
        this.levelManager = gameManager.getLevelManager();
        this.camera = new OrthographicCamera();
        this.camera.setToOrtho(false, 33, 20);
        this.camera.zoom = (float)1;
        this.camera.update();
        this.sb = new SpriteBatch();
        this.unitGraphicsRender = new UnitGraphicsRender();
        this.platformsGraphicsRender = new PlatformsGraphicsRender();
        this.projectileGraphicsRender = new ProjectileGraphicsRender();
    }

    public void renderGraphics(){
        updateCamera();
        clearTheScreen();
        cameraToFollowPlayer();
        connectCameraAndSpriteBatch();
        startSpriteBatchDrawing();
        renderBackground(sb);

        platformsGraphicsRender.renderGraphics(levelManager, sb);
        projectileGraphicsRender.renderGraphics(levelManager, sb);
        unitGraphicsRender.renderUnitGraphics(levelManager, sb);

        stopSpriteBatchDrawing();
    }

    private void updateCamera(){
        camera.update();
    }

    private void clearTheScreen(){
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }


    private void cameraToFollowPlayer(){
        Body body = gameManager.getLevelManager().getPlayer().getBody();
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
        Sprite sprite = levelManager.getBackground().getSprite();
        sprite.setPosition((-10),(-10));
        sprite.setSize(500, 500);
        sprite.draw(spriteBatch);
    }

}
