package com.mycompany.eventmanagementsystemmain;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class userDashForEvents extends JFrame implements ActionListener {

JLabel lblHeader, lblHeader2;
JPanel pnlTop;
JButton btnMyEvent, btnScheduleEvent, btnAboutUs, btnRefreshTable, btnBack, btnSearch;
JTable eventTable;
String[] columnNames = {"Event ID", "Event Name", "Name", "Date", "Event Duration", "Time of Event", "Status"};
JScrollPane sclPane;
private static DefaultTableModel tblModel;

 userDashForEvents() {
     
    // Frame settings
    setSize(1000, 800);
    setLocationRelativeTo(null);
    setTitle("EVENT VENTURE");
    setResizable(false);         
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(null);
    getContentPane().setBackground(new Color(190, 140, 229));

    lblHeader = new JLabel("Event Venture");
    lblHeader.setFont(new Font("Serif", Font.BOLD, 30));
    lblHeader.setForeground(new Color(66, 3, 104));
    lblHeader.setBounds(30, 30, 300, 40);


    lblHeader2 = new JLabel("List of Upcoming Events:");
    lblHeader2.setFont(new Font("Arial", Font.BOLD, 24));
    lblHeader2.setForeground(new Color(66, 3, 104));
    lblHeader2.setBounds(30, 130, 500, 40);
    add(lblHeader2);

  // Buttons on the top panel
   btnMyEvent = new JButton("My Event");
   btnMyEvent.setBounds(400, 0, 150, 100);
   btnMyEvent.setFont(new Font("Serif", Font.ITALIC, 15));
   btnMyEvent.setFocusable(false);
   btnMyEvent.setContentAreaFilled(false);
   btnMyEvent.setBorderPainted(false);
   btnMyEvent.setFocusPainted(false);
   btnMyEvent.addActionListener(this);


   btnScheduleEvent = new JButton("Schedule an Event");
   btnScheduleEvent.setBounds(550, 0, 150, 100);
   btnScheduleEvent.setFont(new Font("Serif", Font.ITALIC, 15));
   btnScheduleEvent.setFocusable(false);
   btnScheduleEvent.setContentAreaFilled(false);
   btnScheduleEvent.setBorderPainted(false);
   btnScheduleEvent.setFocusPainted(false);
   btnScheduleEvent.addActionListener(this);


   btnSearch = new JButton("Search Event");
   btnSearch.setBounds(700, 0, 150, 100);
   btnSearch.setFont(new Font("Serif", Font.ITALIC, 15));
   btnSearch.setFocusable(false);
   btnSearch.setContentAreaFilled(false);
   btnSearch.setBorderPainted(false);
   btnSearch.setFocusPainted(false);
   btnSearch.addActionListener(this);

   btnAboutUs = new JButton("About Us");
   btnAboutUs.setBounds(850, 0, 150, 100);
   btnAboutUs.setFont(new Font("Serif", Font.ITALIC, 15));
   btnAboutUs.setFocusable(false);
   btnAboutUs.setContentAreaFilled(false);
   btnAboutUs.setBorderPainted(false);
   btnAboutUs.setFocusPainted(false);
   btnAboutUs.addActionListener(this);

   pnlTop=new JPanel();
   pnlTop.setLayout(null);
   pnlTop.setBounds(-2, -2, 1000, 100);
   pnlTop.setBackground(new Color(213, 182, 238));
   pnlTop.setBorder(BorderFactory.createLineBorder(new Color(66, 3, 104), 3));
   add(pnlTop);
   pnlTop.add(lblHeader);
   pnlTop.add(btnMyEvent);
   pnlTop.add(btnScheduleEvent);
   pnlTop.add(btnSearch);
   pnlTop.add(btnAboutUs);

    // Create the JTable and DefaultTableModel
    tblModel = new DefaultTableModel(columnNames, 0);
    eventTable = new JTable(tblModel);
    eventTable.setGridColor(new Color(66, 3, 104));
    eventTable.setShowGrid(true);
    transposeDataToFields();

    sclPane = new JScrollPane(eventTable);
    sclPane.setBounds(30, 180, 920, 400);
    add(sclPane);

    // Refresh Table Button
    btnRefreshTable = new JButton("REFRESH TABLE");
    btnRefreshTable.setFocusable(false);
    btnRefreshTable.setBounds(380, 620, 190, 30);
    btnRefreshTable.setForeground(new Color(66, 3, 104));
    btnRefreshTable.setContentAreaFilled(false);
    btnRefreshTable.setBorder(BorderFactory.createLineBorder(new Color(66, 3, 104), 3));
    btnRefreshTable.setFocusPainted(false);
    btnRefreshTable.addActionListener(this);
    add(btnRefreshTable);

    // Back Button
    btnBack = new JButton("Back");
    btnBack.setBounds(840, 700, 150, 40);
    btnBack.setFont(new Font("Arial", Font.BOLD, 14));
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
        transposeDataToFields();
     boolean eventExists = false;
        if (!eventExists) {
         JOptionPane.showMessageDialog(this, "Table Refreshed",  "Reminder", JOptionPane.INFORMATION_MESSAGE);
      }
        } else if (e.getSource() == btnBack) {
             new userDashboard(); // back to dashboard
             dispose();
        } else if (e.getSource() == btnScheduleEvent) {
            new celebrantInformationForm(); //for scheduling events
            dispose();
        }else if(e.getSource()== btnAboutUs){
            new aboutUs();
            dispose();
        }  else if(e.getSource()== btnMyEvent){
            JOptionPane.showMessageDialog(null, "You're already here");
        }else if(e.getSource()== btnSearch){
            new userSearch();
            dispose();
        }
    }

//method for db connection for fetching data to be displayed on the page
private void transposeDataToFields() {
    try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/eventmanagement", "root", "1234");
     Statement stmt = conn.createStatement();
     ResultSet rs = stmt.executeQuery("SELECT * FROM event")) {


    tblModel.setRowCount(0); 
    
    while (rs.next()) {
    int eventID = rs.getInt("EventID");
    String eventName = rs.getString("EventName");
    String name = rs.getString("Name");
    String date = rs.getString("Date");
    String eventDuration = rs.getString("Duration");
    String timeOfEvent = rs.getString("Time");
    String status = rs.getString("Status");


     tblModel.addRow(new Object[]{eventID, eventName, name, date, eventDuration, timeOfEvent, status});

      } 
            
   } catch (SQLException e) {
    JOptionPane.showMessageDialog(this, "Error fetching data from database: " + e.getMessage(),    "Error", JOptionPane.ERROR_MESSAGE);
        }
     }
  }