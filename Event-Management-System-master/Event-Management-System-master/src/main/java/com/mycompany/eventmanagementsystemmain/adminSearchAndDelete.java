
package com.mycompany.eventmanagementsystemmain;


import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


//frame for seach and deleting events to database
public class adminSearchAndDelete extends JFrame implements ActionListener{
    JTextField tfSearch;
    JLabel lblTitle;
    JButton btnDeleteEvent, btnSearchEvent;
    JTextArea txaDisplayEventFound;
    JPanel pnlSearchBg;
 
        adminSearchAndDelete(){
        
        //component settings
        setSize(1000, 800);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(213, 182, 238));
        
        tfSearch = new JTextField("Type here...");
        tfSearch.setBorder(null);
        tfSearch.setOpaque(true);
        tfSearch.setFocusable(true);
        tfSearch.setForeground(new Color(66, 3, 104));
        tfSearch.setBounds(115, 65, 770, 65);
        tfSearch.setBackground(new Color(213, 182, 238));
        tfSearch.setFont(new Font("Arial",Font.BOLD,15));
        add(tfSearch);
        
        pnlSearchBg=new JPanel();
        pnlSearchBg.setBounds(100, 50, 800, 96);
        pnlSearchBg.setBackground(new Color(190, 140, 229));
        add(pnlSearchBg);
        
        lblTitle = new JLabel("Search Here ^");
        lblTitle.setForeground(new Color(66, 3, 104));
        lblTitle.setBounds(120, 160, 200, 30);
        lblTitle.setFont(new Font("Arial",Font.BOLD,15));
        add(lblTitle);
     
        btnDeleteEvent = new JButton("Delete");
        btnDeleteEvent.setBounds(200, 650, 146, 53);
        btnDeleteEvent.setFont(new Font("Arial",Font.BOLD,28));
        btnDeleteEvent.setForeground(new Color(66, 3, 104));
        btnDeleteEvent.setFocusable(false);
        btnDeleteEvent.setContentAreaFilled(false);
        btnDeleteEvent.setBorderPainted(false);
        btnDeleteEvent.setFocusPainted(false);
        btnDeleteEvent.setBackground(new Color(190, 140, 229));
        add(btnDeleteEvent);
        btnDeleteEvent.addActionListener(this);

        
        btnSearchEvent = new JButton("Search");
        btnSearchEvent.setBounds(645, 650, 146, 53);
        btnSearchEvent.setFont(new Font("Arial",Font.BOLD,28));
        btnSearchEvent.setForeground(new Color(66, 3, 104));
        btnSearchEvent.setFocusable(false);
        btnSearchEvent.setContentAreaFilled(false);
        btnSearchEvent.setBorderPainted(false);
        btnSearchEvent.setFocusPainted(false);
        btnSearchEvent.setBackground(new Color(190, 140, 229));
        add(btnSearchEvent);
        btnSearchEvent.addActionListener(this);
        
        txaDisplayEventFound = new JTextArea(); 
        txaDisplayEventFound.setBounds(100, 200, 800, 400);
        txaDisplayEventFound.setBackground(new Color(190, 140, 229));
        txaDisplayEventFound.setForeground(new Color(66, 3, 104));
        txaDisplayEventFound.setEditable(false);
        add(txaDisplayEventFound);
         
        setVisible(true);
    
    }
       public void actionPerformed(ActionEvent e){
          if(e.getSource()== btnDeleteEvent){
              //no method yet.
          }
      }

    

   }
    


