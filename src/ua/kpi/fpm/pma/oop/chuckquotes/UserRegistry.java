package ua.kpi.fpm.pma.oop.chuckquotes;

import ua.kpi.fpm.pma.oop.chuckquotes.dao.HardCodedUserDao;
import ua.kpi.fpm.pma.oop.chuckquotes.dao.UserDao;
import ua.kpi.fpm.pma.oop.chuckquotes.dao.UserNotExistException;

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
