/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package superRainbowReef;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import javafx.scene.paint.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import static superRainbowReef.Brick.BRICKWIDTH;
import static superRainbowReef.Brick.BRICKHEIGHT;

/**
 *
 * @author stephaniesantana
 */
public class World {

    private Handler handler;
    private int width, height;
    private int[][] BrickArray;

    private int spawnX, spawnY;

    public World(Handler handler, String path) {
        this.handler = handler;
        loadWorld(path);

    }

    public void tick() {

    }

    protected boolean beginningStep;

    public void render(Graphics g) {

        g.drawImage(Assets.background, 0, 0, null);

        g.setColor(java.awt.Color.black);

        //for checking if the shoot key for pop is pressed
        if (handler.getKeyControl().shoot) {
            beginningStep = true;
        }

        //displays the string below when pop is not launched
        if (!beginningStep) {
            g.drawString("Press space bar to begin Game :)", 400, 400);
        }

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                getBrick(x, y).render(g, x * BRICKWIDTH, y * BRICKHEIGHT);

            }
        }
    }

    public Brick getBrick(int x, int y) {
        //for checking if the player can go out of the map
        if (x < 0 || y < 0 || x >= width || y >= height) {
            return Brick.block6;
        }

        Brick t = Brick.blocks[BrickArray[x][y]];
        if (t == null) {
            return Brick.block6;
        }
        return t;

    }

    private void loadWorld(String path) {
        String file = Utils.loadFileAsString(path);
        String[] tokens = file.split("\\s+");
        width = Utils.parseInt(tokens[0]);
        height = Utils.parseInt(tokens[1]);
        spawnX = Utils.parseInt(tokens[2]);
        spawnY = Utils.parseInt(tokens[3]);

        BrickArray = new int[width][height];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                BrickArray[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]);
            }
        }

    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
