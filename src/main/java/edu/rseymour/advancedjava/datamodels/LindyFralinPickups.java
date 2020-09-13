package edu.rseymour.advancedjava.datamodels;

import edu.rseymour.advancedjava.interfaces.Pickups;

/**
 * Class to create a set of Lindy Fralin pickups for electric guitars.
 */

public class LindyFralinPickups implements Pickups {

    /**
     * No-arg constructor.
     */
    public LindyFralinPickups() {}

    @Override
    public void testResistance() {
        System.out.println("Resistance test: PASSED.");
    };

    @Override
    public void testContinuity() {
        System.out.println("Continuity test: PASSED.");
    };
}
