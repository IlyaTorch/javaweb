package by.epamtc.jwd.db.dao.mysql;

//import org.apache.log4j.Logger;

import by.epamtc.jwd.db.Query;
import by.epamtc.jwd.db.dao.UserDAO;
import by.epamtc.jwd.db.dto.UserDTO;
import by.epamtc.jwd.db.dao.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Data access object for User.
 *
 * @author Ilya Torch
 *
 */

public class MySQLUserDAO extends UserDTO implements UserDAO {

    public static final Logger LOG = LogManager.getLogger(MySQLUserDAO.class);
    private static final long serialVersionUID = 5566685127381260993L;

    @Override
    public List<UserDTO> getAllUsers() {
        LOG.trace("Start tracing MySQLUserDAO#getAllUsers");
        LOG.error("TEST");
        LOG.error("TEST");
        LOG.error("TEST");

        List<UserDTO> users = new ArrayList<>();
        UserDTO user;

        try (Connection connection = ConnectionPool.getDerbyConnection()) {
            if (connection != null) {
                try (PreparedStatement statement = connection.prepareStatement(Query.SELECT_ALL_USERS)) {
                    connection.setAutoCommit(false);
                    statement.execute();
                    ResultSet resultSet = statement.getResultSet();
                    while (resultSet.next()) {
                        user = new UserDTO(
                            resultSet.getInt("user_id"),
                            resultSet.getString("email"),
                            resultSet.getString("first_name"),
                            resultSet.getString("last_name"),
                            resultSet.getFloat("avg_mark")
                        );
                        users.add(user);
                    }
                    resultSet.close();
                    connection.commit();
                } catch (SQLException ex) {
                    LOG.error(ex.getLocalizedMessage());
                    connection.rollback();
                }
            }
        } catch (SQLException ex) {
            LOG.error(ex.getLocalizedMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        return users;
    }
}
