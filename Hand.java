
package main.java.edu.gonzaga.Farkle;
import edu.gonzaga.Farkle.Die;
import java.util.Arrays;

public class Hand implements Comparable<Die> {

private Die[] defaultHand = new Die[6];
private Die[] currentHand;

public Hand() {
    this.currentHand = defaultHand;
    for(int i = 0; i < 6; i++){
        this.currentHand[i] = new Die();
        this.currentHand[i].roll();
    }
    this.currentHand[0].setSideUp(2);
    this.currentHand[1].setSideUp(2);
    this.currentHand[2].setSideUp(3);
    this.currentHand[3].setSideUp(3);
    this.currentHand[4].setSideUp(4);
    this.currentHand[5].setSideUp(6);

    
}

public Die[] getHand() {
    return this.currentHand;
}

public void sortHand(){
    Arrays.sort(this.currentHand, (die1, die2) -> Integer.compare(die1.getSideUp(), die2.getSideUp()));
}

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


public String toString(Die[] handToPrint) {
    String ret = "current hand = ";
    for(int i = 0; i < 6; i++){
    ret += handToPrint[i] + " ";
    }
return ret;
}

}