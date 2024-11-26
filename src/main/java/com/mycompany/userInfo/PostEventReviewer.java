package com.mycompany.userInfo;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class PostEventReviewer extends JFrame {

    public PostEventReviewer(String name, String id, String email, String eventId, String feedback, JFrame previousFrame) {
        
        setTitle("Event Analytics");
        setSize(1000, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        Color colorLight = new Color(213, 182, 238);
        Color colorMild = new Color(190, 140, 229);
        Color colorDark = new Color(144, 5, 229);

        JPanel paneBg = new JPanel(null);
        paneBg.setBackground(colorLight);
        paneBg.setBounds(0, 0, 1000, 800);
        add(paneBg);

        JLabel lblTitle = new JLabel("Post-Event Analytics", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 25));
       // lblTitle.setForeground(Color.WHITE);
        lblTitle.setBounds(0, 50, 1000, 40);
        paneBg.add(lblTitle);

        JLabel lblAttendee = new JLabel("Attendee Information:");
        lblAttendee.setFont(new Font("Arial", Font.BOLD, 18));
        lblAttendee.setBounds(190, 150, 200, 30);
        paneBg.add(lblAttendee);

        JTextArea attendeeInfo = new JTextArea();
        attendeeInfo.setText(name + "\n" + id + "\n" + email + "\n" + eventId);
        attendeeInfo.setEditable(false);
        attendeeInfo.setBackground(colorMild);
      //  attendeeInfo.setForeground(Color.WHITE);
        attendeeInfo.setBorder(null);
        attendeeInfo.setFont(new Font("Arial", Font.PLAIN, 16));
        JScrollPane scrollAttendee = new JScrollPane(attendeeInfo);
        scrollAttendee.setBounds(110, 200, 350, 400);
        scrollAttendee.setBorder(null);
        paneBg.add(scrollAttendee);

        JLabel lblFeedback = new JLabel("Feedback:");
        lblFeedback.setFont(new Font("Arial", Font.BOLD, 18));
        lblFeedback.setBounds(670, 150, 200, 30);
        paneBg.add(lblFeedback);

        JTextArea feedbackInfo = new JTextArea();
        feedbackInfo.setText(feedback);
        feedbackInfo.setEditable(false);
        feedbackInfo.setBackground(colorMild);
      //  feedbackInfo.setForeground(Color.WHITE);
        feedbackInfo.setBorder(null);
        feedbackInfo.setFont(new Font("Arial", Font.PLAIN, 16));
        JScrollPane scrollFeedback = new JScrollPane(feedbackInfo);
        scrollFeedback.setBounds(550, 200, 350, 400);
        scrollFeedback.setBorder(null);
        paneBg.add(scrollFeedback);

        JButton btnBack = new JButton("Back");
        btnBack.setBounds(310, 650, 150, 50);
        btnBack.setFont(new Font("Arial", Font.BOLD, 18));
        btnBack.setBorder(null);
    //    btnBack.setOpaque(false);
        btnBack.setFocusable(true);
        btnBack.setBackground(colorDark);
        btnBack.setForeground(Color.WHITE);
        btnBack.addActionListener(e -> {
            previousFrame.setVisible(true);
            dispose();
        });
        paneBg.add(btnBack);

        JButton btnSave = new JButton("Save");
        btnSave.setBounds(550, 650, 150, 50);
        btnSave.setFont(new Font("Arial", Font.BOLD, 18));
        btnSave.setBorder(null);
    //    btnSave.setOpaque(false);
        btnSave.setFocusable(true);
        btnSave.setBackground(colorDark);
        btnSave.setForeground(Color.WHITE);
        btnSave.addActionListener(e -> {
            saveToDatabase(name, id, email, eventId, feedback);
            dispose();
        });
        paneBg.add(btnSave);

        setVisible(true);
    }

    private void saveToDatabase(String name, String id, String email, String eventId, String feedback) {
        
        String url = "jdbc:mysql://localhost:3306/users";
        String user = "root";
        String password = "elweng098*";

        String query = "INSERT INTO postevent (name, id, email, event_id, feedback) VALUES (?, ?, ?, ?, ?)";

        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = con.prepareStatement(query)) {

            preparedStatement.setString(1, name);
            preparedStatement.setString(2, id);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, eventId);
            preparedStatement.setString(5, feedback);

            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(this, "Data saved successfully!");
            } else {
                JOptionPane.showMessageDialog(this, "Failed to save data.");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error saving data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
