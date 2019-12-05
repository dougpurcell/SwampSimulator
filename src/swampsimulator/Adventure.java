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

class Adventure extends JPanel implements ActionListener{

    protected JButton itemButton;
    protected SwampSimulator gui;


    public Adventure(SwampSimulator ss) throws IOException {

        gui = ss;

        setBackground(new Color(245, 245, 245));
        setSize(1200,800);
        setPreferredSize(new Dimension(1200,800));
        setLocation(10,10);

        for(int i = 1; i <= 6; i++) { // Fake DB; with db would be something like length of array of DB objects
            BufferedImage buttonIcon = ImageIO.read(new File("assets/img/shrekmoviethumb.jpg"));

            itemButton = new JButton( new ImageIcon(buttonIcon));
            itemButton.setBorder(BorderFactory.createEmptyBorder());
            itemButton.setSize(200, 200);
            //itemButton.setContentAreaFilled(false);
            itemButton.addActionListener(this);
            add(itemButton);

        }

        GridLayout itemGrid = new GridLayout(2,3, 10,10);
        setLayout(itemGrid);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == itemButton) {
            gui.changePanel("adventure", "advpanel");

        }
        repaint();
    }
    
}
