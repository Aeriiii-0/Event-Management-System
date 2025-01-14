
package com.mycompany.eventmanagementsystemmain;



import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

// Post Event Analytics frame
public class PostEventAnalytics extends JFrame implements ActionListener {
    JLabel lblTitle, lblAttendeeInfo,lblAttendeeCount,lblFinalCount;
    JTable tblAttendeeInfo;
    DefaultTableModel modelAttendeeInfo;
    JButton btnBack, btnGenerateAnalytics;
    JPanel backgroundPanel;
    String[] columnNames = {"ID", "Name", "Email", "EventID", "Feedback"};
    
    PostEventAnalytics() {
        
        modelAttendeeInfo = new DefaultTableModel(null, columnNames);

        setTitle("Event Venture");
        setSize(1000, 800);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(213, 182, 238)); 

        // Title
        lblTitle = new JLabel("Post Event Analytics");
        lblTitle.setForeground(new Color(66, 3, 104));
        lblTitle.setFont(new Font("Arial", Font.BOLD, 30));
        lblTitle.setBounds(360, 35, 400, 50);
        

        // Background panel
        backgroundPanel = new JPanel();
        backgroundPanel.setLayout(null);
        backgroundPanel.setBounds(-1, -1, 1000, 110);
        backgroundPanel.setBackground(new Color(190, 140, 229));
        backgroundPanel.setBorder(BorderFactory.createLineBorder(new Color(66, 3, 104), 3));
        add(backgroundPanel);
        backgroundPanel.add(lblTitle);

        // Attendee Information Label
        lblAttendeeInfo = new JLabel("Attendee Information Forms ");
        lblAttendeeInfo.setFont(new Font("Arial", Font.BOLD, 17));
        lblAttendeeInfo.setForeground(new Color(66, 3, 104));
        lblAttendeeInfo.setBounds(30, 125, 250, 40);
        add(lblAttendeeInfo);
        
         // Total Attendee Label
        lblAttendeeCount = new JLabel("Total Attendees Registered:");
        lblAttendeeCount.setFont(new Font("Arial", Font.BOLD, 19));
        lblAttendeeCount.setForeground(new Color(66, 3, 104));
        lblAttendeeCount.setBounds(63, 635, 500, 40);
        add(lblAttendeeCount);
        
         // Attendee Count Label
        lblFinalCount = new JLabel("0");
        lblFinalCount.setFont(new Font("Arial", Font.BOLD, 17));
        lblFinalCount.setForeground(new Color(66, 3, 104));
        lblFinalCount.setBounds(330, 636, 250, 40);
        add(lblFinalCount);

        
        // Attendee Information Table
        modelAttendeeInfo.setRowCount(0);
        tblAttendeeInfo = new JTable(modelAttendeeInfo);
        tblAttendeeInfo.setFont(new Font("Serif", Font.PLAIN, 18));
        tblAttendeeInfo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        JScrollPane scrollPane = new JScrollPane(tblAttendeeInfo);
        scrollPane.setBounds(63, 170, 850, 460);
        add(scrollPane);


        // Back Button
        btnBack = new JButton("Done");
        btnBack.setFont(new Font("Arial", Font.BOLD, 15));
        btnBack.setForeground(new Color(66, 3, 104));
        btnBack.setBounds(860, 700, 150, 35);
        btnBack.setBorderPainted(false);
        btnBack.setFocusPainted(false);
        btnBack.setContentAreaFilled(false);
        add(btnBack);
        btnBack.addActionListener(this);

        // Show List Button
        btnGenerateAnalytics = new JButton("Generate Analytics");
        btnGenerateAnalytics.setFont(new Font("Arial", Font.BOLD, 15));
        btnGenerateAnalytics.setForeground(new Color(66, 3, 104));
        btnGenerateAnalytics.setBounds(737, 648, 180, 30);
        btnGenerateAnalytics.setBorder(BorderFactory.createLineBorder(new Color(66, 3, 104), 3));
        btnGenerateAnalytics.setFocusPainted(false);
        btnGenerateAnalytics.setContentAreaFilled(false);
        add(btnGenerateAnalytics);
        btnGenerateAnalytics.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
         if (e.getSource() == btnBack) {
           new welcomePage();
           dispose(); 
        } else if (e.getSource() == btnGenerateAnalytics) {
            fetchDataFromDatabase();
            updateRegisterCountFromLastId();
        }
    }

   
    private void fetchDataFromDatabase() {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/eventmanagement", "root", "1234");
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM attendee")) {
            
            modelAttendeeInfo.setRowCount(0);
            
            while (rs.next()) {
                int ID = rs.getInt("ID");
                String Name = rs.getString("Name");
                String Email = rs.getString("Email");
                String EventID = rs.getString("EventID");
                String Feedback = rs.getString("Feedback");

                
                modelAttendeeInfo.addRow(new Object[]{ID, Name, Email, EventID, Feedback});
            }

            JOptionPane.showMessageDialog(this, "Post-Analytics Released", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error fetching data from database: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void updateRegisterCountFromLastId() {
         try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/eventmanagement", "root", "1234")) {
        String query = "SELECT MAX(id) AS last_id FROM attendee";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            if (rs.next()) {
                int lastId = rs.getInt("last_id");
                 lblFinalCount.setText(""+ lastId);
            } else {
                
            }
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error fetching last attendee ID: " + e.getMessage());
    }
    }
 
}
