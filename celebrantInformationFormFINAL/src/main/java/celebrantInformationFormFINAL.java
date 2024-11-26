import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 63955
 */

public class celebrantInformationFormFINAL extends JFrame implements ActionListener {
    
  //DECLARE GUI COMPONENTS AS CLASS VARIABLES FOR GLOBAL CLASS
  JLabel lblName, lblAttendees, lblDate, lblHeader, lblEvent, lblDuration;
  JPanel pnlInfoForm;
  JTextField txtName, txtDate, txtDuration, txtEvent;
  JButton btnRequest;
  JComboBox cmbAttendeeReq, cmbDuration;
  String[] eventDuration;
  
  //CONSTRUCTOR TO INITIALIZE AND TO SET UP THE GUI
  celebrantInformationFormFINAL(){
    
    //SETTING UP THE FRAME (background, loacation of the frame and size)
    this.setSize(1000, 800);
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(null);
    this.getContentPane().setBackground(new Color(244, 187, 255));
    
    //CREATE THE HEADER LABEL
    lblHeader = new JLabel("CELEBRANT INFORMATION FORM");
    lblHeader.setFont(new Font("Serif",Font.BOLD,25));
    lblHeader.setForeground(Color.WHITE);
    lblHeader.setBounds(13, 25, 800, 40);
    add(lblHeader);
    
    //CREATING THE PANEL OR THE BACKGROUND
    pnlInfoForm = new JPanel();
    pnlInfoForm.setBounds(0, 0, 1000, 90);  
    pnlInfoForm.setBackground(new Color(190, 140, 229));
    add(pnlInfoForm);
    
    //LABEL OF THE NAME
    lblName = new JLabel("Name: ");
    lblName.setFont(new Font("Serif",Font.BOLD,25));
    lblName.setForeground(Color.BLACK);
    lblName.setBounds(220, 60 , 150, 160);
    add(lblName);
    
    //TEXTFIELD FOR THE CLEBRANT NAME 
    txtName = new JTextField(50);
    txtName.setBounds(400, 120, 520, 50);
    txtName.setBorder(null);
    txtName.setBackground(new Color(	209, 159, 232));
    txtName.setForeground(Color.BLACK);
    txtName.setFont(new Font("Serif",Font.BOLD,15));
    txtName.setText("");//THE NAME OF THE CELEBRANT WILL INPUT HERE
    add(txtName);
    
    //TEXTFIELD FOR THE ATTENDEES
    lblAttendees = new JLabel("Attendees: ");
    lblAttendees.setFont(new Font("Serif",Font.BOLD,25));
    lblAttendees.setForeground(Color.BLACK);
    lblAttendees.setBounds(180,160, 200, 160);
    add(lblAttendees);
    
    
    //THE USER CHOOSE THE NUMBER OF ATTENDEES
    String[] attendeesOptions = {"Select an option", "20persons", "35persons", "50persons"}; 
    cmbAttendeeReq = new JComboBox<>(attendeesOptions);  
    cmbAttendeeReq.setBorder(null);
    cmbAttendeeReq.setBounds(400, 220, 520, 50);  
    cmbAttendeeReq.setBackground(new Color(	209, 159, 232));
    cmbAttendeeReq.setFont(new Font("Serif",Font.BOLD,15));
    add(cmbAttendeeReq);
    
    //THE USER WILL INPUT THE MONTH, DATE AND YEAR OF THE EVENT
    lblDate = new JLabel ("Date (dd/mm/yyyy): ");
    lblDate.setFont(new Font("Serif",Font.BOLD,25));
    lblDate.setForeground(Color.BLACK);
    lblDate.setBounds(80, 280, 230, 160);
    add(lblDate);
  
    //SETTING UP THE TEXTFIELD FOR THE DATE
    txtDate = new JTextField(50);
    txtDate.setBorder(null);
    txtDate.setBounds(400, 330, 520, 50);
    txtDate.setBackground(new Color(	209, 159, 232));
    txtDate.setForeground(Color.BLACK);
    txtDate.setFont(new Font("Serif",Font.BOLD,15));
    txtDate.setText("");
    add(txtDate);
   
    //THE LABEL FOR TIME DURATION
    lblDuration = new JLabel("Time Duration ");
    lblDuration.setFont(new Font("Serif",Font.BOLD,18));
    lblDuration.setForeground(Color.BLACK);
    lblDuration.setBounds(185, 460 , 200, 100);
    add(lblDuration);
    
    //CHOICES FOR THE TIME DURATION OF THE CELEBRATION
    String [] eventDuration = {"Select Option", "2 hours", "3 hours and half hours" , "5 hours"}; 
    cmbDuration = new JComboBox<>(eventDuration);  
    cmbDuration.setBorder(null);
    cmbDuration.setBounds(140, 450, 230, 40);  
    cmbDuration.setBackground(new Color(	209, 159, 232));
    cmbDuration.setFont(new Font("Serif",Font.BOLD,20));
    add(cmbDuration);
    
    //USER INPUT A TIME OF EVENT 
    lblEvent = new JLabel("Time of Event:   ");
    lblEvent.setFont(new Font("Serif",Font.BOLD,18));
    lblEvent.setForeground(Color.BLACK);
    lblEvent.setBounds(620, 460 , 200, 100);
    add(lblEvent);
    
    txtEvent = new JTextField(50);
    txtEvent.setBorder(null);
    txtEvent.setBounds(580, 450, 230, 40);
    txtEvent.setBackground(new Color(	209, 159, 232));
    txtEvent.setForeground(Color.BLACK);
    txtEvent.setFont(new Font("Serif",Font.BOLD,15));
    txtEvent.setText("");
    add(txtEvent);
    
    //CONNECT DIRECTLY TO THE USER PAGE DISPLAY
    btnRequest = new JButton("REQUEST SCHEDULE");
    btnRequest.setBounds(360, 590, 220, 60); 
    btnRequest.setFont(new Font("Serif",Font.BOLD,15));
    btnRequest.setBackground(new Color(190, 140, 229));
    add(btnRequest);
    
    
    btnRequest.addActionListener(this);
    setVisible(true);
    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
        if (e.getSource() == btnRequest){
            //THIS ALLOWS THE USER TO INPUT THE DATA 
            String name = txtName.getText();
            String date = txtDate.getText();
            String eventTime = txtEvent.getText();
            String attendees = (String) cmbAttendeeReq.getSelectedItem();
            String timeDuration = (String) cmbDuration.getSelectedItem();
        
        try (PrintWriter writer = new PrintWriter(new FileWriter("userData.txt", true))) {
            // SAVE USER DATA TO FILE
            writer.println(name + " | " + date + " | " + attendees + " | " + timeDuration + " | " + eventTime);
            // CONFIRMATION 
            int choice = JOptionPane.showConfirmDialog(null,"Schedule requested successfully! Do you want to proceed to the next page?", "Confirmation",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
          
            if (choice == JOptionPane.YES_OPTION) {
                userPageDisplay(); // Proceed to again to the userPageDisplay(next page)
            }else if (choice == JOptionPane.NO_OPTION){
                JOptionPane.showMessageDialog(null, "Returning to the home page.");
                evsWelcomePageGUI();// Redirect to the evsWelcomePageGUI (Home Page)
            }else {
                System.exit(0);
                    }//EXIT THE FRAME
        } catch (IOException ex) {
            JOptionPane.showMessageDialog( null, "Failed to save the schedule. Please try again.", "Error", JOptionPane.ERROR_MESSAGE
            );
        
        }
        }
    }
    private void userPageDisplay() {
        this.dispose();//EXIT THE USERPAGEDISPLAY FRAME
    }
    private void evsWelcomePageGUI() {
        this.dispose();// EXIT THE EVSWELCOMEPAGEGUI
    }
   public static void main(String[] args) {
}
}
