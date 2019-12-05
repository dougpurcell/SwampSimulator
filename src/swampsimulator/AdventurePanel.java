package swampsimulator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

class AdventurePanel extends JFrame implements ActionListener {

    JPanel advPanel = new JPanel();

    private JLabel title;
    private JLabel description;
    protected int price;
    protected JButton addToCart;
    protected JButton backToAdventure;

    public AdventurePanel() throws IOException {
        setSize(650,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        advPanel.setSize(650,400);

        setBackground(new java.awt.Color(253,243,194));
        setSize(600,400);
        setLocation(300,150);

        title = new JLabel("Welcome to Swamp Simulator");
        title.setFont(new Font("Shrek", Font.PLAIN, 30));
        title.setForeground(new java.awt.Color(198,213,136));
        title.setSize(800, 30);
        title.setLocation(30, 20);
        add(title);


        add(advPanel);

        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == addToCart) {

            // TODO: update order, close panel

        }
        repaint();
    }
}
