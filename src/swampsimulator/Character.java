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

        for(int i = 1; i <= 12; i++) { // TODO: Fake DB; with db would be something like length of array of DB objects
            BufferedImage thumbnail = ImageIO.read(new File("assets/img/shrekmoviethumb.jpg")); // swap to link from database, based on location.

            itemButton = new JButton( new ImageIcon(thumbnail));
            itemButton.setBorder(BorderFactory.createEmptyBorder());
            itemButton.setSize(100, 100);
            itemButton.addActionListener(this);
            itemButton.setLocation(100,100);
            add(itemButton);
        }
        setVisible(true);
    }

    public void openPopup() throws IOException {
        // TODO: arrangement styling weirdly not doing the right stuff.
        popup = new JFrame();
        popup.setSize(650,400);
        popup.setLocation(400,400);
        popup.setTitle("Adventure Popup");

        JPanel p = new JPanel();
        p.setSize(650,400);
        p.setVisible(true);

        BufferedImage pThumb = ImageIO.read(new File("assets/img/shrekmoviethumb.jpg")); // TODO: swap to link from database, based on location.

        chrImage = new JLabel(new ImageIcon(pThumb));
        chrImage.setSize(200,200);
        chrImage.setLocation(10,10);
        p.add(chrImage);

        chrtitle = new JLabel("Shrek"); // swap to link from database, based on location.
        chrtitle.setFont(new Font("Helvetica", Font.PLAIN, 30));
        chrtitle.setForeground(new java.awt.Color(198,213,136));
        chrtitle.setSize(100,30);
        chrtitle.setLocation(250,50);
        p.add(chrtitle);

        chrdescription = new JTextArea("longer description of adventure. this is some really interesting stuff.");// swap to link from database, based on location.
        chrdescription.setFont(new Font("Helvetica", Font.PLAIN, 14));
        chrdescription.setLineWrap(true);
        chrdescription.setWrapStyleWord(true);
        chrdescription.setSize(50, 50);
        chrdescription.setLocation(250,100);
        p.add(chrdescription);

        chraddToCart = new JButton("Add To Cart");
        chraddToCart.setSize(25,25);
        chraddToCart.setFont(new Font("Helvetica", Font.PLAIN, 14));
        chraddToCart.setBackground(Color.gray);
        chraddToCart.setLocation(250,300);
        chraddToCart.addActionListener(this);
        p.add(chraddToCart);

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
        if (source == chrImage) {
            // TODO: add event for adding item to Order Class.

            closePopup();
            gui.changePanel("character", "order");
        }
        repaint();
    }

}
