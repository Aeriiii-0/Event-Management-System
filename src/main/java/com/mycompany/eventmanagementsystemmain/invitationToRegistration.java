/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.eventmanagementsystemmain;

import java.awt.Image;
import javax.swing.*;

/**
 *
 * @author Nix
 */
public class invitationToRegistration extends JFrame{

// Triggered by the startTimer(), for directing user to user information forms (attendance) during the event 
    
    invitationToRegistration(){

//component settings
    setSize(1000,800);
    setTitle("Venue Venture");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setResizable(false);
    setLocationRelativeTo(null); 
    setLayout(null);

//frame bg 
      ImageIcon humpyy = new ImageIcon("invitation.jpg");
      Image humpyy1 = humpyy.getImage().getScaledInstance(1000, 800, Image.SCALE_SMOOTH);
      ImageIcon humpyy2 = new ImageIcon(humpyy1);
      JLabel lblBgFinalh = new JLabel(humpyy2);
      lblBgFinalh.setBounds(0, 0, 1000,800);
      add(lblBgFinalh);
        
        
    }
    
    
    
}
