package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BookPackage extends JFrame implements ActionListener{
    
    Choice cPackage;
    JTextField totalPersonsTextField;
    String username;
    JLabel labelUsername, labelId, labelNumber, labelPhoneNumber, labelTotalPrice;
    JButton checkPrice, bookPackage, back;
    
    BookPackage(String username) {
        this.username = username; 
        setBounds(350, 200, 1000, 500);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel text = new JLabel("BOOK PACKAGE ");
        text.setBounds(100,10,200,30);
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(text);
        
        JLabel lblUsername = new JLabel("Username");
        lblUsername.setBounds(40,70,100,20);
        lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblUsername);
        
        labelUsername = new JLabel();
        labelUsername.setBounds(250,70,200,20);
        labelUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(labelUsername);
        
        JLabel lblSelectPackage = new JLabel("Select Package");
        lblSelectPackage.setBounds(40,110,150,20);
        lblSelectPackage.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblSelectPackage);
        
        cPackage = new Choice();
        cPackage.add("Gold Package");
        cPackage.add("Silver Package");
        cPackage.add("Bronze Package");
        cPackage.setBounds(250, 110, 200, 20);
        add(cPackage);
        
        JLabel lblTotalPersons = new JLabel("Total Persons");
        lblTotalPersons.setBounds(40,150,150,25);
        lblTotalPersons.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblTotalPersons);
        
        totalPersonsTextField = new JTextField("1");
        totalPersonsTextField.setBounds(250,150,200,25);
        totalPersonsTextField.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(totalPersonsTextField);
        
        JLabel lblId = new JLabel("Id");
        lblId.setBounds(40,190,150,20);
        lblId.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblId);
        
        labelId = new JLabel();
        labelId.setBounds(250,190,200,25);
        labelId.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(labelId);
        
        JLabel lblNumber = new JLabel("Number");
        lblNumber.setBounds(40,230,150,25);
        lblNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblNumber);
        
        labelNumber = new JLabel();
        labelNumber.setBounds(250,230,150,25);
        labelNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(labelNumber);
        
        JLabel lblPhoneNumber = new JLabel("Phone Number");
        lblPhoneNumber.setBounds(40,270,150,20);
        lblPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblPhoneNumber);
        
        labelPhoneNumber = new JLabel();
        labelPhoneNumber.setBounds(250,270,200,25);
        labelPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(labelPhoneNumber);
        
        JLabel lblTotalPrice = new JLabel("Total Price");
        lblTotalPrice.setBounds(40,310,150,25);
        lblTotalPrice.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblTotalPrice);
        
        labelTotalPrice = new JLabel();
        labelTotalPrice.setBounds(250,310,150,25);
        labelTotalPrice.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(labelTotalPrice);
        
        checkPrice = new JButton("Check Price");
        checkPrice.setBackground(Color.BLACK);
        checkPrice.setForeground(Color.WHITE);
        checkPrice.setBounds(60, 380, 120, 25);
        checkPrice.addActionListener(this);
        add(checkPrice);
        
        bookPackage = new JButton("Book Package");
        bookPackage.setBackground(Color.BLACK);
        bookPackage.setForeground(Color.WHITE);
        bookPackage.setBounds(200, 380, 120, 25);
        bookPackage.addActionListener(this);
        add(bookPackage);
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(340, 380, 120, 25);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookpackage.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500,50,460,300);
        add(image);
        
        try{
            Conn conn = new Conn();
            String query = "select * from customer where username = '"+username+"'";
            ResultSet result = conn.s.executeQuery(query);
            
            while(result.next()) {
                labelUsername.setText(result.getString("username"));
                labelId.setText(result.getString("id"));
                labelNumber.setText(result.getString("number"));
                labelPhoneNumber.setText(result.getString("phoneNumber"));
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        setVisible(true);
    }
    
    public void actionPerformed (ActionEvent ae) {
        if(ae.getSource() == checkPrice){
            String pack = cPackage.getSelectedItem();
            int cost =0;
            
            if(pack.equals("Gold Package")) {
                cost += 12000;
            } else if(pack.equals("Silver Package")) {
                cost +=25000;
            } else{
                cost += 32000;
            }
            
            int persons = Integer.parseInt(totalPersonsTextField.getText());
            cost *= persons;
            labelTotalPrice.setText("Rs " + cost);
        }else if(ae.getSource() == bookPackage) {
            try{
                Conn conn = new Conn();
                conn.s.executeUpdate("insert into bookpackage values('"+labelUsername.getText()+"',"
                        + " '"+cPackage.getSelectedItem()+"', '"+totalPersonsTextField.getText()+"', '"+labelId.getText()+"',"
                                + " '"+labelNumber.getText()+"', '"+labelPhoneNumber.getText()+"', '"+labelTotalPrice.getText()+"')");
                
                JOptionPane.showMessageDialog(null, "Package Booked Successfully.");
                setVisible(false);
            } catch(Exception e) {
                e.printStackTrace();
            }
        }else{
            setVisible(false);
        }
    }
    
    public static void main (String[] args) {
        new BookPackage("bhudevi");
    }
}
