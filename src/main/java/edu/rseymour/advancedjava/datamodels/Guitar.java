package edu.rseymour.advancedjava.datamodels;

import edu.rseymour.advancedjava.exceptionhandlers.*;
import edu.rseymour.advancedjava.interfaces.*;

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

//    /**
//     * Class constructor that returns a Guitar instance consisting of a
//     * body, neck, set of strings, and pickups.
//     *
//     * Select the color of the guitar body from a predetermined set of Color
//     * values.
//     *
//     * Classes that extend Guitar must set values for strumCount, inTune, and
//     * isPluggedIn during instantiation.
//     *
//     * @param body the shape or style of the guitar. Contains bridge.
//     * @param neck the shape or style of the neck. Can be straightened.
//     *             Contains frets that can be cleaned and filed to ensure
//     *             levelness. Contains tuning pegs to attach and tune strings.
//     * @param setOfStrings set of 6 guitar strings attached to the tuning pegs
//     *                     on the guitar neck and the bridge on the guitar body.
//     * @param pickups set of magnetic pickups that capture string vibrations as
//     *                electric signals and send those signals to an amplifier.
//     * @param color the color of the electric guitar body.
//     */
//    public Guitar(
//            Body body,
//            Neck neck,
//            SetOfStrings setOfStrings,
//            Pickups pickups,
//            BodyColors color,
//            int strumCount,
//            boolean isInTune,
//            boolean isPluggedIn)
//    {
//        this.body = body;
//        this.neck = neck;
//        this.setOfStrings = setOfStrings;
//        this.pickups = pickups;
//        this.color = color;
//        this.strumCount = 0;
//        this.isInTune = true;
//        this.isPluggedIn = false;
//    }


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
