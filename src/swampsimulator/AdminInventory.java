package swampsimulator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdminInventory extends JPanel implements ActionListener {
    protected SwampSimulator gui;

    private JLabel title;
    private JButton invBut = new JButton("inventory");
    private JButton ordBut = new JButton("orders");
    private JButton chartBut = new JButton("charts");
    private JTable table;
    private JTable ordTable;
    private JPanel invPanel;
    private JPanel ordPanel;
    
public AdminInventory(SwampSimulator ss) {
        // assigns the jframe we're in
        gui = ss;
        
        // sets panel background color and size
        setBackground(Color.GRAY);
        setSize(1200,800);
        
        // sets layout config for main jpanel
        setLayout(new BorderLayout());
        
        // title formatting stuff
        title = new JLabel("Welcome Admin");                    // setting title
        title.setFont(new Font("Shrek", Font.PLAIN, 30));       // setting font
        title.setForeground(new java.awt.Color(198,213,136));   // setting color
        title.setSize(800, 30);                                 // setting size
        title.setHorizontalAlignment(JLabel.CENTER);            // setting alignment
        add(title, BorderLayout.PAGE_START);                         // adding to the panel
        
        //holding panel for our buttons
        JPanel holder = new JPanel(new FlowLayout(FlowLayout.CENTER));
        
        // inventory formatting
        invBut.setFont(new Font("Shrek", Font.PLAIN, 30));      // setting font
        invBut.setBackground(new java.awt.Color(198,213,136));  // setting color
        invBut.addActionListener(this);                         // adding action listener
        holder.add(invBut);                                     // adding to holding panel
        
        ordBut.setFont(new Font("Shrek", Font.PLAIN, 30));      // setting font
        ordBut.setBackground(new java.awt.Color(198,213,136));  // setting color
        ordBut.addActionListener(this);                         // adding action listener   
        holder.add(ordBut);                                     // adding to holding panel
        
        chartBut.setFont(new Font("Shrek", Font.PLAIN, 30));    // setting font
        chartBut.setBackground(new java.awt.Color(198,213,136));// setting color
        chartBut.addActionListener(this);                       // adding action listener
        holder.add(chartBut);                                   // adding to holding panel
        
        invChart();
        ordChart();
             
        
        // adds holding panel to main panel
        add(holder, BorderLayout.PAGE_END);
//        add(invChart(), BorderLayout.LINE_START);
        add(ordPanel, BorderLayout.CENTER);
        
    }

public void invChart(){
    
    // column names for table
    String[] columnNames = {"Type","Title","Price","Description","Thumbnail","Game Image","Stock"};
    
    // information for table needs to be pumped from database
    Object[][] data = {
        {"Adventure","Shrek 1","100","idk man","some filepath","some other filepath","1"},
        {"Character","Shrek","100","ya boi","some new filepath","idk anymore", "3"},
        {"Adventure","Shrek 1","100","idk man","some filepath","some other filepath","1"},
        {"Character","Shrek","100","ya boi","some new filepath","idk anymore", "3"},
        {"Adventure","Shrek 1","100","idk man","some filepath","some other filepath","1"},
        {"Character","Shrek","100","ya boi","some new filepath","idk anymore", "3"},
        {"Adventure","Shrek 1","100","idk man","some filepath","some other filepath","1"},
        {"Character","Shrek","100","ya boi","some new filepath","idk anymore", "3"},
        {"Adventure","Shrek 1","100","idk man","some filepath","some other filepath","1"},
        {"Character","Shrek","100","ya boi","some new filepath","idk anymore", "3"},
        {"Adventure","Shrek 1","100","idk man","some filepath","some other filepath","1"},
        {"Character","Shrek","100","ya boi","some new filepath","idk anymore", "3"},
        {"Adventure","Shrek 1","100","idk man","some filepath","some other filepath","1"},
        {"Character","Shrek","100","ya boi","some new filepath","idk anymore", "3"},
        {"Adventure","Shrek 1","100","idk man","some filepath","some other filepath","1"},
        {"Character","Shrek","100","ya boi","some new filepath","idk anymore", "3"}
    };
    invPanel = new JPanel();
    invPanel.setSize(800,600);
    table = new JTable(data, columnNames);
    
    invPanel.add(table);
    
    
    
}

public void ordChart(){
    
    // column names for table
    String[] columnNames = {"Type","Title","Price","Description","Thumbnail","Game Image","Stock"};
    
    // information for table needs to be pumped from database
    Object[][] data = {
        {"Adventure","Shrek 1","100","idk man","some filepath","some other filepath","1"},
        {"Character","Shrek","100","ya boi","some new filepath","idk anymore", "3"}
        
    };
    ordPanel = new JPanel();
    ordPanel.setBackground(Color.red);
    ordPanel.setSize(800,600);
    ordTable = new JTable(data, columnNames);
    
    ordPanel.add(ordTable);
    
    
}

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == invBut) {
//            gui.changePanel("login", "adventure");\
//            remove(ordPanel);
            if (ordPanel.isVisible()){
                remove(ordPanel);
            }
            add(invPanel, BorderLayout.CENTER);
            
            System.out.println("inventory");
        } else if (source == ordBut) {
            if (invPanel.isVisible()){
                remove(invPanel);
            }
            add(ordPanel, BorderLayout.CENTER);
            System.out.println("order");
        } else if (source == chartBut){
            System.out.println("chart");
        }
        repaint();
    }

}
