/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.eventmanagementsystemmain;

import java.awt.Color;
import javax.swing.*;
import static javax.swing.WindowConstants.*;

/**
 *
 * @author Nix
 */
public class TryFrame  extends evsWelcomePageGUI{
    TryFrame(){
        JFrame TryFrame=new JFrame();
        TryFrame.setSize(1000,800);
        TryFrame.setTitle("Hampaslupa");
        TryFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        TryFrame.setResizable(false);
        TryFrame.getContentPane().setBackground(new Color(213, 182, 238)); 
        TryFrame.setLocationRelativeTo(null); 
        TryFrame.setLayout(null);
        TryFrame.setVisible(true);
    }
}
