package edu.rseymour.advancedjava.datamodels;

import edu.rseymour.advancedjava.interfaces.SetOfStrings;

/**
 * Class to create a set of 6 Ernie Ball brand guitar strings to add to a guitar.
 */

public class ErnieBallStrings implements SetOfStrings {

    /**
     * No-arg constructor
     */
    public ErnieBallStrings() {}

    @Override
    public void vibrate() {
        System.out.println("BARRAAAANNNNNNGGGGG!");
    };

}
