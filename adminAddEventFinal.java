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

public class adminAddEventFinal extends JFrame  {
    
    JLabel lblHeader, lblEventName, lblName, lblDate, lblAttendees, lblTimeDuration, lblTimeEvent;
    JPanel pnlNorth, pnlCenter, pnlEast;
    JTextField tfEventName, tfName, tfDate, tfAttendees, tfTimeDuration, tfTimeEvent;
    JTextArea txaNotif;
    JButton btnAddEvent, btnUpdateDataBase, btnBack;
    String inputEventName, inputDate, inputName, inputAttendees, message;
    
    adminAddEventFinal(){
        this.setSize(1000, 800);
        this.setTitle("Event Venture");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        getContentPane().setBackground(new Color(213, 182, 238));
        this.setLocationRelativeTo(null);
        this.setLayout(null);

        pnlNorth = new JPanel();
        pnlNorth.setLayout(null);
        pnlNorth.setBounds(0, 0, 1000, 90);
        pnlNorth.setBackground(new Color(190, 140, 229));
        pnlNorth.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));

        lblHeader = new JLabel("ADMIN APPROVAL SLIP");
        lblHeader.setFont(new Font("Arial", Font.BOLD, 30));
        lblHeader.setBounds(320, 15, 400, 60);
        lblHeader.setForeground(new Color(66, 3, 104));
        pnlNorth.add(lblHeader);

        pnlCenter = new JPanel();
        pnlCenter.setLayout(null);
        pnlCenter.setBounds(0, 89, 700, 710);
        pnlCenter.setBackground(new Color(213, 182, 238));

        lblEventName = new JLabel("Event Name: ");
        lblEventName.setFont(new Font("Arial", Font.BOLD, 25));
        lblEventName.setForeground(new Color(66, 3, 104));
        lblEventName.setBounds(80, 70, 200, 40);

        lblName = new JLabel("Name: ");
        lblName.setFont(new Font("Arial", Font.BOLD, 25));
        lblName.setForeground(new Color(66, 3, 104));
        lblName.setBounds(155, 140, 200, 40);

        lblDate = new JLabel("Date: ");
        lblDate.setFont(new Font("Arial", Font.BOLD, 25));
        lblDate.setForeground(new Color(66, 3, 104));
        lblDate.setBounds(165, 210, 200, 40);
        
        lblAttendees = new JLabel("Attendees: ");
        lblAttendees.setFont(new Font("Arial", Font.BOLD, 25));
        lblAttendees.setForeground(new Color(66, 3, 104));
        lblAttendees.setBounds(100, 280, 200, 40);

        lblTimeDuration = new JLabel("Time Duration");
        lblTimeDuration.setFont(new Font("Arial", Font.BOLD, 15));
        lblTimeDuration.setForeground(new Color(66, 3, 104));
        lblTimeDuration.setBounds(150, 390, 200, 40);

        lblTimeEvent = new JLabel("Time of Event");
        lblTimeEvent.setFont(new Font("Arial", Font.BOLD, 15));
        lblTimeEvent.setForeground(new Color(66, 3, 104));
        lblTimeEvent.setBounds(430, 390, 200, 40);

        pnlCenter.add(lblEventName);
        pnlCenter.add(lblName);
        pnlCenter.add(lblDate);
        pnlCenter.add(lblAttendees);
        pnlCenter.add(lblTimeDuration);
        pnlCenter.add(lblTimeEvent);

        tfEventName = new JTextField();
        tfEventName.setBounds(280, 70, 330, 40);
        tfEventName.setBackground(new Color(190, 140, 229));
        tfEventName.setForeground(new Color(66, 3, 104));

        tfName = new JTextField();
        tfName.setBounds(280, 140, 330, 40);
        tfName.setBackground(new Color(190, 140, 229));
        tfName.setForeground(new Color(66, 3, 104));

        tfDate = new JTextField();
        tfDate.setBounds(280, 210, 330, 40);
        tfDate.setBackground(new Color(190, 140, 229));
        tfDate.setForeground(new Color(66, 3, 104));

        tfAttendees = new JTextField();
        tfAttendees.setBounds(280, 280, 330, 40);
        tfAttendees.setBackground(new Color(190, 140, 229));
        tfAttendees.setForeground(new Color(66, 3, 104));
        
        tfTimeDuration = new JTextField();
        tfTimeDuration.setBounds(80, 355, 250, 40);
        tfTimeDuration.setBackground(new Color(190, 140, 229));
        tfTimeDuration.setForeground(new Color(66, 3, 104));
        
        tfTimeEvent = new JTextField();
        tfTimeEvent.setBounds(360, 355, 250, 40);
        tfTimeEvent.setBackground(new Color(190, 140, 229));
        tfTimeEvent.setForeground(new Color(66, 3, 104));
        
        pnlCenter.add(tfEventName);
        pnlCenter.add(tfName);
        pnlCenter.add(tfDate);
        pnlCenter.add(tfAttendees);
        pnlCenter.add(tfTimeDuration);
        pnlCenter.add(tfTimeEvent);

        btnAddEvent = new JButton("ADD EVENT");
        btnAddEvent.setFocusable(false);
        btnAddEvent.setBounds(110, 440, 190, 60);
        btnAddEvent.setBackground(new Color(190, 140, 229)); 
        btnAddEvent.setForeground(new Color(66, 3, 104));
        btnAddEvent.setBorder(BorderFactory.createEmptyBorder());
      
        btnUpdateDataBase = new JButton("UPDATE DATABASE");
        btnUpdateDataBase.setFocusable(false);
        btnUpdateDataBase.setBounds(390, 440, 190, 60);
        btnUpdateDataBase.setBackground(new Color(190, 140, 229));
        btnUpdateDataBase.setForeground(new Color(66, 3, 104));
        btnUpdateDataBase.setBorder(BorderFactory.createEmptyBorder());
        
        btnBack=new JButton("Back");
        btnBack.setBounds(-70, 50, 200, 50);
        btnBack.setFont(new Font("Arial",Font.BOLD,12));
        btnBack.setForeground(new Color(66, 3, 104));
        btnBack.setBorderPainted(false);
        btnBack.setContentAreaFilled(false);
        btnBack.setFocusPainted(false);
        add(btnBack);

        pnlCenter.add(btnAddEvent);
        pnlCenter.add(btnUpdateDataBase);

        pnlEast = new JPanel();
        pnlEast.setBounds(700, 89, 300, 710);
        pnlEast.setLayout(null);
        pnlEast.setBackground(new Color(190, 140, 229));

        txaNotif = new JTextArea();
        txaNotif.setBounds(15, 0, 250, 650);
        txaNotif.setBackground(new Color(213, 182, 238));
        txaNotif.setFont(new Font("Arial", Font.BOLD, 20));
        txaNotif.setForeground(new Color(66, 3, 104));
        txaNotif.setBorder(BorderFactory.createTitledBorder("NOTIFICATIONS: "));
        txaNotif.setLineWrap(true);  
        txaNotif.setWrapStyleWord(true);
        txaNotif.setEditable(false);
        pnlEast.add(txaNotif);
        
        
        btnBack.addActionListener((ActionEvent e)->{
            this.dispose();
            new adminFrameGeneral();
        });
        
        btnAddEvent.addActionListener((ActionEvent e)->{
            txaNotif.setText("");
            tfException();
        });
        btnUpdateDataBase.addActionListener((ActionEvent e)->{
            txaNotif.setText("");
            tfException();
            if(message.isEmpty()){
            txaNotif.setText("Successfully UPDATED");
            }
        });
  
        add(pnlCenter);
        add(pnlEast);
        add(pnlNorth);

        setVisible(true);
    } private String tfException() {
         message = "";
        try{
             inputEventName = tfEventName.getText();
             inputName = tfName.getText();
             inputDate = tfDate.getText();
             inputAttendees = tfAttendees.getText();
             
             if(inputEventName.isEmpty()){
                 message += "Event Name Field is Empty \n";
             }
             if (inputName.isEmpty()){
                 message += "Name Field is Empty \n";
             }
             if (inputDate.isEmpty()){
                 message += "Date Field is  Empty \n";
             }
             if (inputAttendees.isEmpty()){
                 message += "Attendees Field is Empty \n";
             }
             
             if(!message.isEmpty()){
                 txaNotif.setText(message+"\n");
             } else {
                 txaNotif.setText("Successfully ADDED");
                 tfEventName.setText("");
                 tfName.setText("");
                 tfDate.setText("");
                 tfAttendees.setText("");
             }
   
        } catch(Exception e){
            txaNotif.setText("UNEXPECTED ERROR HAS OCCURED");  
        } //trycatch end
        return message;
    }//method end
    
}

     