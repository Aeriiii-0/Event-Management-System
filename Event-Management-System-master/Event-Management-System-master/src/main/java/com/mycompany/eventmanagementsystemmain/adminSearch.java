
package com.mycompany.eventmanagementsystemmain;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

  public class adminSearch extends JFrame implements ActionListener {
    JTextField tfSearch;
    JLabel lblTitle;
    JButton btnSearchEvent, btnBack;
    JPanel pnlSearchBg;
    JTable table;
    String[] columnNames = {"Event Name", "Name", "Date", "Time", "Duration", "Status"};
    JScrollPane scrollPane;

    // database components
    private Connection connection;
    private PreparedStatement pst;
    private ResultSet rs;

 adminSearch() {
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
    btnBack.setFont(new Font("Arial",Font.BOLD,13));
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

    //table initialization
    table = new JTable(model);
    scrollPane = new JScrollPane(table);
    scrollPane.setBounds(100, 200, 800, 400); 
    scrollPane.setBorder(BorderFactory.createLineBorder(new Color(66,3,104), 3));
    add(scrollPane);   


    //database connection initialization
    connectToDatabase();
    setVisible(true);
 }

    private void connectToDatabase() {
        try {
            String url = "jdbc:mysql://localhost:3306/eventmanagement";
            String username = "root";
            String password = "1234";
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Database connection error: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
    if (e.getSource() == btnSearchEvent) {
        String searchTerm = tfSearch.getText().trim();

        if (searchTerm.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a search term!", "Alert", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            String sql = "SELECT * FROM event WHERE EventName LIKE ? OR Name LIKE ? OR Date LIKE ?";
            pst = connection.prepareStatement(sql);
            String searchPattern = "%" + searchTerm + "%";
            pst.setString(1, searchPattern);
            pst.setString(2, searchPattern);
            pst.setString(3, searchPattern);

            rs = pst.executeQuery();

            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0); // Clear existing rows

            boolean found = false;
            while (rs.next()) {
                found = true;
                Object[] row = {
                rs.getString("EventName"),
                rs.getString("Name"),
                rs.getString("Date"),
                rs.getString("Time"),
                rs.getString("Duration"),
                rs.getString("Status")
                };
                model.addRow(row);
            }

            if (!found) {
                JOptionPane.showMessageDialog(this, "No matching records found", "Info", JOptionPane.INFORMATION_MESSAGE);
            } tfSearch.setText("");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Search error: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }

    } else if (e.getSource() == btnBack) {
        new adminDashboard();
        dispose();
    }
    }
  
    }