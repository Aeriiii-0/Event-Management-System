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
    
   JLabel lblUserName, lblEmail, lblEventId, lblFeedback, lblRegisterCount, lblRegisterCounter, lblHeader;
   JButton  btnSubmitForm;
   JTextField tfUserName, tfEmail, tfEventId;
   JTextArea txaFeedback;
   JPanel pnlUp, pnlDown, pnlCenter;
   int attendeeCount=0;
   LinkedList<Guest> guestList = new LinkedList<>();
 
 userInformationForm(){
     
    //component settings
        setSize(1000,800);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(213, 182, 238));
        
        
        lblHeader = new JLabel("ATTENDEE INFORMATION FORM");
        lblHeader.setFont(new Font("Serif",Font.BOLD,25));
        lblHeader.setForeground(Color.BLACK);
        lblHeader.setBounds(435, 40, 800, 40);
        add(lblHeader);
        
        lblUserName = new JLabel("Name:");
        lblUserName.setBounds(150, 200, 100, 30);
        lblUserName.setForeground(Color.BLACK);
        lblUserName.setFont(new Font("Arial", Font.BOLD, 23));
        add(lblUserName);
     
        lblEmail = new JLabel("Email:");
        lblEmail.setBounds(150, 270, 120, 30);
        lblEmail.setForeground(Color.BLACK);
        lblEmail.setFont(new Font("Arial", Font.BOLD, 23));
        add(lblEmail);
        
        lblEventId = new JLabel("Event ID:");
        lblEventId.setBounds(150, 340, 120, 30);
        lblEventId.setForeground(Color.BLACK);
        lblEventId.setFont(new Font("Arial", Font.BOLD, 23));
        add(lblEventId);
        
        lblFeedback = new JLabel("Feedback:");
        lblFeedback.setBounds(150, 430, 160, 30);
        lblFeedback.setForeground(Color.BLACK);
        lblFeedback.setFont(new Font("Arial", Font.BOLD, 23));
        add(lblFeedback);
                     
        btnSubmitForm = new JButton("SUBMIT FORM");
        btnSubmitForm.setBorder(null);
        btnSubmitForm.setOpaque(true);
        btnSubmitForm.setFocusable(true);
        btnSubmitForm.setBounds(535, 660, 200, 40);
        btnSubmitForm.setFont(new Font("Arial", Font.BOLD, 17));
        btnSubmitForm.setBackground(new Color(144, 5, 229));
        btnSubmitForm.setBorder(BorderFactory.createLineBorder(new Color(66, 3, 104), 3));
        add(btnSubmitForm);
        btnSubmitForm.addActionListener(this);
        
        
        tfUserName = new JTextField();    
        tfUserName.setBounds(400, 200, 480, 35);
        tfUserName.setBackground(new Color(190, 140, 229));
        tfUserName.setForeground(new Color(66, 3, 104));
        tfUserName.setFont(new Font("Serif",Font.BOLD,17));
        tfUserName.setBorder(BorderFactory.createLineBorder(new Color(66, 3, 104), 3));
            add(tfUserName);

        
       tfEmail = new JTextField();        
       tfEmail.setBounds(400, 270, 480, 35);
       tfEmail.setBackground(new Color(190,140,229));
       tfEmail.setBackground(new Color(190, 140, 229));
       tfEmail.setForeground(new Color(66, 3, 104));
       tfEmail.setFont(new Font("Serif",Font.BOLD,17));
       tfEmail.setBorder(BorderFactory.createLineBorder(new Color(66, 3, 104), 3));            
       add(tfEmail);
        
        tfEventId = new JTextField();    
        tfEventId.setBorder(null);
        tfEventId.setOpaque(true);
        tfEventId.setFocusable(true);
        tfEventId.setForeground(Color.BLACK);
        tfEventId.setBounds(400, 340, 480, 35);
        tfEventId.setBackground(new Color(190,140,229));
        tfEventId.setFont(new Font("Serif",Font.BOLD,17));
        tfEventId.setBorder(BorderFactory.createLineBorder(new Color(66, 3, 104), 3));
        add(tfEventId);
        
        txaFeedback = new JTextArea();
        txaFeedback.setForeground(Color.BLACK);
        txaFeedback.setBounds(400, 430, 480, 200);
        txaFeedback.setBackground(new Color(190,140,229));
        txaFeedback.setBorder(BorderFactory.createLineBorder(new Color(66, 3, 104), 3));
        txaFeedback.setFont(new Font("Serif",Font.BOLD,17));
        add(txaFeedback);
        
        
        pnlUp = new JPanel();
        pnlUp.setForeground(Color.WHITE);
        pnlUp.setBorder(BorderFactory.createLineBorder(new Color(66, 3, 104), 3));
        pnlUp.setBackground(new Color(190,140,229));
        pnlUp.setBounds(0, 0, 1000, 120);
        add(pnlUp);
        
        lblRegisterCount=new JLabel("Guests Registered: ");
        lblRegisterCount.setBounds(30, 700, 400, 30);
        lblRegisterCount.setForeground(new Color(66, 3, 104));
        lblRegisterCount.setFont(new Font("Arial", Font.BOLD, 23));
        pnlUp.add(lblRegisterCount);
        
        lblRegisterCounter=new JLabel("  0");
        lblRegisterCounter.setBounds(240, 700, 250, 30);
        lblRegisterCounter.setForeground(new Color(66, 3, 104));
        lblRegisterCounter.setFont(new Font("Arial", Font.BOLD, 23));
        pnlUp.add(lblRegisterCounter);

        pnlDown = new JPanel();
        pnlDown.setBounds(0, 0, 300, 800);
        pnlDown.setForeground(Color.WHITE);
        pnlDown.setBackground(new Color(190,140,229));
        pnlDown.setBorder(BorderFactory.createLineBorder(new Color(66, 3, 104), 3));
        add(pnlDown);
        
        pnlCenter = new JPanel();
            pnlCenter.setLayout(null);
            pnlCenter.setBounds(0, 109, 1000, 598);
            pnlCenter.setBackground(new Color(213, 182, 238));
            add(pnlCenter);
            
          setVisible(true);
        
    }

 
 
 
    @Override
   public void actionPerformed(ActionEvent e) {
       
        if (e.getSource() == btnSubmitForm) {
           //validating fields if they're field with required data.
        if(!tfUserName.getText().isEmpty()|| !tfEmail.getText().isEmpty() || !tfEventId.getText().isEmpty()|| !txaFeedback.getText().isEmpty()){
            
            Guest guest = new Guest(
                    tfUserName.getText(),
                    tfEmail.getText(),
                    tfEventId.getText(),
                    txaFeedback.getText()
                );
                guestList.add(guest);
         
          
            addAttendeeToDatabase();
            JOptionPane.showMessageDialog(null, "Successful Registration!");
          
          int askUser=JOptionPane.showConfirmDialog(null, "Do you want to submit another form?");
           if(askUser==JOptionPane.YES_OPTION){
             updateRegisterCountFromLastId();
               //clear all the texts within the fields.
               tfEmail.setText(" ");
               tfEventId.setText(" ");
               tfUserName.setText(" ");
               txaFeedback.setText(" ");
           }}
            } else {
                JOptionPane.showMessageDialog(this, "Please fill in all fields.");
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

           
    } 
        
    