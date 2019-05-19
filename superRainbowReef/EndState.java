/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package superRainbowReef;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 *
 * @author stephaniesantana
 */
public class EndState extends State{

    public EndState(Handler handler) {
        super(handler);
    }

    @Override
    public void tick() {
        
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.background, 0, 0, null);
        if (Pop.isLose()){
        g.drawImage(Assets.end, 60, 40, null);
        }
        if (Pop.isWon()){
        g.drawImage(Assets.youWin, 120, 80, null);
        }
        
        
         g.setColor(Color.PINK);
        g.setFont(new Font("Impact", Font.PLAIN, 40));
        g.drawString("Final Score: " + Creature.getScore() , 220, 100);
    }
    
}
