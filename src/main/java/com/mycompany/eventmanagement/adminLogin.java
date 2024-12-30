package com.mycompany.eventmanagement;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;

public class adminLogin extends JFrame {

    private JLabel lblTitle, lblUsername, lblPassword;
    private JTextField tfUsername;
    private JPasswordField pfPassword;
    private JButton btnLogin;

    adminLogin() {
        // Set JFrame properties
        setTitle("Admin Log-in");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);
        setSize(1024, 576);
        setLocationRelativeTo(null);  // Center the window
        setVisible(true);

        // Panel for the top bar (light purple background)
        JPanel topPanel = new JPanel();
        topPanel.setBackground(new Color(209, 166, 232)); // mid purple color
        topPanel.setBounds(0, 0, 1024, 65);
        topPanel.setLayout(null);
        add(topPanel);

        // Title label "Admin Log-in"
        lblTitle = new JLabel("Admin Log-in", SwingConstants.CENTER);
        lblTitle.setForeground(Color.WHITE);
        lblTitle.setFont(new Font("Serif", Font.BOLD, 25));
        lblTitle.setBounds(-50, 5, 400, 50);  // Centered title
        topPanel.add(lblTitle);

        // Username label
        lblUsername = new JLabel("Username:");
        lblUsername.setForeground(Color.WHITE);
        lblUsername.setFont(new Font("Serif", Font.PLAIN, 30));  // Larger font
        lblUsername.setBounds(100, 130, 200, 40);  // Adjust position
        add(lblUsername);

        // Username text field
        tfUsername = new JTextField();
        tfUsername.setBackground(new Color(199, 138, 217));
        tfUsername.setBounds(330, 130, 550, 40);  // Consistent height with labels
        tfUsername.setFont(new Font("Serif", Font.PLAIN, 20)); 
        add(tfUsername);

        // Password label
        lblPassword = new JLabel("Password:");
        lblPassword.setForeground(Color.WHITE);
        lblPassword.setFont(new Font("Serif", Font.PLAIN, 30));  // Larger font
        lblPassword.setBounds(100, 220, 200, 40);
        add(lblPassword);

        // Password field 
        pfPassword = new JPasswordField();
        pfPassword.setBackground(new Color(199, 138, 217));
        pfPassword.setBounds(330, 220, 550, 40);
        pfPassword.setFont(new Font("Serif", Font.PLAIN, 20));
        add(pfPassword);

        // Log-in button with rounded corners
        btnLogin = new JButton("Log-in") {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(getBackground());
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 40, 40);  // Rounded rectangle with 40px radius
                g2.dispose();
                
                // Now call the super method to draw the button text and other components
                super.paintComponent(g);
            }
        };
        btnLogin.setFont(new Font("Serif", Font.BOLD, 30));  // Larger button text
        btnLogin.setBackground(new Color(179, 32, 255));  // Dark purple
        btnLogin.setForeground(Color.WHITE);    
        btnLogin.setBounds(400, 400, 200, 60);  // Center button
        btnLogin.setBorder(new RoundedBorder(30));  // Rounded border with a radius of 30px
        btnLogin.setFocusPainted(false);  // Remove focus outline
        btnLogin.setContentAreaFilled(false);  // Important to make sure rounded button is visible
        btnLogin.setBorderPainted(false);
        btnLogin.setFocusPainted(false);
        add(btnLogin);

        // Add ActionListener to the button to handle login functionality
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the username and password from the input fields
                String username = tfUsername.getText();
                String password = new String(pfPassword.getPassword());

                // Check if the username and password match
                if (username.equals("AdminEVS") && password.equals("evs123")) {
                    // Login success
                    showCustomMessageDialog("Login Successful!", "Success", new Color(150, 255, 150));  // Greenish background for success
                } else {
                    // Login failed
                    showCustomMessageDialog("Login Failed! Please try again.", "Error", new Color(255, 100, 100));  // Reddish background for error
                }
            }
        });

        // Background panel (light purple background)
        JPanel backgroundPanel = new JPanel();
        backgroundPanel.setBackground(new Color(229, 185, 231));  // Light purple
        backgroundPanel.setBounds(0, 0, 1024, 576);
        add(backgroundPanel);

        // Bring components to the front
        lblUsername.setOpaque(false);
        lblPassword.setOpaque(false);
        tfUsername.setOpaque(true);
        pfPassword.setOpaque(true);
        btnLogin.setOpaque(false);  // Make the button transparent so custom painting works

        setVisible(true);
    }

    // Custom method to display JOptionPane with customized color
    private void showCustomMessageDialog(String message, String title, Color backgroundColor) {
        UIManager.put("OptionPane.background", backgroundColor);
        UIManager.put("Panel.background", backgroundColor);
        UIManager.put("Button.background", new Color(179, 32, 255));  // Match button color with the rest of the UI
        UIManager.put("Button.foreground", Color.WHITE);  // Button text color
        
        JOptionPane.showMessageDialog(this, message, title, JOptionPane.INFORMATION_MESSAGE);
    }

    // Class to define rounded border
    private static class RoundedBorder implements Border {
        private int radius;

        RoundedBorder(int radius) {
            this.radius = radius;
        }

        public Insets getBorderInsets(Component c) {
            return new Insets(this.radius + 1, this.radius + 1, this.radius + 1, this.radius + 1);
        }

        public boolean isBorderOpaque() {
            return true;
        }

        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            g.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
        }
    }

}

//call to kenneth
