
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package superRainbowReef;

import superRainbowReef.Creature;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import superRainbowReef.Assets;
import superRainbowReef.GameState;
import superRainbowReef.Handler;

/**
 *
 * @author stephaniesantana
 */
public class Pop extends Creature {

    private float angle;
    //when these are commented out they do not overwrite gameState position
    //protected float vx;
    //protected float vy;
    protected AffineTransform transform;
    protected boolean shoot;
    protected static boolean won;
    protected static boolean lose;
    protected static boolean level1;
    protected static boolean level2;

    public Pop(Handler handler, float x, float y) {
        super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);

        width = 35;
        height = 35;

        //baseMovement = 3;
        // x = initialVelocity;
        // y = initialVelocity;
        entityCollider = new Rectangle((int) x, (int) y, width, height);
        lives = 3;
        score = 0;
        bigLeg = 0;
    }

    //also the bricks are not re-rendered
    //things needed to be considered and fixed 8/8/18
    //respawning if lost
    public void reset() {
        //pops location
        x = 330;
        y = 400;

        //katchs location
        GameState.katch.x = 300;
        GameState.katch.y = 440;

        GameState2.katch_2.x = 300;
        GameState2.katch_2.y = 440;

        //pops speed
        yMove = 0;
        xMove = 0;

        //game Score reset
        //score = 0;
    }

    @Override
    public void tick() {

        //if shoot key pressed, start moving
        if (handler.getKeyControl().shoot) {
            shoot = true;
            //make xMove zero for no angle
            xMove = 2;
            yMove = -2;
            initialVelocity = 2;
        }

        x += xMove;
        y += yMove;

        if (entityCollider.intersects(GameState.katch.entityCollider)) {
            //pop must be faster when hits katch
            initialVelocity = 3;
            yMove = -initialVelocity;
            //  xMove = -initialVelocity;
            //  changeVelocity(1, 1);

        }

        if (entityCollider.intersects(GameState2.katch_2.entityCollider)) {
            //pop must be faster when hits katch
            initialVelocity = 3;
            yMove = -initialVelocity;
            //  xMove = -initialVelocity;
            //  changeVelocity(1, 1);

        }

        //this is for the single brick ...... 
        if (entityCollider.intersects(GameState.b1.entityCollider)) {
            yMove = -initialVelocity;
            xMove = -initialVelocity;

        }

        //this is for the single brick ...... 
        if (entityCollider.intersects(GameState2.b1_2.entityCollider)) {
            yMove = -initialVelocity;
            xMove = -initialVelocity;

        }
        
        
         //this is for the single brick ...... 
        if (entityCollider.intersects(GameState.l.entityCollider)) {
            yMove = -initialVelocity;
            xMove = -initialVelocity;

        }
        
         //this is for the single brick ...... 
        if (entityCollider.intersects(GameState2.l_2.entityCollider)) {
            yMove = -initialVelocity;
            xMove = -initialVelocity;

        }

        //pop cannot reach outside the top of the canvas
        if (y <= height - 20) {
            yMove = initialVelocity;
        }

        //MOST IMPORTANT ASPECT OF GAME, pop of screen, LOSE life/game
        //if pop goes below the screen
        if (y >= handler.getGame().getHeight()) {

            //for losing a life
            lives = getLives() - 1;

            // System.out.println("Lost a life");
            reset();
        }
            //go to end  state
            if (getLives() == 0) {
                lose = true;
                State.setState(handler.getGame().getEndState());
                //reset the lives for second round
                won = false;

            }

        

        // popcannot go through the sides
        if (x <= width) {
            xMove = initialVelocity;

        }

        //pop cannot go through the sides
        if (x + width >= handler.getGame().getWidth() - height) {
            xMove = -initialVelocity;

        }

        //setting rectangle bounds for pop to follow
        entityCollider.setLocation((int) getX(), (int) getY());

        //MISSION OF THE LEVEL
        // checking if all big legs are caught, then WIN, game Ends
        if (getBigLeg() == 3) {
            won = true;
           
            //level 1 goes to level too
            State.setState(handler.getGame().getGameState2());
            getLives();
            
        }

        //if level 2, then you find the 3 big legs and end State
        if (getBigLeg2() == 5) {
            won = true;
            State.setState(handler.getGame().getEndState());

        }

    }

    public void changeVelocity(int x, int y) {
        xMove *= x;
        yMove *= y;
    }

    private void rotate() {
        this.angle += 2;
    }

    @Override
    public void render(Graphics g) {
        rotate();
        transform = AffineTransform.getTranslateInstance(getX(), getY());
        transform.rotate(Math.toRadians(angle), Assets.pop.getWidth() / 2, Assets.pop.getHeight() / 2);

        Graphics2D graphic2D = (Graphics2D) g;

        graphic2D.drawImage(Assets.pop, transform, null);

        // lives bar for when lost or gained
        
         if (getLives() == 5) {
            g.drawImage(Assets.life, 10, 320, null);
            g.drawImage(Assets.life, 10, 360, null);
            g.drawImage(Assets.life, 10, 400, null);
            g.drawImage(Assets.life, 10, 440, null);

        }
        if (getLives() == 4) {
            g.drawImage(Assets.life, 10, 320, null);
            g.drawImage(Assets.life, 10, 360, null);
            g.drawImage(Assets.life, 10, 400, null);
            g.drawImage(Assets.life, 10, 440, null);

        }

        if (getLives() == 3) {
            g.drawImage(Assets.life, 10, 320, null);
            g.drawImage(Assets.life, 10, 360, null);
            g.drawImage(Assets.life, 10, 400, null);

        }

        if (getLives() == 2) {
            g.drawImage(Assets.life, 10, 360, null);
            g.drawImage(Assets.life, 10, 400, null);
        }

        if (getLives() == 1) {
            g.drawImage(Assets.life, 10, 400, null);
        }

    }

    public int getPopWidth() {
        return Assets.pop.getWidth();
    }

    public int getPopHeight() {
        return Assets.pop.getHeight();
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

    /**
     * @param x the x to set
     */
    public void setX(float x) {
        this.x = x;
    }

    /**
     * @param y the y to set
     */
    public void setY(float y) {
        this.y = y;
    }

    /**
     * @return the won
     */
    public static boolean isWon() {
        return won;
    }

    /**
     * @return the lose
     */
    public static boolean isLose() {
        return lose;
    }

}
