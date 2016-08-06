package net.scnetwork.bus.dao;

import net.scnetwork.bus.config.OraclePoolConfig;
import oracle.jdbc.pool.OracleDataSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class OraclePool {
    @Autowired
    private static OraclePoolConfig poolConfig;

    private static OracleDataSource ods = null;

    private static final String CACHE_NAME = "BUS";

    static {
        try {
            ods = new OracleDataSource();
            ods.setURL(poolConfig.getJdbcUrl());
            ods.setUser(poolConfig.getUsername());
            ods.setPassword(poolConfig.getPassword());
            ods.setConnectionCachingEnabled(true);
            ods.setConnectionCacheName(CACHE_NAME);
            Properties cacheProperties = new Properties();
            cacheProperties.setProperty("MinLimit", String.valueOf(poolConfig.getMaxLimit()));
            cacheProperties.setProperty("MaxLimit", String.valueOf(poolConfig.getMinLimit()));
            cacheProperties.setProperty("InitialLimit", String.valueOf(poolConfig.getInitialLimit()));
            cacheProperties.setProperty("ConnectionWaitTimeout", String.valueOf(poolConfig.getConnectionTimeout()));
            cacheProperties.setProperty("ValidateConnection", String.valueOf(poolConfig.isValidateConnection()));

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
