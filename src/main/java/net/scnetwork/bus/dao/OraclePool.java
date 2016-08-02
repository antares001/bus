package net.scnetwork.bus.dao;

import oracle.jdbc.pool.OracleDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class OraclePool {
    private static OracleDataSource ods = null;

    private static final String JDBC_URL = "";
    private static final String USERNAME = "";
    private static final String PASSWORD = "";
    private static final String CACHE_NAME = "BUS";
    private static final String MIN_LIMIT = "";
    private static final String MAX_LIMIT = "";
    private static final String INITIAL_LIMIT = "";
    private static final String CONNECTION_TIMEOUT = "";
    private static final String VALIDATE_CONNECTION = "";

    static {
        try {
            ods = new OracleDataSource();
            ods.setURL(JDBC_URL);
            ods.setUser(USERNAME);
            ods.setPassword(PASSWORD);
            ods.setConnectionCachingEnabled(true);
            ods.setConnectionCacheName(CACHE_NAME);
            Properties cacheProperties = new Properties();
            cacheProperties.setProperty("MinLimit", MIN_LIMIT);
            cacheProperties.setProperty("MaxLimit", MAX_LIMIT);
            cacheProperties.setProperty("InitialLimit", INITIAL_LIMIT);
            cacheProperties.setProperty("ConnectionWaitTimeout", CONNECTION_TIMEOUT);
            cacheProperties.setProperty("ValidateConnection", VALIDATE_CONNECTION);

            ods.setConnectionCacheProperties(cacheProperties);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private OraclePool(){}

    /**
     * Подключение к базе данных Oracle.
     * @return экземпляр класса Connection - подключение к базе данных Oracle.
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        return getConnection("env.unspecified");
    }

    /**
     * Подключение к базе данных Oracle.
     * @param env переменная окружения.
     * @return экземпляр класса Connection - подключение к базе данных Oracle.
     * @throws SQLException
     */
    public static Connection getConnection(String env) throws SQLException{
        if(ods == null){
            throw new SQLException("OracleDataSource is null.");
        }
        return ods.getConnection();
    }

    /**
     * Закрытие подключения.
     * @throws SQLException
     */
    public static void closePooledConnections() throws SQLException {
        if(ods != null)
            ods.close();
    }
}
