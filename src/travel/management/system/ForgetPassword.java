package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ForgetPassword extends JFrame implements ActionListener{
    
    JTextField userNameTextField, nameTextField, questionTextField, answerTextField, pwdTextField;
    JButton search, retrieve, back;
    
    ForgetPassword() {
        setBounds(350, 200, 850, 380);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/forgotpassword.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(580,70,200,200);
        add(image);
        
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBounds(30,30,500,280);
        add(p1);
        
        JLabel lblUserName = new JLabel("Username");
        lblUserName.setBounds(40,20,100,25);
        lblUserName.setFont(new Font("Tahoma", Font.BOLD, 14));
        p1.add(lblUserName);
        
        userNameTextField = new JTextField();
        userNameTextField.setBounds(220,20,150,25);
        userNameTextField.setBorder(BorderFactory.createEmptyBorder());
        p1.add(userNameTextField);
        
        search = new JButton("Search");
        search.setBackground(Color.GRAY);
        search.setForeground(Color.WHITE);
        search.setBounds(380,20,100,25);
        search.addActionListener(this);
        p1.add(search);
        
        JLabel lblName = new JLabel("Name");
        lblName.setBounds(40,60,100,25);
        lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
        p1.add(lblName);
        
        nameTextField = new JTextField();
        nameTextField.setBounds(220,60,150,25);
        nameTextField.setBorder(BorderFactory.createEmptyBorder());
        p1.add(nameTextField);
        
        JLabel lblQuestion = new JLabel("Security Question");
        lblQuestion.setBounds(40,100,150,25);
        lblQuestion.setFont(new Font("Tahoma", Font.BOLD, 14));
        p1.add(lblQuestion);
        
        questionTextField = new JTextField();
        questionTextField.setBounds(220,100,150,25);
        questionTextField.setBorder(BorderFactory.createEmptyBorder());
        p1.add(questionTextField);
        
        JLabel lblAnswer = new JLabel("Answer");
        lblAnswer.setBounds(40,140,150,25);
        lblAnswer.setFont(new Font("Tahoma", Font.BOLD, 14));
        p1.add(lblAnswer);
        
        answerTextField = new JTextField();
        answerTextField.setBounds(220,140,150,25);
        answerTextField.setBorder(BorderFactory.createEmptyBorder());
        p1.add(answerTextField);
        
        retrieve = new JButton("Retrieve");
        retrieve.setBackground(Color.GRAY);
        retrieve.setForeground(Color.WHITE);
        retrieve.setBounds(380,140,100,25);
        retrieve.addActionListener(this);
        p1.add(retrieve);
        
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(40,180,150,25);
        lblpassword.setFont(new Font("Tahoma", Font.BOLD, 14));
        p1.add(lblpassword);
        
        pwdTextField = new JTextField();
        pwdTextField.setBounds(220,180,150,25);
        pwdTextField.setBorder(BorderFactory.createEmptyBorder());
        p1.add(pwdTextField);
        
        back = new JButton("Back");
        back.setBackground(Color.GRAY);
        back.setForeground(Color.WHITE);
        back.setBounds(150,230,100,25);
        back.addActionListener(this);
        p1.add(back);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){ 
        
        if(ae.getSource() == search){
            
            String userName = userNameTextField.getText();
            try{
                String query = "select * from account where username = '"+userName+"'";
                Conn conn =new Conn();
                    
                ResultSet rs =  conn.s.executeQuery(query);
                
                while(rs.next()) {
                    nameTextField.setText(rs.getString("name"));
                    questionTextField.setText(rs.getString("security"));
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource() == retrieve){
            try{
                String userName = userNameTextField.getText();
                String answer = answerTextField.getText();
                String query = "select * from account where answer='"+answer+"' AND username = '"+userName+"'";
                Conn conn =new Conn();
                    
                ResultSet rs =  conn.s.executeQuery(query);
                
                while(rs.next()) {
                    pwdTextField.setText(rs.getString("password"));
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
            new Login();
        }
    }
    
    public static void main(String[] args){
        new ForgetPassword();
    }
}
