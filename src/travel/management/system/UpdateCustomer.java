package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class UpdateCustomer extends JFrame implements ActionListener{
    
    JLabel lblUsername, lblName;
    JComboBox comboId; 
    JTextField numberTextField, countryTextField, addressTextField, phoneNumberTextField, emailTextField,
            idTextField, genderTextField;
    JButton update, back;
    
    UpdateCustomer(String username) {
        setBounds(400,180,850,530);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel text = new JLabel("Update Customer Details");
        text.setBounds(50,0,300,25);
        text.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(text);
        
        JLabel labelUsername = new JLabel("Username");
        labelUsername.setBounds(30,50,150,25);
        add(labelUsername);
        
        lblUsername = new JLabel();
        lblUsername.setBounds(220,50,150,25);
        add(lblUsername);
        
        JLabel labelId = new JLabel("Id");
        labelId.setBounds(30,90,150,25);
        add(labelId);
        
        idTextField = new JTextField();
        idTextField.setBounds(220,90,150,25);
        add(idTextField);
        
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
        
        genderTextField = new JTextField();
        genderTextField.setBounds(220,210,150,25);
        add(genderTextField);
        
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
        
        update = new JButton("Update");
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.setBounds(70,430,100,25);
        update.addActionListener(this);
        add(update);
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(220,430,100,25);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/update.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,50,450,400);
        add(image);
        
        try{
            Conn conn = new Conn();
            String query = "select * from customer where username = '"+username+"'";
           ResultSet result = conn.s.executeQuery(query);
            while(result.next()) {
                lblUsername.setText(result.getString("username"));
                lblName.setText(result.getString("name"));
                idTextField.setText(result.getString("id"));
                numberTextField.setText(result.getString("number"));
                genderTextField.setText(result.getString("gender"));
                countryTextField.setText(result.getString("country"));
                addressTextField.setText(result.getString("address"));
                phoneNumberTextField.setText(result.getString("phoneNumber"));
                emailTextField.setText(result.getString("email"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == update){
            String username = lblUsername.getText();
            String id = idTextField.getText();
            String number = numberTextField.getText();
            String name = lblName.getText();
            String gender = genderTextField.getText();
            String country = countryTextField.getText();
            String address = addressTextField.getText();
            String phoneNumber = phoneNumberTextField.getText();
            String email = emailTextField.getText();
            
            try{
                Conn conn = new Conn();
                String query = "update customer set username = '"+username+"', id = '"+id+"', number = '"+number+"',"
                        + " name = '"+name+"', gender = '"+gender+"', country = '"+country+"', address = '"+address+"', phoneNumber = '"+phoneNumber+"', email = '"+email+"'";
                conn.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Customer details updated successfully.");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            setVisible(false);
        }
    }
    
    public static void main (String[] args) {
        new UpdateCustomer("bhudevi");
    }
}

