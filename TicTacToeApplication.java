/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoeapplication;

import java.util.Scanner;

/**
 *
 * @author harsh jadaun
 */
public class TicTacToeApplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // Getting Inputs
        Scanner sc = new Scanner(System.in);
        // Allows for continuous games
        boolean doYouWantToPlay=true;
        
        while(doYouWantToPlay){
            // Setting up our tokens and AI
            System.out.println("Welcome to Tic Tac Toe! You are about to go against the master of Tic Tac Toe.Are you ready?");
            System.out.println("But first pick your character");
            System.out.println("\n Enter x or o");
            char playerToken=sc.next().charAt(0);
            char opponentToken;
            if(playerToken=='x'){
                opponentToken='o';
            }else{
                opponentToken='x';
            }
            TicTacToe game = new TicTacToe(playerToken,opponentToken);
            AI ai = new AI();
            // Set up the game
            System.out.println("\nEnter a number\n Numbers goes from 1-9 from left to right and up to down");
            TicTacToe.printIndexBoard();
            System.out.println();
            
            // Let's Play
            while(game.gameOver().equals("not Over")){
                if(game.currentMarker==game.userMarker){
                    // USER TURN
                    System.out.println("It's your turn! Enter a spot for your token");
                    int spot=sc.nextInt();
                    while(!game.playTurn(spot)){
                        System.out.println("Try again "+ spot + " is invalid. This spot is already taken or it is out of range");
                        spot=sc.nextInt();
                    }
                    System.out.println("You picked "+ spot + "!");
                }else{
                    // AI turn
                    System.out.println("It's my turn!");
                    // pick spot
                    int aiSpot = ai.pickSpot(game); 
                    game.playTurn(aiSpot);
                    System.out.println("I picked "+ aiSpot + "!");
                }
                // Print out new board
                System.out.println();
                game.printBoard();
            }
            System.out.println(game.gameOver());
            System.out.println();
            System.out.println("Do You want to play again? Enter Y or anything else!");
            char response = sc.next().charAt(0);
            doYouWantToPlay = (response=='Y');
            System.out.println();
            System.out.println();
        }
    }
    
}
