
package main.java.edu.gonzaga.Farkle;
import edu.gonzaga.Farkle.Die;
import java.util.Scanner;

public class Meld {

//What does meld know?

/*A variable to store the current meld, a default meld of 0 a new scanner
* to take the player's input when meld is called.
*/
private int[] meld;
private int[] DEFAULT_MELD = {0, 0, 0, 0, 0, 0};
Scanner scanner = new Scanner(System.in);

//What does meld do?
/*Should take the current hand and depending on the player's letter input,
* store that value in an array called meld. 
*/

//Constructer method with default open value
public int[] defaultMeld(){

    this.meld = DEFAULT_MELD;
    return DEFAULT_MELD;
}

}