package edu.rseymour.advancedjava;

import edu.rseymour.advancedjava.datamodels.*;
import edu.rseymour.advancedjava.exceptionhandlers.PowerException;
import edu.rseymour.advancedjava.exceptionhandlers.SetupException;
import edu.rseymour.advancedjava.exceptionhandlers.TuningException;
import edu.rseymour.advancedjava.interfaces.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * JUnit tests for ElectricGuitar class.
 *
 * @author Ryan Seymour
 */

public class ElectricGuitarTest {

    /**
     * Instantiate objects for global use in tests.
     */
    Body stratBody;
    Neck stratNeck;
    SetOfStrings ernieBalls;
    SetOfStrings newStrings;
    Pickups fralins;
    Guitar myStrat;

    /**
     * Configures an ElectricGuitar instance to run JUnit tests. Creates and injects objects
     * using the following interfaces: a body, neck, pickups, and set of strings. The
     * ElectricGuitar constructor selects a BodyColor, sets the strumCount to 0, sets
     * inTune to true, and sets isPluggedIn to false.
     */
    @Before
    public void setup() {
        stratBody = new StratocasterBody();
        stratNeck = new StratocasterNeck();
        ernieBalls = new ErnieBallStrings();
        newStrings = new ErnieBallStrings();
        fralins = new LindyFralinPickups();
        myStrat = new ElectricGuitar(
                stratBody,
                stratNeck,
                ernieBalls,
                fralins,
                BodyColors.SUNBURST
        );
    }

    /**
     * Tests that strumCount is properly set during ElectricGuitar
     * instantiation.
     */
    @Test
    public void constructorStrumTest() {
        Assert.assertEquals(0, myStrat.getStrumCount());
    }

    /**
     * Tests that inTune is properly set during ElectricGuitar
     * instantiation.
     */
    @Test
    public void constructorInTuneTest() {
        boolean test = myStrat.isInTune();
        Assert.assertTrue(test);
    }

    /**
     * Tests that isPluggedIn is properly set to false
     * during ElectricGuitar instantiation.
     */
    @Test
    public void constructorIsPluggedIn() {
        Assert.assertFalse(myStrat.isPluggedIn());
    }


    /**
     * Tests that the strumCount is set to 0 when {@link ElectricGuitar#setup(SetOfStrings)}
     * is called.
     */
    @Test
    public void setupStrumCountTest() throws PowerException, SetupException, TuningException  {
        myStrat.setPluggedIn(true);
        myStrat.playSong();
        myStrat.setup(newStrings);
        Assert.assertEquals(0, myStrat.getStrumCount());
    }

    /**
     * Tests that the totalStrumCount is set to 0 when {@link ElectricGuitar#setup(SetOfStrings)}
     * is called.
     */
    @Test
    public void setupTotalStrumCountTest() throws PowerException, SetupException, TuningException {
        myStrat.setPluggedIn(true);
        myStrat.playSong();
        myStrat.setup(newStrings);
        Assert.assertEquals(0, myStrat.getTotalStrumCount());
    }

    /**
     * Tests that isInTune is set to true when {@link ElectricGuitar#setup(SetOfStrings)}
     * is called.
     */
    @Test
    public void setupInTuneTest() throws PowerException, SetupException, TuningException {
        myStrat.setPluggedIn(true);
        myStrat.playSong();
        myStrat.setup(newStrings);
        Assert.assertTrue(myStrat.isInTune());
    }

    /**
     * Tests that isPluggedIn is set to false when {@link ElectricGuitar#setup(SetOfStrings)}
     * is called.
     */
    @Test
    public void setupIsPluggedInTest() throws PowerException, SetupException, TuningException {
        myStrat.setPluggedIn(true);
        myStrat.playSong();
        myStrat.setup(newStrings);
        Assert.assertFalse(myStrat.isPluggedIn());
    }

    /**
     * Tests that {@link ElectricGuitar#tune()} sets the strumCount to 0.
     */
    @Test
    public void tuneTest() throws PowerException, SetupException, TuningException {
        myStrat.setPluggedIn(true);
        myStrat.playSong();
        myStrat.playSong();
        myStrat.playSong();
        myStrat.tune();
        Assert.assertEquals(0, myStrat.getStrumCount());
    }

    /**
     * Tests that a PowerException is thrown if {@link ElectricGuitar#playSong()} is called
     * and isPluggedIn is false.
     *
     * @throws PowerException is thrown when you try to play a song but
     * isPluggedIn is set to false.
     * @throws SetupException is thrown when the ElectricGuitar instance was played
     * so much that it requires a setup.
     * @throws TuningException is thrown when the guitar is out of tune. The guitar goes
     * out of tune after {@link ElectricGuitar#playSong()} is called 3 times.
     */
    @Test (expected = PowerException.class)
    public void playSongIsPluggedInExceptionTest() throws PowerException, SetupException, TuningException {
        myStrat.playSong();
    }

    /**
     * Tests that a TuningException is thrown if {@link ElectricGuitar#playSong()} is called
     * enough times that the ElectricGuitar instance requires that you call
     * {@link ElectricGuitar#tune()} to play more songs.
     *
     * @throws TuningException is thrown when the guitar is out of tune. The guitar goes
     * out of tune after {@link ElectricGuitar#playSong()} is called 3 times.
     */
    @Test (expected = TuningException.class)
    public void playSongIsInTuneExceptionTest() throws PowerException, SetupException, TuningException {
        // Exception if inTune = false
        myStrat.setPluggedIn(true);
        myStrat.playSong();
        myStrat.playSong();
        myStrat.playSong();
        myStrat.playSong();
    }

    /**
     * Tests that an ElectricGuitar instance can play 3 songs before throwing a
     * TuningException.
     */
    @Test
    public void playSongInTuneFalse1500Test() throws PowerException, SetupException, TuningException {
        // inTune set to false if strumCount % 1500 == 0
        myStrat.setPluggedIn(true);
        myStrat.playSong();
        myStrat.playSong();
        myStrat.playSong();
        Assert.assertTrue(myStrat.isInTune());
    }

    /**
     * Tests that the ElectricGuitar instance can play a song with
     * totalStrumCount equal to 10,000.
     */
    @Test
    public void playSongAt10000StrumsTest() throws PowerException, SetupException, TuningException {
        myStrat.setPluggedIn(true);
        for (int i = 0; i < 20; i++) {
            if (i % 3 == 0)
                myStrat.tune();
            myStrat.playSong();
        }
        Assert.assertEquals(10000, myStrat.getTotalStrumCount());
    }

    /**
     * Tests that a SetupException is thrown after the ElectricGuitar instance
     * reaches more than 10,000 total strums.
     *
     * @throws SetupException is thrown when the ElectricGuitar instance was played
     * so much that it requires a setup.
     */
    @Test (expected = SetupException.class)
    public void playSongAtHigherThan10000StrumsExceptionTest() throws PowerException, SetupException, TuningException {
        myStrat.setPluggedIn(true);
        for (int i = 0; i < 21; i++) {
            if (i % 3 == 0)
                myStrat.tune();
            myStrat.playSong();
        }
    }
}
