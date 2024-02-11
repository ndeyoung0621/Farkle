
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
}

public Die[] getHand() {
    return this.currentHand;
}

public void sortHand(){
    Arrays.sort(this.currentHand, (die1, die2) -> Integer.compare(die1.getSideUp(), die2.getSideUp()));
}

public String toString(Die[] handToPrint) {
    String ret = "current hand = ";
    for(int i = 0; i < 6; i++){
    ret += handToPrint[i] + " ";
    }
return ret;
}

}