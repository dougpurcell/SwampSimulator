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

class Character extends JFrame implements ActionListener{

    protected JButton itemButton;
    SwampSimulator ss = new SwampSimulator();


    public Character() throws IOException {

        ss.setBackground(new Color(245, 245, 245));

        int i = 1;

        while (i <= 12) { // Fake DB; with db would be something like length of array of DB objects

            BufferedImage buttonIcon = ImageIO.read(new File("assets/img/shrekmoviethumb.jpg")); // Fake DB, should pull from array of DB Objects
            itemButton = new JButton(new ImageIcon(buttonIcon));
            itemButton.setBorder(BorderFactory.createEmptyBorder());
            itemButton.setSize(200, 200);
            itemButton.setContentAreaFilled(false);
            itemButton.addActionListener(this);

            ss.add(itemButton);

            ++i;
// TODO: BUG: only last button is clickable. all buttons need to be clickable.
        }

        FlowLayout itemGrid = new FlowLayout(FlowLayout.LEFT);
        ss.setLayout(itemGrid);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == itemButton) {
            // fix
//            ss.add();
            System.out.println("cmon doug");

        }
        repaint();
    }
    
}
