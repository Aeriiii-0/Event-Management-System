
package com.mycompany.eventmanagementsystemmain;


import java.awt.*;
import javax.swing.*;



public class adminSearchAndDelete extends JFrame{
    JTextField tfTxt;
    JLabel lblTitle;
    JButton btndelEvent, btnlookEvent;
    JTextArea txaSearch;
    JPanel pnlSearchBg;
 
        adminSearchAndDelete(){
        
        
        setSize(1000, 800);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(213, 182, 238));
        
        tfTxt = new JTextField("Type here...");
        tfTxt.setBorder(null);
        tfTxt.setOpaque(true);
        tfTxt.setFocusable(true);
        tfTxt.setForeground(new Color(66, 3, 104));
        tfTxt.setBounds(115, 65, 770, 65);
        tfTxt.setBackground(new Color(213, 182, 238));
        tfTxt.setFont(new Font("Arial",Font.BOLD,15));
        add(tfTxt);
        
        pnlSearchBg=new JPanel();
        pnlSearchBg.setBounds(100, 50, 800, 96);
        pnlSearchBg.setBackground(new Color(190, 140, 229));
        add(pnlSearchBg);
        
        lblTitle = new JLabel("Search Here ^");
        lblTitle.setForeground(new Color(66, 3, 104));
        lblTitle.setBounds(120, 160, 200, 30);
        lblTitle.setFont(new Font("Arial",Font.BOLD,15));
        add(lblTitle);
     
        btndelEvent = new JButton("Delete");
        btndelEvent.setBounds(200, 650, 146, 53);
        btndelEvent.setFont(new Font("Arial",Font.BOLD,28));
        btndelEvent.setForeground(new Color(66, 3, 104));
        btndelEvent.setFocusable(false);
        btndelEvent.setContentAreaFilled(false);
        btndelEvent.setBorderPainted(false);
        btndelEvent.setFocusPainted(false);
        btndelEvent.setBackground(new Color(190, 140, 229));
        add(btndelEvent);
 //       btnldel.addActionListener(this);

        
        btnlookEvent = new JButton("Search");
        btnlookEvent.setBounds(645, 650, 146, 53);
        btnlookEvent.setFont(new Font("Arial",Font.BOLD,28));
        btnlookEvent.setForeground(new Color(66, 3, 104));
        btnlookEvent.setFocusable(false);
        btnlookEvent.setContentAreaFilled(false);
        btnlookEvent.setBorderPainted(false);
        btnlookEvent.setFocusPainted(false);
        btnlookEvent.setBackground(new Color(190, 140, 229));
        add(btnlookEvent);
//        btnlook.addActionListener(this);
        
        txaSearch = new JTextArea(); 
        txaSearch.setBounds(100, 200, 800, 400);
        txaSearch.setBackground(new Color(190, 140, 229));
        txaSearch.setForeground(new Color(66, 3, 104));
        txaSearch.setEditable(false);
        add(txaSearch);
         
        setVisible(true);
    
    }
//        public void actionPerformed(ActionEvent e){
//            if(e.getSource()== btnldel)
//        }

    

   }
    


