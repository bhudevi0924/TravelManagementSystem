package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Signup extends JFrame implements ActionListener{
    
    JButton create, back;
    JTextField userNameTextField, nameTextField, pwdTextField, answerTextField;
    Choice security;
    
    Signup() {
        setBounds(350,200,900,360);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JPanel p1= new JPanel();
        p1.setBackground(new Color(131, 193, 233));
        p1.setBounds(0,0,500,400);
        p1.setLayout(null);
        add(p1);
        
        JLabel lblUserName = new JLabel("Username");
        lblUserName.setBounds(50,20,125,25);
        lblUserName.setFont(new Font("Tahoma", Font.BOLD, 14));
        p1.add(lblUserName);
        
        userNameTextField= new JTextField();
        userNameTextField.setBounds(190,20,180,25);
        userNameTextField.setBorder(BorderFactory.createEmptyBorder());
        p1.add(userNameTextField);
        
        JLabel lblName = new JLabel("Name");
        lblName.setBounds(50,60,125,25);
        lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
        p1.add(lblName);
        
        nameTextField= new JTextField();
        nameTextField.setBounds(190,60,180,25);
        nameTextField.setBorder(BorderFactory.createEmptyBorder());
        p1.add(nameTextField);
        
        JLabel lblPassword = new JLabel("Password");
        lblPassword.setBounds(50,100,125,25);
        lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
        p1.add(lblPassword);
        
        pwdTextField= new JTextField();
        pwdTextField.setBounds(190,100,180,25);
        pwdTextField.setBorder(BorderFactory.createEmptyBorder());
        p1.add(pwdTextField);
        
        JLabel lblSecurity = new JLabel("Security Question");
        lblSecurity.setBounds(50,140,125,25);
        lblSecurity.setFont(new Font("Tahoma", Font.BOLD, 14));
        p1.add(lblSecurity);
        
        security = new Choice();
        security.add("Your pet name");
        security.add("Your first school name");
        security.add("Your favourite snack");
        security.setBounds(190,140,180,25);
        p1.add(security);
        
        JLabel lblAnswer = new JLabel("Answer");
        lblAnswer.setBounds(50,180,125,25);
        lblAnswer.setFont(new Font("Tahoma", Font.BOLD, 14));
        p1.add(lblAnswer);
        
        answerTextField= new JTextField();
        answerTextField.setBounds(190,180,180,25);
        answerTextField.setBorder(BorderFactory.createEmptyBorder());
        p1.add(answerTextField);
        
        create = new JButton("Create");
        create.setBounds(80,250,100,30);
        create.setBackground(Color.WHITE);
        create.setForeground(new Color(133,193,233));
        create.setFont(new Font("Tahoma", Font.BOLD, 14));
        create.addActionListener(this);
        p1.add(create);
        
        back = new JButton("Back");
        back.setBounds(250,250,100,30);
        back.setBackground(Color.WHITE);
        back.setForeground(new Color(133,193,233));
        back.setFont(new Font("Tahoma", Font.BOLD, 14));
        back.addActionListener(this);
        p1.add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/signup.png"));
        Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        
        JLabel image = new JLabel(i3);
        image.setBounds(580,50,250,250);   //sets custom layout for panel p1     
        add(image); 
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource() == create){
            
            //gets the values from the respective fields
            String userName = userNameTextField.getText();
            String name = nameTextField.getText();
            String password = pwdTextField.getText();
            String question = security.getSelectedItem();
            String answer = answerTextField.getText();
            
            //query to insert values into db
            String query = "insert into account values('"+userName+"', '"+name+"', '"+password+"', '"+question+"', '"+answer+"')";
            
            try{
                Conn conn= new Conn();          //object for Conn class for connection
                conn.s.executeUpdate(query);   //executes the query
                
                JOptionPane.showMessageDialog(null, "Account created scuccessfully."); //populates dialog box on successful addition of new account
                setVisible(false);
                new Login();
            } catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource() == back){
            setVisible(false);
            new Login();
        }
    }
    
    public static void main (String[] args){
        new Signup();
    }
}
