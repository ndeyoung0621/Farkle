
package main.java.edu.gonzaga.Farkle;
import edu.gonzaga.Farkle.Die;
public class Hand {

public String handToString(Die currentHand[]){
    
    String ret = "Current Hand: ";

    for(int i = 0; i < 6; i++){
        currentHand[i] = new Die();
        currentHand[i].roll();
        ret += currentHand[i] + " ";
    }

    return ret;
}

}