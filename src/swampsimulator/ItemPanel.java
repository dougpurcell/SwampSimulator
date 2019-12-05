package swampsimulator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.*
import java.io.IOException;

class ItemPanel extends JPanel implements ActionListener {

    public ItemPanel() throws IOException {

        JPanel itemPanel = new JPanel();
        JLabel itemName = new JLabel("doug");

        itemPanel.setBounds(100,100,600,400);
        itemPanel.setBackground(new java.awt.Color(253,243,194));
        itemName.setFont(new Font("Shrek", Font.PLAIN, 20));
        itemName.setForeground(new java.awt.Color(198,213,136));
        itemName.setSize(600, 30);
        itemName.setLocation(100, 30);

        itemPanel.add(itemName);
//        itemPanel.add(itemDescription);
//        itemPanel.add(price);
//        itemPanel.add(addToCart);
//        itemPanel.add(backToSelect);

        itemPanel.setVisible(true);
    }
}