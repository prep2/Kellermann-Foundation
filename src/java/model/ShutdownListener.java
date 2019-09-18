/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 *
 * @author romugabi
 */
public class ShutdownListener implements ServletContextListener {

    //private final Logger logger =  LoggerFactory.getLogger(ShutdownListener.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //logger.info("Context initialized.");
        System.out.println("Context initialized.");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        deregisterJdbcDrivers();
        // more clean-up tasks here
    }

    private void deregisterJdbcDrivers() {
        final Enumeration<Driver> drivers = DriverManager.getDrivers();
        while (drivers.hasMoreElements()) {
            final Driver driver = drivers.nextElement();
            if (this.getClass().getClassLoader().equals(getClass().getClassLoader())) {
                try {
                    DriverManager.deregisterDriver(driver);
                    //logger.info("Deregistered '{}' JDBC driver.", driver);
                    System.out.println("Deregistered '{}' JDBC driver." + driver);
                } catch (SQLException e) {
                    //logger.warn("Failed to deregister '{}' JDBC driver.", driver);
                    System.out.println("Failed to deregister '{}' JDBC driver." + driver);
                }
            }
        }
    }
}
