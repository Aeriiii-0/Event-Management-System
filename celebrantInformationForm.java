package com.mycompany.eventmanagementsystemmain;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;

public class celebrantInformationForm extends JFrame implements ActionListener {

    JLabel lblName, lblDate, lblHeader, lblEvent, lblDuration, lblEventName;
    JPanel pnlInfoForm;
    JTextField tfName, tfDate, tfEvent;
    JButton btnRequest, btnBack;
    JComboBox cmbDuration, cmbEventName;
    String[] eventDuration = {"Select Option", "2 hours", "3 hours and half hours", "5 hours"};
    String[] eventNames = {"Select an option", "Birthday", "Wedding", "Christening"};

    celebrantInformationForm() {
        // Component settings
        setSize(1000, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(new Color(213, 182, 238));

        lblHeader = new JLabel("CELEBRANT INFORMATION FORM");
        lblHeader.setFont(new Font("Serif", Font.BOLD, 25));
        lblHeader.setForeground(new Color(66, 3, 104));
        lblHeader.setBounds(13, 30, 800, 40);
        add(lblHeader);

        pnlInfoForm = new JPanel();
        pnlInfoForm.setBounds(-2, -2, 990, 100);
        pnlInfoForm.setBackground(new Color(190, 140, 229));
        pnlInfoForm.setBorder(BorderFactory.createLineBorder(new Color(66, 3, 104), 3));
        add(pnlInfoForm);

        // Textfields, combo boxes, and labels settings.
        lblEventName = new JLabel("Event Name: ");
        lblEventName.setFont(new Font("Serif", Font.BOLD, 20));
        lblEventName.setForeground(new Color(66, 3, 104));
        lblEventName.setBounds(120, 100, 150, 160);
        add(lblEventName);

        //eventname
        cmbEventName = new JComboBox<>(eventNames);
        cmbEventName.setBounds(250, 160, 600, 40);
        cmbEventName.setBackground(new Color(190, 140, 229));
        cmbEventName.setBorder(BorderFactory.createLineBorder(new Color(66, 3, 104), 3));
        cmbEventName.setFont(new Font("Serif", Font.BOLD, 17));
        cmbEventName.setForeground(new Color(66, 3, 104));
        add(cmbEventName);

        //name
        lblName = new JLabel("Name: ");
        lblName.setFont(new Font("Serif", Font.BOLD, 20));
        lblName.setForeground(new Color(66, 3, 104));
        lblName.setBounds(120, 180, 150, 160);
        add(lblName);

        tfName = new JTextField(50);
        tfName.setBounds(200, 240, 650, 40);
        tfName.setBackground(new Color(190, 140, 229));
        tfName.setBorder(BorderFactory.createLineBorder(new Color(66, 3, 104), 3));
        tfName.setForeground(new Color(66, 3, 104));
        tfName.setFont(new Font("Serif", Font.BOLD, 17));
        tfName.setText("");
        add(tfName);

        //date
        lblDate = new JLabel("Date (yyyy-MM-dd): ");
        lblDate.setFont(new Font("Serif", Font.BOLD, 20));
        lblDate.setForeground(new Color(66, 3, 104));
        lblDate.setBounds(120, 260, 230, 160);
        add(lblDate);

        tfDate = new JTextField(50);
        tfDate.setBounds(320, 320, 530, 40);
        tfDate.setBackground(new Color(190, 140, 229));
        tfDate.setBorder(BorderFactory.createLineBorder(new Color(66, 3, 104), 3));
        tfDate.setForeground(new Color(66, 3, 104));
        tfDate.setFont(new Font("Serif", Font.BOLD, 17));
        tfDate.setText("");
        add(tfDate);

        //time duration 
        lblDuration = new JLabel("Time Duration: ");
        lblDuration.setFont(new Font("Serif", Font.BOLD, 20));
        lblDuration.setForeground(new Color(66, 3, 104));
        lblDuration.setBounds(120, 370, 200, 100);
        add(lblDuration);

        cmbDuration = new JComboBox<>(eventDuration);
        cmbDuration.setBounds(280, 400, 570, 40);
        cmbDuration.setBackground(new Color(190, 140, 229));
        cmbDuration.setBorder(BorderFactory.createLineBorder(new Color(66, 3, 104), 3));
        cmbDuration.setFont(new Font("Serif", Font.BOLD, 17));
        cmbDuration.setForeground(new Color(66, 3, 104));
        add(cmbDuration);

        //time of event
        lblEvent = new JLabel("Time of Event:   ");
        lblEvent.setFont(new Font("Serif", Font.BOLD, 20));
        lblEvent.setForeground(new Color(66, 3, 104));
        lblEvent.setBounds(120, 450, 200, 100);
        add(lblEvent);

        tfEvent = new JTextField(50);
        tfEvent.setBounds(280, 480, 570, 40);
        tfEvent.setBackground(new Color(190, 140, 229));
        tfEvent.setBorder(BorderFactory.createLineBorder(new Color(66, 3, 104), 3));
        tfEvent.setForeground(new Color(66, 3, 104));
        tfEvent.setFont(new Font("Serif", Font.BOLD, 17));
        tfEvent.setText("");
        add(tfEvent);

        //button for request schedule
        btnRequest = new JButton("REQUEST SCHEDULE");
        btnRequest.setBounds(390, 540, 220, 40);
        btnRequest.setFont(new Font("Serif", Font.BOLD, 15));
        btnRequest.setForeground(new Color(66, 3, 104));
        btnRequest.setContentAreaFilled(false);
        btnRequest.setBorder(BorderFactory.createLineBorder(new Color(66, 3, 104), 3));
        btnRequest.setFocusPainted(false);
        add(btnRequest);
        btnRequest.addActionListener(this);

        btnBack = new JButton("Back");
        btnBack.setBounds(857, 717, 200, 50);
        btnBack.setFont(new Font("Arial", Font.BOLD, 12));
        btnBack.setForeground(new Color(66, 3, 104));
        btnBack.setBorderPainted(false);
        btnBack.setContentAreaFilled(false);
        btnBack.setFocusPainted(false);
        add(btnBack);
        btnBack.addActionListener(this);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnRequest) {
            String eventName = (String) cmbEventName.getSelectedItem();
            String name = tfName.getText();
            String date = tfDate.getText();
            String eventTime = tfEvent.getText();
            String timeDuration = (String) cmbDuration.getSelectedItem();

            if (!name.isEmpty() && !date.isEmpty() && !eventTime.isEmpty() &&
                    !timeDuration.equals("Select Option") && !eventName.equals("Select Option")) {

                // Validate date and time
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                try {
                    String fullDateTime = date + " " + eventTime;
                    Date parsedDateTime = dateFormat.parse(fullDateTime);
                    Date currentDateTime = new Date();

                    if (parsedDateTime.before(currentDateTime)) {
                        JOptionPane.showMessageDialog(null, "Invalid time. The entered date and time has already passed.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid date or time format. Please use yyyy-MM-dd for date and HH:mm for time.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // If everything is valid, proceed with the scheduling request
                int conf = JOptionPane.showConfirmDialog(null, "Do you want to submit the event?");
                if (conf == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(null, "Event scheduled successfully!");
                   
                    
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please answer all required fields", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == btnBack) {
           
            dispose();
        }
    }
    
}