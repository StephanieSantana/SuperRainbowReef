/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package superRainbowReef;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 *
 * @author stephaniesantana
 */
public class Brick {

    public static Brick[] blocks = new Brick[256];
    public static Brick block6 = new UnbreakableBrick(5);
    public static Brick block9 = new BreakableClear(8);

    public static final int BRICKWIDTH = 40, BRICKHEIGHT = 20;

    protected BufferedImage texture;
    protected final int id;
    protected float x, y;
    protected Rectangle entityCollider;

    public Brick(BufferedImage texture, int id) {
        this.texture = texture;
        this.id = id;

        blocks[id] = this;

        entityCollider = new Rectangle((int) x, (int) y, BRICKWIDTH, BRICKHEIGHT);

    }

    public void tick() {

    }

    protected boolean broken;

    public void render(Graphics g, int x, int y) {

            g.drawImage(texture, x, y, BRICKWIDTH, BRICKHEIGHT, null);

        

    }

    public boolean isSolid() {
        return false;
    }

    public int getId() {
        return id;
    }

    /**
     * @return the x
     */
    public float getX() {
        return x;
    }

    /**
     * @return the y
     */
    public float getY() {
        return y;
    }

}
