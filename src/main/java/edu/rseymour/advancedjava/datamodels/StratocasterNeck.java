package edu.rseymour.advancedjava.datamodels;

import edu.rseymour.advancedjava.interfaces.Neck;

public class StratocasterNeck implements Neck {

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
