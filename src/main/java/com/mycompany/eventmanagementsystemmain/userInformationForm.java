package com.mycompany.eventmanagementsystemmain;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.*;


public class userInformationForm extends JFrame implements ActionListener{
    
   JLabel lblName, lbliD, lblEmail, lblEid, lblFeedback;
   JButton btnSFeedback, btnSubmitform;
   JTextField tfName, tfId, tfEmail, tfEid;
   JTextArea taFeedback;
   JPanel jpUp, pnlDown;
   
    userInformationForm(){
        setSize(1000,800);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(213, 182, 238));
        
        lblName = new JLabel("Name:");
        lblName.setBounds(100, 200, 100, 30);
        lblName.setForeground(Color.BLACK);
        lblName.setFont(new Font("",Font.ROMAN_BASELINE,18));
        add(lblName);
        
        lbliD = new JLabel("ID:");
        lbliD.setBounds(100, 250, 100, 30);
        lbliD.setForeground(Color.BLACK);
        lbliD.setFont(new Font("",Font.ROMAN_BASELINE,18));
        add(lbliD);
        
        lblEmail = new JLabel("EMAIL:");
        lblEmail.setBounds(100, 300, 100, 30);
        lblEmail.setForeground(Color.BLACK);
        lblEmail.setFont(new Font("",Font.ROMAN_BASELINE,18));
        add(lblEmail);
        
        lblEid = new JLabel("EVENT I.D:");
        lblEid.setBounds(100, 350, 100, 30);
        lblEid.setForeground(Color.BLACK);
        lblEid.setFont(new Font("",Font.ROMAN_BASELINE,18));
        add(lblEid);
        
        lblFeedback = new JLabel("FEEDBACK:");
        lblFeedback.setBounds(100, 420, 160, 30);
        lblFeedback.setForeground(Color.BLACK);
        lblFeedback.setFont(new Font("",Font.ROMAN_BASELINE,18));
        add(lblFeedback);
        
        btnSFeedback = new JButton("SUBMIT FEEDBACK");
        btnSFeedback.setBorder(null);
        btnSFeedback.setOpaque(true);
        btnSFeedback.setFocusable(true);
        btnSFeedback.setBounds(400, 650, 200, 40);
        btnSFeedback.setFont(new Font("",Font.ROMAN_BASELINE,13));
        btnSFeedback.setBackground(new Color(144, 5, 229));
        add(btnSFeedback);
        btnSFeedback.addActionListener(this);

        
        
        btnSubmitform = new JButton("SUBMIT FORM");
        btnSubmitform.setBorder(null);
        btnSubmitform.setOpaque(true);
        btnSubmitform.setFocusable(true);
        btnSubmitform.setBounds(680, 650, 200, 40);
        btnSubmitform.setFont(new Font("",Font.ROMAN_BASELINE,13));
        btnSubmitform.setBackground(new Color(144, 5, 229));
        add(btnSubmitform);
        btnSubmitform.addActionListener(this);
        
        
        tfName = new JTextField();    
        tfName.setBorder(null);
        tfName.setOpaque(true);
        tfName.setFocusable(true);
        tfName.setForeground(Color.BLACK);
        tfName.setBounds(400, 200, 480, 35);
        tfName.setBackground(new Color(190,140,229));
        add(tfName);
        
        tfId = new JTextField();        
        tfId.setBorder(null);
        tfId.setOpaque(true);
        tfId.setFocusable(true);
        tfId.setForeground(Color.BLACK);
        tfId.setBounds(400, 250, 480, 35);
        tfId.setBackground(new Color(190,140,229));
        add(tfId);
        
        
        tfEmail = new JTextField();    
        tfEmail.setBorder(null);
        tfEmail.setOpaque(true);
        tfEmail.setFocusable(true);
        tfEmail.setForeground(Color.BLACK);
        tfEmail.setBounds(400, 300, 480, 35);
        tfEmail.setBackground(new Color(190,140,229));
        add(tfEmail);
        
        tfEid = new JTextField();
        tfEid.setBorder(null);
        tfEid.setOpaque(true);
        tfEid.setFocusable(true);        
        tfEid.setForeground(Color.BLACK);
        tfEid.setBounds(400, 350, 480, 35);
        tfEid.setBackground(new Color(190,140,229));
        add(tfEid);
        
        taFeedback = new JTextArea();
        taFeedback.setForeground(Color.BLACK);
        taFeedback.setBounds(400, 420, 480, 200);
        taFeedback.setBackground(new Color(190,140,229));
        add(taFeedback);
        
        
        jpUp = new JPanel();
        jpUp.setForeground(Color.WHITE);
        jpUp.setBackground(new Color(190,140,229));
        jpUp.setBounds(0, 0, 1000, 120);
        add(jpUp);

        pnlDown = new JPanel();
        pnlDown.setBounds(0, 0, 300, 800);
        pnlDown.setForeground(Color.WHITE);
        pnlDown.setBackground(new Color(190,140,229));
        add(pnlDown);
        
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()==btnSubmitform){
            if(!tfName.getText().isEmpty() && !tfId.getText().isEmpty()&&
              !tfEmail.getText().isEmpty() && !tfEid.getText().isEmpty()){
               btnSubmitform.setEnabled(true);
               
               
               //enter database /call method              
            }else{
                btnSubmitform.setEnabled(false);
            }
             
   
       
    }}}
   
    
    

