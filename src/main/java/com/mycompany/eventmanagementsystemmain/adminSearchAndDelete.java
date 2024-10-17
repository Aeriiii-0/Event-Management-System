
package com.mycompany.eventmanagementsystemmain;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.*;


public class adminSearchAndDelete extends JFrame implements ActionListener{
    JTextField tfTxt;
    JLabel lblTitle;
    JButton btndelEvent, btnlookEvent;
    JTextArea txaSearch;
    
    adminSearchAndDelete(){
        
        
        setSize(1000, 800);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(213, 182, 238));
        
        tfTxt = new JTextField("Type here...");
        tfTxt.setBorder(null);
        tfTxt.setOpaque(true);
        tfTxt.setFocusable(true);
        tfTxt.setForeground(Color.BLACK);
        tfTxt.setBounds(20, 70, 945, 40);
        tfTxt.setBackground(new Color(190, 140, 229));
        add(tfTxt);
        
        lblTitle = new JLabel("SEARCH", SwingConstants.CENTER);
        lblTitle.setForeground(Color.BLACK);
        lblTitle.setBounds(440, 110, 100, 30);
        lblTitle.setFont(new Font("serif",Font.ROMAN_BASELINE,20));
        add(lblTitle);
     
        btndelEvent = new JButton("Delete");
        btndelEvent.setBounds(200, 650, 146, 53);
        btndelEvent.setFont(new Font("",Font.ROMAN_BASELINE,28));
        btndelEvent.setBorder(BorderFactory.createEmptyBorder());
        btndelEvent.setBackground(new Color(213, 182, 238));
        add(btndelEvent);
 //       btnldel.addActionListener(this);

        
        btnlookEvent = new JButton("Search");
        btnlookEvent.setBounds(645, 650, 146, 53);
        btnlookEvent.setFont(new Font("",Font.ROMAN_BASELINE,28));
        btnlookEvent.setBorder(BorderFactory.createEmptyBorder());
        btnlookEvent.setBackground(new Color(213, 182, 238));
        add(btnlookEvent);
//        btnlook.addActionListener(this);
        
        txaSearch = new JTextArea(); 
        txaSearch.setBounds(20, 150, 945, 470);
        txaSearch.setBackground(new Color(190, 140, 229));
        txaSearch.setEditable(false);
        add(txaSearch);
               
    
    }
//        public void actionPerformed(ActionEvent e){
//            if(e.getSource()== btnldel)
//        }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   }
    


