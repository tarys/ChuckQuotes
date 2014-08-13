package ua.jug.chuckquotes.user.dao;

import ua.jug.chuckquotes.exceptions.UserNotExistException;
import ua.jug.chuckquotes.user.User;

public interface UserDao {
    boolean authenticate(String login, String password) throws UserNotExistException;

    User getUser(String name) throws UserNotExistException;
}
