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
    
  JLabel lblName, lblAttendees, lblDate, lblHeader, lblEvent, lblDuration, lblEventName;
  JPanel pnlInfoForm;
  JTextField tfName, tfDate, tfEvent, tfEventName;
  JButton btnRequest,btnBack;
  JComboBox cmbAttendeeReq, cmbDuration;
  String[] attendeesOptions = {"Select an option", "20 persons", "35 persons", "50 persons"}; 
  String [] eventDuration = {"Select Option", "2 hours", "3 hours and half hours" , "5 hours"};  
  celebrantInformationFormFINAL(){

//component settings
    setSize(1000, 800);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(null);
    getContentPane().setBackground(new Color(213, 182, 238));
    
    lblHeader = new JLabel("CELEBRANT INFORMATION FORM");
    lblHeader.setFont(new Font("Serif",Font.BOLD,25));
    lblHeader.setForeground(new Color(66, 3, 104));
    lblHeader.setBounds(13, 30, 800, 40);
    add(lblHeader);
    
    pnlInfoForm = new JPanel();
    pnlInfoForm.setBounds(-2, -2, 990, 100);  
    pnlInfoForm.setBackground(new Color(190, 140, 229));
    pnlInfoForm.setBorder(BorderFactory.createLineBorder(new Color(66, 3, 104), 3));
    add(pnlInfoForm);
    
    //textfields, combo boxes, and labels settings.
    
    //event name
    lblEventName = new JLabel("Event Name: ");
    lblEventName.setFont(new Font("Serif",Font.BOLD,20));
    lblEventName.setForeground(new Color(66, 3, 104));
    lblEventName.setBounds(120, 100 , 150, 160);
    add(lblEventName);
    
    tfEventName = new JTextField(50);
    tfEventName.setBounds(250, 160, 600, 40);
    tfEventName.setBackground(new Color(190, 140, 229));
    tfEventName.setBorder(BorderFactory.createLineBorder(new Color(66, 3, 104), 3));
    tfEventName.setForeground(new Color(66, 3, 104));
    tfEventName.setFont(new Font("Serif",Font.BOLD,15));
    tfEventName.setText("");
    add(tfEventName);
    
    //name
    lblName = new JLabel("Name: ");
    lblName.setFont(new Font("Serif",Font.BOLD,20));
    lblName.setForeground(new Color(66, 3, 104));
    lblName.setBounds(120, 180 , 150, 160);
    add(lblName);
    
    tfName = new JTextField(50);
    tfName.setBounds(200, 240, 650, 40);
    tfName.setBackground(new Color(190, 140, 229));
    tfName.setBorder(BorderFactory.createLineBorder(new Color(66, 3, 104), 3));
    tfName.setForeground(new Color(66, 3, 104));
    tfName.setFont(new Font("Serif",Font.BOLD,15));
    tfName.setText("");
    add(tfName);
    
    //date
    lblDate = new JLabel ("Date (yyyy-MM-dd): ");
    lblDate.setFont(new Font("Serif",Font.BOLD,20));
    lblDate.setForeground(new Color(66, 3, 104));
    lblDate.setBounds(120, 260, 230, 160);
    add(lblDate);
  
    tfDate = new JTextField(50);
    tfDate.setBounds(320, 320, 530, 40);
    tfDate.setBackground(new Color(190, 140, 229));
    tfDate.setBorder(BorderFactory.createLineBorder(new Color(66, 3, 104), 3));
    tfDate.setForeground(new Color(66, 3, 104));
    tfDate.setFont(new Font("Serif",Font.BOLD,15));
    tfDate.setText("");
    add(tfDate);
    
    //attendees
    lblAttendees = new JLabel("Attendees: ");
    lblAttendees.setFont(new Font("Serif",Font.BOLD,20));
    lblAttendees.setForeground(new Color(66, 3, 104));
    lblAttendees.setBounds(120,340, 200, 160);
    add(lblAttendees);
    
    cmbAttendeeReq = new JComboBox<>(attendeesOptions);  
    cmbAttendeeReq.setBorder(null);
    cmbAttendeeReq.setBounds(250, 400, 600, 40);  
    cmbAttendeeReq.setBackground(new Color(190, 140, 229));
    cmbAttendeeReq.setBorder(BorderFactory.createLineBorder(new Color(66, 3, 104), 3));
    cmbAttendeeReq.setFont(new Font("Serif",Font.BOLD,17));
    cmbAttendeeReq.setForeground(new Color(66, 3, 104));
    add(cmbAttendeeReq);
    
  //time duration
    lblDuration = new JLabel("Time Duration: ");
    lblDuration.setFont(new Font("Serif",Font.BOLD,20));
    lblDuration.setForeground(new Color(66, 3, 104));
    lblDuration.setBounds(120, 450 , 200, 100);
    add(lblDuration);
    
    cmbDuration = new JComboBox<>(eventDuration);  
    cmbDuration.setBounds(280, 480, 570, 40);
    cmbDuration.setBackground(new Color(190, 140, 229));
    cmbDuration.setBorder(BorderFactory.createLineBorder(new Color(66, 3, 104), 3));
    cmbDuration.setFont(new Font("Serif",Font.BOLD,17));
    cmbDuration.setForeground(new Color(66, 3, 104));
    add(cmbDuration);
    
    //time of event
    lblEvent = new JLabel("Time of Event:   ");
    lblEvent.setFont(new Font("Serif",Font.BOLD,20));
    lblEvent.setForeground(new Color(66, 3, 104));
    lblEvent.setBounds(120, 530 , 200, 100);
    add(lblEvent);
    
    tfEvent = new JTextField(50);
    tfEvent.setBounds(280, 560, 570, 40);
    tfEvent.setBackground(new Color(190, 140, 229));
    tfEvent.setBorder(BorderFactory.createLineBorder(new Color(66, 3, 104), 3));
    tfEvent.setForeground(new Color(66, 3, 104));
    tfEvent.setFont(new Font("Serif",Font.BOLD,15));
    tfEvent.setText("");
    add(tfEvent);
    
    //button
    btnRequest = new JButton("REQUEST SCHEDULE");
    btnRequest.setBounds(390, 640, 220, 40); 
    btnRequest.setFont(new Font("Serif",Font.BOLD,15));
    btnRequest.setForeground(new Color(66, 3, 104));
    btnRequest.setContentAreaFilled(false);  
    btnRequest.setBorder(BorderFactory.createLineBorder(new Color(66, 3, 104), 3));
    btnRequest.setFocusPainted(false);
    add(btnRequest);
    btnRequest.addActionListener(this);
    
    btnBack=new JButton("Back");
    btnBack.setBounds(857, 717, 200, 50);
    btnBack.setFont(new Font("Arial",Font.BOLD,12));
    btnBack.setForeground(new Color(66, 3, 104));
    btnBack.setBorderPainted(false);
    btnBack.setContentAreaFilled(false);
    btnBack.setFocusPainted(false);
    add(btnBack);
    btnBack.addActionListener(this);
    
    setVisible(true);
    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == btnRequest){
               if(!tfName.getText().isEmpty() && !tfDate.getText().isEmpty()&&  !tfEvent.getText().isEmpty()){
           
            String name = tfName.getText(); // name of celebrant
            String date = tfDate.getText(); // date of celebration
            String eventTime = tfEvent.getText(); //time to party to take place
            String attendees = (String) cmbAttendeeReq.getSelectedItem(); // attendee population selection
            String timeDuration = (String) cmbDuration.getSelectedItem(); // longevity of the event
        
         //file handling for directing users information of request to admin approval slip
         try (PrintWriter writer = new PrintWriter(new FileWriter("userData.txt", true))) {
            writer.println(name + " | " + date + " | " + attendees + " | " + timeDuration + " | " + eventTime);
            JOptionPane.showMessageDialog(null, "Schedule requested successfully!");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Failed to save the schedule. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
         int conf= JOptionPane.showConfirmDialog(null, "Do you want to exit?");
                      if(conf==JOptionPane.YES_OPTION){
                  JOptionPane.showMessageDialog(null, "See you soon !! >.<"); 
                  System.exit(0);}
            }
           
              
        else{
        JOptionPane.showMessageDialog(null, "Please answer all required fields", "Error", JOptionPane.ERROR_MESSAGE);
        }
        }
        else if(e.getSource()==btnBack){
            new evsWelcomePageGUI();
        }
    
    }
}
