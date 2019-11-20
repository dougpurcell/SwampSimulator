package swampsimulator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ItemPanel extends JPanel {

//    Container itemPanel;
//    JLabel itemName = new JLabel("doug");
//    JLabel itemDescription = new JLabel("What the devil. You can't make a mistake. Anything that happens you can learn to use - and make something beautiful out of it. Let's do it again then, what the heck. We might as well make some Almighty mountains today as well, what the heck.");
//    JLabel price = new JLabel("91");
//    JButton addToCart = new JButton("Add To Cart");
//    JButton backToSelect = new JButton("Back");

    public ItemPanel() {

        // TODO make into frame, on add to cart, set visible to close.
        //

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