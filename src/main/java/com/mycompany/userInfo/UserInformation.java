package com.mycompany.userInfo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserInformation extends JFrame implements ActionListener {
    private JTextField tfName, tfId, tfEmail, tfEid;
    private JTextArea taFeedback;
    private JButton btnSubmitForm, btnSubmitFeedback;
    private String submittedName, submittedId, submittedEmail, submittedEventId, submittedFeedback;

    public UserInformation() {
        setTitle("User Information");
        setSize(1000, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(new Color(213, 182, 238));

        JLabel lblName = new JLabel("Name:");
        lblName.setBounds(100, 200, 100, 30);
        lblName.setFont(new Font("Arial", Font.PLAIN, 18));
        add(lblName);

        tfName = new JTextField();
        tfName.setBounds(400, 200, 480, 35);
        tfName.setBackground(new Color(190, 140, 229));
        tfName.setBorder(null);
        add(tfName);

        JLabel lblId = new JLabel("ID:");
        lblId.setBounds(100, 250, 100, 30);
        lblId.setFont(new Font("Arial", Font.PLAIN, 18));
        add(lblId);

        tfId = new JTextField();
        tfId.setBounds(400, 250, 480, 35);
        tfId.setBackground(new Color(190, 140, 229));
        tfId.setBorder(null);
        add(tfId);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setBounds(100, 300, 100, 30);
        lblEmail.setFont(new Font("Arial", Font.PLAIN, 18));
        add(lblEmail);

        tfEmail = new JTextField();
        tfEmail.setBounds(400, 300, 480, 35);
        tfEmail.setBackground(new Color(190, 140, 229));
        tfEmail.setBorder(null);
        add(tfEmail);

        JLabel lblEid = new JLabel("Event ID:");
        lblEid.setBounds(100, 350, 100, 30);
        lblEid.setFont(new Font("Arial", Font.PLAIN, 18));
        add(lblEid);

        tfEid = new JTextField();
        tfEid.setBounds(400, 350, 480, 35);
        tfEid.setBackground(new Color(190, 140, 229));
        tfEid.setBorder(null);
        add(tfEid);

        JLabel lblFeedback = new JLabel("Feedback:");
        lblFeedback.setBounds(100, 420, 160, 30);
        lblFeedback.setFont(new Font("Arial", Font.PLAIN, 18));
        add(lblFeedback);

        taFeedback = new JTextArea();
        taFeedback.setBounds(400, 420, 480, 200);
        taFeedback.setBackground(new Color(190, 140, 229));
        taFeedback.setBorder(null);
        add(taFeedback);

        btnSubmitForm = new JButton("Submit Form");
        btnSubmitForm.setBounds(400, 650, 200, 40);
        btnSubmitForm.setBackground(new Color(144, 5, 229));
        btnSubmitForm.setBorder(null);
        btnSubmitForm.setForeground(Color.WHITE);
        btnSubmitForm.addActionListener(this);
        add(btnSubmitForm);

        btnSubmitFeedback = new JButton("Submit Feedback");
        btnSubmitFeedback.setBounds(680, 650, 200, 40);
        btnSubmitFeedback.setBackground(new Color(144, 5, 229));
        btnSubmitFeedback.setBorder(null);
        btnSubmitFeedback.setForeground(Color.WHITE);
        btnSubmitFeedback.addActionListener(this);
        add(btnSubmitFeedback);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSubmitForm) {
            submittedName = tfName.getText();
            submittedId = tfId.getText();
            submittedEmail = tfEmail.getText();
            submittedEventId = tfEid.getText();
            JOptionPane.showMessageDialog(this, "Form Submitted!");
        } else if (e.getSource() == btnSubmitFeedback) {
            submittedFeedback = taFeedback.getText();
            JOptionPane.showMessageDialog(this, "Feedback Submitted!");
        }

        if (e.getSource() instanceof JButton) {
            PostEventReviewer reviewer = new PostEventReviewer(submittedName, submittedId, submittedEmail, submittedEventId, submittedFeedback, this);
            reviewer.setVisible(true);
            this.dispose();
        }
    }
}
