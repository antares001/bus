package net.scnetwork.bus.dao.postgresql;

import net.scnetwork.bus.config.Config;
import net.scnetwork.bus.utils.LogBus;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Настройка для подключения к БД PostgreSQL
 */
public class Postgre {
    private static Connection connection = null;
    private static final String DRIVER = "org.postgresql.Driver";

    static {
        try{
            PostgreConfig config = Config.getInstance().getPostgreConfig();
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(config.getJdbcUrl(), config.getUsername(), config.getPassword());
        } catch (NullPointerException | ClassNotFoundException | SQLException e){
            LogBus.writeLog(e);
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
