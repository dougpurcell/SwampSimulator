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
import java.util.ArrayList;
import java.util.Arrays;
import javax.imageio.ImageIO;

/**
 *
 * @author dougles
 */

public class Adventure extends JPanel implements ActionListener {

    protected SwampSimulator gui;
    private JButton itemButton;
    
    Database myDB = new Database();
    AdventureRecord[] queryData = myDB.getQueryData();

    JFrame popup;
    protected JLabel ptitle;
    protected JTextArea pdescription;
    protected JButton paddToCart;
    
private JButton advgame[] = new JButton[6];

    public Adventure(SwampSimulator ss) throws IOException {

        System.out.print(Arrays.toString(queryData));

        gui = ss;

        setBackground(new Color(245, 245, 245));
        setSize(800,800);


            ArrayList<JButton> buttonList = new ArrayList<JButton>();

        for(int i = 0; i < 6; i++) {
             BufferedImage thumbnail = ImageIO.read(new File("assets/img/adventures/shrek.png"));
             advgame[i] = new JButton("");
            itemButton = new JButton( new ImageIcon(thumbnail));
            itemButton.setBorder(BorderFactory.createEmptyBorder());
            itemButton.setSize(200, 200);
            itemButton.addActionListener(this);
            itemButton.setLocation(200,200);
            add(itemButton);
            buttonList.add(itemButton);
        }
        advgame[0] = buttonList.get(0);
        advgame[1] = buttonList.get(1);
        advgame[2] = buttonList.get(2);
        advgame[3] = buttonList.get(3);
        advgame[4] = buttonList.get(4);
        advgame[5] = buttonList.get(5);
        
        for (int i = 0; i < advgame.length; i++)
        {
            System.out.println(queryData[i].getAdName());
            advgame[i].setText(queryData[i].getAdName());
        }
        
        setVisible(true);

    }

    public void openPopup() throws IOException {
    // TODO: arrangement styling weirdly not doing the right stuff.
        popup = new JFrame("Adventure Popup");
        popup.setSize(400,400);
        popup.setLocation(750,300);
        JPanel p = new JPanel();

        ptitle = new JLabel("Shrek"); // swap to link from database, based on location.
        ptitle.setFont(new Font("Helvetica", Font.PLAIN, 30));
        ptitle.setForeground(new java.awt.Color(198,213,136));
        ptitle.setSize(100,30);
        ptitle.setLocation(100,50);
        popup.add(ptitle);

        pdescription = new JTextArea("longer description of adventure. this is some really interesting stuff.");// swap to link from database, based on location.
        pdescription.setFont(new Font("Helvetica", Font.PLAIN, 14));
        pdescription.setLineWrap(true);
        pdescription.setWrapStyleWord(true);
        pdescription.setSize(250, 50);
        pdescription.setLocation(100,100);
        popup.add(pdescription);

        paddToCart = new JButton("Add To Cart");
        paddToCart.setSize(125,50);
        paddToCart.setFont(new Font("Helvetica", Font.PLAIN, 14));
        paddToCart.setBackground(Color.gray);
        paddToCart.setLocation(100,175);
        paddToCart.addActionListener(this);
        popup.add(paddToCart);

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
