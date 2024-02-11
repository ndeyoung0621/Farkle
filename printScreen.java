package main.java.edu.gonzaga.Farkle;
import edu.gonzaga.Farkle.Die;

public class printScreen {
    public void go(Die[] meld, Die[] hand, int[] countNumberOfDie){

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