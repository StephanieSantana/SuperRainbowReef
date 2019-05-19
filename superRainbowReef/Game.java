/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package superRainbowReef;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author stephaniesantana
 */
public class Game implements Runnable {

    private Display display;
    private int width, height;
    private String title;

    private boolean running = false;
    private Thread thread;

    private BufferStrategy bs;
    private Graphics2D g;

    //level 1
    private State gameState;

    private State menuState;
    private State endState;

    private KeyControl keyManager;
    private MouseManager MouseManager;

    //private GameCamera gameCamera;
    private Handler handler;
    private State gameState2;

    public Game(String title, int width, int height) {
        this.width = width;
        this.height = height;
        this.title = title;
        keyManager = new KeyControl();
        MouseManager = new MouseManager();
    }

    private void init() throws IOException {
        display = new Display(title, width, height);
        display.getFrame().addKeyListener(keyManager);
        display.getFrame().addMouseListener(MouseManager);
        display.getFrame().addMouseMotionListener(MouseManager);
        display.getCanvas().addMouseListener(MouseManager);
        display.getCanvas().addMouseMotionListener(MouseManager);
        Assets.init();

        handler = new Handler(this);

        //when game reaches an end
        endState = new EndState(handler);
        State.setState(getEndState());

// when player begins second level
        gameState2 = new GameState2(handler);
        State.setState(getGameState2());

        // when player begins first level
        gameState = new GameState(handler);
        State.setState(getGameState());

        // when game begins
        menuState = new MenuState(handler);
        State.setState(getMenuState());

    }

    private void tick() {

        keyManager.tick();
        if (State.getState() != null) {
            State.getState().tick();
        }

    }

    private void render() {
        bs = display.getCanvas().getBufferStrategy();
        if (bs == null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = (Graphics2D) bs.getDrawGraphics();
        //Clear Screen
        g.clearRect(0, 0, width, height);
        //Draw Here

        if (State.getState() != null) {
            State.getState().render(g);
        }
        //End Drawing!
        bs.show();
        g.dispose();
    }

    @Override
    public void run() {

        try {
            init();
        } catch (IOException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }

        int framesPerSec = 60;
        double timePerTick = 1000000000 / framesPerSec;
        double delta = 0;
        long currentTime;
        long lastTime = System.nanoTime();
        long timer = 0;
        long ticks = 0;

        while (running) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / timePerTick;
            timer += currentTime - lastTime;
            lastTime = currentTime;

            if (delta >= 1) {
                tick();
                render();
                ticks++;
                delta--;
            }

//            if (timer >= 1000000000){
//                System.out.println("Ticks and Frames: " + ticks);
//                ticks = 0;
//                timer = 0;
//            }
        }

        stop();
    }

    public KeyControl getKeyManager() {
        return keyManager;
    }

    public MouseManager getMouseManager() {
        return MouseManager;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public synchronized void start() {
        if (running) {
            return;
        }
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop() {
        if (!running) {
            return;
        }
        running = false;
        try {
            thread.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * @return the gameState
     */
    public State getGameState() {
        return gameState;
    }

    /**
     * @return the menuState
     */
    public State getMenuState() {
        return menuState;
    }

    /**
     * @return the endState
     */
    public State getEndState() {
        return endState;
    }

    public State getGameState2() {
        return gameState2;
    }
}
