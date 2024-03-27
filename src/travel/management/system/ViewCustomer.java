package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class ViewCustomer extends JFrame implements ActionListener{
    
    JButton back;
    
    ViewCustomer(String username) {
        setBounds(400,180,850,530);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel lblUsername = new JLabel("Username");
        lblUsername.setBounds(30,50,150,25);
        add(lblUsername);
        
        JLabel labelUsername = new JLabel();
        labelUsername.setBounds(220,50,150,25);
        add(labelUsername);
        
        JLabel lblId = new JLabel("Id");
        lblId.setBounds(30,110,150,25);
        add(lblId);
        
        JLabel labelId = new JLabel();
        labelId.setBounds(220,110,150,25);
        add(labelId);
        
        JLabel lblNumber = new JLabel("Number");
        lblNumber.setBounds(30,170,150,25);
        add(lblNumber);
        
        JLabel labelNumber = new JLabel();
        labelNumber.setBounds(220,170,150,25);
        add(labelNumber);
        
        JLabel lblName = new JLabel("Name");
        lblName.setBounds(30,230,150,25);
        add(lblName);
        
        JLabel labelName = new JLabel();
        labelName.setBounds(220,230,150,25);
        add(labelName);
        
        JLabel lblGender = new JLabel("Gender");
        lblGender.setBounds(30,290,150,25);
        add(lblGender);
        
        JLabel labelGender = new JLabel();
        labelGender.setBounds(220,290,150,25);
        add(labelGender);
        
        JLabel lblCountry = new JLabel("Country");
        lblCountry.setBounds(500,50,150,25);
        add(lblCountry);
        
        JLabel labelCountry = new JLabel();
        labelCountry.setBounds(690,50,150,25);
        add(labelCountry);
        
        JLabel lblAddress = new JLabel("Address");
        lblAddress.setBounds(500,110,150,25);
        add(lblAddress);
        
        JLabel labelAddress = new JLabel();
        labelAddress.setBounds(690,110,150,25);
        add(labelAddress);
        
        JLabel lblPhoneNumber = new JLabel("Phone Number");
        lblPhoneNumber.setBounds(500,170,150,25);
        add(lblPhoneNumber);
        
        JLabel labelPhoneNumber = new JLabel();
        labelPhoneNumber.setBounds(690,170,150,25);
        add(labelPhoneNumber);
        
        JLabel lblEmail = new JLabel("Email");
        lblEmail.setBounds(500,230,150,25);
        add(lblEmail);
        
        JLabel labelEmail = new JLabel();
        labelEmail.setBounds(690,230,150,25);
        add(labelEmail);
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(350,350,100,25);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(20,400,600,150);
        add(image);
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
        Image i5 = i4.getImage().getScaledInstance(600, 200, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image2 = new JLabel(i6);
        image2.setBounds(600,400,600,150);
        add(image2);
        
        try{
            Conn conn = new Conn();
            String query = "select * from customer where username = '"+username+"'";
            ResultSet result = conn.s.executeQuery(query);
            
            while(result.next()) {
                labelUsername.setText(result.getString("username"));
                labelId.setText(result.getString("id"));
                labelName.setText(result.getString("name"));
                labelCountry.setText(result.getString("country"));
                labelNumber.setText(result.getString("number"));
                labelPhoneNumber.setText(result.getString("phoneNumber"));
                labelGender.setText(result.getString("gender"));
                labelEmail.setText(result.getString("email"));
                labelAddress.setText(result.getString("address"));
                
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
        new ViewCustomer("bhudevi");
    }
}
