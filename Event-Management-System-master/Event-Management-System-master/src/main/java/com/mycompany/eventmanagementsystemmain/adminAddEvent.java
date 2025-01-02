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
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;


public class adminAddEvent extends JFrame implements ActionListener{
    
    JLabel lblHeader, lblEventName, lblName, lblDate, lblTimeDuration, lblTimeEvent, lblQueue;
    JPanel pnlNorth, pnlCenter, pnlEast;
    JTextField  tfName, tfDate, tfTimeEvent;
    JTextArea txaNotif;
    JButton btnAddEvent, btnRefreshTable, btnBack, btnViewDB;
    JComboBox cmbDuration, cmbEventName;
    String inputEventId, inputDate, inputName,inputTimeDuration,inputTimeOfEvent;
    String [] eventName= {"Select Option","Birthday","Christening","Wedding"};
    String [] eventDuration = {"Select Option", "2 hours", "3 hours and half hours" , "5 hours"}; 
    String[] columnNames = {"Event Name", "Name", "Date", "Event Duration", "Time of Event"}; 
    JScrollPane sclPane;
    DefaultTableModel tblModel;
    PriorityQueue<Event> queue;
    JTable eventTable;
    
   
    
    adminAddEvent(){
  
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
        btnRefreshTable.addActionListener(this);
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
        
        btnViewDB=new JButton("View Database");
        btnViewDB.setBounds(675, 494, 280, 35);
        btnViewDB.setForeground(new Color(66, 3, 104));
        btnViewDB.setFont(new Font("Serif",Font.BOLD,17));
        btnViewDB.setContentAreaFilled(false);  
        btnViewDB.setBorder(BorderFactory.createLineBorder(new Color(66, 3, 104), 3));
        btnViewDB.setFocusPainted(false);
        btnViewDB.addActionListener(this);
        pnlCenter.add(btnViewDB);
        
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
        
        eventTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int selectedRow = eventTable.getSelectedRow(); // Get the row that was clicked

                // Get the data from each column of the selected row
                if (selectedRow != -1) {
                    String eventName = tblModel.getValueAt(selectedRow, 0).toString(); 
                    String name = tblModel.getValueAt(selectedRow, 1).toString();    
                    String date = tblModel.getValueAt(selectedRow, 2).toString();   
                    String duration = tblModel.getValueAt(selectedRow, 3).toString(); 
                    String timeOfEvent = tblModel.getValueAt(selectedRow, 4).toString(); 

                    // Set the retrieved data from the table to the textfields.
                    tfName.setText(name);             
                    tfDate.setText(date);            
                    tfTimeEvent.setText(timeOfEvent);
                    cmbEventName.setSelectedItem(eventName);
                    cmbDuration.setSelectedItem(duration);  
                }
            }
        });
        
        
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
                Logger.getLogger(adminAddEvent.class.getName()).log(Level.SEVERE, null, ex);
            } 
            
        }else if(e.getSource()==btnRefreshTable){
           JOptionPane.showMessageDialog(null, "Refreshing Table...", "Refreshing", JOptionPane.INFORMATION_MESSAGE);
            readDataFromFile("userData.txt");
            refreshTable();
        }  else if(e.getSource()==btnBack){
         new adminDashboard(); 
         dispose();
    }
        else if(e.getSource()==btnViewDB){
          new adminUpdateAndDelete();
          dispose();
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
                if (eventDetails.length == 5) {
                    String eventName = eventDetails[0].trim();
                    String name = eventDetails[1].trim();
                    String date = eventDetails[2].trim();
                    String duration = eventDetails[3].trim();
                    String timeOfEvent = eventDetails[4].trim();

                    // Add event to the queue
                    queue.add(new Event(eventName, name, date, duration, timeOfEvent));
                }
            }
            refreshTable(); // Populate the table after loading
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error reading data from file.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
  
    //add events to event table in database.
    public void addEventToDatabase() throws SQLException {
        
        //collection of user inputs.
        inputEventId = (String) cmbEventName.getSelectedItem();   // gets the type of event selected by the user to determine the eventId.
        inputDate = tfDate.getText(); // records date 
        inputName = tfName.getText(); // name of the celebrant
        inputTimeDuration = (String) cmbDuration.getSelectedItem(); // how long the party will take place
        inputTimeOfEvent = tfTimeEvent.getText(); // what time the party will be held (start of the timer)
       
        //validating all the fields are not empty.
       if (cmbEventName.getSelectedIndex()<0 || inputName.isEmpty() || inputDate.isEmpty()  ||  inputTimeOfEvent.isEmpty() || cmbDuration.getSelectedIndex() < 0|| cmbDuration.getSelectedIndex()<0) {
            Event event = new Event(inputEventId, inputName, inputDate, inputTimeOfEvent, inputTimeDuration);
            queue.add(event);
            txaNotif.setText("Please fill all the required fields");
            return;
        }
        
       
        
        //Database connections and inserting queries. Along with the prepared statement and its parameters.
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/eventmanagement", "root", "1234")) {
            String query = "INSERT INTO event (eventName, name, date, time, duration, status) VALUES (?,?,?,?,?,?)";
        try (PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
                stmt.setString(1, inputEventId);
                stmt.setString(2, inputName);
                stmt.setString(3, inputDate);
                stmt.setString(4, inputTimeOfEvent);
                stmt.setString(5, inputTimeDuration);
                stmt.setString(6, "Event Confirmed");

                stmt.executeUpdate(); //execution of the process.
         
        //method for auto-incrementation in database. Arranged regardless of the type of event.
             try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int eventId = generatedKeys.getInt(1);
                        
                    } else {
                        throw new SQLException("Adding event failed, no ID available obtained.");
                    }
                }
           
        int selectedRow = eventTable.getSelectedRow(); // Get the selected row index.
         if (selectedRow >= 0) {
          String eventNameToRemove = (String) tblModel.getValueAt(selectedRow, 0); // Event name.
          queue.removeIf(e -> e.getEventName().equals(eventNameToRemove)); // Remove from queue.
          tblModel.removeRow(selectedRow); // Remove from table model.
                
         for (Event event : queue) {
          if (event.getEventName().equals(inputEventId)
          && event.getName().equals(inputName)
          && event.getDate().equals(inputDate)
          && event.getDuration().equals(inputTimeDuration)
          && event.getTimeOfEvent().equals(inputTimeOfEvent)) {
          queue.remove(event); // Remove the event from the queue
          break;
      }
    }        
                txaNotif.setText("Successfully added to database. Event scheduled.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Input Error: " + e.getMessage());
}

           
    }
    }

     //method in-charge for the start and end time of the operations. 
  private void startTimer() {
    try {
        // Parse to ensure that every variable is in the right format.
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        java.util.Date eventDateTime = dateFormat.parse(inputDate + " " + inputTimeOfEvent);
        long eventTimeInMillis = eventDateTime.getTime();
        long currentTimeInMillis = System.currentTimeMillis();
        
        if (eventTimeInMillis <= currentTimeInMillis) {
            JOptionPane.showMessageDialog(null, "The event date/time is in the past. Please enter a valid future time.");
            return;
        }
        
        // Calculate delay (time until the event starts in milliseconds).
        long delay = eventTimeInMillis - currentTimeInMillis;

        // Timer for the event start time
        Timer eventStartTimer = new Timer((int) delay, e -> {
            startRegistrationWindow(); // Call the method to open the registration window when the event time arrives
        });
        eventStartTimer.setRepeats(false); // Ensure it only triggers once
        eventStartTimer.start();
        
        //notification of approval.
        JOptionPane.showMessageDialog(null, "Event Added to database.");
        JOptionPane.showMessageDialog(null, "Event scheduled successfully for " + dateFormat.format(eventDateTime));
        
        //reset all the fields.
        tfDate.setText("");
        cmbEventName.setSelectedIndex(0);
        tfName.setText("");
        tfTimeEvent.setText("");
        cmbDuration.setSelectedIndex(0);

    } catch (ParseException e) {
        JOptionPane.showMessageDialog(null, "Invalid date/time format. Please use yyyy-MM-dd HH:mm");
    }
}


private void startRegistrationWindow() {
    // Get the duration in minutes based on the user's selected duration
    int durationInMinutes = getDurationInMinutes(inputTimeDuration);
    if (durationInMinutes <= 0) {
        JOptionPane.showMessageDialog(null, "Invalid duration selected.");
        return;
    }
    
    // Timer for the registration period, based on the event duration. Once done, the system exits. Disabling guests to register.
    Timer registrationTimer = new Timer(durationInMinutes * 60000, e -> {
        JOptionPane.showMessageDialog(null, "The event is over, thanks for staying with us!");
       new PostEventAnalytics();
       dispose();
     
    });
    
    registrationTimer.setRepeats(false); // Ensure it's not triggered more than once.
    registrationTimer.start();
    dispose();
    
   new invitationToRegistration();
}
//method for converting hours to minutes.
private int getDurationInMinutes(String duration) {
    switch (duration) {
        case "2 hours":
            return 3;    // 2 hours: 120 minutes
        case "3 hours and half hours": 
            return 5;   // 3 1/2 hours: 210 minutes
        case "5 hours": 
            return 8; // 5 hours: 300 minutes
        default:
            JOptionPane.showMessageDialog(null, "No selected Duration.");
            return 0;
    }
}


//functions left below are all used for transfering the data from the previous frame (celebrantInformationForm) to the present frame.
class EventComparator implements Comparator<Event> { 
    @Override 
    public int compare(Event a, Event b) { 
        return a.getEventName().compareToIgnoreCase(b.getEventName()); 
    } 
}

//this code summarizes the details of an event, including its name, organizer's name, date, number of attendees, duration, and time of the event.
class Event {
    private final String eventName;
    private final String name;
    private final String date;
    private final String duration;
    private final String timeOfEvent;

  public Event(String eventName, String name, String date, String duration, String timeOfEvent) {
        this.eventName = eventName;
        this.name = name;
        this.date = date;
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

    public String getDuration() {
        return duration;
    }

    public String getTimeOfEvent() {
        return timeOfEvent;
    }
    } 

} 