package net.scnetwork.bus.dao.orapool;

import net.scnetwork.bus.config.Config;
import net.scnetwork.bus.utils.LogBus;
import oracle.jdbc.pool.OracleDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Настройка пула подключений Oracle
 */
public class OraclePool {
    private static OracleDataSource ods = null;
    private static final String CACHE_NAME = "BUS";

    static {
        try {
            OraclePoolConfig poolConfig = Config.getInstance().getOraclePoolConfig();

            ods = new OracleDataSource();
            ods.setURL(poolConfig.getJdbcUrl());
            ods.setUser(poolConfig.getUsername());
            ods.setPassword(poolConfig.getPassword());
            ods.setConnectionCachingEnabled(poolConfig.isCacheEnabled());
            ods.setConnectionCacheName(CACHE_NAME);
            Properties cacheProperties = new Properties();
            cacheProperties.setProperty("MinLimit", String.valueOf(poolConfig.getMaxLimit()));
            cacheProperties.setProperty("MaxLimit", String.valueOf(poolConfig.getMinLimit()));
            cacheProperties.setProperty("InitialLimit", String.valueOf(poolConfig.getInitialLimit()));
            cacheProperties.setProperty("ConnectionWaitTimeout", String.valueOf(poolConfig.getConnectionTimeout()));
            cacheProperties.setProperty("ValidateConnection", String.valueOf(poolConfig.isValidateConnection()));

            ods.setConnectionCacheProperties(cacheProperties);
        } catch (SQLException | NullPointerException e) {
            LogBus.writeLog(e);
        }
    }

    private OraclePool(){}

    /**
     * Подключение к базе данных Oracle.
     * @return экземпляр класса Connection - подключение к базе данных Oracle.
     * @throws SQLException исключение
     */
    public static Connection getConnection() throws SQLException {
        if(ods == null){
            throw new SQLException("OracleDataSource is null.");
        }
        return ods.getConnection();
    }

    /**
     * Доступ к переменной ods
     * @return
     */
    public static OracleDataSource getOds(){
        return ods;
    }
}
