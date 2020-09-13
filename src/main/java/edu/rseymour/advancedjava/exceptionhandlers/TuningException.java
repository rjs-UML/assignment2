package edu.rseymour.advancedjava.exceptionhandlers;

/**
 * Exception that is thrown when the guitar has been
 * strummed 1,000 times. You must complete a
 * <CODE>Guitar#tuning</CODE> when you receive this
 * exception.
 */
public class TuningException extends Exception {

    public TuningException(){
        super();
    }

    public TuningException (String errorMessage) {
        super(errorMessage);
    }
}