
package main.java.edu.gonzaga.Farkle;
import edu.gonzaga.Farkle.Die;
import java.util.Scanner;

public class Meld {

//What does meld know?

/*A variable to store the current meld, and the current hand side by side
* the variable should switch the positions of the values left to right as the input is given
*/
private Die[] meld;
private Die[] DEFAULT_MELD = new Die[6]; 

public void set_default_meld(){
    for(int i = 0; i < 6; i++){

            DEFAULT_MELD[i] = new Die(0);
        
    }
}

Scanner scanner = new Scanner(System.in);

//What does meld do?
/*Should take the current hand and depending on the player's letter input,
* store that value in an array called meld. 
*/

//Constructer method with default open value
    public Meld(){
        this.meld = DEFAULT_MELD;
    }

    public Die[] getMeld(){
        return this.meld;
    }

    public void setMeld(String playerInput, Die[] hand){

        Die tempDie = new Die(0);

        for(int i = 0; i < playerInput.length(); i++) {
            
            Character currentChar = playerInput.charAt(i);
            String selection = Character.toString(currentChar);

            switch(selection) {
                case ("A"):
                    tempDie = this.meld[0];
                    this.meld[0] = hand[0];
                    hand[0] = tempDie;
                break;
                case("B"):
                    tempDie = this.meld[1];
                    this.meld[1] = hand[1];
                    hand[1] = tempDie;
                break;
                case("C"):
                    tempDie = this.meld[2];
                    this.meld[2] = hand[2];
                    hand[2] = tempDie;
                break;
                case("D"):
                    tempDie = this.meld[3];
                    this.meld[3] = hand[3];
                    hand[3] = tempDie;
                break;
                case("E"):
                    tempDie = this.meld[4];
                    this.meld[4] = hand[4];
                    hand[4] = tempDie;
                break;
                case("F"):
                    tempDie = this.meld[5];
                    this.meld[5] = hand[5];
                    hand[5] = tempDie;
                break;
        
                default:
                    System.out.println("Error: invalid player input detected");
                break;
            }

        }

    }

    public String toString() {
        String ret = "current meld = ";
        for(int i = 0; i < 6; i++){
            ret += this.meld[i];
        }

        ret += "\n" + "               ";
            
    return ret;
    
    }

}