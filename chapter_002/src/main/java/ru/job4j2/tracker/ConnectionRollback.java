package ru.job4j2.tracker;


import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Class ConnectionRollback used in integration tests.
 * @author v.ivanov
 * @version 1
 * @since 12.07.2020
 */
public class ConnectionRollback {
    /**
     * Create connection with autocommit=false mode and rollback call, when connection closed.
     * @param connection connection
     * @return Connection object
     * @throws SQLException possible exception
     */
    public static Connection create(Connection connection) throws SQLException {
        connection.setAutoCommit(false);
        return (Connection) Proxy.newProxyInstance(
                ConnectionRollback.class.getClassLoader(),
                new Class[] {Connection.class},
                (proxy, method, args) -> {
                    Object rsl = null;
                    if ("close".equals(method.getName())) {
                        connection.rollback();
                        connection.close();
                    } else {
                        rsl = method.invoke(connection, args);
                    }
                    return rsl;
                }
        );
    }
}
