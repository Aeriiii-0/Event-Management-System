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
    
    invitationToRegistration(){
        
        setSize(1000,800);
        setTitle("Venue Venture");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null); 
        setLayout(null);
      
      ImageIcon humpyy = new ImageIcon("invitation.jpg");
      Image humpyy1 = humpyy.getImage().getScaledInstance(1000, 800, Image.SCALE_SMOOTH);
      ImageIcon humpyy2 = new ImageIcon(humpyy1);
      JLabel lblBgFinalh = new JLabel(humpyy2);
      lblBgFinalh.setBounds(0, 0, 1000,800);
      add(lblBgFinalh);
        
        
    }
    
    
    
}
