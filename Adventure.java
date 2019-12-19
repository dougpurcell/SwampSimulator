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
    private String sItem;
    Database myDB = new Database();
    AdventureRecord[] queryData = myDB.getQueryData();
    AdventureRecord adInfo;
    JFrame popup;
    protected JLabel ptitle;
    protected JTextArea pdescription;
    protected JButton paddToCart;
    ArrayList<JButton> buttonList = new ArrayList<JButton>();
    private JLabel price;
    public String adOrder;
    private int sourceId = 0;
    
private JButton advgame[] = new JButton[6];

    public Adventure(SwampSimulator ss) throws IOException {

        gui = ss;

        setBackground(new Color(245, 245, 245));
        setSize(800,800);

        for(int i = 0; i < 6; i++) {
             
            advgame[i] = new JButton("");
            itemButton = new JButton("");
            itemButton.setBorder(BorderFactory.createEmptyBorder());
            itemButton.addActionListener(this);
            itemButton.setSize(200, 200);
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
            BufferedImage thumbnail = ImageIO.read(new File(queryData[i].getAdDesc()));
            ImageIcon icon = new ImageIcon(thumbnail);
            advgame[i].setIcon(icon);
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
        ptitle.setSize(175,30);
        ptitle.setLocation(100,50);
        popup.add(ptitle);

        pdescription = new JTextArea("longer description of adventure. this is some really interesting stuff.");// swap to link from database, based on location.
        pdescription.setFont(new Font("Helvetica", Font.PLAIN, 14));
        pdescription.setLineWrap(true);
        pdescription.setWrapStyleWord(true);
        pdescription.setSize(250, 100);
        pdescription.setLocation(100,100);
        pdescription.setEditable(false);
        popup.add(pdescription);

        paddToCart = new JButton("Add To Cart");
        paddToCart.setSize(125,50);
        paddToCart.setFont(new Font("Helvetica", Font.PLAIN, 14));
        paddToCart.setBackground(Color.gray);
        paddToCart.setLocation(100,250);
        paddToCart.addActionListener(this);
        popup.add(paddToCart);
        
        price = new JLabel("Price: ");
        price.setSize(100, 30);
        price.setLocation(100,200);
        popup.add(price);
        
        popup.add(p);
        popup.setVisible(true);

    }
    public void closePopup(){
        popup.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == buttonList.get(0)) {
            try {
                openPopup();
                price.setText(String.valueOf("Price: " + queryData[0].getAdValue()));
                pdescription.setText("Description: " + queryData[0].getAdImg());
                ptitle.setText(queryData[0].getAdName());
                sourceId = 0;
                
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        if(source == buttonList.get(1))
        {
            try {
                openPopup();
                price.setText(String.valueOf("Price: " + queryData[1].getAdValue()));
                pdescription.setText("Description: " + queryData[1].getAdImg());
                ptitle.setText(queryData[1].getAdName());
                sourceId = 1;

            } catch (IOException e1) {
                e1.printStackTrace();
            }
            
        }
        if(source == buttonList.get(2))
        {
            try {
                openPopup();
                price.setText(String.valueOf("Price: " + queryData[2].getAdValue()));
                pdescription.setText("Description: " + queryData[2].getAdImg());
                ptitle.setText(queryData[2].getAdName());
                sourceId = 2;

            } catch (IOException e1) {
                e1.printStackTrace();
            }
            
        }
        if(source == buttonList.get(3))
        {
            try {
                openPopup();
                price.setText(String.valueOf("Price: " + queryData[3].getAdValue()));
                pdescription.setText("Description: " + queryData[3].getAdImg());
                ptitle.setText(queryData[3].getAdName());
                sourceId = 3;

            } catch (IOException e1) {
                e1.printStackTrace();
            }
            
        }
        if(source == buttonList.get(4))
        {
            try {
                openPopup();
                price.setText(String.valueOf("Price: " + queryData[4].getAdValue()));
                pdescription.setText("Description: " + queryData[4].getAdImg());
                ptitle.setText(queryData[4].getAdName());
                sourceId = 4;

            } catch (IOException e1) {
                e1.printStackTrace();
            }
            
        }
        if(source == buttonList.get(5))
        {
            try {
                openPopup();
                price.setText(String.valueOf("Price: " + queryData[5].getAdValue()));
                pdescription.setText("Description: " + queryData[5].getAdImg());
                ptitle.setText(queryData[5].getAdName());
                sourceId = 5;

            } catch (IOException e1) {
                e1.printStackTrace();
            }
            
        }
        
       
        if (source == paddToCart) {
            // TODO: add event for adding item to Order Class.

            closePopup();
            adOrder = queryData[sourceId].getAdImg();
            gui.changePanel("adventure", "character");
        }
        repaint();
    }
    public String getAdOrder()
    {
        return adOrder;
    }
}
