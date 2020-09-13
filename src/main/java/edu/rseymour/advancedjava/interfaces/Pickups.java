package edu.rseymour.advancedjava.interfaces;

/**
 * Interface to create guitar pickups.
 */

public interface Pickups {

    /**
     * The pickups must have magnetic pull to be functional.
     */
    public void testResistance();

    /**
     * The pickups must allow electricity to flow through the wires
     * and magnets continually.
     */
    public void testContinuity();
}
