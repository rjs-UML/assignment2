package edu.rseymour.advancedjava.datamodels;

import edu.rseymour.advancedjava.interfaces.SetOfStrings;

public class ErnieBallStrings implements SetOfStrings {

    public ErnieBallStrings() {}

    @Override
    public void vibrate() {
        System.out.println("BARRAAAANNNNNNGGGGG!");
    };

}
