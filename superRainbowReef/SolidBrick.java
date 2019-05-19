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
import superRainbowReef.Handler;

/**
 *
 * @author stephaniesantana
 */
public class SolidBrick extends Creature {

    public SolidBrick(Handler handler, float x, float y) {
        super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
        width = 40;
        height = 20;
        
        initialVelocity = -3; //so pop cant speed through it

        entityCollider = new Rectangle((int) x, (int) y, width, height);

        
    }

    @Override
    public void tick() {

        //for in the invent that the squid can move
        //entityCollider.setLocation((int) getX(), (int) getY());
    }

    @Override
    public void render(Graphics g) {

        
        g.drawImage(Assets.solidBlock, (int) getX(), (int) getY(), null);
    }

}
