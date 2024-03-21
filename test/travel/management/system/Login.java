package travel.management.system;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;

public class Login extends JFrame{
    
    Login() {
        setSize(900,400);
        setLocation(350,200);
        setLayout(null);                // states that we don't want to use swing layouts and allows us to 
                                            //create and use our own layouts
        getContentPane().setBackground(Color.WHITE); //sets the color of the entire panel
                                            
        JPanel p1 = new JPanel();      //creates a panel
        p1.setBackground(new Color(131, 193, 233));  //sets the background color of the panel (blue color)
        p1.setBounds(0,0,400,400);      //sets the custom layout (position that it starts, length,height)
        p1.setLayout(null);
        add(p1);                        //adds panel to the frame
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        
        JLabel image = new JLabel(i3);
        image.setBounds(100,120,200,200);   //sets custom layout for panel p1     
        p1.add(image);                      //adds image to the panel p1
        
        JPanel p2 =  new JPanel();
        p2.setLayout(null); 
        p2.setBounds(400,30,450,300);       //considers this only if the default layout is set as null
        add(p2);                            
        
        JLabel lblUserName = new JLabel("User Name");
        lblUserName.setBounds(60,20,100,25);
        lblUserName.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        p2.add(lblUserName);
        
        JTextField  userNameTextField= new JTextField();  //creates a text field
        userNameTextField.setBounds(60,60,300,30);
        userNameTextField.setBorder(BorderFactory.createEmptyBorder()); //removes borders of the text field
        p2.add(userNameTextField);
        
        JLabel lblPassword = new JLabel("Password");
        lblPassword.setBounds(60,110,100,25);
        lblPassword.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        p2.add(lblPassword);
        
        JTextField  passwordTextField= new JTextField();  //creates a text field
        passwordTextField.setBounds(60,150,300,30);
        passwordTextField.setBorder(BorderFactory.createEmptyBorder()); //removes borders of the text field
        p2.add(passwordTextField);
        
        JButton login = new JButton("Login");
        login.setBounds(60,200,130,30);
        login.setBackground(new Color(133,193,233));
        login.setForeground(Color.WHITE);
        login.setBorder(new LineBorder(new Color(133,193,233)));
        p2.add(login);
        
        JButton signup = new JButton("Signup");
        signup.setBounds(230,200,130,30);
        signup.setBackground(new Color(133,193,233));
        signup.setForeground(Color.WHITE);
        signup.setBorder(new LineBorder(new Color(133,193,233)));
        p2.add(signup);
        
         
        JButton forgetPwd = new JButton("Forget Password");
        forgetPwd.setBounds(130,250,130,30);
        forgetPwd.setBackground(new Color(133,193,233));
        forgetPwd.setForeground(Color.WHITE);
        forgetPwd.setBorder(new LineBorder(new Color(133,193,233)));
        p2.add(forgetPwd);
        
        JLabel text = new JLabel("Trouble in login...");
        text.setBounds(300,250,150,20);
        text.setForeground(Color.red);
        p2.add(text);
        
        setVisible(true);
    }
    
    public static void main(String[] args){
        new Login();
    }
}
