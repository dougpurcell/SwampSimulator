/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swampsimulator;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 *
 * @author Cammy
 */
public class badGuy {
    int x = 1300;
    private static final int y = 380;
    private static final int WIDTH = 30;
    private static final int HEIGHT = 150;
    private Image image;
    private int w, h;
    
    private Game game;
    
    public badGuy(Game game) {
        this.game = game;
        loadImage();
    }
    private void loadImage() {
        
        ImageIcon ii = new ImageIcon("src/gameArt/badguy.png");
        image = ii.getImage(); 
        
        w = image.getWidth(null);
        h = image.getHeight(null);
    }
    void move(){
        
        x = x - 4;
        
        if (x < 0){
            x = 1300;
        }
        
    }
    public Image getImage() {
        
        return image;
    }
    public void paint(Graphics2D g) {
        //g.setColor();
        //g.fillRect(x, y, WIDTH, HEIGHT);
        g.drawImage(getImage(), x, y, game);
        g.drawLine(0, 530, 1280, 530);
    }
    
    public Rectangle getBounds() {
        return new Rectangle(x, y, WIDTH, HEIGHT);
    }

    public int getTopY(){
        return y;
    }
}
