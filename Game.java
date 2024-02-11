
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
            Hand hand = new Hand();
            hand.makeHand();
            System.out.println(hand.toString(hand.getHand()) + "\n");
            Meld meld = new Meld();
            meld.set_default_meld();
        while (gameRunning) {
            
            String playerInput = scanner.nextLine();
            playerInput = stringClean(playerInput);
            System.out.println(playerInput);
            meld.setMeld(playerInput, hand.getHand());
            System.out.println(meld.toString());
            farkle = true;

            if (farkle == true) {
                gameRunning = false;
            }
        }
    }

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
}


