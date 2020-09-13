package edu.rseymour.advancedjava.exceptionhandlers;

/**
 * Exception that is thrown when the guitar has been
 * strummed 10,000 times. You must complete a
 * <CODE>Guitar#setup</CODE> when you receive this
 * exception.
 */
public class SetupException extends Exception {

    public SetupException(){
        super();
    }

    public SetupException (String errorMessage) {
        super(errorMessage);
    }
}