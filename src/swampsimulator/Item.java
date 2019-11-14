/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swampsimulator;

import javax.swing.*;
import java.awt.*; 
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

/**
 *
 * @author dougles
 */

class Item extends JFrame implements ActionListener{
    protected JPanel item;
    protected JButton button;
    
    public Item() throws IOException {
        SwampSimulator ss = new SwampSimulator();
        ss.setBackground(new java.awt.Color(245, 245, 245));
        
        int i = 1; //Fake DB
        
        while (i <= 6) { // Fake DB
            
        BufferedImage buttonIcon = ImageIO.read(new File("assets/img/shrekmoviethumb.jpg")); // Fake DB
        button = new JButton(new ImageIcon(buttonIcon));  
        button.setBorder(BorderFactory.createEmptyBorder());
        button.setSize(50, 50);
        button.setContentAreaFilled(false);
        ss.add(button);
        
        ++i;
        
        }
        
        FlowLayout itemgrid = new FlowLayout(FlowLayout.LEFT);
        ss.setLayout(itemgrid);
//        
//        GridLayout grid = new GridLayout(3,3);
//        items.setLayout(grid);
//        while (i < 6) {
//            adventure = new JPanel();
//            adventure.setSize(100, 100);
//            adventure.setLocation(200, 30);
//            adventure.setBackground(Color.green);
//            items.add(adventure);
//            
//            i++;
//        }
       setVisible(true);
    }  
        
        //TODO Work on this too doug. come on man.
     
//    public class Adventure extends Item { 
//    //TODO: work on this Doug    
//       
//    }
//    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
