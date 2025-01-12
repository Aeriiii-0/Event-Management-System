
package com.mycompany.eventmanagementsystemmain;


import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;

//frame for seach and deleting events to database
public class adminSearch extends JFrame implements ActionListener{
    JTextField tfSearch;
    JLabel lblTitle;
    JButton  btnSearchEvent, btnBack;
    JTextArea txaDisplayEventFound;
    JPanel pnlSearchBg;
    JTable table;
    String[] columnNames = {"Event Name", "Name", "Date", "Time", "Duration", "Status"} ;
    JScrollPane scrollPane;
    
adminSearch(){

//component settings
setSize(1000, 800);
setLayout(null);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
getContentPane().setBackground(new Color(213, 182, 238));

tfSearch = new JTextField();
tfSearch.setForeground(new Color(66, 3, 104));
tfSearch.setBounds(115, 65, 770, 65);
tfSearch.setBackground(new Color(190, 140, 229));
tfSearch.setFont(new Font("Arial",Font.BOLD,15));
tfSearch.setBorder(BorderFactory.createLineBorder(new Color(66, 3, 104), 3));
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
btnSearchEvent.setBounds(400, 650, 200, 40);
btnSearchEvent.setFont(new Font("Arial",Font.BOLD,18));
btnSearchEvent.setForeground(new Color(66, 3, 104));
btnSearchEvent.setContentAreaFilled(false);  
btnSearchEvent.setBorder(BorderFactory.createLineBorder(new Color(66, 3, 104), 3));
btnSearchEvent.setFocusPainted(false);
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

DefaultTableModel model = new DefaultTableModel(columnNames, 0) {
    @Override
    public boolean isCellEditable(int row, int column) {
        return false; // Disable table editing


    }
};

// Initializing table
table = new JTable(model);

// Adding scroll pane to the table
scrollPane = new JScrollPane(table);
scrollPane.setBounds(100, 200, 800, 400); 
scrollPane.setBorder(BorderFactory.createLineBorder(new Color(66,3,104), 3));
add(scrollPane);   

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

    public static void main(String[] args) {    
  new adminSearch();
   
    }

   }
    


