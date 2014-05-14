package ua.kpi.fpm.pma.oop.chuckquotes.dao;

import ua.kpi.fpm.pma.oop.chuckquotes.User;

public interface UserDao {
    boolean authenticate(String login, String password) throws UserNotExistException;

    User getUser(String name) throws UserNotExistException;
}
