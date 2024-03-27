package travel.management.system;

import javax.swing.*;
import java.awt.*;

public class CheckPackage extends JFrame {

    CheckPackage() {
        setBounds(350, 160, 900, 600);

        String[] package1 = {"GOLD PACKAGE", "6 Days and 7 Nights", "Airport Assistance", "Half Day City Tour", "Daily Buffet", "Soft Drinks Free", "Full Day 3 Island Cruise", "English Speaking Guide", "BOOK PACKAGE", "SUMMER SPECIAL", "Rs 12000/-", "package1.jpg"};
        String[] package2 = {"SILVER PACKAGE", "5 Days and 6 Nights", "Toll Free", "Entrance Free Tickets", "Meet and Greet at Airport", "Welcome Drinks on Arrival", "Night Safari", "Cruise With Dinner", "BOOK NOW", "WINTER SPECIAL", "Rs 24000/-", "package2.jpg"};
        String[] package3 = {"BRONZE PACKAGE", "6 Days and 5 Nights", "Return Airfare", "Free Clubing, Horse Riding","River Rafting", "Hard Drinks Free", "Daily Buffet", "BBQ Dinner", "BOOK NOW", "WINTER SPECIAL", "Rs 32000/-", "package3.jpg"};
        
        JTabbedPane tab = new JTabbedPane();

        JPanel p1 = createPackage(package1);
        tab.addTab("Package 1", null, p1);
        
        JPanel p2 = createPackage(package2);
        tab.addTab("Package 2", null, p2);
        
        JPanel p3 = createPackage(package3);
        tab.addTab("Package 3", null, p3);
        
        add(tab);
        
        

        setVisible(true);
    }

    public JPanel   createPackage(String[] pack) {
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(Color.WHITE);

        JLabel goldPackageLabel = new JLabel(pack[0]);
        goldPackageLabel.setBounds(50, 5, 300, 30);
        goldPackageLabel.setForeground(Color.YELLOW);
        goldPackageLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
        p1.add(goldPackageLabel);
        
        JLabel label1 = new JLabel(pack[1]);
        label1.setBounds(30, 60, 300, 30);
        label1.setForeground(Color.RED);
        label1.setFont(new Font("Tahoma", Font.BOLD, 20));
        p1.add(label1);
        
        JLabel label2 = new JLabel(pack[2]);
        label2.setBounds(30, 110, 300, 30);
        label2.setForeground(Color.BLUE);
        label2.setFont(new Font("Tahoma", Font.BOLD, 20));
        p1.add(label2);
        
        JLabel label3 = new JLabel(pack[3]);
        label3.setBounds(30, 160, 300, 30);
        label3.setForeground(Color.RED);
        label3.setFont(new Font("Tahoma", Font.BOLD, 20));
        p1.add(label3);
        
        JLabel label4 = new JLabel(pack[4]);
        label4.setBounds(30, 210, 300, 30);
        label4.setForeground(Color.BLUE);
        label4.setFont(new Font("Tahoma", Font.BOLD, 20));
        p1.add(label4);
        
        JLabel label5 = new JLabel(pack[5]);
        label5.setBounds(30, 260, 300, 30);
        label5.setForeground(Color.RED);
        label5.setFont(new Font("Tahoma", Font.BOLD, 20));
        p1.add(label5);
        
        JLabel label6 = new JLabel(pack[6]);
        label6.setBounds(30, 310, 300, 30);
        label6.setForeground(Color.BLUE);
        label6.setFont(new Font("Tahoma", Font.BOLD, 20));
        p1.add(label6);
        
        JLabel label7 = new JLabel(pack[7]);
        label7.setBounds(30, 360, 300, 30);
        label7.setForeground(Color.RED);
        label7.setFont(new Font("Tahoma", Font.BOLD, 20));
        p1.add(label7);
        
        JLabel label8 = new JLabel(pack[8]);
        label8.setBounds(60, 430, 300, 30);
        label8.setForeground(Color.BLACK);
        label8.setFont(new Font("Tahoma", Font.BOLD, 25));
        p1.add(label8);
        
        JLabel label9 = new JLabel(pack[9]);
        label9.setBounds(80, 460, 300, 30);
        label9.setForeground(Color.MAGENTA);
        label9.setFont(new Font("Tahoma", Font.BOLD, 25));
        p1.add(label9);
        
        JLabel label10 = new JLabel(pack[10]);
        label10.setBounds(500, 460, 300, 30);
        label10.setForeground(Color.CYAN);
        label10.setFont(new Font("Tahoma", Font.BOLD, 25));
        p1.add(label10);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/"+pack[11]));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,20,500,300);
        p1.add(image);
        
        return p1;
    }
    
    public static void main(String[] args) {
        new CheckPackage();
    }
}
