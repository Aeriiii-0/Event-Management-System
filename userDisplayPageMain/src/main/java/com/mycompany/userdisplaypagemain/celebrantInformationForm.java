/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.userdisplaypagemain;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.event.ActionListener;

/**
 *
 * @author 63955
 */

public class celebrantInformationForm extends JFrame implements ActionListener {
    
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
    txtName.setBorder(null);
    txtName.setBackground(new Color(	209, 159, 232));
    txtName.setForeground(Color.BLACK);
    txtName.setFont(new Font("Serif",Font.BOLD,15));
    txtName.setText("");
    add(txtName);
    
    lblAttendees = new JLabel("Attendees: ");
    lblAttendees.setFont(new Font("Serif",Font.BOLD,25));
    lblAttendees.setForeground(Color.BLACK);
    lblAttendees.setBounds(120,200, 200, 160);
    add(lblAttendees);
    
    String[] attendeesOptions = {"Select an option", "20 persons", "35 persons", "50persons"}; 
    cmbAttendeeReq = new JComboBox<>(attendeesOptions);  
    cmbAttendeeReq.setBorder(null);
    cmbAttendeeReq.setBounds(400, 250, 520, 50);  
    cmbAttendeeReq.setBackground(new Color(	209, 159, 232));
    cmbAttendeeReq.setFont(new Font("Serif",Font.BOLD,15));

    add(cmbAttendeeReq);
    
 
    lblDate = new JLabel ("Date: ");
    lblDate.setFont(new Font("Serif",Font.BOLD,25));
    lblDate.setForeground(Color.BLACK);
    lblDate.setBounds(168, 300, 150, 160);
    add(lblDate);
  
    txtDate = new JTextField(50);
    txtDate.setBorder(null);
    txtDate.setBounds(400, 360, 520, 50);
    txtDate.setBackground(new Color(	209, 159, 232));
    txtDate.setForeground(Color.BLACK);
    txtDate.setFont(new Font("Serif",Font.BOLD,15));
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

    @Override
    public void actionPerformed(ActionEvent e) {
          if (e.getSource() == btnRequest) {
            String name = txtName.getText();
            String attendees = cmbAttendeeReq.getSelectedItem().toString();
            String date = txtDate.getText();

            if (name.isEmpty() || attendees.equals("Select an option") || date.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in all fields.");
            } else {
                JOptionPane.showMessageDialog(this, "Request Submitted:\nName: " + name + "\nAttendees: " + attendees + "\nDate: " + date);
                
                txtName.setText("");
                cmbAttendeeReq.setSelectedIndex(0);
                txtDate.setText("");
            }
        }
    }

    public static void main(String[] args) {
        new celebrantInformationForm();
        
    }
    
}
