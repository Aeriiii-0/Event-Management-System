

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;



public class adminSearchAndDelete extends JFrame implements ActionListener{
    JTextField tfTxt;
    JLabel lblTitle;
    JButton btndelEvent, btnlookEvent;
    JPanel pnlSearchBg;
    DefaultListModel<String> listModel;
    JList<String> list;
    JScrollPane scrollPane;
 
        adminSearchAndDelete(){
        
        listModel = new DefaultListModel<>();

        
        setSize(1000, 800);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(213, 182, 238));
        
        list = new JList<>(listModel);
        scrollPane = new JScrollPane(list);
        
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
        btndelEvent.setBorder(BorderFactory.createEmptyBorder());
        add(btndelEvent);
        btndelEvent.addActionListener(this);

        add(btndelEvent);

        
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
        

         
        scrollPane = new JScrollPane(list);
        scrollPane.setBounds(100, 200, 800, 400);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.setBackground(new Color(190, 140, 229));
        scrollPane.setForeground(new Color(66, 3, 104));
        scrollPane.getViewport().setBackground(Color.BLUE);
        add(scrollPane);
        
        setVisible(true);
    
    }
    public void actionPerformed(ActionEvent e) {
         if(e.getSource() == btndelEvent){
            int indexSelected = list.getSelectedIndex();
            if(indexSelected!=-1){
                listModel.removeElementAt(indexSelected);
            }else{
                JOptionPane.showMessageDialog(this, "Select Item to remove First", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
    

   }
    }}

