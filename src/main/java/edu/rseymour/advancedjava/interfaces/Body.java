package edu.rseymour.advancedjava.interfaces;

/**
 * Interface to create a guitar body.
 */

public interface Body {

    /**
     * The guitar body must be made of a resonate material to
     * produce sound.
     */
    public void resonate();

    /**
     * Raise or lower the string saddles on the bridge to adjust
     * the action (distance of guitar strings from the frets on the
     * neck).
     */
    public void setActionOnBridge();

    /**
     * Polish the guitar when performing a setup or cleaning.
     */
    public void polish();
}
