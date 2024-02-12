
package main.java.edu.gonzaga.Farkle;
import edu.gonzaga.Farkle.Die;
import edu.gonzaga.Farkle.Hand;
import java.util.Arrays;

//scoreCard method, knows the current score and is able to calculate the current score and add it to the total for each player
public class scoreCard {

    private int score;
    private int DEFAULT_SCORE = 0;

    //constructor method for the scoreCard
    public scoreCard(){
        this.score = DEFAULT_SCORE;
    }

    //getter
    public int getScore(){
        return this.score;
    }

    //method for calculating the score if there are ones or fives in the meld, not called if these numbers are used in a combo
    public int addOneFive (int[] countDie) {
        int oneFiveScore = 0;
        if( countDie[1] < 3) {
            oneFiveScore += countDie[1] * 100;
        }

        if( countDie[5] < 3) {
            oneFiveScore += countDie[5] * 50;
        }
        return oneFiveScore;
    }

    //method for detecting the presence of a straight (1-6) in the meld, returns true if there is 
    public boolean isStraight(int[] countDie) {
        boolean isStraight = true;

            for(int i = 1; i < 7; i++) {
                if (countDie[i] != 1) {
                    isStraight = false;
                }
            }
        return isStraight;
    }

    //method that returns the number of pairs in the meld at any time
    public int numPairs(int[] countDie){
        int pairCount = 0;
            for( int i = 1; i < 7; i++ ) {
                if(countDie[i] == 2) {
                    pairCount++;
                }
            }
        return pairCount;
    }

    //method that returns true if there is a set of three numbers in the meld
    public boolean isTripleSet(int[] countDie){
        boolean isTripleSet = false;
            for( int i = 1; i < 7; i++ ) {
                if(countDie[i] >= 3) {
                    isTripleSet = true;
                }
            }
        return isTripleSet;
    }

    //method for calculating the score if "is triple set" returns true. 1000 if the set is of ones, otherwise calculates based on farkle rules.
    public int tripleSetScore(int[] countDie){
        int tripleSetPoints = 0;
            for( int i = 1; i < 7; i++ ) {
                if( countDie[i] >= 3 ) {    
                    tripleSetPoints = 0;
                    if(i == 1) {
                        tripleSetPoints = 1000;
                    } else {
                        tripleSetPoints = i * 100;
                        tripleSetPoints += (countDie[i] - 3) * 100 * i;
                    }
                        
                }
            }
        return tripleSetPoints;
    }

    /*method for changing the current score depending on which conditions are met. Compartmentalized using set detection and scoring methods 
    * shown above.
    */ 
    public void setScore(Die[] meld) {

        //tempScore used until player who receives score is determined 
        int tempScore = 0;
        //an array returning the number of each die in the meld, passed into detection and scoring methods to be parsed over.
        int[] countDie = {0, 0, 0, 0, 0, 0, 0};
        for( int i = 0; i < 6; i++ ) {
            countDie[meld[i].getSideUp()]++;
        }
        
        //using methods in order to determine score
        if(isStraight(countDie)) {
            tempScore += 1000;
        } else if (numPairs(countDie) == 3) {
            tempScore += 750;
        } else {
            tempScore += addOneFive(countDie);
        }
        if (isTripleSet(countDie)) {
            tempScore += tripleSetScore(countDie);
        }
        this.score = tempScore;
        Game.totalScorePlayer1 = tempScore;
    }
}

