
package main.java.edu.gonzaga.Farkle;
import edu.gonzaga.Farkle.Die;
import java.util.Scanner;

public class Meld {

//What does meld know?

/*A variable to store the current meld, and the current hand side by side
* the variable should switch the positions of the values left to right as the input is given
*/
private Die[][] meld;
private Die[][] DEFAULT_MELD = new Die[6][2]; 

public void set_default_meld(){
    for(int i = 0; i < 2; i++){
        for(int j = 0; j < 6; j++){
            DEFAULT_MELD[i][j] = new Die(0);
        }
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

    public void setMeld(String playerInput, Die[] hand){

        Die tempDie = new Die(0);
            switch(playerInput) {
                case ("A"):
                    tempDie = this.meld[1][1];
                    this.meld[1][1] = hand[1];
                    hand[1] = tempDie;
                break;
                case("B"):
                    this.meld[1][2] = hand[2];
                    hand[2] = 0;
                break;
                case("C"):
                    this.meld[1][3] = hand[3];
                    hand[3] = 0;
                break;
                case("D"):
                    this.meld[1][4] = hand[4];
                    hand[4] = 0;
                break;
                case("E"):
                    this.meld[1][5] = hand[5];
                    hand[5] = 0;
                break;
                case("F"):
                    this.meld[1][6] = hand[6];
                    hand[6] = 0;
                break;
        
                default:
                    System.out.println("Error: invalid player input detected");
                break;
            }
        }

    public String toString() {
        String ret = "current meld = ";
        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 6; j++) {
                //ret += handToPrint[i] + " ";
                ret += this.meld[i][j];
            }
            ret += "\n" + "               ";
            
        }
    return ret;
    }

}