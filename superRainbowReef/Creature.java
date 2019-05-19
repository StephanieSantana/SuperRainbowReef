/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package superRainbowReef;

import java.awt.Rectangle;
import superRainbowReef.Handler;
import static superRainbowReef.Brick.BRICKHEIGHT;
import static superRainbowReef.Brick.BRICKWIDTH;

/**
 *
 * @author stephaniesantana
 */
public abstract class Creature extends Entity {

    public static final int DEFAULT_HEALTH = 10;
    public static final float DEFAULT_SPEED = 3.0f;
    public static final int DEFAULT_CREATURE_WIDTH = 25,
            DEFAULT_CREATURE_HEIGHT = 25;

    /**
     * @return the lives
     */
    public static int getLives() {
        return lives;
    }

    /**
     * @return the bigLeg2
     */
    public static int getBigLeg2() {
        return bigLeg2;
    }

    /**
     * @return the bigLeg
     */
    public static int getBigLeg() {
        return bigLeg;
    }

    protected int health;
    protected float speed;
    protected float xMove;
    protected float yMove;
    protected float initialVelocity;
    protected boolean broken;
    protected static int lives;
    protected static int score;
    protected static int bigLeg;
    protected static int bigLeg2;

    //  protected static boolean redraw;
    public Creature(Handler handler, float x, float y, int width, int height) {
        super(handler, x, y, width, height);
        health = DEFAULT_HEALTH;
        speed = DEFAULT_SPEED;
        xMove = 0;
        yMove = 0;
        initialVelocity = 0;

    }

    public int getHealth() {
        return health;
    }

    public float getSpeed() {
        return speed;
    }

    /**
     * @param health the health to set
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * @param speed the speed to set
     */
    public void setSpeed(float speed) {
        this.speed = speed;
    }

    /**
     * @return the xMove
     */
    public float getxMove() {
        return xMove;
    }

    /**
     * @param xMove the xMove to set
     */
    public void setxMove(int xMove) {
        this.xMove = xMove;
    }

    /**
     * @return the yMove
     */
    public float getyMove() {
        return yMove;
    }

    /**
     * @param yMove the yMove to set
     */
    public void setyMove(int yMove) {
        this.yMove = yMove;
    }

    /**
     * @return the score
     */
    public static int getScore() {
        return score;
    }

}
