/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import javax.swing.*;
import java.util.*;
import java.util.Random;
/**
 *
 * @author Jonida
 */
public class CreateShips extends JFrame {
    
    private String orientation;
    private int xvalue;
    private int yvalue;
    int xguess;
    int yguess;
    int xcoord;
    int ycoord;
    final int MAX = 8;
    public int ship = 1;

    //sets Board FOR USER
    public void setBoard(String[][]board){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                board[i][j] = "_";
            }
        }
    }
    
    //sets Board FOR COMPUTER
    public void setComputerBoard(String[][]computerboard){
        for(int i = 0; i < computerboard.length; i++){
            for(int j = 0; j < computerboard[i].length; j++){
                computerboard[i][j] = "_";
            }
        }
    }
    public void displayBoard(String[][]board){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    //Checks if a certain position exists in player board.
    public boolean takenPosition(String[][] board, int xvalue, int yvalue) {
        if(board[xvalue][yvalue] == "X") {
            return true;
        }
        return false;
    }
    
    //Checks if a certain position exists in computer board.
    public boolean takenComputerPosition(String[][] board, int xvalue, int yvalue) {
        if(board[xvalue][yvalue] == "C") {
            return true;
        }
        return false;
    }
    
    //Checks if a user already shot in that position
    public boolean checkIfUserShootInPosition(String[][] shipboard, int xvalue, int yalue){
        if(shipboard[xcoord][ycoord] == "M" || shipboard[xcoord][ycoord] == "*"){
            return true;
        }
        return false;
    }
    
    //Checks if a computer already shot in that position
    public boolean checkIfComputerShootInPosition(String[][] shipboard, int xcoord, int ycoord){
        if(shipboard[xcoord][ycoord] == "M" || shipboard[xcoord][ycoord] == "$"){
            return true;
        }
        return false;
    }
    
    //Checks if a boat and coordinates are out of bounds.
    public boolean checkRow(int x, int y){
       if((x + y) > 8){return false;}
       return true;
    }
    
    public boolean checkOrientation(String orientation){
        if(orientation.charAt(0) != 'H' && orientation.charAt(0) != 'V'){
            return true;
        }
        return false;
    }
    
    public String orientationUser(){
      System.out.println("Enter H-horizontal, V-Vertical: ");
      String orientationVar = new Scanner(System.in).nextLine(); 
      return orientationVar;
    }
        
    public int xCoordinate(){
        System.out.println("Enter X coordinate: ");
        xvalue = new Scanner(System.in).nextInt();
        return xvalue;
    }
    public int yCoordinate(){
        System.out.println("Enter Y coordinate: ");
        yvalue = new Scanner(System.in).nextInt();
        return yvalue;
    }
    
    //Creates the ship for the user
    public void createUserShip(String[][]board, int xvalue, int yvalue, int length, String orientation){
        while(xvalue<0 || xvalue>7){xvalue = xCoordinate();}
        while(yvalue<0 || yvalue>7){yvalue = yCoordinate();}
        while(takenPosition(board, xvalue, yvalue)){System.out.println("Position taken"); xvalue = xCoordinate();yvalue = yCoordinate();}
        if(orientation.charAt(0) == 'H'){
            int count = 0;
            int vary = yvalue;
            for(int i = 0; i < length; i++){
                if(takenPosition(board,xvalue, vary)){count++;}vary++;
            }
            if(count == 0){
                for(int i = 0; i < length; i++){
                    board[xvalue][yvalue] = "X";
                    yvalue++;
                }
            }
            else{
                System.out.println("Overlap");
                orientation = orientationUser();
                xvalue = xCoordinate();
                yvalue = yCoordinate();
                while(checkOrientation(orientation)){System.out.println("Wrong orientation");orientation = orientationUser();}
                createUserShip(board, xvalue, yvalue, length, orientation);
            }
        }
        if(orientation.charAt(0) == 'V'){
            int count = 0;
            int varx = xvalue;
            for(int i = 0; i < length; i++){
                if(takenPosition(board,varx, yvalue)){count++;}varx++;
            }
            if(count == 0){
                 for(int i = 0; i < length; i++){
                    board[xvalue][yvalue] = "X";
                    xvalue++;
                 }
            }
            else{
                System.out.println("Overlap");
                orientation = orientationUser();
                while(checkOrientation(orientation)){System.out.println("Wrong orientation");orientation = orientationUser();}
                xvalue = xCoordinate();
                yvalue = yCoordinate();
                createUserShip(board, xvalue, yvalue, length, orientation);
            }
        }
    }

    
    //Creates the ship for Computer
    public void createComputerShip(String[][]computerboard, int xcoord, int ycoord, int length, int value){
        while(xcoord<0 || xcoord>7){xcoord = computerHitX();}
        while(ycoord<0 || ycoord>7){ycoord = computerHitY();}
        while(takenComputerPosition(computerboard, xcoord, ycoord)){System.out.println("Position taken");xcoord = computerHitX();ycoord = computerHitY();}
        if(value < 0.5){
            int vary = ycoord;
            int count = 0;
            for(int i = 0; i < length; i++){
                if(takenComputerPosition(computerboard,xcoord, vary)){
                    count++;xcoord = computerHitX();
                    ycoord = computerHitY();
                    createComputerShip(computerboard, xcoord, ycoord, length, value);
                }
                vary++;
            }
            if(count == 0){
                for(int i = 0; i < length; i++){
                    computerboard[xcoord][ycoord] = "C";
                    ycoord++;
                }
            }
            else{
                xcoord = computerHitX();
                ycoord = computerHitY();
                createComputerShip(computerboard, xcoord, ycoord, length, value);
            }
        }
        else{
            int varx = xcoord;
            int count = 0;
            for(int i = 0; i < length; i++){
                if(takenComputerPosition(computerboard,varx, ycoord)){count++;}varx++;
            }
            if(count == 0){
                for(int i = 0; i < length; i++){
                    computerboard[xcoord][ycoord] = "C";
                    ycoord++;
                }
            }
            else{
                xcoord = computerHitX();
                ycoord = computerHitY();
                createComputerShip(computerboard, xcoord, ycoord, length, value);
            }
        }
    }
    
    //Gives x coordinate for computer
    public int computerHitX(){
        xcoord  = (int)(Math.random()*8);
        return xcoord;
    }
    
    //Gives y coordinate for computer
    public int computerHitY(){
        ycoord  = (int)(Math.random()*8);
        return ycoord;
    } 
    
    //Checks if user HITS OR MISSES IN A SHOOT
    public boolean userPlay(String[][]computerboard,String[][]generalboardComputer, int xcoord, int ycoord){
        while(xcoord<0 || xcoord>7){xcoord = xCoordinate();}
        while(ycoord<0 || ycoord>7){ycoord = yCoordinate();}
        if(generalboardComputer[xcoord][ycoord] == "M" || generalboardComputer[xcoord][ycoord] == "H"){System.out.println("Already shot there!");xcoord = xCoordinate();ycoord = yCoordinate();
        userPlay(computerboard,generalboardComputer, xcoord,ycoord);return false;}
        else{
            if(computerboard[xcoord][ycoord] == "C"){
                System.out.println("Hit");
                generalboardComputer[xcoord][ycoord] = "H";
                displayBoard(generalboardComputer);
                return true; 
            }
            else{
                System.out.println("Miss");
                generalboardComputer[xcoord][ycoord] = "M";
               displayBoard(generalboardComputer);
               return false;
            } 
        }
    }
    
    //Checks if computer HITS OR MISSES IN A SHOOT
    public boolean computerPlay(String[][]board,String[][]generalboardUser, int xvalue, int yvalue){
        while(xvalue<0 || xvalue>8){xvalue = computerHitX();}
        while(yvalue<0 || yvalue>8){yvalue = computerHitY();}
        if(generalboardUser[xcoord][ycoord] == "M" || generalboardUser[xcoord][ycoord] == "O"){System.out.println("Computer Already shot there!");xvalue = computerHitX();yvalue = computerHitY();
            computerPlay(board,generalboardUser, xvalue,yvalue);return false;} 
        else{
            if(board[xvalue][yvalue].equals("X")){
                System.out.println("Computer Hit");
                generalboardUser[xvalue][yvalue] = "O";
                displayBoard(generalboardUser);
                return true; 
            }
            else{
                System.out.println("Computer Miss");
                //board[xvalue][yvalue] = "M";
                generalboardUser[xvalue][yvalue] = "M";
                displayBoard(generalboardUser);
                return false;
            }    
        }
    }
}

