/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;


/**
 *
 * @author 63955
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.sql.Statement;

/**
 *
 * @author 63955
 */

public class celebrantInformationForm extends JFrame implements ActionListener {
    
  JLabel lblName, lblAttendees, lblDate, lblHeader, lblEvent, lblDuration;
  JPanel pnlInfoForm;
  JTextField txtName, txtDate, txtDuration, txtEvent;
  JButton btnRequest;
  JComboBox cmbAttendeeReq, cmbDuration;
  String[] eventDuration;
    
  celebrantInformationForm(){
    
    this.setSize(1000, 800);
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(null);
    this.getContentPane().setBackground(new Color(244, 187, 255));
    
    lblHeader = new JLabel("CELEBRANT INFORMATION FORM");
    lblHeader.setFont(new Font("Serif",Font.BOLD,25));
    lblHeader.setForeground(Color.WHITE);
    lblHeader.setBounds(13, 25, 800, 40);
    add(lblHeader);
    
    pnlInfoForm = new JPanel();
    pnlInfoForm.setBounds(0, 0, 1000, 90);  
    pnlInfoForm.setBackground(new Color(190, 140, 229));
    add(pnlInfoForm);
    
    lblName = new JLabel("Name: ");
    lblName.setFont(new Font("Serif",Font.BOLD,25));
    lblName.setForeground(Color.BLACK);
    lblName.setBounds(220, 60 , 150, 160);
    add(lblName);
    
    txtName = new JTextField(50);
    txtName.setBounds(400, 120, 520, 50);
    txtName.setBorder(null);
    txtName.setBackground(new Color(	209, 159, 232));
    txtName.setForeground(Color.BLACK);
    txtName.setFont(new Font("Serif",Font.BOLD,15));
    txtName.setText("");
    add(txtName);
    
    lblAttendees = new JLabel("Attendees: ");
    lblAttendees.setFont(new Font("Serif",Font.BOLD,25));
    lblAttendees.setForeground(Color.BLACK);
    lblAttendees.setBounds(180,160, 200, 160);
    add(lblAttendees);
    
    String[] attendeesOptions = {"Select an option", "20 persons", "35 persons", "50persons"}; 
    cmbAttendeeReq = new JComboBox<>(attendeesOptions);  
    cmbAttendeeReq.setBorder(null);
    cmbAttendeeReq.setBounds(400, 220, 520, 50);  
    cmbAttendeeReq.setBackground(new Color(	209, 159, 232));
    cmbAttendeeReq.setFont(new Font("Serif",Font.BOLD,15));
    add(cmbAttendeeReq);
    
 
    lblDate = new JLabel ("Date (yyyy/mm/dd): ");
    lblDate.setFont(new Font("Serif",Font.BOLD,25));
    lblDate.setForeground(Color.BLACK);
    lblDate.setBounds(80, 280, 230, 160);
    add(lblDate);
  
    txtDate = new JTextField(50);
    txtDate.setBorder(null);
    txtDate.setBounds(400, 330, 520, 50);
    txtDate.setBackground(new Color(	209, 159, 232));
    txtDate.setForeground(Color.BLACK);
    txtDate.setFont(new Font("Serif",Font.BOLD,15));
    txtDate.setText("");
    add(txtDate);
    
    lblDuration = new JLabel("Time Duration ");
    lblDuration.setFont(new Font("Serif",Font.BOLD,18));
    lblDuration.setForeground(Color.BLACK);
    lblDuration.setBounds(185, 460 , 200, 100);
    add(lblDuration);
    
    String [] eventDuration = {"Select Option", "2 hours", "3 hours and half hours" , "5 hours"}; 
    cmbDuration = new JComboBox<>(eventDuration);  
    cmbDuration.setBorder(null);
    cmbDuration.setBounds(140, 450, 230, 40);  
    cmbDuration.setBackground(new Color(	209, 159, 232));
    cmbDuration.setFont(new Font("Serif",Font.BOLD,20));
    add(cmbDuration);
    
    lblEvent = new JLabel("Time of Event   ");
    lblEvent.setFont(new Font("Serif",Font.BOLD,18));
    lblEvent.setForeground(Color.BLACK);
    lblEvent.setBounds(620, 460 , 200, 100);
    add(lblEvent);
    
    txtEvent = new JTextField(50);
    txtEvent.setBorder(null);
    txtEvent.setBounds(580, 450, 230, 40);
    txtEvent.setBackground(new Color(	209, 159, 232));
    txtEvent.setForeground(Color.BLACK);
    txtEvent.setFont(new Font("Serif",Font.BOLD,15));
    txtEvent.setText("");
    add(txtEvent);
    
    btnRequest = new JButton("REQUEST SCHEDULE");
    btnRequest.setBounds(360, 590, 220, 60); 
    btnRequest.setFont(new Font("Serif",Font.BOLD,15));
    btnRequest.setBackground(new Color(190, 140, 229));
    add(btnRequest);
  
    btnRequest.addActionListener((ActionEvent e)->{ 
    String name = txtName.getText();
    String date = txtDate.getText();
    String duration = (String) cmbDuration.getSelectedItem();
    String event = txtEvent.getText();
    String attendees = (String) cmbAttendeeReq.getSelectedItem();
    try{
                Statement statement = DBConnection.getCon().createStatement();
                statement.executeUpdate("INSERT INTO celebrantinformationform(Name,Attendees, Date, Time Duration, Time of Event)" +
                        "VALUES('"+name+ "',  '"+attendees+ "', '"+date+ "' , '"+duration+ "' , '"+event+ "'  )");
                JOptionPane.showMessageDialog(null, "Please Wait...", "Adding", JOptionPane.INFORMATION_MESSAGE);
                
            new Thread(() -> {
                try {
                    Thread.sleep(2000); // Simulate processing time
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                
                SwingUtilities.invokeLater(()->{
                    
                    txtName.setText("");
                    txtDate.setText("");
                    txtDuration.setText("");
                    txtEvent.setText("");    
                });
             }).start();
           
                
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, ex);
            }
              
          
    });
    setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
          if (e.getSource() == btnRequest) {
            String name = txtName.getText();
            String attendees = cmbAttendeeReq.getSelectedItem().toString();
            String date = txtDate.getText();

            if (name.isEmpty() || attendees.equals("Select an option") || date.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in all fields.");
            } else {
                JOptionPane.showMessageDialog(this, "Request Submitted:\nName: " + name + "\nAttendees: " + attendees + "\nDate: " + date);
                
                txtName.setText("");
                cmbAttendeeReq.setSelectedIndex(0);
                txtDate.setText("");
            }
        }
    }

    public static void main(String[] args) {
        new celebrantInformationForm();
        
    }
    
}


