package com.mycompany.adminframegeneral;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author USER
 */
import java.sql.*;
import javax.swing.JOptionPane;
public class connector {
    
    public static Connection getCon(){
        
        String url = "jdbc:mysql://localhost:3306/adminaddevent?useSSL=false";
        String username = "root"; // Your MySQL username
        String password = "evs123"; // Your MySQL password
        Connection con = null;
        try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           con = DriverManager.getConnection("jdbc:mysql://localhost:3306/adminaddevent?useSSL=false", "root", "evs123");
           return DriverManager.getConnection(url, username, password);
        
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL Driver not found!");
            e.printStackTrace();
        }catch(Exception e){
            System.out.println(e);
        }
        return con;
        
    }public static void main(String[] args) {
    Connection con = connector.getCon();
    if (con != null) {
        System.out.println("Connected to the database!");
    } else {
        System.out.println("Connection failed!");
    }
}
        
    
}
