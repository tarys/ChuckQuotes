package ua.jug.chuckquotes.exceptions;

public class QuoteException extends Exception {

    public QuoteException(Exception e) {
        super(e);
    }

    public QuoteException(String message) {
        super(message);
    }
}
