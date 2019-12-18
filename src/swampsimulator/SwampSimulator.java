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
    private Character chr;
    protected Game game;
    private Order ord;
    public AdminInventory adminInv;

    public void initialize() throws IOException {
        ss = new JFrame("Swamp Simulator");
        lgn = new Login(this);
        adv = new Adventure(this);
        chr = new Character(this);
        ord = new Order(this);
        adminInv = new AdminInventory(this);

        ss.setSize(1200, 800);
        ss.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ss.setLocationRelativeTo(null);
        ss.setVisible(true);
        ss.add(lgn);

//        ss.add(adminInv); // Cam uncomment this.
        
    }

    public void changePanel(String Old, String New) {
        if (Old.equals("login")) {
            ss.remove(lgn);
        }
        if (New.equals("adventure")){
            ss.add(adv);
        }
        if (Old.equals("adventure")) {
            ss.remove(adv);
        }
        if (New.equals("character")) {
            ss.add(chr);
        }
        if (Old.equals("character")) {
            ss.remove(chr);
        }
        if (New.equals("order")){
            ss.add(ord);
        }
        ss.validate();

    }

    public void playGame() throws InterruptedException, IOException {

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

public static void main(String args[]) throws InterruptedException, IOException, LineUnavailableException, UnsupportedAudioFileException {

    SwampSimulator ss = new SwampSimulator();
//    ss.playGame(); // moved to a method CAMERON
    ss.initialize();

    }

}
