/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.eventmanagementsystemmain;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


/**
 *
 * @author USER
 */
public class search extends JFrame implements ActionListener{
    
    JLabel lblHeader, lblHeader2, lblResult;
    JPanel pnlTop;
    JTextField jtfSearch;
    JButton btnSearch;
    JTable resultTable;
    DefaultTableModel tblModel;
    String[] columnNames = {"Event Name", "Name", "Date", "Event Duration", "Time of Event", "Status"}; 
    JScrollPane sclPane;
    ArrayList<Event> events;
    
    search(){    
        events= new ArrayList<>();
         
        //components code
        setSize(1000, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);
        getContentPane().setBackground(new Color(244, 187, 255));

        //Top panel
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
        
        //searchfield
        jtfSearch = new JTextField();
        jtfSearch.setBounds(300, 30, 400, 40);
        jtfSearch.setBorder(BorderFactory.createLineBorder(new Color(66, 3, 104), 2));
        pnlTop.add(jtfSearch);
        
        btnSearch = new JButton("🔍");
        btnSearch.setBounds(700, 30, 40, 40);
        btnSearch.setBorder(BorderFactory.createLineBorder(new Color(66, 3, 104), 2));
        btnSearch.setFocusable(false);
        btnSearch.setContentAreaFilled(false);
        btnSearch.addActionListener(this);
        pnlTop.add(btnSearch);
        
        tblModel = new DefaultTableModel(columnNames, 0); 
        resultTable = new JTable(tblModel); 
        resultTable.setGridColor(new Color(66, 3, 104));
        resultTable.setShowGrid(true); 
        
        lblResult = new JLabel("Result");
        lblResult.setFont(new Font("Serif", Font.BOLD, 28));
        lblResult.setForeground(new Color(66, 3, 104));
        lblResult.setBounds(40, 130, 500, 40);
        add(lblResult);
        
        sclPane = new JScrollPane(resultTable);
        sclPane.setBounds(30, 180, 920, 400);
        add(sclPane);
        
        fetchAllEvents();//get all the data from DB
        
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new search();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSearch){
            String searchQuery = jtfSearch.getText().trim(); //getting data 
            binarySearching(searchQuery); //code for  binary search
            jtfSearch.setText(""); //clear the textfield after searching
        }
        
    }
    //get all the data from DB
    private void fetchAllEvents() {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adminaddevent?useSSL=false", "root", "evs123")) {
            String sql = "SELECT * FROM event";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            events.clear(); // clear the list before adding data

            while (rs.next()) {
                 events.add(new Event(
                        rs.getInt("eventID"),
                        rs.getString("eventName"),
                        rs.getString("name"),
                        rs.getString("date"),
                        rs.getString("time"),
                        rs.getString("duration"),
                        rs.getString("status")
                ));
            }

            // Sort events by eventName for binary search
            Collections.sort(events, Comparator.comparing(Event::getEventName));

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Database error occurred while fetching events.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
        //binary search code
        private void binarySearching(String query) {
        tblModel.setRowCount(0); //clear the table
        
        boolean dateSearching = query.matches("\\d{4}-\\d{2}-\\d{2}");//checking if date matches
        
        //check if datesearching is true or false
        Comparator<Event> comparator = dateSearching ? Comparator.comparing(Event::getDate) :  Comparator.comparing(Event::getEventName);
        Collections.sort(events, comparator);
        
        //displaying results
        for (Event result : events){
            boolean match = dateSearching ? result.getDate().trim().equalsIgnoreCase(query.trim()) : result.getEventName().toLowerCase().contains(query.toLowerCase());
        
            //if match display
            if (match) {
                    tblModel.addRow(new Object[]{
                        result.getEventName(),
                        result.getName(),
                        result.getDate(),
                        result.getDuration(),
                        result.getTime(),
                        result.getStatus()
                    });
                }
        }
        //if not result found
        if (tblModel.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "No matching events or date found.", "Search Result", JOptionPane.ERROR_MESSAGE);
        }
    }

    //class to hold event data
    private static class Event {
        private int eventID;
        private String eventName, name, date, time, duration, status;

        public Event(int eventID, String eventName, String name, String date, String time, String duration, String status) {
            this.eventID = eventID;
            this.eventName = eventName;
            this.name = name;
            this.date = date;
            this.time = time;
            this.duration = duration;
            this.status = status;
        }

        public Event(String eventName) {
            this.eventName = eventName;
        }

        public String getEventName() {
            return eventName;
        }

        public String getName() {
            return name;
        }

        public String getDate() {
            return date;
        }

        public String getTime() {
            return time;
        }

        public String getDuration() {
            return duration;
        }

        public String getStatus() {
            return status;
        }
    }
}
    


