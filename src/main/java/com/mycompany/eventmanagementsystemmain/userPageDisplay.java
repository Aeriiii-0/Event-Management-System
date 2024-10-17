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
       JPanel pnlChoose;
      
       
   userPageDisplay(){
        setSize(1000, 800);
        setLocationRelativeTo(null);
        setTitle("EVENT VURTURE");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(new Color(244, 187, 255));
        
        lblHeader = new JLabel("EVENT VENTURE");
        lblHeader.setFont(new Font("Serif",Font.BOLD,25));
        lblHeader.setForeground(Color.WHITE);
        lblHeader.setBounds(13, 25, 800, 40);
        add(lblHeader);
    
        pnlChoose= new JPanel();
        pnlChoose.setBounds(0, 0, 1000, 90);  
        pnlChoose.setBackground(new Color(190, 140, 229));
        add(pnlChoose);
        
        btnBirthday = new JButton("Birthday");
        btnBirthday.setBounds(80, 120, 220, 290);
        add(btnBirthday);
        
        lblBirthday = new JLabel("BIRTHDAY");
        lblBirthday.setBounds(120, 350, 200, 200);
        lblBirthday.setFont(new Font("Serif",Font.BOLD,25));
        add(lblBirthday);
       
        ImageIcon bdayImage = new ImageIcon("images/birthday.jpg");
        Image Image1 = bdayImage.getImage();
        Image resized = Image1.getScaledInstance(400,290, Image.SCALE_SMOOTH);
        bdayImage = new ImageIcon(resized);
        btnBirthday.setIcon(bdayImage);
        
        btnWedding = new JButton("Wedding");
        btnWedding.setBounds(390, 120, 220, 290);
        add(btnWedding);
        
        lblWedding = new JLabel("WEDDING");
        lblWedding.setBounds(438, 350, 200, 200);
        lblWedding.setFont(new Font("Serif",Font.BOLD,25));

        add(lblWedding);
        
        ImageIcon wedImage = new ImageIcon("images/wedding.jpg");
        Image wed2 = wedImage.getImage();
        Image resized1 = wed2.getScaledInstance(400,290, Image.SCALE_SMOOTH);
        wedImage = new ImageIcon(resized1);
        btnWedding.setIcon(wedImage);

        btnChristening = new JButton();
        btnChristening.setBounds(690, 120, 220, 290);
        add(btnChristening);
       
        lblChristening = new JLabel("CHRISTENING");
        lblChristening.setBounds(720, 350, 260, 200);
        lblChristening.setFont(new Font("Serif",Font.BOLD,25));
        add(lblChristening);
       
        ImageIcon binyagImage = new ImageIcon("images/binyag2.jpg");
        Image Image2 = binyagImage.getImage();
        Image resized2 = Image2.getScaledInstance(400,290, Image.SCALE_SMOOTH);
        binyagImage = new ImageIcon(resized2);
        btnChristening.setIcon(binyagImage);
        
        btnRequest = new JButton("SELECT AN EVENT");
        btnRequest.setBounds(400, 550, 220, 60); 
        btnRequest.setBackground(new Color(190, 140, 229));
        btnRequest.setFont(new Font("Serif",Font.BOLD,15));
        add(btnRequest);
        
        btnBirthday.addActionListener(this);
        btnWedding.addActionListener(this);
        btnChristening.addActionListener(this);
        btnRequest.addActionListener(this);

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
               

