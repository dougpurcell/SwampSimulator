package swampsimulator;

import java.io.File;
import java.io.FileInputStream;
import javax.swing.*;
import java.io.IOException;
import java.io.InputStream;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 * @author dougthebicyclist
 * @author cammybaby
 */
public class SwampSimulator {

    private JFrame ss;
    private Login lgn;
    private Adventure adv;

    protected Game game;

    public void initialize() throws IOException {
        ss = new JFrame("Swamp Simulator");
        lgn = new Login(this);
        adv = new Adventure(this);

//        game = new Game();

        ss.setSize(1200, 800);
        ss.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ss.setLocationRelativeTo(null);
        ss.setVisible(true);
        ss.add(lgn);
//        adv.openPopup();

    }

    public void changePanel(String Old, String New) {
        if (Old.equals("login")) {
            ss.remove(lgn);
        }
        if (New.equals("adventure")){
            ss.add(adv);
        }
        ss.validate();

    }

public static void main(String args[]) throws InterruptedException, IOException, LineUnavailableException, UnsupportedAudioFileException {

    SwampSimulator ss = new SwampSimulator();
    ss.initialize();

        /* C A M E R O N:
            uncomment your shit to work on the game bro.
        */

//         this would be the shit connected to the "checkout" button
        JFrame frame = new JFrame("me swamp");

        Game game = new Game();

        frame.add(game);
        frame.setSize(1200, 800);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        while (game.returnCount() < 4){
            game.move();
            game.repaint();
            System.out.println(game.returnCount());
            
          
            Thread.sleep(10);
        }
    }

}
