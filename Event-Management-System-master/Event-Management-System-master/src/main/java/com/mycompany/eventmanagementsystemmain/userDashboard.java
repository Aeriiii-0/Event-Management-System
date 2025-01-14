/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.eventmanagementsystemmain;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Nix
 */
public class userDashboard extends JFrame implements ActionListener{

 JLabel lblHeader2;
 JButton btnMyEvent, btnScheduleEvent, btnAvailableEvents, btnAboutUs,btnLogOut;


    userDashboard (){    
    //component settings
    setSize(1000, 800);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(null);
    setResizable(false);
    getContentPane().setBackground(new Color(244, 187, 255));

    lblHeader2 = new JLabel("WELCOME TO EVENT VENTURE");
    lblHeader2.setFont(new Font("Serif",Font.BOLD,30));
    lblHeader2.setForeground(new Color(	138, 1, 124));
    lblHeader2.setBounds(55, 55, 500, 40);

    JPanel pnlCenter = new JPanel();
    pnlCenter.setLayout(null);
    pnlCenter.setBounds(185, 200, 600, 150);  
    pnlCenter.setBackground(new Color(213, 155, 207));
    pnlCenter.setBorder(BorderFactory.createLineBorder(new Color(138, 1, 124), 3));
    add(pnlCenter);
    pnlCenter.add(lblHeader2);
    
    btnMyEvent=new JButton("My Event");
    btnMyEvent.setFont(new Font("Serif",Font.BOLD,20));
    btnMyEvent.setFocusable(false);
    btnMyEvent.setBackground(new Color(213, 155, 207));
    btnMyEvent.setBounds(100, 420, 250, 50);
    btnMyEvent.setForeground(new Color(	138, 1, 124));
    btnMyEvent.setBorder(BorderFactory.createLineBorder(new Color(	138, 1, 124), 3));
    btnMyEvent.setFocusPainted(false);
    btnMyEvent.addActionListener(this);
    add(btnMyEvent);
    
    btnScheduleEvent=new JButton("Schedule Event");
    btnScheduleEvent.setFont(new Font("Serif",Font.BOLD,20));
    btnScheduleEvent.setFocusable(false);
    btnScheduleEvent.setBackground(new Color(213, 155, 207));
    btnScheduleEvent.setBounds(370, 420, 250, 50);
    btnScheduleEvent.setForeground(new Color(	138, 1, 124));
    btnScheduleEvent.setBorder(BorderFactory.createLineBorder(new Color(	138, 1, 124), 3));
    btnScheduleEvent.setFocusPainted(false);
    btnScheduleEvent.addActionListener(this);
    add(btnScheduleEvent);
    
    btnAboutUs=new JButton("About Us");
    btnAboutUs.setFont(new Font("Serif",Font.BOLD,20));
    btnAboutUs.setFocusable(false);
    btnAboutUs.setBackground(new Color(213, 155, 207));
    btnAboutUs.setBounds(640, 420, 250, 50);
    btnAboutUs.setForeground(new Color(	138, 1, 124));
    btnAboutUs.setBorder(BorderFactory.createLineBorder(new Color(	138, 1, 124), 3));
    btnAboutUs.setFocusPainted(false);
    btnAboutUs.addActionListener(this);
    add(btnAboutUs);
    
    btnLogOut=new JButton("Log-out");
    btnLogOut.setBounds(840, 700, 200, 50);
    btnLogOut.setFont(new Font("Arial",Font.BOLD,13));
    btnLogOut.setForeground(new Color(138, 1, 124));
    btnLogOut.setBorderPainted(false);
    btnLogOut.setContentAreaFilled(false);
    btnLogOut.setFocusPainted(false);
    add(btnLogOut);
    btnLogOut.addActionListener(this);

    
    ImageIcon a1 = new ImageIcon("images/userbg7.jpg");
    Image a2 = a1.getImage().getScaledInstance(1000, 800, Image.SCALE_SMOOTH);
    ImageIcon a3 = new ImageIcon(a2);
    JLabel userBg = new JLabel(a3);
    userBg.setBounds(0, 0, 1000,800);
    add(userBg);


    setVisible(true);
    
}


    @Override
    public void actionPerformed(ActionEvent e) {
     if(e.getSource()==btnMyEvent){
        new userDashForEvents();
            dispose();
     }
     else if(e.getSource()==btnScheduleEvent){
       new celebrantInformationForm();
       dispose();
     }
     else if(e.getSource()==btnAvailableEvents){
       new userPageDisplay();
       dispose();
     }
     else if(e.getSource()==btnAboutUs){
       new aboutUs();
       dispose();
     }
     else if (e.getSource() == btnLogOut) {
       new userLoginAndSignup();
            dispose();
        }
    } 
     
}