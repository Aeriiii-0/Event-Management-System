
package com.mycompany.adminloginmain;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

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
                char [] password = pwField.getPassword();
                
                if (username.length() > 0 && password.length > 0) {
                    JOptionPane.showMessageDialog(null,"Login Successful","Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Please Enter Valid Accounts", "Error", JOptionPane.ERROR_MESSAGE);
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
