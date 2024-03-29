package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class ViewPackage extends JFrame implements ActionListener{
    
    JButton back;
    
    ViewPackage(String username) {
        setBounds(450,200,900,450);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text = new JLabel("VIEW PACKAGE DETAILS");
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
        text.setBounds(60,0,300,30);
        add(text);
        
        JLabel lblUsername = new JLabel("Username");
        lblUsername.setBounds(30,50,150,25);
        add(lblUsername);
        
        JLabel labelUsername = new JLabel();
        labelUsername.setBounds(220,50,150,25);
        add(labelUsername);
        
        JLabel lblPackage = new JLabel("Package");
        lblPackage.setBounds(30,90,150,25);
        add(lblPackage);
        
        JLabel labelPackage = new JLabel();
        labelPackage.setBounds(220,90,150,25);
        add(labelPackage);
        
        JLabel lblTotalPersons = new JLabel("Total Persons");
        lblTotalPersons.setBounds(30,130,150,25);
        add(lblTotalPersons);
        
        JLabel labelTotalPersons = new JLabel();
        labelTotalPersons.setBounds(220,130,150,25);
        add(labelTotalPersons);
        
        JLabel lblId = new JLabel("Id");
        lblId.setBounds(30,170,150,25);
        add(lblId);
        
        JLabel labelId = new JLabel();
        labelId.setBounds(220,170,150,25);
        add(labelId);
        
        JLabel lblNumber = new JLabel("Number");
        lblNumber.setBounds(30,210,150,25);
        add(lblNumber);
        
        JLabel labelNumber = new JLabel();
        labelNumber.setBounds(220,210,150,25);
        add(labelNumber);
        
        JLabel lblPhoneNumber = new JLabel("Phone Number");
        lblPhoneNumber.setBounds(30,250,150,25);
        add(lblPhoneNumber);
        
        JLabel labelPhoneNumber = new JLabel();
        labelPhoneNumber.setBounds(220,250,150,25);
        add(labelPhoneNumber);
        
        JLabel lblPrice = new JLabel("Price");
        lblPrice.setBounds(30,290,150,25);
        add(lblPrice);
        
        JLabel labelPrice = new JLabel();
        labelPrice.setBounds(220,290,150,25);
        add(labelPrice);
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(130,360,100,25);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookedDetails.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(450,20,500,400);
        add(image);
        
        try{
            Conn conn = new Conn();
            String query = "select * from bookpackage where username = '"+username+"'";
            ResultSet result = conn.s.executeQuery(query);
            
            while(result.next()) {
                labelUsername.setText(result.getString("username"));
                labelId.setText(result.getString("id"));
                labelPackage.setText(result.getString("package"));
                labelPhoneNumber.setText(result.getString("phonenumber"));
                labelTotalPersons.setText(result.getString("totalpersons"));
                labelPrice.setText(result.getString("totalprice"));
                labelNumber.setText(result.getString("number"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        setVisible(true);
    }
    
    public void actionPerformed (ActionEvent ae) {
        setVisible(false);
    }
    
    public static void main (String[] args) {
        new ViewPackage("bhudevi");
    }
}

