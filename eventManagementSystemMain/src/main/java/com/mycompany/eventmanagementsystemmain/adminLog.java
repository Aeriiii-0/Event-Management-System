/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.eventmanagementsystemmain;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Nix
 */
public class adminLog extends JFrame implements ActionListener{
    JLabel lblTitle, lblUsername, lblPassword;
    JTextField tfUsername;
    JPasswordField pfPassword;
    JButton btnLogin;
    JPanel pnlHeader,backgroundPanel;
     String username,password;
    adminLog(){
      
        //components
        setTitle("Admin Log-in");
        setSize(1000,800);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(213, 182, 238)); //frame bg color
        
        //title
        lblTitle = new JLabel("Admin Log-in");
        lblTitle.setForeground(new Color(66, 3, 104));
        lblTitle.setFont(new Font("Serif", Font.BOLD, 25));
        lblTitle.setBounds(70, 20, 400, 50);  
        add(lblTitle);
        
        //header/top panel
        pnlHeader=new JPanel();
        pnlHeader.setBounds(0, 0, 1000, 80);
        pnlHeader.setBackground(new Color(190, 140, 229));
        add(pnlHeader);

        // Username label
        lblUsername = new JLabel("Username:");
        lblUsername.setFont(new Font("Serif", Font.BOLD, 25));  
        lblUsername.setForeground(new Color(66, 3, 104));
        lblUsername.setBounds(160, 240, 200, 40);
        add(lblUsername);

        // Username text field
        tfUsername = new JTextField();
        tfUsername.setBackground(new Color(213, 182, 238));
        tfUsername.setForeground(new Color(66, 3, 104));
        tfUsername.setBounds(380, 240, 450, 40); 
        tfUsername.setFont(new Font("Serif", Font.BOLD, 20)); 
        add(tfUsername);

        // Password label
        lblPassword = new JLabel("Password:");
        lblPassword.setFont(new Font("Serif", Font.BOLD, 25));  // Larger font
        lblPassword.setForeground(new Color(66, 3, 104));
        lblPassword.setBounds(160, 340, 300, 40);
        add(lblPassword);

        // Password field 
        pfPassword = new JPasswordField();
        pfPassword.setBackground(new Color(213, 182, 238));
        pfPassword.setBounds(380, 340, 450, 35);
        pfPassword.setFont(new Font("Serif", Font.BOLD, 20));
        pfPassword.setForeground(new Color(66, 3, 104));
        add(pfPassword);

      
        btnLogin = new JButton("Log-in");
        btnLogin.setFont(new Font("Serif", Font.BOLD, 25));  // Larger button text
        btnLogin.setBackground(new Color(158, 77, 208));  // Dark purple   
        btnLogin.setForeground(new Color(228, 206, 243));
        btnLogin.setBounds(400, 500, 200, 45);  // Center button
        btnLogin.setFocusPainted(false);  // Remove focus outline
        btnLogin.setBorderPainted(false);
        add(btnLogin);
        btnLogin.addActionListener(this);
        
        backgroundPanel = new JPanel();
        backgroundPanel.setBackground(new Color(190, 140, 229));  
        backgroundPanel.setBounds(100,150 , 800, 500);
        add(backgroundPanel);
        
        
        setVisible(true);
    }
    
     public void actionPerformed(ActionEvent e) {
     if(e.getSource()==btnLogin){  
       username = tfUsername.getText();
       password = new String(pfPassword.getPassword());
       
       if (username.isEmpty() || password.isEmpty()) {
        JOptionPane.showMessageDialog(adminLog.this, "Please input all required fields!", "Error", JOptionPane.ERROR_MESSAGE);
        
    } else if (username.equals("AdminEVS") && password.equals("evs123")) {
        JOptionPane.showMessageDialog(adminLog.this, "Login Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
        new adminFrameGeneral();
     
    } else {
        JOptionPane.showMessageDialog(adminLog.this, "Wrong Password/Username. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
    }
                      
 
}}}

