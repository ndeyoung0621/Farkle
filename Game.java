
package main.java.edu.gonzaga.Farkle;
import edu.gonzaga.Farkle.Die;
import java.util.Scanner;

public class Game {

    /*variables known by an instance of the game, they include two static variables: gameRunning and totalScorePlayer1
    these variables are static because they should be the same univerally and accessed outside the method. There is only ever
    one instance of game so no cross threading. Also initializes a scanner.
    */
    public static boolean gameRunning = true;
    public static int totalScorePlayer1 = 0;
    Scanner scanner = new Scanner(System.in);


    //method to run a game instance, initializes a hand, a meld, a count of the die in play, a scorecard, and whether a farkle was rolled
    public void run() {

            Hand hand = new Hand();
            hand.sortHand();
            Meld meld = new Meld();
            meld.set_default_meld();
            int[] countDie = hand.countDie();
            scoreCard scoreCard = new scoreCard();
            boolean isFarkle = hand.farkleChecker();

        //a "gameloop" that continues until one of the game quitting conditions have been met
        while (gameRunning) {
            
            //calls the printscreen method and gives it the initialized values for this game's meld, hand, etc
            printScreen(meld.getMeld(), hand.getHand(), countDie, scoreCard.getScore(), isFarkle);
            
            //takes the player's input and cleans 
            String playerInput = scanner.nextLine();
            playerInput = stringClean(playerInput);

            //depending on the cleaned player input, changes the meld 
            meld.setMeld(playerInput, hand.getHand());

            //depending on the meld the player choses, changes the value of the score
            scoreCard.setScore(meld.getMeld());

        }

        //when the loop is done close the scanner and end the game 
        scanner.close();
        System.exit(0);
    }

    /*method for cleaning the player's input, only returns character values in the return string and 
    turns them all into capital letters for later use 
    */
    public String stringClean(String string){
        int max = string.length();
        String ret = "";
        for(int i = 0; i < max; i++){
            char c = string.charAt(i);
                if(Character.isLetter(c)){
                    ret += c;
                }    
        }
        return ret.toString().toUpperCase();
    }

/* A method for printing the screen, takes a variety of inputs, all things that change depending on either the 
 * newly generated hand, the player's changed meld, etc. Updated each time the game loop runs. Uses the same loops
 * as Drew's Farkle game to print the menu correctly as shown in the example.
 */
public void printScreen(Die[] meld, Die[] hand, int[] countNumberOfDie, int currentScore, boolean isFarkle){

    for(int i = 0; i < 5; i++){
        System.out.println("");
    }
    System.out.print("Current Hand:  ");
    for (int i = 0; i < 6; i++){
        System.out.print(hand[i] + " ");
    }
    System.out.println("\n");
    System.out.print("Number of Each Die:  ");
    for (int i = 1; i < 7; i++){
        System.out.print(countNumberOfDie[i] + " ");
    }
    System.out.println("");
    System.out.println("*************************** Current hand and meld *******************");
    System.out.println(" Die   Hand |   Meld");
    System.out.println("-------------+-------------");
    
    for(int i = 0; i < 6; i++ ) {
        char option = (char) ('A' + i);
        System.out.print( " (" + option + ")    ");
        if(hand[i].getSideUp() != 0) {
            System.out.print(hand[i].getSideUp());
        } else {
            System.out.print(" ");
        }
        System.out.print("   |     ");
        if(meld[i].getSideUp() != 0) {
            System.out.println(meld[i].getSideUp());
        } else {
            System.out.println(" ");
        }
        System.out.println("");
    }

    System.out.println("");
    System.out.println(" (K) Bank Meld & End Round");
    System.out.println("");
    System.out.println(" (Q) Quit game");
    System.out.println("");
    if(isFarkle) {
        System.out.println("FARKLE! Game Over!");
        Game.gameRunning = false;
    } else {
    System.out.println("Current Score: " + currentScore);
    System.out.println("-------------+-------------");
    System.out.println("Enter letter choices: ");
    }
    

}

}
