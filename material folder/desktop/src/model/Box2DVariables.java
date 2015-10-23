package model;

/**
 * This class contains public variables available to the entire project to use.
 */
public class Box2DVariables {

    /**
     * This is the ratio of pixels per meter.
     * Because this value is 100 it means that 100 pixels on the screen represents 1 meter in real life.
     */
    public static float PPM = 100;

    /**
     * These values represent the types of collision objects in the game can belong to.
     */
    public static final short BIT_GROUND = 2;
    public static final short BIT_BOX = 4;
    public static final short BIT_BALL = 8;



}
