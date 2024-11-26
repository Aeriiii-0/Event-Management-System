/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.eventmanagementsystemmain;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

/**
 *
 * @author 63955
 */

public class celebrantInformationFormFINAL extends JFrame implements ActionListener {
    
  JLabel lblName, lblAttendees, lblDate, lblHeader, lblEvent, lblDuration;
  JPanel pnlInfoForm;
  JTextField txtName, txtDate, txtDuration, txtEvent;
  JButton btnRequest;
  JComboBox cmbAttendeeReq, cmbDuration;
  String[] eventDuration;
    
  celebrantInformationFormFINAL(){
    
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
    lblName.setBounds(220, 60 , 150, 160);
    add(lblName);
    
    txtName = new JTextField(50);
    txtName.setBounds(400, 120, 520, 50);
    txtName.setBorder(null);
    txtName.setBackground(new Color(	209, 159, 232));
    txtName.setForeground(Color.BLACK);
    txtName.setFont(new Font("Serif",Font.BOLD,15));
    txtName.setText("");
    add(txtName);
    
    lblAttendees = new JLabel("Attendees: ");
    lblAttendees.setFont(new Font("Serif",Font.BOLD,25));
    lblAttendees.setForeground(Color.BLACK);
    lblAttendees.setBounds(180,160, 200, 160);
    add(lblAttendees);
    
    String[] attendeesOptions = {"Select an option", "20 persons", "35 persons", "50 persons"}; 
    cmbAttendeeReq = new JComboBox<>(attendeesOptions);  
    cmbAttendeeReq.setBorder(null);
    cmbAttendeeReq.setBounds(400, 220, 520, 50);  
    cmbAttendeeReq.setBackground(new Color(	209, 159, 232));
    cmbAttendeeReq.setFont(new Font("Serif",Font.BOLD,15));
    add(cmbAttendeeReq);
    
 
    lblDate = new JLabel ("Date (dd/mm/yyyy): ");
    lblDate.setFont(new Font("Serif",Font.BOLD,25));
    lblDate.setForeground(Color.BLACK);
    lblDate.setBounds(80, 280, 230, 160);
    add(lblDate);
  
    txtDate = new JTextField(50);
    txtDate.setBorder(null);
    txtDate.setBounds(400, 330, 520, 50);
    txtDate.setBackground(new Color(	209, 159, 232));
    txtDate.setForeground(Color.BLACK);
    txtDate.setFont(new Font("Serif",Font.BOLD,15));
    txtDate.setText("");
    add(txtDate);
    
    lblDuration = new JLabel("Time Duration ");
    lblDuration.setFont(new Font("Serif",Font.BOLD,18));
    lblDuration.setForeground(Color.BLACK);
    lblDuration.setBounds(185, 460 , 200, 100);
    add(lblDuration);
    
    String [] eventDuration = {"Select Option", "2 hours", "3 hours and half hours" , "5 hours"}; 
    cmbDuration = new JComboBox<>(eventDuration);  
    cmbDuration.setBorder(null);
    cmbDuration.setBounds(140, 450, 230, 40);  
    cmbDuration.setBackground(new Color(	209, 159, 232));
    cmbDuration.setFont(new Font("Serif",Font.BOLD,20));
    add(cmbDuration);
    
    lblEvent = new JLabel("Time of Event   ");
    lblEvent.setFont(new Font("Serif",Font.BOLD,18));
    lblEvent.setForeground(Color.BLACK);
    lblEvent.setBounds(620, 460 , 200, 100);
    add(lblEvent);
    
    txtEvent = new JTextField(50);
    txtEvent.setBorder(null);
    txtEvent.setBounds(580, 450, 230, 40);
    txtEvent.setBackground(new Color(	209, 159, 232));
    txtEvent.setForeground(Color.BLACK);
    txtEvent.setFont(new Font("Serif",Font.BOLD,15));
    txtEvent.setText("");
    add(txtEvent);
    
    btnRequest = new JButton("REQUEST SCHEDULE");
    btnRequest.setBounds(360, 590, 220, 60); 
    btnRequest.setFont(new Font("Serif",Font.BOLD,15));
    btnRequest.setBackground(new Color(190, 140, 229));
    add(btnRequest);
    
    
    btnRequest.addActionListener(this);
    setVisible(true);
    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == btnRequest){
            String name = txtName.getText();
            String date = txtDate.getText();
            String eventTime = txtEvent.getText();
            String attendees = (String) cmbAttendeeReq.getSelectedItem();
            String timeDuration = (String) cmbDuration.getSelectedItem();
        
        try (PrintWriter writer = new PrintWriter(new FileWriter("userData.txt", true))) {
            writer.println(name + " | " + date + " | " + attendees + " | " + timeDuration + " | " + eventTime);
            JOptionPane.showMessageDialog(null, "Schedule requested successfully!");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Failed to save the schedule. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        }
       
    
    }
}
