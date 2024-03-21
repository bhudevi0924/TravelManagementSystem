/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package travel.management.system;

import javax.swing.*;
import java.awt.*;
/**
 *
 * @author Bhudevi Dobbala
 */
public class Splash extends JFrame implements Runnable {
    
    Thread thread;
    
    Splash() {
//        setSize(1200,600);  // sets the size of the frame (length,height)
//        setLocation(100,100); //sets the location of the frame(left,top)
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/splash.jpg"));  //gets the image from the specified location
        Image i2 = i1.getImage().getScaledInstance(1200, 600, Image.SCALE_DEFAULT);  //scales the image (length,height,scaling)
        ImageIcon i3 = new ImageIcon(i2); // as we can't place scaled image directly to frame, converted it into image icon
        
         JLabel image = new JLabel(i3);  //helps to add the image to frame as we can't place images to frame directly
        add(image); //adds image to the frame
        
        setVisible(true);     //sets the visibility of the frame, which is FALSE by default
        
        thread =new Thread(this);  //creates object for thread
        thread.start();            // calls the run method
        
    }
    
    //overriding the run method of the Runnable inteface
    public void run(){
        try{
            Thread.sleep(7000);     //thread sleeps after 7seconds
            setVisible(false);      //the frame visibility is set to FALSE after 7 seconds
        } catch(Exception e){
            
        }
    }
    
    public static void main (String[] args){
       Splash frame= new Splash();  //invokes Splash constructor
       
       //sets dynamic size and location for the frame
       int x=1;
       for (int i=1; i<=500; x+=7, i+=6){
           frame.setLocation(750 -(x+i)/2, 400-(i/2));
           frame.setSize(x+i, i);
           
           try{
               Thread.sleep(5);
           }catch(Exception e){
               
           }
       }
    }
}
