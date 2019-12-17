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

    JFrame popup;
    protected JLabel ptitle;
    protected JTextArea pdescription;
    protected JButton paddToCart;
    protected JLabel pImage;

    public Adventure(SwampSimulator ss) throws IOException {

        gui = ss;

        setBackground(new Color(245, 245, 245));
        setSize(800,800);

        for(int i = 1; i <= 6; i++) { // TODO: Fake DB; with db would be something like length of array of DB objects
            BufferedImage thumbnail = ImageIO.read(new File("assets/img/shrekmoviethumb.jpg")); // swap to link from database, based on location.

            itemButton = new JButton( new ImageIcon(thumbnail));
            itemButton.setBorder(BorderFactory.createEmptyBorder());
            itemButton.setSize(200, 200);
            itemButton.addActionListener(this);
            itemButton.setLocation(200,200);
            add(itemButton);

        }

        setVisible(true);

    }

    public void openPopup() throws IOException {
    // TODO: arrangement styling weirdly not doing the right stuff.
        popup = new JFrame("Adventure Popup");
        popup.setSize(650,400);

        JPanel p = new JPanel();

        BufferedImage pThumb = ImageIO.read(new File("assets/img/shrekmoviethumb.jpg")); // TODO: swap to link from database, based on location.

        ptitle = new JLabel("Shrek"); // swap to link from database, based on location.
        ptitle.setFont(new Font("Helvetica", Font.PLAIN, 30));
        ptitle.setForeground(new java.awt.Color(198,213,136));
        ptitle.setSize(100,30);
        ptitle.setLocation(15,15);
        p.add(ptitle);

        pdescription = new JTextArea("longer description of adventure. this is some really interesting stuff.");// swap to link from database, based on location.
        pdescription.setFont(new Font("Helvetica", Font.PLAIN, 14));
        pdescription.setLineWrap(true);
        pdescription.setWrapStyleWord(true);
        pdescription.setSize(50, 50);
        pdescription.setLocation(250,100);
        p.add(pdescription);

        paddToCart = new JButton("Add To Cart");
        paddToCart.setSize(25,25);
        paddToCart.setFont(new Font("Helvetica", Font.PLAIN, 14));
        paddToCart.setBackground(Color.gray);
        paddToCart.setLocation(250,300);
        paddToCart.addActionListener(this);
        p.add(paddToCart);

        pImage = new JLabel(new ImageIcon(pThumb));
        pImage.setSize(200,200);
        pImage.setLocation(10,10);
        p.add(pImage);
        GridLayout x = new GridLayout(4,2);
        popup.setLayout(x);
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
        if (source == paddToCart) {
            // TODO: add event for adding item to Order Class.

            closePopup();
            gui.changePanel("adventure", "character");
        }
        repaint();
    }
    
}
