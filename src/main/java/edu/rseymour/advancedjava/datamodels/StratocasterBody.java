package edu.rseymour.advancedjava.datamodels;

import edu.rseymour.advancedjava.interfaces.Body;

public class StratocasterBody implements Body {

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
