
package main.java.edu.gonzaga.Farkle;
import edu.gonzaga.Farkle.Die;

public class Game {

    private boolean gameRunning = true;
    private boolean farkle = false;

    public void setFarkle() {
        this.farkle = false;
    }

    public void run() {
        while (gameRunning) {
            
            Hand hand = new Hand();
            hand.makeHand();
            System.out.println(hand.toString(hand.getHand()));

            farkle = true;

            if (farkle == true) {
                gameRunning = false;
            }
        }
    }
}


