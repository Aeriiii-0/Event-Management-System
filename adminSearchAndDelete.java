import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class adminSearchAndDelete extends JFrame implements ActionListener{
    JTextField tfTxt;
    JLabel lblTitle;
    JButton btndelEvent, btnlookEvent;
    JPanel pnlSearchBg;
    JList<String> list;
    JScrollPane scrollPane;
    JTable table;
    
    private PreparedStatement pst;
    private Connection con;
    private ResultSet rs;
    
        adminSearchAndDelete(){
       
        setSize(1000, 800);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(213, 182, 238));
        
        Connect();
        
        tfTxt = new JTextField();
        tfTxt.setBorder(null);
        tfTxt.setOpaque(true);
        tfTxt.setFocusable(true);
        tfTxt.setForeground(new Color(66, 3, 104));
        tfTxt.setBounds(115, 65, 770, 65);
        tfTxt.setFont(new Font("Arial",Font.BOLD,17));
        tfTxt.setBackground(new Color(190, 140, 229));
        tfTxt.setBorder(BorderFactory.createLineBorder(new Color(66, 3, 104), 3));
        
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
        btndelEvent.setOpaque(true);
        btndelEvent.setFocusable(true);
        btndelEvent.setBounds(200, 650, 146, 53);
        btndelEvent.setFont(new Font("Arial", Font.BOLD, 20));
        btndelEvent.setForeground(new Color(66, 3, 104));
        btndelEvent.setBackground(new Color(190, 140, 229));
        btndelEvent.setBorder(BorderFactory.createLineBorder(new Color(66, 3, 104), 3));
        add(btndelEvent);
        btndelEvent.addActionListener(this);
        
        btnlookEvent = new JButton("Search");
        btnlookEvent.setBounds(645, 650, 146, 53);
        btnlookEvent.setFocusable(true);
        btnlookEvent.setBackground(new Color(190, 140, 229));
        btnlookEvent.setFont(new Font("Arial", Font.BOLD, 20));
        btnlookEvent.setForeground(new Color(66, 3, 104));
        btnlookEvent.setBackground(new Color(190, 140, 229));
        btnlookEvent.setOpaque(true);
        btnlookEvent.setFocusable(true);
        btnlookEvent.setBorder(BorderFactory.createLineBorder(new Color(66, 3, 104), 3));
        add(btnlookEvent);
        btnlookEvent.addActionListener(this);
        
         String[] columnNames = {"eventName", "name", "date", "time", "duration", "status"} ;
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
        
        setVisible(true);
  
    }
        public void Connect() {
        String url = "jdbc:mysql://localhost:3306/eventmanagement";
        String username = "root";
        String password = "1234";

        try {
            con = DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            Logger.getLogger(adminSearchAndDelete.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        
    public void actionPerformed(ActionEvent e) {
    if (e.getSource() == btndelEvent) {
         int selectedRow = table.getSelectedRow(); 

    if (selectedRow == -1) { 
        JOptionPane.showMessageDialog(this, "Please select a row to delete.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    DefaultTableModel model = (DefaultTableModel) table.getModel();
    String eventID = model.getValueAt(selectedRow, 2).toString(); // Assuming column index 2 holds the eventID

    int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this entry?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);
    if (confirm != JOptionPane.YES_OPTION) {
        return;
    }

    try {

        pst = con.prepareStatement("DELETE FROM information WHERE inputName = ?");
        pst.setString(1, eventID);
        int rowsAffected = pst.executeUpdate();

        if (rowsAffected > 0) {

            model.removeRow(selectedRow);
            JOptionPane.showMessageDialog(this, "Record deleted successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Record not found in the database.", "Error", JOptionPane.ERROR_MESSAGE);
        }
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error deleting record: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            } 

            if (e.getSource() == btnlookEvent) {
                String search = tfTxt.getText();
        if (search.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please type something first!", "Alert", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                pst = con.prepareStatement("SELECT * FROM information WHERE inputDate = ?");
                pst.setString(1, search);
                rs = pst.executeQuery();

                DefaultTableModel df = (DefaultTableModel) table.getModel();
                df.setRowCount(0);

                if (rs.isBeforeFirst()) { 
                    while (rs.next()) { 
                        Vector<Object> v2 = new Vector<>();
                        v2.add(rs.getString("inputEventId"));
                        v2.add(rs.getString("inputName"));
                        v2.add(rs.getString("inputDate")); 
                        v2.add(rs.getString("inputTimeOfEvent"));
                        v2.add(rs.getString("inputTimeDuration"));
                        df.addRow(v2);
                }
            } else {
                JOptionPane.showMessageDialog(this, "No records found", "Info", JOptionPane.INFORMATION_MESSAGE);
            }

                tfTxt.setText("");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            if (search.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please type something first!", "Alert", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                pst = con.prepareStatement("SELECT * FROM information WHERE inputName = ?");
                pst.setString(1, search);
                rs = pst.executeQuery();

                DefaultTableModel df = (DefaultTableModel) table.getModel();
                df.setRowCount(0);

                if (rs.isBeforeFirst()) { 
                    while (rs.next()) { 
                        Vector<Object> v2 = new Vector<>();
                        v2.add(rs.getString("inputEventId"));
                        v2.add(rs.getString("inputName"));
                        v2.add(rs.getString("inputDate")); 
                        v2.add(rs.getString("inputTimeOfEvent"));
                        v2.add(rs.getString("inputTimeDuration"));
                        df.addRow(v2);
                }
            } 

                tfTxt.setText("");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    }
}
}