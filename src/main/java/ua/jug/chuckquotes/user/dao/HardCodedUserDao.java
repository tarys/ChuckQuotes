package ua.jug.chuckquotes.user.dao;

import ua.jug.chuckquotes.exceptions.UserNotExistException;
import ua.jug.chuckquotes.user.User;

import java.util.HashMap;
import java.util.Map;

public class HardCodedUserDao implements UserDao {

    private Map<String, User> userMap;

    public HardCodedUserDao() {
        this.userMap = new HashMap<>();
        this.userMap.put("Chuck", new User("Chuck", "Sobchuck"));
        this.userMap.put("user", new User("user", "password"));
    }

    @Override
    public boolean authenticate(String username, String password) throws UserNotExistException {
        final User user = getUser(username);
        return checkPassword(user, password);
    }

    @Override
    public User getUser(String name) throws UserNotExistException {
        if (!userMap.containsKey(name)) {
            throw new UserNotExistException(name);
        }
        return userMap.get(name);
    }

    private boolean checkPassword(User user, String password) {
        return user.getPassword().equals(password);
    }

}
