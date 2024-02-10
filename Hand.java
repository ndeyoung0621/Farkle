
package main.java.edu.gonzaga.Farkle;
import edu.gonzaga.Farkle.Die;

public class Hand {

public Die[] makeHand(){

    Die[] currentHand = new Die[6];
    for(int i = 0; i < 6; i++){
        currentHand[i] = new Die();
        currentHand[i].roll();
    }

return currentHand;

}

public String toString(Die[] handToPrint) {
    String ret = "current hand = ";
    for(int i = 0; i < 6; i++){
    ret += handToPrint[i];
    }
return ret;
}

}