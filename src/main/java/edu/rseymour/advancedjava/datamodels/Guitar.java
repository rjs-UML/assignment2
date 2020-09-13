package edu.rseymour.advancedjava.datamodels;

import edu.rseymour.advancedjava.exceptionhandlers.*;
import edu.rseymour.advancedjava.interfaces.*;

/**
 * Abstract class for a Guitar instance.
 */

public abstract class Guitar {

    private int strumCount;
    private int totalStrumCount;
    private boolean isInTune;
    private boolean isPluggedIn;


    private Body body;
    private Neck neck;
    private SetOfStrings setOfStrings;
    private Pickups pickups;
    private BodyColors color;

    /**
     * Private no-argument constructor
     */
    public Guitar(){};

    public abstract void setup(SetOfStrings newStrings);

    public abstract void restring(SetOfStrings newStrings);

    public abstract void tune();

    public abstract void playSong() throws PowerException, SetupException, TuningException;

    public abstract int getStrumCount();

    private void setStrumCount(int strumCount) {
        this.strumCount = strumCount;
    }

    public abstract int getTotalStrumCount();

    private void setTotalStrumCount(int totalStrumCount) {
        this.totalStrumCount = totalStrumCount;
    }

    public abstract boolean isInTune();

    private void setIsInTune(boolean value) {
        isInTune = value;
    }

    public abstract boolean isPluggedIn();

    public abstract void setPluggedIn(boolean pluggedIn);
}
