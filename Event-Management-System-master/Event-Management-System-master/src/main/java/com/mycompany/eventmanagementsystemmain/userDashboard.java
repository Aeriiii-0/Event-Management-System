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

 JLabel lblBdayImage,lblWedImageFinal,lblChristeningImageFinal,lblHeader , lblBday, lblWed, lblChris;
 JPanel pnlTop, pnlSide;
 JButton btnMyEvent, btnScheduleEvent, btnAvailableEvents, btnAboutUs;
 JPanel pnlBdayImage,pnlWeddingImage,pnlChristeningImage;
    userDashboard (){
    
    
    //component settings
    setSize(1000, 800);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(null);
    setResizable(false);
    getContentPane().setBackground(new Color(244, 187, 255));
    
    lblHeader = new JLabel("Event Venture");
    lblHeader.setFont(new Font("Serif",Font.BOLD,30));
    lblHeader.setForeground(new Color(	66, 3, 104));
    lblHeader.setBounds(53, 63, 300, 40);
    
    //buttons on the side panel    
    btnMyEvent=new JButton("My Event");
    btnMyEvent.setBounds(-2, 170, 300, 100);
    btnMyEvent.setFont(new Font("Serif",Font.ITALIC,25));
    btnMyEvent.setForeground(new Color(	66, 3, 104));
    btnMyEvent.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2)); 
    btnMyEvent.setContentAreaFilled(false);
    btnMyEvent.setFocusPainted(false);
    btnMyEvent.addActionListener(this);
    
    btnScheduleEvent=new JButton("Schedule an Event");
    btnScheduleEvent.setBounds(-2, 270, 300, 100);
    btnScheduleEvent.setFont(new Font("Serif",Font.ITALIC,25));
    btnScheduleEvent.setForeground(new Color(	66, 3, 104));
    btnScheduleEvent.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2)); 
    btnScheduleEvent.setContentAreaFilled(false);
    btnScheduleEvent.setFocusPainted(false);
    btnScheduleEvent.addActionListener(this);
    
    btnAvailableEvents=new JButton("See Available Events");
    btnAvailableEvents.setBounds(-2, 370, 300, 100);
    btnAvailableEvents.setFont(new Font("Serif",Font.ITALIC,25));
    btnAvailableEvents.setForeground(new Color(	66, 3, 104));
    btnAvailableEvents.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2)); 
    btnAvailableEvents.setContentAreaFilled(false);
    btnAvailableEvents.setFocusPainted(false);
    btnAvailableEvents.addActionListener(this);

    btnAboutUs=new JButton("About Us");
    btnAboutUs.setBounds(-2, 470, 300, 100);  
    btnAboutUs.setFont(new Font("Serif",Font.ITALIC,25));
    btnAboutUs.setForeground(new Color(	66, 3, 104));
    btnAboutUs.setContentAreaFilled(false);
    btnAboutUs.setBorderPainted(false);
    btnAboutUs.setFocusPainted(false);
    btnAboutUs.addActionListener(this);
   
    //panel for thickening the width of the black border
   pnlTop = new JPanel();
   pnlTop.setBounds(-2, 168, 301, 300);  
   pnlTop.setBackground(new Color(244, 187, 255));
   pnlTop.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3)); 
   
    pnlSide = new JPanel();
    pnlSide.setLayout(null);
    pnlSide.setBounds(-2, -2, 300, 805);  
    pnlSide.setBackground(new Color(244, 187, 255));
    pnlSide.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));
    
    add(pnlSide);
    pnlSide.add(lblHeader);
    pnlSide.add(btnMyEvent);
    pnlSide.add(btnScheduleEvent);
    pnlSide.add(btnAvailableEvents);
    pnlSide.add(btnAboutUs);
    pnlSide.add(pnlTop);
   
  //image and panels
    ImageIcon i1 = new ImageIcon("images/birthD.jpg");
    Image i2 = i1.getImage().getScaledInstance(200, 300, Image.SCALE_SMOOTH);  
    ImageIcon i3 = new ImageIcon(i2);
    lblBdayImage = new JLabel(i3);
    lblBdayImage.setBounds(315, 170, 200, 305);  
    add(lblBdayImage);

    pnlBdayImage = new JPanel();
    pnlBdayImage.setBounds(310, 175, 205, 310); 
    pnlBdayImage.setBackground(new Color(190, 140, 229));
    add(pnlBdayImage);

    ImageIcon lblWedImage = new ImageIcon("images/wed.jpg");
    Image lblWedImage1 = lblWedImage.getImage().getScaledInstance(200, 300, Image.SCALE_SMOOTH);  
    ImageIcon lblWedImage2 = new ImageIcon(lblWedImage1);
    lblWedImageFinal = new JLabel(lblWedImage2);
    lblWedImageFinal.setBounds(542, 170, 200, 305);  
    add(lblWedImageFinal);

    pnlWeddingImage = new JPanel();
    pnlWeddingImage.setBounds(537, 175, 205, 310);  
    pnlWeddingImage.setBackground(new Color(190, 140, 229));
    add(pnlWeddingImage);

    ImageIcon lblChristeningImage = new ImageIcon("images/baptism.jpg");
    Image lblChristeningImage1 = lblChristeningImage.getImage().getScaledInstance(200, 300, Image.SCALE_SMOOTH); 
    ImageIcon lblChristeningImage2 = new ImageIcon(lblChristeningImage1);
    lblChristeningImageFinal = new JLabel(lblChristeningImage2);
    lblChristeningImageFinal.setBounds(772, 170, 200, 305);  
    add(lblChristeningImageFinal);

    pnlChristeningImage = new JPanel();
    pnlChristeningImage.setBounds(767, 175, 205, 310);  
    pnlChristeningImage.setBackground(new Color(190, 140, 229));
    add(pnlChristeningImage);
    
    //labels below the panels
    lblBday = new JLabel("Birthday");
    lblBday.setBounds(310, 490, 200, 50);
    lblBday.setFont(new Font("Arial", Font.BOLD, 20));
    lblBday.setForeground(new Color(97, 3, 154));
    lblBday.setHorizontalAlignment(SwingConstants.CENTER);
    add(lblBday);
        
    lblWed = new JLabel("Wedding");
    lblWed.setBounds(537, 490, 200, 50);
    lblWed.setFont(new Font("Arial", Font.BOLD, 20));
    lblWed.setForeground(new Color(97, 3, 154));
    lblWed.setHorizontalAlignment(SwingConstants.CENTER);
    add(lblWed);
        
    lblChris = new JLabel("Christening");
    lblChris.setBounds(770, 490, 200, 50);
    lblChris.setFont(new Font("Arial", Font.BOLD, 20));
    lblChris.setForeground(new Color(97, 3, 154));
    lblChris.setHorizontalAlignment(SwingConstants.CENTER);
    add(lblChris);

        
   setVisible(true);
    
}

    @Override
    public void actionPerformed(ActionEvent e) {
     if(e.getSource()==btnMyEvent){
       // insert status. 
     }
     else if(e.getSource()==btnScheduleEvent){
       new celebrantInformationFormFINAL();
       dispose();
     }
     else if(e.getSource()==btnAvailableEvents){
       new userPageDisplay();
       dispose();
     }
     else if(e.getSource()==btnAboutUs){
         //insert lang label na naghahandle tayo events ganon ganon. inverted triangle.
     }
    }
}
