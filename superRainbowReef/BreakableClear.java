/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package superRainbowReef;

import java.awt.Graphics;
import java.awt.Rectangle;
import static superRainbowReef.Brick.BRICKHEIGHT;
import static superRainbowReef.Brick.BRICKWIDTH;

/**
 *
 * @author stephaniesantana
 */
public class BreakableClear extends Brick {

    protected boolean broken;

    public BreakableClear(int id) {
        super(Assets.clearBlock, id);

        entityCollider = new Rectangle((int) x, (int) y, BRICKWIDTH, BRICKHEIGHT);
   
        
    }

    @Override
    public boolean isSolid() {
        return false;
    }

}
   
