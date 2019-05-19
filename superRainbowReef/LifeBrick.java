/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package superRainbowReef;

import java.awt.Graphics;
import java.awt.Rectangle;
import static superRainbowReef.Creature.score;

/**
 *
 * @author stephaniesantana
 */
public class LifeBrick extends Creature {

    public LifeBrick(Handler handler, float x, float y) {
        super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_WIDTH
        );
        width = 40;
        height = 20;

        entityCollider = new Rectangle((int) x, (int) y, width, height);

    }

    @Override
    public void tick() {

        //if the bigLegs intersect pop, then they cannot be drawn
        if (entityCollider.intersects(GameState.pop.entityCollider)) {
            broken = true;
// resize the rectangle to not show up anymore
            entityCollider.resize(0, 0);
            GameState.pop.yMove = GameState.pop.initialVelocity;

            score = getScore() + 5;
            lives = getLives() + 1;
            // System.out.println("Lifes count:" + lives);

        }

        //for the second gameState2
        if (entityCollider.intersects(GameState2.pop_2.entityCollider)) {
            broken = true;
            entityCollider.resize(0, 0);
            GameState2.pop_2.yMove = GameState2.pop_2.initialVelocity;
            // resize the rectangle to not show up anymore 

            score = getScore() + 5;
            lives = getLives() + 1;

        }

    }
    //boolean for if if the big Leg is broken

    @Override
    public void render(Graphics g) {

        //if the big Legs are not broken, draw them
        if (!broken) {
            g.drawImage(Assets.lifeBlock, (int) getX(), (int) getY(), null);
        }

        //reset to true if pop and katch or reset when live lost
//        if (redraw) {
//            g.drawImage(Assets.lifeBlock, (int) getX(), (int) getY(), null);
//        }
//    }
    }

}
