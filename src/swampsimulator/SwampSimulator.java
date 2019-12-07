package swampsimulator;

import javax.swing.*;
import java.io.IOException;

/**
 * @author dougthebicyclist
 * @author cammybaby
 */
public class SwampSimulator {
    private JFrame ss;
    private Login lgn;
    private Adventure adv;
    private AdventurePanel advpanel;

//    private Character chr;
//    private CharacterPanel chrpanel;
//    private Order odr;
    protected Game game;

    public void initialize() throws IOException {
        ss = new JFrame("Swamp Simulator");
        lgn = new Login(this);
        adv = new Adventure(this);
        advpanel = new AdventurePanel();
        game = new Game();
//        chr = new Character(this);

        ss.setSize(1200, 800);
        ss.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ss.setLocationRelativeTo(null);
        ss.setVisible(true);
        ss.add(lgn);
    }
    public void changePanel (String Old, String New) {
        if (Old.equals("login")) {
            ss.remove(lgn);
        }
        else if (Old.equals("adventure")) {
            ss.remove(adv);
        }

//        else if (Old.equals("character")){
//            ss.remove(chr);
//        }
//        else (Old.equals("order")){
//            ss.remove(odr);
//        }

        if (New.equals("adventure")){
            ss.add(adv);
        }
        else if (New.equals("advpanel")) {
            ss.add(advpanel);
        }
//        else if (New.equals("character")){
//            ss.add(chr);
//        }
//        else if (New.equals("order")){
//            ss.add(odr);
//        }
//        else (New.equals("game")){
//            ss.add(game);
//        }

        ss.validate();
        ss.pack();

    }

public static void main(String args[]) throws InterruptedException, IOException {

    SwampSimulator ss = new SwampSimulator();
    ss.initialize();

        /* C A M E R O N:
            uncomment your shit to work on the game bro.
        */

//         this would be the shit connected to the "checkout" button
//        JFrame frame = new JFrame("me swamp");
//
//        Game game = new Game();
//
//        frame.add(game);
//        frame.setSize(1280, 720);
//        frame.setVisible(true);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        while (true){
//            game.move();
//            game.repaint();
//            Thread.sleep(10);
//
//        }
    }

}
