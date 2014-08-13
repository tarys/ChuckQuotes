package ua.jug.chuckquotes.exceptions;

public class UserNotExistException extends Exception {
    public UserNotExistException(String login) {
        super(String.format("User '%s' does not exist in system. Do not make Chuck being nervous!", login));
    }
}
