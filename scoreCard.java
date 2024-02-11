
package main.java.edu.gonzaga.Farkle;
import edu.gonzaga.Farkle.Die;
import edu.gonzaga.Farkle.Hand;
import java.util.Arrays;


public class scoreCard {

    private int score;
    private int DEFAULT_SCORE = 0;

    public scoreCard(){
        this.score = DEFAULT_SCORE;
    }

    public int getScore(){
        return this.score;
    }

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

    public boolean isStraight(int[] countDie) {
        boolean isStraight = true;

            for(int numDie : countDie) {
                if (numDie != 1) {
                    isStraight = false;
                }
            }
        return isStraight;
    }

    public int numPairs(int[] countDie){
        int pairCount = 0;
            for( int i = 1; i < 7; i++ ) {
                if(countDie[i] == 2) {
                    pairCount++;
                }
            }
        return pairCount;
    }

    public boolean isTripleSet(int[] countDie){
        boolean isTripleSet = false;
            for( int i = 1; i < 7; i++ ) {
                if(countDie[i] >= 3) {
                    isTripleSet = true;
                }
            }
        return isTripleSet;
    }

    public int tripleSetScore(int[] countDie){
        int tripleSetPoints = 0;
            for( int i = 1; i < 7; i++ ) {
                if( countDie[i] >= 3 ) {    
                    tripleSetPoints = 0;
                    if(i == 1) {
                        tripleSetPoints = 1000;
                    } else {
                        tripleSetPoints = i * 100;
                    }
                    if( countDie[i] > 3 ) {
                        tripleSetPoints += (countDie[i] - 3) * 100 * i;
                    }
                        
                }
            }
        return tripleSetPoints;
    }

    public void setScore(Die[] meld) {
        int tempScore = 0;
        int[] countDie = {0, 0, 0, 0, 0, 0, 0};
        for( int i = 0; i < 6; i++ ) {
            countDie[meld[i].getSideUp()]++;
        }
        
        if(isStraight(countDie)) {
            tempScore += 1000;
        } else if (numPairs(countDie) == 3) {
            tempScore += 750;
        } else if (isTripleSet(countDie)) {
            tempScore += tripleSetScore(countDie);
        } else {
            tempScore += addOneFive(countDie);
        }

        this.score = tempScore;
        Game.totalScorePlayer1 = tempScore;
    }
}

