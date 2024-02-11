
package main.java.edu.gonzaga.Farkle;
import edu.gonzaga.Farkle.Die;

public class Hand {

private Die[] defaultHand = new Die[6];
private Die[] currentHand;

public Hand() {
    this.currentHand = defaultHand;
}

public void makeHand(){

    for(int i = 0; i < 6; i++){
        this.currentHand[i] = new Die();
        this.currentHand[i].roll();
    }

}

public Die[] getHand() {
    return this.currentHand;
}

public String toString(Die[] handToPrint) {
    String ret = "current hand = ";
    for(int i = 0; i < 6; i++){
    ret += handToPrint[i] + " ";
    }
return ret;
}

}