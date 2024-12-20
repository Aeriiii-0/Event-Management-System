/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.eventmanagementsystemmain;

/**
 *
 * @author USER
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class adminFrameGeneral extends JFrame implements ActionListener {
    
    JButton btnAdd, btnUpdate, btnDelete, btnSearchEvents;
   

        adminFrameGeneral(){
            
  //component settings
        setSize(1000, 800);
        setTitle("Venue Venture");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);

    //buttons without borders
        btnAdd = new JButton("ADD");
        btnAdd.setFont(new Font("Serif", Font.BOLD, 20));
        btnAdd.setBounds(90, 500, 180, 40);
        btnAdd.setForeground(Color.LIGHT_GRAY);
        btnAdd.setFocusable(false);
        btnAdd.setContentAreaFilled(false);
        btnAdd.setOpaque(false);
        btnAdd.setBorderPainted(false);
        btnAdd.setFocusPainted(false);
        btnAdd.addActionListener(this);
        add(btnAdd);

        btnUpdate = new JButton("UPDATE");
        btnUpdate.setFont(new Font("Serif", Font.BOLD, 20));
        btnUpdate.setBounds(290, 500, 180, 40);
        btnUpdate.setForeground(Color.LIGHT_GRAY);
        btnUpdate.setFocusable(false);
        btnUpdate.setContentAreaFilled(false);
        btnUpdate.setOpaque(false);
        btnUpdate.setBorderPainted(false);
        btnUpdate.setFocusPainted(false);
        btnUpdate.addActionListener(this);
        add(btnUpdate);

        btnDelete = new JButton("DELETE");
        btnDelete.setFont(new Font("Serif", Font.BOLD, 20));
        btnDelete.setBounds(490, 500, 180, 40);
        btnDelete.setForeground(Color.LIGHT_GRAY);
        btnDelete.setFocusable(false);
        btnDelete.setContentAreaFilled(false);
        btnDelete.setOpaque(false);
        btnDelete.setBorderPainted(false);
        btnDelete.setFocusPainted(false);
        add(btnDelete);
        btnDelete.addActionListener(this);
        
        btnSearchEvents = new JButton("SEARCH");
        btnSearchEvents.setFont(new Font("Serif", Font.BOLD, 20));
        btnSearchEvents.setBounds(690, 500, 180, 40);
        btnSearchEvents.setForeground(Color.LIGHT_GRAY);
        btnSearchEvents.setFocusable(false);
        btnSearchEvents.setContentAreaFilled(false);
        btnSearchEvents.setOpaque(false);
        btnSearchEvents.setBorderPainted(false);
        btnSearchEvents.setFocusPainted(false);
        add(btnSearchEvents);
        btnSearchEvents.addActionListener(this);
       
   //background image settings
       ImageIcon a1 = new ImageIcon("images/welcomebg.jpg");
       Image a2 = a1.getImage().getScaledInstance(1000, 800, Image.SCALE_SMOOTH);
       ImageIcon a3 = new ImageIcon(a2);
       JLabel lblAdminBg = new JLabel(a3);
       lblAdminBg.setBounds(0, 0, 1000,800);
       add(lblAdminBg);
    

        setVisible(true);
    }

    @Override
public void actionPerformed(ActionEvent e) {
    if (e.getSource() == btnAdd) {
       dispose(); 
        new adminAddEventFinal(); // frame for adding and updating events to database
    } else if (e.getSource() == btnUpdate) {
       dispose();
        new adminAddEventFinal();  
    } else if (e.getSource() == btnDelete){
        dispose();
       new adminSearchAndDelete();  // frame for searching and deleting events or information
    } else if (e.getSource() == btnSearchEvents){
        dispose();
        new adminSearchAndDelete();
    }
}
}

        
     
