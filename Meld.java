
package main.java.edu.gonzaga.Farkle;
import edu.gonzaga.Farkle.Die;
import edu.gonzaga.Farkle.scoreCard;

public class Meld {

// A variable to store the current meld

private Die[] meld;
private Die[] DEFAULT_MELD = new Die[6]; 

//initializes the values of each die in the default meld
public void set_default_meld(){
    for(int i = 0; i < 6; i++){

            DEFAULT_MELD[i] = new Die(0);
        
    }
}

//What does meld do?
/*Should take the current hand and depending on the player's letter input,
* store that value in an array called meld. 
*/

    //Constructer method with default open value
    public Meld(){
        this.meld = DEFAULT_MELD;
    }

    //getter
    public Die[] getMeld(){
        return this.meld;
    }

    /* Method for changing the turn's meld to the player's input dice. To do this, the method takes the current hand and 
     * uses a switch case to change the values between the hand and meld depending on the input.
     */
    public void setMeld(String playerInput, Die[] hand){

        //temporary die with value 0 used to store the value of the meld in the chosen position so it is not lost in transition
        Die tempDie = new Die(0);

        //parses over the entirety of the player's input stream
        for(int i = 0; i < playerInput.length(); i++) {
            
            //turns each letter in the input to a one character string to be read more easily
            Character currentChar = playerInput.charAt(i);
            String selection = Character.toString(currentChar);

            /*switch case that takes each character and switches one of the dice positions depending on the input
            * also handles the cases where the player inputs either 'K' or 'Q', banking the score and quitting respectively
            */
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

                case("Q"):
                for(int j = 0; j < 20; j++){
                    System.out.println("");
                    if(j == 9){
                        System.out.println("THANK YOU FOR PLAYING !");
                    }
                }

                Game.gameRunning = false;

                break;

                case("K"):
                    System.out.println("ROUND OVER, TOTAL SCORE IS NOW: " + Game.totalScorePlayer1);
                    Game.gameRunning = false;
                break;
        
                default:
                    System.out.println("Error: invalid player input detected");
                break;
            }

        }

    }

    //override toString method for the current meld
    public String toString() {
        String ret = "current meld = ";
        for(int i = 0; i < 6; i++){
            ret += this.meld[i];
        }

        ret += "\n" + "               ";
            
    return ret;
    
    }

}