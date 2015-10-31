package model;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;


public class Unit extends GameObject {

    private int healthPoints;
    private int energyPoints;

    private Texture texture_healthBar = new Texture(PathVariables.healthBar);
    private Sprite sprite_healthBar = new Sprite(texture_healthBar);

    private FacingDirection facingDirection = FacingDirection.right;
    private FacingDirection lastFacingDirection = FacingDirection.right;
    private double graphicsRenderTimeA;
    private double graphicsRenderTimeB;
    private double graphicsRenderDeltaTime;
    private int graphicsRenderArrayPointer;


    public Unit(World world, float x, float y, float width, float height, BodyDef.BodyType bodyType, String texturePathA, String texturePathB) {
        super(world, x, y, width, height, bodyType, texturePathA, texturePathB);

    }

    public FacingDirection getLastFacingDirection() {
        return lastFacingDirection;
    }
    public void setLastFacingDirection(FacingDirection lastFacingDirection) {
        this.lastFacingDirection = lastFacingDirection;
    }@Override
    public FacingDirection getFacingDirection() {
        return facingDirection;
    }@Override
    public void setFacingDirection(FacingDirection facingDirection) {
        this.facingDirection = facingDirection;
    }
    public double getGraphicsRenderTimeA() {
        return graphicsRenderTimeA;
    }
    public void setGraphicsRenderTimeA(double graphicsRenderTimeA) {
        this.graphicsRenderTimeA = graphicsRenderTimeA;
    }
    public double getGraphicsRenderTimeB() {
        return graphicsRenderTimeB;
    }
    public void setGraphicsRenderTimeB(double graphicsRenderTimeB) {
        this.graphicsRenderTimeB = graphicsRenderTimeB;
    }
    public double getGraphicsRenderDeltaTime() {
        return graphicsRenderDeltaTime;
    }
    public void setGraphicsRenderDeltaTime(double graphicsRenderDeltaTime) {
        this.graphicsRenderDeltaTime = graphicsRenderDeltaTime;
    }
    public int getGraphicsRenderArrayPointer() {
        return graphicsRenderArrayPointer;
    }
    public void setGraphicsRenderArrayPointer(int graphicsRenderArrayPointer) {
        this.graphicsRenderArrayPointer = graphicsRenderArrayPointer;
    }
    public int getHealthPoints() {
        return healthPoints;
    }
    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }
    public int getEnergyPoints() {
        return energyPoints;
    }
    public void setEnergyPoints(int energyPoints) {
        this.energyPoints = energyPoints;
    }
    public Sprite getSprite_healthBar() {
        return sprite_healthBar;
    }



}
