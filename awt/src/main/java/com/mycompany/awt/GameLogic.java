/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.awt;

/**
 *
 * @author Admin
 */
public class GameLogic {

  
   public GameLogic(){
   }
  
   //will determine result based on plater guess
   public int play(int playerGuess,int randomNumber){
       int result;
       if(playerGuess < randomNumber){
           result = -1;
       }else if(playerGuess > randomNumber){
           result = 1;
       }else{ //equal
           result = 0;
       }
      
       return result;
   }
  

}



