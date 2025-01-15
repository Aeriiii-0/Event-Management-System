
package com.mycompany.postEventOngoingg;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

// Post Event Analytics frame
public class postEventOngoingg extends JFrame implements ActionListener {
    JLabel lblTitle, lblAttendeeInfo;
    JTable tblAttendeeInfo;
    DefaultTableModel modelAttendeeInfo;
    JButton btnDelete, btnBack, btnShw;
    JPanel backgroundPanel;

    postEventOngoingg() {
        setTitle("Post Event Analytics");
        setSize(1000, 800);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(213, 182, 238)); // Frame background color

        // Title
        lblTitle = new JLabel("Post Event Analytics");
        lblTitle.setForeground(new Color(66, 3, 104));
        lblTitle.setFont(new Font("Serif", Font.BOLD, 25));
        lblTitle.setBounds(390, 20, 400, 50);
        add(lblTitle);

        // Background panel
        backgroundPanel = new JPanel();
        backgroundPanel.setBackground(new Color(190, 140, 229));
        backgroundPanel.setBounds(30, 100, 930, 600);
        backgroundPanel.setLayout(null);  // Allow positioning of components within this panel
        add(backgroundPanel);

        // Attendee Information Label
        lblAttendeeInfo = new JLabel("Attendee Information: ");
        lblAttendeeInfo.setFont(new Font("Serif", Font.BOLD, 20));
        lblAttendeeInfo.setForeground(new Color(66, 3, 104));
        lblAttendeeInfo.setBounds(370, 5, 250, 40);
        backgroundPanel.add(lblAttendeeInfo);

        // Column names for JTable
        String[] columnNames = {"ID", "Name", "Email", "EventID", "Feedback", "Status"};

        // Initialize Table Model
        modelAttendeeInfo = new DefaultTableModel(null, columnNames);

        // Attendee Information Table
        tblAttendeeInfo = new JTable(modelAttendeeInfo);
        tblAttendeeInfo.setBounds(70, 80, 750, 420); // Adjusted to use the full panel width
        tblAttendeeInfo.setBackground(new Color(213, 182, 238));
        tblAttendeeInfo.setFont(new Font("Serif", Font.PLAIN, 18));
        tblAttendeeInfo.setBorder(BorderFactory.createLineBorder(new Color(66, 3, 104), 2));
        tblAttendeeInfo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(tblAttendeeInfo);
        scrollPane.setBounds(15, 100, 900, 400);
        backgroundPanel.add(scrollPane);

        // Delete Button
        btnDelete = new JButton("Delete List");
        btnDelete.setFont(new Font("Serif", Font.BOLD, 18));
        btnDelete.setForeground(new Color(66, 3, 104));
        btnDelete.setBounds(15, 505, 150, 35);
        btnDelete.setBorder(BorderFactory.createLineBorder(new Color(66, 3, 104), 3));
        btnDelete.setFocusPainted(false);
        btnDelete.setContentAreaFilled(false);
        backgroundPanel.add(btnDelete);
        btnDelete.addActionListener(this);

        // Back Button
        btnBack = new JButton("Back");
        btnBack.setFont(new Font("Arial", Font.BOLD, 15));
        btnBack.setForeground(new Color(66, 3, 104));
        btnBack.setBounds(800, 560, 150, 35);
        btnBack.setBorderPainted(false);
        btnBack.setFocusPainted(false);
        btnBack.setContentAreaFilled(false);
        backgroundPanel.add(btnBack);
        btnBack.addActionListener(this);

        // Show List Button
        btnShw = new JButton("Show Event List");
        btnShw.setFont(new Font("Serif", Font.BOLD, 18));
        btnShw.setForeground(new Color(66, 3, 104));
        btnShw.setBounds(15, 58, 150, 35);
        btnShw.setBorder(BorderFactory.createLineBorder(new Color(66, 3, 104), 3));
        btnShw.setFocusPainted(false);
        btnShw.setContentAreaFilled(false);
        backgroundPanel.add(btnShw);
        btnShw.addActionListener(this);

        // Initially, JTable is empty
        modelAttendeeInfo.setRowCount(0);

        // Set visible
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnDelete) {
            // Delete selected row from the table
            int selectedRow = tblAttendeeInfo.getSelectedRow();
            if (selectedRow != -1) {
                modelAttendeeInfo.removeRow(selectedRow);
            } else {
                JOptionPane.showMessageDialog(this, "No row selected to delete.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == btnBack) {
            // Go back to the previous frame
            JOptionPane.showMessageDialog(this, "Going back to the previous page...");
            this.dispose(); // Close this frame
        } else if (e.getSource() == btnShw) {
            // Fetch and update data in JTable
            fetchDataFromDatabase();
        }
    }

    // Fetch data from MySQL database and populate JTable
    private void fetchDataFromDatabase() {
    try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/eventmanagement", "root", "elweng098*");
         Statement stmt1 = conn.createStatement();
         ResultSet rs1 = stmt1.executeQuery("SELECT id, name, email, eventId, feedback FROM attendee")) {

        // Clear the table before adding new data
        modelAttendeeInfo.setRowCount(0);

        while (rs1.next()) {
            int attendeeID = rs1.getInt("id");
            String attendeeName = rs1.getString("name");
            String attendeeEmail = rs1.getString("email");
            String eventID = rs1.getString("eventId");
            String feedback = rs1.getString("feedback");

            // Check event validity and if the date is in the past
            try (PreparedStatement stmt2 = conn.prepareStatement(
                    "SELECT eventId, eventName, name, date, time, duration, status " +
                    "FROM event " +
                    "WHERE eventId = ? AND date < CURDATE()")) { // Add condition to check for past dates
                stmt2.setString(1, eventID);
                ResultSet rs2 = stmt2.executeQuery();

                if (rs2.next()) {
                    String status = rs2.getString("status");

                    // Add attendee data and event status to the table
                    modelAttendeeInfo.addRow(new Object[]{attendeeID, attendeeName, attendeeEmail, eventID, feedback, status});
                }
            }
        }

        JOptionPane.showMessageDialog(this, "Table updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error fetching data from database: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }
}
