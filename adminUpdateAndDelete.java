
package com.mycompany.eventmanagementsystemmain;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class adminUpdateAndDelete extends JFrame implements ActionListener {
JLabel lblHeader, lblEventName, lblName, lblDate, lblTimeDuration, lblTimeEvent, lblQueue;
JPanel pnlNorth, pnlCenter, pnlEast;
JTextField  tfName, tfDate, tfTimeEvent;
JTextArea txaNotif;
JButton btnRefreshTable,btnUpdate,btnDelete , btnBack;
JComboBox cmbDuration, cmbEventName;
String [] eventName= {"Select Option","Birthday","Christening","Wedding"};
String [] eventDuration = {"Select Option", "2 hours", "3 hours and half hours" , "5 hours"}; 
String[] columnNames = {"Event ID", "Event Name", "Name", "Date", "Event Duration", "Time of Event", "Status"};
JScrollPane sclPane;
DefaultTableModel tblModel;
JTable eventTable;
    
adminUpdateAndDelete(){

    //component settings
     setSize(1000, 800);
    setLocationRelativeTo(null);
    setTitle("EVENT VENTURE");
    setResizable(false);         
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(null);

     //top panel
    pnlNorth = new JPanel();
    pnlNorth.setLayout(null);
    pnlNorth.setBounds(0, -1, 999, 110);
    pnlNorth.setBackground(new Color(190, 140, 229));

    txaNotif = new JTextArea("  NOTIFICATIONS: ");
    txaNotif.setBounds(15, 17, 955, 80);
    txaNotif.setBackground(new Color(213, 182, 238));
    txaNotif.setFont(new Font("Serif", Font.BOLD, 15));
    txaNotif.setForeground(new Color(66, 3, 104));
    txaNotif.setBorder(BorderFactory.createLineBorder(new Color(66, 3, 104), 3));
    txaNotif.setLineWrap(true);  
    txaNotif.setWrapStyleWord(true);
    txaNotif.setEditable(false);
    pnlNorth.add(txaNotif);

     //center panel
    pnlCenter = new JPanel();
    pnlCenter.setLayout(null);
    pnlCenter.setBounds(0, 109, 1000, 598);
    pnlCenter.setBackground(new Color(213, 182, 238));

    //labels setting. added in center panel.
    lblQueue = new JLabel("Event Database:");
    lblQueue.setFont(new Font("Arial", Font.BOLD, 15));
    lblQueue.setBounds(25, 10, 400, 20);
    lblQueue.setForeground(new Color(66, 3, 104));
    pnlCenter.add(lblQueue);

    lblEventName = new JLabel("Event Name: ");
    lblEventName.setFont(new Font("Arial", Font.BOLD, 17));
    lblEventName.setForeground(new Color(66, 3, 104));
    lblEventName.setBounds(675, 30, 200, 40);
    pnlCenter.add(lblEventName);

    lblName = new JLabel("Name: ");
    lblName.setFont(new Font("Arial", Font.BOLD, 17));
    lblName.setForeground(new Color(66, 3, 104));
    lblName.setBounds(675, 120, 200, 40);
    pnlCenter.add(lblName);

    lblDate = new JLabel("Date: ");
    lblDate.setFont(new Font("Arial", Font.BOLD, 17));
    lblDate.setForeground(new Color(66, 3, 104));
    lblDate.setBounds(675, 210, 200, 40);
    pnlCenter.add(lblDate);

    lblTimeDuration = new JLabel("Time Duration:");
    lblTimeDuration.setFont(new Font("Arial", Font.BOLD, 17));
    lblTimeDuration.setForeground(new Color(66, 3, 104));
    lblTimeDuration.setBounds(675, 300, 200, 40);
    pnlCenter.add(lblTimeDuration);

    lblTimeEvent = new JLabel("Time of Event:");
    lblTimeEvent.setFont(new Font("Arial", Font.BOLD, 17));
    lblTimeEvent.setForeground(new Color(66, 3, 104));
    lblTimeEvent.setBounds(675, 390, 200, 40);
    pnlCenter.add(lblTimeEvent);

     //table settings
    tblModel = new DefaultTableModel(columnNames, 0); 
    eventTable = new JTable(tblModel); 
    eventTable.setGridColor(new Color(66, 3, 104));
    eventTable.setShowGrid(true); 

    sclPane = new JScrollPane(eventTable); 
    sclPane.setBounds(30, 40, 610, 490); 
    pnlCenter.add(sclPane);

   //textfields and combo boxes setting. added in center panel.
    cmbEventName = new JComboBox(eventName);
    cmbEventName.setBounds(675, 65, 280, 40);
    cmbEventName.setBackground(new Color(190, 140, 229));
    cmbEventName.setForeground(new Color(66, 3, 104));
    cmbEventName.setFont(new Font("Serif",Font.BOLD,17));
    cmbEventName.setBorder(BorderFactory.createLineBorder(new Color(66, 3, 104), 3));
    pnlCenter.add(cmbEventName);

    tfName = new JTextField();
    tfName.setBounds(675, 155, 280, 40);
    tfName.setBackground(new Color(190, 140, 229));
    tfName.setForeground(new Color(66, 3, 104));
    tfName.setFont(new Font("Serif",Font.BOLD,17));
    tfName.setBorder(BorderFactory.createLineBorder(new Color(66, 3, 104), 3));
    pnlCenter.add(tfName);

    tfDate = new JTextField();
    tfDate.setBounds(675, 245, 280, 40);
    tfDate.setBackground(new Color(190, 140, 229));
    tfDate.setForeground(new Color(66, 3, 104));
    tfDate.setFont(new Font("Serif",Font.BOLD,17));
    tfDate.setBorder(BorderFactory.createLineBorder(new Color(66, 3, 104), 3));
    pnlCenter.add(tfDate);

    cmbDuration = new JComboBox<>(eventDuration);  
    cmbDuration.setBorder(null);
    cmbDuration.setBounds(675, 335, 280, 40);  
    cmbDuration.setBackground(new Color(190, 140, 229));
    cmbDuration.setFont(new Font("Serif",Font.BOLD,17));
    cmbDuration.setForeground(new Color(66, 3, 104));
    cmbDuration.setBorder(BorderFactory.createLineBorder(new Color(66, 3, 104), 3));
    pnlCenter.add(cmbDuration);

    tfTimeEvent = new JTextField();
    tfTimeEvent.setBounds(675, 425, 280, 40);
    tfTimeEvent.setBackground(new Color(190, 140, 229));
    tfTimeEvent.setForeground(new Color(66, 3, 104));
    tfTimeEvent.setFont(new Font("Serif",Font.BOLD,17));
    tfTimeEvent.setBorder(BorderFactory.createLineBorder(new Color(66, 3, 104), 3));
    pnlCenter.add(tfTimeEvent);


    //buttons setting. bounds are derived from center panel.
    btnDelete = new JButton("DELETE EVENT");
    btnDelete.setFocusable(false);
    btnDelete.setBounds(30, 548, 190, 30);
    btnDelete.setForeground(new Color(66, 3, 104));
    btnDelete.setContentAreaFilled(false);  
    btnDelete.setBorder(BorderFactory.createLineBorder(new Color(66, 3, 104), 3));
    btnDelete.setFocusPainted(false);
    btnDelete.addActionListener(this);
    pnlCenter.add(btnDelete);

    btnRefreshTable = new JButton("REFRESH TABLE");
    btnRefreshTable.setFocusable(false);
    btnRefreshTable.setBounds(240, 548, 190, 30); 
    btnRefreshTable.setForeground(new Color(66, 3, 104));
    btnRefreshTable.setContentAreaFilled(false);  
    btnRefreshTable.setBorder(BorderFactory.createLineBorder(new Color(66, 3, 104), 3));
    btnRefreshTable.setFocusPainted(false);
    btnRefreshTable.addActionListener(this);
    pnlCenter.add(btnRefreshTable);

    btnUpdate = new JButton("UPDATE EVENT");
    btnUpdate.setFocusable(false);
    btnUpdate.setBounds(450, 548, 190, 30);
    btnUpdate.setForeground(new Color(66, 3, 104));
    btnUpdate.setContentAreaFilled(false);  
    btnUpdate.setBorder(BorderFactory.createLineBorder(new Color(66, 3, 104), 3));
    btnUpdate.setFocusPainted(false);
    btnUpdate.addActionListener(this);
    pnlCenter.add(btnUpdate);

    //frame derived button bounds and setting.
    btnBack=new JButton("Back");
    btnBack.setBounds(857, 717, 200, 50);
    btnBack.setFont(new Font("Arial",Font.BOLD,12));
    btnBack.setForeground(new Color(66, 3, 104));
    btnBack.setBorderPainted(false);
    btnBack.setContentAreaFilled(false);
    btnBack.setFocusPainted(false);
    add(btnBack);
    btnBack.addActionListener(this);

     //east panel setting (bottom panel)
    pnlEast = new JPanel();
    pnlEast.setBounds(0, 663, 1000, 110);
    pnlEast.setLayout(null);
    pnlEast.setBackground(new Color(190, 140, 229));

    lblHeader = new JLabel("ADMIN EVENT DATABASE");
    lblHeader.setFont(new Font("Arial", Font.BOLD, 25));
    lblHeader.setBounds(337, 705, 400, 60);
    lblHeader.setForeground(new Color(66, 3, 104));
    add(lblHeader);

    // Create the JTable and DefaultTableModel
   tblModel = new DefaultTableModel(columnNames, 0);
   eventTable = new JTable(tblModel);
   eventTable.setGridColor(new Color(66, 3, 104));
   eventTable.setShowGrid(true);
   eventTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

   sclPane = new JScrollPane(eventTable);
   sclPane.setBounds(30, 149, 610, 490); ;
   add(sclPane);

    //table additionals: actionListener.
    eventTable.getSelectionModel().addListSelectionListener(event -> {
    if (!event.getValueIsAdjusting() && eventTable.getSelectedRow() != -1) {
        transposeDataToFields(eventTable.getSelectedRow()); //method for transposing the data from table to fields.
    }
 });

    //addition of all the panels, ensuring its components' visibility.      
    add(pnlCenter);
    add(pnlEast);
    add(pnlNorth);

    setVisible(true);
    
  } 

  @Override
 public void actionPerformed(ActionEvent e) {
     if(e.getSource()==btnUpdate){
          try {
            int selectedRow = eventTable.getSelectedRow();
            
             if(selectedRow != -1) { //validating if there's selected index.
                updateEvent(selectedRow); //method for editing/updating data to the database.
            } 
            else {
                JOptionPane.showMessageDialog(null, "Please select an event to update");
            }
        }catch (SQLException ex) {
            Logger.getLogger(adminUpdateAndDelete.class.getName()).log(Level.SEVERE, null, ex); //exception handling.
        } 
     }
   else if(e.getSource()==btnDelete){
       int selectedRow = eventTable.getSelectedRow(); 
       
       if(selectedRow != -1) { //validating if there's selected index.
           deleteEventToDatabase(selectedRow); //method for deleting event to the database.
       }
       else {
           JOptionPane.showMessageDialog(null, "Please select an event to delete");
       }
}
    else if(e.getSource()==btnRefreshTable){
             retrieveDataToDatabase(); //getting data from database to the frame.
         }
   else if(e.getSource()==btnBack){
             new adminDashboard(); //back to the general admin frame.
             dispose();
         }
     }
     
     
  //Methods for Updating, Deleting, Refresh and going back to the previous frame.  
     
   // Method to update the selected event in the database  
    private void updateEvent(int selectedRow) throws SQLException {
     
    //collecting field inputs.
    String eventName = cmbEventName.getSelectedItem().toString();
    String name = tfName.getText();
    String date = tfDate.getText();
    String duration = cmbDuration.getSelectedItem().toString();
    String timeEvent = tfTimeEvent.getText();
    
   int eventID = Integer.parseInt(tblModel.getValueAt(selectedRow, 0).toString()); //gathering the eventId from the selected index from the table.

    // Database connection
    try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/eventmanagement", "root", "1234")) {
     String query = "UPDATE event SET eventName=?, name=?, date=?, duration=?, time=?, status=? WHERE EventID=?"; //query for updating the row.
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            //giving query parameters.
            stmt.setString(1, eventName);
            stmt.setString(2, name);
            stmt.setString(3, date);
            stmt.setString(4, duration);
            stmt.setString(5, timeEvent);
            stmt.setString(6, "Event Confirmed");
            stmt.setInt(7, eventID);
            
            //execute the update.
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(this, "Event updated successfully.");
                txaNotif.setText("Event has been updated in the database.");
                retrieveDataToDatabase(); //refrehing the table from the recent update.
                setFields();
            } else {
                JOptionPane.showMessageDialog(this, "No event found with the provided ID.", "Error", JOptionPane.ERROR_MESSAGE);
                setFields();
            }
        }
    } catch (SQLException ex) { //exception handling.
        JOptionPane.showMessageDialog(this, "Error updating event: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        ex.printStackTrace();
    }
}
    // Method to refresh the data in the table from the database
    private void retrieveDataToDatabase() {

    try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/eventmanagement", "root", "1234");
      Statement stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery("SELECT * FROM event")) {


     tblModel.setRowCount(0); //clear current rows.

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
        JOptionPane.showMessageDialog(this, "Error fetching data from database: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
       JOptionPane.showMessageDialog(null, "Table Refreshed", "Refreshing", JOptionPane.INFORMATION_MESSAGE);
    }
       
      
//transfering data from table to fields.    
 private void transposeDataToFields(int selectedRow) {
    
    //gather the values from the table's selected row/index.
    String eventName = tblModel.getValueAt(selectedRow, 1).toString();
    String name = tblModel.getValueAt(selectedRow, 2).toString();
    String date = tblModel.getValueAt(selectedRow, 3).toString();
    String duration = tblModel.getValueAt(selectedRow, 4).toString();
    String timeEvent = tblModel.getValueAt(selectedRow, 5).toString();

    //distribute them to their respective fields.
    cmbEventName.setSelectedItem(eventName);
    tfName.setText(name);
    tfDate.setText(date);
    cmbDuration.setSelectedItem(duration);
    tfTimeEvent.setText(timeEvent);
}

// Method to delete the selected event
 private void deleteEventToDatabase(int selectedRow){
    
  int eventID = Integer.parseInt(tblModel.getValueAt(selectedRow, 0).toString()); //gathering the eventId from the selected index from the table.

    //Mysql connection
     try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/eventmanagement", "root", "1234")) {
       String query = "DELETE FROM event WHERE EventID=?";   // SQL query to delete the event
       try (PreparedStatement stmt = connection.prepareStatement(query)) {
       stmt.setInt(1, eventID);

     //execution of deleting event.
     int rowsDeleted = stmt.executeUpdate();
     if (rowsDeleted > 0) {
        
        JOptionPane.showMessageDialog(this, "Event deleted successfully.");
        txaNotif.setText("Event has been removed from the database.");
        tblModel.removeRow(selectedRow); 
        setFields();
   } 
   else {
       JOptionPane.showMessageDialog(this, "No event found with the provided ID.", "Error", JOptionPane.ERROR_MESSAGE);
       setFields();
     } 
   }
 } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Error deleting event: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        ex.printStackTrace();
     }
   }
 private void setFields(){
    tfDate.setText("");
    tfName.setText("");
    tfTimeEvent.setText("");
    cmbDuration.setSelectedIndex(0);
    cmbEventName.setSelectedIndex(0);
    }
 }