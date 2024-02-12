
package edu.gonzaga.Farkle;
import main.java.edu.gonzaga.Farkle.Hand;
import main.java.edu.gonzaga.Farkle.Game;

/*
*  This is the main class for the Farkle project.
*  It just instantiates another class and runs
*  a method of that other class.
*/

/** Main program class for launching Farkle program. */
public class Farkle {
    // This main is where my Farkle game starts execution for general use.
    public static void main(String[] args) {

        Game game = new Game();
        game.run();

    }
}
