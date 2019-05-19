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
public class GameState2 extends State {

    //world for level 1
    private World world_2;

    //players
    protected static Katch katch_2;
    protected static Pop pop_2;

    //BigLegs that need to be destroyed
    protected static BigLeg bigleg_2;
    protected static BigLeg bigleg2_2;
    protected static BigLeg bigleg3_2;
    protected static BigLeg bigleg4_2;
    protected static BigLeg bigleg5_2;

    protected static GreenBrick gBlock_2;
    protected static GreenBrick gBlock2_2;
    protected static GreenBrick gBlock3_2;
    protected static GreenBrick gBlock4_2;

    protected static RedBrick rBlock_2;
    protected static RedBrick rBlock2_2;
    protected static RedBrick rBlock3_2;
    protected static RedBrick rBlock4_2;

    protected static TealBrick tBlock_2;
    protected static TealBrick tBlock2_2;
    protected static TealBrick tBlock3_2;
    protected static TealBrick tBlock4_2;

    protected static MagentaBrick mBlock_2;
    protected static MagentaBrick mBlock2_2;
    protected static MagentaBrick mBlock3_2;
    protected static MagentaBrick mBlock4_2;

    // under the squid
    protected static SolidBrick b1_2;
    protected static RedBrick b2_2;
    protected static RedBrick b3_2;

    // under the squid colored bricks
    protected static YellowBrick y1_2;
    protected static YellowBrick y2_2;
    protected static YellowBrick y3_2;
    protected static YellowBrick y4_2;
    protected static YellowBrick y5_2;

    protected static GreenBrick b4_2;
    protected static GreenBrick b5_2;
    protected static GreenBrick b6_2;
    protected static GreenBrick b7_2;

    protected static LifeBrick l_2;

    public GameState2(Handler handler) {
        super(handler);
        world_2 = new World(handler, "src/Resources/world1.txt");
        handler.setWorld(world_2);
        katch_2 = new Katch(handler, 300, 440);
        pop_2 = new Pop(handler, 330, 400);

        //1 4 and 7 for big leg will contain a solid Stone below it
        bigleg_2 = new BigLeg(handler, 280, 80);
        // b1_2 = new SolidBrick(handler, 280, 160);
        b1_2 = new SolidBrick(handler, 284, 240);

        b2_2 = new RedBrick(handler, 320, 160);
        b3_2 = new RedBrick(handler, 240, 160);

        y1_2 = new YellowBrick(handler, 204, 240);
        y2_2 = new YellowBrick(handler, 244, 240);
        // y3 = new YellowBrick(handler, 284, 240);
        y4_2 = new YellowBrick(handler, 324, 240);
        y5_2 = new YellowBrick(handler, 364, 240);

       // l_2 = new LifeBrick(handler, 284, 240);
        l_2 = new LifeBrick(handler, 280, 125);

        bigleg2_2 = new BigLeg(handler, 104, 180);
        b4_2 = new GreenBrick(handler, 84, 240);
        b5_2 = new GreenBrick(handler, 124, 240);

        bigleg3_2 = new BigLeg(handler, 500, 180);
        b6_2 = new GreenBrick(handler, 520, 240);
        b7_2 = new GreenBrick(handler, 480, 240);

        rBlock_2 = new RedBrick(handler, 40, 20);
        rBlock2_2 = new RedBrick(handler, 60, 60);
        rBlock3_2 = new RedBrick(handler, 80, 100);
        rBlock4_2 = new RedBrick(handler, 100, 140);

        gBlock_2 = new GreenBrick(handler, 80, 20);
        gBlock2_2 = new GreenBrick(handler, 100, 60);
        gBlock3_2 = new GreenBrick(handler, 120, 100);
        gBlock4_2 = new GreenBrick(handler, 140, 140);

        tBlock_2 = new TealBrick(handler, 560, 20);
        tBlock2_2 = new TealBrick(handler, 520, 60);
        tBlock3_2 = new TealBrick(handler, 480, 100);
        tBlock4_2 = new TealBrick(handler, 420, 140);

        mBlock_2 = new MagentaBrick(handler, 520, 20);
        mBlock2_2 = new MagentaBrick(handler, 480, 60);
        mBlock3_2 = new MagentaBrick(handler, 440, 100);
        mBlock4_2 = new MagentaBrick(handler, 380, 140);

        bigleg5_2 = new BigLeg(handler, 150, 50);
        bigleg4_2 = new BigLeg(handler, 400, 50);

    }

    @Override
    public void tick() {
        world_2.tick();
        katch_2.tick();
        pop_2.tick();
        bigleg_2.tick();

        bigleg2_2.tick();

        bigleg3_2.tick();

        rBlock_2.tick();
        rBlock2_2.tick();
        rBlock3_2.tick();
        rBlock4_2.tick();

        gBlock_2.tick();
        gBlock2_2.tick();
        gBlock3_2.tick();
        gBlock4_2.tick();

        tBlock_2.tick();
        tBlock2_2.tick();
        tBlock3_2.tick();
        tBlock4_2.tick();

        mBlock_2.tick();
        mBlock2_2.tick();
        mBlock3_2.tick();
        mBlock4_2.tick();

        b1_2.tick();
        b2_2.tick();
        b3_2.tick();

        b4_2.tick();
        b5_2.tick();
        b6_2.tick();
        b7_2.tick();

        y1_2.tick();
        y2_2.tick();
        //y3.tick();
        y4_2.tick();
        y5_2.tick();

        l_2.tick();

        bigleg4_2.tick();
        bigleg5_2.tick();

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
        world_2.render(g);
        katch_2.render(g);

        //drawing bigLeg
        bigleg2_2.render(g);
        bigleg_2.render(g);

        bigleg3_2.render(g);

        //drawing the bricks
        rBlock_2.render(g);
        rBlock2_2.render(g);
        rBlock3_2.render(g);
        rBlock4_2.render(g);

        gBlock_2.render(g);
        gBlock2_2.render(g);
        gBlock3_2.render(g);
        gBlock4_2.render(g);

        tBlock_2.render(g);
        tBlock2_2.render(g);
        tBlock3_2.render(g);
        tBlock4_2.render(g);

        mBlock_2.render(g);
        mBlock2_2.render(g);
        mBlock3_2.render(g);
        mBlock4_2.render(g);

        b1_2.render(g);
        b2_2.render(g);
        b3_2.render(g);

        b4_2.render(g);
        b5_2.render(g);
        b6_2.render(g);
        b7_2.render(g);

        y1_2.render(g);
        y2_2.render(g);
        // y3.render(g);
        y4_2.render(g);
        y5_2.render(g);

        l_2.render(g);

        bigleg4_2.render(g);
        bigleg5_2.render(g);

        pop_2.render(g);

    }

}
