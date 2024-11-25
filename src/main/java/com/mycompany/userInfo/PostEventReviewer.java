package com.mycompany.userInfo;

import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.*;

public class PostEventReviewer extends JFrame {
    public PostEventReviewer(String name, String id, String email, String eventId, String feedback, JFrame previousFrame) {
        // Define colors to match UserInformation
        Color colorLight = new Color(213, 182, 238);
        Color colorMild = new Color(190, 140, 229);
        Color colorDark = new Color(144, 5, 229);

        setTitle("Event Analytics");
        setSize(1000, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        // Background panel
        JPanel panelBackground = new JPanel(null);
        panelBackground.setBackground(colorLight);
        panelBackground.setBounds(0, 0, 1000, 800);
        add(panelBackground);

        // Headline panel
        JPanel panelHeadline = new JPanel(null);
        panelHeadline.setBackground(colorMild);
        panelHeadline.setBounds(0, 0, 1000, 100);
        panelBackground.add(panelHeadline);

        JLabel lblTitle = new JLabel("Post-Event Analytics", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 25));
        lblTitle.setForeground(Color.WHITE);
        lblTitle.setBounds(0, 30, 1000, 40);
        panelHeadline.add(lblTitle);

        // Attendance Form list
        JLabel lblAttendee = new JLabel("Attendee Form");
        lblAttendee.setFont(new Font("Arial", Font.BOLD, 18));
        lblAttendee.setBounds(190, 150, 150, 30);
        lblAttendee.setForeground(Color.WHITE);
        panelBackground.add(lblAttendee);

        DefaultListModel<String> attendeeModel = new DefaultListModel<>();
        if (name != null && !name.isEmpty()) attendeeModel.addElement("Name: " + name);
        if (id != null && !id.isEmpty()) attendeeModel.addElement("ID: " + id);
        if (email != null && !email.isEmpty()) attendeeModel.addElement("Email: " + email);
        if (eventId != null && !eventId.isEmpty()) attendeeModel.addElement("Event ID: " + eventId);

        JList<String> attendeeList = new JList<>(attendeeModel);
        JScrollPane scrollAttendee = new JScrollPane(attendeeList);
        scrollAttendee.setBounds(110, 200, 300, 370);
        attendeeList.setBackground(colorMild);
        attendeeList.setForeground(Color.WHITE);
        attendeeList.setFont(new Font("Arial", Font.PLAIN, 16));
        panelBackground.add(scrollAttendee);

        // Feedback Form list
        JLabel lblFeedBck = new JLabel("Feedback Form");
        lblFeedBck.setFont(new Font("Arial", Font.BOLD, 18));
        lblFeedBck.setBounds(660, 150, 150, 30);
        lblFeedBck.setForeground(Color.WHITE);
        panelBackground.add(lblFeedBck);

        DefaultListModel<String> feedBckModel = new DefaultListModel<>();
        if (feedback != null && !feedback.isEmpty()) {
            feedBckModel.addElement(feedback);
        }

        JList<String> feedBckList = new JList<>(feedBckModel);
        JScrollPane scrollFeedBck = new JScrollPane(feedBckList);
        scrollFeedBck.setBounds(570, 200, 300, 370);
        feedBckList.setBackground(colorMild);
        feedBckList.setForeground(Color.WHITE);
        feedBckList.setFont(new Font("Arial", Font.PLAIN, 16));
        panelBackground.add(scrollFeedBck);

        // Back button
        JButton btnBck = new JButton("Back");
        btnBck.setBounds(185, 600, 150, 50);
        btnBck.setFont(new Font("Arial", Font.BOLD, 18));
        btnBck.setBackground(colorDark);
        btnBck.setForeground(Color.WHITE);
        btnBck.addActionListener(e -> {
            previousFrame.setVisible(true);
            this.dispose();
        });
        panelBackground.add(btnBck);

        // Save button
        JButton btnSave = new JButton("Save");
        btnSave.setBounds(645, 600, 150, 50);
        btnSave.setFont(new Font("Arial", Font.BOLD, 18));
        btnSave.setBackground(colorDark);
        btnSave.setForeground(Color.WHITE);
        btnSave.addActionListener(e -> {
        saveToDatabase(name, id, email, eventId, feedback);
        this.dispose(); // Close the current frame after saving
        });
        panelBackground.add(btnSave);

        setVisible(true);
    }

    private void saveToDatabase(String name, String id, String email, String eventId, String feedback) {
        String url = "jdbc:mysql://localhost:3306/users";
        String user = "root";
        String password = "elweng098*";

        String query = "INSERT INTO postevent (name, id, email, event_id, feedback) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, name);
            preparedStatement.setString(2, id);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, eventId);
            preparedStatement.setString(5, feedback);

            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(this, "Data saved successfully!");
            } else {
                JOptionPane.showMessageDialog(this, "Failed to save data.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error saving data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }
}
