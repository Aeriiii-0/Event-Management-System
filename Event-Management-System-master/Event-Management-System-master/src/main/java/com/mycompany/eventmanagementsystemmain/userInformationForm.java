package com.mycompany.eventmanagementsystemmain;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalTime;
import java.util.LinkedList;
import javax.swing.*;

class attendeeInput {
String name;
String email;
String eventId;
String feedback;

public attendeeInput(String name, String email, String eventId, String feedback) {
this.name = name;
this.email = email;
this.eventId = eventId;
this.feedback = feedback;
 }

@Override
public String toString() {
    return "Name: " + name + ", Email: " + email + ", Event ID: " + eventId + ", Feedback: " + feedback;
 }
}

public class userInformationForm extends JFrame implements ActionListener{
    
JLabel lblHeader, lblUserName, lblEmail, lblEventId, lblFeedback, lblRegisterCount, lblRegisterCounter;
JButton  btnSubmitForm;
JTextField tfUserName, tfEmail, tfEventId;
JTextArea txaFeedback;
JPanel pnlUp, pnlDown;
int attendeeCount=0;
LinkedList<attendeeInput> attendeeInformationList = new LinkedList<>();
String attendeeName, attendeeEmail, eventId, attendeeFeedback;

 userInformationForm(){
     
 //component settings
     setSize(1000, 800);
    setLocationRelativeTo(null);
    setTitle("EVENT VENTURE");
    setResizable(false);         
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(null);
    getContentPane().setBackground(new Color(213, 182, 238));

    lblUserName = new JLabel("NAME:");
    lblUserName.setBounds(100, 200, 100, 30);
    lblUserName.setForeground(new Color(66, 3, 104));
    lblUserName.setFont(new Font("Arial",Font.BOLD,18));
    add(lblUserName);

    lblEmail = new JLabel("EMAIL:");
    lblEmail.setBounds(100, 270, 100, 30);
    lblEmail.setForeground(new Color(66, 3, 104));
    lblEmail.setFont(new Font("Arial",Font.BOLD,18));
    add(lblEmail);

    lblEventId = new JLabel("EVENT I.D:");
    lblEventId.setBounds(100, 340, 100, 30);
    lblEventId.setForeground(new Color(66, 3, 104));
    lblEventId.setFont(new Font("Arial",Font.BOLD,18));
    add(lblEventId);

    lblFeedback = new JLabel("FEEDBACK:");
    lblFeedback.setBounds(100, 430, 160, 30);
    lblFeedback.setForeground(new Color(66, 3, 104));
    lblFeedback.setFont(new Font("Arial",Font.BOLD,18));
    add(lblFeedback);

    btnSubmitForm = new JButton("SUBMIT FORM");
    btnSubmitForm.setBounds(540, 660, 200, 35);
    btnSubmitForm.setFont(new Font("Arial",Font.BOLD,13));
    btnSubmitForm.setForeground(new Color(66, 3, 104));
    btnSubmitForm.setContentAreaFilled(false);  
    btnSubmitForm.setBorder(BorderFactory.createLineBorder(new Color(66, 3, 104), 3));
    btnSubmitForm.setFocusPainted(false);
    add(btnSubmitForm);
    btnSubmitForm.addActionListener(this);


    tfUserName = new JTextField();
    tfUserName.setForeground(new Color(66, 3, 104));
    tfUserName.setBounds(400, 200, 480, 35);
    tfUserName.setBackground(new Color(190,140,229));
    tfUserName.setBorder(BorderFactory.createLineBorder(new Color(66, 3, 104), 3));
    tfUserName.setFont(new Font("Serif",Font.BOLD,17));
    add(tfUserName);


    tfEmail = new JTextField();
    tfEmail.setForeground(new Color(66, 3, 104));
    tfEmail.setBounds(400, 270, 480, 35);
    tfEmail.setBackground(new Color(190,140,229));
    tfEmail.setBorder(BorderFactory.createLineBorder(new Color(66, 3, 104), 3));  
    tfEmail.setFont(new Font("Serif",Font.BOLD,17));
    add(tfEmail);

    tfEventId = new JTextField();       
    tfEventId.setForeground(new Color(66, 3, 104));
    tfEventId.setBounds(400, 340, 480, 35);
    tfEventId.setBackground(new Color(190,140,229));
    tfEventId.setBorder(BorderFactory.createLineBorder(new Color(66, 3, 104), 3));
    tfEventId.setFont(new Font("Serif",Font.BOLD,17));
    add(tfEventId);

    txaFeedback = new JTextArea();
    txaFeedback.setForeground(new Color(66, 3, 104));
    txaFeedback.setBounds(400, 430, 480, 200);
    txaFeedback.setBackground(new Color(190,140,229));
    txaFeedback.setBorder(BorderFactory.createLineBorder(new Color(66, 3, 104), 3));
    txaFeedback.setFont(new Font("Serif",Font.BOLD,17));
    add(txaFeedback);


    pnlUp = new JPanel();
    pnlUp.setBackground(new Color(190,140,229));
    pnlUp.setBounds(301, -2, 720, 120);
    pnlUp.setBorder(BorderFactory.createLineBorder(new Color(66, 3, 104), 3));
    pnlUp.setLayout(null);
    add(pnlUp);
    
        
    lblHeader = new JLabel("ATTENDEE INFORMATION FORM");
    lblHeader.setFont(new Font("Serif",Font.BOLD,25));
    lblHeader.setForeground(new Color(66, 3, 104));
    lblHeader.setBounds(115, 40, 500, 40);
    pnlUp.add(lblHeader);

    lblRegisterCount=new JLabel("Guests Registered:");
    lblRegisterCount.setBounds(20, 80, 400, 30);
    lblRegisterCount.setForeground(new Color(66, 3, 104));
    lblRegisterCount.setFont(new Font("Serif",Font.BOLD,18));
   

    lblRegisterCounter=new JLabel("0");
    lblRegisterCounter.setBounds(185, 80, 400, 30);
    lblRegisterCounter.setForeground(new Color(66, 3, 104));
    lblRegisterCounter.setFont(new Font("Serif",Font.BOLD,18)); pnlUp.add(lblRegisterCounter);

    pnlDown = new JPanel();
    pnlDown.setLayout(null);
    pnlDown.setBounds(-2, -2, 305, 1000);
    pnlDown.setForeground(new Color(66, 3, 104));
    pnlDown.setBackground(new Color(190,140,229));
    pnlDown.setBorder(BorderFactory.createLineBorder(new Color(66, 3, 104), 3));
    add(pnlDown);
    pnlDown.add(lblRegisterCount);
    pnlDown.add(lblRegisterCounter);

    setVisible(true);
        
    }

@Override
public void actionPerformed(ActionEvent e) {
if (e.getSource() == btnSubmitForm) {
    
   //Collecting attendee input.
    attendeeName= tfUserName.getText().trim();
    attendeeEmail = tfEmail.getText().trim();
    eventId = tfEventId.getText().trim();
    attendeeFeedback= txaFeedback.getText().trim();
    
    //validate fields if all are filled
     if (attendeeName.isEmpty() || attendeeEmail.isEmpty() || eventId.isEmpty() || attendeeFeedback.isEmpty()) {
        JOptionPane.showMessageDialog(this, "All fields are required.");
        return ;
     }
     
    //collect user information and add to linkedList
    attendeeInput attendeeInformation = new attendeeInput(attendeeName, attendeeEmail, eventId, attendeeFeedback);
    attendeeInformationList.add(attendeeInformation);

    //if valid, add to database.
   if (checkPoints()) {
    addAttendeeToDatabase();
    JOptionPane.showMessageDialog(this, "You are registered! Enjoy everything <3", "Registration Successful", JOptionPane.INFORMATION_MESSAGE);
    
    int askUser = JOptionPane.showConfirmDialog(null, "Do you want to submit another form?");
    if (askUser == JOptionPane.YES_OPTION) {
        updateAttendeeCount();
        setFields();
    } else if (askUser == JOptionPane.NO_OPTION) {
        new welcomePage();
        dispose();
    } else {
        setFields();
        return;
    }
 }
   else {
    JOptionPane.showMessageDialog(  this, "Please make sure that you enter correct data. \n Please try again.",   "ERROR",   JOptionPane.ERROR_MESSAGE);
    setFields();
    return;
       }
    }
 }


 //checks if all information are valid before recording the data.
  private boolean checkPoints() {
      
     if (!validateEventId(eventId)) {
        JOptionPane.showMessageDialog(this, "Invalid or non-existent Event ID.", "ERROR", JOptionPane.ERROR_MESSAGE);
        setFields();
        return false;
    }
 
    if (!isWithinEventTime(eventId)) {
        JOptionPane.showMessageDialog(this, "Current time does not align with the scheduled event.", "ERROR", JOptionPane.ERROR_MESSAGE);
        return false;
    }
    
    if (!eventId.matches("[a-zA-Z0-9]+")) {
        JOptionPane.showMessageDialog(this, "Invalid Event ID. Only alphanumeric characters are allowed.", "ERROR", JOptionPane.ERROR_MESSAGE);
        tfEventId.setText("");
        return false;
    }
    
    if (!attendeeEmail.contains("@gmail.com")) {
        JOptionPane.showMessageDialog(this, "Invalid Email Address", "ERROR", JOptionPane.ERROR_MESSAGE);
        setFields();
        return false;
    }

    return true;
}
  
//method for validating eventId in the database.
 private boolean validateEventId(String eventId) {
    try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/eventmanagement", "root", "1234")) {
        String query = "SELECT eventId FROM event WHERE eventId = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, eventId);
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next(); 
            }
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Database error during event ID validation: " + e.getMessage());
    }
    return false;
}

 
 //after validating eventId, the next is if it's aligned with the time slot they're given
private boolean isWithinEventTime(String eventId) {
    try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/eventmanagement", "root", "1234")) {
        String query = "SELECT time FROM event WHERE eventId = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, eventId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String eventStartTime = rs.getString("time");

                    LocalTime startTime = LocalTime.parse(eventStartTime);
                    LocalTime currentTime = LocalTime.now();

                    return !currentTime.isBefore(startTime); 
                }
            }
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Database error during time validation: " + e.getMessage());
    }
    return false;
}


 //method for adding attendee to database
private void addAttendeeToDatabase() {

    try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/eventmanagement", "root", "1234")) {
        String query = "INSERT INTO attendee (name, email, eventId, feedback) VALUES (?,?,?,?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            for (attendeeInput attendeeInformation : attendeeInformationList) {
            stmt.setString(1, attendeeInformation.name);
            stmt.setString(2, attendeeInformation.email);
            stmt.setString(3, attendeeInformation.eventId);
            stmt.setString(4, attendeeInformation.feedback);
            stmt.addBatch();
            }
            //executing query and removing the attendee on the list once added on db
            stmt.executeBatch();
            attendeeInformationList.clear();
            setFields();
            
         }
        } catch (SQLException e) {
            setFields();
            return;
          }
    
    }

//method for updating the current count of ateendees who registered
    private void updateAttendeeCount() {
         try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/eventmanagement", "root", "1234")) {
        String query = "SELECT MAX(id) AS last_id FROM attendee";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            if (rs.next()) {
                int lastId = rs.getInt("last_id");
                lblRegisterCounter.setText("   " + lastId);
                attendeeCount = lastId;
            } else {
                lblRegisterCounter.setText("   0"); 
                attendeeCount = 0;
            }
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error fetching last attendee ID: " + e.getMessage());
       }
    }
    
    
    private void setFields(){
    tfEmail.setText(" ");
    tfEventId.setText(" ");
    tfUserName.setText(" ");
    txaFeedback.setText(" ");
    }
   
    
} 
        
    
