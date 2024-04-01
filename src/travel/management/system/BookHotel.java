package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BookHotel extends JFrame implements ActionListener{
    
    Choice cHotel, cAC, cFood;
    JTextField totalPersonsTextField, daysTextField;
    String username;
    JLabel labelUsername, labelId, labelNumber, labelPhoneNumber, labelTotalPrice;
    JButton checkPrice, bookPackage, back;
    
    BookHotel(String username) {
        this.username = username; 
        setBounds(350, 150, 1000, 600);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel text = new JLabel("BOOK HOTEL ");
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
        
        JLabel lblSelectHotel = new JLabel("Select Hotel");
        lblSelectHotel.setBounds(40,110,150,20);
        lblSelectHotel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblSelectHotel);
        
        cHotel = new Choice();
        cHotel.setBounds(250, 110, 200, 20);
        add(cHotel);
        
        try{
            Conn conn = new Conn();
            ResultSet result = conn.s.executeQuery("select * from hotel");
            
            while(result.next()) {
                cHotel.add(result.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JLabel lblTotalPersons = new JLabel("Total Persons");
        lblTotalPersons.setBounds(40,150,150,25);
        lblTotalPersons.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblTotalPersons);
        
        totalPersonsTextField = new JTextField("1");
        totalPersonsTextField.setBounds(250,150,200,25);
        totalPersonsTextField.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(totalPersonsTextField);
        
        JLabel lblDays = new JLabel("No.of Days");
        lblDays.setBounds(40,190,150,25);
        lblDays.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblDays);
        
        daysTextField = new JTextField("1");
        daysTextField.setBounds(250,190,200,25);
        daysTextField.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(daysTextField);
        
        JLabel lblAC = new JLabel("AC /NON-AC");
        lblAC.setBounds(40,230,150,25);
        lblAC.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblAC);
        
        cAC = new Choice();
        cAC.add("AC");
        cAC.add("NON-AC");
        cAC.setBounds(250,230,200,20);
        add(cAC);
        
        JLabel lblFood = new JLabel("Food Included");
        lblFood.setBounds(40,270,150,25);
        lblFood.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblFood);
        
        cFood = new Choice();
        cFood.add("Yes");
        cFood.add("No");
        cFood.setBounds(250,270,200,20);
        add(cFood);
        
        JLabel lblId = new JLabel("Id");
        lblId.setBounds(40,310,150,20);
        lblId.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblId);
        
        labelId = new JLabel();
        labelId.setBounds(250,310,200,25);
        labelId.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(labelId);
        
        JLabel lblNumber = new JLabel("Number");
        lblNumber.setBounds(40,350,150,25);
        lblNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblNumber);
        
        labelNumber = new JLabel();
        labelNumber.setBounds(250,350,150,25);
        labelNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(labelNumber);
        
        JLabel lblPhoneNumber = new JLabel("Phone Number");
        lblPhoneNumber.setBounds(40,390,150,20);
        lblPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblPhoneNumber);
        
        labelPhoneNumber = new JLabel();
        labelPhoneNumber.setBounds(250,390,200,25);
        labelPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(labelPhoneNumber);
        
        JLabel lblTotalPrice = new JLabel("Total Price");
        lblTotalPrice.setBounds(40,430,150,25);
        lblTotalPrice.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblTotalPrice);
        
        labelTotalPrice = new JLabel();
        labelTotalPrice.setBounds(250,430,150,25);
        labelTotalPrice.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(labelTotalPrice);
        
        checkPrice = new JButton("Check Price");
        checkPrice.setBackground(Color.BLACK);
        checkPrice.setForeground(Color.WHITE);
        checkPrice.setBounds(60, 490, 120, 25);
        checkPrice.addActionListener(this);
        add(checkPrice);
        
        bookPackage = new JButton("Book Hotel");
        bookPackage.setBackground(Color.BLACK);
        bookPackage.setForeground(Color.WHITE);
        bookPackage.setBounds(200, 490, 120, 25);
        bookPackage.addActionListener(this);
        add(bookPackage);
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(340, 490, 120, 25);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/book.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500,50,600,300);
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
            try{
                Conn conn = new Conn();
                ResultSet result = conn.s.executeQuery("select * from hotel where name = '"+cHotel.getSelectedItem()+"'");
                while(result.next()) {
                    int cost = Integer.parseInt(result.getString("costperperson"));
                    int food = Integer.parseInt(result.getString("foodincluded"));
                    int ac = Integer.parseInt(result.getString("acroom"));
                    int persons = Integer.parseInt(totalPersonsTextField.getText());
                    int days = Integer.parseInt(daysTextField.getText());
                    
                    String acSelected  = cAC.getSelectedItem();
                    String foodSelected = cFood.getSelectedItem();
                    
                    if(persons * days > 0) {
                        int total =0;
                        total += acSelected.equals("AC") ? ac : 0;
                        total += foodSelected.equals("Yes") ? food :0;
                        total += cost;
                        total = total * persons * days;
                        labelTotalPrice.setText("Rs" + total);
                    } else {
                        JOptionPane.showMessageDialog(null, "Please enter a valid number");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }else if(ae.getSource() == bookPackage) {
            try{
                Conn conn = new Conn();
                conn.s.executeUpdate("insert into bookhotel values('"+labelUsername.getText()+"',"
                        + " '"+cHotel.getSelectedItem()+"', '"+totalPersonsTextField.getText()+"', '"+daysTextField.getText()+"',"
                                + "'"+cAC.getSelectedItem()+"', '"+cFood.getSelectedItem()+"','"+labelId.getText()+"',"
                                + " '"+labelNumber.getText()+"', '"+labelPhoneNumber.getText()+"', '"+labelTotalPrice.getText()+"')");
                
                JOptionPane.showMessageDialog(null, "Hotel Booked Successfully.");
                setVisible(false);
            } catch(Exception e) {
                e.printStackTrace();
            }
        }else{
            setVisible(false);
        }
    }
    
    public static void main (String[] args) {
        new BookHotel("bhudevi");
    }
}

