/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.awt;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class merger {
    static int count=0;
     private static void updateUIManager(int value){
       Color color = null;
       if(value == 1000){
           //at start
           color = Color.white;
       }else if(value > 0){
           color= Color.red;
       }else if(value < 0){
           color = Color.GRAY;
       }else{ 
           color = Color.green;
       }
      
       UIManager.put("OptionPane.background", color);
       UIManager.put("Panel.background", color);
   }
    private static String getMessage(int gameResult,int count){
        String message = null;
        if(gameResult > 0){
            message = "You guessed too high, try again!";
        }else if(gameResult < 0){
            message = "You guessed too low, try again!";
        }else{ 

            message = "Congrats! you guessed THE NUMBER in "+ count +" Tries!!!";
        }

        return message;
    }
  
    
    public static void converter()
    {
        
       
  
     
        JFrame f = new JFrame("Game");
  
   
        JLabel l1;
  
       
        JTextField t1;
  
    
        JButton b1, b2;
  
   
        l1 = new JLabel("Guess the number between 0 and 1000!:");
        l1.setBounds(20, 40, 400, 30);
    
  
      
        t1 = new JTextField("0");
        t1.setBounds(120, 80, 80, 30);
    
  
       
        b1 = new JButton("Guess!");
        b1.setBounds(270, 83, 80, 25);
        b2 = new JButton("close");
        b2.setBounds(295, 232, 90, 30);
        UIManager.put("OptionPane.backround", Color.white);  
        UIManager.put("Pandelbackround", Color.white);  
        UIManager.put("Button.background", Color.white);
      
        Random nextRandom = new Random();
        int randomNum = nextRandom.nextInt(1000);        
        
       
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                  
               
                   count++;
               

                 
               int playerGuess = 0;
               

             
               GameLogic gl = new GameLogic();


               String message = null;
               
                   
                    updateUIManager(1000);
                  
                    try{
                        
                        playerGuess = Integer.parseInt(t1.getText());  
                    }
                    catch(NumberFormatException nfe){ //handled exception here. If not proper inpput , it will display error and go to top of loop
                        message = "Invalid input";
                        JOptionPane.showMessageDialog(null, message);
                        
                    }
               int result = gl.play(playerGuess, randomNum); 
               updateUIManager(result);
               if (message != "Invalid input"){
               message = getMessage(result,count);
               JOptionPane.showMessageDialog(null, message);
               }
               if(result == 0){
                   
                   message = getMessage(result,count);
                   
               }
       }
            
        });
  
        
     
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                f.dispose();
            }
        });
  
     
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        });
  
        
        f.add(l1);
        f.add(t1);
   
   
        f.add(b1);
       
        f.add(b2);
  
        f.setLayout(null);
        f.setSize(400, 300);
        f.setVisible(true);
    }
    
  

    public static void main(String args[])
    {
        converter();
    }
}