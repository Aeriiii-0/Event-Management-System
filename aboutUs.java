
package com.mycompany.eventmanagementsystemmain;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class aboutUs extends JFrame implements ActionListener{
    
    JLabel lblHeader, lblHeader2, lblSubHeader, lblContact, lblFollow, lblTelephone, lblCellphone, lblFacebook, lblInstagram;
    JPanel pnlTop, pnlCenter, pnlContact, pnlFollow;
    JButton btnMyEvent, btnScheduleEvent, btnAboutUs, btnSearch, btnBack;
    
    aboutUs() {
        
    // Frame settings
    setSize(1000, 800);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(null);
    setTitle("EVENT VENTURE");
    setResizable(false); 
    getContentPane().setBackground(new Color(213, 182, 238));

    pnlCenter = new JPanel();
    pnlCenter.setLayout(null);
    pnlCenter.setBounds(185, 200, 600, 100);  
    pnlCenter.setBackground(new Color(190, 140, 229));
    pnlCenter.setBorder(BorderFactory.createLineBorder(new Color(66, 3, 104), 3));
    add(pnlCenter);

    pnlContact = new JPanel();
    pnlContact.setLayout(null);
    pnlContact.setBounds(100, 580, 320, 50);  
    pnlContact.setBackground(new Color(190, 140, 229));
    pnlContact.setBorder(BorderFactory.createLineBorder(new Color(66, 3, 104), 3));
    add(pnlContact);

    lblContact = new JLabel("Contact Us");
    lblContact.setFont(new Font("Serif",Font.BOLD, 22));
    lblContact.setForeground(new Color(66, 3, 104));
    lblContact.setBounds(100, 0, 300, 50);
    pnlContact.add(lblContact);

    pnlFollow = new JPanel();
    pnlFollow.setLayout(null);
    pnlFollow.setBounds(560, 580, 320, 50);  
    pnlFollow.setBackground(new Color(190, 140, 229));
    pnlFollow.setBorder(BorderFactory.createLineBorder(new Color(66, 3, 104), 3));
    add(pnlFollow);

    lblFollow = new JLabel("Follow Us");
    lblFollow.setFont(new Font("Serif",Font.BOLD, 22));
    lblFollow.setForeground(new Color(66, 3, 104));
    lblFollow.setBounds(110, 0, 300, 50);
    pnlFollow.add(lblFollow);

    lblHeader = new JLabel("About Us");
    lblHeader.setFont(new Font("Serif", Font.BOLD, 30));
    lblHeader.setForeground(new Color(66, 3, 104));
    lblHeader.setBounds(30, 30, 300, 40);

    lblHeader2 = new JLabel("EVENT VENTURE");
    lblHeader2.setFont(new Font("Serif",Font.BOLD,30));
    lblHeader2.setForeground(new Color(66, 3, 104));
    lblHeader2.setBounds(170, 30, 500, 40);
    pnlCenter.add(lblHeader2);

    //frame paragraph
    lblSubHeader = new JLabel("<html>" 
            + "<div style='text-align: center;'>"
            + "<p style='line-height: 1.8;'>Welcome to our Event Management System, your all-in-one solution for planning, organizing, and managing events effortlessly. "
            + "Our platform is designed to streamline the event management process, allowing users to create, search, and track events with ease<br>.</p>"
            + "<p style='line-height: 1.8;'>Whether you're organizing a birthday, wedding, or the christening of your baby, our system provides a user-friendly interface and robust features to ensure your event's success. "
            + "With a focus on simplicity, efficiency, and reliability, we aim to make event management stress-free and accessible for everyone.</p>"
            + "<p style='line-height: 1.8;'><br>Join us in transforming the way events are managed!</p>"
            + "</div>"
            + "</html>");
    lblSubHeader.setFont(new Font("Arial", Font.PLAIN, 16));
    lblSubHeader.setBounds(185, 250, 610, 350);
    add(lblSubHeader);

    lblTelephone = new JLabel("📞 Telephone: (***) *** - ****");
    lblTelephone.setFont(new Font("Serif",Font.ITALIC , 18));
    lblTelephone.setForeground(new Color(66, 3, 104));
    lblTelephone.setBounds(130, 630, 320, 50);
    add(lblTelephone);

    lblCellphone = new JLabel("📱 Cellphone: (+63) *** *** ****");
    lblCellphone.setFont(new Font("Serif",Font.ITALIC , 18));
    lblCellphone.setForeground(new Color(66, 3, 104));
    lblCellphone.setBounds(130, 670, 320, 50);
    add(lblCellphone);

    lblFacebook = new JLabel("📘 FaceBook: Event Venture Official");
    lblFacebook.setFont(new Font("Serif",Font.ITALIC , 18));
    lblFacebook.setForeground(new Color(66, 3, 104));
    lblFacebook.setBounds(580, 630, 320, 50);
    add(lblFacebook);

    lblInstagram = new JLabel("📸 Instagram: its_EventVenture");
    lblInstagram.setFont(new Font("Serif",Font.ITALIC , 18));
    lblInstagram.setForeground(new Color(66, 3, 104));
    lblInstagram.setBounds(580, 670, 320, 50);
    add(lblInstagram);

    // Buttons on the top panel
    btnMyEvent = new JButton("My Event");
    btnMyEvent.setBounds(400, 0, 150, 100);
    btnMyEvent.setFont(new Font("Serif", Font.ITALIC, 15));
    btnMyEvent.setFocusable(false);
    btnMyEvent.setContentAreaFilled(false);
    btnMyEvent.setBorderPainted(false);
    btnMyEvent.setFocusPainted(false);
    btnMyEvent.addActionListener(this);


    btnScheduleEvent = new JButton("Schedule an Event");
    btnScheduleEvent.setBounds(550, 0, 150, 100);
    btnScheduleEvent.setFont(new Font("Serif", Font.ITALIC, 15));
    btnScheduleEvent.setFocusable(false);
    btnScheduleEvent.setContentAreaFilled(false);
    btnScheduleEvent.setBorderPainted(false);
    btnScheduleEvent.setFocusPainted(false);
    btnScheduleEvent.addActionListener(this);


    btnSearch = new JButton("Search Event");
    btnSearch.setBounds(700, 0, 150, 100);
    btnSearch.setFont(new Font("Serif", Font.ITALIC, 15));
    btnSearch.setFocusable(false);
    btnSearch.setContentAreaFilled(false);
    btnSearch.setBorderPainted(false);
    btnSearch.setFocusPainted(false);
    btnSearch.addActionListener(this);

    btnAboutUs = new JButton("About Us");
    btnAboutUs.setBounds(850, 0, 150, 100);
    btnAboutUs.setFont(new Font("Serif", Font.ITALIC, 15));
    btnAboutUs.setFocusable(false);
    btnAboutUs.setContentAreaFilled(false);
    btnAboutUs.setBorderPainted(false);
    btnAboutUs.setFocusPainted(false);
    btnAboutUs.addActionListener(this);

    pnlTop=new JPanel();
    pnlTop.setLayout(null);
    pnlTop.setBounds(-2, -2, 1000, 100);
    pnlTop.setBackground(new Color(190, 140, 229));
    pnlTop.setBorder(BorderFactory.createLineBorder(new Color(66, 3, 104), 3));
    add(pnlTop);
    pnlTop.add(lblHeader);
    pnlTop.add(btnMyEvent);
    pnlTop.add(btnScheduleEvent);
    pnlTop.add(btnSearch);
    pnlTop.add(btnAboutUs);

    btnBack = new JButton("Back");
    btnBack.setBounds(840, 700, 150, 40);
    btnBack.setFont(new Font("Arial", Font.BOLD, 14));
    btnBack.setForeground(new Color(66, 3, 104));
    btnBack.setBorderPainted(false);
    btnBack.setContentAreaFilled(false);
    btnBack.setFocusPainted(false);
    btnBack.addActionListener(this);
    add(btnBack);

    setVisible(true);

        }


        @Override
        public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnMyEvent){
            dispose();
            new userDashForEvents();
        } else if (e.getSource()== btnAboutUs){
            JOptionPane.showMessageDialog(null, "You're already here");
        }else if(e.getSource()== btnScheduleEvent){
            new celebrantInformationForm();
            dispose();
        }else if(e.getSource()== btnSearch){
            new userSearch();
            dispose();
        }else if(e.getSource()== btnBack){
            new userDashForEvents();
            dispose();
        }


        }
    }
