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

public class Character extends JPanel implements ActionListener {

    protected SwampSimulator gui;
    
    private static int counter = 0;

    private JButton itemButton;

    JFrame popup;
    protected JLabel chrtitle;
    protected JTextArea chrdescription;
    protected JButton chraddToCart;
    protected JLabel chrImage;

    public Character(SwampSimulator ss) throws IOException {

        gui = ss;

        setBackground(new Color(245, 245, 245));
        setSize(800,800);
        Dimension thumbsize = new Dimension(100,100);
        for(int i = 1; i <= 12; i++) { // TODO: Fake DB; with db would be something like length of array of DB objects
            BufferedImage thumbnail = ImageIO.read(new File("assets/img/characters/donkey.png")); // swap to link from database, based on location.

            itemButton = new JButton( new ImageIcon(thumbnail));
            itemButton.setBorder(BorderFactory.createEmptyBorder());
            itemButton.setMaximumSize(thumbsize);
            itemButton.addActionListener(this);
            itemButton.setLocation(100,100);
            add(itemButton);
        }
        setVisible(true);
    }

    public void openPopup() throws IOException {
        // TODO: arrangement styling weirdly not doing the right stuff.
        popup = new JFrame("Character Popup");
        popup.setSize(400,400);
        popup.setLocation(750,300);

        JPanel p = new JPanel();

        chrtitle = new JLabel("Shrek"); // swap to link from database, based on location.
        chrtitle.setFont(new Font("Helvetica", Font.PLAIN, 30));
        chrtitle.setForeground(new java.awt.Color(198,213,136));
        chrtitle.setSize(100,30);
        chrtitle.setLocation(100,50);
        popup.add(chrtitle);

        chrdescription = new JTextArea("longer description of adventure. this is some really interesting stuff.");// swap to link from database, based on location.
        chrdescription.setFont(new Font("Helvetica", Font.PLAIN, 14));
        chrdescription.setLineWrap(true);
        chrdescription.setWrapStyleWord(true);
        chrdescription.setSize(250, 50);
        chrdescription.setLocation(100,100);
        popup.add(chrdescription);

        chraddToCart = new JButton("Add To Cart");
        chraddToCart.setSize(125,50);
        chraddToCart.setFont(new Font("Helvetica", Font.PLAIN, 14));
        chraddToCart.setBackground(Color.gray);
        chraddToCart.setLocation(100,175);
        chraddToCart.addActionListener(this);
        popup.add(chraddToCart);

        popup.add(p);
        popup.setVisible(true);

    }
    public void closePopup(){
        popup.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == itemButton) {
            try {
                openPopup();

            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }

        if (source == chraddToCart) {
            // TODO: add event for adding item to Order Class.
            closePopup();
            counter++;
        }
        if (counter == 4) {
            gui.changePanel("character", "order");

        }
        
        repaint();
    }

}
