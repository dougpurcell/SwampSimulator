/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swampsimulator;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

/**
 *
 * @author Cammy
 */
public class Player{
    private static final int DIAMETER = 30;
    int x = 100;
    int y = 500;
    int xa = 0;
    int ya = 0;
    int count = 0;
    private Game game;
    public Player(Game game){
        this.game = game;
        System.out.println("New player");
    }
    
    public void paint(Graphics2D g){
        //character art go here
        g.fillOval(x, y, DIAMETER, DIAMETER);
        System.out.println("x: " + x + " xa: " + xa + " y: " + y + " ya: " + ya);
        
    }
    void move(){
        
        if (x + xa > 0 && x + xa < 1280-DIAMETER){
            x = x + xa;
        }
        
        if (y + ya > 0 && y + ya < 500){
            if (y > 300){
                y = y + ya;
            } else{
                ya = 3;
                y = y + ya;
            }
            
            
        }
        if (game.collision()){
            count++;
            game.gameOver(count);
        } // end collsion
    } // end move
    
    
    public Rectangle getBounds(){
        
        return new Rectangle(x, y, DIAMETER, DIAMETER);
    } // end getBounds
    
    public void keyReleased(KeyEvent e){

        if (e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_D){
            xa = 0;
        } // end if
    } // end keyReleased
    
    public void keyPressed(KeyEvent e){
    
        if (e.getKeyCode() == KeyEvent.VK_A){
            xa = -3;
        }
        if (e.getKeyCode() == KeyEvent.VK_D){
            xa = 3;
        }
        if (e.getKeyCode() == KeyEvent.VK_W){
            
            ya = -3;
        } //end if
    } // end keyPressed
}
