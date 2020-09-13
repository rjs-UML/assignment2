package edu.rseymour.advancedjava.datamodels;

import edu.rseymour.advancedjava.interfaces.Body;

/**
 * Class to create a Stratocaster-style electric guitar body.
 */

public class StratocasterBody implements Body {

    /**
     * No-arg constructor.
     */
    public StratocasterBody() {}

    @Override
    public void resonate() {
        System.out.println("BARRRAAAAANNNNNNGGGGGG!");
    }

    @Override
    public void setActionOnBridge(){
        System.out.println("Action is set");
    }

    @Override
    public void polish() {
        System.out.println("Body is polished.");
    }
}
