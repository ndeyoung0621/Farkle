
package main.java.edu.gonzaga.Farkle;
import edu.gonzaga.Farkle.Die;
import java.util.Scanner;

public class Game {

    public static boolean gameRunning = true;
    public static int totalScorePlayer1 = 0;
    private boolean farkle = false;
    Scanner scanner = new Scanner(System.in);


    public void run() {

            Hand hand = new Hand();
            hand.sortHand();
            Meld meld = new Meld();
            meld.set_default_meld();
            int[] countDie = hand.countDie();
            scoreCard scoreCard = new scoreCard();
            boolean isFarkle = hand.farkleChecker();

        while (gameRunning) {
            
            printScreen(meld.getMeld(), hand.getHand(), countDie, scoreCard.getScore(), isFarkle);
            
            String playerInput = scanner.nextLine();
            playerInput = stringClean(playerInput);

            meld.setMeld(playerInput, hand.getHand());

            scoreCard.setScore(meld.getMeld());

        }
        scanner.close();
        System.exit(0);
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


public void printScreen(Die[] meld, Die[] hand, int[] countNumberOfDie, int currentScore, boolean isFarkle){

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
