/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swampsimulator;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import static java.awt.image.ImageObserver.ABORT;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 *
 * @author Cammy
 */
public class Game extends JPanel {
    Player player = new Player(this);
    badGuy badGuy = new badGuy(this);
    // character arrays holding string paths to the character artwork, will need to come from the order class
    //String characters[] = new String[]{"src/gameArt/characters/shrek.gif","src/gameArt/characters/donkey.gif","src/gameArt/characters/fiona.gif","src/gameArt/characters/3 mice.gif"};
    //String characters[] = new String[]{"src/gameArt/characters/3 piggies.gif","src/gameArt/characters/puss in boots.gif","src/gameArt/characters/farquaad.gif","src/gameArt/characters/dragon.gif"};
    String characters[] = new String[]{"src/gameArt/characters/god mother.gif","src/gameArt/characters/pinocchio.gif","src/gameArt/characters/wolf.gif","src/gameArt/characters/gingerbread man.gif"};
    
    // string that holds the background image, will need to come from the order class
//    final String background = "src/gameArt/adventures/shrek 1 background.png";
//    final String background = "src/gameArt/adventures/shrek 2 background.png";
//    final String background = "src/gameArt/adventures/shrek 3 background.png";
//    final String background = "src/gameArt/adventures/shrek 4 background.png";
//    final String background = "src/gameArt/adventures/shrek the halls.png";
    final String background = "src/gameArt/adventures/scared shrekless.png";
    
    public Game(){
        
        // adds keyListeners in the game constructor class for key typed, pressed, and released
        addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent e){
                //throw new UnsupportedOperationException("Not supported yet.");
            }
            
            @Override
            public void keyReleased(KeyEvent e){
                player.keyReleased(e);
                //throw new UnsupportedOperationException("Not supported yet.");
            }
            
            @Override
            public void keyPressed(KeyEvent e){
                try {
                    player.keyPressed(e);
                    //throw new UnsupportedOperationException("Not supported yet.");
                } catch (IOException ex) {
                    Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });
        setFocusable(true);
        player.loadImage();
    }
    
    @Override
    public void paint(Graphics g){
        // paints the graphics on screen
        super.paint(g);
        // creates graphics2d object to draw characters
        Graphics2D g2d = (Graphics2D) g;
        // turn on antialiasing for the smoothest of edges
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        // paint the current enemy position
        badGuy.paint(g2d);
        // paint the current player position
        player.paint(g2d);
    }
    
    // checks for a collision between character and enemy
    public boolean collision() {
        // creates a new rectangle for enemy position
        Rectangle r1;
        // creates a new rectangle for player position
        Rectangle r2;
        // sets the value to r1 to the actual enemy position
        r1 = badGuy.getBounds();
        // sets the value to r2 to the actual enemy position
        r2 = player.getBounds();
        // returns either true or false if the two rectangles intersect, determining a collision
        return r1.intersects(r2);
    }
    
    // returns the current player life count to determine character array position
    public int returnCount(){
        return player.count;
    }
    
    // either plays game over sound or loads the next image and resets position values
    public void gameOver(int count) throws FileNotFoundException, IOException, InterruptedException{
        if (count > 3){
            // string containing the filepath of the sound
            //String soundname = "G:\\Fall 2019\\IST 311\\project\\New Folder\\swampsimulator\\assets\\audio\\sharpesttool.wav";
            String soundname = "src/audio/sharpesttool.wav";
            
            // new input stream for game over sound
            InputStream in = new FileInputStream(soundname);
            // new audio stream with the input stream as parameter
            AudioStream audioStream = new AudioStream(in);
            //starts the audio output
            AudioPlayer.player.start(audioStream);
            // sleep to be able to hear the audio (I did read this from a blog online, unknown if necessary)
            Thread.sleep(10);
            
            // display the end popup message on screen
            JOptionPane.showMessageDialog(this, "get out o' me swamp!", "Game Over", JOptionPane.YES_NO_OPTION);
            
            //exit the system
            System.exit(ABORT);
        } else{
            // string containing the filepath of the hit sound
            //String hitSound = "G:\\Fall 2019\\IST 311\\project\\New Folder\\swampsimulator\\assets\\audio\\heh.wav";
            String hitSound = "src/audio/heh.wav";
            
            // using the input stream for hit sount
            InputStream in = new FileInputStream(hitSound);
            // new audio stream with the input stream as parameter
            AudioStream audioStream = new AudioStream(in);
            // starts the audio output
            AudioPlayer.player.start(audioStream);
            // thread sleep
            Thread.sleep(1);
            
            // loads the next character image
            this.player.loadImage();
            // resets character x value
            player.x = 100;
            // resets character y value
            player.y = 500;
            // resets character y velocity value
            player.ya = 0;
            // resets enemy x position
            badGuy.x = 1280;
        }
    }
    
    // updates character and enemy position
    public void move() throws IOException, InterruptedException{
        player.move();
        badGuy.move();
    }
}
