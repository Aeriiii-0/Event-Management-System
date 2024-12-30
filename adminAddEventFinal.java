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
import java.io.*;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

public class adminAddEventFinal extends JFrame implements ActionListener{
    
    JLabel lblHeader, lblEventName, lblName, lblDate, lblAttendees, lblTimeDuration, lblTimeEvent, lblQueue;
    JPanel pnlNorth, pnlCenter, pnlEast;
    JTextField  tfName, tfDate, tfTimeEvent;
    JTextArea txaNotif;
    JButton btnAddEvent, btnRefreshTable, btnBack;
    JComboBox cmbDuration,cmbAttendeePopulation, cmbEventName;
    String inputEventId, inputDate, inputName,inputTimeDuration,inputTimeOfEvent,inputAttendeePopulation;
    String [] eventName= {"Select Option","Birthday","Christening","Wedding"};
    String [] eventDuration = {"Select Option", "2 hours", "3 hours and half hours" , "5 hours"}; 
    String[] attendeesOption = {"Select an option", "20 persons", "35 persons", "50 persons"}; 
    String[] columnNames = {"Event Name", "Name", "Date", "Number of Attendees", "Event Duration", "Time of Event"}; 
    JScrollPane sclPane;
    DefaultTableModel tblModel;
    JTable eventTable;
    PriorityQueue<Event> tempQueue;
    PriorityQueue<Event> queue;
   
    
    adminAddEventFinal(){

        queue = new PriorityQueue<>(new EventComparator());
        
        //component settings
        setSize(1000, 800);
        setTitle("Event Venture");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
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
        lblQueue = new JLabel("Guests in Queue:");
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
        lblDate.setBounds(675, 200, 200, 40);
        pnlCenter.add(lblDate);
        
        lblAttendees = new JLabel("Attendees: ");
        lblAttendees.setFont(new Font("Arial", Font.BOLD, 17));
        lblAttendees.setForeground(new Color(66, 3, 104));
        lblAttendees.setBounds(675, 280, 200, 40);
        pnlCenter.add(lblAttendees);

        lblTimeDuration = new JLabel("Time Duration:");
        lblTimeDuration.setFont(new Font("Arial", Font.BOLD, 17));
        lblTimeDuration.setForeground(new Color(66, 3, 104));
        lblTimeDuration.setBounds(675, 370, 200, 40);
        pnlCenter.add(lblTimeDuration);

        lblTimeEvent = new JLabel("Time of Event:");
        lblTimeEvent.setFont(new Font("Arial", Font.BOLD, 17));
        lblTimeEvent.setForeground(new Color(66, 3, 104));
        lblTimeEvent.setBounds(675, 455, 200, 40);
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
        tfDate.setBounds(675, 235, 280, 40);
        tfDate.setBackground(new Color(190, 140, 229));
        tfDate.setForeground(new Color(66, 3, 104));
        tfDate.setFont(new Font("Serif",Font.BOLD,17));
        tfDate.setBorder(BorderFactory.createLineBorder(new Color(66, 3, 104), 3));
        pnlCenter.add(tfDate);

        cmbAttendeePopulation = new JComboBox<>(attendeesOption);  
        cmbAttendeePopulation.setBorder(null);
        cmbAttendeePopulation.setBounds(675, 320, 280, 40); 
        cmbAttendeePopulation.setBackground(new Color(	190, 140, 229));
        cmbAttendeePopulation.setFont(new Font("Serif",Font.BOLD,15));
        cmbAttendeePopulation.setForeground(new Color(66, 3, 104));
        cmbAttendeePopulation.setBorder(BorderFactory.createLineBorder(new Color(66, 3, 104), 3));
        pnlCenter.add(cmbAttendeePopulation);

        cmbDuration = new JComboBox<>(eventDuration);  
        cmbDuration.setBorder(null);
        cmbDuration.setBounds(675, 408, 280, 40);  
        cmbDuration.setBackground(new Color(190, 140, 229));
        cmbDuration.setFont(new Font("Serif",Font.BOLD,15));
        cmbDuration.setForeground(new Color(66, 3, 104));
        cmbDuration.setBorder(BorderFactory.createLineBorder(new Color(66, 3, 104), 3));
        pnlCenter.add(cmbDuration);
        
        tfTimeEvent = new JTextField();
        tfTimeEvent.setBounds(675, 490, 280, 40);
        tfTimeEvent.setBackground(new Color(190, 140, 229));
        tfTimeEvent.setForeground(new Color(66, 3, 104));
        tfTimeEvent.setFont(new Font("Serif",Font.BOLD,17));
        tfTimeEvent.setBorder(BorderFactory.createLineBorder(new Color(66, 3, 104), 3));
        pnlCenter.add(tfTimeEvent);
      
        //buttons setting. bounds are derived from center panel.
        btnAddEvent = new JButton("ADD EVENT");
        btnAddEvent.setFocusable(false);
        btnAddEvent.setBounds(100, 548, 190, 30);
        btnAddEvent.setForeground(new Color(66, 3, 104));
        btnAddEvent.setContentAreaFilled(false);  
        btnAddEvent.setBorder(BorderFactory.createLineBorder(new Color(66, 3, 104), 3));
        btnAddEvent.setFocusPainted(false);
        btnAddEvent.addActionListener(this);
        pnlCenter.add(btnAddEvent);
       
        btnRefreshTable = new JButton("REFRESH TABLE");
        btnRefreshTable.setFocusable(false);
        btnRefreshTable.setBounds(360, 548, 190, 30);
        btnRefreshTable.setForeground(new Color(66, 3, 104));
        btnRefreshTable.setContentAreaFilled(false);  
        btnRefreshTable.setBorder(BorderFactory.createLineBorder(new Color(66, 3, 104), 3));
        btnRefreshTable.setFocusPainted(false);
        btnRefreshTable.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Refreshing Table...", "Refreshing", JOptionPane.INFORMATION_MESSAGE);
            readDataFromFile("userData.txt");
            refreshTable();
        });

        pnlCenter.add(btnRefreshTable);
        
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
        
        lblHeader = new JLabel("ADMIN APPROVAL SLIP");
        lblHeader.setFont(new Font("Arial", Font.BOLD, 25));
        lblHeader.setBounds(355, 705, 400, 60);
        lblHeader.setForeground(new Color(66, 3, 104));
        add(lblHeader);
        
        //code for displaying the data from table to textfield
        eventTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int selectedRow = eventTable.getSelectedRow(); // Get the row that was clicked

                // Get the data from each column of the selected row
                if (selectedRow != -1) {
                    String eventName = tblModel.getValueAt(selectedRow, 0).toString(); 
                    String name = tblModel.getValueAt(selectedRow, 1).toString();    
                    String date = tblModel.getValueAt(selectedRow, 2).toString();   
                    String attendees = tblModel.getValueAt(selectedRow, 3).toString(); 
                    String duration = tblModel.getValueAt(selectedRow, 4).toString(); 
                    String timeOfEvent = tblModel.getValueAt(selectedRow, 5).toString(); 

                    // Set the retrieved data to the respective textfields
                    tfName.setText(name);             
                    tfDate.setText(date);            
                    tfTimeEvent.setText(timeOfEvent);
                    cmbEventName.setSelectedItem(eventName);
                    cmbAttendeePopulation.setSelectedItem(attendees); 
                    cmbDuration.setSelectedItem(duration);  
                }
            }
        });
        //reading the data from the textfile
        readDataFromFile("userData.txt");
        
        //addition of all the panels, ensuring its components' visibility.      
        add(pnlCenter);
        add(pnlEast);
        add(pnlNorth);

        setVisible(true);
    } 

  @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnAddEvent){
            try {
                addEventToDatabase(); // listing events to database.
                startTimer(); //start calculating the time left before the event and how long the duration will be.
               
            } catch (SQLException ex) {
                Logger.getLogger(adminAddEventFinal.class.getName()).log(Level.SEVERE, null, ex);
            } 

        }  else if(e.getSource()==btnBack){
         new adminFrameGeneral(); 
        
    }
    }
    //code for refreshing the data in the table
    public void refreshTable() {
    tblModel.setRowCount(0); //Clear the table
    PriorityQueue<Event> tempQueue = new PriorityQueue<>(queue); // Temporary queue for sorted events
    while (!tempQueue.isEmpty()) {
        Event event = tempQueue.poll();
        tblModel.addRow(new Object[]{
                event.getEventName(),
                event.getName(),
                event.getDate(),
                event.getAttendees(),
                event.getDuration(),
                event.getTimeOfEvent()
        });
    }
}
    //code for reading the data from the textfile
    private void readDataFromFile(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            queue.clear(); // Clear the queue to avoid duplicate entries
            while ((line = br.readLine()) != null) {
                String[] eventDetails = line.split(","); //seperator of the data in the textfile
                if (eventDetails.length == 6) {
                    String eventName = eventDetails[0].trim();
                    String name = eventDetails[1].trim();
                    String date = eventDetails[2].trim();
                    String attendees = eventDetails[3].trim();
                    String duration = eventDetails[4].trim();
                    String timeOfEvent = eventDetails[5].trim();

                    // Add event to the queue
                    queue.add(new Event(eventName, name, date, attendees, duration, timeOfEvent));
                }
            }
            refreshTable(); // Populate the table after loading
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error reading data from file.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void updateDatabase() {
        
    }
  
    //add events to event table in database.
    public void addEventToDatabase() throws SQLException {
        
        //collection of user inputs.
        inputEventId = (String) cmbEventName.getSelectedItem();   // gets the type of event selected by the user to determine the eventId.
        inputDate = tfDate.getText(); // records date 
        inputName = tfName.getText(); // name of the celebrant
        inputTimeDuration = (String) cmbDuration.getSelectedItem(); // how long the party will take place
        inputAttendeePopulation = (String) cmbAttendeePopulation.getSelectedItem(); // max number of the guests to attend
        inputTimeOfEvent = tfTimeEvent.getText(); // what time the party will be held (start of the timer)
       
        //validating all the fields are not empty.
        if (cmbEventName.getSelectedIndex()<0 || inputName.isEmpty() || inputDate.isEmpty() ||  inputAttendeePopulation.isEmpty() ||  inputTimeOfEvent.isEmpty() || cmbDuration.getSelectedIndex() < 0|| cmbDuration.getSelectedIndex()<0) {
            Event event = new Event(inputEventId, inputName, inputDate, inputTimeOfEvent, inputTimeDuration, inputAttendeePopulation);
            queue.add(event);
            txaNotif.setText("Please fill all the required fields");
            return;
        }
        
        int eventId= givenEventId(cmbEventName);//method to assign an eventId based on user selection of event. 
        
        //Database connections and inserting queries. Along with the prepared statement and its parameters.
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/eventmanagement", "root", "1234")) {
            String query = "INSERT INTO event (eventId,eventName, name, date, attendees, time, duration) VALUES (?, ?, ?, ?,?,?,?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, eventId);
            stmt.setString(2, inputEventId);
            stmt.setString(3, inputName);
            stmt.setString(4, inputDate);
            stmt.setString(5, inputAttendeePopulation);
            stmt.setString(6, inputTimeOfEvent);
            stmt.setString(7, inputTimeDuration);
            
            stmt.executeUpdate(); //execution of the process.
            
            //notification of successful execution.
            JOptionPane.showMessageDialog(null, "Event Added");
            txaNotif.setText("Succefully added.");
        }
        //exception handling for catchable errors during the process.
         catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Input Error: " + e.getMessage());
        }
}

           
    }
    /*Assigning eventId by using a method for randomizing the eventId. Each event can hold 250 as its maximum capacity. 
    Where 1-249 are assigned for birthdays.
    259-499 are for christenings.
    500-749 are for weddings.*/
    
     private int givenEventId(JComboBox cmbEventName) {
     int eventId=0;
                                                   
     switch(inputEventId){
       case "Birthday":  
            eventId = 1 + (int) (Math.random() * 249);
            break;
        case "Christening": 
            eventId = 250 + (int) (Math.random() * 249); 
            break;
        case "Wedding": eventId = 500 + (int) (Math.random() * 249);
            break;
        default:
            JOptionPane.showMessageDialog(null, "Please select a valid event type.");
            break;
    }
    return eventId;
}

  private void startTimer() {
    try {
        // Parse the event time from input fields
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        java.util.Date eventDateTime = dateFormat.parse(inputDate + " " + inputTimeOfEvent);
        long eventTimeInMillis = eventDateTime.getTime();
        long currentTimeInMillis = System.currentTimeMillis();
        
        if (eventTimeInMillis <= currentTimeInMillis) {
            JOptionPane.showMessageDialog(null, "The event date/time is in the past. Please enter a valid future time.");
            return;
        }
        
        // Calculate delay (time until the event starts in milliseconds)
        long delay = eventTimeInMillis - currentTimeInMillis;

        // Timer for the event start time
        Timer eventStartTimer = new Timer((int) delay, e -> {
            startRegistrationWindow(); // Call the method to open the registration window when the event time arrives
        });
        eventStartTimer.setRepeats(false); // Ensure it only triggers once
        eventStartTimer.start();
        
        JOptionPane.showMessageDialog(null, "Event scheduled successfully for " + dateFormat.format(eventDateTime));
         
        // Reset the form fields after the event has been scheduled
        resetFields();
    } catch (ParseException e) {
        JOptionPane.showMessageDialog(null, "Invalid date/time format. Please use dd/MM/yyyy HH:mm");
    }
}

private void resetFields() {
    // Reset form fields
    tfDate.setText("");
    cmbEventName.setSelectedIndex(0);
    tfName.setText("");
    tfTimeEvent.setText("");
    cmbDuration.setSelectedIndex(0);
    cmbAttendeePopulation.setSelectedIndex(0);
}

private void startRegistrationWindow() {
    // Get the duration in minutes based on the selected duration
    int durationInMinutes = getDurationInMinutes(inputTimeDuration);
    if (durationInMinutes <= 0) {
        JOptionPane.showMessageDialog(null, "Invalid duration selected.");
        return;
    }
    
    // Timer for the registration period, based on the event duration
    Timer registrationTimer = new Timer(durationInMinutes * 60000, e -> {
     System.exit(0);
    });
    registrationTimer.setRepeats(false); // Ensure it only triggers once
    registrationTimer.start();
    
     dispose();
     String selectedAttendeePopulation = (String) cmbAttendeePopulation.getSelectedItem();
     
     //new invitationToRegistration(inputAttendeePopulation);
     
     
}



private int getDurationInMinutes(String duration) {
    switch (duration) {
        case "2 hours":
            return 3;    // 2 hours: 120 minutes
        case "3 hours and half hours": 
            return 5;   // 3 1/2 hours: 210 minutes
        case "5 hours": 
            return 8; // 5 hours: 300 minutes
        default:
            return 0;
    }
}
public static void main (String[] args){
    new adminAddEventFinal();
    }
    
    
} 
//code to sort or prioritize Event objects based on their event names in a case-insensitive manner.
class EventComparator implements Comparator<Event> { 
    @Override 
    public int compare(Event a, Event b) { 
        return a.getEventName().compareToIgnoreCase(b.getEventName()); 
    } 
}

//this code summarizethe details of an event, including its name, organizer's name, date, number of attendees, duration, and time of the event
class Event {
    private final String eventName;
    private final String name;
    private final String date;
    private final String attendees;
    private final String duration;
    private final String timeOfEvent;

    public Event(String eventName, String name, String date, String attendees, String duration, String timeOfEvent) {
        this.eventName = eventName;
        this.name = name;
        this.date = date;
        this.attendees = attendees;
        this.duration = duration;
        this.timeOfEvent = timeOfEvent;
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

    public String getAttendees() {
        return attendees;
    }

    public String getDuration() {
        return duration;
    }

    public String getTimeOfEvent() {
        return timeOfEvent;
    }
} 
    


