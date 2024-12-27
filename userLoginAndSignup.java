/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.eventmanagementsystemmain;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Nix
 */
public class userLoginAndSignup  extends JFrame implements ActionListener {
    
    JLabel lblUserTitle, lblUserUsername, lblUserPassword;
    JTextField tfUserUsername;
    JPasswordField pfUserPassword;
    JButton btnUserLogin;
    JPanel pnlHeader,backgroundPanel;
    String userUsername,userPassword;
    userLoginAndSignup(){
        
        //components
        setTitle("Admin Log-in");
        setSize(1000,800);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(213, 182, 238)); //frame bg color
        
        //title
        lblUserTitle = new JLabel("User Log-in or Sign-up");
        lblUserTitle.setForeground(new Color(66, 3, 104));
        lblUserTitle.setFont(new Font("Serif", Font.BOLD, 25));
        lblUserTitle.setBounds(70, 20, 400, 50);  
        add(lblUserTitle);
        
        //header/top panel
        pnlHeader=new JPanel();
        pnlHeader.setBounds(0, 0, 1000, 80);
        pnlHeader.setBackground(new Color(190, 140, 229));
        add(pnlHeader);

        // Username label
        lblUserUsername = new JLabel("Username:");
        lblUserUsername.setFont(new Font("Serif", Font.BOLD, 25));  
        lblUserUsername.setForeground(new Color(66, 3, 104));
        lblUserUsername.setBounds(160, 240, 200, 40);
        add(lblUserUsername);

        // Username text field
        tfUserUsername = new JTextField();
        tfUserUsername.setBackground(new Color(213, 182, 238));
        tfUserUsername.setForeground(new Color(66, 3, 104));
        tfUserUsername.setBounds(380, 240, 450, 40); 
        tfUserUsername.setFont(new Font("Serif", Font.BOLD, 20)); 
        add(tfUserUsername);

        // Password label
        lblUserPassword = new JLabel("Password:");
        lblUserPassword.setFont(new Font("Serif", Font.BOLD, 25));  // Larger font
        lblUserPassword.setForeground(new Color(66, 3, 104));
        lblUserPassword.setBounds(160, 340, 300, 40);
        add(lblUserPassword);

        // Password field 
        pfUserPassword = new JPasswordField();
        pfUserPassword.setBackground(new Color(213, 182, 238));
        pfUserPassword.setBounds(380, 340, 450, 35);
        pfUserPassword.setFont(new Font("Serif", Font.BOLD, 20));
        pfUserPassword.setForeground(new Color(66, 3, 104));
        add(pfUserPassword);

       
        btnUserLogin = new JButton("Join-in");
        btnUserLogin.setFont(new Font("Serif", Font.BOLD, 25));  
        btnUserLogin.setBackground(new Color(158, 77, 208));    
        btnUserLogin.setForeground(new Color(228, 206, 243));
        btnUserLogin.setBounds(400, 500, 200, 45);  
        btnUserLogin.setFocusPainted(false);  
        btnUserLogin.setBorderPainted(false);
        add(btnUserLogin);
        btnUserLogin.addActionListener(this);
        
        backgroundPanel = new JPanel();
        backgroundPanel.setBackground(new Color(190, 140, 229));  
        backgroundPanel.setBounds(100,150 , 800, 500);
        add(backgroundPanel);
        
        
        setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()==btnUserLogin){
        new  userDashboard();
        dispose();
       }    }
    
    
    
}
