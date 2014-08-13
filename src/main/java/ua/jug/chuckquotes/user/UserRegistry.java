package ua.jug.chuckquotes.user;

import ua.jug.chuckquotes.exceptions.UserNotExistException;
import ua.jug.chuckquotes.user.dao.HardCodedUserDao;
import ua.jug.chuckquotes.user.dao.UserDao;

public class UserRegistry {
    private UserDao dao;

    public UserRegistry() {
        this.dao = new HardCodedUserDao();
    }

    public boolean authenticate(String username, String password) throws UserNotExistException {
        return dao.authenticate(username, password);
    }
    public User getUser(String name) throws UserNotExistException {
        return dao.getUser(name);
    }
}
