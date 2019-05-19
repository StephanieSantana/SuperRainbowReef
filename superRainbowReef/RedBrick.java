/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package superRainbowReef;

import superRainbowReef.Creature;
import java.awt.Graphics;
import java.awt.Rectangle;
import superRainbowReef.Assets;
import superRainbowReef.GameState;
import superRainbowReef.Handler;

/**
 *
 * @author stephaniesantana
 */
public class RedBrick extends Creature {

    public RedBrick(Handler handler, float x, float y) {
        super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
        width = 40;
        height = 20;

        entityCollider = new Rectangle((int) x, (int) y, width, height);

    }

    @Override
    public void tick() {

        if (entityCollider.intersects(GameState.pop.entityCollider)) {
            broken = true;
// resize the rectangle to not show up anymore
            entityCollider.resize(0, 0);
            GameState.pop.yMove = GameState.pop.initialVelocity;

            score = getScore() + 5;

            //for in the invent that the squid can move
            //entityCollider.setLocation((int) getX(), (int) getY());
        }

        //for the second gameState2
        if (entityCollider.intersects(GameState2.pop_2.entityCollider)) {
            broken = true;
            // resize the rectangle to not show up anymore 
            entityCollider.resize(0, 0);
            GameState2.pop_2.yMove = GameState2.pop_2.initialVelocity;

            score = getScore() + 5;

        }

    }
    //boolean for if if the big Leg is broken

    @Override
    public void render(Graphics g) {

        //if the big Legs are not broken, draw them
        if (!broken) {
            g.drawImage(Assets.redBlock, (int) getX(), (int) getY(), null);
        }

    }

}
