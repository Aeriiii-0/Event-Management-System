
package com.mycompany.eventmanagementsystemmain;


import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


//frame for seach and deleting events to database
public class adminSearch extends JFrame implements ActionListener{
    JTextField tfSearch;
    JLabel lblTitle;
    JButton  btnSearchEvent, btnBack;
    JTextArea txaDisplayEventFound;
    JPanel pnlSearchBg;
 
        adminSearch(){
        
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
        
        btnBack=new JButton("Back");
        btnBack.setBounds(840, 700, 200, 50);
        btnBack.setFont(new Font("Arial",Font.BOLD,12));
        btnBack.setForeground(new Color(66, 3, 104));
        btnBack.setBorderPainted(false);
        btnBack.setContentAreaFilled(false);
        btnBack.setFocusPainted(false);
        add(btnBack);
        btnBack.addActionListener(this);
        
        txaDisplayEventFound = new JTextArea(); 
        txaDisplayEventFound.setBounds(100, 200, 800, 400);
        txaDisplayEventFound.setBackground(new Color(190, 140, 229));
        txaDisplayEventFound.setForeground(new Color(66, 3, 104));
        txaDisplayEventFound.setEditable(false);
        add(txaDisplayEventFound);
         
        setVisible(true);
    
    }
       public void actionPerformed(ActionEvent e){
          if(e.getSource()== btnSearchEvent){
              //no method yet.
          }else if(e.getSource()==btnBack){
              new adminDashboard();
              dispose();
          }
      }

    

   }
    


