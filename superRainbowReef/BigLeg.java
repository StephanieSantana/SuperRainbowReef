/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package superRainbowReef;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.logging.Level;
import java.util.logging.Logger;
import superRainbowReef.Assets;
import superRainbowReef.GameState;
import superRainbowReef.Handler;

/**
 *
 * @author stephaniesantana
 */
public class BigLeg extends Creature {

    public BigLeg(Handler handler, float x, float y) {
        super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
        width = 40;
        height = 40;

        entityCollider = new Rectangle((int) x, (int) y, width, height);

    }

    @Override
    public void tick() {

        //for in the invent that the squid can move
        //entityCollider.setLocation((int) getX(), (int) getY());
        //if the bigLegs intersect pop, then they cannot be drawn
        //for gameState 1
        if (entityCollider.intersects(GameState.pop.entityCollider)) {
            broken = true;
            entityCollider.resize(0, 0);

            GameState.pop.yMove = GameState.pop.initialVelocity;

            // resize the rectangle to not show up anymore 
            score = getScore() + 20;
            bigLeg = getBigLeg() + 1;

        }

        //for the second gameState2
        if (entityCollider.intersects(GameState2.pop_2.entityCollider)) {
            broken = true;
            entityCollider.resize(0, 0);

            GameState2.pop_2.yMove = GameState2.pop_2.initialVelocity;
            // resize the rectangle to not show up anymore 
            score = getScore() + 20;
            bigLeg2 = getBigLeg2() + 1;

        }
    }

    @Override
    public void render(Graphics g) {

        //if the big Legs are not broken, draw them
        if (!broken) {
            g.drawImage(Assets.bigLeg, (int) getX(), (int) getY(), null);
        }

    }

}
