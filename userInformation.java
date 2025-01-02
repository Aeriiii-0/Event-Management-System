
    import java.awt.*;
    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;
    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.PreparedStatement;
    import java.sql.SQLException;
    import java.util.LinkedList;
    import java.util.logging.Level;
    import java.util.logging.Logger;
    import javax.swing.*;


    public class userInformation extends JFrame implements ActionListener{

       JLabel lblName, lbliD, lblEmail, lblEid, lblFeedback, lblHeader;
       JButton btnSFeedback, btnSubmitform;
       JTextField tfName, tfId, tfEmail, tfeventId;
       JTextArea taFeedback;
       JPanel jpUp, pnlDown, pnlCenter;
       LinkedList<String> linkedlist;

        userInformation(){
                        
            setSize(1000,800);
            setLayout(null);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            getContentPane().setBackground(new Color(213, 182, 238));
            con();
            


            lblHeader = new JLabel("ATTENDEE INFORMATION FORM");
            lblHeader.setFont(new Font("Serif",Font.BOLD,25));
            lblHeader.setForeground(Color.BLACK);
            lblHeader.setBounds(435, 40, 800, 40);
            add(lblHeader);
            
            lblName = new JLabel("Name:");
            lblName.setBounds(150, 200, 100, 30);
            lblName.setForeground(Color.BLACK);
            lblName.setFont(new Font("Arial", Font.BOLD, 23));
            add(lblName);

            lbliD = new JLabel("Email:");
            lbliD.setBounds(150, 270, 120, 30);
            lbliD.setForeground(Color.BLACK);
            lbliD.setFont(new Font("Arial", Font.BOLD, 23));
            add(lbliD);

            lblEmail = new JLabel("Event ID:");
            lblEmail.setBounds(150, 340, 120, 30);
            lblEmail.setForeground(Color.BLACK);
            lblEmail.setFont(new Font("Arial", Font.BOLD, 23));
            add(lblEmail);

            lblFeedback = new JLabel("Feedback:");
            lblFeedback.setBounds(150, 430, 160, 30);
            lblFeedback.setForeground(Color.BLACK);
            lblFeedback.setFont(new Font("Arial", Font.BOLD, 23));
            add(lblFeedback);

            
            btnSubmitform = new JButton("SUBMIT FORM");
            btnSubmitform.setBorder(null);
            btnSubmitform.setOpaque(true);
            btnSubmitform.setFocusable(true);
            btnSubmitform.setBounds(535, 660, 200, 40);
            btnSubmitform.setFont(new Font("Arial", Font.BOLD, 17));
            btnSubmitform.setBackground(new Color(144, 5, 229));
            btnSubmitform.setBorder(BorderFactory.createLineBorder(new Color(66, 3, 104), 3));
            add(btnSubmitform);
            btnSubmitform.addActionListener(this);


            tfName = new JTextField();    
            tfName.setBounds(400, 200, 480, 35);
            tfName.setBackground(new Color(190, 140, 229));
            tfName.setForeground(new Color(66, 3, 104));
            tfName.setFont(new Font("Serif",Font.BOLD,17));
            tfName.setBorder(BorderFactory.createLineBorder(new Color(66, 3, 104), 3));
            add(tfName);

            tfeventId = new JTextField();        
            tfeventId.setBounds(400, 270, 480, 35);
            tfeventId.setBackground(new Color(190,140,229));
            tfeventId.setBackground(new Color(190, 140, 229));
            tfeventId.setForeground(new Color(66, 3, 104));
            tfeventId.setFont(new Font("Serif",Font.BOLD,17));
            tfeventId.setBorder(BorderFactory.createLineBorder(new Color(66, 3, 104), 3));            
            add(tfeventId);


            tfEmail = new JTextField();    
            tfEmail.setBorder(null);
            tfEmail.setOpaque(true);
            tfEmail.setFocusable(true);
            tfEmail.setForeground(Color.BLACK);
            tfEmail.setBounds(400, 340, 480, 35);
            tfEmail.setBackground(new Color(190,140,229));
            tfEmail.setFont(new Font("Serif",Font.BOLD,17));
            tfEmail.setBorder(BorderFactory.createLineBorder(new Color(66, 3, 104), 3));
            add(tfEmail);


            taFeedback = new JTextArea();
            taFeedback.setForeground(Color.BLACK);
            taFeedback.setBounds(400, 430, 480, 200);
            taFeedback.setBackground(new Color(190,140,229));
            taFeedback.setBorder(BorderFactory.createLineBorder(new Color(66, 3, 104), 3));
            taFeedback.setFont(new Font("Serif",Font.BOLD,17));
            add(taFeedback);


            jpUp = new JPanel();
            jpUp.setForeground(Color.WHITE);
            jpUp.setBorder(BorderFactory.createLineBorder(new Color(66, 3, 104), 3));
            jpUp.setBackground(new Color(190,140,229));
            jpUp.setBounds(0, 0, 1000, 120);
            add(jpUp);

            pnlDown = new JPanel();
            pnlDown.setBounds(0, 0, 300, 800);
            pnlDown.setForeground(Color.WHITE);
            pnlDown.setBackground(new Color(190,140,229));
            pnlDown.setBorder(BorderFactory.createLineBorder(new Color(66, 3, 104), 3));
            add(pnlDown);

                    pnlCenter = new JPanel();
                    pnlCenter.setLayout(null);
                    pnlCenter.setBounds(0, 109, 1000, 598);
                    pnlCenter.setBackground(new Color(213, 182, 238));
                    add(pnlCenter);

        }
        PreparedStatement pst;
        Connection con;

     public void con(){
         String url = "jdbc:mysql://localhost:3306/projectdsa";
            String username = "root";
            String password = "admin123";


        try {
          con=(Connection) DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            Logger.getLogger(userInformation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
        @Override
        public void actionPerformed(ActionEvent e) {
           if (e.getSource() == btnSubmitform) {
            // Check if any of the fields are empty
            String name = tfName.getText();
            String  eventID = tfeventId.getText();
            String email = tfEmail.getText();
            String feedback = taFeedback.getText();
            if(name.isEmpty()||eventID.isEmpty()||email.isEmpty()||feedback.isEmpty()){
                JOptionPane.showMessageDialog(this, "Please fill up all the needed information first!");
            } else {
                
            
            try{
                
              pst = con.prepareStatement("insert into information (name,eventID,email,feedback) values (?,?,?,?)");  
              pst.setString(1, name);
              pst.setString(2, email);
              pst.setString(3, eventID);
              pst.setString(4, feedback);
              
              
              int k = pst.executeUpdate();
              if(k==1){
                  
              }
              JOptionPane.showMessageDialog(this, "Form submitted successfully");
              tfName.setText("");
              tfEmail.setText("");
              tfeventId.setText("");
              taFeedback.setText("");
              
            } catch (Exception f){
                f.printStackTrace();
            }
            }

                
                  } 
                 
                    else {
                   JOptionPane.showMessageDialog(this, "please input all the information needed first!");
                        

                        }
          
            }      
     
                    }

        
        
    