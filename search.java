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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USER
 */
public class search extends JFrame implements ActionListener {

    JLabel lblHeader, lblHeader2, lblResult;
    JPanel pnlTop;
    JTextField jtfSearch;
    JButton btnSearch;
    JTable resultTable;
    DefaultTableModel tblModel;
    String[] columnNames = {"Event Name", "Name", "Date", "Event Duration", "Time of Event", "Status"};
    JScrollPane sclPane;
    ArrayList<String> search;

    search() {
        search = new ArrayList<>();

        // components code
        setSize(1000, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);
        getContentPane().setBackground(new Color(244, 187, 255));

        // Top panel
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

        // search field
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

        fetchAllEvents(); // get all the data from DB

        setVisible(true);
    }

    public static void main(String[] args) {
        new search();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSearch) {
            String searchQuery = jtfSearch.getText().trim(); // getting data
            linearSearching(searchQuery); // code for linear search
            jtfSearch.setText(""); // clear the textfield after searching
        }

    }

    // get all the data from DB
    private void fetchAllEvents() {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adminaddevent?useSSL=false", "root", "evs123")) {
            String sql = "SELECT * FROM event";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
  
            //Clear the list before adding data
            search.clear(); 

            while (rs.next()) {
                //Store each row's data
                search.add(String.join(",",
                    rs.getString("eventName"),
                    rs.getString("name"),
                    rs.getString("date"),
                    rs.getString("time"),
                    rs.getString("duration"),
                    rs.getString("status")
                ));
            }

            //sort the data
            Collections.sort(search);

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Database error occurred while fetching search.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void linearSearching(String query) {
        tblModel.setRowCount(0); //Clear the table

        //check if the dateMatches
        boolean dateSearch = query.matches("\\d{4}-\\d{2}-\\d{2}");

        //loop for searching
        for (String event : search) {
            String[] eventData = event.split(",");
            
            //chech if date and eventName matches
            boolean match = dateSearch ? eventData[2].trim().equals(query.trim()) : eventData[0].toLowerCase().contains(query.toLowerCase());

            if (match) {
                //display data if match
                tblModel.addRow(new Object[]{
                    eventData[0], 
                    eventData[1], 
                    eventData[2],
                    eventData[3], 
                    eventData[4],
                    eventData[5]
                });
            }
        }

        //if no data matches
        if (tblModel.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "No Event or Date is found.", "Result", JOptionPane.ERROR_MESSAGE);
        }
    }
}
