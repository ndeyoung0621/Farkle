
package main.java.edu.gonzaga.Farkle;
import edu.gonzaga.Farkle.Die;
import java.util.Scanner;

public class Game {

    private boolean gameRunning = true;
    private boolean farkle = false;
    Scanner scanner = new Scanner(System.in);

    public void setFarkle() {
        this.farkle = false;
    }

    public void run() {
        while (gameRunning) {
            
            Hand hand = new Hand();
            hand.makeHand();
            System.out.println(hand.toString(hand.getHand()) + "\n");
            Meld meld = new Meld();
            meld.set_default_meld();
            meld.setMeld("A", hand.getHand());
            System.out.println(meld.toString());
            farkle = true;

            if (farkle == true) {
                gameRunning = false;
            }
        }
    }
}


