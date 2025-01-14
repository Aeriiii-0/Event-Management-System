
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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 63955
 */

public class celebrantInformationForm extends JFrame implements ActionListener {
    
  JLabel lblName, lblDate, lblHeader, lblEvent, lblDuration, lblEventName;
  JPanel pnlInfoForm;
  JTextField tfName, tfDate, tfEvent;
  JButton btnRequest,btnBack;
  JComboBox  cmbDuration,cmbEventName;
  String [] eventDuration = {"Select Option", "2 hours", "3 hours and half hours" , "5 hours"}; 
  String[] eventNames = {"Select an option", "Birthday", "Wedding", "Christening"};
  
  celebrantInformationForm(){

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
    
   cmbEventName = new JComboBox<>(eventNames);
   cmbEventName.setBounds(250, 160, 600, 40);
   cmbEventName.setBackground(new Color(190, 140, 229));
   cmbEventName.setBorder(BorderFactory.createLineBorder(new Color(66, 3, 104), 3));
   cmbEventName.setFont(new Font("Serif", Font.BOLD, 17));
   cmbEventName.setForeground(new Color(66, 3, 104));
   add(cmbEventName);
    
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
    
    
  //time duration
    lblDuration = new JLabel("Time Duration: ");
    lblDuration.setFont(new Font("Serif",Font.BOLD,20));
    lblDuration.setForeground(new Color(66, 3, 104));
    lblDuration.setBounds(120, 370 , 200, 100);
    add(lblDuration);
    
    cmbDuration = new JComboBox<>(eventDuration);  
    cmbDuration.setBounds(280, 400, 570, 40);
    cmbDuration.setBackground(new Color(190, 140, 229));
    cmbDuration.setBorder(BorderFactory.createLineBorder(new Color(66, 3, 104), 3));
    cmbDuration.setFont(new Font("Serif",Font.BOLD,17));
    cmbDuration.setForeground(new Color(66, 3, 104));
    add(cmbDuration);
    
    //time of event
    lblEvent = new JLabel("Time of Event:   ");
    lblEvent.setFont(new Font("Serif",Font.BOLD,20));
    lblEvent.setForeground(new Color(66, 3, 104));
    lblEvent.setBounds(120, 450 , 200, 100);
    add(lblEvent);
    
    tfEvent = new JTextField(50);
    tfEvent.setBounds(280, 480, 570, 40);
    tfEvent.setBackground(new Color(190, 140, 229));
    tfEvent.setBorder(BorderFactory.createLineBorder(new Color(66, 3, 104), 3));
    tfEvent.setForeground(new Color(66, 3, 104));
    tfEvent.setFont(new Font("Serif",Font.BOLD,15));
    tfEvent.setText("");
    add(tfEvent);
    
    //button
    btnRequest = new JButton("REQUEST SCHEDULE");
    btnRequest.setBounds(390, 540, 220, 40); 
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
    if (e.getSource() == btnRequest) {
        //collect user inputs
    String eventName = (String) cmbEventName.getSelectedItem();
    String name = tfName.getText();
    String date = tfDate.getText();
    String timeEvent = tfEvent.getText();
    String duration = (String) cmbDuration.getSelectedItem();

    //validating textfields
    if (name.isEmpty() || date.isEmpty() || timeEvent.isEmpty() || duration.equals("Select Option") || eventName.equals("Select Option")) {
        JOptionPane.showMessageDialog(null, "Please fill in all required fields.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    
    // if validated, proceed to parsing date and time together
   try {
        SimpleDateFormat dateAndTime = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        dateAndTime.setLenient(false);

        String combineDateAndTime = date + " " + timeEvent;
        Date finalDateTime = dateAndTime.parse(combineDateAndTime);

        Date getTimeAndDate = new Date(); //retrieve what the current time is

        if (finalDateTime.before(getTimeAndDate)) {
            JOptionPane.showMessageDialog(null, "The selected time has already passed. Please choose a future time.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
    //select duration to estimate intervals between events
    try {
        int durationMinutes = switch (duration) {
            case "2 hours" -> 3; 
            case "3 hours and half hours" -> 5;
            case "5 hours" -> 6;
            default -> 0;
        };

        if (durationMinutes == 0) {
            JOptionPane.showMessageDialog(null, "Invalid duration selected.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        //scan data from db if there's event that may overlap.
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/eventmanagement", "root", "1234")) {
            String checkQuery = """
            SELECT * FROM event WHERE date = ?  AND (TIME(?) < ADDTIME(time, SEC_TO_TIME(duration * 60))  AND TIME(?) >= time)  """;

            try (PreparedStatement checkStmt = connection.prepareStatement(checkQuery)) {
                checkStmt.setString(1, date);
                checkStmt.setString(2, timeEvent);
                checkStmt.setString(3, timeEvent);

                try (ResultSet rs = checkStmt.executeQuery()) {
                    if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "Time slot not available. Please pick another time.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Database error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
            return;
        }

    // add the user input to userData for adding the customers in prio queue.
    try (PrintWriter writer = new PrintWriter(new FileWriter("userData.txt", true))) {
        writer.println(eventName + ", " + name + ", " + date + ", " + duration + ", " + timeEvent);
        JOptionPane.showMessageDialog(null, "Schedule requested successfully and saved to file!");
        eraseFields();
        
    } catch (IOException ex) {
        JOptionPane.showMessageDialog(null, "Failed to save the schedule to file. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
        eraseFields();
     }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "An error occurred. Please check your input.", "Error", JOptionPane.ERROR_MESSAGE);
                eraseFields();
                ex.printStackTrace();
            }
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Invalid date or time format. Please use 'yyyy-MM-dd' for the date and 'HH:mm' for the time.", "Error", JOptionPane.ERROR_MESSAGE);
            eraseFields();
        }
    }

    else if (e.getSource() == btnBack) {
        new userDashboard();
        dispose();
    }
}
  
  private void eraseFields(){
 tfDate.setText("");
 cmbEventName.setSelectedIndex(0);
 tfName.setText("");
 tfEvent.setText(" ");
 cmbDuration.setSelectedIndex(0);
  }
public static void main(String[] args) {    
new celebrantInformationForm();

}

}