/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package superRainbowReef;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author stephaniesantana
 */
public class KeyControl implements KeyListener {

    private boolean[] keys;
    public boolean moveRight, moveLeft, shoot;

    public KeyControl() {
        keys = new boolean[256];
    }

    public void tick() {
        
        moveRight = keys[KeyEvent.VK_RIGHT];
        moveLeft = keys[KeyEvent.VK_LEFT];
        shoot = keys[KeyEvent.VK_SPACE];
        
        
      
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
        

    }

}
