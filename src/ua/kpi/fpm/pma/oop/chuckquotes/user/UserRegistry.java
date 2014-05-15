package ua.kpi.fpm.pma.oop.chuckquotes.user;

import ua.kpi.fpm.pma.oop.chuckquotes.exceptions.UserNotExistException;
import ua.kpi.fpm.pma.oop.chuckquotes.user.dao.HardCodedUserDao;
import ua.kpi.fpm.pma.oop.chuckquotes.user.dao.UserDao;

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
