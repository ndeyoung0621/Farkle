
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
            hand.sortHand();
            Meld meld = new Meld();
            meld.set_default_meld();
            int[] countDie = hand.countDie();

        while (gameRunning) {
            
            printScreen(meld.getMeld(), hand.getHand(), countDie);
            
            String playerInput = scanner.nextLine();
            playerInput = stringClean(playerInput);
            //System.out.println(playerInput);

            meld.setMeld(playerInput, hand.getHand());
            //farkle = true;

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


public void printScreen(Die[] meld, Die[] hand, int[] countNumberOfDie){

    for(int i = 0; i < 5; i++){
        System.out.println("");
    }
    System.out.print("Initial Roll:  ");
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
    System.out.println(" (K) BanK Meld & End Round");
    System.out.println(" (Q) Quit game");
    System.out.println("Enter letter choices: ");
    System.out.println("-------------+-------------");

}

}
