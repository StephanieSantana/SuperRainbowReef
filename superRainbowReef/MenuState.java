/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package superRainbowReef;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author stephaniesantana
 */
public class MenuState extends State {

    
    public MenuState(Handler handler) {
        super(handler);
      
        
    }

    @Override
    public void tick() {
  
        if (handler.getMouseManager().isLeftPressed())
            State.setState(handler.getGame().getGameState());
      
    }

    @Override
    public void render(Graphics g) {

        g.drawImage(Assets.startUp, 0 ,0 , null);
        g.drawImage(Assets.startButton, 280, 420, null);
        //g.setColor(Color.red);
        //g.fillRect(handler.getMouseManager().getMouseX(), handler.getMouseManager().getMouseY(), 8, 8);
    }
    
}
