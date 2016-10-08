package net.scnetwork.bus.dao.orapool;

import net.scnetwork.bus.config.Config;
import net.scnetwork.bus.config.Global;
import net.scnetwork.bus.utils.LogBus;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Настройка пула подключений Oracle
 */
public class OraclePool {
    private static BasicDataSource dataSource;

    static {
        try {
            Global global = Config.getInstance();
            if (null != global) {
                OraclePoolConfig poolConfig = global.getOraclePool();

                if (null != poolConfig) {
                    dataSource = new BasicDataSource();
                    dataSource.setDriverClassName("org.oracle.Driver");
                    dataSource.setUrl(poolConfig.getJdbcUrl());
                    dataSource.setUsername(poolConfig.getUsername());
                    dataSource.setPassword(poolConfig.getPassword());
                    dataSource.setInitialSize(poolConfig.getInitialLimit());
                    dataSource.setMaxTotal(poolConfig.getMaxLimit());
                    dataSource.setDefaultQueryTimeout(poolConfig.getConnectionTimeout());
                }
            }
        } catch (NullPointerException e) {
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
        if(dataSource == null){
            throw new SQLException("OracleDataSource is null.");
        }
        return dataSource.getConnection();
    }

    /**
     * Доступ к переменной ods
     * @return datasource
     */
    public static BasicDataSource getOds(){
        return dataSource;
    }
}
