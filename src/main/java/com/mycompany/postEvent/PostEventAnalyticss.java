package com.mycompany.postEvent;

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

// Post Event Analytics frame
public class PostEventAnalyticss extends JFrame implements ActionListener {
    JLabel lblTitle, lblAttendeeInfo;
    JTable tblAttendeeInfo;
    DefaultTableModel modelAttendeeInfo;
    JButton btnDelete, btnBack, btnShw;
    JPanel backgroundPanel;

    PostEventAnalyticss() {
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
        backgroundPanel.setBounds(70, 100, 850, 600);
        backgroundPanel.setLayout(null);  // Allow positioning of components within this panel
        add(backgroundPanel);

        // Attendee Information Label
        lblAttendeeInfo = new JLabel("Attendee Information: ");
        lblAttendeeInfo.setFont(new Font("Serif", Font.BOLD, 20));
        lblAttendeeInfo.setForeground(new Color(66, 3, 104));
        lblAttendeeInfo.setBounds(330, 5, 250, 40);
        backgroundPanel.add(lblAttendeeInfo);

        // Column names for JTable
        String[] columnNames = {"ID", "Name", "Email", "EventID", "Feedback"};

        // Initialize Table Model
        modelAttendeeInfo = new DefaultTableModel(null, columnNames);

        // Attendee Information Table
        tblAttendeeInfo = new JTable(modelAttendeeInfo);
        tblAttendeeInfo.setBounds(50, 80, 750, 420); // Adjusted to use the full panel width
        tblAttendeeInfo.setBackground(new Color(213, 182, 238));
        tblAttendeeInfo.setFont(new Font("Serif", Font.PLAIN, 18));
        tblAttendeeInfo.setBorder(BorderFactory.createLineBorder(new Color(66, 3, 104), 2));
        tblAttendeeInfo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(tblAttendeeInfo);
        scrollPane.setBounds(50, 100, 750, 400);
        backgroundPanel.add(scrollPane);

        // Delete Button
        btnDelete = new JButton("Delete List");
        btnDelete.setFont(new Font("Serif", Font.BOLD, 18));
        btnDelete.setForeground(new Color(66, 3, 104));
        btnDelete.setBounds(50, 505, 150, 35);
        btnDelete.setBorder(BorderFactory.createLineBorder(new Color(66, 3, 104), 3));
        btnDelete.setFocusPainted(false);
        btnDelete.setContentAreaFilled(false);
        backgroundPanel.add(btnDelete);
        btnDelete.addActionListener(this);

        // Back Button
        btnBack = new JButton("Back");
        btnBack.setFont(new Font("Arial", Font.BOLD, 15));
        btnBack.setForeground(new Color(66, 3, 104));
        btnBack.setBounds(740, 560, 150, 35);
        btnBack.setBorderPainted(false);
        btnBack.setFocusPainted(false);
        btnBack.setContentAreaFilled(false);
        backgroundPanel.add(btnBack);
        btnBack.addActionListener(this);

        // Show List Button
        btnShw = new JButton("Show List");
        btnShw.setFont(new Font("Serif", Font.BOLD, 18));
        btnShw.setForeground(new Color(66, 3, 104));
        btnShw.setBounds(50, 58, 150, 35);
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
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM event")) {
            
            // Clear the table before adding new data
            modelAttendeeInfo.setRowCount(0);
            
            while (rs.next()) {
                int ID = rs.getInt("ID");
                String Name = rs.getString("Name");
                String Email = rs.getString("Email");
                String EventID = rs.getString("EventID");
                String Feedback = rs.getString("Feedback");

                // Add the data to the table
                modelAttendeeInfo.addRow(new Object[]{ID, Name, Email, EventID, Feedback});
            }

            JOptionPane.showMessageDialog(this, "Table updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error fetching data from database: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
