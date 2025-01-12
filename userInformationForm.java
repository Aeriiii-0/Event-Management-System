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
    
JLabel lblUserName, lblEmail, lblEventId, lblFeedback, lblRegisterCount, lblRegisterCounter;
JButton btnSubmitFeedback, btnSubmitForm;
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
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    getContentPane().setBackground(new Color(213, 182, 238));



    lblUserName = new JLabel("Name:");
    lblUserName.setBounds(100, 200, 100, 30);
    lblUserName.setForeground(new Color(66, 3, 104));
    lblUserName.setFont(new Font("",Font.ROMAN_BASELINE,18));
    add(lblUserName);

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

    lblRegisterCounter=new JLabel("   0");
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

            if (attendeeName.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Name is required.");
                tfUserName.requestFocus();
                return;
             }
            if (attendeeEmail.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Email is required.");
                tfEmail.requestFocus();
                return;
             }
            if (eventId.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Event ID is required.");
                tfEventId.requestFocus();
                return;
             }
            if (attendeeFeedback.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Feedback is required.");
                txaFeedback.requestFocus();
                return;
             }

            Guest guest = new Guest(attendeeName, attendeeEmail, eventId, attendeeFeedback);
            guestList.add(guest);

            addAttendeeToDatabase();
            JOptionPane.showMessageDialog(null, "Successful Registration!");

            int askUser = JOptionPane.showConfirmDialog(null, "Do you want to submit another form?");
            if (askUser == JOptionPane.YES_OPTION) {
                updateRegisterCountFromLastId();
                tfEmail.setText("");
                tfEventId.setText("");
                tfUserName.setText("");
                txaFeedback.setText("");
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
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Input Error: " + e.getMessage());
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

    public static void main(String[] args) {    
  new userInformationForm();
   
    }
           
    } 
        
    
