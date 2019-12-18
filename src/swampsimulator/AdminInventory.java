package swampsimulator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdminInventory extends JPanel implements ActionListener {
    protected SwampSimulator gui;

    private JLabel title;
    private JButton invBut = new JButton("edit inventory");
    private JButton ordBut = new JButton("orders");
    private JButton chartBut = new JButton("charts");
    private JTable table;
    private JTable ordTable;
    private JPanel invPanel = new JPanel();
    private JPanel ordPanel = new JPanel();
    private JPanel chartView = new JPanel();
    public String[][] charData = new String[12][6];
    
    
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
        
        JPanel cage = new JPanel(new FlowLayout(FlowLayout.CENTER));
        
        // inventory formatting
        invBut.setFont(new Font("Shrek", Font.PLAIN, 30));      // setting font
        invBut.setBackground(new java.awt.Color(198,213,136));  // setting color
        invBut.addActionListener(this);                         // adding action listener
        holder.add(invBut);                                     // adding to holding panel
        
        // order formatting
        ordBut.setFont(new Font("Shrek", Font.PLAIN, 30));      // setting font
        ordBut.setBackground(new java.awt.Color(198,213,136));  // setting color
        ordBut.addActionListener(this);                         // adding action listener   
        holder.add(ordBut);                                     // adding to holding panel
        
        // chart formatting
        chartBut.setFont(new Font("Shrek", Font.PLAIN, 30));    // setting font
        chartBut.setBackground(new java.awt.Color(198,213,136));// setting color
        chartBut.addActionListener(this);                       // adding action listener
        holder.add(chartBut);                                   // adding to holding panel
        
        // init charts
        invChart();
        ordChart();
        chartView();
        
        // add charts to holding pane
        cage.add(invPanel);
        cage.add(ordPanel);
        cage.add(chartView);
        
        // adds holding panel to main panel
        add(holder, BorderLayout.PAGE_END);
        // adds chart holding unit to main panel
        add(cage, BorderLayout.CENTER);
        
    }

// displays inventory chart for admin users, uses getAdminStats from Database class
public void invChart(){
    
    // column names for table
    String[] columnNames = {"Type","Title","Price","Description","Thumbnail","Game Image","Stock"};
    
    // declare / init new database object
    Database db = new Database();
    
    // set panel size
    invPanel.setSize(800,600);
    
    // create table w/ gotten info from database
    table = new JTable(db.getAdminStats(), columnNames);
    
    // add table to the panel
    invPanel.add(new JScrollPane(table));
    
    // hide it
    invPanel.setVisible(false);
}

// displays order chart for admin users, uses getOrderStats from Database class
public void ordChart(){
    
    // column names for table
    String[] columnNames = {"User ID","Date Ordered","Characters","Adventure","Total"};
    
    // declare / init new database object
    Database db = new Database();
    
    // set panel size
    ordPanel.setSize(800,600);
    
    // create table w/ gotten info from database
    ordTable = new JTable(db.getOrderStats(), columnNames);
    
    // add table to the panel
    ordPanel.add(new JScrollPane(ordTable));
    
    // hide it
    ordPanel.setVisible(false);
}

public void chartView(){
    chartView.setBackground(Color.blue);
    chartView.setSize(800,600);
    chartView.setVisible(false);
    
    // declare / init new database object
    Database db = new Database();
    db.getChartData();
}

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        
        // if inventory button
        if (source == invBut) {
            // if order panel is visible
            if (ordPanel.isVisible()){
                // set order view to not visible
                ordPanel.setVisible(false);
            }
            
            // if chart panel is visible
            if (chartView.isVisible()){
                // set chart view to not visible
                chartView.setVisible(false);
            }
            
            // set inventory panel to visible
            invPanel.setVisible(true);
         
        }
        // if order button
        else if (source == ordBut) {
            // if inventory panel is visible
            if (invPanel.isVisible()){
                // set it to not visible
                invPanel.setVisible(false);
            } 
            
            // if chart panel is visible
            if (chartView.isVisible()){
                // set it to not visible
                chartView.setVisible(false);
            }
            
            // set order panel to visible
            ordPanel.setVisible(true);
            
        } 
        // if chart button
        else if (source == chartBut){
            // if inventory panel is visible
            if (invPanel.isVisible()){
                // set it to not visible
                invPanel.setVisible(false);
            } 
            // if order panel is visible
            if (ordPanel.isVisible()){
                // set it to not visible
                ordPanel.setVisible(false);
            }
            
            // set chart panel to visible
            chartView.setVisible(true);
        }
        repaint();
    }

}
