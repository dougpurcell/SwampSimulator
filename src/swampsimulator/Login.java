/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swampsimulator;

import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author dougbug
 */

class Login extends JFrame implements ActionListener {
    
    private Container loginContainer;
    private JLabel title; 
    private JLabel user;
    private JTextField username;
    private JLabel pw;
    private JPasswordField password;
    private JButton loginButton;
    
    public Login() {
        setTitle("Swamp Simulator Login"); 
        setBounds(300, 90, 900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        setResizable(false); 
        
        loginContainer = getContentPane(); 
        loginContainer.setLayout(null); 
        loginContainer.setBackground(new java.awt.Color(253,243,194));
        
        title = new JLabel("Welcome to Swamp Simulator"); 
        title.setFont(new Font("Shrek", Font.PLAIN, 30)); 
        title.setForeground(new java.awt.Color(198,213,136));
        title.setSize(800, 30); 
        title.setLocation(200, 30);
        loginContainer.add(title); 
  
        user = new JLabel("Name"); 
        user.setFont(new Font("Helvetica", Font.PLAIN, 14)); 
        user.setSize(100, 20); 
        user.setLocation(100, 100); 
        loginContainer.add(user); 
  
        username = new JTextField(); 
        username.setFont(new Font("Helvetica", Font.PLAIN, 12)); 
        username.setSize(190, 20); 
        username.setLocation(200, 100); 
        loginContainer.add(username);
        
        pw = new JLabel("Password"); 
        pw.setFont(new Font("Helvetica", Font.PLAIN, 14)); 
        pw.setSize(100, 20); 
        pw.setLocation(100, 150); 
        loginContainer.add(pw); 
        
        password = new JPasswordField(); 
        password.setFont(new Font("Helvetica", Font.PLAIN, 12)); 
        password.setSize(190, 20); 
        password.setLocation(200, 150); 
        loginContainer.add(password);
        
        loginButton = new JButton("Log In");
        loginButton.setFont(new Font("Helvetica", Font.PLAIN, 14));
        loginButton.setBackground(new java.awt.Color(198, 213, 136));
        loginButton.setSize(90,35);
        loginButton.setLocation(100,200);
        loginButton.addActionListener(this);
        loginContainer.add(loginButton);

        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == loginButton) {
            try {
                Adventure adventure = new Adventure();
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
            Login.super.dispose();
        }
        
        repaint();
    }
}
