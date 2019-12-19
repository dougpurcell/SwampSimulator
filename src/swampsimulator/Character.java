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

public class Character extends JPanel implements ActionListener {

    protected SwampSimulator gui;
    
    private static int counter = 0;
    
    private JButton itemButton;

    JFrame popup;
    protected JLabel chrtitle;
    protected JTextArea chrdescription;
    protected JButton chraddToCart;
    protected JLabel chrImage;
    private JLabel price;
    private JButton crButton[] = new JButton[11];
    Database myDB = new Database();
    CharacterRecord[] queryData = myDB.getCrData();
     ArrayList<JButton> buttonList = new ArrayList<JButton>();
     public String[] chrOrderArr = new String[4];
     private int sourceId = 0;

    public Character(SwampSimulator ss) throws IOException {

        gui = ss;
        
        setBackground(new Color(245, 245, 245));
        setSize(800,800);
        Dimension thumbsize = new Dimension(100,100);
        
        //ArrayList<JButton> buttonList = new ArrayList<JButton>();
        
       
        for(int i = 0; i < crButton.length; i++) { // TODO: Fake DB; with db would be something like length of array of DB objects
            
            
            itemButton = new JButton("");
            itemButton.setBorder(BorderFactory.createEmptyBorder());
            itemButton.setMaximumSize(thumbsize);
            itemButton.addActionListener(this);
            itemButton.setLocation(100,100);
            buttonList.add(itemButton);
            add(itemButton);
        }
        setVisible(true);
        
        crButton[0] = buttonList.get(0);
        crButton[1] = buttonList.get(1);
        crButton[2] = buttonList.get(2);
        crButton[3] = buttonList.get(3);
        crButton[4] = buttonList.get(4);
        crButton[5] = buttonList.get(5);
        crButton[6] = buttonList.get(6);
        crButton[7] = buttonList.get(7);
        crButton[8] = buttonList.get(8);
        crButton[9] = buttonList.get(9);
        crButton[10] = buttonList.get(10);
        
        for (int i = 0; i < crButton.length; i++)
        {
            BufferedImage thumbnail = ImageIO.read(new File(queryData[i].getCrImg()));
            ImageIcon icon = new ImageIcon(thumbnail);
            crButton[i].setIcon(icon);
       
        }  
    }

    public void openPopup() throws IOException {
        // TODO: arrangement styling weirdly not doing the right stuff.
        popup = new JFrame("Character Popup");
        popup.setSize(400,400);
        popup.setLocation(750,300);

        JPanel p = new JPanel();

        chrtitle = new JLabel("Shrek"); // swap to link from database, based on location.
        chrtitle.setFont(new Font("Helvetica", Font.PLAIN, 24));
        chrtitle.setForeground(new java.awt.Color(198,213,136));
        chrtitle.setSize(225,30);
        chrtitle.setLocation(100,50);
        popup.add(chrtitle);

        chrdescription = new JTextArea("longer description of adventure. this is some really interesting stuff.");// swap to link from database, based on location.
        chrdescription.setFont(new Font("Helvetica", Font.PLAIN, 14));
        chrdescription.setLineWrap(true);
        chrdescription.setWrapStyleWord(true);
        chrdescription.setSize(250, 100);
        chrdescription.setLocation(100,100);
        popup.add(chrdescription);
        
        price = new JLabel("Price: ");
        price.setSize(100, 30);
        price.setLocation(100,200);
        popup.add(price);
        
        chraddToCart = new JButton("Add To Cart");
        chraddToCart.setSize(125,50);
        chraddToCart.setFont(new Font("Helvetica", Font.PLAIN, 14));
        chraddToCart.setBackground(Color.gray);
        chraddToCart.setLocation(100,250);
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
        if (source == buttonList.get(0)) {
            try {
                openPopup();
                price.setText(String.valueOf("Price: " + queryData[0].getCrValue()));
                chrdescription.setText("Description: " + queryData[0].getCrDesc());
                chrtitle.setText(queryData[1].getCrName());
                sourceId = 0;
                
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        if (source == buttonList.get(1)) {
            try {
                openPopup();
                price.setText(String.valueOf("Price: " + queryData[1].getCrValue()));
                chrdescription.setText("Description: " + queryData[1].getCrDesc());
                chrtitle.setText(queryData[1].getCrName());
                sourceId = 1;
                
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
         if (source == buttonList.get(2)) {
            try {
                openPopup();
                price.setText(String.valueOf("Price: " + queryData[2].getCrValue()));
                chrdescription.setText("Description: " + queryData[2].getCrDesc());
                chrtitle.setText(queryData[2].getCrName());
                sourceId = 2;
                
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
          if (source == buttonList.get(3)) {
            try {
                openPopup();
                price.setText(String.valueOf("Price: " + queryData[3].getCrValue()));
                chrdescription.setText("Description: " + queryData[3].getCrDesc());
                chrtitle.setText(queryData[3].getCrName());
                sourceId = 3;
                
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
           if (source == buttonList.get(4)) {
            try {
                openPopup();
                price.setText(String.valueOf("Price: " + queryData[4].getCrValue()));
                chrdescription.setText("Description: " + queryData[4].getCrDesc());
                chrtitle.setText(queryData[4].getCrName());
                sourceId = 4;
                
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
            if (source == buttonList.get(5)) {
            try {
                openPopup();
                price.setText(String.valueOf("Price: " + queryData[5].getCrValue()));
                chrdescription.setText("Description: " + queryData[5].getCrDesc());
                chrtitle.setText(queryData[5].getCrName());
                sourceId = 5;
                
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
             if (source == buttonList.get(6)) {
            try {
                openPopup();
                price.setText(String.valueOf("Price: " + queryData[6].getCrValue()));
                chrdescription.setText("Description: " + queryData[6].getCrDesc());
                chrtitle.setText(queryData[6].getCrName());
                sourceId = 6;
                
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
              if (source == buttonList.get(7)) {
            try {
                openPopup();
                price.setText(String.valueOf("Price: " + queryData[7].getCrValue()));
                chrdescription.setText("Description: " + queryData[7].getCrDesc());
                chrtitle.setText(queryData[7].getCrName());
                sourceId = 7;
                
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
           if (source == buttonList.get(8)) {
            try {
                openPopup();
                price.setText(String.valueOf("Price: " + queryData[8].getCrValue()));
                chrdescription.setText("Description: " + queryData[8].getCrDesc());
                chrtitle.setText(queryData[8].getCrName());
                sourceId = 8;
                
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
            if (source == buttonList.get(9)) {
            try {
                openPopup();
                price.setText(String.valueOf("Price: " + queryData[9].getCrValue()));
                chrdescription.setText("Description: " + queryData[9].getCrDesc());
                chrtitle.setText(queryData[9].getCrName());
                sourceId = 9;
                
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
             if (source == buttonList.get(10)) {
            try {
                openPopup();
                price.setText(String.valueOf("Price: " + queryData[10].getCrValue()));
                chrdescription.setText("Description: " + queryData[10].getCrDesc());
                chrtitle.setText(queryData[10].getCrName());
                sourceId = 10;
                
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }

        if (source == chraddToCart) {
            // TODO: add event for adding item to Order Class.
            closePopup();
            chrOrderArr[counter] = queryData[sourceId].getCrImg();
            counter++;
        }
        if (counter == 4) {
            gui.changePanel("character", "order");

        }
        
        repaint();
    }
    public String[] getChrOrderArr()
    {
        return chrOrderArr.clone();
    }
}
