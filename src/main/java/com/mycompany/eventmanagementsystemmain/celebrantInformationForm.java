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
    
  celebrantInformationForm(){
    
    this.setSize(1000, 800);
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(null);
    this.getContentPane().setBackground(new Color(244, 187, 255));
    
    lblHeader = new JLabel("CELEBRANT INFORMATION FORM");
    lblHeader.setFont(new Font("Serif",Font.BOLD,25));
    lblHeader.setForeground(Color.WHITE);
    lblHeader.setBounds(13, 25, 800, 40);
    add(lblHeader);
    
    pnlInfoForm = new JPanel();
    pnlInfoForm.setBounds(0, 0, 1000, 90);  
    pnlInfoForm.setBackground(new Color(190, 140, 229));
    add(pnlInfoForm);
    
    lblName = new JLabel("Name: ");
    lblName.setFont(new Font("Serif",Font.BOLD,25));
    lblName.setForeground(Color.BLACK);
    lblName.setBounds(160, 100 , 150, 160);
    add(lblName);
    
    txtName = new JTextField(50);
    txtName.setBounds(400, 150, 520, 50);
    txtName.setBackground(new Color(	209, 159, 232));
    txtName.setForeground(Color.white);
    txtName.setText("");
    add(txtName);
    
    lblAttendees = new JLabel("Atendees: ");
    lblAttendees.setFont(new Font("Serif",Font.BOLD,25));
    lblAttendees.setForeground(Color.BLACK);
    lblAttendees.setBounds(120,200, 200, 160);
    add(lblAttendees);
    
    String[] attendeesOptions = {"Select an option", "20 persons", "35 persons", "50persons"}; 
    cmbAttendeeReq = new JComboBox<>(attendeesOptions);  
    cmbAttendeeReq.setBounds(400, 250, 520, 50);  
    cmbAttendeeReq.setBackground(new Color(	209, 159, 232));
    add(cmbAttendeeReq);
    
 
    lblDate = new JLabel ("Date: ");
    lblDate.setFont(new Font("Serif",Font.BOLD,25));
    lblDate.setForeground(Color.BLACK);
    lblDate.setBounds(168, 300, 150, 160);
    add(lblDate);
  
    txtDate = new JTextField(50);
    txtDate.setBounds(400, 360, 520, 50);
    txtDate.setBackground(new Color(	209, 159, 232));
    txtDate.setForeground(Color.white);
    txtDate.setText("");
    add(txtDate);
    
    btnRequest = new JButton("REQUEST SCHEDULE");
    btnRequest.setBounds(550, 470, 220, 60); 
    btnRequest.setFont(new Font("Serif",Font.BOLD,15));
    btnRequest.setBackground(new Color(190, 140, 229));
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
