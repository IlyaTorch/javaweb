package by.bsu.jwd.db.dao;


import by.bsu.jwd.db.dao.mysql.MySQLUserDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class ConnectionPool {

    public static final Logger LOG = LogManager.getLogger(MySQLUserDAO.class);

    private ConnectionPool(){
    }

    /**
     * Establish connection with Derby
     *
     * @return Connection with Derby
     */
    public static synchronized Connection getDerbyConnection() throws SQLException, IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class.forName("com.mysql.jdbc.Driver").getDeclaredConstructor().newInstance();
        return getConnection();
    }

    /**
     * Establish connection with MySQL
     *
     * @return Connection with MySQL
     */
    public static Connection getConnection() throws SQLException, IOException {
        LOG.trace("getConnection method call()");
        Properties props = new Properties();
        try(InputStream in = Files.newInputStream(Paths.get("/Users/ilyatorch/IdeaProjects/EPAM-Labs/javaweb/src/main/webapp/WEB-INF/database.properties"))){
            props.load(in);
        }
        String url = props.getProperty("url");
        String username = props.getProperty("username");
        String password = props.getProperty("password");

        return DriverManager.getConnection(url, username, password);
    }

}
