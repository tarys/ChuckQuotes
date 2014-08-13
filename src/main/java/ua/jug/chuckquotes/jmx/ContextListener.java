package ua.jug.chuckquotes.jmx;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        LoginWatchDog watchDog = new LoginWatchDog();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
