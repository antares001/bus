package net.scnetwork.bus.dao.mysqlpool;


import net.scnetwork.bus.config.Config;
import net.scnetwork.bus.config.Global;
import net.scnetwork.bus.utils.LogBus;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Инициализация пула подключений к Mysql
 */
public class MysqlPool {
    private static BasicDataSource dataSource;

    static {
        dataSource = new BasicDataSource();

        Global global = Config.getInstance();
        if (null != global){
            MysqlPoolConfig config = global.getMysqlPoolConfig();
            if (null != config){
                dataSource.setDriverClassName("com.mysql.Driver");
                dataSource.setUrl(config.getJdbcUrl());
                dataSource.setUsername(config.getUsername());
                dataSource.setPassword(config.getPassword());
                dataSource.setInitialSize(config.getInitialLimit());
                dataSource.setMaxTotal(config.getMaxLimit());
                dataSource.setDefaultQueryTimeout(config.getConnectionTimeout());
            }
        }
    }

    private MysqlPool(){}

    /**
     * Получение подключения
     * @return подключение
     * @throws SQLException исключение
     */
    public static Connection getConnection() throws SQLException {
        if (null == dataSource){
            throw new SQLException("MysqlPool not initialised");
        }
        return dataSource.getConnection();
    }

    /**
     * Закрытие подключения
     * @param connection подключение
     */
    public static void close(Connection connection){
        if (null != connection) {
            try {
                connection.close();
            } catch (SQLException e) {
                LogBus.writeLog(e);
            }
        }
    }
}
