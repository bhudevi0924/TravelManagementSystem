package travel.management.system;

import java.sql.*;
public class Conn {
    
    Connection c;
    Statement s;
    
    Conn() {
        try{
             Class.forName("com.mysql.cj.jdbc.Driver");   //registers the driver class
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/travelmanagementsystem", "root", ""); //creates connection string
            s= c.createStatement();  // creates statement
        }catch(Exception e){
            e.printStackTrace();    
        }
    }
}
