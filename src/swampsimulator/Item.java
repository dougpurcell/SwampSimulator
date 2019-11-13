/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swampsimulator;

import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*;

/**
 *
 * @author dougles
 */

class Item extends JFrame implements ActionListener{
    private Container items;
    protected String name;
    protected String description;
    protected int price;
    protected String thumbnail;
 
    public Item() {
        setTitle("Swamp Simulator"); 
        setSize(1200,800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        setVisible(true);
    }
    
    
//    public class Adventure extends Item {
//        
//    }
//    
//    public class Character extends Item {
//        
//    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
