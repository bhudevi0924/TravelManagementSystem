package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class ViewBookedHotel extends JFrame implements ActionListener{
    
    JButton back;
    
    ViewBookedHotel(String username) {
        setBounds(350,180,1000,550);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text = new JLabel("VIEW BOOKED HOTEL DETAILS");
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
        text.setBounds(60,0,400,30);
        add(text);
        
        JLabel lblUsername = new JLabel("Username");
        lblUsername.setBounds(30,50,150,25);
        add(lblUsername);
        
        JLabel labelUsername = new JLabel();
        labelUsername.setBounds(220,50,150,25);
        add(labelUsername);
        
        JLabel lblHotel = new JLabel("Hotel Name");
        lblHotel.setBounds(30,90,150,25);
        add(lblHotel);
        
        JLabel labelHotel = new JLabel();
        labelHotel.setBounds(220,90,150,25);
        add(labelHotel);
        
        JLabel lblTotalPersons = new JLabel("Total Persons");
        lblTotalPersons.setBounds(30,130,150,25);
        add(lblTotalPersons);
        
        JLabel labelTotalPersons = new JLabel();
        labelTotalPersons.setBounds(220,130,150,25);
        add(labelTotalPersons);
        
        JLabel lblTotalDays = new JLabel("Total Days");
        lblTotalDays.setBounds(30,170,150,25);
        add(lblTotalDays);
        
        JLabel labelTotalDays = new JLabel();
        labelTotalDays.setBounds(220,170,150,25);
        add(labelTotalDays);
        
        JLabel lblAC = new JLabel("AC/NON-AC");
        lblAC.setBounds(30,210,150,25);
        add(lblAC);
        
        JLabel labelAC = new JLabel();
        labelAC.setBounds(220,210,150,25);
        add(labelAC);
        
        JLabel lblFood = new JLabel("Food Included?");
        lblFood.setBounds(30,250,150,25);
        add(lblFood);
        
        JLabel labelFood = new JLabel();
        labelFood.setBounds(220,250,150,25);
        add(labelFood);
        
        JLabel lblId = new JLabel("Id");
        lblId.setBounds(30,290,150,25);
        add(lblId);
        
        JLabel labelId = new JLabel();
        labelId.setBounds(220,290,150,25);
        add(labelId);
        
        JLabel lblNumber = new JLabel("Number");
        lblNumber.setBounds(30,330,150,25);
        add(lblNumber);
        
        JLabel labelNumber = new JLabel();
        labelNumber.setBounds(220,330,150,25);
        add(labelNumber);
        
        JLabel lblPhoneNumber = new JLabel("Phone Number");
        lblPhoneNumber.setBounds(30,370,150,25);
        add(lblPhoneNumber);
        
        JLabel labelPhoneNumber = new JLabel();
        labelPhoneNumber.setBounds(220,370,150,25);
        add(labelPhoneNumber);
        
        JLabel lblPrice = new JLabel("Price");
        lblPrice.setBounds(30,410,150,25);
        add(lblPrice);
        
        JLabel labelPrice = new JLabel();
        labelPrice.setBounds(220,410,150,25);
        add(labelPrice);
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(130,460,100,25);
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
            String query = "select * from bookhotel where username = '"+username+"'";
            ResultSet result = conn.s.executeQuery(query);
            
            while(result.next()) {
                labelUsername.setText(result.getString("username"));
                labelId.setText(result.getString("id"));
                labelHotel.setText(result.getString("name"));
                labelPhoneNumber.setText(result.getString("phone"));
                labelTotalPersons.setText(result.getString("persons"));
                labelPrice.setText(result.getString("price"));
                labelNumber.setText(result.getString("number"));
                labelTotalDays.setText(result.getString("days"));
                labelAC.setText(result.getString("ac"));
                labelFood.setText(result.getString("food"));
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
        new ViewBookedHotel("bhudevi");
    }
}


