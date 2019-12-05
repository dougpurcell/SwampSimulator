/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swampsimulator;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author dougles
 */

class Character extends JPanel implements ActionListener{

    protected JButton itemButton;
    protected SwampSimulator gui;


    public Character(SwampSimulator ss) throws IOException {

        gui = ss;

        setBackground(new Color(245, 245, 245));
        setSize(800,800);
        setPreferredSize(new Dimension(1200,800));
        setLocation(10,10);


        for(int i = 1; i <= 12; i++) { // Fake DB; with db would be something like length of array of DB objects
            BufferedImage buttonIcon = ImageIO.read(new File("assets/img/shrekmoviethumb.jpg"));

            itemButton = new JButton( new ImageIcon(buttonIcon));
            itemButton.setBorder(BorderFactory.createEmptyBorder());
            itemButton.setSize(100, 100);
            itemButton.setContentAreaFilled(false);
            itemButton.addActionListener(this);
            add(itemButton);

        }

        GridLayout itemGrid = new GridLayout(3,4, 10,10);
        setLayout(itemGrid);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == itemButton) {
            gui.changePanel("character", "order");
        }
        repaint();
    }
    
}
