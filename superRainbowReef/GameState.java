/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package superRainbowReef;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author stephaniesantana
 */
public class GameState extends State {

    //world for level 1
    private World world;

    //players
    protected static Katch katch;
    protected static Pop pop;

    //BigLegs that need to be destroyed
    protected static BigLeg bigleg;
    protected static BigLeg bigleg2;
    protected static BigLeg bigleg3;

    protected static GreenBrick gBlock;
    protected static GreenBrick gBlock2;
    protected static GreenBrick gBlock3;
    protected static GreenBrick gBlock4;

    protected static RedBrick rBlock;
    protected static RedBrick rBlock2;
    protected static RedBrick rBlock3;
    protected static RedBrick rBlock4;

    protected static TealBrick tBlock;
    protected static TealBrick tBlock2;
    protected static TealBrick tBlock3;
    protected static TealBrick tBlock4;

    protected static MagentaBrick mBlock;
    protected static MagentaBrick mBlock2;
    protected static MagentaBrick mBlock3;
    protected static MagentaBrick mBlock4;

    // under the squid
    protected static SolidBrick b1;
    protected static RedBrick b2;
    protected static RedBrick b3;

    // under the squid colored bricks
    protected static YellowBrick y1;
    protected static YellowBrick y2;
    protected static YellowBrick y3;
    protected static YellowBrick y4;
    protected static YellowBrick y5;

    protected static GreenBrick b4;
    protected static GreenBrick b5;
    protected static GreenBrick b6;
    protected static GreenBrick b7;

    protected static LifeBrick l;

    public GameState(Handler handler) {
        super(handler);
        world = new World(handler, "src/Resources/world1.txt");
        handler.setWorld(world);
        katch = new Katch(handler, 300, 440);
        pop = new Pop(handler, 330, 400);

        //1 4 and 7 for big leg will contain a solid Stone below it
        bigleg = new BigLeg(handler, 280, 110);
        b1 = new SolidBrick(handler, 280, 160);
        b2 = new RedBrick(handler, 320, 160);
        b3 = new RedBrick(handler, 240, 160);

        y1 = new YellowBrick(handler, 204, 240);
        y2 = new YellowBrick(handler, 244, 240);
        // y3 = new YellowBrick(handler, 284, 240);
        y4 = new YellowBrick(handler, 324, 240);
        y5 = new YellowBrick(handler, 364, 240);

        l = new LifeBrick(handler, 284, 240);

        bigleg2 = new BigLeg(handler, 104, 180);
        b4 = new GreenBrick(handler, 84, 240);
        b5 = new GreenBrick(handler, 124, 240);

        bigleg3 = new BigLeg(handler, 500, 180);
        b6 = new GreenBrick(handler, 520, 240);
        b7 = new GreenBrick(handler, 480, 240);

        rBlock = new RedBrick(handler, 40, 20);
        rBlock2 = new RedBrick(handler, 60, 60);
        rBlock3 = new RedBrick(handler, 80, 100);
        rBlock4 = new RedBrick(handler, 100, 140);

        gBlock = new GreenBrick(handler, 80, 20);
        gBlock2 = new GreenBrick(handler, 100, 60);
        gBlock3 = new GreenBrick(handler, 120, 100);
        gBlock4 = new GreenBrick(handler, 140, 140);

        tBlock = new TealBrick(handler, 560, 20);
        tBlock2 = new TealBrick(handler, 520, 60);
        tBlock3 = new TealBrick(handler, 480, 100);
        tBlock4 = new TealBrick(handler, 420, 140);

        mBlock = new MagentaBrick(handler, 520, 20);
        mBlock2 = new MagentaBrick(handler, 480, 60);
        mBlock3 = new MagentaBrick(handler, 440, 100);
        mBlock4 = new MagentaBrick(handler, 380, 140);

    }

    @Override
    public void tick() {
        world.tick();
        katch.tick();
        pop.tick();
        bigleg.tick();

        bigleg2.tick();

        bigleg3.tick();

        rBlock.tick();
        rBlock2.tick();
        rBlock3.tick();
        rBlock4.tick();

        gBlock.tick();
        gBlock2.tick();
        gBlock3.tick();
        gBlock4.tick();

        tBlock.tick();
        tBlock2.tick();
        tBlock3.tick();
        tBlock4.tick();

        mBlock.tick();
        mBlock2.tick();
        mBlock3.tick();
        mBlock4.tick();

        b1.tick();
        b2.tick();
        b3.tick();

        b4.tick();
        b5.tick();
        b6.tick();
        b7.tick();

        y1.tick();
        y2.tick();
        //y3.tick();
        y4.tick();
        y5.tick();

        l.tick();

        //tealBrick2.tick();
//        for(RedBrick b: rList){
//            b.tick();
//        }
//        
//        for(GreenBrick b1: gList){
//            b1.tick();
//        }
//
//        for(int i = 0; i < bList.size(); i++){
//            if (bList.get(i).broken)
//                    bList.remove(i);
//        }
    }

    @Override
    public void render(Graphics g) {
        world.render(g);
        katch.render(g);
        bigleg.render(g);

        //drawing bigLegs
        // bigleg2.render(g);
        // bigleg3.render(g);
        bigleg2.render(g);
        // bigleg5.render(g);
        //bigleg6.render(g);
        bigleg3.render(g);

        //drawing the bricks
        rBlock.render(g);
        rBlock2.render(g);
        rBlock3.render(g);
        rBlock4.render(g);

        gBlock.render(g);
        gBlock2.render(g);
        gBlock3.render(g);
        gBlock4.render(g);

        tBlock.render(g);
        tBlock2.render(g);
        tBlock3.render(g);
        tBlock4.render(g);

        mBlock.render(g);
        mBlock2.render(g);
        mBlock3.render(g);
        mBlock4.render(g);

        b1.render(g);
        b2.render(g);
        b3.render(g);

        b4.render(g);
        b5.render(g);
        b6.render(g);
        b7.render(g);

        y1.render(g);
        y2.render(g);
        // y3.render(g);
        y4.render(g);
        y5.render(g);

        l.render(g);

        pop.render(g);

    }

}
