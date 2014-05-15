package ua.kpi.fpm.pma.oop.chuckquotes.user.dao;

import ua.kpi.fpm.pma.oop.chuckquotes.exceptions.UserNotExistException;
import ua.kpi.fpm.pma.oop.chuckquotes.user.User;

public interface UserDao {
    boolean authenticate(String login, String password) throws UserNotExistException;

    User getUser(String name) throws UserNotExistException;
}
