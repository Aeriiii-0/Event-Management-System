package com.mycompany.eventmanagementsystemmain;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;



public class userInformationForm extends JFrame implements ActionListener{
    
   JLabel lblUserName, lblID, lblEmail, lblEventId, lblFeedback, lblRegisterCount, lblRegisterCounter;
   JButton btnSubmitFeedback, btnSubmitForm;
   JTextField tfUserName, tfId, tfEmail, tfEventId;
   JTextArea txaFeedback;
   JPanel pnlUp, pnlDown;
   int attendeeCounter;
   
 userInformationForm(int attendeeCounter){
 this.attendeeCounter = attendeeCounter;   
     
    //component settings
        setSize(1000,800);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(213, 182, 238));
        
        
        
        lblUserName = new JLabel("Name:");
        lblUserName.setBounds(100, 200, 100, 30);
        lblUserName.setForeground(new Color(66, 3, 104));
        lblUserName.setFont(new Font("",Font.ROMAN_BASELINE,18));
        add(lblUserName);
        
        lblID = new JLabel("ID:");
        lblID.setBounds(100, 250, 100, 30);
        lblID.setForeground(new Color(66, 3, 104));
        lblID.setFont(new Font("",Font.ROMAN_BASELINE,18));
        add(lblID);
        
        lblEmail = new JLabel("EMAIL:");
        lblEmail.setBounds(100, 300, 100, 30);
        lblEmail.setForeground(new Color(66, 3, 104));
        lblEmail.setFont(new Font("",Font.ROMAN_BASELINE,18));
        add(lblEmail);
        
        lblEventId = new JLabel("EVENT I.D:");
        lblEventId.setBounds(100, 350, 100, 30);
        lblEventId.setForeground(new Color(66, 3, 104));
        lblEventId.setFont(new Font("",Font.ROMAN_BASELINE,18));
        add(lblEventId);
        
        lblFeedback = new JLabel("FEEDBACK:");
        lblFeedback.setBounds(100, 420, 160, 30);
        lblFeedback.setForeground(new Color(66, 3, 104));
        lblFeedback.setFont(new Font("",Font.ROMAN_BASELINE,18));
        add(lblFeedback);
        
        btnSubmitFeedback = new JButton("SUBMIT FEEDBACK");
        btnSubmitFeedback.setBorder(null);
        btnSubmitFeedback.setBounds(400, 650, 200, 40);
        btnSubmitFeedback.setFont(new Font("",Font.ROMAN_BASELINE,13));
        btnSubmitFeedback.setForeground(new Color(66, 3, 104));
        btnSubmitFeedback.setBackground(new Color(144, 5, 229));
        add(btnSubmitFeedback);
        btnSubmitFeedback.addActionListener(this);

        
        
        btnSubmitForm = new JButton("SUBMIT FORM");
        btnSubmitForm.setBorder(null);
        btnSubmitForm.setBounds(680, 650, 200, 40);
        btnSubmitForm.setFont(new Font("",Font.ROMAN_BASELINE,13));
        btnSubmitForm.setForeground(new Color(66, 3, 104));
        btnSubmitForm.setBackground(new Color(144, 5, 229));
        add(btnSubmitForm);
        btnSubmitForm.addActionListener(this);
        
        
        tfUserName = new JTextField();    
        tfUserName.setBorder(null);
        tfUserName.setOpaque(true);
        tfUserName.setFocusable(true);
        tfUserName.setForeground(new Color(66, 3, 104));
        tfUserName.setBounds(400, 200, 480, 35);
        tfUserName.setBackground(new Color(190,140,229));
        add(tfUserName);
        
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
        
        tfEventId = new JTextField();
        tfEventId.setBorder(null);
        tfEventId.setOpaque(true);
        tfEventId.setFocusable(true);        
        tfEventId.setForeground(new Color(66, 3, 104));
        tfEventId.setBounds(400, 350, 480, 35);
        tfEventId.setBackground(new Color(190,140,229));
        add(tfEventId);
        
        txaFeedback = new JTextArea();
        txaFeedback.setForeground(new Color(66, 3, 104));
        txaFeedback.setBounds(400, 420, 480, 200);
        txaFeedback.setBackground(new Color(190,140,229));
        add(txaFeedback);
        
        
        pnlUp = new JPanel();
        pnlUp.setForeground(Color.WHITE);
        pnlUp.setBackground(new Color(190,140,229));
        pnlUp.setBounds(0, 0, 1000, 120);
        pnlUp.setLayout(null);
        add(pnlUp);
        
        lblRegisterCount=new JLabel("Guests Registered: ");
        lblRegisterCount.setBounds(50, 40, 400, 30);
        lblRegisterCount.setForeground(new Color(66, 3, 104));
        lblRegisterCount.setFont(new Font("",Font.ROMAN_BASELINE,18));
        pnlUp.add(lblRegisterCount);
        
        lblRegisterCounter=new JLabel("0 ");
        lblRegisterCounter.setBounds(200, 40, 400, 30);
        lblRegisterCounter.setForeground(new Color(66, 3, 104));
        lblRegisterCounter.setFont(new Font("",Font.ROMAN_BASELINE,18));
        pnlUp.add(lblRegisterCounter);

        pnlDown = new JPanel();
        pnlDown.setBounds(0, 0, 300, 800);
        pnlDown.setForeground(new Color(66, 3, 104));
        pnlDown.setBackground(new Color(190,140,229));
        add(pnlDown);
        
          setVisible(true);
        
    }

    @Override
   public void actionPerformed(ActionEvent e) {
       
        if (e.getSource() == btnSubmitForm) {
        if(!tfUserName.getText().isEmpty() && !tfId.getText().isEmpty()&&
              !tfEmail.getText().isEmpty() && !tfEventId.getText().isEmpty()){
         
           attendeeCounter++;
           lblRegisterCounter.setText(": "+attendeeCounter);
           
           int askUser=JOptionPane.showConfirmDialog(null, "Do you want to submit another form?");
           if(askUser==JOptionPane.YES_OPTION){
               JOptionPane.showMessageDialog(null, "Successful Registration!");
               tfId.setText(" ");
               tfEmail.setText(" ");
               tfEventId.setText(" ");
               tfUserName.setText(" ");
               txaFeedback.setText(" ");
           }}
            } else {
                JOptionPane.showMessageDialog(this, "Please fill in all fields.");
            }
        }
  
    
    
  }