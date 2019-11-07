/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swampsimulator;

import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 *
 * @author Cammy
 */
public class badGuy {
    int x = 1300;
    private static final int y = 380;
    private static final int WIDTH = 30;
    private static final int HEIGHT = 150;
    
    private Game game;
    
    public badGuy(Game game) {
        this.game = game;
    }
    
    void move(){
        
        x = x - 4;
        
        if (x < 0){
            x = 1300;
        }
        
    }
    
    public void paint(Graphics2D g) {
        g.fillRect(x, y, WIDTH, HEIGHT);
        g.drawLine(0, 530, 1280, 530);
    }
    
    public Rectangle getBounds() {
        return new Rectangle(x, y, WIDTH, HEIGHT);
    }

    public int getTopY(){
        return y;
    }
}
