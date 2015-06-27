package ua.jug.chuckquotes.user.dao;

import ua.jug.chuckquotes.exceptions.UserNotExistException;
import ua.jug.chuckquotes.user.User;

import java.sql.*;

public class MySQLUserDao implements UserDao{
    @Override
    public boolean authenticate(String login, String password) throws UserNotExistException {
        final User user = getUser(login);
        return user.getName().equals(login) && user.getPassword().equals(password);
    }

    @Override
    public User getUser(String login) throws UserNotExistException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            final Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/chuck_quotes", "root", "root");

            final PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE username LIKE ?");
            preparedStatement.setString(1, login);
            final ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                final String username = resultSet.getString("username");
                final String password = resultSet.getString("password");

                return new User(username, password);
            }

        } catch (Exception e) {
            throw new UserNotExistException(login);
        }
        throw new UserNotExistException(login);
    }
}
