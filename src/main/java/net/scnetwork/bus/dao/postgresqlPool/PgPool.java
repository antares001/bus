package net.scnetwork.bus.dao.postgresqlPool;


import net.scnetwork.bus.config.Config;
import net.scnetwork.bus.config.Global;
import net.scnetwork.bus.utils.LogBus;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Инициализация пула подключений к PostgreSQL
 */
public class PgPool {
    private static BasicDataSource dataSource;

    static {
        Global global = Config.getInstance();
        if (null != global) {
            PgPoolConfig config = global.getPgPoolConfig();

            if (null != config) {
                dataSource = new BasicDataSource();
                dataSource.setDriverClassName("org.postgresql.Driver");
                dataSource.setUrl(config.getJdbcUrl());
                dataSource.setUsername(config.getUsername());
                dataSource.setPassword(config.getPassword());
                dataSource.setInitialSize(config.getInitialLimit());
                dataSource.setMaxTotal(config.getMaxLimit());
            }
        }
    }

    private PgPool(){}

    /**
     * Получение подключения
     * @return подключение
     * @throws SQLException исключение
     */
    public static Connection getConnection() throws SQLException {
        if (null == dataSource){
            throw new SQLException("PostgresqlPool not initialised");
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
