/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.eventmanagementsystemmain;

/**
 *
 * @author 63955
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class userPageDisplay extends JFrame implements ActionListener{
       JButton btnBirthday,btnWedding, btnChristening, btnRequest;
       JLabel lblBirthday, lblWedding,lblChristening, lblHeader;
       JPanel pnlChoose, pnlBdayImage, pnlWedImage, pnlChristeningImage;
      
       
   userPageDisplay(){
        setSize(1000, 800);
        setLocationRelativeTo(null);
        setTitle("EVENT VENTURE");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        
        lblHeader = new JLabel("EVENT VENTURE");
        lblHeader.setFont(new Font("Serif",Font.BOLD,25));
        lblHeader.setForeground(new Color(66, 3, 104));
        lblHeader.setBounds(50, 25, 800, 40);
        add(lblHeader);
    
        pnlChoose= new JPanel();
        pnlChoose.setBounds(0, 0, 1000, 90);  
        pnlChoose.setBackground(new Color(190, 140, 229));
        add(pnlChoose);
        
        //birthday components. (bounds > image > panel)
        btnBirthday = new JButton("Birthday");
        btnBirthday.setBounds(80, 150, 240, 290);
        add(btnBirthday);
        
        ImageIcon bdayImage = new ImageIcon("images/birthday.jpg");
        Image Image1 = bdayImage.getImage();
        Image resized = Image1.getScaledInstance(400,290, Image.SCALE_SMOOTH);
        bdayImage = new ImageIcon(resized);
        btnBirthday.setIcon(bdayImage);
        
        pnlBdayImage=new JPanel();
        pnlBdayImage.setBounds(70, 155, 245, 295);
        pnlBdayImage.setBackground(new Color(190, 140, 229));
        add(pnlBdayImage);
        
        lblBirthday = new JLabel("BIRTHDAY");
        lblBirthday.setBounds(120, 385, 200, 200);
        lblBirthday.setFont(new Font("Serif",Font.BOLD,25));
        lblBirthday.setForeground(new Color(97, 3, 154));
        add(lblBirthday);
       
       //wed comps.
        
        btnWedding = new JButton("Wedding");
        btnWedding.setBounds(385, 150, 240, 290);
        add(btnWedding);
        
        ImageIcon wedImage = new ImageIcon("images/wedding.jpg");
        Image wed2 = wedImage.getImage();
        Image resized1 = wed2.getScaledInstance(400,290, Image.SCALE_SMOOTH);
        wedImage = new ImageIcon(resized1);
        btnWedding.setIcon(wedImage);
        
        pnlWedImage=new JPanel();
        pnlWedImage.setBounds(375, 155, 245, 295);
        pnlWedImage.setBackground(new Color(190, 140, 229));
        add(pnlWedImage);
        
        lblWedding = new JLabel("WEDDING");
        lblWedding.setBounds(435, 386, 200, 200);
        lblWedding.setFont(new Font("Serif",Font.BOLD,25));
        lblWedding.setForeground(new Color(97, 3, 154));
        add(lblWedding);
      
        //christening comps
        
        btnChristening = new JButton();
        btnChristening.setBounds(690, 150, 240, 290);
        add(btnChristening);
        
        ImageIcon binyagImage = new ImageIcon("images/binyag2.jpg");
        Image Image2 = binyagImage.getImage();
        Image resized2 = Image2.getScaledInstance(400,290, Image.SCALE_SMOOTH);
        binyagImage = new ImageIcon(resized2);
        btnChristening.setIcon(binyagImage);
        
        pnlChristeningImage=new JPanel();
        pnlChristeningImage.setBounds(680, 155, 245, 295);
        pnlChristeningImage.setBackground(new Color(190, 140, 229));
        add(pnlChristeningImage);
       
        lblChristening = new JLabel("CHRISTENING");
        lblChristening.setBounds(730, 385, 200, 200);
        lblChristening.setFont(new Font("Serif",Font.BOLD,25));
        lblChristening.setForeground(new Color(97, 3, 154));
        add(lblChristening);
       
        
        btnRequest = new JButton("SELECT AN EVENT");
        btnRequest.setBounds(300, 550, 400, 60); 
        btnRequest.setFocusable(false);
        btnRequest.setContentAreaFilled(false);
        btnRequest.setBorderPainted(false);
        btnRequest.setFocusPainted(false);
        btnRequest.setFont(new Font("Serif",Font.BOLD,25));
        btnRequest.setForeground(new Color(66, 3, 104));
        add(btnRequest);
        
        btnBirthday.addActionListener(this);
        btnWedding.addActionListener(this);
        btnChristening.addActionListener(this);
        btnRequest.addActionListener(this);
        
        //frame bg
        ImageIcon i7 = new ImageIcon("images/bg.jpg");
        Image i74 = i7.getImage().getScaledInstance(1000, 800, Image.SCALE_SMOOTH);
        ImageIcon i741 = new ImageIcon(i74);
        JLabel limg = new JLabel(i741);
        limg.setBounds(0, 0, 1000,800);
        add(limg);
    

        setVisible(true);
}      @Override
       public void actionPerformed(ActionEvent e){
        
             if(e.getSource() == btnBirthday){
             this.dispose();
             new celebrantInformationForm();
             dispose();
        } else if (e.getSource() == btnWedding) {
            this.dispose();
            new celebrantInformationForm();
            dispose();
        } else if (e.getSource() == btnChristening) {
            this.dispose();
            new celebrantInformationForm();
        } else {
            JOptionPane.showMessageDialog(null, "Please Select an Event");
        }
                     
       }
             }
               
