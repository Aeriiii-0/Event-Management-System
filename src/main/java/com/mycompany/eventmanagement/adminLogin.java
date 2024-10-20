package com.mycompany.eventmanagement;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class adminLogin extends JFrame {

    private JLabel lblTitle, lblUsername, lblPassword;
    private JTextField tfUsername;
    private JPasswordField pfPassword;
    private JButton btnLogin;

    adminLogin() {
        // JFrame properties
        setTitle("Admin Log-in");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);
        setSize(1024, 576);
        setLocationRelativeTo(null);  
        setVisible(true);

        // Panel for the top bar (light purple background)
        JPanel topPanel = new JPanel();
        topPanel.setBackground(new Color(209, 166, 232)); 
        topPanel.setBounds(0, 0, 1024, 65);
        topPanel.setLayout(null);
        add(topPanel);

        // Title label "Admin Log-in"
        lblTitle = new JLabel("Admin Log-in", SwingConstants.CENTER);
        lblTitle.setForeground(Color.WHITE);
        lblTitle.setFont(new Font("Serif", Font.BOLD, 25));
        lblTitle.setBounds(-50, 5, 400, 50);  
        topPanel.add(lblTitle);

        // Username label
        lblUsername = new JLabel("Username:");
        lblUsername.setForeground(Color.WHITE);
        lblUsername.setFont(new Font("Serif", Font.PLAIN, 30));  
        lblUsername.setBounds(100, 130, 200, 40);  
        add(lblUsername);

        // Username text field
        tfUsername = new JTextField();
        tfUsername.setBackground(new Color(199, 138, 217));
        tfUsername.setBounds(330, 130, 550, 40);  
        tfUsername.setFont(new Font("Serif", Font.PLAIN, 20)); 
        add(tfUsername);

        // Password label
        lblPassword = new JLabel("Password:");
        lblPassword.setForeground(Color.WHITE);
        lblPassword.setFont(new Font("Serif", Font.PLAIN, 30));  // Larger font
        lblPassword.setBounds(100, 220, 200, 40);
        add(lblPassword);

        // Password field 
        pfPassword = new JPasswordField();
        pfPassword.setBackground(new Color(199, 138, 217));
        pfPassword.setBounds(330, 220, 550, 40);
        pfPassword.setFont(new Font("Serif", Font.PLAIN, 20));
        add(pfPassword);

        // Log-in button without rounded corners
        btnLogin = new JButton("Log-in");
        btnLogin.setFont(new Font("Serif", Font.BOLD, 30));  // Larger button text
        btnLogin.setBackground(new Color(179, 32, 255));  // Dark purple
        btnLogin.setForeground(Color.WHITE);    
        btnLogin.setBounds(400, 400, 200, 60);  // Center button
        btnLogin.setFocusPainted(false);  // Remove focus outline
        btnLogin.setContentAreaFilled(false);  // Important to make sure rounded button is visible
        btnLogin.setBorderPainted(false);
        btnLogin.setFocusPainted(false);
        add(btnLogin);

        // Background panel (light purple background)
        JPanel backgroundPanel = new JPanel();
        backgroundPanel.setBackground(new Color(229, 185, 231));  // Light purple
        backgroundPanel.setBounds(0, 0, 1024, 576);
        add(backgroundPanel);

        // Bring components to the front
        lblUsername.setOpaque(false);
        lblPassword.setOpaque(false);
        tfUsername.setOpaque(true);
        pfPassword.setOpaque(true);
        btnLogin.setOpaque(true);  

        // ActionListener button 
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                String username = tfUsername.getText();
                String password = new String(pfPassword.getPassword());

                
                if (username.equals("AdminEVS") && password.equals("evs123")) {
                    
JOptionPane.showMessageDialog(adminLogin.this, "Login Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                 
 JOptionPane.showMessageDialog(adminLogin.this, "Login Failed! Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });  
    }
}


