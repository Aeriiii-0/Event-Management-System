package com.mycompany.eventmanagementsystemmain;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class myEvent extends JFrame implements ActionListener {

    JLabel lblHeader, lblHeader2;
    JPanel pnlTop;
    JButton btnMyEvent, btnScheduleEvent, btnAboutUs, btnRefreshTable, btnBack;
    JTable eventTable;
    String[] columnNames = {"Event Name", "Name", "Date", "Event Duration", "Time of Event", "Status"};
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

        lblHeader2 = new JLabel("Events Lists ");
        lblHeader2.setFont(new Font("Serif", Font.BOLD, 28));
        lblHeader2.setForeground(new Color(66, 3, 104));
        lblHeader2.setBounds(30, 130, 500, 40);
        add(lblHeader2);

        // Buttons on the top panel
        btnMyEvent = new JButton("My Event");
        btnMyEvent.setBounds(330, 0, 300, 100);
        styleButton(btnMyEvent);
        pnlTop.add(btnMyEvent);

        btnScheduleEvent = new JButton("Schedule an Event");
        btnScheduleEvent.setBounds(500, 0, 300, 100);
        styleButton(btnScheduleEvent);
        pnlTop.add(btnScheduleEvent);

        btnAboutUs = new JButton("About Us");
        btnAboutUs.setBounds(650, 0, 300, 100);
        styleButton(btnAboutUs);
        pnlTop.add(btnAboutUs);

        // Create the JTable and DefaultTableModel
        tblModel = new DefaultTableModel(columnNames, 0);
        eventTable = new JTable(tblModel);
        eventTable.setGridColor(new Color(66, 3, 104));
        eventTable.setShowGrid(true);

        // Load events into the table from the file
        readDataFromFile();

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
         // Ensure the button is on top

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
         // Ensure the button is on top
        setVisible(true);
    }

    private void styleButton(JButton button) {
        button.setFont(new Font("Serif", Font.ITALIC, 15));
        button.setFocusable(false);
        button.setContentAreaFilled(false);
        button.setOpaque(false);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
    }

    private void readDataFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader("userData.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",\\s*"); // Handle spaces after commas
                if (data.length == 6) {
                    // Add the row directly to the table model
                    tblModel.addRow(new Object[]{data[0], data[1], data[2], data[3], data[4], data[5]});
                } else {
                    System.err.println("Invalid line format: " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading userData.txt: " + e.getMessage());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnRefreshTable) {
            // Clear the table and reload the data
            tblModel.setRowCount(0);
            readDataFromFile();
        } else if (e.getSource() == btnBack) {
            // Handle the back button action
            System.out.println("Back button pressed!");
            dispose(); // Close the current window
            // Optionally, navigate to the previous screen
        } else if (e.getSource() == btnAboutUs){
            
        } else if (e.getSource() == btnScheduleEvent){
            new celebrantInformationFormFINAL();
        }
    }
}
