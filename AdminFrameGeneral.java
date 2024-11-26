/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.adminframegeneral;

/**
 *
 * @author USER
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminFrameGeneral extends JFrame implements ActionListener {
    
    JButton btnAdd, btnUpdate, btnDelete, btnSearchEvents;
    JLabel lblBackgroundImage;
    
    AdminFrameGeneral(){
        setSize(1000, 800);
        setTitle("Event Venture");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        
        //for add button
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

        //for update button
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

        //for delete button
        btnDelete = new JButton("DELETE");
        btnDelete.setFont(new Font("Serif", Font.BOLD, 20));
        btnDelete.setBounds(490, 500, 180, 40);
        btnDelete.setForeground(Color.LIGHT_GRAY);
        btnDelete.setFocusable(false);
        btnDelete.setContentAreaFilled(false);
        btnDelete.setOpaque(false);
        btnDelete.setBorderPainted(false);
        btnDelete.setFocusPainted(false);
        btnDelete.addActionListener(this);
        add(btnDelete);
       
        //for search button
        btnSearchEvents = new JButton("SEARCH");
        btnSearchEvents.setFont(new Font("Serif", Font.BOLD, 20));
        btnSearchEvents.setBounds(690, 500, 180, 40);
        btnSearchEvents.setForeground(Color.LIGHT_GRAY);
        btnSearchEvents.setFocusable(false);
        btnSearchEvents.setContentAreaFilled(false);
        btnSearchEvents.setOpaque(false);
        btnSearchEvents.setBorderPainted(false);
        btnSearchEvents.setFocusPainted(false);
        btnSearchEvents.addActionListener(this);
        add(btnSearchEvents);
        
        //for background image
        ImageIcon bg = new ImageIcon("welcomebg.jpg");
        Image image = bg.getImage().getScaledInstance(1000, 800, Image.SCALE_SMOOTH);
        ImageIcon bg1 = new ImageIcon(image);
        lblBackgroundImage = new JLabel(bg1);
        lblBackgroundImage.setBounds(0, 0, 1000, 800);
        add(lblBackgroundImage);

        setVisible(true);
    }//constructor ends

    @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == btnAdd) {
                this.dispose();
                new adminAddEventFinal(); //add event class
            } else if (e.getSource() == btnUpdate) {
                this.dispose();
                new adminUpdateEvent(); //update event class  
            } else if (e.getSource() == btnDelete){
                //this.dispose();
                //adminDeleteEvent class
            } else if (e.getSource() == btnSearchEvents){
                //this.dispose();
                //adminSearchEvents class
             }
    }//method ends
}//class ends   

  