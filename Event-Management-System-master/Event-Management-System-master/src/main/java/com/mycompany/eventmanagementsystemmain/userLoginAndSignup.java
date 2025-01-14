/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.eventmanagementsystemmain;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author Nix
 */
public class userLoginAndSignup  extends JFrame implements ActionListener {
    
    JLabel lblUserTitle, lblUserUsername, lblUserPassword;
    JTextField tfUserUsername;
    JPasswordField pfUserPassword;
    JButton btnUserLogin, btnUserSignup, btnBack;
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
        tfUserUsername.setBorder(BorderFactory.createLineBorder(new Color(66, 3, 104), 2)); 
        tfUserUsername.setForeground(new Color(66, 3, 104));
        tfUserUsername.setBounds(380, 240, 450, 40); 
        tfUserUsername.setFont(new Font("Serif", Font.BOLD, 20)); 
        add(tfUserUsername);

        // Password label
        lblUserPassword = new JLabel("Password:");
        lblUserPassword.setFont(new Font("Serif", Font.BOLD, 25));
        lblUserPassword.setForeground(new Color(66, 3, 104));
        lblUserPassword.setBounds(160, 340, 300, 40);
        add(lblUserPassword);

        // Password field 
        pfUserPassword = new JPasswordField();
        pfUserPassword.setBackground(new Color(213, 182, 238));
        pfUserPassword.setBorder(BorderFactory.createLineBorder(new Color(66, 3, 104), 2)); 
        pfUserPassword.setBounds(380, 340, 450, 35);
        pfUserPassword.setFont(new Font("Serif", Font.BOLD, 20));
        pfUserPassword.setForeground(new Color(66, 3, 104));
        add(pfUserPassword);
        
        
        btnUserSignup = new JButton("Sign-up");
        btnUserSignup.setFont(new Font("Serif", Font.BOLD, 20));    
        btnUserSignup.setForeground(new Color(66, 3, 104));
        btnUserSignup.setBounds(280, 500, 200, 35);  
        btnUserSignup.setContentAreaFilled(false);  
        btnUserSignup.setBorder(BorderFactory.createLineBorder(new Color(66, 3, 104), 3));
        btnUserSignup.setFocusPainted(false);
        add(btnUserSignup);
        btnUserSignup.addActionListener(this);
        
        btnUserLogin = new JButton("Log-in");
        btnUserLogin.setFont(new Font("Serif", Font.BOLD, 20));  
        btnUserLogin.setForeground(new Color(66, 3, 104));
        btnUserLogin.setBounds(530, 500, 200, 35);  
        btnUserLogin.setContentAreaFilled(false);  
        btnUserLogin.setBorder(BorderFactory.createLineBorder(new Color(66, 3, 104), 3));
        btnUserLogin.setFocusPainted(false);
        add(btnUserLogin);
        btnUserLogin.addActionListener(this);
        
        btnBack=new JButton("Back");
        btnBack.setBounds(750, 605, 200, 50);
        btnBack.setFont(new Font("Arial",Font.BOLD,15));
        btnBack.setForeground(new Color(66, 3, 104));
        btnBack.setBorderPainted(false);
        btnBack.setContentAreaFilled(false);
        btnBack.setFocusPainted(false);
        add(btnBack);
        btnBack.addActionListener(this);

        
        backgroundPanel = new JPanel();
        backgroundPanel.setLayout(null);
        backgroundPanel.setBackground(new Color(190, 140, 229));  
        backgroundPanel.setBounds(100,150 , 800, 500);
        add(backgroundPanel);
        
        setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()==btnUserSignup){
           try {
            addInfoToDatabase();
           } catch (SQLException ex) {
               Logger.getLogger(userLoginAndSignup.class.getName()).log(Level.SEVERE, null, ex);
           }
       }    
       else if(e.getSource()==btnUserLogin){
           try {
            checkInfoToDatabase();
           } catch (SQLException ex) {
               Logger.getLogger(userLoginAndSignup.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
       else if(e.getSource()==btnBack){
          new welcomePage(); //back to welcome page
          dispose();
       }
    }

       private void addInfoToDatabase() throws SQLException {
        userUsername = tfUserUsername.getText();
        userPassword = new String(pfUserPassword.getPassword());

        if (userUsername.isEmpty() || userPassword.isEmpty()) {
   JOptionPane.showMessageDialog(this, "Fill all the required fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

         /*To create an account, the system must ensure that each user has its unique identifier/username. Scanning for its existence before inserting the information to the database is a must to
        prevent mixing up information from different users*/
         
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/eventmanagement", "root", "1234")) {
            String verifyUsername = "SELECT * FROM usernamepasswords WHERE username=?";
            try (PreparedStatement verifyStatement = conn.prepareStatement(verifyUsername)) {
                verifyStatement.setString(1, userUsername);

                if (verifyStatement.executeQuery().next()) {
                    JOptionPane.showMessageDialog(this, "The username is taken. Please try another.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }

            //after verifying that data doesn't exist yet, the system can now add the user's information. Hence, they're accounts.
            
            String insertQuery = "INSERT INTO usernamepasswords(username, password) VALUES(?, ?)";
            try (PreparedStatement insertStatement = conn.prepareStatement(insertQuery)) {
                insertStatement.setString(1, userUsername);
                insertStatement.setString(2, userPassword); 
                insertStatement.executeUpdate();
                JOptionPane.showMessageDialog(this, "Congratulations, your account has been created.");
                new userDashboard();
                dispose();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Database error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
       
    private void checkInfoToDatabase() throws SQLException {
        userUsername = tfUserUsername.getText();
        userPassword = new String(pfUserPassword.getPassword());

      if (userUsername.isEmpty() || userPassword.isEmpty()){
          JOptionPane.showMessageDialog(this, "Fill the required fields.", "Error", JOptionPane.ERROR_MESSAGE);
      }
      //Repeating the scanning process. When found, the user exists.
      try(Connection conns= DriverManager.getConnection("jdbc:mysql://localhost/eventmanagement", "root", "1234")){
          String checkUsername="SELECT * FROM usernamepasswords WHERE username=? AND password=?";
          try(PreparedStatement checkStatement= conns.prepareStatement(checkUsername)){
              checkStatement.setString(1, userUsername);
              checkStatement.setString(2, userPassword);
              
              try (ResultSet verified = checkStatement.executeQuery()) {
            if (verified.next()) { 
                JOptionPane.showMessageDialog(this, "Log-in successful. Welcome aboard!", "Information", JOptionPane.PLAIN_MESSAGE);
                new userDashboard();
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Incorrect username or password entered. Please Try again", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
      }}}
    