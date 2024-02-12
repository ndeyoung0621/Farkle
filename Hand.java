
package main.java.edu.gonzaga.Farkle;
import edu.gonzaga.Farkle.Die;
import java.util.Arrays;

//this class knows its own state, it takes an array of 6 die and can modify, return, and examine itself
public class Hand implements Comparable<Die> {

private Die[] defaultHand = new Die[6];
private Die[] currentHand;

//constructer for "hand", initializes each of the 6 die in hand to a random value 1-6 using "roll" from 'Die'
public Hand() {
    this.currentHand = defaultHand;
    for(int i = 0; i < 6; i++){
        this.currentHand[i] = new Die();
        this.currentHand[i].roll();
    }

}

//Getter
public Die[] getHand() {
    return this.currentHand;
}

//Uses the sort method from java's "arrays" library to sort the array by comparing the provided values 
public void sortHand(){
    Arrays.sort(this.currentHand, (die1, die2) -> Integer.compare(die1.getSideUp(), die2.getSideUp()));
}

/*Returns an array of integer values for multiple future uses, the array contains the number of each value showing 
*on the hand of Die. i.e. a hand with two die that rolled "1" will return "2" in the first value slot
*/
public int[] countDie(){

int[] countNumberOfDie = new int[7];

for (int i = 0; i < 7; i++){
    countNumberOfDie[i] = 0;
}

for (int i = 0; i < 6; i++){
    countNumberOfDie[this.currentHand[i].getSideUp()]++;
}

return countNumberOfDie;

}

/* Method that returns a boolean; true if none of the scoring opportunities in the game are hit resulting in a "farkle"
 * used later to print the "Farkle, game over" message and end the turn if a farkle is hit.
 */
public boolean farkleChecker(){
    boolean isFarkle = true;
    int pairCount = 0;
    int[] numDie = countDie();
    if(numDie[1] != 0 || numDie[5] != 0) {
        isFarkle = false;
    }
    for( int i = 2; i < 7; i++ ) {
        if(numDie[i] >= 3) {
            isFarkle = false;
        }
    }
    for( int i = 1; i < 7; i++ ) {
        if(numDie[i] == 2) {
            pairCount++;
        }
    }
    if( pairCount == 3 ) {
        isFarkle = false;
    }
    return isFarkle;
}

//a override method used for printing the current hand
public String toString(Die[] handToPrint) {
    String ret = "current hand = ";
    for(int i = 0; i < 6; i++){
    ret += handToPrint[i] + " ";
    }
return ret;
}

}