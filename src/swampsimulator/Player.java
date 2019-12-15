/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swampsimulator;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import javax.swing.ImageIcon;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 *
 * @author Cammy
 */
public class Player{
    int x = 100; // character x position
    int y = 502; // character y position and floor position
    int xa = 0; // character x velocity
    int ya = 0; // character y velocity
    int count = 0; // life count, used for switching characters
    private Game game; // game instance for player class
    private Image image; // image variable holder for character art
    private int w; // image width
    private int h; // image height
    
    // initiates the instance of the game
    public Player(Game game){
        this.game = game;
    }
    
    // loads the image of the character
    public void loadImage() {
        // creates a new image icon with the characters array and the count as a file path
        ImageIcon ii = new ImageIcon(game.characters[count]);
        // load the image
        image = ii.getImage(); 
        
        // sets width
        w = image.getWidth(null);
        // sets height
        h = image.getHeight(null);
    }
    
    // returns the image used in drawning the graphics to the screen set in loadImage()
    public Image getImage() {
        return image;
    }
    
    // paints the graphic to screen
    public void paint(Graphics2D g){
        // prints graphic to screen
        g.drawImage(getImage(), x, y, game);
        // prints character position information
        System.out.println("x: " + x + " xa: " + xa + " y: " + y + " ya: " + ya);
    }
    
    // calculates movement in game
    void move() throws IOException, InterruptedException{
        
        // if current position and velocity are greater than 0 and less than the right edge of the screen
        if (x + xa > 0 && x + xa < 1280-w){
            // increase the character position by velocity
            x = x + xa;
        }
        
        // if current height and velocity are greater than zero and less than the floor of the game
        if (y + ya > 0 && y + ya < 500){
            // if jumping up
            if (y > 300){
                y = y + ya;
            } else{ // if falling down, increase velocity to 3
                ya = 3;
                y = y + ya;
            }
        }
        
        // if a collision is detected increase life counter
        if (game.collision()){
            // increase life counter
            count++;
            // call game over to load next image or to close game
            game.gameOver(count);
        } 
    } 
    
    // returns a rectangle with the dimensions of our image for collision
    public Rectangle getBounds(){
        return new Rectangle(x, y, w, w);
    } 
    
    // key listener for reseting x acceleration on key release
    public void keyReleased(KeyEvent e){
        // if A or D released
        if (e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_D){
            xa = 0;
        } 
    } 
    
    // key listener for setting x velocity on key presses
    public void keyPressed(KeyEvent e) throws FileNotFoundException, IOException, InterruptedException{
        
        // if A pressed go backward
        if (e.getKeyCode() == KeyEvent.VK_A){
            xa = -3;
        }
        // if D pressed go forward
        if (e.getKeyCode() == KeyEvent.VK_D){
            xa = 3;
        }
        // if W pressed jump
        if (e.getKeyCode() == KeyEvent.VK_W){
            ya = -3;
            
            // string containing the filepath of the sound
            String soundname = "G:\\Fall 2019\\IST 311\\project\\swampsimulator\\assets\\audio\\brrringheh.wav";
            
            // new input stream for game over sound
            InputStream in = new FileInputStream(soundname);
            // new audio stream with the input stream as parameter
            AudioStream audioStream = new AudioStream(in);
            //starts the audio output
            AudioPlayer.player.start(audioStream);
            // sleep to be able to hear the audio (I did read this from a blog online, unknown if necessary)
            Thread.sleep(1);
        } 
    } 
}
