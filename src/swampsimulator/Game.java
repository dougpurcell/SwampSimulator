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
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Cammy
 */
public class Game extends JPanel {
    Player player = new Player(this);
    badGuy badGuy = new badGuy(this);
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
                player.keyPressed(e);
                //throw new UnsupportedOperationException("Not supported yet.");
            }

        });
        setFocusable(true);
        
    }
    
    @Override
    public void paint(Graphics g){
    
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        player.paint(g2d);
        badGuy.paint(g2d);
    }
    public boolean collision() {
        Rectangle r1 = new Rectangle();
        Rectangle r2 = new Rectangle();
        r1 = badGuy.getBounds();
        r2 = player.getBounds();
        return r1.intersects(r2);
    }
    public void gameOver(int count){
        if (count > 3){
            JOptionPane.showMessageDialog(this, "get out o' me swamp!", "Game Over", JOptionPane.YES_NO_OPTION);
            System.exit(ABORT);
        } else{
            player.x = 100;
            player.y = 500;
            badGuy.x = 1280;
        }
    }
    public void move(){
        badGuy.move();
        player.move();
    }
}
