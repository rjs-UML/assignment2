package edu.rseymour.advancedjava.datamodels;

import edu.rseymour.advancedjava.interfaces.Pickups;

public class LindyFralinPickups implements Pickups {

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
