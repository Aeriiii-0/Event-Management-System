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

public class adminAddEvent extends JFrame  {
    
    JLabel lblHeader, lblEventName, lblName, lblDate, lblAttendees;
    JPanel pnlNorth, pnlCenter, pnlEast;
    JTextField tfEventName, tfName, tfDate, tfAttendees;
    JTextArea txaNotif;
    JButton btnAddEvent, btnUpdateDataBase;
    String inputEventName, inputDate, inputName, inputAttendees;
    
    adminAddEvent(){
        this.setSize(1000, 800);
        this.setTitle("name of business");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
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
        lblHeader.setForeground(Color.WHITE);
        pnlNorth.add(lblHeader);

        pnlCenter = new JPanel();
        pnlCenter.setLayout(null);
        pnlCenter.setBounds(0, 89, 700, 710);
        pnlCenter.setBackground(new Color(213, 182, 238));

        lblEventName = new JLabel("Event Name: ");
        lblEventName.setFont(new Font("Arial", Font.BOLD, 25));
        lblEventName.setBounds(110, 70, 200, 40);

        lblName = new JLabel("Name: ");
        lblName.setFont(new Font("Arial", Font.BOLD, 25));
        lblName.setBounds(185, 140, 200, 40);

        lblDate = new JLabel("Date: ");
        lblDate.setFont(new Font("Arial", Font.BOLD, 25));
        lblDate.setBounds(195, 210, 200, 40);

        lblAttendees = new JLabel("Attendees: ");
        lblAttendees.setFont(new Font("Arial", Font.BOLD, 25));
        lblAttendees.setBounds(130, 280, 200, 40);

        pnlCenter.add(lblEventName);
        pnlCenter.add(lblName);
        pnlCenter.add(lblDate);
        pnlCenter.add(lblAttendees);

        tfEventName = new JTextField();
        tfEventName.setBounds(300, 70, 280, 40);
        tfEventName.setBackground(new Color(186, 85, 211));

        tfName = new JTextField();
        tfName.setBounds(300, 140, 280, 40);
        tfName.setBackground(new Color(186, 85, 211));

        tfDate = new JTextField();
        tfDate.setBounds(300, 210, 280, 40);
        tfDate.setBackground(new Color(186, 85, 211));

        tfAttendees = new JTextField();
        tfAttendees.setBounds(300, 280, 280, 40);
        tfAttendees.setBackground(new Color(186, 85, 211));

        pnlCenter.add(tfEventName);
        pnlCenter.add(tfName);
        pnlCenter.add(tfDate);
        pnlCenter.add(tfAttendees);

        btnAddEvent = new JButton("ADD EVENT");
        btnAddEvent.setFocusable(false);
        btnAddEvent.setBounds(100, 380, 200, 60);
        btnAddEvent.setBackground(new Color(186, 85, 211)); 
        btnAddEvent.setBorder(BorderFactory.createEmptyBorder());
        btnAddEvent.addActionListener((ActionEvent e)->{
        String resultForbtnAdd= tfException(tfEventName, tfName, tfDate, tfAttendees, "ADDED");
        txaNotif.setText(resultForbtnAdd);
        });
        
        

        btnUpdateDataBase = new JButton("UPDATE DATABASE");
        btnUpdateDataBase.setFocusable(false);
        btnUpdateDataBase.setBounds(330, 380, 200, 60);
        btnUpdateDataBase.setBackground(new Color(186, 85, 211)); 
        btnUpdateDataBase.setBorder(BorderFactory.createEmptyBorder());
        btnUpdateDataBase.addActionListener(e -> {
        String resultForBtnUpdate = tfException(tfEventName, tfName, tfDate, tfAttendees, "UPDATED");
        txaNotif.setText(resultForBtnUpdate);
           
        });

        pnlCenter.add(btnAddEvent);
        pnlCenter.add(btnUpdateDataBase);

        pnlEast = new JPanel();
        pnlEast.setBounds(700, 89, 300, 710);
        pnlEast.setLayout(null);
        pnlEast.setBackground(new Color(190, 140, 229));

        txaNotif = new JTextArea();
        txaNotif.setBounds(15, 0, 250, 650);
        txaNotif.setBackground(new Color(213, 182, 238));
        txaNotif.setFont(new Font("Arial", Font.BOLD, 30));
        txaNotif.setBorder(BorderFactory.createTitledBorder("NOTIFICATIONS: "));
        txaNotif.setLineWrap(true);  
        txaNotif.setWrapStyleWord(true);

        pnlEast.add(txaNotif);

        add(pnlCenter);
        add(pnlEast);
        add(pnlNorth);

        setVisible(true);
    }

    private String tfException(JTextField tfEventName, JTextField tfName, JTextField tfDate, JTextField tfAttendees, String resultForTxa) {
        inputEventName = tfEventName.getText();
        inputName = tfName.getText();
        inputDate = tfDate.getText();
        inputAttendees = tfAttendees.getText();
        
        String message = " ";
        
        if(inputEventName.isEmpty()){
            return "Event Field is Empty";
        } if (inputName.isEmpty()){
            return "Name Field is Empty";
        } if (inputDate.isEmpty()){
            return "Date Field is Empty";
        } if (inputAttendees.isEmpty()){
            return "Attendees Field is Empty";
        }
        return resultForTxa;

 
    }
}

     