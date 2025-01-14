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
import java.util.LinkedList;
import javax.swing.*;

class Guest {
String name;
String email;
String eventId;
String feedback;

public Guest(String name, String email, String eventId, String feedback) {
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
LinkedList<Guest> guestList = new LinkedList<>();
String attendeeName, attendeeEmail, eventId, attendeeFeedback;

 userInformationForm(){
     
    //component settings
    setSize(1000,800);
    setLayout(null);
    setLocationRelativeTo(null);
    setResizable(false);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

    //validating fields if they're field with required data.
 if (attendeeName.isEmpty() && attendeeEmail.isEmpty() && eventId.isEmpty() && attendeeFeedback.isEmpty()) {
    JOptionPane.showMessageDialog(this, "All fields are empty. Please fill in the required details.");
    return;
             }
        Guest guest = new Guest(attendeeName, attendeeEmail, eventId, attendeeFeedback);
        guestList.add(guest);

        addAttendeeToDatabase();

        int askUser = JOptionPane.showConfirmDialog(null, "Do you want to submit another form?");
        if (askUser == JOptionPane.YES_OPTION) {
         updateRegisterCountFromLastId();  
          setFields();
        }
        else if(askUser==JOptionPane.NO_OPTION){
          new welcomePage();
           dispose();
        }
         else {
             setFields();
             return;
        }
        }
    }

private void addAttendeeToDatabase() {

    try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/eventmanagement", "root", "1234")) {
        String query = "INSERT INTO attendee (name, email, eventId, feedback) VALUES (?,?,?,?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            for (Guest guest : guestList) {
            stmt.setString(1, guest.name);
            stmt.setString(2, guest.email);
            stmt.setString(3, guest.eventId);
            stmt.setString(4, guest.feedback);
            stmt.addBatch();
            }
            stmt.executeBatch();
            guestList.clear();
            JOptionPane.showMessageDialog(null, "Successful Registration!");
            setFields();
        }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Input Error: " + e.getMessage());
            setFields();
            return;
            
        }
    }
    private void updateRegisterCountFromLastId() {
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
    tfEmail.setText("");
    tfEventId.setText("");
    tfUserName.setText("");
    txaFeedback.setText("");
    }
    public static void main(String[] args) {
        new userInformationForm();
    }
} 
        
    
