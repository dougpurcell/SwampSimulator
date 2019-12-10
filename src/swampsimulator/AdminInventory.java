package swampsimulator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdminInventory extends JPanel implements ActionListener {
    protected SwampSimulator gui;

    private JLabel title;

    public AdminInventory(SwampSimulator ss) {
        gui = ss;

        setBackground(Color.WHITE);
        setSize(1200,800);

        title = new JLabel("Welcome Admin");
        title.setFont(new Font("Shrek", Font.PLAIN, 30));
        title.setForeground(new java.awt.Color(198,213,136));
        title.setSize(800, 30);
        title.setLocation(30, 20);
        add(title);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
//        if (source == ) {
//            gui.changePanel("login", "adventure");
//        }
        repaint();
    }
}
