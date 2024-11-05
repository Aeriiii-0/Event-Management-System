    
package com.mycompany.adminloginmain;

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class adminLogin  extends JFrame{
        
    private JLabel label, userLabel, pwLabel;
    private JTextField userField;
    private JPasswordField pwField;
    private JButton logButton;
    private JPanel panelWholeBg, panelHeadLine, colorLight, colorMild, colorDark;
    
    
    
    adminLogin(){
        setTitle ("Home Page");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);
        setSize (1000, 800);
        setResizable(false);
        
        Color colorLight = new Color (209,159,232);
        Color colorMild = new Color (204,102,255);
        Color colorDark = new Color (204,51,255);
        
        panelWholeBg = new JPanel (null);
        panelWholeBg.setBackground(colorLight);
        panelWholeBg.setBounds(0, 0, 1000, 800);
        
        panelHeadLine = new JPanel (null);
        panelHeadLine.setBackground(colorMild);
        panelHeadLine.setBounds(0,0,1000,170);

        label = new JLabel("Admin: Log In",SwingConstants.CENTER);
        label.setForeground(Color.white);
        label.setFont(new Font("Arial",Font.BOLD,60));
        label.setBounds(0,50,1000,80);
        
        userLabel = new JLabel("Username:");
        userLabel.setBounds(200, 300, 250, 30);
        userLabel.setFont(new Font("Arial",Font.BOLD,30));
        userLabel.setForeground(Color.WHITE);
        
        userField = new JTextField();
        userField.setBackground(colorMild);
        userField.setBounds(500, 290, 250,50);
        userField.setFont(new Font("Arial",Font.BOLD,30));
        userField.setForeground(Color.WHITE);
        
        pwLabel = new JLabel ("Password:");
        pwLabel.setBounds(200,400,250,30);
        pwLabel.setFont(new Font("Arial",Font.BOLD,30));
        pwLabel.setForeground(Color.WHITE);
        
        pwField = new JPasswordField();
        pwField.setBackground(colorMild);
        pwField.setBounds(500, 390,250,50);
        pwField.setFont(new Font("Arial",Font.BOLD,30));
        pwField.setForeground(Color.WHITE);
        
        logButton = new JButton("Log in");
        logButton.setBounds(400,550, 210, 60);
        logButton.setFont(new Font("Arial",Font.BOLD,30));
        logButton.setBackground(colorDark);
        logButton.setForeground(Color.white);
        
        logButton.addActionListener(new ActionListener () {
            public void actionPerformed (ActionEvent e) {
                
                String username = userField.getText();
                String password = new String(pwField.getPassword());
                
                 try {
                     Class.forName("com.mysql.cj.jdbc.Driver");
            
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root", "elweng098*");

            PreparedStatement checkStmt = connection.prepareStatement("SELECT * FROM student WHERE username = ?");
            checkStmt.setString(1, username);
            ResultSet rs = checkStmt.executeQuery();

            if (rs.next()) {
                JOptionPane.showMessageDialog(logButton, "Username already exists. Please choose a different username.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                PreparedStatement insertStmt = connection.prepareStatement("INSERT INTO student (username, password) VALUES (?, ?)");
                insertStmt.setString(1, username);
                insertStmt.setString(2, password);

                int rowsInserted = insertStmt.executeUpdate();
                if (rowsInserted > 0) {
                    JOptionPane.showMessageDialog(logButton, "You have successfully registered in Mysql Database!\n\n\n" + "Entered Username: " + username + "\nEntered Password: " + password + "\n\n\n", "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(logButton, "Registration failed. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
                }

                insertStmt.close();
            }
            
            rs.close();
            checkStmt.close();
            connection.close();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            JOptionPane.showMessageDialog(logButton, "Database Error: " + sqlException.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException cnfException) {
            cnfException.printStackTrace();
            JOptionPane.showMessageDialog(logButton, "MySQL Driver Not Found: " + cnfException.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
});
        panelWholeBg.add(label);
        panelWholeBg.add(panelHeadLine);
        panelWholeBg.add(userLabel);
        panelWholeBg.add(userField);
        panelWholeBg.add(pwLabel);
        panelWholeBg.add(pwField);
        panelWholeBg.add(logButton);
        add(panelWholeBg);
        
        setVisible(true);
    }
    
}
