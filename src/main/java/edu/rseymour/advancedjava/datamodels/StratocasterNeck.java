package edu.rseymour.advancedjava.datamodels;

import edu.rseymour.advancedjava.interfaces.Neck;

/**
 * Class to create a Stratocaster-style electric guitar neck.
 */

public class StratocasterNeck implements Neck {

    /**
     * No-arg constructor.
     */
    public StratocasterNeck() {}

    @Override
    public void straighten(){
        System.out.println("Neck is straight.");
    }

    @Override
    public void dressFrets() {
        System.out.println("The frets are cleaned and even.");
    }
}
