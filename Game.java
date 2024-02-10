
package main.java.edu.gonzaga.Farkle;
import edu.gonzaga.Farkle.Die;

public class Game {

    private boolean gameRunning = true;
    private boolean farkle = false;

    public void setFarkle() {
        this.farkle = false;
    }
    
    public void run() {
        while (gameRunning) {
            
            if (farkle == true) {
                gameRunning = false;
            }
        }
    }
}


