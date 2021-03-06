package ua.jug.chuckquotes.jmx;

import javax.management.MBeanServer;
import javax.management.MBeanServerFactory;
import javax.management.ObjectName;
import java.util.ArrayList;

public class LoginWatchDog implements LoginWatchDogMBean {

    private int loginCount;

    public LoginWatchDog() {
        final MBeanServer mBeanServer = getServer();
        try {
            ObjectName name = new ObjectName("ua.jug.chuckquotes.jmx:type=LoginWatchDog");
            mBeanServer.registerMBean(this, name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.loginCount = 0;
    }


    private MBeanServer getServer() {
        MBeanServer mbserver = null;

        ArrayList mbservers = MBeanServerFactory.findMBeanServer(null);

        if (mbservers.size() > 0) {
            mbserver = (MBeanServer) mbservers.get(0);
        }

        if (mbserver != null) {
            System.out.println("Found Tomcat's MBean server:" + mbserver);
        } else {
            mbserver = MBeanServerFactory.createMBeanServer();
        }

        return mbserver;
    }

    @Override
    public int getChuckLoginCount() {
        return loginCount;
    }

    @Override
    public void resetLoginCount() {
        this.loginCount = 0;
    }

    public void chuckLoggedIn() {
        this.loginCount++;
    }
}
