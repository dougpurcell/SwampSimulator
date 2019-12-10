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

public class Adventure extends JPanel implements ActionListener {

    protected SwampSimulator gui;

    private JButton itemButton;

    protected JLabel title;
//    protected JLabel description;
//    protected JButton addToCart;
//    protected JButton closePanel;

    JFrame popup;

    public Adventure(SwampSimulator ss) throws IOException {

        gui = ss;

        setBackground(new Color(245, 245, 245));
        setSize(800,800);

        for(int i = 1; i <= 6; i++) { // Fake DB; with db would be something like length of array of DB objects
            BufferedImage thumbnail = ImageIO.read(new File("assets/img/shrekmoviethumb.jpg")); // swap to link from database, based on location.

            itemButton = new JButton( new ImageIcon(thumbnail));
            itemButton.setBorder(BorderFactory.createEmptyBorder());
            itemButton.setSize(200, 200);
            itemButton.addActionListener(this);
            itemButton.setLocation(200,200);
            add(itemButton);

        }

        setVisible(true);

//    adventuresDetails.setSize(600,400);
//
//    title = new JLabel("Shrek"); // swap to link from database, based on location.
//    title.setFont(new Font("Helvetica", Font.PLAIN, 30));
//    title.setForeground(new java.awt.Color(198,213,136));
//    title.setSize(400, 30);
//
//    adventuresDetails.add(title);
//
//    description = new JLabel("longer description of adventure. this is some really interesting stuff."); // swap to link from database, based on location.
//    description.setFont(new Font("Helvetica", Font.PLAIN, 14));
//    adventuresDetails.add(description);

    }

    public void openPopup() {

        popup = new JFrame();
        popup.setSize(400,400);
        popup.setTitle("");
        popup.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == itemButton) {
            System.out.print("worked");
            openPopup();
//            gui.changePanel("adventure", "adminInventory");
//            adventuresDetails.setVisible(true);
        }
        repaint();
    }
    
}
