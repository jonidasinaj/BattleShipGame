/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 *
 * @author Jonida
 */
public class Player {
    
    //p-----> variable is for player
    
    public void play(){
        model.CreateShips p = new model.CreateShips();
        String [][] battleboard = new String[8][8];
        String [][] computerboard = new String[8][8];
        String [][] generalboardComputer = new String[8][8];
        String [][] generalboardUser = new String[8][8];
        p.setBoard(computerboard);
        p.setBoard(generalboardComputer);
        p.setBoard(generalboardUser);
        p.setBoard(battleboard);
        int totalboatsuser = 9;
        int totalboatscomputer = 9;
        String orientationvar;
        int noboats = 0;
        int x,y, value, xc, yc;
        
        //Enters the 3 types of ships
        while(noboats < 3){
            System.out.println("Choose your ship by entering 1-destroyer(length 2), 2-submarine(length 3), 3- battleship(length 4)");
            int boat = new Scanner(System.in).nextInt();
            System.out.println("Enter H-horizontal, V-Vertical: ");
            orientationvar = new Scanner(System.in).nextLine();
            while(p.checkOrientation(orientationvar)){
                System.out.println("WRONG ORIENTATION. PLEASE ENTER AGAIN! Enter H-horizontal, V-Vertical: ");
                orientationvar = new Scanner(System.in).nextLine();
            }
            if(boat == 1){
                value = (int)Math.random();
                System.out.println("You chose DESTROYER");
                x = p.xCoordinate();
                y = p.yCoordinate();
                if(orientationvar.charAt(0) == 'H'){
                    while(!p.checkRow(y, 2)){
                        System.out.println("Out of bounds");
                        x = p.xCoordinate();
                        y = p.yCoordinate();
                    }
                    p.createUserShip(battleboard, x, y, 2, orientationvar);
                }
                if(orientationvar.charAt(0) == 'V'){
                    while(!p.checkRow(x, 2)){
                        System.out.println("Out of bounds");
                        x = p.xCoordinate();
                        y = p.yCoordinate();
                    }
                    p.createUserShip(battleboard, x, y, 2, orientationvar);
                }
                if(value < 0.5){
                    xc = p.computerHitX();
                    yc = p.computerHitY();
                    while(p.takenComputerPosition(computerboard, xc, yc)){System.out.println("Position taken");xc = p.computerHitX();yc = p.computerHitY();}
                    while(!p.checkRow(yc, 2)){
                        //System.out.println("Out of bounds");
                        xc = p.computerHitX();
                        yc = p.computerHitY();
                    }
                    p.createComputerShip(computerboard, xc, yc, 2, value);
                }
                else{xc = p.computerHitX();
                    yc = p.computerHitY();
                    while(p.takenComputerPosition(computerboard, xc, yc)){System.out.println("Position taken");xc = p.computerHitX();yc = p.computerHitY();}
                    while(!p.checkRow(xc, 2)){
                        //System.out.println("Out of bounds");
                        xc = p.computerHitX();
                        yc = p.computerHitY();
                    }
                    p.createComputerShip(computerboard, xc, yc, 2, value);
                }
                p.displayBoard(battleboard);
                noboats++;
            }
            else if(boat == 2){
                value = (int)Math.random();
                System.out.println("You chose SUBMARINE");
                x = p.xCoordinate();
                y = p.yCoordinate();
                if(orientationvar.charAt(0) == 'H'){
                    while(!p.checkRow(y, 3)){
                        System.out.println("Out of bounds");
                        x = p.xCoordinate();
                        y = p.yCoordinate();
                    }
                    p.createUserShip(battleboard, x, y, 3, orientationvar);
                }
                if(orientationvar.charAt(0) == 'V'){
                    while(!p.checkRow(x, 3)){
                        System.out.println("Out of bounds");
                        x = p.xCoordinate();
                        y = p.yCoordinate();
                    }
                    p.createUserShip(battleboard, x, y, 3, orientationvar);
                }
                if(value < 0.5){
                    xc = p.computerHitX();
                    yc = p.computerHitY();
                    while(p.takenComputerPosition(computerboard, xc, yc)){System.out.println("Position taken");xc = p.computerHitX();yc = p.computerHitY();}
                    while(!p.checkRow(yc, 3)){
                        //System.out.println("Out of bounds");
                        xc = p.computerHitX();
                        yc = p.computerHitY();
                    }
                    p.createComputerShip(computerboard, xc, yc, 3, value);
                }
                else{xc = p.computerHitX();
                    yc = p.computerHitY(); 
                    while(p.takenComputerPosition(computerboard, xc, yc)){System.out.println("Position taken");xc = p.computerHitX();yc = p.computerHitY();}
                    while(!p.checkRow(xc, 3)){
                        //System.out.println("Out of bounds");
                        xc = p.computerHitX();
                        yc = p.computerHitY();
                    }
                    p.createComputerShip(computerboard, xc, yc, 3, value);
                }
                p.displayBoard(battleboard);
                noboats++;
            }
            else if(boat == 3){
                value = (int)Math.random();
                System.out.println("You chose BATTLESHIP");
                x = p.xCoordinate();
                y = p.yCoordinate();
                if(orientationvar.charAt(0) == 'H'){
                    while(!p.checkRow(y, 4)){
                        System.out.println("Out of bounds");
                        x = p.xCoordinate();
                        y = p.yCoordinate();
                    }
                    p.createUserShip(battleboard, x, y, 4, orientationvar);
                }
                if(orientationvar.charAt(0) == 'V'){
                    while(!p.checkRow(x, 4)){
                        System.out.println("Out of bounds");
                        x = p.xCoordinate();
                        y = p.yCoordinate();
                    }
                    p.createUserShip(battleboard, x, y, 4, orientationvar);
                }
                if(value < 0.5){
                    xc = p.computerHitX();
                    yc = p.computerHitY(); 
                    while(p.takenComputerPosition(computerboard, xc, yc)){System.out.println("Position taken");xc = p.computerHitX();yc = p.computerHitY();}
                    while(!p.checkRow(yc, 4)){
                        //System.out.println("Out of bounds");
                        xc = p.computerHitX();
                        yc = p.computerHitY();
                    }
                    p.createComputerShip(computerboard, xc, yc, 4, value);
                }
                else{
                    xc = p.computerHitX();
                    yc = p.computerHitY(); 
                    while(p.takenComputerPosition(computerboard, xc, yc)){System.out.println("Position taken");xc = p.computerHitX();yc = p.computerHitY();}
                    while(!p.checkRow(xc, 4)){
                        //System.out.println("Out of bounds");
                        xc = p.computerHitX();
                        yc = p.computerHitY();
                    }
                    p.createComputerShip(computerboard, xc, yc, 4, value);
                }
                p.displayBoard(battleboard);
                noboats++;
            }
            else{
                System.out.println("There is no option like this!");
            }
        }
        
        int xcoord,ycoord;
        int xvalue,yvalue;
        System.out.println("Player turn: ");
        System.out.println("SHOT x coordinate: ");
        xcoord = new Scanner(System.in).nextInt();
        System.out.println("SHOT y coordinate: ");
        ycoord = new Scanner(System.in).nextInt();
        int constantvar = 5;//Constant variable that if the user or computer HITS they win 5 points
        int pointsUser = 0;// Total sum for user
        int pointsComputer = 0;// Total sum for computer
        
        //The part WHERE IT GETS TO THEREALPLAY
        while(totalboatscomputer > 0 && totalboatsuser > 0){
            if(p.userPlay(computerboard,generalboardComputer, xcoord, ycoord)){
                totalboatsuser--;
                pointsUser = pointsUser + constantvar;
                if(totalboatsuser==0){System.out.println("YOU   WIN !!!!!" + " "+ pointsUser + " points" );break;}
                else{
                    System.out.println("Player turn: ");
                    System.out.println("SHOT x coordinate: ");
                    xcoord = new Scanner(System.in).nextInt();
                    System.out.println("SHOT y coordinate: ");
                    ycoord = new Scanner(System.in).nextInt();
                }
            }
            else{
                pointsUser --;
                System.out.println("Computer turn: ");
                System.out.println("SHOT x coordinate: ");
                xvalue = p.computerHitX();System.out.print(xvalue);
                System.out.println("SHOT y coordinate: ");
                yvalue = p.computerHitY();System.out.print(yvalue);
                
                if(p.computerPlay(battleboard,generalboardUser, xvalue, yvalue)){
                    totalboatscomputer--;
                    pointsComputer = pointsComputer + constantvar;
                    if(totalboatscomputer==0){System.out.println("Computer   WIN !!!!!" + " " + pointsComputer + "points");break;}
                    else{
                        System.out.println("Computer turn: ");
                        System.out.print("SHOT x coordinate: ");
                        xvalue = p.computerHitX();
                        System.out.print(xvalue);
                        System.out.print("SHOT y coordinate: ");
                        yvalue = p.computerHitY();
                        System.out.print(yvalue);
                    }
                }
                else{
                    pointsComputer --;
                    System.out.println("Player turn: ");
                    System.out.println("SHOT x coordinate: ");
                    xcoord = new Scanner(System.in).nextInt();
                    System.out.println("SHOT y coordinate: ");
                    ycoord = new Scanner(System.in).nextInt();
                }     
            }  
        }  
    }
}
