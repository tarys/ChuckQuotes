package ua.kpi.fpm.pma.oop.chuckquotes;

import org.junit.Assert;
import org.junit.Test;
import ua.kpi.fpm.pma.oop.chuckquotes.exceptions.UserNotExistException;
import ua.kpi.fpm.pma.oop.chuckquotes.user.UserRegistry;

public class UserRegistryTest {
    @Test
    public void testAuthenticateChuck() throws Exception {
        final UserRegistry userRegistry = new UserRegistry();
        Assert.assertTrue(userRegistry.authenticate("Chuck", "Sobchuck"));
    }
    @Test
    public void testAuthenticateUser() throws Exception {
        final UserRegistry userRegistry = new UserRegistry();
        Assert.assertTrue(userRegistry.authenticate("user", "password"));
    }
    @Test
    public void testNotAuthenticateUserWithWrongPassword() throws Exception {
        final UserRegistry userRegistry = new UserRegistry();
        Assert.assertFalse(userRegistry.authenticate("user", "wrong password"));
    }

    @Test(expected = UserNotExistException.class)
    public void testAuthenticateUserNotExistException() throws Exception {
        final UserRegistry userRegistry = new UserRegistry();
        Assert.assertTrue(userRegistry.authenticate("non-existing user", "password"));
    }

}
