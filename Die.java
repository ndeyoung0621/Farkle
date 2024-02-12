/* (C)2021 */

package edu.gonzaga.Farkle;

/*
* Class for a Die used in Farkle.
*/

import java.util.Random;

/** Class to store the state of a single die. */
public class Die {

   
    //private Integer numSides; // Sides on the die (should be 1...INF integer)
    //private static final Integer DEFAULT_NUM_SIDES = 6;
    private Integer sideUp; // Current die 'value' in range 1..numSides
    private static final Integer DEFAULT_SIDE_UP = 1;

    public Die() {
        this.sideUp = DEFAULT_SIDE_UP;
    }

    public Die(Integer startingSide) {
        this.sideUp = startingSide;
    }

    public void setSideUp(int value){
        this.sideUp = value;
    }
    /** Rolls the die once, getting new random value. */
    public void roll() {
        Random rand = new Random();
        this.sideUp = rand.nextInt(6) + 1;
    }

    /**
    * Returns current die value (the side that's up).
    *
    * @return Integer Current Die's Side Up
    */
    public Integer getSideUp() {
        return this.sideUp;
    }

    /**
    * Provides the ability to convert the Die object into a string. representation, both with
    * .toString(), but also in System.out.println()
    *
    * @return String of whatever you want this die to say for itself
    */
    @Override
    public String toString() {
        String ret = "";
        // ret += "Die: " + this.sideUp.toString() + " of " + this.numSides.toString() + " sides";
        ret += this.sideUp.toString();
        return ret;
    }

    /**
    * Makes two dice comparable using <, ==, >, etc. based on sideUp values.
    *
    * @param otherDie The die we're comparing to this one (two objects)
    * @return int -1, 0, 1 for less than, equal, greater than
    */
    @Override
    public int compareTo(Die otherDie) {
        return this.sideUp.compareTo(otherDie.sideUp);
    }
}
