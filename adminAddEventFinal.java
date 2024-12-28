package com.mycompany.eventmanagementsystemmain;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author USER
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.PriorityQueue;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;


public class adminAddEventFinal extends JFrame implements ActionListener{
    
    JLabel lblHeader, lblEventName, lblName, lblDate, lblAttendees, lblTimeDuration, lblTimeEvent, lblQueue;
    JPanel pnlNorth, pnlCenter, pnlEast;
    JTextField tfEventName, tfName, tfDate, tfAttendees, tfTimeEvent;
    JTextArea txaNotif;
    JButton btnAddEvent, btnUpdateDataBase, btnBack, btnRefreshTable;
    String inputEventId, inputDate, inputName, inputAttendees,inputTimeDuration,inputTimeOfEvent;
    JComboBox cmbDuration, cmbAttendees;
    JScrollPane scrollPane;
//    JList<String> list;
//    DefaultListModel<String> listModel;
    DefaultTableModel tableModel;
    JTable eventTable;
    String [] eventDuration = {"Select Option", "2 hours", "3 hours and half hours" , "5 hours"}; 
    String [] eventAttendees = {"Select Option", "20persons", "35persons" , "50persons"}; 
    PriorityQueue<Event> queue;
    
    adminAddEventFinal(){
        
        queue = new PriorityQueue<>();

        //component settings
        setSize(1000, 800);
        setTitle("Event Venture");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(true);
        getContentPane().setBackground(new Color(213, 182, 238));
        setLocationRelativeTo(null);
        setLayout(null);

        pnlNorth = new JPanel();
        pnlNorth.setLayout(null);
        pnlNorth.setBounds(0, 0, 1000, 90);
        pnlNorth.setBackground(new Color(190, 140, 229));
        pnlNorth.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));

        pnlCenter = new JPanel();
        pnlCenter.setLayout(null);
        pnlCenter.setBounds(0, 89, 1000, 600);
        pnlCenter.setBackground(new Color(213, 182, 238));

        pnlEast = new JPanel();
        pnlEast.setBounds(30, 640, 925, 100);
        pnlEast.setLayout(null);
        pnlEast.setBackground(new Color(190, 140, 229));

        lblHeader = new JLabel("ADMIN APPROVAL SLIP");
        lblHeader.setFont(new Font("Arial", Font.BOLD, 30));
        lblHeader.setBounds(320, 15, 400, 60);
        lblHeader.setForeground(new Color(66, 3, 104));
        pnlNorth.add(lblHeader);

        lblEventName = new JLabel("Event Name: ");
        lblEventName.setFont(new Font("Arial", Font.BOLD, 17));
        lblEventName.setForeground(new Color(66, 3, 104));
        lblEventName.setBounds(675, 30, 200, 40);

        lblName = new JLabel("Name: ");
        lblName.setFont(new Font("Arial", Font.BOLD, 17));
        lblName.setForeground(new Color(66, 3, 104));
        lblName.setBounds(675, 120, 200, 40);

        lblDate = new JLabel("Date: ");
        lblDate.setFont(new Font("Arial", Font.BOLD, 17));
        lblDate.setForeground(new Color(66, 3, 104));
        lblDate.setBounds(675, 210, 200, 40);    

        lblAttendees = new JLabel("Attendees: ");
        lblAttendees.setFont(new Font("Arial", Font.BOLD, 17));
        lblAttendees.setForeground(new Color(66, 3, 104));
        lblAttendees.setBounds(675, 300, 200, 40);

        lblTimeDuration = new JLabel("Time Duration");
        lblTimeDuration.setFont(new Font("Arial", Font.BOLD, 13));
        lblTimeDuration.setForeground(new Color(66, 3, 104));
        lblTimeDuration.setBounds(675, 470, 200, 40);

        lblTimeEvent = new JLabel("Time of Event");
        lblTimeEvent.setFont(new Font("Arial", Font.BOLD, 13));
        lblTimeEvent.setForeground(new Color(66, 3, 104));
        lblTimeEvent.setBounds(675, 390, 200, 40);

        lblQueue = new JLabel("In Queue: ");
        lblQueue.setFont(new Font("Arial", Font.BOLD, 13));
        lblQueue.setForeground(new Color(66, 3, 104));
        lblQueue.setBounds(30, 5, 200, 40);

        pnlCenter.add(lblEventName);
        pnlCenter.add(lblName);
        pnlCenter.add(lblDate);
        pnlCenter.add(lblAttendees);
        pnlCenter.add(lblTimeDuration);
        pnlCenter.add(lblTimeEvent);
        pnlCenter.add(lblQueue);


        tfEventName = new JTextField();
        tfEventName.setBounds(675, 65, 280, 40);
        tfEventName.setBackground(new Color(190, 140, 229));
        tfEventName.setForeground(new Color(66, 3, 104));

        tfName = new JTextField();
        tfName.setBounds(675, 155, 280, 40);
        tfName.setBackground(new Color(190, 140, 229));
        tfName.setForeground(new Color(66, 3, 104));

        tfDate = new JTextField();
        tfDate.setBounds(675, 245, 280, 40);
        tfDate.setBackground(new Color(190, 140, 229));
        tfDate.setForeground(new Color(66, 3, 104));

        tfTimeEvent = new JTextField();
        tfTimeEvent.setBounds(675, 425, 280, 40);
        tfTimeEvent.setBackground(new Color(190, 140, 229));
        tfTimeEvent.setForeground(new Color(66, 3, 104));

        pnlCenter.add(tfEventName);
        pnlCenter.add(tfName);
        pnlCenter.add(tfDate);
        pnlCenter.add(tfTimeEvent);

        cmbDuration = new JComboBox<>(eventDuration);  
        cmbDuration.setBorder(null);
        cmbDuration.setBounds(675, 505, 280, 40); 
        cmbDuration.setBackground(new Color(190, 140, 229));
        cmbDuration.setFont(new Font("Serif",Font.BOLD,15));
        cmbDuration.setForeground(new Color(66, 3, 104));
        pnlCenter.add(cmbDuration);

        cmbAttendees = new JComboBox<>(eventAttendees);  
        cmbAttendees.setBorder(null);
        cmbAttendees.setBounds(675, 335, 280, 40); 
        cmbAttendees.setBackground(new Color(190, 140, 229));
        cmbAttendees.setFont(new Font("Serif",Font.BOLD,15));
        cmbAttendees.setForeground(new Color(66, 3, 104));
        pnlCenter.add(cmbAttendees);

        btnAddEvent = new JButton("ADD EVENT");
        btnAddEvent.setFocusable(false);
        btnAddEvent.setBounds(270, 555, 190, 30);
        btnAddEvent.setBackground(new Color(190, 140, 229)); 
        btnAddEvent.setForeground(new Color(66, 3, 104));
        btnAddEvent.setBorder(BorderFactory.createEmptyBorder());
        pnlCenter.add(btnAddEvent);

        btnBack=new JButton("Back");
        btnBack.setBounds(-70, 50, 200, 50);
        btnBack.setFont(new Font("Arial",Font.BOLD,12));
        btnBack.setForeground(new Color(66, 3, 104));
        btnBack.setBorderPainted(false);
        btnBack.setContentAreaFilled(false);
        btnBack.setFocusPainted(false);
        add(btnBack);
        
        btnRefreshTable = new JButton("Refresh Table");
        btnRefreshTable.setFocusable(false);
        btnRefreshTable.setBounds(30, 550, 150, 30);
        btnRefreshTable.setBackground(new Color(190, 140, 229));
        btnRefreshTable.setForeground(new Color(66, 3, 104));
        btnRefreshTable.setBorder(BorderFactory.createEmptyBorder());
        btnRefreshTable.addActionListener(e -> refreshTable());
        pnlCenter.add(btnRefreshTable);


        txaNotif = new JTextArea();
        txaNotif.setBounds(10, 60, 900, 50);
        txaNotif.setBackground(new Color(213, 182, 238));
        txaNotif.setFont(new Font("Arial", Font.BOLD, 20));
        txaNotif.setForeground(new Color(66, 3, 104));
        txaNotif.setBorder(BorderFactory.createTitledBorder("NOTIFICATIONS: "));
        txaNotif.setLineWrap(true);//automatically put the text into next if exceeds the width
        txaNotif.setWrapStyleWord(true);//move the entire word not split it
        txaNotif.setEditable(false);
        pnlEast.add(txaNotif);

    //code for displaying the user data in the scrollPane
    //            listModel = new DefaultListModel<>();
    //            list = new JList(listModel);
    //            scrollPane = new JScrollPane(list);
    //            scrollPane.setBounds(30, 40, 350, 340);
    //            pnlCenter.add(scrollPane);

        //btnAddEvent.addActionListener(e -> adminAdd()); //calling the adminAdd method              
        //btnBack.addActionListener(this);

        String[] columnNames = {"Event Name", "Name", "Date", "Number of Attendees", "Event Duration", "Time of Event"}; 
        tableModel = new DefaultTableModel(columnNames, 0); 
        eventTable = new JTable(tableModel); 
        eventTable.setGridColor(Color.BLACK);
        eventTable.setShowGrid(true); 
        scrollPane = new JScrollPane(eventTable); 
        scrollPane.setBounds(30, 40, 610, 505); 
        pnlCenter.add(scrollPane);
        
        
        readDataFromFile("userData.txt");
        

        add(pnlCenter);
        add(pnlNorth);
        add(pnlEast);
        setVisible(true);
    } 
    
    
    private void readDataFromFile(String fileName) { 
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) { 
            String line; 
            while ((line = br.readLine()) != null) { 
                String[] data = line.split(", "); 
                tableModel.addRow(data); 
            } 
        } catch (IOException e) { 
            e.printStackTrace(); 
        } 
    }
    
  @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnAddEvent){
            try {
                addEventToDatabase(); // listing events to database.
                tfAttendees.setText(" ");
                tfDate.setText(" ");
                tfEventName.setText(" ");
                tfName.setText(" ");
                tfTimeEvent.setText(" ");
                cmbDuration.setSelectedIndex(0);
                
                startTimer(); 
            } catch (SQLException ex) {
                Logger.getLogger(adminAddEventFinal.class.getName()).log(Level.SEVERE, null, ex);
            } 
            
        }else if(e.getSource()==btnUpdateDataBase){
            updateDatabase();
        }  else if(e.getSource()==btnBack){
            new adminFrameGeneral(); 
        
    }
    }
    
    private void updateDatabase() {
        
    }
  
//add events to event table in database.
    private void addEventToDatabase() throws SQLException {
        
        inputEventId = tfEventName.getText();   // event ID 
        inputDate = tfDate.getText(); // records date 
        inputName = tfName.getText(); // name of the celebrant
        inputAttendees = (String) cmbAttendees.getSelectedItem(); // attendee population selection
        inputTimeDuration = (String) cmbDuration.getSelectedItem(); // how long the party will take place
        inputTimeOfEvent = tfTimeEvent.getText(); // what time the party will be held (start of the timer)

        if (inputEventId.isEmpty() || inputName.isEmpty() || inputDate.isEmpty() ||  inputAttendees.isEmpty() ||  inputTimeOfEvent.isEmpty() || cmbDuration.getSelectedIndex() < 0) {
           txaNotif.setText("Please fill all the required fields");
            return;
        }
        
        Event event = new Event(inputEventId, inputName, inputDate, inputAttendees, inputTimeOfEvent);
        queue.offer(event);

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/eventmanagement", "root", "1234")) {
            String query = "INSERT INTO adminaddtable (eventId, name, date, attendees) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, inputEventId);
            stmt.setString(2, inputName);
            stmt.setString(3, inputDate);
            stmt.setString(4, inputAttendees);
            stmt.setString(5, inputTimeDuration);
            stmt.setString(6, inputAttendees);
            
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Event Added");
            txaNotif.setText("Succefully added.");
        }
         catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Input Error: " + e.getMessage());
        }   
        
    }
        updateEventTable();

           
    }
    
    private void updateEventTable() {
        // Clear the table
        tableModel.setRowCount(0);

        // Loop through the queue and display each event
        for (Event event : queue) {
            String[] rowData = {event.getEventId(), event.getName(), event.getDate(), event.getAttendees(), event.getTimeOfEvent()};
            tableModel.addRow(rowData);
        }
    }
    
    private void refreshTable() {
        tableModel.setRowCount(0); // Clear the existing table data
        updateEventTable();       // Re-populate the table from the queue
    }

  private void startTimer() {
    try {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        java.util.Date eventDateTime = dateFormat.parse(inputDate + " " + inputTimeOfEvent);
        long eventTimeInMillis = eventDateTime.getTime();
        long currentTimeInMillis = System.currentTimeMillis();
        
        if (eventTimeInMillis <= currentTimeInMillis) {
            JOptionPane.showMessageDialog(null, "The event date/time is in the past. Please enter a valid future time.");
            return;
        }
        
        long delay = eventTimeInMillis - currentTimeInMillis; // Time until the event starts in milliseconds

        Timer swingTimer = new Timer((int) delay, e -> {
            startRegistrationWindow();
        });
        swingTimer.setRepeats(false);
        swingTimer.start();
        
        JOptionPane.showMessageDialog(null, "Event scheduled successfully for " + dateFormat.format(eventDateTime));
    } catch (ParseException e) {
        JOptionPane.showMessageDialog(null, "Invalid date/time format. Please use dd/MM/yyyy HH:mm");
    }
}

private void startRegistrationWindow() {
    int durationInMinutes = getDurationInMinutes(inputTimeDuration);
    if (durationInMinutes <= 0) {
        JOptionPane.showMessageDialog(null, "Invalid duration selected.");
        return;
    }
    
    Timer registrationTimer = new Timer(durationInMinutes * 60000, e -> {
        endRegistrationWindow();
    });
    registrationTimer.setRepeats(false);
    registrationTimer.start();
    
   new invitationToRegistration();
   dispose();
}

private void endRegistrationWindow() {
    JOptionPane.showMessageDialog(null, "Guest registration period has ended.");
    // Additional logic to handle post-registration activities
}

private int getDurationInMinutes(String duration) {
    switch (duration) {
        case "2 hours":
            return 5; // 2 hours: 120, 5 mins for testing.
        case "3 hours and half hours":
            return 8;
        case "5 hours":  //3 1/2 hours: 210
            return 10;
        default:
            return 0;
    }
}
class Event implements Comparable<Event> {
    private String eventId;
    private String name;
    private String date;
    private String attendees;
    private String timeOfEvent;
    
    public Event(String eventId, String name, String date, String attendees, String timeOfEvent) {
        this.eventId = eventId;
        this.name = name;
        this.date = date;
        this.attendees = attendees;
        this.timeOfEvent = timeOfEvent;
    }

    public String getEventId() {
        return eventId;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public String getAttendees() {
        return attendees;
    }

    public String getTimeOfEvent() {
        return timeOfEvent;
    }

    @Override
    public int compareTo(Event otherEvent) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        try {
            // Compare based on the event date and time
            java.util.Date thisEventDate = dateFormat.parse(this.date + " " + this.timeOfEvent);
            java.util.Date otherEventDate = dateFormat.parse(otherEvent.date + " " + otherEvent.timeOfEvent);
            return thisEventDate.compareTo(otherEventDate);
        } catch (ParseException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
    
public static void main (String[] args){
    new adminAddEventFinal();
}

}