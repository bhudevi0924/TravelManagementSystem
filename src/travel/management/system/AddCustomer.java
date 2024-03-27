package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class AddCustomer extends JFrame implements ActionListener{
    
    JLabel lblUsername, lblName;
    JComboBox comboId; 
    JTextField numberTextField, countryTextField, addressTextField, phoneNumberTextField, emailTextField;
    JRadioButton male, female;
    JButton add, back;
    
    AddCustomer(String username) {
        setBounds(400,180,850,530);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel labelUsername = new JLabel("Username");
        labelUsername.setBounds(30,50,150,25);
        add(labelUsername);
        
        lblUsername = new JLabel();
        lblUsername.setBounds(220,50,150,25);
        add(lblUsername);
        
        JLabel labelId = new JLabel("Id");
        labelId.setBounds(30,90,150,25);
        add(labelId);
        
        comboId = new JComboBox(new String[] {"Passport", "Aadhar Card", "Pan Card", "Ration Card"});
        comboId.setBounds(220,90,150,25);
        comboId.setBackground(Color.WHITE);
        add(comboId);
        
        JLabel labelNumber = new JLabel("Number");
        labelNumber.setBounds(30,130,150,25);
        add(labelNumber);
        
        numberTextField = new JTextField();
        numberTextField.setBounds(220,130,150,25);
        add(numberTextField);
        
        JLabel labelName = new JLabel("Name");
        labelName.setBounds(30,170,150,25);
        add(labelName);
        
        lblName = new JLabel();
        lblName.setBounds(220,170,150,25);
        add(lblName);
        
        JLabel labelGender = new JLabel("Gender");
        labelGender.setBounds(30,210,150,25);
        add(labelGender);
        
        male = new JRadioButton("Male");
        male.setBounds(220,210,70,25);
        male.setBackground(Color.WHITE);
        add(male);
        
        female = new JRadioButton("Female");
        female.setBounds(300,210,70,25);
        female.setBackground(Color.WHITE);
        add(female);
        
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(male);
        buttonGroup.add(female);
        
        JLabel labelCountry = new JLabel("Country");
        labelCountry.setBounds(30,250,150,25);
        add(labelCountry);
        
        countryTextField = new JTextField();
        countryTextField.setBounds(220,250,150,25);
        add(countryTextField);
        
        JLabel labelAddress = new JLabel("Address");
        labelAddress.setBounds(30,290,150,25);
        add(labelAddress);
        
        addressTextField = new JTextField();
        addressTextField.setBounds(220,290,150,25);
        add(addressTextField);
        
        JLabel labelPhone = new JLabel("Phone Number");
        labelPhone.setBounds(30,330,150,25);
        add(labelPhone);
        
        phoneNumberTextField = new JTextField();
        phoneNumberTextField.setBounds(220,330,150,25);
        add(phoneNumberTextField);
        
        JLabel labelEmail = new JLabel("Email");
        labelEmail.setBounds(30,370,150,25);
        add(labelEmail);
        
        emailTextField = new JTextField();
        emailTextField.setBounds(220,370,150,25);
        add(emailTextField);
        
        add = new JButton("Add");
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.setBounds(70,430,100,25);
        add.addActionListener(this);
        add(add);
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(220,430,100,25);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/newcustomer.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,40,450,420);
        add(image);
        
        try{
            Conn conn = new Conn();
            String query = "select * from account where username = '"+username+"'";
           ResultSet result = conn.s.executeQuery(query);
            while(result.next()) {
                lblUsername.setText(result.getString("username"));
                lblName.setText(result.getString("name"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == add){
            String username = lblUsername.getText();
            String id = (String) comboId.getSelectedItem();
            String number = numberTextField.getText();
            String name = lblName.getText();
            String gender = null;
            if(male.isSelected()) {
                gender = "Male";
            }else{
                gender = "Female";
            }
            String country = countryTextField.getText();
            String address = addressTextField.getText();
            String phoneNumber = phoneNumberTextField.getText();
            String email = emailTextField.getText();
            
            try{
                Conn conn = new Conn();
                String query = "insert into customer values('"+username+"', '"+id+"', '"+number+"', "
                        + "'"+name+"', '"+gender+"', '"+country+"', '"+address+"', '"+phoneNumber+"', '"+email+"')";
                conn.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Customer details added successfully.");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            setVisible(false);
        }
    }
    
    public static void main (String[] args) {
        new AddCustomer("bhudevi");
    }
}
