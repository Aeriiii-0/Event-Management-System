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
        LinkedList<String> linkedList;
        DefaultListModel<String> listModel;
        JScrollPane scrollPane;
        String inputEventId, inputDate, inputName, inputAttendees,inputTimeDuration,inputTimeOfEvent, userData;
        String [] eventDuration = {"Select Option", "2 hours", "3 hours and half hours" , "5 hours"}; 
        String [] eventAttendees = {"Select Option", "20persons", "35persons" , "50persons"}; 
        int birthdayCounter = 0;
        int weddingCounter = 250;
        int christeningCounter = 500;

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
            txaNotif.setLineWrap(true);  
            txaNotif.setWrapStyleWord(true);
            txaNotif.setEditable(false);
            pnlEast.add(txaNotif);

            linkedList = new LinkedList<>();
            listModel = new DefaultListModel<>();

            list = new JList(listModel);
            scrollPane = new JScrollPane(list);
            scrollPane.setBounds(30, 40, 350, 340);
            pnlCenter.add(scrollPane);

            btnAddEvent.addActionListener(e -> adminAdd());              
            btnBack.addActionListener(this);
            gettingTheUserData();
            
            add(pnlCenter);
            add(pnlEast);
            add(pnlNorth);
            setVisible(true);
        }
        //code for getting the data from user
        //data will come from the file which comes from the celebrantInformationFormFINAL class
        public void gettingTheUserData(){
            txaNotif.setText("");
            listModel = new DefaultListModel<>();
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
            
        } public void adminAdd() {
            //getting the data from the textfields and the combo box
            String eventName = tfEventName.getText().trim();
            String organizerName = tfName.getText().trim();
            String eventDate = tfDate.getText().trim();
            String attendees = (String) cmbAttendees.getSelectedItem();
            String duration = (String) cmbDuration.getSelectedItem();
            String timeEvent = tfTimeEvent.getText().trim();

        //EXCEPTION 
        if (eventName.isEmpty() || organizerName.isEmpty() || eventDate.isEmpty() || timeEvent.isEmpty()
            || attendees.equals("Select Option") || duration.equals("Select Option")) {
            txaNotif.setText("PLEASE FILL OUT ALL FIELDS");
            return;
        }

    //connection to database
        try (Connection conn = connector.getCon()) {
        if (conn == null) {
            JOptionPane.showMessageDialog(this, "Database connection failed!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String query = "INSERT INTO adminaddtable (event_name, name, date, attendees, duration, time_of_event) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement insertStmt = conn.prepareStatement(query)) {
            // Set the event data for the query
            insertStmt.setString(1, eventName);
            insertStmt.setString(2, organizerName);
            insertStmt.setString(3, eventDate);
            insertStmt.setString(4, attendees);
            insertStmt.setString(5, duration);
            insertStmt.setString(6, timeEvent);
            
            insertStmt.executeUpdate();
            txaNotif.setText("EVENT ADDED SUCCESSFULLY");

            //clear all fields and combobox after adding
            tfEventName.setText("");
            tfName.setText("");
            tfDate.setText("");
            cmbAttendees.setSelectedIndex(0);
            cmbDuration.setSelectedIndex(0);
            tfTimeEvent.setText("");
        }

        } catch (SQLException ex) {
            ex.printStackTrace();
            txaNotif.setText("ERROR: " +ex.getMessage());
        }
    }
}