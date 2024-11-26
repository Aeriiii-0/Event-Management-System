package com.mycompany.adminframegeneral;


    /*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
     */

    /**
     *
     * @author USER
     */
import com.mycompany.adminframegeneral.connector;
    import javax.swing.*;
    import java.awt.*;
    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;
    import java.io.*;
    import java.sql.*;
    import java.text.*;
    import java.util.*;
    import java.util.Date;
    import java.util.LinkedList;
    import java.util.PriorityQueue;
    import java.util.Queue;
    import java.util.Timer;
    import java.util.TimerTask;
    import java.util.logging.Level;
    import java.util.logging.Logger;

    public class adminAddEventFinal extends JFrame implements ActionListener{

        JLabel lblHeader, lblEventName, lblName, lblDate, lblAttendees, lblTimeDuration, lblTimeEvent;
        JPanel pnlNorth, pnlCenter, pnlEast;
        JTextField tfEventName, tfName, tfDate, tfTimeEvent;
        JTextArea txaNotif;
        JButton btnAddEvent, btnBack;
        JComboBox cmbDuration, cmbAttendees;
        JList<String> list;
        DefaultListModel<String> listModel;
        JScrollPane scrollPane;
        String [] eventDuration = {"Select Option", "2 hours", "3 hours and half hours" , "5 hours"}; 
        String [] eventAttendees = {"Select Option", "20persons", "35persons" , "50persons"}; 
 
        adminAddEventFinal(){
            setSize(1000, 800);
            setTitle("Event Venture");
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setResizable(false);
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
            pnlCenter.setBounds(0, 89, 700, 710);
            pnlCenter.setBackground(new Color(213, 182, 238));

            pnlEast = new JPanel();
            pnlEast.setBounds(700, 89, 300, 710);
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
            lblEventName.setBounds(410, 30, 200, 40);

            lblName = new JLabel("Name: ");
            lblName.setFont(new Font("Arial", Font.BOLD, 17));
            lblName.setForeground(new Color(66, 3, 104));
            lblName.setBounds(410, 120, 200, 40);

            lblDate = new JLabel("Date: ");
            lblDate.setFont(new Font("Arial", Font.BOLD, 17));
            lblDate.setForeground(new Color(66, 3, 104));
            lblDate.setBounds(410, 210, 200, 40);    

            lblAttendees = new JLabel("Attendees: ");
            lblAttendees.setFont(new Font("Arial", Font.BOLD, 17));
            lblAttendees.setForeground(new Color(66, 3, 104));
            lblAttendees.setBounds(410, 300, 200, 40);

            lblTimeDuration = new JLabel("Time Duration");
            lblTimeDuration.setFont(new Font("Arial", Font.BOLD, 13));
            lblTimeDuration.setForeground(new Color(66, 3, 104));
            lblTimeDuration.setBounds(70, 390, 200, 40);

            lblTimeEvent = new JLabel("Time of Event");
            lblTimeEvent.setFont(new Font("Arial", Font.BOLD, 13));
            lblTimeEvent.setForeground(new Color(66, 3, 104));
            lblTimeEvent.setBounds(410, 390, 200, 40);

            pnlCenter.add(lblEventName);
            pnlCenter.add(lblName);
            pnlCenter.add(lblDate);
            pnlCenter.add(lblAttendees);
            pnlCenter.add(lblTimeDuration);
            pnlCenter.add(lblTimeEvent);

            tfEventName = new JTextField();
            tfEventName.setBounds(410, 65, 280, 40);
            tfEventName.setBackground(new Color(190, 140, 229));
            tfEventName.setForeground(new Color(66, 3, 104));

            tfName = new JTextField();
            tfName.setBounds(410, 155, 280, 40);
            tfName.setBackground(new Color(190, 140, 229));
            tfName.setForeground(new Color(66, 3, 104));

            tfDate = new JTextField();
            tfDate.setBounds(410, 245, 280, 40);
            tfDate.setBackground(new Color(190, 140, 229));
            tfDate.setForeground(new Color(66, 3, 104));

            tfTimeEvent = new JTextField();
            tfTimeEvent.setBounds(410, 425, 280, 40);
            tfTimeEvent.setBackground(new Color(190, 140, 229));
            tfTimeEvent.setForeground(new Color(66, 3, 104));

            pnlCenter.add(tfEventName);
            pnlCenter.add(tfName);
            pnlCenter.add(tfDate);
            pnlCenter.add(tfTimeEvent);

            cmbDuration = new JComboBox<>(eventDuration);  
            cmbDuration.setBorder(null);
            cmbDuration.setBounds(70, 425, 280, 40); 
            cmbDuration.setBackground(new Color(190, 140, 229));
            cmbDuration.setFont(new Font("Serif",Font.BOLD,15));
            cmbDuration.setForeground(new Color(66, 3, 104));
            pnlCenter.add(cmbDuration);

            cmbAttendees = new JComboBox<>(eventAttendees);  
            cmbAttendees.setBorder(null);
            cmbAttendees.setBounds(410, 335, 280, 40); 
            cmbAttendees.setBackground(new Color(190, 140, 229));
            cmbAttendees.setFont(new Font("Serif",Font.BOLD,15));
            cmbAttendees.setForeground(new Color(66, 3, 104));
            pnlCenter.add(cmbAttendees);

            btnAddEvent = new JButton("ADD EVENT");
            btnAddEvent.setFocusable(false);
            btnAddEvent.setBounds(160, 480, 190, 30);
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

            txaNotif = new JTextArea();
            txaNotif.setBounds(15, 0, 270, 650);
            txaNotif.setBackground(new Color(213, 182, 238));
            txaNotif.setFont(new Font("Arial", Font.BOLD, 20));
            txaNotif.setForeground(new Color(66, 3, 104));
            txaNotif.setBorder(BorderFactory.createTitledBorder("NOTIFICATIONS: "));
            txaNotif.setLineWrap(true);//automatically put the text into next if exceeds the width
            txaNotif.setWrapStyleWord(true);//move the entire word not split it
            txaNotif.setEditable(false);
            pnlEast.add(txaNotif);

            //code for displaying the user data in the scrollPane
            listModel = new DefaultListModel<>();
            list = new JList(listModel);
            scrollPane = new JScrollPane(list);
            scrollPane.setBounds(30, 40, 350, 340);
            pnlCenter.add(scrollPane);

            btnAddEvent.addActionListener(e -> adminAdd()); //calling the adminAdd method              
            btnBack.addActionListener(this);
            //method for getting the data from the user
            gettingTheUserData();
            
            add(pnlCenter);
            add(pnlEast);
            add(pnlNorth);
            setVisible(true);
        }
        //code for getting the data from user with the use of FILE HANDLING
        //data will come from the file which comes from the celebrantInformationFormFINAL class
        public void gettingTheUserData(){
            txaNotif.setText("");
            listModel.clear();
            try(BufferedReader getData = new BufferedReader(new FileReader("userData.txt"))){
                String data;
                while((data = getData.readLine()) != null){
                    listModel.addElement(data);
                }
            } catch(IOException ex){
                txaNotif.setText("FILE NOT FOUND");
            }
            list.setModel(listModel);
            
            //code for when admin click the data in scrollpane it will go to the textfield
            list.addListSelectionListener(e -> {
                if (!e.getValueIsAdjusting()){
                    String selected = list.getSelectedValue();
                    String[] data = selected.split("\\|");
                    if(data.length == 5){
                        tfName.setText(data[0].trim());
                        tfDate.setText(data[1].trim());
                        cmbAttendees.setSelectedItem(data[2].trim());
                        cmbDuration.setSelectedItem(data[3].trim());
                        tfTimeEvent.setText(data[4].trim());
                    }  
                }
            });
        }
        
        //code for buttons
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == btnBack){
                this.dispose();
                new AdminFrameGeneral();
                
            }
            
        } 
        public void adminAdd() {
        //retrieving the data
        String eventName = tfEventName.getText().trim();
        String organizerName = tfName.getText().trim();
        String eventDate = tfDate.getText().trim();
        String attendees = (String) cmbAttendees.getSelectedItem();
        String duration = (String) cmbDuration.getSelectedItem();
        String timeEvent = tfTimeEvent.getText().trim();

        //identifying the event type based on eventName
        String eventType;
        int startId = 0;
        int endId = 0;
        if (eventName.toLowerCase().contains("birthday")) { //RANGE OF BIRTHDAY EVENTID
            eventType = "birthday";
            startId = 0;
            endId = 249;
        } else if (eventName.toLowerCase().contains("wedding")) { //RANGE OF WEDDING EVENTID
            eventType = "wedding";
            startId = 250;
            endId = 499;
        } else if (eventName.toLowerCase().contains("christening")) { //RANGE OF CHRISTENING EVENTID
            eventType = "christening";
            startId = 500;
            endId = 749;
        } else {
            txaNotif.setText("Please specify 'birthday', 'wedding', or 'christening' in the event name.");
            return;
        }

        //EXCEPTION
        //THROWS AN EXCEPTION IF TEXTFIELDS OR CMB IS EMPTY
        if (eventName.isEmpty() || organizerName.isEmpty() || eventDate.isEmpty() || timeEvent.isEmpty() || attendees.equals("Select Option") || duration.equals("Select Option")) {
            txaNotif.setText("PLEASE FILL OUT ALL FIELDS");
            return;
        }

        //DATABASE CONNECTION
        try (Connection conn = connector.getCon()) {
            if (conn == null) {
                JOptionPane.showMessageDialog(this, "Database connection failed!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        //determining the next available event ID
        int nextId = startId;
        String maxIdQuery = "SELECT MAX(event_id) AS max_id FROM adminaddtable WHERE event_id BETWEEN ? AND ?"; //retrieves the maxId
        try (PreparedStatement stmtMaxId = conn.prepareStatement(maxIdQuery)) {
            stmtMaxId.setInt(1, startId);
            stmtMaxId.setInt(2, endId);

            //Executing the Query and Processing Results
            try (ResultSet rs = stmtMaxId.executeQuery()) {
                if (rs.next() && rs.getString("max_id") != null) {
                    nextId = rs.getInt("max_id") + 1;
                } else {
                    nextId = startId;
                }
            }
        }

        //CHECK if the nextId exceeds the range
        if (nextId > endId) {
            txaNotif.setText("ERROR: Maximum ID has been reached for " + eventType + " events.");
            return;
        }

        //Insert the data into the database
        String insertQuery = "INSERT INTO adminaddtable (event_id, event_name, name, date, attendees, duration, time_of_event) " + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement insertStmt = conn.prepareStatement(insertQuery)) {
            insertStmt.setInt(1, nextId);
            insertStmt.setString(2, eventName);
            insertStmt.setString(3, organizerName);
            insertStmt.setString(4, eventDate);
            insertStmt.setString(5, attendees);
            insertStmt.setString(6, duration);
            insertStmt.setString(7, timeEvent);

            insertStmt.executeUpdate();
            txaNotif.setText("EVENT ADDED SUCCESSFULLY");

            //Clear fields after successful insertion
            tfEventName.setText("");
            tfName.setText("");
            tfDate.setText("");
            cmbAttendees.setSelectedIndex(0);
            cmbDuration.setSelectedIndex(0);
            tfTimeEvent.setText("");
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
        txaNotif.setText("ERROR: " + ex.getMessage());
    }
    }
}