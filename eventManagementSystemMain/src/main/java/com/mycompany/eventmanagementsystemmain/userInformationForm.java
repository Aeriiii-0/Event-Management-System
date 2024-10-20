package com.mycompany.eventmanagementsystemmain;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;



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
        lblName.setForeground(new Color(66, 3, 104));
        lblName.setFont(new Font("",Font.ROMAN_BASELINE,18));
        add(lblName);
        
        lbliD = new JLabel("ID:");
        lbliD.setBounds(100, 250, 100, 30);
        lbliD.setForeground(new Color(66, 3, 104));
        lbliD.setFont(new Font("",Font.ROMAN_BASELINE,18));
        add(lbliD);
        
        lblEmail = new JLabel("EMAIL:");
        lblEmail.setBounds(100, 300, 100, 30);
        lblEmail.setForeground(new Color(66, 3, 104));
        lblEmail.setFont(new Font("",Font.ROMAN_BASELINE,18));
        add(lblEmail);
        
        lblEid = new JLabel("EVENT I.D:");
        lblEid.setBounds(100, 350, 100, 30);
        lblEid.setForeground(new Color(66, 3, 104));
        lblEid.setFont(new Font("",Font.ROMAN_BASELINE,18));
        add(lblEid);
        
        lblFeedback = new JLabel("FEEDBACK:");
        lblFeedback.setBounds(100, 420, 160, 30);
        lblFeedback.setForeground(new Color(66, 3, 104));
        lblFeedback.setFont(new Font("",Font.ROMAN_BASELINE,18));
        add(lblFeedback);
        
        btnSFeedback = new JButton("SUBMIT FEEDBACK");
        btnSFeedback.setBorder(null);
        btnSFeedback.setOpaque(true);
        btnSFeedback.setFocusable(true);
        btnSFeedback.setBounds(400, 650, 200, 40);
        btnSFeedback.setFont(new Font("",Font.ROMAN_BASELINE,13));
        btnSFeedback.setForeground(new Color(66, 3, 104));
        btnSFeedback.setBackground(new Color(144, 5, 229));
        add(btnSFeedback);
        btnSFeedback.addActionListener(this);

        
        
        btnSubmitform = new JButton("SUBMIT FORM");
        btnSubmitform.setBorder(null);
        btnSubmitform.setOpaque(true);
        btnSubmitform.setFocusable(true);
        btnSubmitform.setBounds(680, 650, 200, 40);
        btnSubmitform.setFont(new Font("",Font.ROMAN_BASELINE,13));
        btnSubmitform.setForeground(new Color(66, 3, 104));
        btnSubmitform.setBackground(new Color(144, 5, 229));
        add(btnSubmitform);
        btnSubmitform.addActionListener(this);
        
        
        tfName = new JTextField();    
        tfName.setBorder(null);
        tfName.setOpaque(true);
        tfName.setFocusable(true);
        tfName.setForeground(new Color(66, 3, 104));
        tfName.setBounds(400, 200, 480, 35);
        tfName.setBackground(new Color(190,140,229));
        add(tfName);
        
        tfId = new JTextField();        
        tfId.setBorder(null);
        tfId.setOpaque(true);
        tfId.setFocusable(true);
        tfId.setForeground(new Color(66, 3, 104));
        tfId.setBounds(400, 250, 480, 35);
        tfId.setBackground(new Color(190,140,229));
        add(tfId);
        
        
        tfEmail = new JTextField();    
        tfEmail.setBorder(null);
        tfEmail.setOpaque(true);
        tfEmail.setFocusable(true);
        tfEmail.setForeground(new Color(66, 3, 104));
        tfEmail.setBounds(400, 300, 480, 35);
        tfEmail.setBackground(new Color(190,140,229));
        add(tfEmail);
        
        tfEid = new JTextField();
        tfEid.setBorder(null);
        tfEid.setOpaque(true);
        tfEid.setFocusable(true);        
        tfEid.setForeground(new Color(66, 3, 104));
        tfEid.setBounds(400, 350, 480, 35);
        tfEid.setBackground(new Color(190,140,229));
        add(tfEid);
        
        taFeedback = new JTextArea();
        taFeedback.setForeground(new Color(66, 3, 104));
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
        pnlDown.setForeground(new Color(66, 3, 104));
        pnlDown.setBackground(new Color(190,140,229));
        add(pnlDown);
        
       
        
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()==btnSubmitform){
            if(!tfName.getText().isEmpty() && !tfId.getText().isEmpty()&&
              !tfEmail.getText().isEmpty() && !tfEid.getText().isEmpty()){
               btnSubmitform.setEnabled(true);
               JOptionPane.showMessageDialog(null, "Please answer all fields to proceed.");
               
               //enter database /call method              
            }else{
                btnSubmitform.setEnabled(false);
            }
             
   
       
    }}}
   
    
    

