package com.mycompany.eventmanagementsystemmain;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class myEvent extends JFrame implements ActionListener {

    JLabel lblHeader, lblHeader2;
    JPanel pnlTop;
    JButton btnMyEvent, btnScheduleEvent, btnAboutUs, btnRefreshTable, btnBack;
    JTable eventTable;
    String[] columnNames = {"Event ID", "Event Name", "Name", "Date", "Event Duration", "Time of Event", "Status"};
    JScrollPane sclPane;
    private static DefaultTableModel tblModel;

    public myEvent() {
        // Frame settings
        setSize(1000, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);
        getContentPane().setBackground(new Color(244, 187, 255));

        // Side panel
        pnlTop = new JPanel();
        pnlTop.setLayout(null);
        pnlTop.setBounds(0, 0, 1000, 100);
        pnlTop.setBackground(new Color(201, 165, 207));
        add(pnlTop);
        
        lblHeader = new JLabel("Event Venture");
        lblHeader.setFont(new Font("Serif", Font.BOLD, 30));
        lblHeader.setForeground(new Color(66, 3, 104));
        lblHeader.setBounds(30, 30, 300, 40);
        pnlTop.add(lblHeader);

        lblHeader2 = new JLabel("Lists of Confirmed Events");
        lblHeader2.setFont(new Font("Serif", Font.BOLD, 28));
        lblHeader2.setForeground(new Color(66, 3, 104));
        lblHeader2.setBounds(30, 130, 500, 40);
        add(lblHeader2);

        // Buttons on the top panel
        btnMyEvent = new JButton("My Event");
        btnMyEvent.setBounds(330, 0, 300, 100);
        btnMyEvent.setFont(new Font("Serif", Font.ITALIC, 15));
        btnMyEvent.setFocusable(false);
        btnMyEvent.setContentAreaFilled(false);
        btnMyEvent.setOpaque(false);
        btnMyEvent.setBorderPainted(false);
        btnMyEvent.setFocusPainted(false);
        pnlTop.add(btnMyEvent);

        btnScheduleEvent = new JButton("Schedule an Event");
        btnScheduleEvent.setBounds(500, 0, 300, 100);
        btnScheduleEvent.setFont(new Font("Serif", Font.ITALIC, 15));
        btnScheduleEvent.setFocusable(false);
        btnScheduleEvent.setContentAreaFilled(false);
        btnScheduleEvent.setOpaque(false);
        btnScheduleEvent.setBorderPainted(false);
        btnScheduleEvent.setFocusPainted(false);
        pnlTop.add(btnScheduleEvent);

        btnAboutUs = new JButton("About Us");
        btnAboutUs.setBounds(650, 0, 300, 100);
        btnAboutUs.setFont(new Font("Serif", Font.ITALIC, 15));
        btnAboutUs.setFocusable(false);
        btnAboutUs.setContentAreaFilled(false);
        btnAboutUs.setOpaque(false);
        btnAboutUs.setBorderPainted(false);
        btnAboutUs.setFocusPainted(false);
        pnlTop.add(btnAboutUs);

        // Create the JTable and DefaultTableModel
        tblModel = new DefaultTableModel(columnNames, 0);
        eventTable = new JTable(tblModel);
        eventTable.setGridColor(new Color(66, 3, 104));
        eventTable.setShowGrid(true);
        fetchDataFromDatabase();

        sclPane = new JScrollPane(eventTable);
        sclPane.setBounds(30, 180, 920, 400);
        add(sclPane);

        // Refresh Table Button
        btnRefreshTable = new JButton("REFRESH TABLE");
        btnRefreshTable.setFocusable(false);
        btnRefreshTable.setBounds(380, 600, 190, 30);
        btnRefreshTable.setForeground(new Color(66, 3, 104));
        btnRefreshTable.setContentAreaFilled(false);
        btnRefreshTable.setBorder(BorderFactory.createLineBorder(new Color(66, 3, 104), 3));
        btnRefreshTable.setFocusPainted(false);
        btnRefreshTable.addActionListener(this);
        add(btnRefreshTable);

        // Back Button
        btnBack = new JButton("Back");
        btnBack.setBounds(800, 720, 150, 40);
        btnBack.setFont(new Font("Arial", Font.BOLD, 12));
        btnBack.setForeground(new Color(66, 3, 104));
        btnBack.setBorderPainted(false);
        btnBack.setContentAreaFilled(false);
        btnBack.setFocusPainted(false);
        btnBack.addActionListener(this);
        add(btnBack);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnRefreshTable) {
            fetchDataFromDatabase();
            JOptionPane.showMessageDialog(this, "Data successfully fetched from the database!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else if (e.getSource() == btnBack) {
            dispose();
        } else if (e.getSource() == btnScheduleEvent) {
            new celebrantInformationFormFINAL();
        }
    }
    
    private void fetchDataFromDatabase() {
    try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adminaddevent?useSSL=false", "root", "evs123");
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery("SELECT * FROM event")) {
        
        // Clear the current table data
        tblModel.setRowCount(0);
        
        // Loop through the result set and add rows to the table model
        while (rs.next()) {
            int eventID = rs.getInt("EventID");
            String eventName = rs.getString("EventName");
            String name = rs.getString("Name");
            String date = rs.getString("Date");
            String eventDuration = rs.getString("Duration");
            String timeOfEvent = rs.getString("Time");
            String status = rs.getString("Status");

            // Add each row to the table model
            tblModel.addRow(new Object[]{eventID, eventName, name, date, eventDuration, timeOfEvent, status});
        }
    } catch (SQLException e) {
        // Display an error message if something goes wrong
        JOptionPane.showMessageDialog(this, "Error fetching data from database: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}
    public static void main(String[] args) {
        new myEvent();
    }
}
