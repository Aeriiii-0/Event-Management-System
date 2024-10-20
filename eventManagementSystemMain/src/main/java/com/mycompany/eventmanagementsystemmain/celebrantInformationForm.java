/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.eventmanagementsystemmain;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author 63955
 */

public class celebrantInformationForm extends JFrame implements ActionListener{
    
  JLabel lblName, lblAttendees, lblDate, lblHeader;
  JPanel pnlInfoForm;
  JTextField txtName, txtDate;
  JButton btnRequest;
  JComboBox cmbAttendeeReq;
  String[]  attendeesOptions = {"Select an option", "20 persons", "35 persons", "50persons"}; ;
  
  celebrantInformationForm(){
    
    this.setSize(1000, 800);
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    getContentPane().setBackground(new Color(213, 182, 238));
    this.setLayout(null);
   
    
    lblHeader = new JLabel("CELEBRANT INFORMATION FORM");
    lblHeader.setFont(new Font("Serif",Font.BOLD,25));
    lblHeader.setForeground(new Color(	66, 3, 104));
    lblHeader.setBounds(13, 25, 800, 40);
    add(lblHeader);
    
    pnlInfoForm = new JPanel();
    pnlInfoForm.setBounds(0, 0, 1000, 90);  
    pnlInfoForm.setBackground(new Color(190, 140, 229));
    add(pnlInfoForm);
    
    lblName = new JLabel("Name: ");
    lblName.setFont(new Font("Serif",Font.BOLD,25));
    lblName.setForeground(new Color(	66, 3, 104));
    lblName.setBounds(160, 140 , 150, 160);
    add(lblName);
    
    txtName = new JTextField(50);
    txtName.setBounds(300, 190, 520, 50);
    txtName.setBackground(new Color(190, 140, 229));
    txtName.setForeground(new Color(97, 3, 154));
    add(txtName);
    
    lblAttendees = new JLabel("Atendees: ");
    lblAttendees.setFont(new Font("Serif",Font.BOLD,25));
    lblAttendees.setForeground(new Color(66, 3, 104));
    lblAttendees.setBounds(120,240, 200, 160);
    add(lblAttendees);
   
    cmbAttendeeReq = new JComboBox<>(attendeesOptions);  
    cmbAttendeeReq.setBounds(300, 290, 520, 50);  
    cmbAttendeeReq.setBackground(new Color(190, 140, 229));
    add(cmbAttendeeReq);
    
 
    lblDate = new JLabel ("Date: ");
    lblDate.setFont(new Font("Serif",Font.BOLD,25));
    lblDate.setForeground(new Color(66, 3, 104));
    lblDate.setBounds(168, 340, 150, 160);
    add(lblDate);
  
    txtDate = new JTextField(50);
    txtDate.setBounds(300, 400, 520, 50);
    txtDate.setBackground(new Color(209, 159, 232));
    txtDate.setBackground(new Color(190, 140, 229));
    txtDate.setText("");
    add(txtDate);
    
    btnRequest = new JButton("REQUEST SCHEDULE");
    btnRequest.setBounds(620, 500, 200, 50); 
    btnRequest.setFont(new Font("Serif",Font.BOLD,15));
    btnRequest.setBackground(new Color(190, 140, 229));
    btnRequest.setForeground(new Color(66, 3, 104));
    add(btnRequest);
    btnRequest.addActionListener(this);
    
    
    setVisible(true);
       
    }
     public void actionPerformed(ActionEvent e) { 
         if(e.getSource()==btnRequest){
             JOptionPane.showMessageDialog(null, "Request has been sent. \nYou'll be notified if the request has been appropved.");
            new adminAddEvent();
                      }
     }
}
