/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package superRainbowReef;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;

/**
 *
 * @author stephaniesantana
 */
public class Katch extends Creature {

    private int angle, vx, vy;
    private float r = 6;
    private AffineTransform rotation;

    public Katch(Handler handler, float x, float y) {
        super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
        width = 80;
        height = 30;
        initialVelocity = 3;
        entityCollider = new Rectangle((int) x, (int) y, width, height);

        //p1 = new Rectangle((int) x, (int) y, Assets.tank1.getWidth(), Assets.tank1.getHeight());
    }

    @Override
    public void tick() {
        //move();

        xMove = 0;
        yMove = 0;

        if (handler.getKeyControl().moveRight) {
            this.moveForwards();
            x += initialVelocity;
        }
        if (handler.getKeyControl().moveLeft) {
            this.moveBackwards();
            x -= initialVelocity;
        }

        entityCollider.setLocation((int) x, (int) y);
    }

    private void moveBackwards() {
        vx = (int) Math.round(r * Math.cos(Math.toRadians(angle)));
        vy = (int) Math.round(r * Math.sin(Math.toRadians(angle)));
        x -= vx;
        y -= vy;

        //moveY(); //moves to left
        checkBorder();
    }

    private void moveForwards() {
        vx = (int) Math.round(r * Math.cos(Math.toRadians(angle)));
        vy = (int) Math.round(r * Math.sin(Math.toRadians(angle)));
        x += vx;
        y += vy;

        //moveX(); //moves to right
        checkBorder();

    }

    private void checkBorder() {
        if (x < 45) {
            x = 45;
        }
        if (x > 515) {
            x = 515;
        }
        if (y < 0) {
            y = 0;
        }
        if (y >= 460) {
            y = 460;

        }
    }

    public void rotate() {
        rotation = AffineTransform.getTranslateInstance(x, y);
        rotation.rotate(Math.toRadians(angle), Assets.katch.getWidth() / 2, Assets.katch.getHeight() / 2);

    }

    @Override
    public void render(Graphics g) {

        rotate();
        Graphics2D graphic2D = (Graphics2D) g;

        graphic2D.drawImage(Assets.katch, rotation, null);

        //score count
        g.setColor(Color.pink);
        g.setFont(new Font("Impact", Font.PLAIN, 40));
        g.drawString("Score: " + score, 220, 300);

        // g.drawImage(Assets.katch, 40, 400, null);
        // g.fillRect(entityCollider.x, entityCollider.y, entityCollider.width, entityCollider.height);
        //drawing of health bars
        //g.fillRect((int) (x + p1.x), (int) (y + p1.y), p1.width, p1.height);
        //g.fillRect((int) (x2 + p2.x), (int) (y2 + p2.y), p2.width, p2.height);
        //g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()),
        //(int) (y + bounds.y - handler.getGameCamera().getyOffset()),
        //bounds.width, bounds.height);
    }

}
