package ua.jug.chuckquotes.jmx;

public interface LoginWatchDogMBean {
    int getChuckLoginCount();

    void resetLoginCount();
}
