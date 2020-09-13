package edu.rseymour.advancedjava;

import edu.rseymour.advancedjava.datamodels.*;
import edu.rseymour.advancedjava.exceptionhandlers.*;
import edu.rseymour.advancedjava.interfaces.*;

/**
 * The Guitar class creates a guitar consisting of a body, neck,
 * set of strings, and pickups.
 *
 * A Guitar instance can plug in, unplug, and make noise when it
 * is strummed.
 */

public class ElectricGuitar extends Guitar {

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
    private ElectricGuitar() {};

    /**
     * Class constructor that returns an ElectricGuitar instance consisting of a
     * body, neck, set of strings, and pickups.
     *
     * Select the color of the guitar body from a predetermined set of Color
     * values.
     *
     * strumCount is set to 0, inTune is set to true, and isPluggedIn is set
     * to false.
     *
     * @param body the shape or style of the guitar. Contains bridge.
     * @param neck the shape or style of the neck. Can be straightened.
     *             Contains frets that can be cleaned and filed to ensure
     *             levelness. Contains tuning pegs to attach and tune strings.
     * @param setOfStrings set of 6 guitar strings attached to the tuning pegs
     *                     on the guitar neck and the bridge on the guitar body.
     * @param pickups set of magnetic pickups that capture string vibrations as
     *                electric signals and send those signals to an amplifier.
     * @param color the color of the electric guitar body.
     */
    public ElectricGuitar(
            Body body,
            Neck neck,
            SetOfStrings setOfStrings,
            Pickups pickups,
            BodyColors color
    )
    {
        this.body = body;
        this.neck = neck;
        this.setOfStrings = setOfStrings;
        this.pickups = pickups;
        this.color = color;
        setStrumCount(0);
        setTotalStrumCount(0);
        setIsInTune(true);
        setPluggedIn(false);
    }

    /**
     * Configures the electric guitar for playing. Sets action,
     * straightens the neck, levels the frets, tests the pickups,
     * tunes the guitar to standard tuning, and sets strumCount
     * to 0.
     */
    @Override
    public void setup(SetOfStrings newStrings) {
        body.setActionOnBridge();
        body.polish();
        neck.straighten();
        neck.dressFrets();
        pickups.testResistance();
        pickups.testContinuity();
        restring(newStrings);
        setStrumCount(0);
        setTotalStrumCount(0);
        tune();
        setPluggedIn(false);
    };

    /**
     * Replaces existing setOfStrings with a new setOfStrings.
     * @param newStrings new SetOfStrings object to replace existing
     *                   SetOfStrings object to complete restring.
     */
    public void restring(SetOfStrings newStrings) {
        this.setOfStrings = null;
        this.setOfStrings = newStrings;
        tune();
    }

    /**
     * Tunes the electric guitar. Tunes the strings, then the
     * body resonates and the strings vibrate through the
     * pickups to produce sound.
     *
     */
    public void tune() {
        setIsInTune(true);
        setStrumCount(0);
    }

    /**
     * Plays a song on the guitar. inTune and isPluggedIn
     * must both equal true to play a song.
     *
     * Each song equals 500 strums. After 3 songs are played,
     * you must tune the guitar or a <CODE>TuningException</CODE>
     * is thrown. After 10,000 strums, you must tune the guitar
     * or a <CODE>TuningException</CODE> is thrown.
     *
     * @throws PowerException is thrown when you try to play a song but
     * isPluggedIn is set to false.
     * @throws SetupException is thrown when the ElectricGuitar instance was played
     * so much that it requires a setup.
     * @throws TuningException is thrown when the guitar is out of tune. The guitar goes
     * out of tune after {@link ElectricGuitar#playSong()} is called 3 times.
     */
    @Override
    public void playSong() throws PowerException, SetupException, TuningException {
        if (!isPluggedIn) throw new PowerException("You need to plug in!");
        if(!isInTune) throw new TuningException("You're out of tune!");

        if (getStrumCount() != 0 && getStrumCount() % 1500 == 0){
            setIsInTune(false);
            throw new TuningException("You're out of tune!");
        }
        else if (getTotalStrumCount() <= 9500) {
            System.out.println("Playing the song");
            strumCount += 500;
            totalStrumCount += 500;
        } else if (getTotalStrumCount() >= 10000) {
            setIsInTune(false);
            setPluggedIn(false);
            throw new SetupException("Cannot play. Need a setup.");
        }
    };

    /**
     * @return current strumCount value.
     */
    public int getStrumCount() {
        return strumCount;
    }

    /**
     * Set strumCount value.
     * @param strumCount number of strums played on the guitar since
     *                   the last time <CODE>tuneUp</CODE> or
     *                   <CODE>setUp</CODE> was called.
     */
    private void setStrumCount(int strumCount) {
        this.strumCount = strumCount;
    }

    public int getTotalStrumCount() {
        return totalStrumCount;
    }

    private void setTotalStrumCount(int totalStrumCount) {
        this.totalStrumCount = totalStrumCount;
    }

    /**
     * @return if the ElectricGuitar instance is currently in tune.
     */
    public boolean isInTune() {
        return isInTune;
    }

    /**
     * Tunes the ElectricGuitar instance so you can play songs.
     * @param value is true if the guitar is ready to play songs.
     */
    private void setIsInTune(boolean value) {
        isInTune = value;
    }

    /**
     * @return if the ElectricGuitar instance is plugged in.
     */
    public boolean isPluggedIn() {
        return isPluggedIn;
    }

    /**
     * Connects an ElectricGuitar instance to an amplifier.
     * @param pluggedIn is true if the electric guitar is plugged in.
     */
    public void setPluggedIn(boolean pluggedIn) {
        isPluggedIn = pluggedIn;
    }
}
