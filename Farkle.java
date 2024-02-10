
package edu.gonzaga.Farkle;
import main.java.edu.gonzaga.Farkle.Hand;
import main.java.edu.gonzaga.Farkle.PrintMenu;

/*
*  This is the main class for the Farkle project.
*  It really should just instantiate another class and run
*   a method of that other class.
*/

/** Main program class for launching Farkle program. */
public class Farkle {
    // This main is where your Farkle game starts execution for general use.
    public static void main(String[] args) {

        PrintMenu printMenu = new PrintMenu();
        Hand hand = new Hand();
        Die[] gameHand = new Die[6];
        printMenu.printMenu(hand.handToString(gameHand)); 

        

    }
}
