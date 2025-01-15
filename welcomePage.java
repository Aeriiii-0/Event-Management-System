
package com.mycompany.eventmanagementsystemmain;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;

public class welcomePage extends JFrame implements ActionListener{
    
JButton btnBday,btnWed,btnChris,btnTap,btnOpenAdmin, btnExit;
JLabel lblBdayImage,lblWedImageFinal,lblChristeningImageFinal,lblTagline,lblHeader;
JPanel pnlBdayImage,pnlWeddingImage,pnlChristeningImage,pnlHeader;

welcomePage(){

    //component settings
     setSize(1000, 800);
    setLocationRelativeTo(null);
    setTitle("EVENT VENTURE");
    setResizable(false);         
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(null);
   
  //buttons
    btnBday=new JButton("Birthday");
    btnBday.setBounds(100, 20, 200, 50);
    btnBday.setFont(new Font("Serif",Font.BOLD,20));
    btnBday.setForeground(new Color(66, 3, 104));
    btnBday.setBorderPainted(false);
    btnBday.setContentAreaFilled(false);
    btnBday.setFocusPainted(false);
    add(btnBday);
    btnBday.addActionListener(this);

    btnWed=new JButton("Wedding");
    btnWed.setBounds(400, 20, 200, 50);
    btnWed.setFont(new Font("Serif",Font.BOLD,20));
    btnWed.setForeground(new Color(66, 3, 104));
    btnWed.setBorderPainted(false);
    btnWed.setContentAreaFilled(false);
    btnWed.setFocusPainted(false);
    add(btnWed);
    btnWed.addActionListener(this);

    btnChris=new JButton("Christening");
    btnChris.setBounds(700, 20, 200, 50);
    btnChris.setFont(new Font("Serif",Font.BOLD,20));
    btnChris.setForeground(new Color(66, 3, 104));
    btnChris.setBorderPainted(false);
    btnChris.setContentAreaFilled(false);
    btnChris.setFocusPainted(false);
    add(btnChris);
    btnChris.addActionListener(this);

    //image on top of panel
    ImageIcon i1 = new ImageIcon("images/birthD.jpg");
    Image i2 = i1.getImage().getScaledInstance(240, 300, Image.SCALE_REPLICATE);
    ImageIcon i3 = new ImageIcon(i2);
    lblBdayImage = new JLabel(i3);
    lblBdayImage.setBounds(80, 170, 240, 290);
    add(lblBdayImage);

    pnlBdayImage=new JPanel();
    pnlBdayImage.setBounds(70, 175, 245, 295);
    pnlBdayImage.setBackground(new Color(170, 120, 209));
    add(pnlBdayImage);

    ImageIcon lblWedImage = new ImageIcon("images/wed.jpg");
    Image lblWedImage1 = lblWedImage.getImage().getScaledInstance(240, 300, Image.SCALE_REPLICATE);
    ImageIcon lblWedImage2 = new ImageIcon(lblWedImage1);
    lblWedImageFinal = new JLabel(lblWedImage2);
    lblWedImageFinal.setBounds(385, 170, 235, 290);
    add(lblWedImageFinal);

    pnlWeddingImage=new JPanel();
    pnlWeddingImage.setBounds(375, 175, 240, 295);
    pnlWeddingImage.setBackground(new Color(170, 120, 209));
    add(pnlWeddingImage);

    ImageIcon lblChristeningImage = new ImageIcon("images/baptism.jpg");
    Image lblChristeningImage1 = lblChristeningImage.getImage().getScaledInstance(240, 300, Image.SCALE_REPLICATE);
    ImageIcon lblChristeningImage2 = new ImageIcon(lblChristeningImage1);
    lblChristeningImageFinal = new JLabel(lblChristeningImage2);
    lblChristeningImageFinal.setBounds(690, 170, 235, 290);
    add(lblChristeningImageFinal);

    pnlChristeningImage=new JPanel();
    pnlChristeningImage.setBounds(680, 175, 240, 295);
    pnlChristeningImage.setBackground(new Color(170, 120, 209));
    add(pnlChristeningImage);

    lblTagline=new JLabel("Planning Made Simple, Events Made Spectacular",SwingConstants.CENTER);
    lblTagline.setBounds(0, 490, 1000, 30);
    lblTagline.setFont(new Font("Arial",Font.BOLD,15));
    lblTagline.setForeground(new Color(97, 3, 154));
    add(lblTagline);

    lblHeader=new JLabel("Venue Venture",SwingConstants.CENTER);
    lblHeader.setBounds(0, 520, 1000, 30);
    lblHeader.setFont(new Font("Serif",Font.BOLD,25));
    lblHeader.setForeground(new Color(97, 3, 154));
    add(lblHeader);

    //button settings.
    btnTap=new JButton("Tap here to log-in or sign-up ");
    btnTap.setBounds(0, 540, 1000, 50);
    btnTap.setFont(new Font("Serif",Font.BOLD,17));
    btnTap.setForeground(new Color(	66, 3, 104));
    btnTap.setBorderPainted(false);
    btnTap.setContentAreaFilled(false);
    btnTap.setFocusPainted(false);
    add(btnTap);
    btnTap.addActionListener(this);

    btnOpenAdmin=new JButton("Admin Log-in");
    btnOpenAdmin.setBounds(780, 650, 200, 50);
    btnOpenAdmin.setFont(new Font("Serif",Font.BOLD,17));
    btnOpenAdmin.setForeground(new Color(	66, 3, 104));
    btnOpenAdmin.setBorderPainted(false);
    btnOpenAdmin.setContentAreaFilled(false);
    btnOpenAdmin.setFocusPainted(false);
    add(btnOpenAdmin);
    btnOpenAdmin.addActionListener(this);

    btnExit=new JButton("Exit");
    btnExit.setBounds(0, 650, 200, 50);
    btnExit.setFont(new Font("Serif",Font.BOLD,17));
    btnExit.setForeground(new Color(66, 3, 104));
    btnExit.setBorderPainted(false);
    btnExit.setContentAreaFilled(false);
    btnExit.setFocusPainted(false);
    add(btnExit);
    btnExit.addActionListener(this);

    pnlHeader=new JPanel();
    pnlHeader.setBounds(-2, -2, 1000, 90);
    pnlHeader.setBackground(new Color(190, 140, 229));
    pnlHeader.setBorder(BorderFactory.createLineBorder(new Color(66, 3, 104), 3));
    add(pnlHeader);

// image background
   ImageIcon lblBg = new ImageIcon("images/bg.jpg");
   Image lblBg1 = lblBg.getImage().getScaledInstance(1000, 800, Image.SCALE_SMOOTH);
   ImageIcon lblBg2 = new ImageIcon(lblBg1);
   JLabel lblBgFinal = new JLabel(lblBg2);
   lblBgFinal.setBounds(0, 0, 1000,800);
   add(lblBgFinal);

    setVisible(true);

}
    
    @Override
    public void actionPerformed(ActionEvent e) { 

//directs user to user's main frame
   if(e.getSource()==btnBday){
     dispose();
     new userLoginAndSignup(); 
   }else if(e.getSource()==btnWed){
        dispose();
     new userLoginAndSignup();
   } else if(e.getSource()==btnChris){
       dispose();
     new userLoginAndSignup();
   }else if(e.getSource()==btnTap){
       dispose();
     new userLoginAndSignup();
   } else if(e.getSource() ==btnExit){
       clearFile();
       System.exit(0);
     }
    //directs to admin log-in
   else if(e.getSource()==btnOpenAdmin){
       dispose();
      new adminLogin();
     }
   }
    
    private void clearFile() {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter("userData.txt", false))) {
        writer.write(""); 
    } catch (IOException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error clearing userData.txt.", "Error", JOptionPane.ERROR_MESSAGE);
    }
  }
 }
