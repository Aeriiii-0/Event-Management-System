/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.eventmanagementsystemmain;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Nix
 */

// Triggered by the startTimer(), for directing user to user information forms (attendance) during the event.

public class invitationToRegistration extends JFrame implements ActionListener{
     JButton btnEnterEvent;
     
    invitationToRegistration(){

//component settings
      setSize(1000,800);
      setTitle("Venue Venture");
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setResizable(false);
      setLocationRelativeTo(null); 
      setLayout(null);
      
      ImageIcon humpyy = new ImageIcon("C:\\Users\\Nix\\Documents\\NetBeansProjects\\eventManagementSystemMain\\images\\invi.jpg");
      Image humpyy1 = humpyy.getImage().getScaledInstance(1000, 800, Image.SCALE_SMOOTH);
      ImageIcon humpyy2 = new ImageIcon(humpyy1);
      JLabel lblBgFinalh = new JLabel(humpyy2);
      lblBgFinalh.setBounds(0, 0, 1000,800);
      add(lblBgFinalh);
      
      
      btnEnterEvent = new JButton("Exit");
      btnEnterEvent.setBounds(400, 470, 190, 50);
      btnEnterEvent.setForeground(new Color(255, 255, 255));
      btnEnterEvent.setFont(new Font("Serif",Font.BOLD,22));
      btnEnterEvent.setFocusable(false);
      btnEnterEvent.setContentAreaFilled(false);
      btnEnterEvent.addActionListener(this);
      add(btnEnterEvent);
        
      add(lblBgFinalh);
      
      setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    if(e.getSource()==btnEnterEvent){
      JOptionPane.showMessageDialog(null, "The event is done! Thank you for staying with us!");
      System.exit(0);
    }
    }

   
    }
    
    
    

