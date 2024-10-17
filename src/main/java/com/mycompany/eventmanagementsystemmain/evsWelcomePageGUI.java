/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.eventmanagementsystemmain;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class evsWelcomePageGUI extends JFrame implements ActionListener{
    
    JButton btnBday,btnWedding,btnChristening,btnTap,btnOpenAdmin;
    JLabel lblBdayImage,lblWedImageFinal,lblChristeningImageFinal,lblTagline,lblHeader;
    JPanel pnlBdayImage,pnlWeddingImage,pnlChristeningImage,pnlHeader;
    evsWelcomePageGUI(){
        
        setSize(1000,800);
        setTitle("Venue Venture");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setBackground(new Color(213, 182, 238)); 
        setLocationRelativeTo(null); 
        setLayout(null);
      
        btnBday=new JButton("Birthday");
        btnBday.setBounds(100, 20, 200, 50);
        btnBday.setFont(new Font("Arial",Font.BOLD,20));
        btnBday.setForeground(new Color(97, 3, 154));
        btnBday.setBorderPainted(false);
        btnBday.setContentAreaFilled(false);
        btnBday.setFocusPainted(false);
        add(btnBday);
        btnBday.addActionListener(this);
        
        btnWedding=new JButton("Wedding");
        btnWedding.setBounds(400, 20, 200, 50);
        btnWedding.setFont(new Font("Arial",Font.BOLD,20));
        btnWedding.setForeground(new Color(97, 3, 154));
        btnWedding.setBorderPainted(false);
        btnWedding.setContentAreaFilled(false);
        btnWedding.setFocusPainted(false);
        add(btnWedding);
        btnWedding.addActionListener(this);
        
        btnChristening=new JButton("Christening");
        btnChristening.setBounds(700, 20, 200, 50);
        btnChristening.setFont(new Font("Arial",Font.BOLD,20));
        btnChristening.setForeground(new Color(97, 3, 154));
        btnChristening.setBorderPainted(false);
        btnChristening.setContentAreaFilled(false);
        btnChristening.setFocusPainted(false);
        add(btnChristening);
        btnChristening.addActionListener(this);
        
        ImageIcon i1 = new ImageIcon("images/birthD.jpg");
        Image i2 = i1.getImage().getScaledInstance(240, 300, Image.SCALE_REPLICATE);
        ImageIcon i3 = new ImageIcon(i2);
        lblBdayImage = new JLabel(i3);
        lblBdayImage.setBounds(80, 170, 240, 290);
        add(lblBdayImage);
        
        pnlBdayImage=new JPanel();
        pnlBdayImage.setBounds(70, 175, 245, 295);
        pnlBdayImage.setBackground(new Color(190, 140, 229));
        add(pnlBdayImage);
        
        ImageIcon lblWedImage = new ImageIcon("images/wed.jpg");
        Image lblWedImage1 = lblWedImage.getImage().getScaledInstance(240, 300, Image.SCALE_REPLICATE);
        ImageIcon lblWedImage2 = new ImageIcon(lblWedImage1);
        lblWedImageFinal = new JLabel(lblWedImage2);
        lblWedImageFinal.setBounds(385, 170, 235, 290);
        add(lblWedImageFinal);
         
        pnlWeddingImage=new JPanel();
        pnlWeddingImage.setBounds(375, 175, 240, 295);
        pnlWeddingImage.setBackground(new Color(190, 140, 229));
        add(pnlWeddingImage);
        
        ImageIcon lblChristeningImage = new ImageIcon("images/baptism.jpg");
        Image lblChristeningImage1 = lblChristeningImage.getImage().getScaledInstance(240, 300, Image.SCALE_REPLICATE);
        ImageIcon lblChristeningImage2 = new ImageIcon(lblChristeningImage1);
        lblChristeningImageFinal = new JLabel(lblChristeningImage2);
        lblChristeningImageFinal.setBounds(690, 170, 235, 290);
        add(lblChristeningImageFinal);
        
        pnlChristeningImage=new JPanel();
        pnlChristeningImage.setBounds(680, 175, 240, 295);
        pnlChristeningImage.setBackground(new Color(190, 140, 229));
        add(pnlChristeningImage);
      
        lblTagline=new JLabel("Planning Made Simple, Events Made Spectacular",SwingConstants.CENTER);
        lblTagline.setBounds(0, 490, 1000, 30);
        lblTagline.setFont(new Font("Arial",Font.BOLD,15));
        lblTagline.setForeground(new Color(97, 3, 154));
        add(lblTagline);
        
        lblHeader=new JLabel("Venue Venture",SwingConstants.CENTER);
        lblHeader.setBounds(0, 520, 1000, 30);
        lblHeader.setFont(new Font("Arial",Font.BOLD,25));
        lblHeader.setForeground(new Color(97, 3, 154));
        add(lblHeader);
        
        btnTap=new JButton("Tap here to book ");
        btnTap.setBounds(0, 540, 1000, 50);
        btnTap.setFont(new Font("Arial",Font.BOLD,12));
        btnTap.setForeground(new Color(	66, 3, 104));
        btnTap.setBorderPainted(false);
        btnTap.setContentAreaFilled(false);
        btnTap.setFocusPainted(false);
        add(btnTap);
        btnChristening.addActionListener(this);
      
        
        btnOpenAdmin=new JButton("Admin Log-in");
        btnOpenAdmin.setBounds(800, 650, 200, 50);
        btnOpenAdmin.setFont(new Font("Arial",Font.BOLD,12));
        btnOpenAdmin.setForeground(new Color(	66, 3, 104));
        btnOpenAdmin.setBorderPainted(false);
        btnOpenAdmin.setContentAreaFilled(false);
        btnOpenAdmin.setFocusPainted(false);
        add(btnOpenAdmin);

        pnlHeader=new JPanel();
        pnlHeader.setBounds(0, 0, 1000, 80);
        pnlHeader.setBackground(new Color(190, 140, 229));
        add(pnlHeader);
    
        setVisible(true);

    }
    public void actionPerformed(ActionEvent e) { 
   if(e.getSource()==btnBday){
         new TryFrame();
         dispose();    
        }}
     

   
    }

