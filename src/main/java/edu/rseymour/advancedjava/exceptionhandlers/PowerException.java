package edu.rseymour.advancedjava.exceptionhandlers;

/**
 * Exception that is thrown when the user tries to play a song
 * when a Guitar instance is not plugged in.
 */
public class PowerException extends Exception {

    public PowerException(){
        super();
    }

    public PowerException (String errorMessage) {
        super(errorMessage);
    }
}
