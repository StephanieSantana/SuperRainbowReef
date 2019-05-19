/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package superRainbowReef;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author stephaniesantana
 */
public class Assets {

    public static BufferedImage magentaBlock, yellowBlock, redBlock, greenBlock, tealBlock,
            solidBlock, wallBlock, pop, katch, background, lifeBlock, clearBlock, bigLeg, startUp,
            startButton, end, life, youWin;

    public static void init() {
        try {
            magentaBlock = ImageIO.read(new FileInputStream("src/Resources/Block1.gif"));
            yellowBlock = ImageIO.read(new FileInputStream("src/Resources/Block2.gif"));
            redBlock = ImageIO.read(new FileInputStream("src/Resources/Block3.gif"));
            greenBlock = ImageIO.read(new FileInputStream("src/Resources/Block4.gif"));
            tealBlock = ImageIO.read(new FileInputStream("src/Resources/Block5.gif"));
            solidBlock = ImageIO.read(new FileInputStream("src/Resources/block_solid.gif"));
            lifeBlock = ImageIO.read(new FileInputStream("src/Resources/Block_life.gif"));
            wallBlock = ImageIO.read(new FileInputStream("src/Resources/BlockWall.gif"));
            clearBlock = ImageIO.read(new FileInputStream("src/Resources/transparentBrick.gif"));
            bigLeg = ImageIO.read(new FileInputStream("src/Resources/Bigleg_small_transparent.gif"));
            pop = ImageIO.read(new FileInputStream("src/Resources/Pop_transparent.gif"));
            katch = ImageIO.read(new FileInputStream("src/Resources/Katch_transparent.gif"));
            background = ImageIO.read(new FileInputStream("src/Resources/Background1.bmp"));
            startUp = ImageIO.read(new FileInputStream("src/Resources/Title.BMP"));
            startButton = ImageIO.read(new FileInputStream("src/Resources/Button_Start.gif"));
            end = ImageIO.read(new FileInputStream("src/Resources/gameover.gif"));
            life = ImageIO.read(new FileInputStream("src/Resources/live.png"));
            youWin = ImageIO.read(new FileInputStream("src/Resources/youwin.gif"));

        } catch (IOException ex) {
            Logger.getLogger(Assets.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
