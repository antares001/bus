package net.scnetwork.bus.dao;

import net.scnetwork.bus.config.Config;
import net.scnetwork.bus.config.Global;
import net.scnetwork.bus.utils.LogBus;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Одиночные подключения
 */
public class SingleConnection {
    private static Connection connection = null;
    private static final String MYSQL = "com.mysql.Driver";
    private static final String POSTGRE = "com.postgresql.Driver";
    private static final String ORACLE = "com.oracle.Driver";


    /**
     * Определение
     */
    public static void setConnection() {
        Global global = Config.getInstance();
        if (null != global) {
            ConnectionSingle single = global.getConnection();
            if (null != single){
                String driver = single.getDriver();
                switch (driver){
                    case MYSQL:
                    case POSTGRE:
                    case ORACLE:
                        LogBus.info(driver);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    /**
     * Получение соединения
     * @return дескриптор соединения
     */
    public static Connection getConnection() {
        return connection;
    }

    /**
     * Закрытие соединения
     * @throws SQLException исключение закрытия
     */
    public void close() throws SQLException {
        connection.close();
    }
}
