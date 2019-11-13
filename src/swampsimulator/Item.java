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
    private Container items;
    protected String name;
    protected String description;
    protected int price;
 
    public Item() {
        SwampSimulator ss = new SwampSimulator();
//        JPanel Adventure = new JPanel();
        //TODO Work on this too doug. come on man.
    }
     
//    public class Adventure extends Item {
//    //TODO: work on this Doug    
//        public class ImagePanel extends JPanel{
//            private BufferedImage thumbnail;
//            
//            public ImagePanel() {
//                try {                
//                thumbnail = ImageIO.read(new File("/assets/img/shrekmoviethumb.jpg"));
//                } 
//                catch (IOException ex) {
//                    // handle exception...
//                }
//            }
//        @Override
//        protected void paintComponent(Graphics g) {
//            super.paintComponent(g);
//            g.drawImage(thumbnail, 0, 0, this); // see javadoc for more info on the parameters            
//        }
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
